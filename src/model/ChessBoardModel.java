package model;

import model.state.*;

public class ChessBoardModel extends BaseModel {
	private ActualBlock[][] actualBlockArray;
	private DisplayBlock[][] displayBlockArray;
	private int length;

	public ChessBoardModel(int length) {
		this.length = length;
		actualBlockArray = new ActualBlock[this.length+1][this.length+1];
		for (int i = 0; i <= this.length; i++) {
			for (int x = 0; x <= this.length; x++) {
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

	public int[] getStatesOfAllBlocks(){
		//数组第几号元素(1~6)对应被几号武士占领,调用时候是[1...6]
		int[] statesCount = new int[7];
		for (int x = 0; x <= this.length; x++) {
			for (int y = 0; y <= this.length; y++) {
				statesCount[getActualBlockState(x,y)]++;
			}
		}
		return statesCount;
	}
}
