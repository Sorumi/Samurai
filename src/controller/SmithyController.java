package controller;

import model.StoryModel;
import model.po.Weapon;

/**
 * Created by Kray on 16/5/4.
 */
public class SmithyController extends TerritoryController{

    public void createWeapon(int weaponNum){
        Weapon weapon = storyModel.getArmory().getWeapon(weaponNum);
        if(weapon.canCreate()){
            if(storyModel.getArmory().buildWeapon(weaponNum,storyModel.getMaterialLibrary())){
                System.out.println("SUCCESS");
            }else{
                System.out.println("FAILURE");
            }
        }
    }

}
