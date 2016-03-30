package controller.msgqueue;

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
        OperationQueue.getGameModel().sendMsg(actionNum,direction);
    }

}
