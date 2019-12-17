package modele;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> player_list;
    private Board board;

    Game(int nb_joueur) {
        ArrayList<Player> player_list = new ArrayList<Player>() {{
            add(new Player("blue"));
            add(new Player("red"));
            if (nb_joueur > 2) {
                add(new Player("green"));
            }
            if (nb_joueur > 3) {
                add(new Player("yellow"));
            }
        }};
        this.player_list=player_list;
        this.board=new Board(player_list, nb_joueur);
    }

    Game(ArrayList<Player> player_list) {
        this.player_list=player_list;
        this.board=new Board();
    }

    Game(Board board) {
        this.player_list=new ArrayList<>();
        this.board=board;
    }

    Game() {
        this.player_list=new ArrayList<>();
        this.board=new Board();
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

}
