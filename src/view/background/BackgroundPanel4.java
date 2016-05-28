package view.background;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.Images;

public class BackgroundPanel4 extends BackgroundPanel{
	public BackgroundPanel4(){
		super(4);
		
		ImageView meteor = new ImageView(Images.METEOR);
		meteor.setPreserveRatio(true);
		meteor.setLayoutX(229);
		meteor.setLayoutY(-100);
		meteor.setFitWidth(196);
		this.getChildren().add(meteor);
		
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.millis(1000), new KeyValue(meteor.layoutXProperty(), 1182)),
				new KeyFrame(Duration.millis(1000), new KeyValue(meteor.layoutYProperty(), 318)),
				new KeyFrame(Duration.millis(10000), new KeyValue(meteor.layoutXProperty(), 1182)),
				new KeyFrame(Duration.millis(10000), new KeyValue(meteor.layoutYProperty(), 318))
				);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		}

	}


