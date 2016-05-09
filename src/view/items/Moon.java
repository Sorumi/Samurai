package view.items;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Moon extends Group{
	
	private DropShadow light;
	
	private Timeline effectTL;
	
	public Moon(){
		Circle bigC = new Circle();
		bigC.setRadius(85);
		bigC.setLayoutX(85);
		bigC.setLayoutY(85);
		
		Circle smallC = new Circle();
		smallC.setRadius(70);
		smallC.setLayoutX(98);
		smallC.setLayoutY(70);
		
		Shape moon = Shape.subtract(bigC, smallC);
		moon.setFill(Color.web("#FFFEED"));
		
		light = new DropShadow(BlurType.GAUSSIAN, Color.rgb(253, 252, 235, 0.8), 30, 0.5, 0, 0);	       
		moon.setEffect(light);

		this.getChildren().add(moon);
	}
	
	public void lightAnimation(){
		effectTL= new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(light.radiusProperty(), 30)),
				new KeyFrame(Duration.millis(6000), new KeyValue(light.radiusProperty(), 127, Interpolator.EASE_BOTH))
				);
		effectTL.setAutoReverse(true);
		effectTL.setCycleCount(Timeline.INDEFINITE);
		effectTL.play();
	}
	
	public void stopTL(){
		if(effectTL != null){
			effectTL.stop();
		}
	}

}