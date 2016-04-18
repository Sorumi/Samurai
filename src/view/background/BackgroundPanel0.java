package view.background;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.Images;

public class BackgroundPanel0 extends BackgroundPanel{

	private ImageView cloud0;
	private ImageView cloud1;
	private ImageView cloud2;
	
	public BackgroundPanel0(){
		super();

		this.cloud0 = new ImageView(Images.CLOUD_0);
		this.cloud1 = new ImageView(Images.CLOUD_1);
		this.cloud2 = new ImageView(Images.CLOUD_2);

		this.cloud0.setFitWidth(103);
		this.cloud1.setFitWidth(165);
		this.cloud2.setFitWidth(79);
		

		this.cloud0.setPreserveRatio(true);
		this.cloud1.setPreserveRatio(true);
		this.cloud2.setPreserveRatio(true);
		

		this.getChildren().add(cloud0);
		this.getChildren().add(cloud1);
		this.getChildren().add(cloud2);
		
		this.cloud0.setLayoutX(133);
		this.cloud0.setLayoutY(100);
		this.cloud1.setLayoutX(236);
		this.cloud1.setLayoutY(64);
		this.cloud2.setLayoutX(900);
		this.cloud2.setLayoutY(40);
		
		this.startAnimation();
	}
	
	public void startAnimation(){
		
		
		Timeline timeLine = new Timeline(
				//CLOUD0
				new KeyFrame(Duration.millis(20000), new KeyValue(cloud0.xProperty(), 400)),
				//CLOUD1
				new KeyFrame(Duration.millis(10000), new KeyValue(cloud1.xProperty(), 500)),
				new KeyFrame(Duration.millis(20000), new KeyValue(cloud1.xProperty(), 100)),
				//CLOUD2
				new KeyFrame(Duration.millis(10000),new KeyValue(cloud2.xProperty(), -500)),
				new KeyFrame(Duration.millis(20000),new KeyValue(cloud2.xProperty(), -300))
		);
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.setAutoReverse(true);
		timeLine.play();
		
	    
	
	}
	
	

}
