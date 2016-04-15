package model;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.NextOperation;
import controller.msgqueue.OperationQueue;
import main.Main;
import model.po.*;
import model.state.GameResultState;
import model.state.GameState;
//import view.MainFrame;

import java.util.ArrayList;
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
    private int AILevel;
    private SamuraiAI[] samuraiAI;

    public GameModel(int round, int length, Main mainFrame, int level){
        this.AILevel = level;
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
        switch (this.AILevel){
            case 0:
                break;
            case 1:
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(players[1].getSamuraiOfNum(4),1,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(players[1].getSamuraiOfNum(5),1,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(players[1].getSamuraiOfNum(6),1,this.chessBoardModel,1);
                break;
            default:
                break;
        }
    }

    public boolean gameStart(){
        ArrayList<ActualBlock> blocks = new ArrayList<>();
        for(int x = 0; x <= this.length; x++){
            for (int y = 0; y <= this.length; y++) {
                blocks.add(this.chessBoardModel.getActualBlock(x,y));
            }
        }
        super.updateChange(new UpdateMessage("vision", blocks));

        for (int i = 1; i <= 6; i++) {
            this.updateHome(i);
        }
        switch (this.AILevel){
            case 0:
                this.assignNext();
                break;
            case 1:
                this.assignNextWithAI();
                break;
            default:
                break;
        }
        this.timer = new Timer();
        timer.schedule(new countDownTask(),0,1000);
        return true;
    }

    public void updateHome(int num){
        switch (num){
            case 1:
                super.updateChange(new UpdateMessage("home",this.players[0].getSamuraiOfNum(1)));
                break;
            case 2:
                super.updateChange(new UpdateMessage("home",this.players[0].getSamuraiOfNum(2)));
                break;
            case 3:
                super.updateChange(new UpdateMessage("home",this.players[0].getSamuraiOfNum(3)));
                break;
            case 4:
                super.updateChange(new UpdateMessage("home",this.players[1].getSamuraiOfNum(4)));
                break;
            case 5:
                super.updateChange(new UpdateMessage("home",this.players[1].getSamuraiOfNum(5)));
                break;
            case 6:
                super.updateChange(new UpdateMessage("home",this.players[1].getSamuraiOfNum(6)));
                break;
            default:
                break;
        }
    }

    public void updatePosition(Position position){
        super.updateChange(new UpdateMessage("samuraiMove",position));
    }

    public void updateOccupy(int direction){
        super.updateChange(new UpdateMessage("samuraiOccupy",direction));
    }

    public void updateKilled(int i){
        super.updateChange(new UpdateMessage("samuraiKilled",i));
    }

    public void updateHide(boolean isHide){
        super.updateChange(new UpdateMessage("samuraiHide",isHide));
    }

    public void actionPerformed(int actionNum){
        //move 的时候要 see 一下新的视野
        ArrayList<ActualBlock> blocks;
        if(actionNum == 1 || actionNum == 0) {
            blocks = this.updateVision();
            this.updateVisible(blocks);
        }
        //要更新一下actionPoint
        super.updateChange(new UpdateMessage("actionPoint",this.players[this.playerSeq[this.currentPlayer - 1]].getActionPoint()));
    }

    public ArrayList<ActualBlock> updateVision(){
        ArrayList<ActualBlock> blocks = this.players[this.playerSeq[this.currentPlayer - 1]].showVision();
        super.updateChange(new UpdateMessage("vision", blocks));
        return blocks;
    }

    public void updateVisible(ArrayList<ActualBlock> blocks){
        super.updateChange(new UpdateMessage("visible", blocks));
    }

    //Assign next samurai
    public void assignNext(){
        //全部设为不可见
        for(int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                this.chessBoardModel.setActualBlockVisible(i,j,false);
            }
        }
        super.updateChange(new UpdateMessage("player",this.playerSeq[this.currentPlayer - 1]));
        super.updateChange(new UpdateMessage("samurai",this.samuraiSeq[this.currentSamurai - 1]));
        super.updateChange(new UpdateMessage("round",this.currentRound));
        super.updateChange(new UpdateMessage("pointsTotal",this.players[this.playerSeq[this.currentPlayer - 1]].getPointsTotal()));
//        this.updateVisible(this.updateVision());
        this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();
    }

    public void assignNextWithAI(){
        super.updateChange(new UpdateMessage("player",this.playerSeq[this.currentPlayer - 1]));
        super.updateChange(new UpdateMessage("samurai",this.samuraiSeq[this.currentSamurai - 1]));
        super.updateChange(new UpdateMessage("round",this.currentRound));
        super.updateChange(new UpdateMessage("pointsTotal",this.players[this.playerSeq[this.currentPlayer - 1]].getPointsTotal()));
//        this.updateVisible(this.updateVision());
        this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();
        if(this.currentPlayer == 1 || this.currentPlayer == 4 || this.currentPlayer == 5){

        }else{
            switch (this.currentPlayer){
                case 2:
                    for(ActionOperation operation : samuraiAI[0].calculate()){
                        OperationQueue.addOperation(operation);
                    }
                    break;
                case 3:
                    for(ActionOperation operation : samuraiAI[1].calculate()){
                        OperationQueue.addOperation(operation);
                    }
                    break;
                case 6:
                    for(ActionOperation operation : samuraiAI[2].calculate()){
                        OperationQueue.addOperation(operation);
                    }
                    break;
            }
            OperationQueue.addOperation(new NextOperation());
            try{
                Thread.sleep(2000);
            }catch (Exception E){
                E.printStackTrace();
            }
        }
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

            switch (this.AILevel){
                case 0:
                    this.assignNext();
                    break;
                case 1:
                    this.assignNextWithAI();
                    break;
                default:
                    break;
            }
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
