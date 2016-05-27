package controller;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import controller.msgqueue.StopOperation;
import model.GameModel;
import model.po.Armor;
import model.po.Position;
import model.po.SamuraiPO;
import model.po.Weapon;
import view.GamePanel;

/**
 * Created by Kray on 16/5/25.
 */
public class CustomContoller extends TerritoryController{

    private GameModel gameModel;

    public void startGameWithPos(GamePanel gamePanel, Position[] positions, int[] weapons, int[] armors, int[] levels){

        Weapon[] weapons1 = new Weapon[6];
        Armor[] armors1 = new Armor[6];
        for (int i = 1; i <= 6; i++) {
            System.out.println("W:" + weapons[i] + " A: " + armors[i]);
            weapons1[i-1] = storyModel.getArmory().getWeapon(weapons[i]);
            armors1[i-1] = storyModel.getArmory().getArmor(armors[i] + 900);
        }
        this.gameModel = new GameModel(gamePanel, positions, 20, levels, weapons1, armors1);
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
            //设置六个属性
            SamuraiPO tmpPO = this.gameModel.getSamuraiOfNum(i);
            gamePanel.set6Properties(i,new int[]{tmpPO.getLevel(),tmpPO.getAttackValue()[0],tmpPO.getAttackValue()[1],
                    tmpPO.getArmorValue(),tmpPO.getCriticalHitRate(),tmpPO.getDodgeRate(),tmpPO.getArmorPenetration()});
        }

        OperationQueue operationQueue = new OperationQueue(this.gameModel,gamePanel);
        Thread operationThread = new Thread(operationQueue);
        operationThread.start();

        OperationQueue.addOperation(new StartGameOperation());
    }
}

