package view.items;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class StarCircle extends Circle{
	private DropShadow light;
	private Timeline effectTL;
	
	public StarCircle(int scale){
		this.setRadius(60);
		this.setCenterX(60);
		this.setCenterY(60);
		
		Stop[] stops = new Stop[]{new Stop(0, Color.web("#FDFFF1")), new Stop(1, Color.rgb(244, 245, 57, 0.5))};
		LinearGradient lg = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);
		this.setFill(lg);
		
		light = new DropShadow(BlurType.GAUSSIAN, Color.rgb(253, 252, 235, 0.8), 30, 0.5, 0, 0);	       
		this.setEffect(light);
		this.setScaleX(scale/60.0);
		this.setScaleY(scale/60.0);
	}
	
	public void lightAnimation(){
		Random random = new Random();
		int time = random.nextInt(3000);
		
		effectTL = new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(light.radiusProperty(), 30)),
				new KeyFrame(Duration.millis(time), new KeyValue(light.radiusProperty(), 30)),
				new KeyFrame(Duration.millis(2000+time), new KeyValue(light.radiusProperty(), 127, Interpolator.EASE_BOTH))
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
