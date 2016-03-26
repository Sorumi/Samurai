package model;

import model.state.*;

public class ChessBoardModel extends BaseModel {
	private ActualBlock[][] actualBlockArray;
	private DisplayBlock[][] displayBlockArray;

	public ChessBoardModel(int length) {
		for (int i = 0; i <= length; i++) {
			for (int x = 0; x <= length; x++) {
				actualBlockArray[i][x] = new ActualBlock();
			}
		}
		for (int i = 0; i <= length; i++) {
			for (int x = 0; x <= length; x++) {
				displayBlockArray[i][x] = new DisplayBlock();
			}
		}
	}

	public void changeActualBlock(int x, int y, int state) {
		actualBlockArray[x][y].setState(state);
	}
	public void changeActualBlock(int x, int y,boolean occ) {
		actualBlockArray[x][y].setOccupied(occ);
	}

	public int getActualBlockState(int x, int y) {
		return actualBlockArray[x][y].getState();
	}

	public boolean getActualBlockOccupied(int x, int y) {
		return actualBlockArray[x][y].getOccupied();
	}
}
