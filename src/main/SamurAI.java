package main;

import model.GameModel;

public class SamurAI {
    public static void main(String[] args){
        GameModel gameModel = new GameModel(1008);
        gameModel.gameStart();
    }
}
