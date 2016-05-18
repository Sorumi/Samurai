package view;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ArmorView extends StackPane {

	private double SCALE = 1;
	private int BODY_X;
	private int BODY_Y;

	private int num;
	
	private Group group;
	
	private ImageView left;
	private ImageView body;
	private ImageView right;

	private ColorAdjust grayscale;

	public ArmorView(int number) {
		this(number, 1);
	}
	public ArmorView(int number, int scale) {
		number = (number - 900)*10;
		this.num = number;
		this.SCALE = scale;
//		this.BODY_X = 0;
//		this.BODY_Y = 0;

		this.setPrefSize(100 * SCALE, 100 * SCALE);
		

		if (Images.ARMOR[number / 100][number % 100 / 10] != null) {
			left = new ImageView(Images.ARMOR[number / 100][number % 100 / 10][0]);
			body = new ImageView(Images.ARMOR[number / 100][number % 100 / 10][1]);
			right = new ImageView(Images.ARMOR[number / 100][number % 100 / 10][3]);
			left.setPreserveRatio(true);
			body.setPreserveRatio(true);
			right.setPreserveRatio(true);
			left.setSmooth(true);
			body.setSmooth(true);
			right.setSmooth(true);

			this.setInit();
			group = new Group();
			group.getChildren().addAll(right, body, left);
			this.getChildren().add(group);
		}

	}

	private void setInit() {
		switch (num / 100) {
		// 布甲
		case 1:

			left.setFitWidth(32 * SCALE);
			left.setLayoutX(-2 * SCALE);
			left.setLayoutY(4 * SCALE);

			body.setFitWidth(58 * SCALE);
			body.setLayoutX(BODY_X);
			body.setLayoutY(BODY_Y);

			right.setFitWidth(22 * SCALE);
			right.setLayoutX(30 * SCALE);
			right.setLayoutY(-2 * SCALE);

			break;

		// 皮甲
		case 2:

			left.setFitWidth(26 * SCALE);
			left.setLayoutX(-6 * SCALE);
			left.setLayoutY(8 * SCALE);

			body.setFitWidth(58 * SCALE);
			body.setLayoutX(0);
			body.setLayoutY(0);

			right.setFitWidth(22 * SCALE);
			right.setLayoutX(34 * SCALE);
			right.setLayoutY(4 * SCALE);

			break;

		// 铁甲
		case 3:

			left.setFitWidth(20 * SCALE);
			left.setLayoutX(0);
			left.setLayoutY(4 * SCALE);

			body.setFitWidth(64 * SCALE);
			body.setLayoutX(-2 * SCALE);
			body.setLayoutY(0);

			right.setFitWidth(18 * SCALE);
			right.setLayoutX(34 * SCALE);
			right.setLayoutY(0);

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
