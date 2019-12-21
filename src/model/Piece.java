package model;

import java.util.ArrayList;

public abstract class Piece {
    private Position position;
    private Character orientation;
    private Boolean is_destructible;

    Piece() {
        this(new Position(), 'N');
    }

    Piece(Position position) {
        this(position, 'N');
    }

    Piece(Position position, Character orientation) {
        this.position = position;
        this.orientation = orientation;
        is_destructible=false;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position.setPosition(x,y);
    }

    public Character getOrientation() {
        return orientation;
    }

    public void setOrientation(Character orientation) {
        this.orientation = orientation;
    }

    public Boolean getIs_destructible() {
        return is_destructible;
    }

    public void setIs_destructible(Boolean is_destructible) {
        this.is_destructible = is_destructible;
    }
}
