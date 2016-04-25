package model.po;

import java.io.Serializable;
import java.util.ArrayList;

public class Armory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Weapon> swordList = new ArrayList<Weapon>();
	private ArrayList<Weapon> spearList = new ArrayList<Weapon>();
	private ArrayList<Weapon> axeList = new ArrayList<Weapon>();
	private ArrayList<Weapon> bowList = new ArrayList<Weapon>();
	private ArrayList<Weapon> shurikenList = new ArrayList<Weapon>();

	// 这个方法仅在进入故事模式时调用一次
	public void initialize() {
		int[] materialTag = {};
		int[] materialItem = {};
		int[] materialNumber = {};
		int[] nextWeapon = { 112 };
		swordList.add(new Weapon(1, 111, 15, 19, 0, 0, materialTag, materialItem, materialNumber, true, nextWeapon, 1));
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

	public boolean buildWeapon(int type, MaterialLibrary materialLibrary) {
		Weapon weapon = getWeapon(type);
		if (weapon.canCreate()) {
			if (materialLibrary.checkEnough(weapon.getMaterialTag(), weapon.getMaterialItem(),
					weapon.getMaterialNumber())) {
				//材料够，开始制造
				for (int i = 0; i < weapon.getMaterialTag().length; i++) {
					materialLibrary.changeItem(weapon.getMaterialTag()[i], weapon.getMaterialItem()[i],
							weapon.getMaterialNumber()[i]);
				}
				//减材料
				if (weapon.create()) {
					for (int nextWeapon : weapon.getNextWeapon()) {
						getWeapon(nextWeapon).unlock();
					}
				} 
				return true;
				//判断是否要解锁
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
