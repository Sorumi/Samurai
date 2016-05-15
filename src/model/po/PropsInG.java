package model.po;

/**
 * Created by Kray on 16/5/14.
 */
public class PropsInG extends Props {

    private int type;
    private Position position;
    private int number;
    private int existRound;

    public PropsInG(Position position, int type){
        super();
        this.position = new Position(position.getX(), position.getY());
        this.type = type;
        this.existRound = 1;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getType() {
        return this.type;
    }

    public int getExistRound() {
        return this.existRound;
    }

    public void minusExistRound() {
        this.existRound--;
    }

    public static int get14Type(int i){
        if(i == 741){
            return 13;
        }else if(i == 751){
            return 14;
        }else{
            return ((i - 700) / 10) * 3 + (i - 700) % 10;
        }
    }

    public static int get7Type(int i){
        switch (i){
            case 1:
                return 701;
            case 2:
                return 702;
            case 3:
                return 703;
            case 4:
                return 711;
            case 5:
                return 712;
            case 6:
                return 713;
            case 7:
                return 721;
            case 8:
                return 722;
            case 9:
                return 723;
            case 10:
                return 731;
            case 11:
                return 732;
            case 12:
                return 733;
            case 13:
                return 741;
            case 14:
                return 751;
            default:
                return 999;
        }
    }

    public void changeNumber(int number) {
        this.number = this.number + number;
    }
}
