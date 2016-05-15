package model.po;

import java.io.Serializable;

public class Props implements Serializable {

	private static final long serialVersionUID = 1L;
	private int type;
	private int number;

	public Props() {
	}

	public Props(int type, int number) {
		this.type = type;
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	public void changeNumber(int number) {
		this.number = this.number + number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
