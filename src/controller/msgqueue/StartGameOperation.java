package controller.msgqueue;

import model.GameModel;
import model.GameModelService;

/**
 * Created by Kray on 16/3/30.
 */
public class StartGameOperation extends Operation {
    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.gameStart();
    }
}
