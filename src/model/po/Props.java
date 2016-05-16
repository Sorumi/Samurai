package model.po;

import java.io.Serializable;

public class Props implements Serializable {

	private static final long serialVersionUID = 1L;
	private int type;
	private int number;
	private int price;

	public Props() {
	}

	public Props(int type, int number,int price) {
		this.type = type;
		this.number = number;
		this.price = price;
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

	public int getPrice() {
		return price;
	}
}
