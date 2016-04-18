package model.po;

public class Armor {
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
	public Armor clone() {
		try {
			return (Armor) super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}






