package controller;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import model.GameModel;

public class GameController {
    //等着 View 那边传来一个调用哦~
    public boolean handleAction(int actionNum, int direction){
        Operation op = new ActionOperation(actionNum, direction);
        OperationQueue.addOperation(op);
        return true;
    }
}
