package modele;

public class Turtle_piece extends Piece {
    private String color;

    Turtle_piece(String color) {
        this.color=color;
        this.setOrientation('S');
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}