package controller;

import model.po.Armory;

/**
 * Created by Kray on 16/5/4.
 */
public class CampsiteController extends TerritoryController {

    public void changeWeapon(int samuraiNum, int weaponNum){
        storyModel.changeWeapon(samuraiNum,weaponNum);
    }

    public void setWeaponNum(){
        Armory armory = storyModel.getArmory();
        armory.getWeapon(0);
    }

}
