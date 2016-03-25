package model;

public class GameModel extends BaseModel {
    private ChessBoardModel chessBoardModel;

    public GameModel(){
        this.chessBoardModel = new ChessBoardModel(15);
    }
}
