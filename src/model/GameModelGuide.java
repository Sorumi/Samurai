package model;

import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.SkipOperation;
import javafx.application.Platform;
import model.po.ActualBlock;
import model.po.Player;
import model.po.Position;
import model.po.PropsInG;
import view.GamePanel;
import view.guide.GameGuidePanel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kray on 16/5/16.
 */
public class GameModelGuide extends GameModel {

    private int length;
    private ChessBoardModel chessBoardModel;

    public GameModelGuide(GameGuidePanel gamePanel){
        super();
        this.length = 10;
        this.players = new Player[1];
        this.players[0] = new Player(this, 0);
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

        System.out.println("Guide start!");

        super.updateChange(new UpdateMessage("home",this.players[0].getSamuraiOfNum(1)));

        super.updateChange(new UpdateMessage("vision", blocks));

        return true;
    }

    public void actionPerformed(int actionNum, int direction) {
        //actionNum:动作编号
        //0:occupy 1:move 2:show / hide
        switch (actionNum) {
            case 0:
                this.players[0].getSamuraiOfNum(1).occupied(direction, this.chessBoardModel, true);
                this.updateOccupy(direction);
                this.updateOccupiedBlocks();
                break;
            case 1:
                if (this.players[0].getSamuraiOfNum(1).move(direction, this.chessBoardModel)) {
                    this.updatePosition(this.players[0].getSamuraiOfNum(1).getPos());
                }
                break;
            case 2:
                if (this.players[0].getSamuraiOfNum(1).getHide()) {
                    if (this.players[0].getSamuraiOfNum(1).show(this.chessBoardModel)) {
                        this.updateHide(false);
                    }
                } else {
                    if (this.players[0].getSamuraiOfNum(1).hide(this.chessBoardModel)) {
                        this.updateHide(true);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void updateOccupy(int direction){
        super.updateChange(new UpdateMessage("samuraiOccupy",direction));
    }

    public void updateHide(boolean isHide){
        super.updateChange(new UpdateMessage("samuraiHide",isHide));
    }

    public ArrayList<ActualBlock> updateVision(){
        ArrayList<ActualBlock> blocks;
        blocks = this.players[0].showVision();
        super.updateChange(new UpdateMessage("vision", blocks));
        return blocks;
    }

    public void updateVisible(ArrayList<ActualBlock> blocks){
        super.updateChange(new UpdateMessage("visible", blocks));
    }

    public void updateOccupiedBlocks(){
        super.updateChange(new UpdateMessage("occupiedBlocks",this.chessBoardModel.getStatesOfAllBlocks()));
    }

    public void updatePosition(Position position){
        super.updateChange(new UpdateMessage("samuraiMove",position));
    }

}



