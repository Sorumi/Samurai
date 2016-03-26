package model;

public class ChessBoardModel extends BaseModel {
    private int length;
    private int[][] chessBoardBlock;
    //类型要换一下

    public ChessBoardModel(int length){
        this.length = length;
        this.chessBoardBlock = new int[this.length][this.length];
    }
}
