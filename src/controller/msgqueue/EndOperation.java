package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/4/22.
 */
public class EndOperation extends Operation {
    public void execute() {
        GameModel model = OperationQueue.getGameModel();
        model.gameOver();
//        model.
    }
}
