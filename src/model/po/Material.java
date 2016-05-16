package model.po;

public class Material {
	private int type;
	private int number;

	public Material(int type, int number) {
		this.type = type;
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public int getNumer() {
		return number;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
