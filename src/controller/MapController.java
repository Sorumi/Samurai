package controller;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import model.GameModel;
import model.po.Position;
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
        this.gamePanel.setSamuraiWeapon(1,storyModel.getSamuraiPO(1).getWeapon().getType());
        this.gamePanel.setSamuraiWeapon(2,storyModel.getSamuraiPO(2).getWeapon().getType());
        this.gamePanel.setSamuraiWeapon(3,storyModel.getSamuraiPO(3).getWeapon().getType());

        for (int i = 1; i <= 3; i++) {
            SamuraiPO tmpPO = storyModel.getSamuraiPO(i);
            this.gamePanel.set6Properties(i,new int[]{tmpPO.getLevel(),999,999,999,999,999});
        }

    }

    public void startGameAtLevel(int level){

        System.out.println("Level: " + level);

        this.gameModel = new GameModel(24, 14, gamePanel, level, this.storyModel.getSamuraiPOs());
        this.gameModel.addObserver(this.gamePanel);
        this.gameModel.getChessBoardModel().addObserver(this.gamePanel);

        for (int i = 1; i <= 3; i++) {
            Position pos = this.gameModel.getSamuraiOfNum(i).getHome();
            this.gameModel.getChessBoardModel().changeActualBlock(pos.getX(), pos.getY(), true);
            this.gameModel.getChessBoardModel().changeActualBlock(pos.getX(), pos.getY(), this.gameModel.getSamuraiOfNum(i).getNumber());
        }

        OperationQueue operationQueue = new OperationQueue(gameModel);
        Thread operationThread = new Thread(operationQueue);
        operationThread.start();

        OperationQueue.addOperation(new StartGameOperation());

    }

}
