package model.po;

import java.io.Serializable;
import java.util.ArrayList;

public class Armory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Weapon> swordList = new ArrayList<Weapon>();
	private ArrayList<Weapon> spearList = new ArrayList<Weapon>();
	private ArrayList<Weapon> axeList = new ArrayList<Weapon>();
	private ArrayList<Weapon> bowList = new ArrayList<Weapon>();
	private ArrayList<Weapon> shurikenList = new ArrayList<Weapon>();
	private ArrayList<Armor> armorList = new ArrayList<Armor>();

	// 这个方法仅在进入故事模式时调用一次
	public void initialize() {
		// 基础类别初始化

		int[] materialTag = {};
		int[] materialItem = {};
		int[] materialNumber = {};
		int[] nextWeapon = { 112 };
		swordList.add(new Weapon(1, 111, 15, 19, 0, 0, materialTag, materialItem, materialNumber, true, nextWeapon, 1));
		nextWeapon = new int[] { 12 };
		spearList.add(new Weapon(0, 11, 18, 22, 0, 0, materialTag, materialItem, materialNumber, true, nextWeapon, 1));
		nextWeapon = new int[] { 212 };
		axeList.add(new Weapon(2, 211, 14, 19, 0, 0, materialTag, materialItem, materialNumber, true, nextWeapon, 1));
		nextWeapon = new int[] { 312 };
		shurikenList
				.add(new Weapon(3, 311, 20, 25, 5, 0, materialTag, materialItem, materialNumber, true, nextWeapon, 1));
		nextWeapon = new int[] { 412, 422 };
		bowList.add(new Weapon(4, 411, 19, 24, 0, 5, materialTag, materialItem, materialNumber, true, nextWeapon, 1));
		// 矛类初始化

		materialTag = new int[] { 1, 2, 2 };
		materialItem = new int[] { 0, 0, 1 };
		materialNumber = new int[] { 3, 2, 2 };
		nextWeapon = new int[] { 13, 23, 33 };
		spearList.add(new Weapon(0, 12, 32, 37, 0, 8, materialTag, materialItem, materialNumber, true, nextWeapon, 0));
		materialTag = new int[] { 1, 1, 1, 2, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 0 };
		materialNumber = new int[] { 1, 2, 4, 1, 1 };
		nextWeapon = new int[] { 14 };
		spearList
				.add(new Weapon(0, 13, 45, 51, 0, 20, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 1, 1, 2, 3 };
		materialItem = new int[] { 2, 0, 1, 1, 1 };
		materialNumber = new int[] { 1, 4, 2, 1, 1 };
		nextWeapon = new int[] { 14 };
		spearList
				.add(new Weapon(0, 23, 50, 55, 0, 12, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 1, 1, 2, 3 };
		materialItem = new int[] { 2, 0, 1, 1, 1 };
		materialNumber = new int[] { 1, 3, 3, 1, 1 };
		nextWeapon = new int[] { 34 };
		spearList.add(new Weapon(0, 33, 40, 43, 8, 7, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 3, 2, 2, 3, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 1, 3, 1, 2, 4 };
		nextWeapon = new int[] { 15, 25 };
		spearList
				.add(new Weapon(0, 14, 72, 77, 3, 22, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 3, 2, 2, 3, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 1, 1, 3, 4, 2 };
		nextWeapon = new int[] { 35 };
		spearList.add(
				new Weapon(0, 34, 59, 63, 15, 10, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0 };
		materialNumber = new int[] { 2, 2, 3, 7, 2 };
		nextWeapon = new int[] { 16 };
		spearList.add(
				new Weapon(0, 15, 96, 101, 6, 50, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 2, 2, 5, 5, 1, 1 };
		nextWeapon = new int[] { 26 };
		spearList.add(
				new Weapon(0, 25, 117, 125, 6, 30, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 1 };
		materialNumber = new int[] { 2, 2, 7, 3, 2 };
		nextWeapon = new int[] { 36 };
		spearList.add(
				new Weapon(0, 35, 79, 85, 28, 17, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		spearList.add(
				new Weapon(0, 16, 141, 150, 12, 90, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		spearList.add(
				new Weapon(0, 26, 164, 172, 12, 50, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		spearList.add(
				new Weapon(0, 36, 117, 125, 50, 25, materialTag, materialItem, materialNumber, false, nextWeapon, 0));

		// 剑类初始化

		materialTag = new int[] { 1, 2, 2 };
		materialItem = new int[] { 0, 0, 1 };
		materialNumber = new int[] { 3, 2, 2 };
		nextWeapon = new int[] { 113 };
		swordList.add(new Weapon(1, 112, 27, 31, 0, 8, materialTag, materialItem, materialNumber, true, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 2 };
		materialItem = new int[] { 0, 0, 1 };
		materialNumber = new int[] { 3, 1, 3 };
		nextWeapon = new int[] { 133 };
		swordList.add(new Weapon(1, 132, 22, 26, 3, 4, materialTag, materialItem, materialNumber, true, nextWeapon, 0));
		materialTag = new int[] { 1, 1, 1, 2, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 0 };
		materialNumber = new int[] { 1, 3, 3, 1, 1 };
		nextWeapon = new int[] { 124, 114 };
		swordList.add(
				new Weapon(1, 113, 39, 43, 0, 15, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 1, 1, 2, 3 };
		materialItem = new int[] { 2, 0, 1, 1, 1 };
		materialNumber = new int[] { 1, 3, 3, 1, 1 };
		nextWeapon = new int[] { 134 };
		swordList
				.add(new Weapon(1, 133, 32, 36, 8, 7, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 3, 2, 2, 3, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 1, 2, 2, 1, 5 };
		nextWeapon = new int[] { 125 };
		swordList.add(
				new Weapon(1, 124, 57, 64, 2, 30, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 3, 2, 2, 3, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 1, 2, 2, 3, 3 };
		nextWeapon = new int[] { 115 };
		swordList.add(
				new Weapon(1, 114, 70, 77, 2, 20, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 3, 2, 2, 3, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 1, 2, 2, 5, 1 };
		nextWeapon = new int[] { 135 };
		swordList.add(
				new Weapon(1, 134, 47, 51, 15, 12, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0 };
		materialNumber = new int[] { 2, 2, 3, 7, 2 };
		nextWeapon = new int[] { 126 };
		swordList.add(
				new Weapon(1, 125, 80, 88, 5, 45, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0 };
		materialNumber = new int[] { 2, 2, 5, 5, 2 };
		nextWeapon = new int[] { 116 };
		swordList.add(
				new Weapon(1, 115, 97, 111, 5, 28, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 2, 2, 7, 3, 1, 1 };
		nextWeapon = new int[] { 136 };
		swordList.add(
				new Weapon(1, 135, 68, 75, 28, 15, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		swordList.add(
				new Weapon(1, 126, 120, 134, 10, 80, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		swordList.add(
				new Weapon(1, 116, 148, 159, 10, 45, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		swordList.add(
				new Weapon(1, 136, 105, 111, 45, 22, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		// 斧类初始化
		materialTag = new int[] { 1, 2, 2 };
		materialItem = new int[] { 0, 0, 1 };
		materialNumber = new int[] { 3, 2, 2 };
		nextWeapon = new int[] { 213, 233 };
		axeList.add(new Weapon(2, 212, 30, 34, 0, 8, materialTag, materialItem, materialNumber, true, nextWeapon, 0));
		materialTag = new int[] { 1, 1, 1, 2, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 0 };
		materialNumber = new int[] { 1, 2, 4, 1, 1 };
		nextWeapon = new int[] { 214 };
		axeList.add(new Weapon(2, 213, 41, 45, 0, 15, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 1, 1, 2, 3 };
		materialItem = new int[] { 2, 0, 1, 1, 1 };
		materialNumber = new int[] { 1, 4, 2, 1, 1 };
		nextWeapon = new int[] { 234 };
		axeList.add(new Weapon(2, 233, 35, 39, 8, 6, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 3, 2, 2, 3, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 1, 2, 2, 3, 3 };
		nextWeapon = new int[] { 215, 225 };
		axeList.add(new Weapon(2, 214, 73, 80, 2, 20, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 3, 2, 2, 3, 3 };
		materialItem = new int[] { 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 1, 3, 1, 5, 1 };
		nextWeapon = new int[] { 235 };
		axeList.add(
				new Weapon(2, 234, 50, 54, 15, 12, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0 };
		materialNumber = new int[] { 2, 2, 5, 5, 2 };
		nextWeapon = new int[] { 216 };
		axeList.add(
				new Weapon(2, 215, 97, 107, 5, 28, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0 };
		materialNumber = new int[] { 2, 2, 3, 7, 2 };
		nextWeapon = new int[] { 226 };
		axeList.add(new Weapon(2, 225, 82, 90, 5, 45, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 2, 3, 3, 3, 4, 4 };
		materialItem = new int[] { 2, 2, 0, 1, 0, 1 };
		materialNumber = new int[] { 2, 2, 7, 3, 1, 1 };
		nextWeapon = new int[] { 236 };
		axeList.add(
				new Weapon(2, 235, 67, 73, 30, 15, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		axeList.add(
				new Weapon(2, 216, 150, 161, 10, 45, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		axeList.add(
				new Weapon(2, 226, 125, 137, 10, 80, materialTag, materialItem, materialNumber, false, nextWeapon, 0));
		materialTag = new int[] { 1, 2, 3, 4 };
		materialItem = new int[] { 4, 4, 4, 3 };
		materialNumber = new int[] { 1, 1, 1, 1 };
		nextWeapon = new int[] {};
		axeList.add(
				new Weapon(2, 236, 112, 120, 45, 25, materialTag, materialItem, materialNumber, false, nextWeapon, 0));

		// 手里剑类初始化

		// 弓类初始化

		// 护甲初始化
		materialTag = new int[] {};
		materialItem = new int[] {};
		materialNumber = new int[] {};
		int[] nextArmor = { 912 };
		armorList.add(new Armor(911, 5, 2, materialTag, materialItem, materialNumber, true, nextArmor, 3));
	}

	public Weapon getWeapon(int type) {
		switch (type / 100) {
		case 0:
			for (Weapon weapon : spearList) {
				if (weapon.getType() == type) {
					return weapon;
				}
			}
			break;
		case 1:
			for (Weapon weapon : swordList) {
				if (weapon.getType() == type) {
					return weapon;
				}
			}
			break;
		case 2:
			for (Weapon weapon : axeList) {
				if (weapon.getType() == type) {
					return weapon;
				}
			}
			break;
		case 3:
			for (Weapon weapon : bowList) {
				if (weapon.getType() == type) {
					return weapon;
				}
			}
			break;
		case 4:
			for (Weapon weapon : shurikenList) {
				if (weapon.getType() == type) {
					return weapon;
				}
			}
			break;
		default:
			System.out.println("No such weapon!");
			break;
		}
		System.out.println("No such weapon!");
		return null;
	}
	public ArrayList<Armor> checkAllArmor() {
		ArrayList<Armor> armors=new ArrayList<Armor>();
		for(Armor armor:armorList){
			if(armor.getNumber()>0){
				armors.add(armor);
			}
		}
		return armors;
	}

	public ArrayList<Weapon> checkAllWeapon() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		for(Weapon weapon:spearList){
			if(weapon.getNumber()>0){
				weapons.add(weapon);
			}
		}
		for(Weapon weapon:swordList){
			if(weapon.getNumber()>0){
				weapons.add(weapon);
			}
		}
		for(Weapon weapon:axeList){
			if(weapon.getNumber()>0){
				weapons.add(weapon);
			}
		}
		for(Weapon weapon:shurikenList){
			if(weapon.getNumber()>0){
				weapons.add(weapon);
			}
		}
		for(Weapon weapon:bowList){
			if(weapon.getNumber()>0){
				weapons.add(weapon);
			}
		}
		return weapons;
	}

	public Armor getArmor(int type) {
		for (Armor armor : armorList) {
			if (armor.getType() == type) {
				return armor;
			}
		}
		return null;
	}

	// 制造武器的方法 如果制造成功 返回true 否则返回false
	public boolean buildWeapon(int type, MaterialLibrary materialLibrary) {
		Weapon weapon = getWeapon(type);
		if (weapon.canCreate()) {
			if (materialLibrary.checkEnough(weapon.getMaterialTag(), weapon.getMaterialItem(),
					weapon.getMaterialNumber())) {
				// 材料够，开始制造
				for (int i = 0; i < weapon.getMaterialTag().length; i++) {
					materialLibrary.changeItem(weapon.getMaterialTag()[i], weapon.getMaterialItem()[i],
							-weapon.getMaterialNumber()[i]);
				}
				// 减材料
				if (weapon.create()) {
					for (int nextWeapon : weapon.getNextWeapon()) {
						getWeapon(nextWeapon).unlock();
					}
				}
				return true;
				// 判断是否要解锁
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean buildArmor(int type, MaterialLibrary materialLibrary) {
		Armor armor = getArmor(type);
		if (armor.canCreate()) {
			if (materialLibrary.checkEnough(armor.getMaterialTag(), armor.getMaterialItem(),
					armor.getMaterialNumber())) {
				// 材料够，开始制造
				for (int i = 0; i < armor.getMaterialTag().length; i++) {
					materialLibrary.changeItem(armor.getMaterialTag()[i], armor.getMaterialItem()[i],
							-armor.getMaterialNumber()[i]);
				}
				// 减材料
				if (armor.create()) {
					for (int nextArmor : armor.getNextArmor()) {
						getArmor(nextArmor).unlock();
					}
				}
				return true;
				// 判断是否要解锁
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
