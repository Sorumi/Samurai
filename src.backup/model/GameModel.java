package model;

import controller.msgqueue.*;
import main.Main;
import model.po.*;
import model.state.GameResultState;
import model.state.GameState;
import network.TransformObject;
import network.client.ClientService;
//import view.MainFrame;

import java.util.*;

public class GameModel extends BaseModel implements Observer {
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
    private int level;
    private SamuraiAI[] samuraiAI;
    private int coldRoundNum;

    protected ClientService net;

    private static boolean isServer = false;
    private static boolean isClient = false;


    //level:
    //1~9   : Regular Mode, AI Level from 0 ~ 9
    //11~20 : Adventure Mode, Level from 1 ~ 7
    //99    : Online Mode, No AI.
    public GameModel(int round, int length, Main mainFrame, int level){
        this.level = level;
        this.length = length;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.chessBoardModel.addObserver(mainFrame.gamePanel.chessBoard);
        this.gameState = GameState.RUN;
        this.timeTotal = 30;
        this.coldRoundNum = 1;
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
        switch (this.level){
            case 99:
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(players[1].getSamuraiOfNum(4),1,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(players[1].getSamuraiOfNum(5),1,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(players[1].getSamuraiOfNum(6),1,this.chessBoardModel,1);
                break;
            default:
                break;
        }
        isServer = false;
        isClient = false;
    }

    public GameModel(ClientService client) {
        this.net = client;
        isClient = true;
    }

    public boolean gameStart(){
        System.out.println("I'm " + isServer() + " a server.");
        System.out.println("I'm " + isClient() + " a client.");
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

        switch (this.level){
            case 0:
                this.assignNext();
                break;
            case 99:
                this.assignNextWithAI();
                break;
            default:
                break;
        }

        if(!isServer && !isClient){
//        if(!isServer){
            this.timer = new Timer();
            this.timer.schedule(new countDownTask(), 0, 1000);
        }

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
        //position和direction能都返回吗，，
    }

    public void updateOccupy(int direction){
        super.updateChange(new UpdateMessage("samuraiOccupy",direction));
    }

    public void updateKilled(int i){
        switch (i){
            case 1:
                this.players[0].getSamuraiOfNum(1).setColdRound(this.coldRoundNum);
                break;
            case 2:
                this.players[0].getSamuraiOfNum(2).setColdRound(this.coldRoundNum);
                break;
            case 3:
                this.players[0].getSamuraiOfNum(3).setColdRound(this.coldRoundNum);
                break;
            case 4:
                this.players[1].getSamuraiOfNum(4).setColdRound(this.coldRoundNum);
                break;
            case 5:
                this.players[1].getSamuraiOfNum(5).setColdRound(this.coldRoundNum);
                break;
            case 6:
                this.players[1].getSamuraiOfNum(6).setColdRound(this.coldRoundNum);
                break;
        }
        super.updateChange(new UpdateMessage("samuraiKilled",i));
    }

    public void attackSamurai(int samurai, int attackPoint, int armorPuncture){
        double attackPointDouble=attackPoint;
        switch (samurai){
            case 1:
                if(!this.players[0].getSamuraiOfNum(1).checkMiss()){
                    double ta = this.players[0].getSamuraiOfNum(1).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (ta / (ta + 100));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[0].getSamuraiOfNum(1).injure((int)attackPointDouble);
                }
                break;
            case 2:
                if(!this.players[0].getSamuraiOfNum(2).checkMiss()){
                    double ta = this.players[0].getSamuraiOfNum(2).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (ta / (ta + 100));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[0].getSamuraiOfNum(2).injure((int)attackPointDouble);
                }
                break;
            case 3:
                if(!this.players[0].getSamuraiOfNum(3).checkMiss()){
                    double ta = this.players[0].getSamuraiOfNum(3).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (ta / (ta + 100));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[0].getSamuraiOfNum(3).injure((int)attackPointDouble);
                }
                break;
            case 4:
                if(!this.players[1].getSamuraiOfNum(4).checkMiss()){
                    double ta = this.players[1].getSamuraiOfNum(4).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (ta / (ta + 100));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[1].getSamuraiOfNum(4).injure((int)attackPointDouble);
                }
                break;
            case 5:
                if(!this.players[1].getSamuraiOfNum(5).checkMiss()){
                    double ta = this.players[1].getSamuraiOfNum(5).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (ta / (ta + 100));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[1].getSamuraiOfNum(5).injure((int)attackPointDouble);
                }
                break;
            case 6:
                if(!this.players[1].getSamuraiOfNum(6).checkMiss()){
                    double ta = this.players[1].getSamuraiOfNum(6).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (ta / (ta + 100));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[1].getSamuraiOfNum(6).injure((int)attackPointDouble);
                }
                break;
        }
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

    //单机模式也是只能看见自己这方的 block
    public ArrayList<ActualBlock> updateVision(){
        ArrayList<ActualBlock> blocks;
        if(GameModel.isClient() && !GameModel.isServer()){
            blocks = this.players[1].showVision();
            super.updateChange(new UpdateMessage("vision", blocks));
            return blocks;
        }else{
            blocks = this.players[0].showVision();
            super.updateChange(new UpdateMessage("vision", blocks));
            return blocks;
        }
    }

    public void updateVisible(ArrayList<ActualBlock> blocks){
        super.updateChange(new UpdateMessage("visible", blocks));
    }

    public void updateOccupiedBlocks(){
        super.updateChange(new UpdateMessage("occupiedBlocks",this.chessBoardModel.getStatesOfAllBlocks()));
    }

    //Assign next samurai
    public void assignNext(){
        //全部设为不可见
//        for(int i = 0; i < length; i++){
//            for (int j = 0; j < length; j++){
//                this.chessBoardModel.setActualBlockVisible(i,j,false);
//            }
//        }

        if(this.playerSeq[this.currentPlayer - 1] == 0){
            Operation.setServer(true);
        }else{
            Operation.setServer(false);
        }

        super.updateChange(new UpdateMessage("player",this.playerSeq[this.currentPlayer - 1]));
        super.updateChange(new UpdateMessage("samurai",this.samuraiSeq[this.currentSamurai - 1]));
        super.updateChange(new UpdateMessage("round",this.currentRound));
        super.updateChange(new UpdateMessage("pointsTotal",this.players[this.playerSeq[this.currentPlayer - 1]].getPointsTotal()));
        this.updateVisible(this.updateVision());
        if(this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() == 0){
            this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();
        }else{
            this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).setColdRound(this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() - 1);
            this.actionDone();
        }
    }

    public void assignNextWithAI() {
        super.updateChange(new UpdateMessage("player", this.playerSeq[this.currentPlayer - 1]));
        super.updateChange(new UpdateMessage("samurai", this.samuraiSeq[this.currentSamurai - 1]));
        super.updateChange(new UpdateMessage("round", this.currentRound));
        super.updateChange(new UpdateMessage("pointsTotal", this.players[this.playerSeq[this.currentPlayer - 1]].getPointsTotal()));
//        this.updateVisible(this.updateVision());

        if (this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() == 0) {
            this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();
            if (this.currentPlayer == 1 || this.currentPlayer == 4 || this.currentPlayer == 5) {

            } else {
                switch (this.currentPlayer) {
                    case 2:
                        for (ActionOperation operation : samuraiAI[0].calculate()) {
                            OperationQueue.addOperation(operation);
                        }
                        break;
                    case 3:
                        for (ActionOperation operation : samuraiAI[1].calculate()) {
                            OperationQueue.addOperation(operation);
                        }
                        break;
                    case 6:
                        for (ActionOperation operation : samuraiAI[2].calculate()) {
                            OperationQueue.addOperation(operation);
                        }
                        break;
                }
                this.skip1Round();
            }
        } else {
            this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).setColdRound(this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() - 1);
            this.skip1Round();
        }
    }

    public void skip1Round(){
        OperationQueue.addOperation(new NextOperation());
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

            switch (this.level){
                case 0:
                    this.assignNext();
                    break;
                case 99:
                    this.assignNextWithAI();
                    break;
                default:
                    break;
            }
        }else{
            OperationQueue.addOperation(new EndOperation());
        }
    }

    public boolean gameOver(){
        this.gameState = GameState.OVER;
        if(this.timer != null) {
            this.timer.cancel();
        }
        super.updateChange(new UpdateMessage("over",this.chessBoardModel));

        //暂时先exit(0)
        System.exit(0);
        //用来保存信息的部分

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

    public int getLevel() {
        return level;
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

    public static boolean isServer() {
        return isServer;
    }

    public static boolean isClient(){
        return isClient;
    }

    public static void setServer(boolean server) {
        isServer = server;
        isClient = !server;
    }

    public class countDownTask extends java.util.TimerTask{
        public void run() {
            if(!isServer && !isClient) {
//            if(!isServer) {
//                Thread.sleep(1000);
                OperationQueue.addOperation(new TimeOperation());
            }
        }
    }

    public void countDown(){
//        System.out.println("COUNT DOWN!");
        if(this.currentTime > 0) {

//            if(this.playerSeq[this.currentPlayer - 1] == 0){
//                Operation.setServer(true);
//            }else{
//                Operation.setServer(false);
//            }

            super.updateChange(new UpdateMessage("time", this.currentTime));
            this.currentTime--;
        }else{
            this.actionDone();
        }
    }

    public void update(Observable o, Object arg) {
        TransformObject obj = (TransformObject) arg;
        String trigger_class = obj.getSource();
        UpdateMessage msg = obj.getMsg();
        Class<?> super_class = this.getClass().getInterfaces()[0];
        try {
            if(super_class.isAssignableFrom(Class.forName(trigger_class))){
                this.updateChange(msg);
                //执行 operation
                if(msg.getValue() instanceof Operation){
                    OperationQueue.addOperation((Operation)msg.getValue());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
