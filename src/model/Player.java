package model;

import java.util.*;

public class Player {
    private String color;
    private Turtle_piece piece;
    private Queue<Color_card> card_deck;
    private ArrayList<Color_card> card_hand;
    private Queue<Color_card> program = new LinkedList<>();
    private ArrayList<Wall_card> wall_hand;

    Player(String color) {
        this.color=color;
        this.piece=new Turtle_piece(color);
        init();

    }

    public void execute_program(Board board) {
        int program_size = program.size();
        for (int i=0;i<program_size;i++) {
            play_color_card(program.poll(), board);
        }
    }

    public void complete_program() {

    }
    public void construct_wall() {

    }
    public void run_program() {

    }

    public void refill_hand() {
        int missing_card_nb = 5-card_hand.size();
        for (int i=0; i<missing_card_nb;i++) {
            draw_card();
        }
    }

    public void draw_card() {
        card_hand.add(card_deck.poll());
    }

    public void play_color_card(Color_card card, Board board) {
        board.piece_do(this.getPiece(),card.getInstruction());
    }

    public void play_wall_card(Wall_card card, Board board, Position position) {
        board.piece_do(new Wall_piece(position, card.getWall_type()),card.getInstruction());
    }

    public void init() {
        ArrayList<Color_card> color_card_list= new ArrayList<>();
        for (int i=0;i<18;i++) {
            color_card_list.add(new Color_card("blue"));
        }
        for (int i=0;i<8;i++) {
            color_card_list.add(new Color_card("yellow"));
            color_card_list.add(new Color_card("purple"));
        }
        for (int i=0;i<3;i++) {
            color_card_list.add(new Color_card("laser"));
        }
        Collections.shuffle(color_card_list);
        card_deck = new LinkedList<>(color_card_list);

        card_hand = new ArrayList<>();
        for (int i=0; i<5; i++) {draw_card();}

        wall_hand = new ArrayList<>();
        for (int i=0; i<3; i++) {wall_hand.add(new Wall_card("stone"));}
        for (int i=0; i<2; i++) {wall_hand.add(new Wall_card("ice"));}
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Turtle_piece getPiece() {
        return piece;
    }

    public void setPiece(Turtle_piece piece) {
        this.piece = piece;
    }

    public Queue<Color_card> getCard_deck() {
        return card_deck;
    }

    public void setCard_deck(Queue<Color_card> card_deck) {
        this.card_deck = card_deck;
    }

    public ArrayList<Color_card> getCard_hand() {
        return card_hand;
    }

    public void setCard_hand(ArrayList<Color_card> card_hand) {
        this.card_hand = card_hand;
    }

    public Queue<Color_card> getProgram() {
        return program;
    }

    public void setProgram(Queue<Color_card> program) {
        this.program = program;
    }

    public ArrayList<Wall_card> getWall_hand() {
        return wall_hand;
    }

    public void setWall_hand(ArrayList<Wall_card> wall_hand) {
        this.wall_hand = wall_hand;
    }

}
