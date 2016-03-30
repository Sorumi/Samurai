package main;

import controller.GameController;
import controller.MenuController;
import controller.msgqueue.OperationQueue;
import model.GameModel;
import view.MainFrame;

public class SamurAI {

    //2016-03-29 19:00:18 Kray 测试
    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();

        GameModel gameModel = new GameModel(12,14);
        gameModel.addObserver(mainFrame);
        MenuController menuController = new MenuController();
        GameController gameController = new GameController();

        //先动作 再方向
        //actionNum: 0:occupy 1:move 2:show 3:hide
        //direction: 0:up 1:left 2:right 3:down
        //左和右反了???
        //Sliver Narcissus 修复了这个bug
        OperationQueue operationQueue = new OperationQueue(gameModel);
        Thread operationThread = new Thread(operationQueue);
        operationThread.start();

        menuController.startGame();

        //暂时扮演 view 发消息的角色
        gameController.handleAction(1,3);

//        gameModel.gameStart();

//        gameModel.sendMsg(1, 3);
//        gameModel.sendMsg(1, 3);

//        gameModel.sendMsg(1,1);
//        gameModel.sendMsg(1,2);
//        gameModel.sendMsg(1,0);
//        gameModel.sendMsg(1,0);

//        gameModel.sendMsg(0,3);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,3);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,1);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,2);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,0);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,0);
//        gameModel.actionDone();

    }
}
