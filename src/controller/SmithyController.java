package controller;

import model.po.Armor;
import model.po.Armory;
import model.po.Information;
import model.po.Weapon;

import java.util.ArrayList;

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


    public ArrayList<Armor> getArmors() {
        return storyModel.getArmory().checkAllArmor();
    }

    public ArrayList<Weapon> getWeapons() {
        return storyModel.getArmory().checkAllWeapon();
    }

    public Information getInformationOfTag(int tag){
        return storyModel.getInformationLibrary().getInformationOfTag(tag);
    }

    public Weapon getWeaponOfTag(int tag){
        return storyModel.getArmory().getWeapon(tag);
    }

}
