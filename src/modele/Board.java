package modele;

import java.util.ArrayList;

public class Board {
    private ArrayList<Piece> piece_list;

    Board(ArrayList<Player> player_list, int nb_joueur) {
        ArrayList<Piece> piece_list=new ArrayList<>();
        if (nb_joueur==2) {
            Player blue_player=player_list.get(0);
            Turtle_piece blue_turtle=blue_player.getPiece();
            blue_turtle.setPosition(1,2);
            Player red_player=player_list.get(1);
            Turtle_piece red_turtle=red_player.getPiece();
            red_turtle.setPosition(1,6);

            Jewel_piece green_jewel = new Jewel_piece("green");
            green_jewel.setPosition(8,4);

            piece_list.add(blue_turtle);
            piece_list.add(red_turtle);
            piece_list.add(green_jewel);
        }

        if (nb_joueur==3) {
            Player blue_player = player_list.get(0);
            Turtle_piece blue_turtle = blue_player.getPiece();
            blue_turtle.setPosition(1, 1);
            Player red_player = player_list.get(1);
            Turtle_piece red_turtle = red_player.getPiece();
            red_turtle.setPosition(1, 4);
            Player green_player = player_list.get(2);
            Turtle_piece green_turtle = green_player.getPiece();
            green_turtle.setPosition(1, 7);

            Jewel_piece red_jewel = new Jewel_piece("red");
            red_jewel.setPosition(8, 1);
            Jewel_piece green_jewel = new Jewel_piece("green");
            green_jewel.setPosition(8, 4);
            Jewel_piece blue_jewel = new Jewel_piece("blue");
            blue_jewel.setPosition(8, 7);

            piece_list.add(blue_turtle);
            piece_list.add(red_turtle);
            piece_list.add(green_turtle);
            piece_list.add(red_jewel);
            piece_list.add(green_jewel);
            piece_list.add(blue_jewel);

            piece_list = add_walls(piece_list);
        }

        if (nb_joueur == 4) {
            Player blue_player = player_list.get(0);
            Turtle_piece blue_turtle = blue_player.getPiece();
            blue_turtle.setPosition(1, 1);
            Player red_player = player_list.get(1);
            Turtle_piece red_turtle = red_player.getPiece();
            red_turtle.setPosition(1, 3);
            Player green_player = player_list.get(2);
            Turtle_piece green_turtle = green_player.getPiece();
            green_turtle.setPosition(1, 6);
            Player yellow_player = player_list.get(3);
            Turtle_piece yellow_turtle = yellow_player.getPiece();
            yellow_turtle.setPosition(1, 8);

            Jewel_piece red_jewel = new Jewel_piece("red");
            red_jewel.setPosition(8, 2);
            Jewel_piece blue_jewel = new Jewel_piece("blue");
            blue_jewel.setPosition(8, 7);
            piece_list.add(blue_turtle);
            piece_list.add(red_turtle);
            piece_list.add(green_turtle);
            piece_list.add(yellow_turtle);
            piece_list.add(red_jewel);
            piece_list.add(blue_jewel);
        }
        this.piece_list = piece_list;
    }

    public ArrayList<Piece> add_walls(ArrayList<Piece> piece_list) {
        Wall_piece wall_piece1 = new Wall_piece();
        wall_piece1.setPosition(1, 8);
        piece_list.add(wall_piece1);
        Wall_piece wall_piece2 = new Wall_piece();
        wall_piece2.setPosition(2, 8);
        piece_list.add(wall_piece2);
        Wall_piece wall_piece3 = new Wall_piece();
        wall_piece3.setPosition(3, 8);
        piece_list.add(wall_piece3);
        Wall_piece wall_piece4 = new Wall_piece();
        wall_piece4.setPosition(4, 8);
        piece_list.add(wall_piece4);
        Wall_piece wall_piece5 = new Wall_piece();
        wall_piece5.setPosition(5, 8);
        piece_list.add(wall_piece5);
        Wall_piece wall_piece6 = new Wall_piece();
        wall_piece6.setPosition(6, 8);
        piece_list.add(wall_piece6);
        Wall_piece wall_piece7 = new Wall_piece();
        wall_piece7.setPosition(7, 8);
        piece_list.add(wall_piece7);
        Wall_piece wall_piece8 = new Wall_piece();
        wall_piece8.setPosition(8, 8);
        piece_list.add(wall_piece8);
        return piece_list;
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
}
