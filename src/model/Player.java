package model;

import java.util.ArrayList;
import java.util.Queue;

public class Player {
    private String color;
    private Turtle_piece piece;
    private ArrayList<Color_card> card_deck;
    private ArrayList<Color_card> card_hand;
    private Queue<Color_card> program;
    private ArrayList<Wall_card> wall_hand;

    Player(String color) {
        this.color=color;
        this.piece=new Turtle_piece(color);
    }

    public void play(Board board) {

    }
    public void complete_program() {

    }
    public void construct_wall() {

    }
    public void run_program() {

    }
    public void draw_card() {

    }
    public void discard_card() {

    }
    public void use_card(Card card, Board board) {
        board.piece_do(this.getPiece(),card.getInstruction());
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

    public ArrayList<Color_card> getCard_deck() {
        return card_deck;
    }

    public void setCard_deck(ArrayList<Color_card> card_deck) {
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
