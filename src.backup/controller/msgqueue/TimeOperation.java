package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/4/19.
 */
public class TimeOperation extends Operation{
    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.countDown();
    }
}
