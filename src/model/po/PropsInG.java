package model.po;

/**
 * Created by Kray on 16/5/14.
 */
public class PropsInG extends Props {

    private int type;
    private Position position;
    private int number;

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

    public static int getRealType(int i){
        if(i == 741){
            return 13;
        }else if(i == 751){
            return 14;
        }else{
            return ((i - 700) / 10) * 3 + (i - 700) % 10;
        }
    }

    public void changeNumber(int number) {
        this.number = this.number + number;
    }
}
