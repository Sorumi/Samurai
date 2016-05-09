package controller;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import model.GameModel;
import model.po.SamuraiPO;
import view.GamePanel;

/**
 * Created by Kray on 16/5/9.
 */
public class MapController extends TerritoryController {

    private GamePanel gamePanel;
    private GameModel gameModel;

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void startGameAtLevel(int level){

        System.out.println("Level: " + level);

        this.gameModel = new GameModel(24, 14, gamePanel, level, this.storyModel.getSamuraiPOs());
        this.gameModel.addObserver(this.gamePanel);
        this.gameModel.getChessBoardModel().addObserver(this.gamePanel);

        OperationQueue operationQueue = new OperationQueue(gameModel);
        Thread operationThread = new Thread(operationQueue);
        operationThread.start();

        OperationQueue.addOperation(new StartGameOperation());

    }

}
