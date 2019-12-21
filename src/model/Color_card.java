package model;

public class Color_card extends Card {
    private String color;

    Color_card(String color) {
        switch (color) {
            case "blue":
                this.color="blue";
                this.setInstruction("move_forward");
                break;
            case "yellow":
                this.color="yellow";
                this.setInstruction("turn_left");
                break;
            case "purple":
                this.color="purple";
                this.setInstruction("turn_right");
                break;
            case "laser":
                this.color="laser";
                this.setInstruction("shoot_laser");
                break;
            default:
                System.out.println("erreur à Color_card: couleur inconnue");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

