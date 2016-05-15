package controller;

import model.StoryModel;
import model.po.Armor;
import model.po.SamuraiPO;
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

    public Armor getArmorOfSamurai(int i){
        return this.storyModel.getSamuraiPO(i).getArmor();
    }

    public static TerritoryController territoryController(){
        if(territoryController == null){
            territoryController = new TerritoryController();
        }
        return territoryController;
    }

    public int[] get6Properties(int samurai){
        SamuraiPO tmpPO  = this.storyModel.getSamuraiPO(samurai);
        return new int[]{tmpPO.getLevel(),tmpPO.getAttackValue()[0],tmpPO.getAttackValue()[1],tmpPO.getArmorValue(),
                tmpPO.getCriticalHitRate(),tmpPO.getDodgeRate(),tmpPO.getArmorPenetration()};
    }

    public int getBlood(int samurai){
        return this.storyModel.getSamuraiPO(samurai).getTotalHealthPoint();
    }

}
