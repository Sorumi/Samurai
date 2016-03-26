package model;

import model.state.GameResultState;
import model.state.GameState;

public class GameModel extends BaseModel {
    private ChessBoardModel chessBoardModel;
    private GameState gameState;
    private GameResultState gameResultState;
    private int currentSamurai;
//    private Player[] players
    private int round;

    public GameModel(){
        this.chessBoardModel = new ChessBoardModel(15);
        this.gameState = GameState.RUN;
        this.currentSamurai = 0;
        this.round = 1008;
    }

    public boolean gameStart(){

        return true;
    }

    public boolean gameOver(){

        return true;
    }
}
