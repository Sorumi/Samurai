package model.po;

/**
 * 界面上土地块的状态：未被占领，被某一个武士占领，不可见
 * @author Sorumi
 *
 */

public class DisplayBlock {
	//0:未占领 1:A0 2:B0 3:A1 4:B1 5:A2 6:B2 7:不可见
	private int state = 0;
	
	//棋盘的坐标 By Sorumi
	private final int x;
	private final int y;
	
	public DisplayBlock(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setState(int state){
		this.state=state;
	}
	public int getState(){
		return state;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
}
