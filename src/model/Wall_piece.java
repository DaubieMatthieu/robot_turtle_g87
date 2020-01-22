package model;

public class Wall_piece extends Piece{
    private String wall_type;

    Wall_piece() {
        this("stone");
    }

    Wall_piece(String wall_type) {
        this(new Position(), wall_type);
    }

    Wall_piece(Position position, String wall_type) {
        switch (wall_type) {
            case "ice":
                this.wall_type="ice";
                this.setIs_destructible(true);
                break;
            case "stone":
                this.wall_type="stone";
                this.setIs_destructible(false);
                break;
        }
        this.setPosition(position);
    }

    public String getWall_type() {
        return wall_type;
    }

    public void setWall_type(String wall_type) {
        this.wall_type = wall_type;
    }
}
