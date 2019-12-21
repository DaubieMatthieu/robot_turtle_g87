package model;

import java.util.ArrayList;

public class Position {
    private ArrayList<Integer> position;

    public Position() {
        this(0, 0);
    }

    public Position(ArrayList<Integer> position) {
        this.position = position;
    }

    public Position(int x, int y) {
        this.position = new ArrayList<Integer>() {{
            add(x);
            add(y);
        }};
    }

    public ArrayList<Integer> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Integer> position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return this.position.get(0);
    }

    public int getY() {
        return this.position.get(1);
    }

    public void setX(int x) {
        this.position.set(0, x);
    }

    public void setY(int y) {
        this.position.set(1, y);
    }

    public static boolean samePosition(Position position1, Position position2) {
        return position1.getX() == position2.getX() && position1.getY() == position2.getY();
    }
}
