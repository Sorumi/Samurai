package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
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

	private int[] blockNum = {0,0,0,0,0,0,0};
	
	private ImageView logo;
	private Arc[] arcs;
	private Arc timeArc;
	
	Timeline timeline;

	
	public CirclePanel(int player, int timeTotal) {
		this.player = player;
		this.timeTotal = timeTotal;
		Image image = Images.PLAYER_LOGO[player];
		this.logo = new ImageView(image);
		this.logo.setFitWidth(image.getWidth()/RATIO);
		this.logo.setPreserveRatio(true);
		direction = 1;
		if (player == 1){
			direction = -1;
		}
		timeline = new Timeline();
		//TODO
		size = 15;
		blockNum[0] = 52;
		blockNum[1] = 38;
		blockNum[2] = 27;
		blockNum[3] = 32;
		blockNum[4] = 49;
		blockNum[5] = 23;
		
		//Circle
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
		arcs = new Arc[6];
		double startAngle = 90.0;
		double preAngle = -180.0*direction / (size*size);
		for (int i=0; i<arcs.length/2; i++){
			arcs[i] = new Arc();
			Arc tmpArc = arcs[i];
			tmpArc.setCenterX(CIRCLE_RADIUS+strokeSize);
			tmpArc.setCenterY(CIRCLE_RADIUS+strokeSize);
			tmpArc.setRadiusX(CIRCLE_RADIUS);
			tmpArc.setRadiusY(CIRCLE_RADIUS);
			tmpArc.setStartAngle(startAngle);
			tmpArc.setLength(preAngle * blockNum[i]);
			tmpArc.setType(ArcType.ROUND);
			tmpArc.setFill(GameColor.getBlockColor(i+1));
			this.getChildren().add(tmpArc);
			startAngle += preAngle * blockNum[i];
		}
		startAngle = -90.0;
		preAngle = 180.0*direction / (size*size);
		for (int i=arcs.length/2; i<arcs.length; i++){
			arcs[i] = new Arc();
			Arc tmpArc = arcs[i];
			tmpArc.setCenterX(CIRCLE_RADIUS+strokeSize);
			tmpArc.setCenterY(CIRCLE_RADIUS+strokeSize);
			tmpArc.setRadiusX(CIRCLE_RADIUS);
			tmpArc.setRadiusY(CIRCLE_RADIUS);
			tmpArc.setStartAngle(startAngle);
			tmpArc.setLength(preAngle * blockNum[i]);
			tmpArc.setType(ArcType.ROUND);
			tmpArc.setFill(GameColor.getBlockColor(i+1));
			this.getChildren().add(tmpArc);
			startAngle += preAngle * blockNum[i];
		}
		for (int i=0; i<arcs.length; i++){
			Arc tmpArc = arcs[i];
			tmpArc.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
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
		
		//time Arc
		startAngle = 90.0;
		preAngle = 180.0*direction / timeTotal;
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

}
