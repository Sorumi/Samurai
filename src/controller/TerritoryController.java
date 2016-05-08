package controller;

import model.StoryModel;
import model.po.Weapon;

/**
 * Created by Kray on 16/5/5.
 */

//故事模式中三个Controller的父类
public class TerritoryController{

    protected StoryModel storyModel;

    public void setStoryModel(StoryModel storyModel){
        this.storyModel = storyModel;
    }

    public void save(){
        this.storyModel.saveStoryModel();
    }

    public Weapon getWeaponOfSamurai(int i){
        return this.storyModel.getSamuraiPO(i).getWeapon();
    }

}
