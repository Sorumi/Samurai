package model.po;

import java.io.Serializable;

public class Armor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int type;
	private int armorValue;
	private int dodgeRate;
	public Armor(int type,int armorValue,int dodgeRate){
		this.type=type;
		this.armorValue=armorValue;
		this.dodgeRate=dodgeRate;
	}
	public Armor(){
		
	}
	public int getArmorValue(){
		return armorValue;
	}
	public int getDodgeRate(){
		return dodgeRate;
	}
	public int getType(){
		return type;
	}
	public Armor clone() {
		try {
			return (Armor) super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
