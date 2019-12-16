import java.util.ArrayList;

public class Piece {
    private ArrayList<Integer> position;
    private Character orientation;
    private Boolean is_destructible;

    public ArrayList<Integer> getPosition(){
        return this.position;
    }

    public Character getOrientation(){
        return this.orientation;
    }

    public Boolean getIs_destructible(){
        return this.is_destructible;
    }
}
