package controller;

import model.StoryModel;
import model.po.Weapon;

/**
 * Created by Kray on 16/5/4.
 */
public class CampsiteController {
    private StoryModel storyModel;

    public void changeWeapon(int samuraiNum, int weaponNum){
        this.storyModel.changeWeapon(samuraiNum,weaponNum);
    }

    public void createWeapon(int weaponNum){
        Weapon weapon = storyModel.getArmory().getWeapon(weaponNum);
        if(weapon.canCreate()){
            if(storyModel.getArmory().buildWeapon(weaponNum,storyModel.materialLibrary())){
                System.out.println("SUCCESS");
            }else{
                System.out.println("FAILURE");
            }
        }
    }

    public void setStoryModel(StoryModel storyModel){
        this.storyModel = storyModel;
    }
}
