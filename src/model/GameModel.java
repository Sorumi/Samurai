package model;

import controller.msgqueue.*;
import model.po.*;
import network.TransformObject;
import network.client.ClientService;
import view.GamePanel;

/*
 * 2016-05-15 1,000 Lines Get!
 * By KrayC
 */

import java.util.*;

public class GameModel extends BaseModel implements Observer {
    private ChessBoardModel chessBoardModel;
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

    private ArrayList<PropsInG> propsInGList;
    private int[] propList;
    private PropsStore propsStore;

    private boolean flag = false;
    private Position aidPos;

    protected ClientService net;
    private static boolean isServer = false;
    private static boolean isClient = false;

    //level:
    //0     : Online
    //11--- : Story Mode, Level from 1 ~ 5, each have 3 difficulties
    //99    : Classic

    //Classic 和 Online 构造方法
    public GameModel(int round, int length, GamePanel gamePanel, int level){
        this.level = level;
        this.length = length;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.chessBoardModel.addObserver(gamePanel.chessBoard);
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

    //Story 构造方法
    public GameModel(int round, int length, GamePanel gamePanel, int level, SamuraiPO[] samuraiPOs){

        Thread.currentThread().setPriority(1);
        Armory armory = StoryModel.getStoryModel().getArmory();
        this.aidPos = new Position(length/2 , length/2);
        this.level = level;
        this.length = length;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.chessBoardModel.addObserver(gamePanel.chessBoard);
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
        players[0] = new Player(this,0,samuraiPOs);
        players[0].setSamuraiPOs(samuraiPOs);
        SamuraiPO[] aiSamuraiPO = new SamuraiPO[3];

        Position[] homePosition = new Position[3];

        if(this.level % 10 == 1){
            homePosition[0] = new Position(0,0);
            homePosition[1] = new Position(7,0);
            homePosition[2] = new Position(14,0);
        }

        switch (this.level){
            //TODO
            case 11:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(11), 14, chessBoardModel, armory.getArmor(911), new Position(0, length), 10, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(111), 14, chessBoardModel, armory.getArmor(911), new Position(length/2, length), 10, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(211), 14, chessBoardModel, armory.getArmor(911), new Position(length, length), 10, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],0,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],1,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],0,this.chessBoardModel,1);
                break;
            case 12:
                homePosition[0] = this.randomHomeLocationWithScale(2,2,1);
                homePosition[1] = this.randomHomeLocationWithScale(7,2,1);
                homePosition[2] = this.randomHomeLocationWithScale(12,2,1);
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(12), 14, chessBoardModel, armory.getArmor(911), this.randomHomeLocationWithScale(2,12,1), 12, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(112), 14, chessBoardModel, armory.getArmor(911), this.randomHomeLocationWithScale(7,12,1), 12, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(212), 14, chessBoardModel, armory.getArmor(911), this.randomHomeLocationWithScale(12,12,1), 12, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],0,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],1,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],1,this.chessBoardModel,1);
                break;
            case 13:
                homePosition[0] = this.randomHomeLocationWithScale(2,2,2);
                homePosition[1] = this.randomHomeLocationWithScale(7,2,2);
                homePosition[2] = this.randomHomeLocationWithScale(12,2,2);
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(13), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(2,12,2), 12, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(133), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(7,12,2), 12, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(213), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(12,12,2), 12, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],1,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],1,this.chessBoardModel,1);
                break;
            case 21:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(12), 14, chessBoardModel, armory.getArmor(912), new Position(0, length), 14, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(112), 14, chessBoardModel, armory.getArmor(912), new Position(length/2, length), 14, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(212), 14, chessBoardModel, armory.getArmor(912), new Position(length, length), 14, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],0,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],1,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],1,this.chessBoardModel,1);
                break;
            case 22:
                homePosition[0] = this.randomHomeLocationWithScale(2,2,1);
                homePosition[1] = this.randomHomeLocationWithScale(7,2,1);
                homePosition[2] = this.randomHomeLocationWithScale(2,7,1);
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(13), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(12,12,1), 16, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(133), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(7,12,1), 16, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(213), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(12,7,1), 16, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],1,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],1,this.chessBoardModel,1);
                break;
            case 23:
                homePosition[0] = this.randomHomeLocationWithScale(2,2,2);
                homePosition[1] = this.randomHomeLocationWithScale(7,2,2);
                homePosition[2] = this.randomHomeLocationWithScale(2,7,2);
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(14), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(12,12,2), 16, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(124), 14, chessBoardModel, armory.getArmor(912), this.randomHomeLocationWithScale(7,12,2), 16, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(234), 14, chessBoardModel, armory.getArmor(933), this.randomHomeLocationWithScale(12,7,2), 16, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],2,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],1,this.chessBoardModel,1);
                break;
            case 31:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(33), 14, chessBoardModel, armory.getArmor(933), new Position(0, length), 16, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(113), 14, chessBoardModel, armory.getArmor(913), new Position(length/2, length), 16, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(323), 14, chessBoardModel, armory.getArmor(913), new Position(length, length), 16, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],1,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],1,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],1,this.chessBoardModel,1);
                break;
            case 32:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(233), 14, chessBoardModel, armory.getArmor(914), new Position(0, length), 16, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(23), 14, chessBoardModel, armory.getArmor(933), new Position(length/2, length), 16, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(413), 14, chessBoardModel, armory.getArmor(913), new Position(length, length), 16, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],2,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],2,this.chessBoardModel,1);
                break;
            case 33:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(14), 14, chessBoardModel, armory.getArmor(914), new Position(0, length), 18, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(424), 14, chessBoardModel, armory.getArmor(924), new Position(length/2, length), 18, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(324), 14, chessBoardModel, armory.getArmor(934), new Position(length, length), 18, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],3,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],3,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],3,this.chessBoardModel,1);
                break;
            case 41:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(234), 14, chessBoardModel, armory.getArmor(924), new Position(0, length), 18, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(134), 14, chessBoardModel, armory.getArmor(934), new Position(length/2, length), 18, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(314), 14, chessBoardModel, armory.getArmor(915), new Position(length, length), 18, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],1,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],1,this.chessBoardModel,1);
                break;
            case 42:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(115), 14, chessBoardModel, armory.getArmor(925), new Position(0, length), 20, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(15), 14, chessBoardModel, armory.getArmor(935), new Position(length/2, length), 20, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(414), 14, chessBoardModel, armory.getArmor(915), new Position(length, length), 20, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],2,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],2,this.chessBoardModel,1);
                break;
            case 43:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(415), 14, chessBoardModel, armory.getArmor(916), new Position(0, length), 22, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(16), 14, chessBoardModel, armory.getArmor(925), new Position(length/2, length), 22, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(325), 14, chessBoardModel, armory.getArmor(935), new Position(length, length), 22, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],3,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],3,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],3,this.chessBoardModel,1);
                break;
            case 51:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(315), 14, chessBoardModel, armory.getArmor(915), new Position(0, length), 22, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(225), 14, chessBoardModel, armory.getArmor(925), new Position(length/2, length), 22, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(35), 14, chessBoardModel, armory.getArmor(935), new Position(length, length), 22, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],2,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],2,this.chessBoardModel,1);
                break;
            case 52:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(416), 14, chessBoardModel, armory.getArmor(916), new Position(0, length), 24, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(325), 14, chessBoardModel, armory.getArmor(925), new Position(length/2, length), 24, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(15), 14, chessBoardModel, armory.getArmor(936), new Position(length, length), 24, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],3,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],2,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],3,this.chessBoardModel,1);
                break;
            case 53:
                aiSamuraiPO[0] = new SamuraiPO(4, 1, armory.getWeapon(126), 14, chessBoardModel, armory.getArmor(926), new Position(0, length), 10, 2);
                aiSamuraiPO[1] = new SamuraiPO(5, 1, armory.getWeapon(226), 14, chessBoardModel, armory.getArmor(936), new Position(length/2, length), 2, 2);
                aiSamuraiPO[2] = new SamuraiPO(6, 1, armory.getWeapon(16), 14, chessBoardModel, armory.getArmor(916), new Position(length, length), 2, 2);
                samuraiAI = new SamuraiAI[3];
                samuraiAI[0] = new SamuraiAI(aiSamuraiPO[0],3,this.chessBoardModel,1);
                samuraiAI[1] = new SamuraiAI(aiSamuraiPO[1],3,this.chessBoardModel,1);
                samuraiAI[2] = new SamuraiAI(aiSamuraiPO[2],3,this.chessBoardModel,1);
                break;
            default:
                break;
        }

        players[1] = new Player(this,1,aiSamuraiPO);

        //这里更新人类武士的家
        this.getSamuraiOfNum(1).setHome(homePosition[0]);
        this.getSamuraiOfNum(2).setHome(homePosition[1]);
        this.getSamuraiOfNum(3).setHome(homePosition[2]);
        this.getSamuraiOfNum(1).beKilled(chessBoardModel);
        this.getSamuraiOfNum(2).beKilled(chessBoardModel);
        this.getSamuraiOfNum(3).beKilled(chessBoardModel);

        this.propList = new int[15];
        this.propsInGList = new ArrayList<>();
        this.propsStore = StoryModel.getStoryModel().getPropsStore();
        for (int i = 1; i <= 14; i++) {
            this.propList[i] = this.propsStore.getProps(PropsInG.get7Type(i)).getNumber();
        }

        isServer = false;
        isClient = false;
    }

    public GameModel(){
        this.level = 9999;
        this.length = 14;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.timeTotal = 9999;
        this.currentTime = this.timeTotal;
        this.currentRound = 1;
        this.totalRound = 24;
        this.currentSamurai = 1;
        this.players = new Player[1];
        players[0] = new Player(this,0);
//        players[1] = new Player(this,1);
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

        System.out.println("Level " + this.getLevel());

        super.updateChange(new UpdateMessage("vision", blocks));

        //重置武士的一些属性
        for (int i = 1; i <= 6; i++) {
            super.updateChange(new UpdateMessage("healthTotal", new int[]{i, this.getSamuraiOfNum(i).getTotalHealthPoint()}));
            this.updateHome(i);
            if(this.getSamuraiOfNum(i).getColdRound() != 0) {
                this.getSamuraiOfNum(i).setColdRound(0);
            }
        }

        switch (this.level){
            case 0:
                this.assignNext();
                break;
            case 99:
                this.assignNextWithAI();
                break;
            default:
                //故事模式重置道具 list
                this.propsInGList.clear();
                this.assignNextWithAI();
                break;
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
        System.out.println("Update Pos : " + position);

        if(this.level != 99) {
            ArrayList<PropsInG> tmp = new ArrayList<>();
            //捡到道具
            for (PropsInG props : this.propsInGList) {
                if (props.getPosition().getX() == position.getX() &&
                        props.getPosition().getY() == position.getY()) {

                    System.out.println("Get prop!" + props.getType());

                    //只有人类玩家才加道具
                    if(this.samuraiSeq[this.currentSamurai - 1] / 4 == 1) {
                        propList[props.getType()]++;
                    }

                    tmp.add(props);

                    System.out.println(props.getType() + " number: " + propList[props.getType()]);

                    //这个消息是用来消失道具的
                    super.updateChange(new UpdateMessage("getProp", position));

                    super.updateChange(new UpdateMessage("allProps", this.propList));
                }
            }

            for(PropsInG propsInG : tmp){
                this.propsInGList.remove(propsInG);
            }
        }

    }

    public void useProp(int propNum){
        propList[propNum]--;
        System.out.println("prop : " + propNum + " num " + propList[propNum]);
        if(!this.propsStore.use(PropsInG.get7Type(propNum), this.getSamuraiOfNum(this.getCurrentSamurai())).equals("kill")) {
            this.getSamuraiOfNum(this.getCurrentSamurai()).setProp(propNum);
        }
    }

    public void updateOccupy(int direction){
        super.updateChange(new UpdateMessage("samuraiOccupy",direction));
    }

    public void updateHealthPoint(int samurai){
        super.updateChange(new UpdateMessage("healthPoint", new int[]{samurai, this.getSamuraiOfNum(samurai).getHealthPoint()}));
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

    public int attackSamurai(int samurai, int attackPoint, int armorPuncture, int isCritical){
        double attackPointDouble=attackPoint;
        switch (samurai){
            case 1:
                if(!this.players[0].getSamuraiOfNum(1).checkMiss()){
                    double ta = this.players[0].getSamuraiOfNum(1).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (1-(ta / (ta + 100)));
                        System.out.println(attackPointDouble);
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[0].getSamuraiOfNum(1).injure((int)attackPointDouble);

                    if(isCritical == 0){
                        super.updateChange(new UpdateMessage("normal-attack",new int[]{samurai,(int)attackPointDouble}));
                    }else{
                        super.updateChange(new UpdateMessage("critical-attack",new int[]{samurai,(int)attackPointDouble}));
                    }

                }else{
                    super.updateChange(new UpdateMessage("miss",samurai));
                }
                return this.players[0].getSamuraiOfNum(1).getHealthPoint();
            case 2:
                if(!this.players[0].getSamuraiOfNum(2).checkMiss()){
                    double ta = this.players[0].getSamuraiOfNum(2).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (1-(ta / (ta + 100)));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[0].getSamuraiOfNum(2).injure((int)attackPointDouble);

                    if(isCritical == 0){
                        super.updateChange(new UpdateMessage("normal-attack",new int[]{samurai,(int)attackPointDouble}));
                    }else{
                        super.updateChange(new UpdateMessage("critical-attack",new int[]{samurai,(int)attackPointDouble}));
                    }

                }else{
                    super.updateChange(new UpdateMessage("miss",samurai));
                }
                return this.players[0].getSamuraiOfNum(2).getHealthPoint();
            case 3:
                if(!this.players[0].getSamuraiOfNum(3).checkMiss()){
                    double ta = this.players[0].getSamuraiOfNum(3).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (1-(ta / (ta + 100)));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[0].getSamuraiOfNum(3).injure((int)attackPointDouble);

                    if(isCritical == 0){
                        super.updateChange(new UpdateMessage("normal-attack",new int[]{samurai,(int)attackPointDouble}));
                    }else{
                        super.updateChange(new UpdateMessage("critical-attack",new int[]{samurai,(int)attackPointDouble}));
                    }

                }else{
                    super.updateChange(new UpdateMessage("miss",samurai));
                }
                return this.players[0].getSamuraiOfNum(3).getHealthPoint();
            case 4:
                if(!this.players[1].getSamuraiOfNum(4).checkMiss()){
                    double ta = this.players[1].getSamuraiOfNum(4).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (1-(ta / (ta + 100)));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[1].getSamuraiOfNum(4).injure((int)attackPointDouble);

                    if(isCritical == 0){
                        super.updateChange(new UpdateMessage("normal-attack",new int[]{samurai,(int)attackPointDouble}));
                    }else{
                        super.updateChange(new UpdateMessage("critical-attack",new int[]{samurai,(int)attackPointDouble}));
                    }

                }else{
                    super.updateChange(new UpdateMessage("miss",samurai));
                }
                return this.players[1].getSamuraiOfNum(4).getHealthPoint();
            case 5:
                if(!this.players[1].getSamuraiOfNum(5).checkMiss()){
                    double ta = this.players[1].getSamuraiOfNum(5).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (1-(ta / (ta + 100)));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[1].getSamuraiOfNum(5).injure((int)attackPointDouble);

                    if(isCritical == 0){
                        super.updateChange(new UpdateMessage("normal-attack",new int[]{samurai,(int)attackPointDouble}));
                    }else{
                        super.updateChange(new UpdateMessage("critical-attack",new int[]{samurai,(int)attackPointDouble}));
                    }

                }else{
                    super.updateChange(new UpdateMessage("miss",samurai));
                }
                return this.players[1].getSamuraiOfNum(5).getHealthPoint();
            case 6:
                if(!this.players[1].getSamuraiOfNum(6).checkMiss()){
                    double ta = this.players[1].getSamuraiOfNum(6).getArmorRate() - armorPuncture;
                    if(ta > 0){
                        attackPointDouble *= (1-(ta / (ta + 100)));
                    }else{
                        attackPointDouble *= 1.5;
                    }
                    this.players[1].getSamuraiOfNum(6).injure((int)attackPointDouble);

                    if(isCritical == 0){
                        super.updateChange(new UpdateMessage("normal-attack",new int[]{samurai,(int)attackPointDouble}));
                    }else{
                        super.updateChange(new UpdateMessage("critical-attack",new int[]{samurai,(int)attackPointDouble}));
                    }

                }else{
                    super.updateChange(new UpdateMessage("miss",samurai));
                }
                return this.players[1].getSamuraiOfNum(6).getHealthPoint();
            default:
                return 9999;
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
        super.updateChange(new UpdateMessage("actionPoint",this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getActionPoint()));
    }

    //单机模式也是只能看见自己这方的 block
    public ArrayList<ActualBlock> updateVision(){

        //开挂模式

        ArrayList<ActualBlock> blocks = new ArrayList<>();

        for(int x = 0; x <= this.length; x++){
            for (int y = 0; y <= this.length; y++) {
                blocks.add(this.chessBoardModel.getActualBlock(x,y));
            }
        }

//        if(GameModel.isClient() && !GameModel.isServer()){
//            blocks = this.players[1].showVision();
//            super.updateChange(new UpdateMessage("vision", blocks));
//            return blocks;
//        }else{
//            blocks = this.players[0].showVision();
//            super.updateChange(new UpdateMessage("vision", blocks));
//            return blocks;
//        }


        super.updateChange(new UpdateMessage("vision", blocks));
        return blocks;
    }

    public void updateVisible(ArrayList<ActualBlock> blocks){
        super.updateChange(new UpdateMessage("visible", blocks));
    }

    public void updateOccupiedBlocks(){
        super.updateChange(new UpdateMessage("occupiedBlocks",this.chessBoardModel.getStatesOfAllBlocks()));
    }

    public void updatePseudo0ccupy(boolean HL, int direction) {
        if(HL) {
            super.updateChange(new UpdateMessage("pseudoOccupy",this.players[this.playerSeq[this.currentPlayer - 1]].pseudoOccupy(direction)));
        }else{
            super.updateChange(new UpdateMessage("a-pseudoOccupy",this.players[this.playerSeq[this.currentPlayer - 1]].pseudoOccupy(direction)));
        }
    }

    public Position randomHomeLocationWithScale(int x, int y, int scale){
        Random random = new Random();
        boolean flag = false;
        while(!flag){
            x = x + random.nextInt(2 * scale + 1) - scale;
            y = y + random.nextInt(2 * scale + 1) - scale;
            if(this.chessBoardModel.getActualBlockState(x ,y) == 0){
                flag = true;
            }
        }
        return new Position(x, y);
    }

    //生成道具随机位置
    public Position randomPropLocation(){
        Random random = new Random();
        boolean flag = false;
        int x = 0, y = 0;
        while(!flag){
            x = random.nextInt(this.length);
            y = random.nextInt(this.length);
            if(this.chessBoardModel.getActualBlockState(x ,y) == 0){
                flag = true;
            }
            for(PropsInG propsInG : this.propsInGList){
                if(propsInG.getPosition().getX() == x && propsInG.getPosition().getY() == y){
                    flag = false;
                    break;
                }
            }
        }
        return new Position(x, y);
    }

    //联机模式下
    public void assignNext(){

        if(this.playerSeq[this.currentPlayer - 1] == 0){
            Operation.setServer(true);
        }else{
            Operation.setServer(false);
        }

        System.out.println("Now is " + this.getCurrentSamurai());

        this.getSamuraiOfNum(this.getCurrentSamurai()).setActionPoint(this.getSamuraiOfNum(this.getCurrentSamurai()).getTotalActionPoint());

        if(this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() == 0){

            this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();

            super.updateChange(new UpdateMessage("player",this.playerSeq[this.currentPlayer - 1]));
            super.updateChange(new UpdateMessage("samurai",this.samuraiSeq[this.currentSamurai - 1]));
            super.updateChange(new UpdateMessage("round",this.currentRound));
            super.updateChange(new UpdateMessage("pointsTotal", this.getSamuraiOfNum(this.getCurrentSamurai()).getTotalActionPoint()));
            super.updateChange(new UpdateMessage("actionPoint",this.getSamuraiOfNum(this.getCurrentSamurai()).getActionPoint()));
//            this.updateVisible(this.updateVision());
        }else{

            this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).setColdRound(this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() - 1);

            if (this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() == 0) {
                super.updateChange(new UpdateMessage("revive", this.samuraiSeq[this.currentSamurai - 1]));
            }

            OperationQueue.addOperation(new SkipOperation());

        }
    }

    //经典模式下+故事模式下
    public void assignNextWithAI()  {

        //在 gamePanel 上放道具
        if(this.level != 99) {
            Random random = new Random();
            if (random.nextInt(1) == 0) {
//                Position position = this.randomPropLocation();
                //暂时固定位置
                Position position = new Position(2 + random.nextInt(2) + 1,12 + random.nextInt(2) + 1);
                //type 都是1~14的
                int type = random.nextInt(14) + 1;
                this.propsInGList.add(new PropsInG(position,type));

                super.updateChange(new UpdateMessage("prop",new int[]{position.getX(),position.getY(),type}));
            }

            //把所有道具存活轮数减1,如果是0的就去掉
            ArrayList<PropsInG> tmp = new ArrayList<>();
            for(PropsInG propsInG : this.propsInGList){
                if(propsInG.getExistRound() == 0){
                    tmp.add(propsInG);
                }
                propsInG.minusExistRound();
            }
            for (PropsInG propsInG : tmp){
                Position position = propsInG.getPosition();
                super.updateChange(new UpdateMessage("getProp", position));
                this.propsInGList.remove(propsInG);
            }

            System.out.println("prop size:  " + this.propsInGList.size());

            int i = this.getSamuraiOfNum(this.getCurrentSamurai()).getProp();
            if(i != 0){
                this.getSamuraiOfNum(this.getCurrentSamurai()).setProp(0);
                if(i != 13) {
                    this.propsStore.replace(PropsInG.get7Type(i), this.getSamuraiOfNum(this.getCurrentSamurai()));
                }
            }

        }

        System.out.println("Now is " + this.samuraiSeq[this.currentSamurai - 1]);

        if (this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() == 0) {

            if (this.currentPlayer == 1 || this.currentPlayer == 3 || this.currentPlayer == 4) {
                this.timer = new Timer();
                this.timer.schedule(new countDownTask(), 0, 1000);
            }
            if (this.currentPlayer == 2 || this.currentPlayer == 3 || this.currentPlayer == 6) {
                this.timer.cancel();
            }

            this.getSamuraiOfNum(this.getCurrentSamurai()).setActionPoint(this.getSamuraiOfNum(this.getCurrentSamurai()).getTotalActionPoint());

            super.updateChange(new UpdateMessage("player", this.playerSeq[this.currentPlayer - 1]));
            super.updateChange(new UpdateMessage("samurai", this.samuraiSeq[this.currentSamurai - 1]));
            super.updateChange(new UpdateMessage("round", this.currentRound));
            super.updateChange(new UpdateMessage("pointsTotal", this.getSamuraiOfNum(this.getCurrentSamurai()).getTotalActionPoint()));
            super.updateChange(new UpdateMessage("actionPoint", this.getSamuraiOfNum(this.getCurrentSamurai()).getActionPoint()));
            super.updateChange(new UpdateMessage("healthPoint", new int[]{this.currentSamurai, this.getSamuraiOfNum(this.currentSamurai).getHealthPoint()}));

            this.updateVisible(this.updateVision());

            this.players[this.playerSeq[this.currentPlayer - 1]].setEnableToAction();

            if (this.currentPlayer == 1 || this.currentPlayer == 4 || this.currentPlayer == 5) {

            } else {
                if (this.level == 99) {
                    switch (this.currentPlayer) {
                        case 2:
                            for (ActionOperation operation : samuraiAI[0].calculate()) {
                                OperationQueue.addOperation(operation);
                            }
                            OperationQueue.addOperation(new SkipOperation());
                            break;
                        case 3:
                            for (ActionOperation operation : samuraiAI[1].calculate()) {
                                OperationQueue.addOperation(operation);
                            }
                            OperationQueue.addOperation(new SkipOperation());
                            break;
                        case 6:
                            for (ActionOperation operation : samuraiAI[2].calculate()) {
                                OperationQueue.addOperation(operation);
                            }
                            OperationQueue.addOperation(new SkipOperation());
                            break;
                    }
                } else {
                    int i = 0;
                    ArrayList<Position> positions = this.players[this.playerSeq[this.currentPlayer - 1]].getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).see();
                    for (Position p : positions) {
                        if (p.getX() == this.players[0].getSamuraiOfNum(1).getPos().getX()
                                && p.getY() == this.players[0].getSamuraiOfNum(1).getPos().getY()) {
                            i = 1;
                        }
                        if (p.getX() == this.players[0].getSamuraiOfNum(2).getPos().getX()
                                && p.getY() == this.players[0].getSamuraiOfNum(2).getPos().getY()) {
                            i = 2;
                        }
                        if (p.getX() == this.players[0].getSamuraiOfNum(3).getPos().getX()
                                && p.getY() == this.players[0].getSamuraiOfNum(3).getPos().getY()) {
                            i = 3;
                        }
                    }
                    switch (this.currentPlayer) {
                        case 2:
                            this.samuraiAI[0].getSamuraiPO().setActionPoint(samuraiAI[0].getSamuraiPO().getTotalActionPoint());
                            for (ActionOperation operation : samuraiAI[0].storyCalculate(i == 0 ? null : this.getSamuraiOfNum(i), flag ? aidPos : null)) {
                                if (operation.getActionNum() == 98) {
                                    aidPos.setX(operation.getDirection() / 100);
                                    aidPos.setY(operation.getDirection() % 100);
                                    flag = true;
                                } else {
                                    OperationQueue.addOperation(operation);
                                }
                            }
                            OperationQueue.addOperation(new SkipOperation());
                            break;
                        case 3:
                            this.samuraiAI[1].getSamuraiPO().setActionPoint(samuraiAI[1].getSamuraiPO().getTotalActionPoint());
                            for (ActionOperation operation : samuraiAI[1].storyCalculate(i == 0 ? null : this.getSamuraiOfNum(i), flag ? aidPos : null)) {
                                if (operation.getActionNum() == 98) {
                                    aidPos.setX(operation.getDirection() / 100);
                                    aidPos.setY(operation.getDirection() % 100);
                                    flag = true;
                                } else {
                                    OperationQueue.addOperation(operation);
                                }
                            }
                            OperationQueue.addOperation(new SkipOperation());
                            break;
                        case 6:
                            this.samuraiAI[2].getSamuraiPO().setActionPoint(samuraiAI[2].getSamuraiPO().getTotalActionPoint());
                            for (ActionOperation operation : samuraiAI[2].storyCalculate(i == 0 ? null : this.getSamuraiOfNum(i), flag ? aidPos : null)) {
                                if (operation.getActionNum() == 98) {
                                    aidPos.setX(operation.getDirection() / 100);
                                    aidPos.setY(operation.getDirection() % 100);
                                    flag = true;
                                } else {
                                    OperationQueue.addOperation(operation);
                                }
                            }
                            OperationQueue.addOperation(new SkipOperation());
                            break;
                    }
                }
            }
        } else {

            this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).setColdRound(this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() - 1);

            if (this.getSamuraiOfNum(this.samuraiSeq[this.currentSamurai - 1]).getColdRound() == 0) {
                super.updateChange(new UpdateMessage("revive", this.samuraiSeq[this.currentSamurai - 1]));
            }

            OperationQueue.addOperation(new SkipOperation());
        }

    }

    public void actionDone(){

        this.currentTime = this.timeTotal;

        super.updateChange(new UpdateMessage("goodbyeactionpanel",0));

        System.out.println("Action Done");

        if(this.timer != null){
            this.timer.cancel();
        }

        if(this.currentRound < this.totalRound) {
            this.currentRound++;
            if((this.currentSamurai++) % 6 == 0){
                this.currentSamurai = 1;
            }
            if((this.currentPlayer++) % 6 == 0){
                this.currentPlayer = 1;
            }
            OperationQueue.addOperation(new NextOperation());

            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            OperationQueue.addOperation(new EndOperation(true));
        }

    }

    public void gameOver(){
        if(this.timer != null) {
            this.timer.cancel();
        }
        super.updateChange(new UpdateMessage("over",this.chessBoardModel.getStatesOfAllBlocks()));

        //故事模式时
        if(this.level != 99) {
            //发送我这局拿到多少道具
            ScoreBoard scoreBoard = new ScoreBoard();

            int myKill = this.getSamuraiOfNum(1).getKillNum() + this.getSamuraiOfNum(2).getKillNum() + this.getSamuraiOfNum(3).getKillNum();
            int aiKill = this.getSamuraiOfNum(4).getKillNum() + this.getSamuraiOfNum(5).getKillNum() + this.getSamuraiOfNum(6).getKillNum();
            System.out.println("I kill " + myKill + " and AI kill " + aiKill);

            int block = this.chessBoardModel.getStatesOfAllBlocks()[1] + this.chessBoardModel.getStatesOfAllBlocks()[2]
                    + this.chessBoardModel.getStatesOfAllBlocks()[3] - this.chessBoardModel.getStatesOfAllBlocks()[4]
                    - this.chessBoardModel.getStatesOfAllBlocks()[5] - this.chessBoardModel.getStatesOfAllBlocks()[6];

            scoreBoard.caculateMaterial(level/10 - 1, level%10, block, myKill, aiKill);
            ArrayList<Material> materials = scoreBoard.getMaterial();
            super.updateChange(new UpdateMessage("materials",materials));

            int[] experience = scoreBoard.getExperience(level/10, level%10, this.chessBoardModel.getStatesOfAllBlocks()[1],
                    this.chessBoardModel.getStatesOfAllBlocks()[2], this.chessBoardModel.getStatesOfAllBlocks()[3],
                    this.getSamuraiOfNum(1).getKillNum(),this.getSamuraiOfNum(2).getKillNum(),this.getSamuraiOfNum(3).getKillNum());
            this.players[0].getSamuraiOfNum(1).addExperience(experience[0]);
            this.players[0].getSamuraiOfNum(2).addExperience(experience[1]);
            this.players[0].getSamuraiOfNum(3).addExperience(experience[2]);
            super.updateChange(new UpdateMessage("experiences",experience));

            boolean[] isLevelUp = new boolean[]{this.players[0].getSamuraiOfNum(1).isUpLevel(),this.players[0].getSamuraiOfNum(2).isUpLevel(),
                    this.players[0].getSamuraiOfNum(3).isUpLevel()};
            for (int i = 0; i <= 2; i++) {
                if(isLevelUp[i]){
                    super.updateChange(new UpdateMessage("levelup",i));
                }
            }

            int money = experience[0]+experience[1]+experience[2];
            this.propsStore.updateMoney(money);
            //去 propsStore 更新数量
            for (int i = 1; i <= 14; i++) {
                this.propsStore.getProps(PropsInG.get7Type(i)).setNumber(this.propList[i]);
            }

            super.updateChange(new UpdateMessage("money",money));

            super.updateChange(new UpdateMessage("rating",scoreBoard.getRating()));

            //这是-->这一局<--获得的道具
            super.updateChange(new UpdateMessage("allProps", this.propList));
        }

        System.out.println("GAME OVER!");
    }

    public void exit(){
        if(this.timer != null) {
            this.timer.cancel();
        }
        System.out.println("GAME EXIT!");
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

    public int getCurrentRound() {
        return currentRound;
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
            OperationQueue.addOperation(new TimeOperation());
        }
    }

    public void countDown(){
        if(this.currentTime > 0) {
            super.updateChange(new UpdateMessage("time", this.currentTime));
            System.out.println("Time: " + this.currentTime);
            this.currentTime--;

        }else{
            OperationQueue.addOperation(new SkipOperation());
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
