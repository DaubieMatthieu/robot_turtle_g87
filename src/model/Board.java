package model;

import java.util.ArrayList;

public class Board {
    private ArrayList<Piece> pieces_list;

    Board(ArrayList<Piece> pieces_list) {
        this.pieces_list = pieces_list;
    }

    Board() {
        this.pieces_list =new ArrayList<>();
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

    public void piece_do(Piece piece, String instruction) {
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
                    default:
                        System.out.println("Erreur à Board.java:piece_do():case \"case turn_left\"");
                }
                if (position_exist(new_position)) {
                    if (position_is_free(new_position)) {
                        piece.setPosition(new_position);
                    } else {
                        System.out.println("test2");
                        System.out.println(getPiece(new_position));
                        if (getPiece(new_position) instanceof Jewel_piece) {
                            pieces_list.remove(getPiece(new_position));
                            piece.setPosition(new_position);
                            //TODO trouver un moyen d'avertir le controller que la partie est finie ou mettre cette fonction dans une autre classe
                        }
                        if (getPiece(new_position) instanceof Turtle_piece) {
                            back_to_start((Turtle_piece) piece);
                        }
                    }
                } else {
                    back_to_start((Turtle_piece) piece);
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
                    default:
                        System.out.println("Erreur à Board.java:piece_do():case \"case turn_left\"");
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
                    default:
                        System.out.println("Erreur à Board.java:piece_do():case \"case turn_left\"");
                }
                break;
            case "shoot_laser":
                //TODO tirer un laser, ne pas oublier le back_to_start quand laser sur tortue
                break;
            case "place_wall":
                pieces_list.add(piece);
                break;
            default:
                System.out.println("Instruction inconnue");
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

    public void back_to_start(Turtle_piece turtle) {
        //TODO ajouter fonction de retour à la case départ (quand obstacle ou laser), que faire si la case départ est déjà occupée ?
    }
}
