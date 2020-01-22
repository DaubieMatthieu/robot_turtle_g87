package model;

public class Wall_card extends Card {
    private String wall_type;

    Wall_card() {
        this("stone");
    }

    Wall_card(String wall_type) {
        switch (wall_type) {
            case "ice":
                this.wall_type="ice";
                break;
            case "stone":
                this.wall_type="stone";
                break;
        }
        this.setInstruction("place_wall");
    }

    public String getWall_type() {
        return wall_type;
    }

    public void setWall_type(String wall_type) {
        this.wall_type = wall_type;
    }
}

