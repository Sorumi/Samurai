package view;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
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
		
		//string
		
		
	}
	
	public void setIsShow(boolean isShow){
//		if (isShow != this.isShow){
//			ScaleTransition st = new ScaleTransition(Duration.millis(1000), this);
//			if(isShow){
//				st.setToX(10f);
//			}else{
//				st.setToX(0.1f);
//			}
//			st.play();
//		}
		this.isShow = isShow;
		this.setVisible(isShow);
	}
	
	public void setCurrentSamurai(int currentSamurai){
		this.currentSamurai = currentSamurai;
		fillRect.setFill(GameColor.getBlockColor(currentSamurai));
	}

	public void setPointsRest(int pointsRest) {
		this.pointsRest = pointsRest;
		double width = (float)PANEL_WIDTH/pointsTotal*pointsRest;

		Timeline timeline = new Timeline(
				new KeyFrame(Duration.millis(500), new KeyValue(fillRect.widthProperty(),width,Interpolator.EASE_BOTH)));
		if (player == 1){
			KeyValue kv = new KeyValue(fillRect.xProperty(), strokeSize+(float)PANEL_WIDTH-width, Interpolator.EASE_BOTH);
			KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
			timeline.getKeyFrames().add(kf);
		}
		timeline.play();
		
	}

	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}

}
