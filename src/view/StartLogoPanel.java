package view;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Main;
import view.items.Ring;

public class StartLogoPanel extends Pane{
	
	private final int x = 600-256;//344
	private final int y = 400-256;//144
	
	private ImageView logo;
	private ImageView logoText;
	private ImageView logoAbove;
	private ImageView logoSwordLeft;
	private ImageView logoSwordRight;
	private ImageView logoBelow;
	
	public StartLogoPanel(Main mainFrame){
		this.setPrefSize(1200, 800);
		this.setStyle("-fx-background-color: #ffffff");
		
		logo = new ImageView(Images.LOGO_0);
		logo.setFitWidth(512);
		logo.setPreserveRatio(true);
		logo.setLayoutX(x);
		logo.setLayoutY(y);
		logo.setOpacity(0);
		
		logoBelow = new ImageView(Images.LOGO_3);
		logoBelow.setFitWidth(308);
		logoBelow.setPreserveRatio(true);
		logoBelow.setLayoutX(x+103);
		logoBelow.setLayoutY(y+176);
		
		logoSwordLeft = new ImageView(Images.LOGO_2);
		logoSwordLeft.setFitWidth(348);
		logoSwordLeft.setPreserveRatio(true);
		logoSwordLeft.setLayoutX(x+87);
		logoSwordLeft.setLayoutY(y+84);
		
		logoSwordRight = new ImageView(Images.LOGO_2);
		logoSwordRight.setFitWidth(348);
		logoSwordRight.setPreserveRatio(true);
		logoSwordRight.setScaleX(-1);
		logoSwordRight.setLayoutX(x+78);
		logoSwordRight.setLayoutY(y+84);

		logoAbove = new ImageView(Images.LOGO_1);
		logoAbove.setFitWidth(342);
		logoAbove.setPreserveRatio(true);
		logoAbove.setLayoutX(x+85);
		logoAbove.setLayoutY(y+162);
		
		logoText = new ImageView(Images.LOGO_4);
		logoText.setFitWidth(242);
		logoText.setPreserveRatio(true);
		logoText.setLayoutX(x+136);
		logoText.setLayoutY(y+390);
		logoText.setOpacity(0);
		
		this.getChildren().addAll(logoBelow, logoSwordLeft, logoSwordRight, logoAbove, logo, logoText);		
		
		Timeline tl = new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(logoSwordLeft.layoutXProperty(), 0-100)),
				new KeyFrame(Duration.millis(0), new KeyValue(logoSwordLeft.layoutYProperty(), -330)),
				new KeyFrame(Duration.millis(0), new KeyValue(logoSwordRight.layoutXProperty(), 1200-248)),
				new KeyFrame(Duration.millis(0), new KeyValue(logoSwordRight.layoutYProperty(), -330)),
				
				new KeyFrame(Duration.millis(1000), new KeyValue(logoSwordLeft.layoutXProperty(), 0-100)),
				new KeyFrame(Duration.millis(1000), new KeyValue(logoSwordLeft.layoutYProperty(), -330)),
				new KeyFrame(Duration.millis(1300), new KeyValue(logoSwordRight.layoutXProperty(), 1200-248)),
				new KeyFrame(Duration.millis(1300), new KeyValue(logoSwordRight.layoutYProperty(), -330)),
				
				new KeyFrame(Duration.millis(1500), new KeyValue(logoSwordLeft.layoutXProperty(), x+87, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1500), new KeyValue(logoSwordLeft.layoutYProperty(), y+84, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1800), new KeyValue(logoSwordRight.layoutXProperty(), x+78, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1800), new KeyValue(logoSwordRight.layoutYProperty(), y+84, Interpolator.EASE_IN)),
				
				new KeyFrame(Duration.millis(2500), new KeyValue(logo.opacityProperty(), 0)),
				new KeyFrame(Duration.millis(3500), new KeyValue(logo.opacityProperty(), 1, Interpolator.EASE_IN)),
				
				new KeyFrame(Duration.millis(4000), new KeyValue(logoText.opacityProperty(), 0)),
				new KeyFrame(Duration.millis(5000), new KeyValue(logoText.opacityProperty(), 1, Interpolator.EASE_IN)),
				
				new KeyFrame(Duration.millis(6000), new KeyValue(this.opacityProperty(), 1)),
				new KeyFrame(Duration.millis(7000), new KeyValue(this.opacityProperty(), 0, Interpolator.EASE_IN))
				);

		tl.setOnFinished(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Pane parent = (Pane) StartLogoPanel.this.getParent();
				parent.getChildren().remove(StartLogoPanel.this);
				mainFrame.setMenu();
			}
			
		});

//		Color color = Color.web("#ADC0AB");
//		
//		Random random = new Random();
//		
//		for (int i=0; i<30; i++){
//			Ring ring = new Ring(color);
//			ring.setLayoutX(random.nextInt(450)+x+30);
//			ring.setLayoutY(random.nextInt(450)+y+30);
//			this.getChildren().add(ring);
//			tl.getKeyFrames().addAll(ring.getFrames());
//		}
		
		tl.play();
	}

}
