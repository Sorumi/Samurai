package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OrderImageView extends ImageView implements Comparable<OrderImageView>{

	public int zOrder;
	
	public OrderImageView() {
		super();
	}
	public OrderImageView(Image image){
		super(image);
	}
	@Override
	public int compareTo(OrderImageView o) {
		return o.zOrder - this.zOrder;
	}
	
	public void setZOrder(int zOrder){
		this.zOrder = zOrder;
	}
}
