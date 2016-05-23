package model.po;

import java.io.Serializable;
import java.util.Random;

public class Weapon implements Cloneable, Serializable {
	/**
	 * 
	 */
	// canCreate 表示这个武器可以被制造
	// nextWeapon 指示这个武器之后可以解锁的武器
	// number 指这个武器的数量
	// Tag Item 的意思参见材料库
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
	private boolean isHave;

	public Weapon(int genre, int type, int lowAttackPoint, int highAttackPoint, int criticalHitRate,
			int armorPenetration, int[] materialTag, int[] materialItem, int[] materialNumber, boolean canCreate,
			int[] nextWeapon, int number) {
		this.genre = genre;
		this.type = type;
		this.lowAttackPoint = lowAttackPoint;
		this.highAttackPoint = highAttackPoint;
		this.criticalRate = criticalHitRate;
		this.armorPenetration = armorPenetration;
		this.materialTag = materialTag;
		this.materialItem = materialItem;
		this.materialNumber = materialNumber;
		this.canCreate = canCreate;
		this.nextWeapon = nextWeapon;
		this.number = number;
	}

	public Weapon(int genre) {
		this.genre = genre;
	}

	public void changeHave() {
		isHave = true;
	}

	public int getGenre() {
		return genre;
	}

	public int getLowAttackPoint() {
		return lowAttackPoint;
	}

	public int getHighAttackPoint() {
		return highAttackPoint;
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

	public int getMaterialQuantity() {
		return materialTag.length;
	}

	public boolean create() {
		number++;
		isHave = true;
		if (number == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHave() {
		return isHave;
	}

	public boolean canCreate() {
		return canCreate;
	}

	public int[] getMaterialTag() {
		return materialTag;
	}

	public int[] getMaterialItem() {
		return materialItem;
	}

	public int[] getMaterialNumber() {
		return materialNumber;
	}

	public int[] getNextWeapon() {
		return nextWeapon;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int num) {
		number = num;
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
