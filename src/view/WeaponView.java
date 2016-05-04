package view;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class WeaponView extends StackPane{

	private double SCALE = 1;
	private ImageView imgV;
	private ImageView imgVExtra;
	
	private ColorAdjust grayscale;
	
	public WeaponView(int number){
		this(number, 1);
	}
	public WeaponView(int number, int scale){
		this.SCALE = scale;
		this.setPrefSize(100*SCALE, 100*SCALE);
		
		if(Images.WEAPON[number/100][number%100/10][number%10] != null){
			imgV = new ImageView(Images.WEAPON[number/100][number%100/10][number%10]);
			imgV.setFitWidth(Images.WEAPON[number/100][number%100/10][number%10].getWidth()/6*SCALE);
			imgV.setPreserveRatio(true);
			imgV.setSmooth(true);
			
			if(Images.WEAPON[number/100][number%100/10][number%10].getHeight()/6*SCALE > 100*SCALE){
				imgV.setScaleX(1.1);
				imgV.setScaleY(1.1);
			}else{
				imgV.setScaleX(1.5);
				imgV.setScaleY(1.5);
			}
			
			if(number/100 != 4){
				imgV.setRotate(45);
			}else{
				imgV.setRotate(-45);
				imgVExtra = new ImageView(Images.WEAPON[number/100+1][number%100/10][number%10]);
				imgVExtra.setFitWidth(Images.WEAPON[number/100+1][number%100/10][number%10].getWidth()/6*SCALE);
				imgVExtra.setPreserveRatio(true);
				imgVExtra.setSmooth(true);
				imgVExtra.setScaleX(1.5);
				imgVExtra.setScaleY(1.5);
				imgVExtra.setRotate(-45);
				this.getChildren().add(imgVExtra);
				StackPane.setAlignment(imgVExtra, Pos.CENTER);
			}
			
			this.getChildren().add(imgV);
			StackPane.setAlignment(imgV, Pos.CENTER);
		}

		this.setStyle("-fx-content-display: center;"
				+ "-fx-alignment: center;");
	}
	
	public void setGray(){
		grayscale = new ColorAdjust();
		grayscale.setSaturation(-1);
		this.setEffect(grayscale);
	}
	
	public void setColored(){
		if(grayscale != null){
			DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.rgb(255, 255, 150, 0.5), 0, 0.5, 0, 0);	       
			this.setEffect(shadow);
			
			Timeline colorTL= new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(grayscale.saturationProperty(), -1)),
					new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0)),
					new KeyFrame(Duration.millis(600), new KeyValue(grayscale.saturationProperty(), 0,  Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(600), new KeyValue(shadow.radiusProperty(), 127,  Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(1200), new KeyValue(shadow.radiusProperty(), 0,  Interpolator.EASE_IN))
					);
			colorTL.play();
		}
	}
	
}
