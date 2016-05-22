package model.po;

import model.ChessBoardModel;
import model.GameModelGuide;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/22.
 */
public class PlayerGuide {

    private GameModelGuide gameModelGuide;
    private SamuraiPO samuraiPO;
    private ChessBoardModel chessBoardModel;

    //classic 和 online 的构造方法
    public PlayerGuide(GameModelGuide model){
        this.gameModelGuide = model;
        this.chessBoardModel = this.gameModelGuide.getChessBoardModel();
        this.samuraiPO = new SamuraiPO(1,0,new Weapon(0),this.gameModelGuide.getLength(),this.chessBoardModel,new Armor());
    }

    public ArrayList<ActualBlock> showVision(){
        ArrayList<ActualBlock> blocks = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        positions.addAll(samuraiPO.see());
        for(Position position : positions){
            blocks.add(this.chessBoardModel.getActualBlock(position.getX(),position.getY()));
            this.chessBoardModel.setActualBlockVisible(position.getX(),position.getY(),true);
        }
        return blocks;
    }

    public ArrayList<Position> pseudoOccupy(int direction){
        return this.samuraiPO.occupied(direction,this.chessBoardModel,false);
    }

    public SamuraiPO getSamuraiPO() {
        return samuraiPO;
    }
}
