package model.po;

import java.util.Random;

public class Weapon implements Cloneable {
	private int genre;
	private int type;
	private int lowAttackPoint;
	private int highAttackPoint;
	private int criticalRate;
	private int armorPenetration;

	public Weapon(int genre, int type, int lowAttackPoint, int highAttackPoint, int criticalHitRate,
			int armorPenetration) {
		this.genre = genre;
		this.type = type;
		this.lowAttackPoint = lowAttackPoint;
		this.highAttackPoint = highAttackPoint;
		this.criticalRate = criticalHitRate;
		this.armorPenetration = armorPenetration;
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

	public Weapon clone() {
		try {
			return (Weapon) super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
