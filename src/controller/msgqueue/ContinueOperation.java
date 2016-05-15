package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/5/16.
 */
public class ContinueOperation extends Operation {
    public void execute() {
        GameModel model = OperationQueue.getGameModel();
        model.goOn();
    }
}
