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
        gameModelGuide.actionPerformed(actionNum, direction);
    }

    public static void start(){
        gameModelGuide.gameStart();
    }

    public static void pseudoOccupy(boolean isEnter, int direction){
        gameModelGuide.updatePseudo0ccupy(isEnter, direction);
    }

    public static void changeWeapon(int weaponNum){
        gameModelGuide.changeWeapon(weaponNum);
    }

    public static void changeArmor(){
        gameModelGuide.changeArmor();
    }

}
