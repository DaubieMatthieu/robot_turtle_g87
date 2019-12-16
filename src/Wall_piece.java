public class Wall_piece extends Piece{
    private String wall_type;

    Wall_piece() {
        this.wall_type="stone";
        this.setIs_destructible(true);
    }

    Wall_piece(String wall_type) {
        this.wall_type=wall_type;
        if (wall_type.equals("stone")) {
            this.setIs_destructible(true);
        }
    }

    public String getWall_type() {
        return wall_type;
    }

    public void setWall_type(String wall_type) {
        this.wall_type = wall_type;
    }
}
