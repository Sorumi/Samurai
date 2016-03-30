package controller.msgqueue;

/**
 * Created by Kray on 16/3/30.
 */
public class StartGameOperation extends Operation {
    public void execute(){
        OperationQueue.getGameModel().gameStart();
    }
}
