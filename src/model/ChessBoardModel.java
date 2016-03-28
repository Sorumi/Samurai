package model;

import model.state.*;

public class ChessBoardModel extends BaseModel {
	private ActualBlock[][] actualBlockArray;
	private DisplayBlock[][] displayBlockArray;

	public ChessBoardModel(int length) {
		actualBlockArray = new ActualBlock[length+1][length+1];
		for (int i = 0; i <= length; i++) {
			
			for (int x = 0; x <= length; x++) {
				this.actualBlockArray[i][x] = new ActualBlock();
			}
		}
	}

	public void changeActualBlock(int x, int y, int state) {
		this.actualBlockArray[x][y].setState(state);
	}

	public void changeActualBlock(int x, int y, boolean occ) {
		actualBlockArray[x][y].setOccupied(occ);
	}

	public int getActualBlockState(int x, int y) {
		return this.actualBlockArray[x][y].getState();
	}

	public boolean getActualBlockOccupied(int x, int y) {
		return this.actualBlockArray[x][y].getOccupied();
	}
}
