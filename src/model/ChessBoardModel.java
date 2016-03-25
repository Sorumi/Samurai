package model;

public class ChessBoardModel extends BaseModel {
    private int length;
    private int[][] chessBoardBlock;

    public ChessBoardModel(int length){
        this.length = length;
        this.chessBoardBlock = new int[this.length][this.length];
    }
}
