package model.po;

import model.ChessBoardModel;
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
    private boolean canAction;
    private int currentSamurai;
    private Thread timeUpdateThread;
    private ChessBoardModel chessBoardModel;

    public Player(GameModel model,int playerNum){
        this.canAction = false;
        this.playerNum = playerNum;
        this.gameModel = model;
        this.chessBoardModel = this.gameModel.getChessBoardModel();
        this.samuraiPOs = new SamuraiPO[3];
        samuraiPOs[0] = new SamuraiPO(1+3*playerNum,playerNum,0,this.gameModel.getLength(),this.chessBoardModel);
        samuraiPOs[1] = new SamuraiPO(2+3*playerNum,playerNum,1,this.gameModel.getLength(),this.chessBoardModel);
        samuraiPOs[2] = new SamuraiPO(3+3*playerNum,playerNum,2,this.gameModel.getLength(),this.chessBoardModel);
        this.timeUpdateThread = new Thread(new CountDown());
    }

    public void setEnableToAction() {
        this.canAction = true;
        this.currentSamurai = gameModel.getCurrentSamurai();
        samuraiPOs[currentSamurai].resetActionPoint();
        timeUpdateThread.start();
    }

    //当view做出动作的时候 调用这个方法
    public void actionPerformed(int actionNum, int direction){
        if(this.canAction){
            //actionNum:动作编号
            switch (actionNum){
                //要加上更新 view 的代码
                case 0:
                    if(this.samuraiPOs[currentSamurai].occupied(direction,this.chessBoardModel)){

                    }
                    break;
                case 1:
                    if(this.samuraiPOs[currentSamurai].move(direction,this.chessBoardModel)){

                    }
                    break;
                case 2:
                    if(this.samuraiPOs[currentSamurai].show(this.chessBoardModel)){

                    }
                    break;
                case 3:
                    if(this.samuraiPOs[currentSamurai].hide(this.chessBoardModel)){

                    }
                    break;
                default:
                    break;
            }
        }
    }

    //时间到了或者没点数的时候调用此方法
    public void actionDone(){
        this.timeUpdateThread.interrupt();
        this.gameModel.actionDone();
    }

    public SamuraiPO getSamuraiOfNum(int num){
        return samuraiPOs[num];
    }

    private class CountDown implements Runnable{
        public void run(){
            for(int i = 30; i > 0; i--){
                System.out.println("还有"+i+"秒");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean canAction(){
        return this.canAction;
    }

    public int getPlayerNum(){
        return this.playerNum;
    }

}
