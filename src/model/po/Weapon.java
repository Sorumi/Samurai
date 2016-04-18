package model.po;

import java.util.Random;

public class Weapon implements Cloneable {
	private int genre;
	private int type;
	private int lowAttackPoint;
	private int highAttackPoint;
	private int criticalRate;

	public Weapon(int genre, int type, int lowAttackPoint, int highAttackPoint, int criticalHitRate) {
		this.genre = genre;
		this.type = type;
		this.lowAttackPoint = lowAttackPoint;
		this.highAttackPoint = highAttackPoint;
		this.criticalRate = criticalHitRate;
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

	public Weapon clone() {
		try {
			return (Weapon) super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
