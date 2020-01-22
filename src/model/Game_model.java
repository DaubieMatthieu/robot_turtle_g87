package model;

import java.util.ArrayList;

public class Game_model {
    private ArrayList<Player> player_list;
    private Board board;

    public Game_model(int player_nb) {
        ArrayList<Player> player_list = new ArrayList<>();
        ArrayList<Piece> piece_list=new ArrayList<>();

        Player blue_player=new Player("blue");
        player_list.add(blue_player);
        Turtle_piece blue_turtle = blue_player.getPiece();
        piece_list.add(blue_turtle);

        Player red_player=new Player("red");
        player_list.add(red_player);
        Turtle_piece red_turtle=red_player.getPiece();
        piece_list.add(red_turtle);

        Player green_player=new Player("green");
        Turtle_piece green_turtle=green_player.getPiece();

        Player pink_player=new Player("pink");
        Turtle_piece pink_turtle=pink_player.getPiece();

        Jewel_piece green_jewel = new Jewel_piece("green");
        Jewel_piece blue_jewel = new Jewel_piece("blue");
        Jewel_piece red_jewel = new Jewel_piece("red");

        if (player_nb > 2) {
            player_list.add(green_player);
            piece_list.add(green_turtle);
        }

        if (player_nb > 3) {
            player_list.add(pink_player);
            piece_list.add(pink_turtle);
        }


        switch (player_nb) {
            case 2:
                blue_turtle.setPosition(1,0);
                red_turtle.setPosition(5,0);

                green_jewel.setPosition(3,7);

                piece_list.add(green_jewel);
                piece_list = add_walls(piece_list);
                break;
            case 3:
                blue_turtle.setPosition(0, 0);
                red_turtle.setPosition(3, 0);
                green_turtle.setPosition(6, 0);

                red_jewel.setPosition(0, 7);
                green_jewel.setPosition(3, 7);
                blue_jewel.setPosition(6, 7);

                piece_list.add(red_jewel);
                piece_list.add(green_jewel);
                piece_list.add(blue_jewel);
                piece_list = add_walls(piece_list);
                break;

            case 4:
                blue_turtle.setPosition(0, 0);
                red_turtle.setPosition(2, 0);
                green_turtle.setPosition(5, 0);
                pink_turtle.setPosition(7, 0);

                red_jewel.setPosition(1, 7);
                blue_jewel.setPosition(6, 7);
                piece_list.add(red_jewel);
                piece_list.add(blue_jewel);
                break;
        }

        this.player_list=player_list;
        this.board=new Board(piece_list,player_nb);
    }

    public ArrayList<Player> getPlayer_list() {
        return player_list;
    }

    public void setPlayer_list(ArrayList<Player> player_list) {
        this.player_list = player_list;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void play_game() {}

    public void move_piece(Piece piece, Character direction) {}

    public ArrayList<Piece> add_walls(ArrayList<Piece> piece_list) {
        ArrayList<Piece> wall_pieces = new ArrayList<>();
        for (int i=0;i<8;i++) {
            wall_pieces.add(new Wall_piece());
            wall_pieces.get(i).setPosition(7,i);
        }
        piece_list.addAll(wall_pieces);
        return piece_list;
    }
}
