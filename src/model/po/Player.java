package model.po;

import model.ChessBoardModel;
import model.GameModel;
import model.state.GameState;

import java.util.ArrayList;

/**
 * Created by Kray on 16/3/26.
 */
public class Player {
    private GameModel gameModel;
    private int playerNum;
    private SamuraiPO[] samuraiPOs;
    private int currentSamurai;
    private ChessBoardModel chessBoardModel;
    private int actionPoint;
    private int pointsTotal;

    public Player(GameModel model,int playerNum){
        this.pointsTotal = 10;
        this.playerNum = playerNum;
        this.gameModel = model;
        this.chessBoardModel = this.gameModel.getChessBoardModel();
        this.samuraiPOs = new SamuraiPO[7];
        if(playerNum == 0){
            samuraiPOs[1] = new SamuraiPO(1,playerNum,new Weapon(0),this.gameModel.getLength(),this.chessBoardModel,new Armor());
            samuraiPOs[2] = new SamuraiPO(2,playerNum,new Weapon(1),this.gameModel.getLength(),this.chessBoardModel,new Armor());
            samuraiPOs[3] = new SamuraiPO(3,playerNum,new Weapon(2),this.gameModel.getLength(),this.chessBoardModel,new Armor());
        }else if(playerNum == 1){
            samuraiPOs[4] = new SamuraiPO(4,playerNum,new Weapon(0),this.gameModel.getLength(),this.chessBoardModel,new Armor());
            samuraiPOs[5] = new SamuraiPO(5,playerNum,new Weapon(1),this.gameModel.getLength(),this.chessBoardModel,new Armor());
            samuraiPOs[6] = new SamuraiPO(6,playerNum,new Weapon(2),this.gameModel.getLength(),this.chessBoardModel,new Armor());
        }
    }

    public void setEnableToAction(){
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
        //actionNum:动作编号
        //0:occupy 1:move 2:show / hide
        boolean done = false;
        switch (actionNum){
            case 0:
                if(this.actionPoint >= 4){
                    ArrayList<Position> positions
                            = this.samuraiPOs[this.currentSamurai].occupied(direction,this.chessBoardModel,true);
                    if(!positions.isEmpty()) {
                        this.gameModel.updateOccupy(direction);
                        done = true;
                        this.actionPoint -= 4;
                        //检测需不需要把别人踢回去
                        ArrayList<Integer> killedSamurais = new ArrayList<>();
                        for(Position position : positions){
                            if(this.playerNum == 0){
                                if(position.getX() == this.gameModel.getSamuraiOfNum(4).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(4).getPos().getY()){
                                    this.gameModel.getSamuraiOfNum(4).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    this.gameModel.updateHome(4);
                                    if(!killedSamurais.contains(4)) {
                                        killedSamurais.add(4);
                                    }
                                    this.gameModel.getChessBoardModel().changeActualBlock(
                                            this.gameModel.getSamuraiOfNum(4).getHome().getX(),
                                            this.gameModel.getSamuraiOfNum(4).getHome().getY(),
                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(5).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(5).getPos().getY()){
                                    this.gameModel.getSamuraiOfNum(5).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    this.gameModel.updateHome(5);
                                    if(!killedSamurais.contains(5)) {
                                        killedSamurais.add(5);
                                    }
                                    this.gameModel.getChessBoardModel().changeActualBlock(
                                            this.gameModel.getSamuraiOfNum(5).getHome().getX(),
                                            this.gameModel.getSamuraiOfNum(5).getHome().getY(),
                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(6).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(6).getPos().getY()){
                                    this.gameModel.getSamuraiOfNum(6).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    this.gameModel.updateHome(6);
                                    if(!killedSamurais.contains(6)) {
                                        killedSamurais.add(6);
                                    }
                                    this.gameModel.getChessBoardModel().changeActualBlock(
                                            this.gameModel.getSamuraiOfNum(6).getHome().getX(),
                                            this.gameModel.getSamuraiOfNum(6).getHome().getY(),
                                            false);
                                }
                            }else{
                                if(position.getX() == this.gameModel.getSamuraiOfNum(1).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(1).getPos().getY()){
                                    this.gameModel.getSamuraiOfNum(1).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    this.gameModel.updateHome(1);
                                    if(!killedSamurais.contains(1)) {
                                        killedSamurais.add(1);
                                    }
                                    this.gameModel.getChessBoardModel().changeActualBlock(
                                            this.gameModel.getSamuraiOfNum(1).getHome().getX(),
                                            this.gameModel.getSamuraiOfNum(1).getHome().getY(),
                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(2).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(2).getPos().getY()){
                                    this.gameModel.getSamuraiOfNum(2).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    this.gameModel.updateHome(2);
                                    if(!killedSamurais.contains(2)) {
                                        killedSamurais.add(2);
                                    }
                                    this.gameModel.getChessBoardModel().changeActualBlock(
                                            this.gameModel.getSamuraiOfNum(2).getHome().getX(),
                                            this.gameModel.getSamuraiOfNum(2).getHome().getY(),
                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(3).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(3).getPos().getY()){
                                    this.gameModel.getSamuraiOfNum(3).beKilled(this.gameModel.getLength(),this.chessBoardModel);
                                    this.gameModel.updateHome(3);
                                    if(!killedSamurais.contains(3)) {
                                        killedSamurais.add(3);
                                    }
                                    this.gameModel.getChessBoardModel().changeActualBlock(
                                            this.gameModel.getSamuraiOfNum(3).getHome().getX(),
                                            this.gameModel.getSamuraiOfNum(3).getHome().getY(),
                                            false);
                                }
                            }
                        }
                        //去发消息:哪些人被杀了
                        if(killedSamurais.size() > 0) {
                            this.gameModel.getChessBoardModel().changeActualBlock(
                                    this.gameModel.getSamuraiOfNum(this.gameModel.getCurrentSamurai()).getPos().getX(),
                                    this.gameModel.getSamuraiOfNum(this.gameModel.getCurrentSamurai()).getPos().getY(),
                                    true);
                            for(Integer integer : killedSamurais){
                                this.gameModel.updateKilled(integer);
                            }
                        }
                    }
                }
                break;
            case 1:
                if(this.actionPoint >= 2){
                    if(this.samuraiPOs[this.currentSamurai].move(direction,this.chessBoardModel)){
                        this.gameModel.updatePosition(this.samuraiPOs[this.currentSamurai].getPos());
                        done = true;
                        this.actionPoint -= 2;
                    }
                }
                break;
            case 2:
                if(this.samuraiPOs[this.currentSamurai].getHide()) {
                    if (this.actionPoint >= 1) {
                        if(this.samuraiPOs[this.currentSamurai].show(this.chessBoardModel)) {
                            this.gameModel.updateHide(false);
                            done = true;
                            this.actionPoint -= 1;
                        }
                    }
                }else{
                    if(this.actionPoint >= 1){
                        if(this.samuraiPOs[this.currentSamurai].hide(this.chessBoardModel)) {
                            this.gameModel.updateHide(true);
                            done = true;
                            this.actionPoint -= 1;
                        }
                    }
                }
                break;
            default:
                break;
        }
        if(done){
            this.gameModel.actionPerformed(actionNum);
        }
        if(this.actionPoint == 0){
            this.actionDone();
        }
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

}
