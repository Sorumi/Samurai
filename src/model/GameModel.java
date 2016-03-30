package model;

import model.po.Player;
import model.state.GameResultState;
import model.state.GameState;

import java.util.Timer;

public class GameModel extends BaseModel {
    private ChessBoardModel chessBoardModel;
    private GameState gameState;
    private GameResultState gameResultState;
    private int[] samuraiSeq;
    private int currentSamurai;
    private Player[] players;
    private int[] playerSeq;
    private int currentPlayer;
    private int currentRound;
    private int totalRound;
    private int length;
    private Timer timer;

    public GameModel(int round,int length){
        this.length = length;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.gameState = GameState.RUN;
        this.timer = new Timer();
        this.currentRound = 1;
        this.totalRound = round;
        this.currentSamurai = 1;//1,2,3,4,5,6
        this.samuraiSeq = new int[]{1,2,3,4,5,6};
        this.currentPlayer = 1;//1,2,3,4,5,6
        this.playerSeq = new int[]{0,1,1,0,0,1};
        this.players = new Player[2];
        players[0] = new Player(this,0);
        players[1] = new Player(this,1);
    }

    public boolean gameStart(){
        System.out.println("Game Start.");
        this.assignNext();
        return true;
    }

    //Assign next samurai
    public void assignNext(){
        System.out.println("This Player:" + this.playerSeq[this.currentPlayer - 1]);
        System.out.println("This Samurai:" + this.samuraiSeq[this.currentSamurai - 1]);
        System.out.println("This Round:" + this.currentRound);
        this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();
        this.timer.schedule(new CountDownTask(),0);
        //此处加上告诉 view 应该是哪个 samurai 行动的代码
    }

    //一个 samurai 一套动作完成时调用此方法
    public void actionDone(){
        System.out.println("Action Done");
        if(this.currentRound < this.totalRound) {
            this.currentRound++;
            if((this.currentSamurai++) % 6 == 0){
                this.currentSamurai = 1;
            }
            if((this.currentPlayer++) % 6 == 0){
                this.currentPlayer = 1;
            }
            this.assignNext();
        }else{
            this.gameOver();
        }
    }

    public boolean gameOver(){
        this.gameState = GameState.OVER;
        System.out.println("Game Over.");
        System.exit(0);
        return true;
    }

    //暂时扮演Controller发消息的角色
    public void sendMsg(int actionNum, int direction){
        this.players[this.playerSeq[this.currentPlayer - 1]].actionPerformed(actionNum, direction);
    }

    public int getCurrentSamurai(){
        return this.samuraiSeq[this.currentSamurai - 1];
    }

    public int getLength(){
        return this.length;
    }

    public ChessBoardModel getChessBoardModel(){
        return this.chessBoardModel;
    }

    public class CountDownTask extends java.util.TimerTask{
        public void run(){
            for(int i = 30; i > 0; i--) {
                try {
                    System.out.println("还有"+i+"秒");
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            actionDone();
        }
    }
}
