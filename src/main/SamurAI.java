package main;

import controller.GameController;
import controller.MenuController;
import controller.msgqueue.OperationQueue;
import model.GameModel;
import model.UpdateMessage;
import view.MainFrame;
import view.TestView;

public class SamurAI {
	
	private static MainFrame mainFrame;
	private static GameModel gameModel;

    public static void main(String[] args) {
        //先动作 再方向
        //actionNum: 0:occupy 1:move 2:show / hide
        //direction: 0:up 1:left 2:right 3:down
        //左和右反了???
        //Sliver Narcissus 修复了这个bug

        mainFrame = new MainFrame();
        gameModel = new GameModel(24,14,mainFrame,true);

        gameModel.addObserver(mainFrame.gamePanel);
        gameModel.getChessBoardModel().addObserver(mainFrame.gamePanel);
        MenuController menuController = new MenuController();
        GameController gameController = new GameController();

        OperationQueue operationQueue = new OperationQueue(gameModel);
        Thread operationThread = new Thread(operationQueue);
        operationThread.start();

        menuController.startGame();
    
        //界面交互测试方法 by Sorumi
        //所有界面接收消息的测试放在TestView中 这里无需改动
//        TestView testView = new TestView();
//        testView.addObserver(mainFrame.gamePanel.chessBoard);
//        testView.test();
    }
}
