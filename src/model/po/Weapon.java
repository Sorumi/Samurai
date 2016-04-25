package model.po;


import java.io.Serializable;
import java.util.Random;

public class Weapon implements Cloneable,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int genre;
	private int type;
	private int lowAttackPoint;
	private int highAttackPoint;
	private int criticalRate;
	private int armorPenetration;
	private int[] materialTag;
	private int[] materialItem;
	private int[] materialNumber;
	private boolean canCreate;
	private int number;
	private int[] nextWeapon;

	public Weapon(int genre, int type, int lowAttackPoint, int highAttackPoint, int criticalHitRate,
			int armorPenetration, int[] materialTag, int[] materialItem, int[] materialNumber, boolean canCreate,
			int[] nextWeapon,int number) {
		this.genre = genre;
		this.type = type;
		this.lowAttackPoint = lowAttackPoint;
		this.highAttackPoint = highAttackPoint;
		this.criticalRate = criticalHitRate;
		this.armorPenetration = armorPenetration;
		this.materialTag=materialTag;
		this.materialItem=materialItem;
		this.materialNumber=materialNumber;
		this.canCreate=canCreate;
		this.nextWeapon=nextWeapon;
		this.number=number;
	}

	public Weapon(int genre) {
		this.genre = genre;
	}

	public int getGenre() {
		return genre;
	}

	public int getAttackPoint() {
		int cache = highAttackPoint - lowAttackPoint;
		Random random = new Random();
		return lowAttackPoint + random.nextInt(cache);
	}

	public int getCriticalRate() {
		return criticalRate;
	}

	public int getArmorPenetration() {
		return armorPenetration;
	}

	public int getType() {
		return type;
	}

	public void unlock() {
		canCreate = true;
	}

	public boolean create() {
		number++;
		if (number == 1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean canCreate(){
		return canCreate;
	}
	public int[] getMaterialTag(){
		return materialTag;
	}
	public int[] getMaterialItem(){
		return materialItem;
	}
	public int[] getMaterialNumber(){
		return materialNumber;
	}
	public int[] getNextWeapon(){
		return nextWeapon;
	}

	public Weapon clone() {
		try {
			return (Weapon) super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
