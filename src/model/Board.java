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
            if (piece.getPosition() == position) {return piece;}
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
                        if (position_is_free(new_position)) {piece.setPosition(new_position);}
                        else if (getPiece(new_position) instanceof Jewel_piece) {
                            //TODO ça ne fonctionne pas
                            pieces_list.remove(getPiece(new_position));
                            piece.setPosition(new_position);
                            //TODO trouver un moyen d'avertir le controller que la partie est finie ou mettre cette fonction dans une autre classe
                        }
                        //TODO implémenter les autres réactions de rencontre d'un obstacle (voir pdf)
                        break;
                    case 'W':
                        new_position.setPosition(position.getX()-1,position.getY());
                        if (position_is_free(new_position)) {piece.setPosition(new_position);}
                        break;
                    case 'S':
                        new_position.setPosition(position.getX(),position.getY()+1);
                        if (position_is_free(new_position)) {piece.setPosition(new_position);}
                        break;
                    case 'E':
                        new_position.setPosition(position.getX()+1,position.getY());
                        if (position_is_free(new_position)) {piece.setPosition(new_position);}
                        break;
                    default:
                        System.out.println("Erreur à Board.java:piece_do():case \"case turn_left\"");
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
                //tirer un laser
                break;
            case "place_wall":
                pieces_list.add(piece);
                break;
            default:
                System.out.println("Instruction inconnue");
        }
    }

    public boolean position_is_free(Position position) {
        if (!position_exist(position)) {return false;}
        for (Piece piece: pieces_list) {
            if (Position.samePosition(piece.getPosition(), position)) {return false;}
        }
        return true;
    }

    public boolean position_exist(Position position) {
        return position.getX() >= 0 && position.getX() <= 7 && position.getY() >= 0 && position.getY() <= 7;
    }
}
