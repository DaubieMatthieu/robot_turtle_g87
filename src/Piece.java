import java.util.ArrayList;

public class Piece {
    private ArrayList<Integer> position;
    private Character orientation;
    private Boolean is_destructible;

    Piece() {
        this.position =
            new ArrayList<Integer>() {{
                add(0);
                add(0);
            }};
        this.orientation = 'N';
        is_destructible=false;
    }

    Piece(ArrayList<Integer> position, Character orientation) {
        this.position = position;
        this.orientation = orientation;
        is_destructible=false;
    }

    public ArrayList<Integer> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Integer> position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position =
                new ArrayList<Integer>() {{
                    add(x);
                    add(y);
                }};
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
