package view.items;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ring extends Circle{
	/*
	 * radius: 25-45
	 */
	private Color color;
	private Random random;
	private int radius;
	private int start;
	
	public Ring(Color color){
		this.color = color;
		
		this.setFill(null);
		this.setStroke(color);
		this.setStrokeWidth(5);
		this.setOpacity(0);
		
		random = new Random();
		radius = random.nextInt(50)+45;
		start = random.nextInt(1000)+1000;
	}
	
	public KeyFrame[] getFrames(){
		return new KeyFrame[]{new KeyFrame(Duration.millis(start), new KeyValue(this.radiusProperty(), 0)),
				new KeyFrame(Duration.millis(start), new KeyValue(this.opacityProperty(), 0.9, Interpolator.DISCRETE)),
				new KeyFrame(Duration.millis(start), new KeyValue(this.strokeProperty(), color)),
			
				new KeyFrame(Duration.millis(start+800), new KeyValue(this.radiusProperty(), radius, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(start+800), new KeyValue(this.opacityProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(start+800), new KeyValue(this.strokeProperty(), Color.web("#ffffff"), Interpolator.EASE_IN))
				};
	}

}
