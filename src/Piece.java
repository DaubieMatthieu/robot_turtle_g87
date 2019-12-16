import java.util.ArrayList;

public class Piece {
    private ArrayList<Integer> position;
    private Character orientation;
    private Boolean destructible;

    public ArrayList<Integer> get_position(){
        return this.position;
    }

    public Character get_orientation(){
        return this.orientation;
    }

    public Boolean is_destructible(){
        return this.destructible;
    }
}
