package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/5/13.
 */
public class SkipOperation extends Operation {

    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.actionDone();
    }

}
