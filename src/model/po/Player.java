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
    private ChessBoardModel chessBoardModel;
    private int actionPoint;

    public Player(GameModel model,int playerNum){
        this.canAction = false;
        this.playerNum = playerNum;
        this.gameModel = model;
        this.chessBoardModel = this.gameModel.getChessBoardModel();
        this.samuraiPOs = new SamuraiPO[7];
        if(playerNum == 0){
            samuraiPOs[1] = new SamuraiPO(1,playerNum,0,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[4] = new SamuraiPO(4,playerNum,1,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[5] = new SamuraiPO(5,playerNum,2,this.gameModel.getLength(),this.chessBoardModel);
        }else if(playerNum == 1){
            samuraiPOs[2] = new SamuraiPO(2,playerNum,0,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[3] = new SamuraiPO(3,playerNum,1,this.gameModel.getLength(),this.chessBoardModel);
            samuraiPOs[6] = new SamuraiPO(6,playerNum,2,this.gameModel.getLength(),this.chessBoardModel);
        }
    }

    public void setEnableToAction(){
        this.canAction = true;
        this.currentSamurai = gameModel.getCurrentSamurai();
        this.actionPoint = 7;
    }

    //当view做出动作的时候 调用这个方法
    //actionNum: 0:occupy 1:move 2:show 3:hide
    //direction: 0:up 1:left 2:right 3:down
    public void actionPerformed(int actionNum, int direction){
        if(this.canAction){
            //actionNum:动作编号
            boolean done = false;
            switch (actionNum){
                //要加上更新 view 的代码
                case 0:
                    if(this.actionPoint >= 4){
                        if(this.samuraiPOs[this.currentSamurai].occupied(direction,this.chessBoardModel)) {
                            done = true;
                            this.actionPoint -= 4;
                            //加上检测需不需要把别人踢回去的代码
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
                    if(this.actionPoint >= 1){
                        if(this.samuraiPOs[this.currentSamurai].show(this.chessBoardModel)) {
                            done = true;
                            this.actionPoint -= 1;
                        }
                    }
                    break;
                case 3:
                    if(this.actionPoint >= 1){
                        if(this.samuraiPOs[this.currentSamurai].hide(this.chessBoardModel)) {
                            done = true;
                            this.actionPoint -= 1;
                        }
                    }
                    break;
                default:
                    break;
            }
            if(!done){
                System.out.println("Action NOT Performed.");
            }
            System.out.println("ActionPoint Left:" + actionPoint);
        }

        //打印一下棋盘
        for (int i = 0; i <= this.gameModel.getLength(); i++) {
            if(i < 10)  System.out.print(" ");
            System.out.print(i + ":");
            for (int x = 0; x <= this.gameModel.getLength(); x++) {
                System.out.print(this.chessBoardModel.getActualBlockState(i, x) + " ");
            }
            System.out.println();
        }
        for (int i = 0; i <= this.gameModel.getLength(); i++) {
            if(i < 10)  System.out.print(" ");
            System.out.print(i + ":");
            for (int x = 0; x <= this.gameModel.getLength(); x++) {
                System.out.print(this.chessBoardModel.getActualBlockOccupied(i, x) + " ");
            }
            System.out.println();
        }
    }

    //时间到了或者没点数的时候调用此方法
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

    public boolean canAction(){
        return this.canAction;
    }

}
