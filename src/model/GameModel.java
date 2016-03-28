package model;

import model.po.Player;
import model.state.GameResultState;
import model.state.GameState;

public class GameModel extends BaseModel {
    private ChessBoardModel chessBoardModel;
    private GameState gameState;
    private GameResultState gameResultState;
    private int currentSamurai;
    private Player[] players;
    private int currentPlayer;
    private int currentRound;
    private int totalRound;
    private int length;

    public GameModel(int round,int length){
        this.length = length;
        this.chessBoardModel = new ChessBoardModel(this.length);
        this.gameState = GameState.RUN;
        this.currentSamurai = 1;
        this.currentPlayer = 0;
        this.currentRound = 1;
        this.totalRound = round;
        this.players = new Player[2];
        players[0] = new Player(this,0);
        players[1] = new Player(this,1);
    }

    public boolean gameStart(){
        this.assignNext();
        return true;
    }

    //Assign next samurai
    public void assignNext(){
        if(this.currentRound <= this.totalRound) {
            this.players[this.currentPlayer].setEnableToAction();

            //此处加上告诉 view 应该是哪个 samurai 行动的代码
        }else{
            this.gameOver();
        }
    }

    //一个 samurai 一套动作完成时调用此方法
    public void actionDone(){
        this.currentPlayer = (++this.currentPlayer) % 2;
        this.currentRound++;
        this.currentSamurai = (++this.currentSamurai) % 6;

        this.assignNext();
    }

    public boolean gameOver(){
        this.gameState = GameState.OVER;
        return true;
    }

    public int getCurrentSamurai(){
        return this.currentSamurai;
    }

    public int getLength(){
        return this.length;
    }

    public ChessBoardModel getChessBoardModel(){
        return this.chessBoardModel;
    }
}
