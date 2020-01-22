package model;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class Board {
    private ArrayList<Piece> pieces_list;
    private int player_nb;

    Board(ArrayList<Piece> pieces_list, int player_nb) {
        this.pieces_list=pieces_list;
        this.player_nb=player_nb;
    }

    public ArrayList<Piece> getPieces_list() {
        return pieces_list;
    }

    public void setPieces_list(ArrayList<Piece> pieces_list) {
        this.pieces_list = pieces_list;
    }

    public void display_board() {}

    public Piece getPiece(Position position) {
        for (Piece piece: pieces_list) {
            if (Position.samePosition(piece.getPosition(),position)) {return piece;}
        }
        return null;
    }

    public boolean piece_do(Piece piece, String instruction) {
        Position position = piece.getPosition();
        Character orientation = piece.getOrientation();
        switch (instruction) {
            case "move_forward":
                Position new_position = new Position();
                switch (orientation) {
                    case 'N':
                        new_position.setPosition(position.getX(),position.getY()-1);
                        break;
                    case 'W':
                        new_position.setPosition(position.getX()-1,position.getY());
                        break;
                    case 'S':
                        new_position.setPosition(position.getX(),position.getY()+1);
                        break;
                    case 'E':
                        new_position.setPosition(position.getX()+1,position.getY());
                        break;
                }
                if (position_exist(new_position)) {
                    if (position_is_free(new_position)) {
                        piece.setPosition(new_position);
                    } else {
                        if (getPiece(new_position) instanceof Jewel_piece) {
                            pieces_list.remove(getPiece(new_position));
                            piece.setPosition(new_position);
                            return true;
                        }
                        if (getPiece(new_position) instanceof Turtle_piece) {
                            backToStart((Turtle_piece) piece);
                        }
                    }
                } else {
                    backToStart((Turtle_piece) piece);
                }

                break;
            case "turn_left":
                switch (orientation) {
                    case 'N':
                        piece.setOrientation('W');
                        break;
                    case 'W':
                        piece.setOrientation('S');
                        break;
                    case 'S':
                        piece.setOrientation('E');
                        break;
                    case 'E':
                        piece.setOrientation('N');
                        break;
                }
                break;
            case "turn_right":
                switch (orientation) {
                    case 'N':
                        piece.setOrientation('E');
                        break;
                    case 'W':
                        piece.setOrientation('N');
                        break;
                    case 'S':
                        piece.setOrientation('W');
                        break;
                    case 'E':
                        piece.setOrientation('S');
                        break;
                }
                break;
            case "shoot_laser":
                Position laserPosition=new Position(position);
                laserMoveForward(orientation, laserPosition);//le laser part de devant la tortue
                while (Position.inRange(laserPosition)) {
                    Piece pieceReached=getPiece(laserPosition);
                    if (pieceReached!=null) {
                        if (pieceReached instanceof Wall_piece) {
                            if (pieceReached.getIs_destructible()) {
                                pieces_list.remove(pieceReached);//si le mur est destructible on le retire
                            }//sinon on le laisse
                        } else if (pieceReached instanceof Jewel_piece) {
                            switch (orientation) {//on tourne le joyau dans le sens opposé au laser
                                case 'N':
                                    pieceReached.setOrientation('S');
                                    break;
                                case 'W':
                                    pieceReached.setOrientation('E');
                                    break;
                                case 'S':
                                    pieceReached.setOrientation('N');
                                    break;
                                case 'E':
                                    pieceReached.setOrientation('W');
                                    break;
                            }
                            piece_do(pieceReached, "shoot_laser");//on renvoie le laser
                            pieceReached.setOrientation('N');//on remet le joyau dans son orientation par défaut
                        } else if (pieceReached instanceof Turtle_piece){
                            backToStart((Turtle_piece)pieceReached);//on renvoie la tortue à sa position d'origine
                        }
                        break;//on arrete le laser quand il a rencontré un obstacle
                    } else {
                        laserMoveForward(orientation, laserPosition);//le laser avance
                    }
                }
                break;
            case "place_wall":
                //si le mur à placer est en pierre on vérifie qu'il n'entoure pas un joueur/joyau
                if (((Wall_piece)piece).getWall_type().equals("stone")) {
                    int[][] tab;
                    ArrayList<Turtle_piece> turtle_pieces=new ArrayList<>();
                    ArrayList<Jewel_piece> jewel_pieces=new ArrayList<>();
                    for (Piece board_piece:pieces_list) {
                        if (board_piece instanceof Turtle_piece) {turtle_pieces.add((Turtle_piece) board_piece);}
                        if (board_piece instanceof Jewel_piece) {jewel_pieces.add((Jewel_piece) board_piece);}
                    }
                    for (Jewel_piece jewel_piece:jewel_pieces) {
                        for (Turtle_piece turtle_piece:turtle_pieces) {
                            //pour les valeurs de case données voir FindPath.java
                            tab = FindPath.change_format(pieces_list);//on transforme la pieces_list en tableau avec des int représentant les types de pièces
                            tab[position.getX()][position.getY()]=3;//on ajoute le mur que l'on veut poser
                            tab[turtle_piece.getPosition().getX()][turtle_piece.getPosition().getY()]=1;//on définit la source
                            tab[jewel_piece.getPosition().getX()][jewel_piece.getPosition().getY()]=2;//on définit la destination
                            if (!FindPath.isPath(tab)) {return false;}//le mur bloque le jeu donc on ne le place pas
                        }
                    }
                }
                //si on sort de la boucle c'est que le mur ne bloque pas le jeu
                pieces_list.add(piece);
                return true;//le mur ne bloque pas
        }
        return false;
    }

    private void laserMoveForward(Character orientation, Position laserPosition) {
        switch (orientation) {
            case 'N':
                laserPosition.setY(laserPosition.getY()-1);
                break;
            case 'W':
                laserPosition.setX(laserPosition.getX()-1);
                break;
            case 'S':
                laserPosition.setY(laserPosition.getY()+1);
                break;
            case 'E':
                laserPosition.setX(laserPosition.getX()+1);
                break;
        }
    }

    public boolean position_is_free(Position position) {
        for (Piece piece: pieces_list) {
            if (Position.samePosition(piece.getPosition(), position)) {return false;}
        }
        return true;
    }

    public boolean position_exist(Position position) {
        return position.getX() >= 0 && position.getX() <= 7 && position.getY() >= 0 && position.getY() <= 7;
    }

    public void backToStart(Turtle_piece turtle_piece) {
        turtle_piece.setOrientation('S');
        Position newPosition=new Position();
        switch (player_nb) {
            case 2:
                switch (turtle_piece.getColor()) {
                    case "blue":
                        newPosition.setPosition(1,0);
                        break;
                    case "red":
                        newPosition.setPosition(5,0);
                        break;
                }
                break;
            case 3:
                switch (turtle_piece.getColor()) {
                    case "blue":
                        newPosition.setPosition(0, 0);
                        break;
                    case "red":
                        newPosition.setPosition(3, 0);
                        break;
                    case "green":
                        newPosition.setPosition(6, 0);
                        break;
                }
                break;
            case 4:
                switch (turtle_piece.getColor()) {
                    case "blue":
                        newPosition.setPosition(0, 0);
                        break;
                    case "red":
                        newPosition.setPosition(2, 0);
                        break;
                    case "green":
                        newPosition.setPosition(5, 0);
                        break;
                    case "pink":
                        newPosition.setPosition(7, 0);
                        break;
                }
                break;
        }
        if (!Position.samePosition(newPosition,turtle_piece.getPosition())) {//si il n'est pas déjà sur sa position de départ
            while (!position_is_free(newPosition)) { //on vérifie que la position de départ n'est pas occupée
                newPosition.setY(newPosition.getY()+1);
            }
            turtle_piece.setPosition(newPosition);
        }
    }
}
