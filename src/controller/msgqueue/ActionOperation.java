package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/3/30.
 */
public class ActionOperation extends Operation{

    private int actionNum;
    private int direction;

    public ActionOperation(int actionNum, int direction) {
        this.actionNum = actionNum;
        this.direction = direction;
    }

    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.sendMsg(actionNum,direction);
    }

    public int getActionNum(){
        return this.actionNum;
    }

    public int getDirection(){
        return this.direction;
    }

}
