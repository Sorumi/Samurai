package model;

import model.po.ActualBlock;
import model.po.SamuraiPO;

public class ChessBoardModel extends BaseModel implements Cloneable {
	private ActualBlock[][] actualBlockArray;
	private int length;

	public ChessBoardModel(int length) {
		this.length = length;
		actualBlockArray = new ActualBlock[this.length+1][this.length+1];
		for (int x = 0; x <= this.length; x++) {
			for (int y = 0; y <= this.length; y++) {
				this.actualBlockArray[x][y] = new ActualBlock(x, y);
			}
		}
	}
	public ChessBoardModel(int length,ActualBlock[][] actualBlocks) {
		this.length=length;
		actualBlockArray=actualBlocks;
	}

	public ActualBlock getActualBlock(int x, int y){
		return actualBlockArray[x][y];
	}

	public void changeActualBlock(int x, int y, int state) {
		this.actualBlockArray[x][y].setState(state);
		super.updateChange(new UpdateMessage("block",actualBlockArray[x][y]));
	}

	public void changeActualBlock(int x, int y, boolean occ) {
		actualBlockArray[x][y].setOccupied(occ);
		super.updateChange(new UpdateMessage("samuraiPosition",actualBlockArray[x][y]));
	}

	public void setActualBlockVisible(int x, int y, boolean visible){
		actualBlockArray[x][y].setVisible(visible);
	}

	public boolean getActualBlockVisible(int x, int y){
		return actualBlockArray[x][y].getVisible();
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
	public ChessBoardModel clone() {
		try{
			ChessBoardModel chessBoardModel=new ChessBoardModel(length, new ActualBlock[length+1][length+1]);
			for(int i=0;i<this.actualBlockArray.length;i++){
				for(int x=0;x<this.actualBlockArray.length;x++){
				chessBoardModel.actualBlockArray[i][x]=this.actualBlockArray[i][x].clone();
				}
			}
			return chessBoardModel;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
