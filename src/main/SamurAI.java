package main;

import model.ChessBoardModel;
import model.GameModel;
import model.po.Player;

public class SamurAI {

    //2016-03-29 19:00:18 Kray 测试
    public static void main(String[] args) {
        GameModel gameModel = new GameModel(12,14);
        //先动作 再方向
        //actionNum: 0:occupy 1:move 2:show 3:hide
        //direction: 0:up 1:left 2:right 3:down
<<<<<<< HEAD
        //左和右反了???  
        //Sliver Narcissus 修复了这个bug
=======
>>>>>>> 445919af26b3fdfa370990ea871b27ee2894f966
        gameModel.gameStart();

//        while(gameModel.getCanHandle()) {
            gameModel.sendMsg(1, 3);
            gameModel.sendMsg(1, 3);
//        }

//        gameModel.sendMsg(1,1);
//        gameModel.sendMsg(1,2);
//        gameModel.sendMsg(1,0);
//        gameModel.sendMsg(1,0);

//        gameModel.sendMsg(0,3);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,3);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,1);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,2);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,0);
//        gameModel.actionDone();
//        gameModel.sendMsg(0,0);
//        gameModel.actionDone();

    }
}
