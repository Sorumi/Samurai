package model.po;

import model.GameModel;
import model.state.GameState;

import java.util.Calendar;
import java.util.Timer;

/**
 * Created by Kray on 16/3/26.
 */
public class Player {
    private GameModel gameModel;
    private int playerNum;
    private SamuraiPO[] samuraiPOs;
    private int currentSamurai;
    private int actionPoint;
    private boolean canAction;

    private Thread timeUpdateThread;

    public Player(GameModel model,int playerNum){
        this.playerNum = playerNum;
        this.gameModel = model;
        this.samuraiPOs = new SamuraiPO[3];
        samuraiPOs[0] = new SamuraiPO(1+3*playerNum,playerNum,0,this.gameModel.getLength(),this.gameModel.getChessBoardModel());
        samuraiPOs[1] = new SamuraiPO(2+3*playerNum,playerNum,1,this.gameModel.getLength(),this.gameModel.getChessBoardModel());
        samuraiPOs[2] = new SamuraiPO(3+3*playerNum,playerNum,2,this.gameModel.getLength(),this.gameModel.getChessBoardModel());
        this.timeUpdateThread = new Thread(new CountDown());
    }

    public void setEnableToAction() {
        this.canAction = true;
        this.currentSamurai = gameModel.getCurrentSamurai();
        timeUpdateThread.start();
    }

    //当做出动作的时候 调用这个方法
    public void actionPerformed(){
        if(this.canAction){
            //Do sth.
        }
    }

    public SamuraiPO getSamuraiOfNum(int num){
        return samuraiPOs[num];
    }

    private class CountDown implements Runnable{
        public void run() {
            //Countdown 30 seconds.
        }
    }


}
