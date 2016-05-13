package controller.msgqueue;

import model.GameModel;
import model.GameModelService;


/**
 * Created by Kray on 16/4/11.
 */
public class NextOperation extends Operation {

    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.assignNextWithAI();
    }

}
