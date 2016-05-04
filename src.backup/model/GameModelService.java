package model;

/**
 * Created by Kray on 16/4/17.
 */
public interface GameModelService {

    public boolean gameStart();

    public void actionDone();

    public void sendMsg(int actionNum, int direction);

}
