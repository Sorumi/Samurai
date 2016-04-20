package background;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.Images;

public class BackgroundPanel3 extends BackgroundPanel {
	private ImageView fish0; 
	private ImageView fish1;
	private ImageView fish2;
	private ImageView fish3;
	private ImageView leaf0;
	private ImageView leaf1;
	private ImageView lotus0;
	private ImageView lotus1;
	
	public BackgroundPanel3(Image image){
		super(image);

		this.fish0 = new ImageView(Images.FISH_0);
		this.fish1 = new ImageView(Images.FISH_1);
		this.fish2 = new ImageView(Images.FISH_2);
		this.fish3 = new ImageView(Images.FISH_3);
		
		this.leaf0 = new ImageView(Images.LEAF_0);
		this.leaf1 = new ImageView(Images.LEAF_1);
		
		this.lotus0 = new ImageView(Images.LOTUS_0);
		this.lotus1 = new ImageView(Images.LOTUS_0);

		this.fish0.setFitWidth(43);
		this.fish1.setFitWidth(48);
		this.fish2.setFitWidth(36);
		this.fish3.setFitWidth(51);		
		this.leaf0.setFitWidth(62);
		this.leaf1.setFitWidth(71);
		this.lotus0.setFitWidth(68);
		this.lotus1.setFitWidth(68);

		this.fish0.setPreserveRatio(true);
		this.fish1.setPreserveRatio(true);
		this.fish2.setPreserveRatio(true);
		this.fish3.setPreserveRatio(true);		
		this.leaf0.setPreserveRatio(true);
		this.leaf1.setPreserveRatio(true);		
		this.lotus0.setPreserveRatio(true);
		this.lotus1.setPreserveRatio(true);

		this.getChildren().add(fish0);
		this.getChildren().add(fish1);
		this.getChildren().add(fish2);
		this.getChildren().add(fish3);
		this.getChildren().add(leaf0);
		this.getChildren().add(leaf1);
		this.getChildren().add(lotus0);
		this.getChildren().add(lotus1);
		
		this.fish0.setLayoutX(202);
		this.fish0.setLayoutY(148);
		this.fish1.setLayoutX(269);
		this.fish1.setLayoutY(164);
		this.fish2.setLayoutX(1075);
		this.fish2.setLayoutY(290);
		this.fish3.setLayoutX(1070);
		this.fish3.setLayoutY(365);
		this.leaf0.setLayoutX(236);
		this.leaf0.setLayoutY(108);
		this.leaf1.setLayoutX(999);
		this.leaf1.setLayoutY(2225);
		this.lotus0.setLayoutX(139);
		this.lotus0.setLayoutY(302);
		this.lotus1.setLayoutX(882);
		this.lotus1.setLayoutY(122);
		
//		this.startAnimation();
	}
	
//	public void startAnimation(){
//		
//		
//		Timeline timeLine = new Timeline(
//				//CLOUD0
//				new KeyFrame(Duration.millis(20000), new KeyValue(cloud0.xProperty(), 400)),
//				//CLOUD1
//				new KeyFrame(Duration.millis(10000), new KeyValue(cloud1.xProperty(), 500)),
//				new KeyFrame(Duration.millis(20000), new KeyValue(cloud1.xProperty(), 100)),
//				//CLOUD2
//				new KeyFrame(Duration.millis(10000),new KeyValue(cloud2.xProperty(), -500)),
//				new KeyFrame(Duration.millis(20000),new KeyValue(cloud2.xProperty(), -300))
//		);
//		timeLine.setCycleCount(Timeline.INDEFINITE);
//		timeLine.setAutoReverse(true);
//		timeLine.play();
//		
//	    
//	
//	}
	
	



}
