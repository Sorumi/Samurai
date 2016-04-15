package view;

import javafx.animation.ScaleTransition;
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
	private int pointsTotal = 7;
	private int pointsRest = 6;
	private int currentSamurai = 2;
	private boolean isShow;
	
	Rectangle clipRect;
	Rectangle fillRect;
	Shape fillShape;
	
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
		fillRect.setWidth(PANEL_WIDTH/pointsTotal*pointsRest);
		fillRect.setHeight(PANEL_HEIGHT);
		
		clipRect = new Rectangle();
		clipRect.setX(strokeSize);
		clipRect.setY(strokeSize);
		clipRect.setWidth(PANEL_WIDTH);
		clipRect.setHeight(PANEL_HEIGHT);
		clipRect.setArcWidth(PANEL_HEIGHT);
		clipRect.setArcHeight(PANEL_HEIGHT);

		fillShape = Shape.intersect(clipRect, fillRect);
		fillShape.setFill(GameColor.getBlockColor(currentSamurai));
		this.getChildren().add(fillShape);
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
		//TODO
	}

	public void setPointsRest(int pointsRest) {
		// TODO Auto-generated method stub
		fillRect.setWidth(PANEL_WIDTH/pointsTotal*pointsRest);
		fillShape = Shape.intersect(clipRect, fillRect);
	}

	public void setPointsTotal(int pointsTotal) {
		// TODO Auto-generated method stub
		this.pointsTotal = pointsTotal;
	}

}
