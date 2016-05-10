package controller.msgqueue;

import model.GameModel;
import model.GameModelService;

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

        System.out.println("A-op begin");
        GameModel model = OperationQueue.getGameModel();
        model.sendMsg(actionNum,direction);

        System.out.println("A-op done");
    }

    public int getActionNum(){
        return this.actionNum;
    }

    public int getDirection(){
        return this.direction;
    }

}
