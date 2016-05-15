package controller;

import model.po.Armor;
import model.po.Armory;
import model.po.Information;
import model.po.Weapon;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/4.
 */
public class SmithyController extends TerritoryController {

	public void createWeapon(int num) {
		if(num/100 != 9){
			Weapon weapon = storyModel.getArmory().getWeapon(num);
			if (weapon.canCreate()) {
				if (storyModel.getArmory().buildWeapon(num, storyModel.getMaterialLibrary())) {
					System.out.println("SUCCESS");
				} else {
					System.out.println("FAILURE");
				}
			}
		}else{
			Armor armor = storyModel.getArmory().getArmor(num);
			if (armor.canCreate()) {
				if (storyModel.getArmory().buildArmor(num, storyModel.getMaterialLibrary())) {
					System.out.println("SUCCESS");
				} else {
					System.out.println("FAILURE");
				}
			}
		}
		
	}

	public int getNumOfMaterialOfTag(int tag) {
		return storyModel.getMaterialLibrary().getNumber(tag);
	}

	public ArrayList<Armor> getUnlockedArmors() {
		return storyModel.getArmory().checkAllAvailableArmor();
	}

	public ArrayList<Weapon> getUnlockedWeapons() {
		return storyModel.getArmory().checkAllAvailableWeapon();
	}

	public Information getInformationOfTag(int tag) {
		return storyModel.getInformationLibrary().getInformationOfTag(tag);
	}

	public Weapon getWeaponOfTag(int tag) {
		return storyModel.getArmory().getWeapon(tag);
	}

	public Armor getArmorOfTag(int tag) {
		return storyModel.getArmory().getArmor(tag);
	}
}
