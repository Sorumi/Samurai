package model;

import model.po.BlockPO;
import model.state.ActualBlockState;

public class ChessBoardModel extends BaseModel {
    private int length;
    private BlockPO[][] chessBoardBlock;
    //类型要换一下

    public ChessBoardModel(int length){
        this.length = length;
        this.chessBoardBlock = new BlockPO[this.length][this.length];
    }

    public void setBlockState(int x, int y, ActualBlockState state){
        this.chessBoardBlock[x][y].setActualBlockState(state);
    }
}
