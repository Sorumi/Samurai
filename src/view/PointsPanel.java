package view;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class PointsPanel extends Pane {

	private final int PANEL_WIDTH = 200;
	private final int PANEL_HEIGHT = 30;
	private final int strokeSize = 2;
//	private int labelX;

	private int player;
	private int pointsTotal;
	private int pointsRest;
	private int currentSamurai;
	private boolean isShow;
	
	private Rectangle fillRect;
	private Label pointsLabel;
	
	public PointsPanel(int player) {
		this.player = player;
		this.isShow = true;
		//bounds
//		this.setPrefWidth(PANEL_WIDTH+2*strokeSize);
//		this.setPrefHeight(PANEL_HEIGHT+2*strokeSize);
		this.setVisible(false);
		
		//bg
		Rectangle bgRect = new Rectangle();
		bgRect.setX(strokeSize);
		bgRect.setY(strokeSize);
		bgRect.setWidth(PANEL_WIDTH);
		bgRect.setHeight(PANEL_HEIGHT);
		bgRect.setArcWidth(PANEL_HEIGHT);
		bgRect.setArcHeight(PANEL_HEIGHT);
		bgRect.setStroke(Color.WHITE);
		bgRect.setStrokeWidth(strokeSize);
		bgRect.setStrokeType(StrokeType.OUTSIDE);
		bgRect.setFill(Color.WHITE);
		this.getChildren().add(bgRect);
		
		//fill		
		fillRect = new Rectangle();
		fillRect.setX(strokeSize);
		fillRect.setY(strokeSize);
		fillRect.setWidth(PANEL_WIDTH);
		fillRect.setHeight(PANEL_HEIGHT);
		fillRect.setArcWidth(PANEL_HEIGHT);
		fillRect.setArcHeight(PANEL_HEIGHT);
		this.getChildren().add(fillRect);
		
		//label		
		pointsLabel = new Label("10");
		pointsLabel.setId("point-label");
		pointsLabel.setTextFill(Color.WHITE);
		
		
		pointsLabel.setLayoutY(strokeSize+4);
		pointsLabel.setPrefWidth(40);
		if(player == 0){
			pointsLabel.setLayoutX(PANEL_WIDTH-50);
			pointsLabel.setAlignment(Pos.CENTER_RIGHT);
		}else{
			pointsLabel.setLayoutX(10);
			pointsLabel.setAlignment(Pos.CENTER_LEFT);
		}
		this.getChildren().add(pointsLabel);
		
		
	}
	
	public void setIsShow(boolean isShow){
		this.isShow = isShow;
		this.setVisible(isShow);
	}
	
	public void setCurrentSamurai(int currentSamurai){
		this.currentSamurai = currentSamurai;
		fillRect.setFill(GameColor.getBlockColor(currentSamurai));
	}

	public void setPointsRest(int pointsRest) {
		this.pointsRest = pointsRest;
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				pointsLabel.setText(pointsRest + "");

				System.out.println("rest point" + pointsRest);
			}
		});

		double width = (float)PANEL_WIDTH/pointsTotal*pointsRest;

		Timeline timeline = new Timeline(
				new KeyFrame(Duration.millis(500), new KeyValue(fillRect.widthProperty(),width,Interpolator.EASE_IN)));
		if (player == 1){
			KeyValue kv = new KeyValue(fillRect.xProperty(), strokeSize+(float)PANEL_WIDTH-width, Interpolator.EASE_IN);
			KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
			timeline.getKeyFrames().add(kf);
			
			KeyValue kvLabel = new KeyValue(pointsLabel.layoutXProperty(), strokeSize+(float)PANEL_WIDTH-width+10, Interpolator.EASE_IN);
			KeyFrame kfLabel = new KeyFrame(Duration.millis(500), kvLabel);
			timeline.getKeyFrames().add(kfLabel);
		}else{
			KeyValue kvLabel = new KeyValue(pointsLabel.layoutXProperty(), width-50, Interpolator.EASE_IN);
			KeyFrame kfLabel = new KeyFrame(Duration.millis(500), kvLabel);
			timeline.getKeyFrames().add(kfLabel);
		}

		timeline.play();
		
	}

	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
		this.pointsRest = pointsTotal;
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				pointsLabel.setText(pointsRest + "");

				System.out.println("total point:" + pointsTotal);
			}
		});
	}

}
