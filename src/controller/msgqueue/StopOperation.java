package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/5/16.
 */

//用来暂停游戏
public class StopOperation extends Operation {
    public void execute() {
        GameModel model = OperationQueue.getGameModel();
        model.stop();
    }
}
