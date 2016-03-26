package model;

public class GameModel extends BaseModel {
    private ChessBoardModel chessBoardModel;
//    private

    public GameModel(){
        this.chessBoardModel = new ChessBoardModel(15);
    }
}
