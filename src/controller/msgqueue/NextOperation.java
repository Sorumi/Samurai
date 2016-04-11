package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/4/11.
 */
public class NextOperation extends Operation {
    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.actionDone();
    }
}
