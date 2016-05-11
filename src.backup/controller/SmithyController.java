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
    
    public int getNumOfMaterialOfTag(int tag){
        return storyModel.getMaterialLibrary().getNumber(tag);
    }

    public ArrayList<Armor> getUnlockedArmors() {
        return storyModel.getArmory().checkAllAvailableArmor();
    }

    public ArrayList<Weapon> getUnlockedWeapons() {
        return storyModel.getArmory().checkAllAvailableWeapon();
    }

    public Information getInformationOfTag(int tag){
        return storyModel.getInformationLibrary().getInformationOfTag(tag);
    }

    public Weapon getWeaponOfTag(int tag){
        return storyModel.getArmory().getWeapon(tag);
    }

}
