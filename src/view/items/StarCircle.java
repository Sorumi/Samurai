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
		this.setRadius(10);
		this.setCenterX(10);
		this.setCenterY(10);

		this.setFill(Color.web("#FFFFFC"));
		
		light = new DropShadow(BlurType.GAUSSIAN, Color.web("#ffffff"), 20, 0.5, 0, 0);	       
		this.setEffect(light);
		this.setScaleX(scale/20.0);
		this.setScaleY(scale/20.0);
	}

}
