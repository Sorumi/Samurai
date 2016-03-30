package controller;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;

/**
 * Created by Kray on 16/3/30.
 */
public class MenuController {
    public boolean startGame() {
        OperationQueue.addOperation(new StartGameOperation());
        return true;
    }
}
