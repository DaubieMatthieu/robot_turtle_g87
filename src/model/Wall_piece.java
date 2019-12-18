package model;

public class Wall_piece extends Piece{
    private String wall_type;

    Wall_piece() {
        this.wall_type="stone";
        this.setIs_destructible(false);
    }

    Wall_piece(String wall_type) {
        switch (wall_type) {
            case "ice":
                this.wall_type="ice";
                this.setIs_destructible(true);
                break;
            case "stone":
                this.wall_type="stone";
                this.setIs_destructible(false);
                break;
            default:
                System.out.println("Erreur à Wall_piece.java:Wall_piece(String wall_type):Type de mur inconnu");
        }
    }

    public String getWall_type() {
        return wall_type;
    }

    public void setWall_type(String wall_type) {
        this.wall_type = wall_type;
    }
}
