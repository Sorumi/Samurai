package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CirclePanel extends Pane {

	private final int CIRCLE_RADIUS = 100;
	private final int RATIO = 2; //比例
	private final int strokeSize = 2;
	
	private int size;
	private int player;
	private int timeTotal;
	private int timeRest;
	private int direction;

	private int blocksNum;
	
	private ImageView logo;
	private ImageView originalLogo; 
	private BlockArc[] arcs;
	private Arc timeArc;
	private Label blockLabel;
	
	private Timeline timeline;
	
	private boolean isFront;

	private class BlockArc extends Arc{
		private int blockNum;
		
		BlockArc(){
			blockNum = 1;
		}
	}
	
	public CirclePanel(int player, int timeTotal) {
		this.player = player;
		this.timeTotal = timeTotal;
		
		Image image = Images.PLAYER_LOGO[player];
		logo = new ImageView(image);
		logo.setFitWidth(image.getWidth()/RATIO);
		logo.setPreserveRatio(true);
		logo.setRotationAxis(Rotate.Y_AXIS);
		logo.setRotate(270);
		
		originalLogo = new ImageView(Images.PLAYER_LOGO_0);
		originalLogo.setFitWidth(image.getWidth()/RATIO);
		originalLogo.setPreserveRatio(true);
		originalLogo.setRotationAxis(Rotate.Y_AXIS);
		originalLogo.setRotate(360);
		
		
		direction = 1;
		if (player == 1){
			direction = -1;
		}
		timeline = new Timeline();
		//TODO
		size = 15;
		isFront = false;
		
		//Circle
		Circle blockCircle = new Circle();
		if (player == 0){
			blockCircle.setCenterX(23);
		}else{
			blockCircle.setCenterX(CIRCLE_RADIUS*2+strokeSize*2-23);
		}
		blockCircle.setCenterY(23);
		blockCircle.setRadius(23);
		blockCircle.setFill(Color.WHITE);
		this.getChildren().add(blockCircle);
		
		blockLabel = new Label("");
		blockLabel.setId("block-label");
		blockLabel.setPrefWidth(30);
		if (player == 0){
			blockLabel.setLayoutX(6);
		}else{
			blockLabel.setLayoutX(CIRCLE_RADIUS*2+strokeSize*2-38);
		}
		
		blockLabel.setLayoutY(14);
		this.getChildren().add(blockLabel);
		
		Circle bgCircle = new Circle();
		bgCircle.setCenterX(CIRCLE_RADIUS+strokeSize);
		bgCircle.setCenterY(CIRCLE_RADIUS+strokeSize);
		bgCircle.setRadius(CIRCLE_RADIUS);
		bgCircle.setFill(Color.WHITE);
		bgCircle.setStroke(Color.WHITE);
		bgCircle.setStrokeWidth(strokeSize);
		bgCircle.setStrokeType(StrokeType.OUTSIDE);
		this.getChildren().add(bgCircle);
		
		//block Arc
		arcs = new BlockArc[3];
		if(player == 0){
			double startAngle = 90.0;
			double preAngle = -180.0 / (size*size);
			for (int i=0; i<arcs.length; i++){
				arcs[i] = new BlockArc();
				BlockArc tmpArc = arcs[i];
				tmpArc.setCenterX(CIRCLE_RADIUS+strokeSize);
				tmpArc.setCenterY(CIRCLE_RADIUS+strokeSize);
				tmpArc.setRadiusX(CIRCLE_RADIUS);
				tmpArc.setRadiusY(CIRCLE_RADIUS);
				tmpArc.setStartAngle(startAngle);
				tmpArc.setLength(preAngle * tmpArc.blockNum);
				tmpArc.setType(ArcType.ROUND);
				tmpArc.setFill(GameColor.getBlockColor(i+1));
				this.getChildren().add(tmpArc);
				startAngle += preAngle * tmpArc.blockNum;
			}
		}else{
			double startAngle = 90.0;
			double preAngle = 180.0 / (size*size);
			for (int i=0; i<arcs.length; i++){
				arcs[i] = new BlockArc();
				BlockArc tmpArc = arcs[i];
				tmpArc.setCenterX(CIRCLE_RADIUS+strokeSize);
				tmpArc.setCenterY(CIRCLE_RADIUS+strokeSize);
				tmpArc.setRadiusX(CIRCLE_RADIUS);
				tmpArc.setRadiusY(CIRCLE_RADIUS);
				tmpArc.setStartAngle(startAngle);
				tmpArc.setLength(preAngle * tmpArc.blockNum);
				tmpArc.setType(ArcType.ROUND);
				tmpArc.setFill(GameColor.getBlockColor(i+4));
				this.getChildren().add(tmpArc);
				startAngle += preAngle * tmpArc.blockNum;
			}
		}
		
		
		for (int i=0; i<arcs.length; i++){
			Arc tmpArc = arcs[i];
			tmpArc.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					BlockArc arc = (BlockArc) event.getSource();
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							blockLabel.setText(arc.blockNum + "");
							blockLabel.setTextFill(arc.getFill());
						}
					});

					Timeline timeline = new Timeline();
					KeyValue kv1 = new KeyValue(tmpArc.radiusXProperty(), 110);
					KeyFrame kf1 = new KeyFrame(Duration.millis(100), kv1);
					KeyValue kv2 = new KeyValue(tmpArc.radiusYProperty(), 110);
					KeyFrame kf2 = new KeyFrame(Duration.millis(100), kv2);
					timeline.getKeyFrames().add(kf1);
					timeline.getKeyFrames().add(kf2);
					timeline.play();
				}
	        });
			tmpArc.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							blockLabel.setText(blocksNum + "");
							blockLabel.setTextFill(GameColor.getOtherColor(2));
						}
					});
					Timeline timeline = new Timeline();
					KeyValue kv1 = new KeyValue(tmpArc.radiusXProperty(), 100);
					KeyFrame kf1 = new KeyFrame(Duration.millis(100), kv1);
					KeyValue kv2 = new KeyValue(tmpArc.radiusYProperty(), 100);
					KeyFrame kf2 = new KeyFrame(Duration.millis(100), kv2);
					timeline.getKeyFrames().add(kf1);
					timeline.getKeyFrames().add(kf2);
					timeline.play();
				}
	        });
		}
		//blockLabel
		blocksNum = arcs[0].blockNum + arcs[1].blockNum + arcs[2].blockNum;
		blockLabel.setText(blocksNum + "");
		
		//time Arc
		double startAngle = 90.0;
		double preAngle = 180.0*direction / timeTotal;
		timeArc = new Arc();
		timeArc.setCenterX(CIRCLE_RADIUS+strokeSize);
		timeArc.setCenterY(CIRCLE_RADIUS+strokeSize);
		timeArc.setRadiusX(CIRCLE_RADIUS);
		timeArc.setRadiusY(CIRCLE_RADIUS);
		timeArc.setStartAngle(startAngle);
		timeArc.setLength(preAngle * timeRest);
		timeArc.setType(ArcType.ROUND);
		timeArc.setFill(GameColor.getOtherColor(player));
		this.getChildren().add(timeArc);
		
		//Logo
		logo.setLayoutX(strokeSize+CIRCLE_RADIUS-image.getWidth()/RATIO/2);
		logo.setLayoutY(strokeSize+CIRCLE_RADIUS-image.getHeight()/RATIO/2);
		this.getChildren().add(logo); 
		originalLogo.setLayoutX(strokeSize+CIRCLE_RADIUS-image.getWidth()/RATIO/2);
		originalLogo.setLayoutY(strokeSize+CIRCLE_RADIUS-image.getHeight()/RATIO/2);
		this.getChildren().add(originalLogo);

	}

	public void setTimeRest(int timeRest) {
		timeline = new Timeline();
		KeyValue kv = new KeyValue(timeArc.lengthProperty(), 180*direction/timeTotal*(timeRest-1));
		KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();
	}

	public void setNewTime(boolean isCurrent) {
		if(isCurrent){
			timeline.stop();
			this.timeRest = timeTotal;
			timeArc.setLength(180*direction);
		}else{
			timeline.stop();
			this.timeRest = 0;
			timeArc.setLength(0);
		}
	}
	
	public void flip(boolean isRotate){
		if(isRotate && isFront == false){
			RotateTransition rotator1 = new RotateTransition(Duration.millis(1000), originalLogo);
			rotator1.setAxis(Rotate.Y_AXIS);
			rotator1.setFromAngle(0);
			rotator1.setToAngle(90);
			
			RotateTransition rotator2 = new RotateTransition(Duration.millis(1000), logo);
			rotator2.setAxis(Rotate.Y_AXIS);
			rotator2.setFromAngle(270);
			rotator2.setToAngle(360);
			
			rotator1.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					rotator2.play();
					
				}
			});
			rotator1.play();
			isFront = true;
		}else if(!isRotate && isFront == true){
			RotateTransition rotator1 = new RotateTransition(Duration.millis(1000), logo);
			rotator1.setAxis(Rotate.Y_AXIS);
			rotator1.setFromAngle(0);
			rotator1.setToAngle(90);
			
			RotateTransition rotator2 = new RotateTransition(Duration.millis(1000), originalLogo);
			rotator2.setAxis(Rotate.Y_AXIS);
			rotator2.setFromAngle(270);
			rotator2.setToAngle(360);
			
			rotator1.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					rotator2.play();
					
				}
			});
			rotator1.play();
			isFront = false;
		}
	}

	public void setBlocks(int[] blockNum) {
		for(int i=0; i<blockNum.length; i++){
			arcs[i].blockNum = blockNum[i];
		}
		this.blocksNum = arcs[0].blockNum + arcs[1].blockNum + arcs[2].blockNum;
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				blockLabel.setText(blocksNum + "");
			}
		});
		
		if (player == 0){
			double startAngle = 90.0;
			double preAngle = -180.0 / (size*size);
			timeline = new Timeline(
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[0].lengthProperty(), preAngle*blockNum[0])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[1].startAngleProperty(), startAngle+preAngle*blockNum[0])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[1].lengthProperty(), preAngle*blockNum[1])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[2].startAngleProperty(), startAngle+preAngle*blockNum[0]+preAngle*blockNum[1])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[2].lengthProperty(), preAngle*blockNum[2]))
					);
			timeline.play();
		}else{
			double startAngle = 90.0;
			double preAngle = 180.0 / (size*size);
			timeline = new Timeline(
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[0].lengthProperty(), preAngle*blockNum[0])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[1].startAngleProperty(), startAngle+preAngle*blockNum[0])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[1].lengthProperty(), preAngle*blockNum[1])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[2].startAngleProperty(), startAngle+preAngle*blockNum[0]+preAngle*blockNum[1])),
					new KeyFrame(Duration.millis(500), new KeyValue(arcs[2].lengthProperty(), preAngle*blockNum[2]))
					);

			timeline.play();
		
		}
	}

}
