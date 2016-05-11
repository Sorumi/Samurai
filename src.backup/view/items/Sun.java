package view.items;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Sun extends Circle{
	private DropShadow light;
	
	
	public Sun(){
		this.setRadius(60);
		this.setCenterX(60);
		this.setCenterY(60);
		
		Stop[] stops = new Stop[]{new Stop(0, Color.web("#FDFFF1")), new Stop(1, Color.rgb(244, 245, 57, 0.5))};
		LinearGradient lg = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);
		this.setFill(lg);
		
		light = new DropShadow(BlurType.GAUSSIAN, Color.rgb(253, 252, 235, 0.8), 30, 0.5, 0, 0);	       
		this.setEffect(light);
	}
	
	public KeyFrame[] lightAnimation(){
		KeyFrame[] frames = {
				new KeyFrame(Duration.ZERO, new KeyValue(light.radiusProperty(), 30)),
				new KeyFrame(Duration.millis(6000), new KeyValue(light.radiusProperty(), 127, Interpolator.EASE_BOTH))
		};
		return frames;
	}

}
