package model.po;

import java.io.*;

public class Position implements Serializable,Cloneable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int x;
  private int y;
  public Position(int x,int y){
	  this.x=x;
	  this.y=y;
  }
  public int getX(){
	  return x;
  }
  public int getY(){
	  return y;
}
  public void setX(int x){
	  this.x=x;
  }
  public void setY(int y){
	  this.y=y;
  }
  public Position clone() {
		try {
			return (Position)super.clone();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
