package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/5/14.
 */
public class PropOperation extends Operation {

    private int propNumber;

    public PropOperation(int i){
        this.propNumber = i;
    }

    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.useProp(this.propNumber);
    }
}
