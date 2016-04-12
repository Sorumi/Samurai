package model.po;

import model.ChessBoardModel;
import model.GameModel;
import model.state.GameState;

import java.util.ArrayList;
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
    private ChessBoardModel chessBoardModel;
    private int actionPoint;
    private int pointsTotal;

    public Player(GameModel model,int playerNum){
        this.canAction = false;
        this.pointsTotal = 7;
        this.playerNum = playerNum;
        this.gameModel = model;
        this.chessBoardModel = this.gameModel.getChessBoardModel();
        this.samuraiPOs = new SamuraiPO[7];
        if(playerNum == 0){
            samuraiPOs[1] = new SamuraiPO(1,playerNum,0,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[2] = new SamuraiPO(2,playerNum,1,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[3] = new SamuraiPO(3,playerNum,2,this.gameModel.getLength(),this.chessBoardModel);
        }else if(playerNum == 1){
            samuraiPOs[4] = new SamuraiPO(4,playerNum,0,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[5] = new SamuraiPO(5,playerNum,1,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[6] = new SamuraiPO(6,playerNum,2,this.gameModel.getLength(),this.chessBoardModel);
        }
    }

    public void setEnableToAction(){
        this.canAction = true;
        this.currentSamurai = gameModel.getCurrentSamurai();
        this.actionPoint = pointsTotal;
        this.gameModel.actionPerformed(0);
    }

    public ArrayList<ActualBlock> showVision(){
        ArrayList<ActualBlock> blocks = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        if(this.playerNum == 1){
            positions.addAll(samuraiPOs[4].see());
            positions.addAll(samuraiPOs[5].see());
            positions.addAll(samuraiPOs[6].see());
        }else{
            positions.addAll(samuraiPOs[1].see());
            positions.addAll(samuraiPOs[2].see());
            positions.addAll(samuraiPOs[3].see());
        }
        //设为可见
        for(Position position : positions){
            blocks.add(this.chessBoardModel.getActualBlock(position.getX(),position.getY()));
            this.chessBoardModel.setActualBlockVisible(position.getX(),position.getY(),true);
        }
        return blocks;
    }

    //当view做出动作的时候 调用这个方法
    public void actionPerformed(int actionNum, int direction){
        if(this.canAction){
            //actionNum:动作编号
            //0:occupy 1:move 2:show / hide
            boolean done = false;
            switch (actionNum){
                case 0:
                    if(this.actionPoint >= 4){
                        ArrayList<Position> positions
                                = this.samuraiPOs[this.currentSamurai].occupied(direction,this.chessBoardModel,true);
                        if(!positions.isEmpty()) {
                            done = true;
                            this.actionPoint -= 4;
                            //检测需不需要把别人踢回去
                            for(Position position : positions){
                                if(this.playerNum == 0){
                                    if(position.getX() == this.gameModel.getSamuraiOfNum(4).getPos().getX()
                                            && position.getY() == this.gameModel.getSamuraiOfNum(4).getPos().getY()){
                                        this.gameModel.getSamuraiOfNum(4).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    }
                                    if(position.getX() == this.gameModel.getSamuraiOfNum(5).getPos().getX()
                                            && position.getY() == this.gameModel.getSamuraiOfNum(5).getPos().getY()){
                                        this.gameModel.getSamuraiOfNum(5).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    }
                                    if(position.getX() == this.gameModel.getSamuraiOfNum(6).getPos().getX()
                                            && position.getY() == this.gameModel.getSamuraiOfNum(6).getPos().getY()){
                                        this.gameModel.getSamuraiOfNum(6).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    }
                                }else{
                                    if(position.getX() == this.gameModel.getSamuraiOfNum(1).getPos().getX()
                                            && position.getY() == this.gameModel.getSamuraiOfNum(1).getPos().getY()){
                                        this.gameModel.getSamuraiOfNum(1).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    }
                                    if(position.getX() == this.gameModel.getSamuraiOfNum(2).getPos().getX()
                                            && position.getY() == this.gameModel.getSamuraiOfNum(2).getPos().getY()){
                                        this.gameModel.getSamuraiOfNum(2).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    }
                                    if(position.getX() == this.gameModel.getSamuraiOfNum(3).getPos().getX()
                                            && position.getY() == this.gameModel.getSamuraiOfNum(3).getPos().getY()){
                                        this.gameModel.getSamuraiOfNum(3).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    if(this.actionPoint >= 2){
                        if(this.samuraiPOs[this.currentSamurai].move(direction,this.chessBoardModel)){
                            done = true;
                            this.actionPoint -= 2;
                        }
                    }
                    break;
                case 2:
//                    System.out.println(this.currentSamurai + " is " + this.samuraiPOs[this.currentSamurai].getHide());
                    if(this.samuraiPOs[this.currentSamurai].getHide()) {
                        if (this.actionPoint >= 1) {
                            if(this.samuraiPOs[this.currentSamurai].show(this.chessBoardModel)) {
                                done = true;
                                this.actionPoint -= 1;
                            }
                        }
                    }else{
                        if(this.actionPoint >= 1){
                            if(this.samuraiPOs[this.currentSamurai].hide(this.chessBoardModel)) {
                                done = true;
                                this.actionPoint -= 1;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
            System.out.println("ActionPoint Left:" + actionPoint);
            if(!done){
                System.out.println("Action NOT Performed.");
            }else{
                this.gameModel.actionPerformed(actionNum);
            }
            if(this.actionPoint == 0){
                this.actionDone();
            }
        }

        //打印一下棋盘
//        for (int i = 0; i <= this.gameModel.getLength(); i++) {
//            if(i < 10)  System.out.print(" ");
//            System.out.print(i + ":");
//            for (int x = 0; x <= this.gameModel.getLength(); x++) {
//                System.out.print(this.chessBoardModel.getActualBlockState(i, x) + " ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i <= this.gameModel.getLength(); i++) {
//            if(i < 10)  System.out.print(" ");
//            System.out.print(i + ":");
//            for (int x = 0; x <= this.gameModel.getLength(); x++) {
//                System.out.print(this.chessBoardModel.getActualBlockOccupied(i, x) + " ");
//            }
//            System.out.println();
//        }
    }

    //时间到了或者没点数或者玩家主动放弃的时候调用此方法
    public void actionDone(){
        this.gameModel.actionDone();
    }

    public int getPlayerNum(){
        return this.playerNum;
    }

    public SamuraiPO getSamuraiOfNum(int num){
        return samuraiPOs[num];
    }

    public int getActionPoint(){
        return this.actionPoint;
    }
    
    public int getPointsTotal(){
        return this.pointsTotal;
    }
    
    public boolean canAction(){
        return this.canAction;
    }

}
