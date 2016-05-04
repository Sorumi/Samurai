package view;

import javafx.scene.layout.Pane;

public class OrderPanel extends Pane implements Comparable<OrderPanel>{

	protected int zOrder;

	public int compareTo(OrderPanel o) {
		return this.zOrder - o.zOrder;
	}
	
	public void setZOrder(int zOrder){
		this.zOrder = zOrder;
	}
}
