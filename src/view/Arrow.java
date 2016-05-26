package view;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Arrow extends OrderPanel{
	
	private final int SAMURAI_WIDTH = 60;
	
	private ImageView imageV;
	private SamuraiPanel currentSamurai;
	private TranslateTransition tt;
	
	public Arrow(){
		imageV = new ImageView (Images.ARROW);
		this.getChildren().add(imageV);
		this.setVisible(false);
		
		tt = new TranslateTransition(Duration.millis(1000), this);
		tt.setToY(-20);
		tt.setInterpolator(Interpolator.EASE_BOTH);
		tt.setCycleCount(Timeline.INDEFINITE);
		tt.setAutoReverse(true);
	}
	
	public void setCurrentSamurai(SamuraiPanel samurai){
		this.currentSamurai = samurai;
		this.setVisible(true);
		this.setActualLocation();
	}
	
	public void setActualLocation(){
		this.setLayoutX(currentSamurai.getLayoutX() +SAMURAI_WIDTH/2 -this.getBoundsInParent().getWidth()/2);
		this.setLayoutY(currentSamurai.getLayoutY() -this.getBoundsInParent().getHeight());
	}
	
	public void setAppear(boolean isAppear){
		if(isAppear){
			this.setZOrder(900);
			this.setVisible(true);
			this.setActualLocation();
			tt.play();
		}else{
			this.setZOrder(-1);
			this.setVisible(false);
//			tt.stop();
		}
	}
	
}
