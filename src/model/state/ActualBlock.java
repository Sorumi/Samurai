package model.state;

/**
 * 逻辑运行时土地块的状态：未被占领，被某一个武士占领
 * 
 * @author Sorumi
 *
 */

public class ActualBlock {
	//0 未占领 1:A0 2:B0 3:A1 4:B1 5:A2 6:B2 
	private int state=0;
	private boolean occupied;
	public void setState(int state){
		this.state=state;
	}
	public int getState(){
		return state;
	}
	public boolean getOccupied(){
		return occupied;
	}
	public void setOccupied(boolean occupied){
		this.occupied=occupied;
	}
    
}
