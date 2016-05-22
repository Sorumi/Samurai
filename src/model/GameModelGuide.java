package model;

import model.po.*;
import view.guide.GameGuidePanel;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/16.
 */
public class GameModelGuide extends BaseModel{

    private int length;
    private ChessBoardModel chessBoardModel;
    private PlayerGuide player;

    public GameModelGuide(GameGuidePanel gameGuidePanel){
//        super();
        this.length = 10;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.chessBoardModel.addObserver(gameGuidePanel.chessBoard);
        this.player = new PlayerGuide(this);
    }

    public boolean gameStart(){
        ArrayList<ActualBlock> blocks = new ArrayList<>();
        for(int x = 0; x <= this.length; x++) {
            for (int y = 0; y <= this.length; y++) {
                blocks.add(this.chessBoardModel.getActualBlock(x, y));
            }
        }

        System.out.println("Guide start!");

        super.updateChange(new UpdateMessage("home",this.player.getSamuraiPO()));

        super.updateChange(new UpdateMessage("vision", blocks));

        this.updateVision();

        return true;
    }

    public void actionPerformed(int actionNum, int direction) {
        //actionNum:动作编号
        //0:occupy 1:move 2:show / hide
        switch (actionNum) {
            case 0:
                this.player.getSamuraiPO().occupied(direction, this.chessBoardModel, true);
                this.updateOccupy(direction);
                break;
            case 1:
                if (this.player.getSamuraiPO().move(direction, this.chessBoardModel)) {
                    this.updatePosition(this.player.getSamuraiPO().getPos());
                }
                break;
            case 2:
                if (this.player.getSamuraiPO().getHide()) {
                    if (this.player.getSamuraiPO().show(this.chessBoardModel)) {
                        this.updateHide(false);
                    }
                } else {
                    if (this.player.getSamuraiPO().hide(this.chessBoardModel)) {
                        this.updateHide(true);
                    }
                }
                break;
            default:
                break;
        }
        this.updateVisible(this.updateVision());
    }

    public void changeWeapon(int weapon){
        //底层改武器
        this.player.getSamuraiPO().changeWeapon(new Weapon(weapon));
        //上层改武器
        super.updateChange(new UpdateMessage("weapon",weapon));
    }

    public void updateOccupy(int direction){
        super.updateChange(new UpdateMessage("samuraiOccupy",direction));
    }

    public void updateHide(boolean isHide){
        super.updateChange(new UpdateMessage("samuraiHide",isHide));
    }

    public ArrayList<ActualBlock> updateVision(){
        ArrayList<ActualBlock> blocks;
        blocks = this.player.showVision();
        super.updateChange(new UpdateMessage("vision", blocks));
        return blocks;
    }

    public void updateVisible(ArrayList<ActualBlock> blocks){
        super.updateChange(new UpdateMessage("visible", blocks));
    }

    public void updatePosition(Position position){
        super.updateChange(new UpdateMessage("samuraiMove",position));
    }

    public void updatePseudo0ccupy(boolean HL, int direction) {
        if(HL) {
            super.updateChange(new UpdateMessage("pseudoOccupy",this.player.pseudoOccupy(direction)));
        }else{
            super.updateChange(new UpdateMessage("a-pseudoOccupy",this.player.pseudoOccupy(direction)));
        }
    }

    public ChessBoardModel getChessBoardModel(){
        return this.chessBoardModel;
    }

    public int getLength() {
        return length;
    }
}



