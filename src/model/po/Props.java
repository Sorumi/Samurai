package model.po;

public class Props {
	private int type;
	private int number;

	public int getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	public void changeNumber(int number) {
		this.number = this.number + number;
	}

}
