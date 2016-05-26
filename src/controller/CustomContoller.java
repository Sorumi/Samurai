package controller;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import controller.msgqueue.StopOperation;
import model.GameModel;
import model.po.Position;
import model.po.SamuraiPO;
import model.po.Weapon;
import view.GamePanel;

/**
 * Created by Kray on 16/5/25.
 */
public class CustomContoller extends TerritoryController{

    private GameModel gameModel;

    public void startGameWithPos(GamePanel gamePanel, Position[] positions, int[] weapons, int[] armors){

        this.gameModel = new GameModel(gamePanel, positions, 20, new int[]{1,2,3});
        this.gameModel.addObserver(gamePanel);
        this.gameModel.getChessBoardModel().addObserver(gamePanel);

        for (int i = 1; i <= 6; i++) {
            //更新家的位置
            Position pos = this.gameModel.getSamuraiOfNum(i).getHome();
            this.gameModel.getChessBoardModel().changeActualBlock(pos.getX(), pos.getY(), true);
            this.gameModel.getChessBoardModel().changeActualBlock(pos.getX(), pos.getY(), this.gameModel.getSamuraiOfNum(i).getNumber());
            //更新武士武器和护甲
            gamePanel.setSamuraiWeapon(i, weapons[i]);
            gamePanel.setSamuraiArmor(i, armors[i]);
            this.gameModel.getSamuraiOfNum(i).changeWeapon(storyModel.getArmory().getWeapon(weapons[i]));
            this.gameModel.getSamuraiOfNum(i).changeArmor(storyModel.getArmory().getArmor(armors[i]));
        }

        OperationQueue operationQueue = new OperationQueue(this.gameModel,gamePanel);
        Thread operationThread = new Thread(operationQueue);
        operationThread.start();

        OperationQueue.addOperation(new StartGameOperation());
    }
}

