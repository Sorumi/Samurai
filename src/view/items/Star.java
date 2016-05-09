package view.items;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Star extends Group {

	private Polygon star;
	private Polygon light;
	
	private Timeline effectTL;
	
	public Star(int scale){
		star = new Polygon();
		star.getPoints().addAll(new Double[]{
		    20.0, 0.0,
		    25.0, 15.0,
		    40.0, 20.0,
		    25.0, 25.0,
		    20.0, 40.0,
		    15.0, 25.0,
		    0.0, 20.0,
		    15.0, 15.0});
		star.setFill(Color.web("#ECF3F2"));
		
		light = new Polygon();
		light.getPoints().addAll(new Double[]{
			    20.0, 0.0,
			    25.0, 15.0,
			    40.0, 20.0,
			    25.0, 25.0,
			    20.0, 40.0,
			    15.0, 25.0,
			    0.0, 20.0,
			    15.0, 15.0
		});
		light.setFill(Color.rgb(253, 255, 250, 0.5));
		light.setScaleX(1.4);
		light.setScaleY(1.4);

		GaussianBlur blur = new GaussianBlur(5);
		light.setEffect(blur);
		
		this.getChildren().addAll(star, light);
		this.setScaleX(scale/40.0);
		this.setScaleY(scale/40.0);
	}
	
	public void lightAnimation(){
		Random random = new Random();
		int time = random.nextInt(3000);
		effectTL= new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(light.scaleXProperty(), 1.4)),
				new KeyFrame(Duration.ZERO, new KeyValue(light.scaleYProperty(), 1.4)),
				new KeyFrame(Duration.millis(time), new KeyValue(light.scaleXProperty(), 1.4)),
				new KeyFrame(Duration.millis(time), new KeyValue(light.scaleYProperty(), 1.4)),
				new KeyFrame(Duration.millis(1000+time), new KeyValue(light.scaleXProperty(), 1.8)),
				new KeyFrame(Duration.millis(1000+time), new KeyValue(light.scaleYProperty(), 1.8)),
				new KeyFrame(Duration.millis(1300+time), new KeyValue(light.scaleXProperty(), 2.5, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1300+time), new KeyValue(light.scaleYProperty(), 2.5, Interpolator.EASE_IN))
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
