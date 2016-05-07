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
	
	private int num;
	private ImageView imgV;
	private ImageView imgVExtra;
	
	private ColorAdjust grayscale;
	
	public WeaponView(int number){
		this(number, 1);
	}
	public WeaponView(int number, int scale){
		this.num = number;
		this.SCALE = scale;
		this.setPrefSize(100*SCALE, 100*SCALE);
		
		if(Images.WEAPON[number/100][number%100/10][number%10] != null){
			imgV = new ImageView(Images.WEAPON[number/100][number%100/10][number%10]);
			imgV.setPreserveRatio(true);
			imgV.setSmooth(true);
			
			this.setInit();

			if(imgV.getFitHeight() > 100*SCALE){
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
	
	private void setInit(){
		switch(num){
			//spear
			case 00:
			case 12:
				imgV.setFitWidth(6*SCALE);
				break;
			case 11:
				imgV.setFitWidth(7*SCALE);
				break;
			case 13:
				imgV.setFitWidth(17*SCALE);
				break;
			case 14:
				imgV.setFitWidth(9*SCALE);
				break;
			case 15:
				imgV.setFitWidth(21*SCALE);
				imgV.setFitHeight(107*SCALE);
				break;
			case 16:
				imgV.setFitWidth(18*SCALE);
				imgV.setFitHeight(106*SCALE);
				break;
			case 23:
				imgV.setFitWidth(8*SCALE);
				break;
			case 25:
				imgV.setFitWidth(7*SCALE);
				break;
			case 26:
				imgV.setFitWidth(16*SCALE);
				imgV.setFitHeight(112*SCALE);
				break;
			case 33:
				imgV.setFitWidth(9*SCALE);
				break;
			case 34:
				imgV.setFitWidth(15*SCALE);
				break;
			case 35:
				imgV.setFitWidth(8*SCALE);
				break;
			case 36:
				imgV.setFitWidth(16*SCALE);
				break;
				
			//sword
			case 100:
			case 113:
				imgV.setFitWidth(14*SCALE);
				break;
			case 111:
				imgV.setFitWidth(12*SCALE);
				break;
			case 112:
				imgV.setFitWidth(8*SCALE);
				break;
			case 114:
				imgV.setFitWidth(10*SCALE);
				break;
			case 115:
				imgV.setFitWidth(18*SCALE);
				break;
			case 116:
				imgV.setFitWidth(24*SCALE);
				break;
			case 124:
				imgV.setFitWidth(14*SCALE);
				break;
			case 125:
				imgV.setFitWidth(20*SCALE);
				break;
			case 126:
				imgV.setFitWidth(16*SCALE);
				break;
			case 132:
				imgV.setFitWidth(10*SCALE);
				break;
			case 133:
				imgV.setFitWidth(7*SCALE);
				break;
			case 134:
				imgV.setFitWidth(11*SCALE);
				break;
			case 135:
				imgV.setFitWidth(12*SCALE);
				break;
			case 136:
				imgV.setFitWidth(8*SCALE);
				break;
			
			//battleax
			case 200:
			case 212:
				imgV.setFitWidth(18*SCALE);
				break;
			case 211:
				imgV.setFitWidth(23*SCALE);
				break;
			case 213:
				imgV.setFitWidth(31*SCALE);
				imgV.setFitHeight(111*SCALE);
				break;
			case 214:
				imgV.setFitWidth(32*SCALE);
				imgV.setFitHeight(115*SCALE);
				break;
			case 215:
				imgV.setFitWidth(37*SCALE);
				imgV.setFitHeight(121*SCALE);
				break;
			case 216:
				imgV.setFitWidth(25*SCALE);
				imgV.setFitHeight(116*SCALE);
				break;
			case 225:
				imgV.setFitWidth(38*SCALE);
				break;
			case 226:
				imgV.setFitWidth(36*SCALE);
				imgV.setFitHeight(105*SCALE);
				break;
			case 233:
				imgV.setFitWidth(27*SCALE);
				break;
			case 234:
				imgV.setFitWidth(34*SCALE);
				break;
			case 235:
				imgV.setFitWidth(28*SCALE);
				break;
			case 236:
				imgV.setFitWidth(36*SCALE);
				break;
				
			//shuriken
			case 300:
			case 323:
				imgV.setFitWidth(20*SCALE);
				break;
			case 311:
				imgV.setFitWidth(8*SCALE);
				break;
			case 312:
				imgV.setFitWidth(30*SCALE);
				break;
			case 313:
				imgV.setFitWidth(6*SCALE);
				break;
			case 314:
				imgV.setFitWidth(10*SCALE);
				break;
			case 315:
				imgV.setFitWidth(8*SCALE);
				break;
			case 316:
				imgV.setFitWidth(4*SCALE);
				break;
			case 324:
				imgV.setFitWidth(24*SCALE);
				break;
			case 325:
				imgV.setFitWidth(27*SCALE);
				break;
			case 326:
				imgV.setFitWidth(28*SCALE);
				break;
				
			case 400:
			case 411:
			case 412:
			case 413:
			case 414:
			case 415:
			case 416:
			case 422:
			case 423:
			case 424:
			case 425:
			case 426:
				imgV.setFitWidth(18*SCALE);
				break;
			case 500:
			case 511:
			case 512:
			case 513:
			case 514:
			case 515:
			case 516:
			case 522:
			case 523:
			case 524:
			case 525:
			case 526:
				imgV.setFitWidth(50*SCALE);
				break;
		}

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
