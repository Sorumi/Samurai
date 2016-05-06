package controller;

import model.po.Armor;
import model.po.Armory;
import model.po.Weapon;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/4.
 */
public class CampsiteController extends TerritoryController {

    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;

    public void changeWeapon(int samuraiNum, int weaponNum){
        storyModel.changeWeapon(samuraiNum,weaponNum);
    }

    public void setWeaponNum(){
        Armory armory = storyModel.getArmory();
        weapons = armory.checkAllWeapon();
        armors =  armory.checkAllArmor();
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
}
