package model;

import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.SkipOperation;
import model.po.ActualBlock;
import view.GamePanel;
import view.guide.GameGuidePanel;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/16.
 */
public class GameModelGuide extends GameModel {

    private int length;
    private ChessBoardModel chessBoardModel;

    public GameModelGuide(GameGuidePanel gamePanel){
        super();
        this.length = 11;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.chessBoardModel.addObserver(gamePanel.chessBoard);
    }

    public boolean gameStart(){
        ArrayList<ActualBlock> blocks = new ArrayList<>();
        for(int x = 0; x <= this.length; x++) {
            for (int y = 0; y <= this.length; y++) {
                blocks.add(this.chessBoardModel.getActualBlock(x, y));
            }
        }

        super.updateChange(new UpdateMessage("vision", blocks));

        for (int i = 1; i <= 6; i++) {
            updateHome(i);
        }

        this.assignNext();

        return true;
    }

    public void assignNext(){

        this.getSamuraiOfNum(this.getCurrentSamurai()).setActionPoint(this.getSamuraiOfNum(this.getCurrentSamurai()).getTotalActionPoint());

        players[0].setEnableToAction();

        super.updateChange(new UpdateMessage("player",players[0]));
        super.updateChange(new UpdateMessage("samurai",getSamuraiOfNum(0)));
        super.updateChange(new UpdateMessage("round",1));
        super.updateChange(new UpdateMessage("pointsTotal", getSamuraiOfNum(getCurrentSamurai()).getTotalActionPoint()));
        super.updateChange(new UpdateMessage("actionPoint",getSamuraiOfNum(getCurrentSamurai()).getActionPoint()));

    }

}
