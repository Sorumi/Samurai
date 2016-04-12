package model;

import model.po.Player;
import model.po.Position;
import model.po.SamuraiPO;
import model.state.GameResultState;
import model.state.GameState;
import view.MainFrame;

import java.util.Timer;
import java.util.TimerTask;

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
    private int timeTotal;
    private Timer timer;
    private int currentTime;

    public GameModel(int round, int length, MainFrame mainFrame){
        this.length = length;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.chessBoardModel.addObserver(mainFrame.gamePanel.chessBoard);
        this.gameState = GameState.RUN;
        this.timeTotal = 30;
        this.currentTime = this.timeTotal;
        this.currentRound = 1;
        this.totalRound = round;
        this.currentSamurai = 1;//1,2,3,4,5,6
        this.samuraiSeq = new int[]{1,4,5,2,3,6};
        this.currentPlayer = 1;//1,2,3,4,5,6
        this.playerSeq = new int[]{0,1,1,0,0,1};
        this.players = new Player[2];
        players[0] = new Player(this,0);
        players[1] = new Player(this,1);
    }

    public boolean gameStart(){
//        SamuraiPO[] samuraiPOs = new SamuraiPO[6];
//        super.updateChange(new UpdateMessage("home",this.players[0].getSamuraiOfNum(1)));
//        super.updateChange(new UpdateMessage("home",this.players[0].getSamuraiOfNum(2)));
//        super.updateChange(new UpdateMessage("home",this.players[0].getSamuraiOfNum(3)));
//        super.updateChange(new UpdateMessage("home",this.players[1].getSamuraiOfNum(4)));
//        super.updateChange(new UpdateMessage("home",this.players[1].getSamuraiOfNum(5)));
//        super.updateChange(new UpdateMessage("home",this.players[1].getSamuraiOfNum(6)));


        this.assignNext();

        this.timer = new Timer();
        timer.schedule(new countDownTask(),0,1000);

        return true;
    }

    public void actionPerformed(){;
        //要 see 一下新的视野
        super.updateChange(new UpdateMessage("vision",this.players[this.playerSeq[this.currentPlayer - 1]].showVision()));
        //要更新一下actionPoint
        super.updateChange(new UpdateMessage("actionPoint",this.players[this.playerSeq[this.currentPlayer - 1]].getActionPoint()));
    }

    //Assign next samurai
    public void assignNext(){

        super.updateChange(new UpdateMessage("player",this.playerSeq[this.currentPlayer - 1]));
        super.updateChange(new UpdateMessage("samurai",this.samuraiSeq[this.currentSamurai - 1]));
        super.updateChange(new UpdateMessage("round",this.currentRound));
        super.updateChange(new UpdateMessage("pointsTotal",this.players[this.playerSeq[this.currentPlayer - 1]].getPointsTotal()));
        super.updateChange(new UpdateMessage("vision",this.players[this.playerSeq[this.currentPlayer - 1]].showVision()));

        this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();

    }

    //一个 samurai 一套动作完成时调用此方法
    public void actionDone(){

        this.currentTime = this.timeTotal;

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
        this.timer.cancel();
        super.updateChange(new UpdateMessage("over",this.chessBoardModel));

        return true;
    }

    //负责给 player 发消息
    public void sendMsg(int actionNum, int direction){
        this.players[this.playerSeq[this.currentPlayer - 1]].actionPerformed(actionNum, direction);
    }

    public int getCurrentSamurai(){
        return this.samuraiSeq[this.currentSamurai - 1];
    }

    public int getLength(){
        return this.length;
    }

    public SamuraiPO getSamuraiOfNum(int n){
        switch (n){
            case 1:
                return players[0].getSamuraiOfNum(1);
            case 2:
                return players[0].getSamuraiOfNum(2);
            case 3:
                return players[0].getSamuraiOfNum(3);
            case 4:
                return players[1].getSamuraiOfNum(4);
            case 5:
                return players[1].getSamuraiOfNum(5);
            case 6:
                return players[1].getSamuraiOfNum(6);
        }
        return null;
    }

    public ChessBoardModel getChessBoardModel(){
        return this.chessBoardModel;
    }

    public class countDownTask extends java.util.TimerTask{
        public void run() {
            if(currentTime > 0){
                updateChange(new UpdateMessage("time",currentTime));
                currentTime--;
            }else{
                actionDone();
            }
        }
    }
}
