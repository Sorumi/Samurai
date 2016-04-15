package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Arrow extends Pane{

	private ImageView imageV;
	private SamuraiView currentSamurai;
	
	public Arrow(){
		imageV = new ImageView (Images.ARROW);
		this.getChildren().add(imageV);
		this.setVisible(false);
	}
	
	public void setCurrentSamurai(SamuraiView samurai){
		this.currentSamurai = samurai;
		this.setVisible(true);
		this.setActualLocation();
	}
	
	public void setActualLocation(){
		this.setLayoutX(currentSamurai.getLayoutX() +34 -this.getBoundsInParent().getWidth()/2);
		this.setLayoutY(currentSamurai.getLayoutY() -this.getBoundsInParent().getHeight());
	}
}
