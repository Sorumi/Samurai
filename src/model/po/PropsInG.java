package model.po;

/**
 * Created by Kray on 16/5/14.
 */
public class PropsInG extends Props {

    private int type;
    private Position position;

    public PropsInG(Position position, int type){
        super();
        this.position = new Position(position.getX(), position.getY());
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public int getType() {
        return type;
    }
}
