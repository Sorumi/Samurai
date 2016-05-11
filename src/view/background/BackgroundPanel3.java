package view.background;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import view.GameColor;
import view.Images;

public class BackgroundPanel3 extends BackgroundPanel {
	private ImageView bg;
	private ImageView fish0; 
	private ImageView fish1;
	private ImageView fish2;
	private ImageView fish3;
	private ImageView leaf0;
	private ImageView leaf1;
	private ImageView lotus0;
	private ImageView lotus1;
	
	private Arc arc1,arc2,arc3,arc4;
	
	public BackgroundPanel3(){
		super(3);

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
//		this.getChildren().add(leaf1);
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
		this.leaf1.setLayoutX(1099);
		this.leaf1.setLayoutY(225);
		this.lotus0.setLayoutX(139);
		this.lotus0.setLayoutY(302);
		this.lotus1.setLayoutX(882);
		this.lotus1.setLayoutY(122);
		
		Arc arc1 = new Arc();
		arc1.setCenterX(1035);
		arc1.setCenterY(246);
		arc1.setRadiusX(35.5);
		arc1.setRadiusY(21);
		arc1.setStartAngle(0);
		arc1.setLength(360);
		arc1.setFill(null);
		arc1.setType(ArcType.OPEN);
		arc1.setStroke(Color.WHITE);
		arc1.setStrokeWidth(2);
		this.getChildren().add(arc1);
		
		Arc arc2 = new Arc();
		arc2.setCenterX(1035);
		arc2.setCenterY(246);
		arc2.setRadiusX(35.5);
		arc2.setRadiusY(21);
		arc2.setStartAngle(0);
		arc2.setLength(360);
		arc2.setFill(null);
		arc2.setType(ArcType.OPEN);
		arc2.setStroke(Color.WHITE);
		arc2.setStrokeWidth(2);
		this.getChildren().add(arc2);
		
		Arc arc3 = new Arc();
		arc3.setCenterX(1035);
		arc3.setCenterY(246);
		arc3.setRadiusX(35.5);
		arc3.setRadiusY(21);
		arc3.setStartAngle(0);
		arc3.setLength(360);
		arc3.setFill(null);
		arc3.setType(ArcType.OPEN);
		arc3.setStroke(Color.WHITE);
		arc3.setStrokeWidth(2);
		this.getChildren().add(arc3);
		
		Arc arc4 = new Arc();
		arc4.setCenterX(1035);
		arc4.setCenterY(246);
		arc4.setRadiusX(35.5);
		arc4.setRadiusY(21);
		arc4.setStartAngle(0);
		arc4.setLength(360);
		arc4.setFill(null);
		arc4.setType(ArcType.OPEN);
		arc4.setStroke(Color.WHITE);
		arc4.setStrokeWidth(2);
		this.getChildren().add(arc4);
		this.getChildren().add(leaf1);

		this.setOnMouseClicked(new EventHandler<MouseEvent>() { 
			@Override
			public void handle(MouseEvent event) { 
				// TODO Auto-generated method stub
			
				
				Timeline timeline = new Timeline(new KeyFrame(Duration.millis(0), new KeyValue(arc1.radiusXProperty(), 35.5)),
						new KeyFrame(Duration.millis(0), new KeyValue(arc1.radiusYProperty(), 21)),
						new KeyFrame(Duration.millis(10000), new KeyValue(arc1.radiusXProperty(), 150)),
						new KeyFrame(Duration.millis(10000), new KeyValue(arc1.radiusYProperty(), 140)),
						new KeyFrame(Duration.millis(0), new KeyValue(arc2.radiusXProperty(), 35.5)),
						new KeyFrame(Duration.millis(0), new KeyValue(arc2.radiusYProperty(), 21)),
						new KeyFrame(Duration.millis(2000), new KeyValue(arc2.radiusXProperty(), 35.5)),
						new KeyFrame(Duration.millis(2000), new KeyValue(arc2.radiusYProperty(), 21)),
						new KeyFrame(Duration.millis(12000), new KeyValue(arc2.radiusXProperty(), 150)),
						new KeyFrame(Duration.millis(12000), new KeyValue(arc2.radiusYProperty(), 140)),
						new KeyFrame(Duration.millis(0), new KeyValue(arc3.radiusXProperty(), 35.5)),
						new KeyFrame(Duration.millis(0), new KeyValue(arc3.radiusYProperty(), 21)),
						new KeyFrame(Duration.millis(4000), new KeyValue(arc3.radiusXProperty(), 35.5)),
						new KeyFrame(Duration.millis(4000), new KeyValue(arc3.radiusYProperty(), 21)),
						new KeyFrame(Duration.millis(14000), new KeyValue(arc3.radiusXProperty(), 150)),
						new KeyFrame(Duration.millis(14000), new KeyValue(arc3.radiusYProperty(), 140)),
						new KeyFrame(Duration.millis(0), new KeyValue(arc4.radiusXProperty(), 35.5)),
						new KeyFrame(Duration.millis(0), new KeyValue(arc4.radiusYProperty(), 21)),
						new KeyFrame(Duration.millis(6000), new KeyValue(arc4.radiusXProperty(), 35.5)),
						new KeyFrame(Duration.millis(6000), new KeyValue(arc4.radiusYProperty(), 21)),
						new KeyFrame(Duration.millis(16000), new KeyValue(arc4.radiusXProperty(), 150)),
						new KeyFrame(Duration.millis(16000), new KeyValue(arc4.radiusYProperty(), 140))
						);
				timeline.play();
			
				System.out.println("aaaa");
				FadeTransition ft1 = new FadeTransition(Duration.millis(6000), arc1);
				ft1.setFromValue(1.0);
				ft1.setToValue(0.0);
				ft1.play();
				FadeTransition ft2 = new FadeTransition(Duration.millis(8000), arc2);
				ft2.setFromValue(1.0);
				ft2.setToValue(0.0);
				ft2.play();
				FadeTransition ft3 = new FadeTransition(Duration.millis(10000), arc3);
				ft3.setFromValue(1.0);
				ft3.setToValue(0.0);
				ft3.play();
				FadeTransition ft4 = new FadeTransition(Duration.millis(12000), arc4);
				ft4.setFromValue(1.0);
				ft4.setToValue(0.0);
				ft4.play();
				
				
			}
        });
		
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
