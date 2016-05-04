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

    public void setStoryModel(StoryModel storyModel){
        this.storyModel = storyModel;
    }

    public void save(){
        this.storyModel.saveStoryModel();
    }

}
