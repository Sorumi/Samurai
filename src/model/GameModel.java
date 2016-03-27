package model;

import model.po.Player;
import model.state.GameResultState;
import model.state.GameState;

public class GameModel extends BaseModel {
    private ChessBoardModel chessBoardModel;
    private GameState gameState;
    private GameResultState gameResultState;
    private static int currentSamurai;
    private Player[] players;
    private int currentRound;
    private int totalRound;

    public GameModel(int round){
        this.chessBoardModel = new ChessBoardModel(15);
        this.gameState = GameState.RUN;
        currentSamurai = 1;
        this.currentRound = 0;
        this.totalRound = round;
        this.players = new Player[2];
    }

    public boolean gameStart(){
        this.assignNext();
        return true;
    }

    public static int getCurrSamurai(){
        return currentSamurai;
    }

    //指派下一个行动的 samurai
    public void assignNext(){
        int playerNum = (currentSamurai / 3);
        Player currPlayer = players[playerNum];
        currPlayer.setEnableToAction();
    }

    //一个 samurai 完成动作了以后
    public void actionDone(){
        this.currentRound++;
        currentSamurai = (currentSamurai++) % 6;
        this.assignNext();
    }

    public boolean gameOver(){
        this.gameState = GameState.OVER;
        return true;
    }


}
