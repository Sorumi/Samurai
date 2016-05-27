package model.po;

import controller.TerritoryController;
import controller.msgqueue.NextOperation;
import controller.msgqueue.OperationQueue;
import model.ChessBoardModel;
import model.GameModel;
import model.StoryModel;
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

    //classic 和 online 的构造方法
    public Player(GameModel model, int playerNum){
        this.playerNum = playerNum;
        this.gameModel = model;
        this.chessBoardModel = this.gameModel.getChessBoardModel();
        System.out.println(this.chessBoardModel.getLength() + "!");
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

    //故事模式中带SamuraiPO的人类方构造方法
    public Player(GameModel model, int playerNum, SamuraiPO[] sPOs){
        this.playerNum = playerNum;
        this.gameModel = model;
        this.chessBoardModel = this.gameModel.getChessBoardModel();
        this.samuraiPOs = new SamuraiPO[7];
        if(playerNum == 0){
            this.samuraiPOs[1] = sPOs[1];
            this.samuraiPOs[2] = sPOs[2];
            this.samuraiPOs[3] = sPOs[3];
        }else if(playerNum == 1) {
            this.samuraiPOs[4] = sPOs[0];
            this.samuraiPOs[5] = sPOs[1];
            this.samuraiPOs[6] = sPOs[2];
        }
    }

    //自定义模式构造方法
    public Player(GameModel model, int playerNum, Position[] positions, int[] level, Weapon[] weapons, Armor[] armors){
        this.playerNum = playerNum;
        this.gameModel = model;
        this.chessBoardModel = this.gameModel.getChessBoardModel();
        this.samuraiPOs = new SamuraiPO[7];
        if(playerNum == 0){
            this.samuraiPOs[1] = new SamuraiPO(1,playerNum,weapons[0],this.gameModel.getLength(),this.chessBoardModel, armors[0], positions[1], level[0]);
            this.samuraiPOs[2] = new SamuraiPO(2,playerNum,weapons[1],this.gameModel.getLength(),this.chessBoardModel, armors[1], positions[2], level[1]);
            this.samuraiPOs[3] = new SamuraiPO(3,playerNum,weapons[2],this.gameModel.getLength(),this.chessBoardModel, armors[2], positions[3], level[2]);
        }else if(playerNum == 1) {
            this.samuraiPOs[4] = new SamuraiPO(4,playerNum,weapons[3],this.gameModel.getLength(),this.chessBoardModel, armors[3], positions[4], level[0]);
            this.samuraiPOs[5] = new SamuraiPO(5,playerNum,weapons[4],this.gameModel.getLength(),this.chessBoardModel, armors[4], positions[5], level[1]);
            this.samuraiPOs[6] = new SamuraiPO(6,playerNum,weapons[5],this.gameModel.getLength(),this.chessBoardModel, armors[5], positions[6], level[2]);
        }
    }

    public void setEnableToAction(){
        this.currentSamurai = gameModel.getCurrentSamurai();
//        this.gameModel.actionPerformed(0);
//        this.samuraiPOs[this.currentSamurai].setActionPoint(this.samuraiPOs[this.currentSamurai].getTotalActionPoint());
//        this.gameModel.updateVisible(this.gameModel.updateVision());
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
                if(this.samuraiPOs[this.currentSamurai].getActionPoint() >= 4){
                    ArrayList<Position> positions
                            = this.samuraiPOs[this.currentSamurai].occupied(direction,this.chessBoardModel,true);
                    if(!positions.isEmpty()) {
                        this.gameModel.updateOccupy(direction);
                        this.gameModel.updateOccupiedBlocks();
                        done = true;
                        this.samuraiPOs[this.currentSamurai].changeActionPoint(4);
                        //检测需不需要把别人踢回去
                        ArrayList<Integer> killedSamurais = new ArrayList<>();
                        for(Position position : positions){
                            if(this.playerNum == 0){
                                if(position.getX() == this.gameModel.getSamuraiOfNum(4).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(4).getPos().getY()){
                                    if(!killedSamurais.contains(4)) {
                                        killedSamurais.add(4);
                                    }

//                                    this.gameModel.getChessBoardModel().changeActualBlock(
//                                            this.gameModel.getSamuraiOfNum(4).getHome().getX(),
//                                            this.gameModel.getSamuraiOfNum(4).getHome().getY(),
//                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(5).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(5).getPos().getY()){
                                    if(!killedSamurais.contains(5)) {
                                        killedSamurais.add(5);
                                    }

//                                    this.gameModel.getChessBoardModel().changeActualBlock(
//                                            this.gameModel.getSamuraiOfNum(5).getHome().getX(),
//                                            this.gameModel.getSamuraiOfNum(5).getHome().getY(),
//                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(6).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(6).getPos().getY()){
                                    if(!killedSamurais.contains(6)) {
                                        killedSamurais.add(6);
                                    }

//                                    this.gameModel.getChessBoardModel().changeActualBlock(
//                                            this.gameModel.getSamuraiOfNum(6).getHome().getX(),
//                                            this.gameModel.getSamuraiOfNum(6).getHome().getY(),
//                                            false);
                                }
                            }else{
                                if(position.getX() == this.gameModel.getSamuraiOfNum(1).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(1).getPos().getY()){
                                    if(!killedSamurais.contains(1)) {
                                        killedSamurais.add(1);
                                    }

//                                    this.gameModel.getChessBoardModel().changeActualBlock(
//                                            this.gameModel.getSamuraiOfNum(1).getHome().getX(),
//                                            this.gameModel.getSamuraiOfNum(1).getHome().getY(),
//                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(2).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(2).getPos().getY()){
                                    if(!killedSamurais.contains(2)) {
                                        killedSamurais.add(2);
                                    }
//                                    this.gameModel.getChessBoardModel().changeActualBlock(
//                                            this.gameModel.getSamuraiOfNum(2).getHome().getX(),
//                                            this.gameModel.getSamuraiOfNum(2).getHome().getY(),
//                                            false);
                                }
                                if(position.getX() == this.gameModel.getSamuraiOfNum(3).getPos().getX()
                                        && position.getY() == this.gameModel.getSamuraiOfNum(3).getPos().getY()){
                                    if(!killedSamurais.contains(3)) {
                                        killedSamurais.add(3);
                                    }
//                                    this.gameModel.getChessBoardModel().changeActualBlock(
//                                            this.gameModel.getSamuraiOfNum(3).getHome().getX(),
//                                            this.gameModel.getSamuraiOfNum(3).getHome().getY(),
//                                            false);
                                }
                            }
                        }
                        //去发消息:哪些人被杀了
                        if(killedSamurais.size() > 0) {

//                            this.gameModel.getChessBoardModel().changeActualBlock(
//                                    this.gameModel.getSamuraiOfNum(this.gameModel.getCurrentSamurai()).getPos().getX(),
//                                    this.gameModel.getSamuraiOfNum(this.gameModel.getCurrentSamurai()).getPos().getY(),
//                                    true);

                            for(Integer integer : killedSamurais){

//                                try{
//                                    Thread.sleep(1000);
//                                }catch (Exception e){
//                                    e.printStackTrace();
//                                }

                                if(this.gameModel.getLevel() < 99 && this.gameModel.getLevel() > 0){
                                    int[] attackPoint = this.gameModel.getSamuraiOfNum(this.currentSamurai).getAttackPoint();
                                    if(this.gameModel.attackSamurai(integer, attackPoint[0], attackPoint[1], attackPoint[2]) < 0){
                                        this.gameModel.updateHome(integer);
                                        this.gameModel.updateVisible(this.gameModel.updateVision());
                                        this.gameModel.getSamuraiOfNum(integer).beKilled(this.chessBoardModel);
                                        this.gameModel.getSamuraiOfNum(this.gameModel.getCurrentSamurai()).updateKillNum(1);
                                        this.gameModel.updateKilled(integer);
                                    }
                                    //要更新血量
                                    this.gameModel.updateHealthPoint(integer);
                                }else {
                                    this.gameModel.updateHome(integer);
                                    this.gameModel.updateVisible(this.gameModel.updateVision());
                                    this.gameModel.updateKilled(integer);
                                }

                            }
                        }
                    }
                }
                break;
            case 1:
                if(this.samuraiPOs[this.currentSamurai].getActionPoint() >= 2){
                    if(this.samuraiPOs[this.currentSamurai].move(direction,this.chessBoardModel)){
                        this.gameModel.updatePosition(this.samuraiPOs[this.currentSamurai].getPos());
                        done = true;
                        this.samuraiPOs[this.currentSamurai].changeActionPoint(2);
                    }
                }
                break;
            case 2:
                int i = 1;
                if(this.gameModel.getLevel() == 99 || this.gameModel.getLevel() == 0){
                    i = 1;
                }else {
                    i = 3;
                }
                if(this.samuraiPOs[this.currentSamurai].getHide()) {
                    if (this.samuraiPOs[this.currentSamurai].getActionPoint() >= i) {
                        if(this.samuraiPOs[this.currentSamurai].show(this.chessBoardModel)) {
                            this.gameModel.updateHide(false);
                            done = true;
                            this.samuraiPOs[this.currentSamurai].changeActionPoint(i);
                        }
                    }
                }else{
                    if(this.samuraiPOs[this.currentSamurai].getActionPoint() >= i){
                        if(this.samuraiPOs[this.currentSamurai].hide(this.chessBoardModel)) {
                            this.gameModel.updateHide(true);
                            done = true;
                            this.samuraiPOs[this.currentSamurai].changeActionPoint(i);
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

        if(this.samuraiPOs[this.currentSamurai].getActionPoint() == 0){
            //这是为了点数没了的时候可以播放完动画
            try{
                Thread.sleep(1200);
            }catch (Exception e){
                e.printStackTrace();
            }

            //若是人类操纵,那么点数为零的时候自动跳转下一局
            if(this.playerNum == 0) {

                this.actionDone();
            }

        }
    }

    public ArrayList<Position> pseudoOccupy(int direction){
        return this.samuraiPOs[this.currentSamurai].occupied(direction,this.chessBoardModel,false);
    }

    //时间到了或者没点数或者玩家主动放弃的时候调用此方法
    public void actionDone(){
//        OperationQueue.addOperation(new NextOperation(true));
        this.gameModel.actionDone();
    }

    public int getPlayerNum(){
        return this.playerNum;
    }

    public SamuraiPO getSamuraiOfNum(int num){
        return samuraiPOs[num];
    }

    public void setSamuraiPOs(SamuraiPO[] samuraiPOs) {
        this.samuraiPOs = samuraiPOs;
    }

}
