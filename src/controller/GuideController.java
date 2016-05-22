package controller;

import model.GameModelGuide;
import view.guide.GameGuidePanel;

/**
 * Created by Kray on 16/5/17.
 */
public class GuideController {

    private static GameModelGuide gameModelGuide;

    public GuideController(GameModelGuide g){
        gameModelGuide = g;
    }

    public static void sendMsg(int actionNum, int direction){
        System.out.println("SM : " +actionNum + " , " + direction);
        gameModelGuide.actionPerformed(actionNum, direction);
    }

    public static void start(){
        gameModelGuide.gameStart();
    }


}
