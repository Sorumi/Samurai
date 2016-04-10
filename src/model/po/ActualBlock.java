package model.po;

/**
 * 逻辑运行时土地块的状态：未被占领，被某一个武士占领
 * 
 * @author Sorumi
 *
 */

public class ActualBlock implements Cloneable {
	//0 未占领 1:A0 2:B0 3:A1 4:B1 5:A2 6:B2 
	private int state = 0;
	private boolean occupied;
	private boolean visible;
	//棋盘的坐标 By Sorumi
	private final int x;
	private final int y;
	
	//初始化方法 By Sorumi
	public ActualBlock(int x, int y){
		this.x = x;
		this.y = y;
	}
	
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
		this.occupied = occupied;
	}
	public boolean getVisible(){
		return visible;
	}
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public ActualBlock clone() {
		try {
			return (ActualBlock)super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
