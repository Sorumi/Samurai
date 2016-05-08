package controller;

import model.StoryModel;
import model.po.Weapon;

/**
 * Created by Kray on 16/5/5.
 */

//故事模式中三个Controller的父类
public class TerritoryController{

    private static TerritoryController territoryController;

    protected StoryModel storyModel;

    public void setStoryModel(StoryModel storyModel){
        this.storyModel = storyModel;
    }

    public void save(int n){
        this.storyModel.saveStoryModel(n);
    }

    public StoryModel getStoryModel(){
        return this.storyModel;
    }

    public Weapon getWeaponOfSamurai(int i){
        return this.storyModel.getSamuraiPO(i).getWeapon();
    }

    public static TerritoryController territoryController(){
        if(territoryController == null){
            territoryController = new TerritoryController();
        }
        return territoryController;
    }

}
