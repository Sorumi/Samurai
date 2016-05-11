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
	private int[] materialTag;
	private int[] materialItem;
	private int[] materialNumber;
	private int[] nextArmor;
	private boolean canCreate;
	private int number;
	public Armor(int type,int armorValue,int dodgeRate,int[] materialTag, int[] materialItem, int[] materialNumber, boolean canCreate,
			int[] nextArmor,int number){
		this.type=type;
		this.armorValue=armorValue;
		this.dodgeRate=dodgeRate;
		this.materialTag=materialTag;
		this.materialItem=materialItem;
		this.materialNumber=materialNumber;
		this.canCreate=canCreate;
		this.nextArmor=nextArmor;
		this.number=number;
	}
	public Armor(){
		
	}
	public boolean canCreate(){
		return canCreate;
	}
	public boolean create() {
		number++;
		if (number == 1) {
			return true;
		} else {
			return false;
		}
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
	public int[] getMaterialTag(){
		return materialTag;
	}
	public int[] getMaterialItem(){
		return materialItem;
	}
	public int[] getMaterialNumber(){
		return materialNumber;
	}
	public int[] getNextArmor(){
		return nextArmor;
	}
	public void unlock() {
		canCreate = true;
	}
	public int getNumber(){
		return number;
	}
	public Armor clone() {
		try {
			return new Armor(type, armorValue,dodgeRate, materialTag.clone(),  materialItem.clone(),  materialNumber.clone(),  canCreate,
					 nextArmor.clone(), number);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
