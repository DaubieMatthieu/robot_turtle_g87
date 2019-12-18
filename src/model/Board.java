package model;

import java.util.ArrayList;

public class Board {
    private ArrayList<Piece> piece_list;

    Board(ArrayList<Piece> piece_list) {
        this.piece_list = piece_list;
    }

    Board() {
        this.piece_list=new ArrayList<>();
    }

    public ArrayList<Piece> getPiece_list() {
        return piece_list;
    }

    public void setPiece_list(ArrayList<Piece> piece_list) {
        this.piece_list = piece_list;
    }

    public void display_board() {}

    public void piece_do(Piece piece, String instruction) {
        Character orientation = piece.getOrientation();
        switch (instruction) {
            case "move_forward":
                //faire avancer la pièce si possible
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
            case "place_piece":
                //le joueur choisi une case et on y place la pièce
                break;
            default:
                System.out.println("Instruction inconnue");
        }
    }
}
