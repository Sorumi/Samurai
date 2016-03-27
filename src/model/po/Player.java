package model.po;

import model.GameModel;
import model.state.GameState;

import java.util.Calendar;

/**
 * Created by Kray on 16/3/26.
 */
public class Player {
    private int playerNum;
    private SamuraiPO[] samuraiPOs;
    private int currSamurai;
    private int actionPoint;
    private int time;
    private int startTime;
    private boolean canAction;
    private Thread timeUpdateThread;

    public Player(int num){
        this.playerNum = num;
        this.samuraiPOs = new SamuraiPO[3];
        this.startTime = (int)Calendar.getInstance().getTimeInMillis();
        this.timeUpdateThread = new Thread(new CountDown());
    }

    public void setEnableToAction() {
        this.canAction = true;
        timeUpdateThread.start();
        this.currSamurai = GameModel.getCurrSamurai();
    }

    private class CountDown implements Runnable{
        public void run(){
            time = (int)(Calendar.getInstance().getTimeInMillis() - startTime)/1000;
            if(time >= 30.0){
                //告诉MODEL该结束了
            }
        }
    }
}
