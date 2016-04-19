package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Arrow extends Pane{
	
	private final int SAMURAI_WIDTH = 60;
	
	private ImageView imageV;
	private SamuraiPanel currentSamurai;
	
	public Arrow(){
		imageV = new ImageView (Images.ARROW);
		this.getChildren().add(imageV);
		this.setVisible(false);
	}
	
	public void setCurrentSamurai(SamuraiPanel samurai){
		this.currentSamurai = samurai;
		this.setVisible(true);
		this.setActualLocation();
	}

	public void setInvisible(){
		this.setVisible(false);
	}
	
	public void setActualLocation(){
		this.setLayoutX(currentSamurai.getLayoutX() +SAMURAI_WIDTH/2 -this.getBoundsInParent().getWidth()/2);
		this.setLayoutY(currentSamurai.getLayoutY() -this.getBoundsInParent().getHeight());
	}
}
