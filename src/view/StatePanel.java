package view;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import view.Images;
import view.eventhandler.ActionHandler;
import view.eventhandler.StateHandler;

public class StatePanel extends OrderPanel { 
	private final int SAMURAI_WIDTH = 60;
	private int prefWidth = 200;
	private int prefHeight = 157;
	private int strokeWidth = 2;
	
	private boolean isAppear;
	
	private Rectangle bgRect;
	private Polygon triangle;
	private Circle bgCircle;
	private Arc bloodArc;
	private Circle centralCircle;

	private Group iconGroup;
	private ImageView stateIcon1;
	private ImageView stateIcon2;
	private ImageView stateIcon3;
	private ImageView stateIcon4;
	private ImageView stateIcon5;
	private ImageView stateIcon6;
	
	private SamuraiPanel currentSamurai;
	
	private StateHandler stateHandler;
	
	public StatePanel(StateHandler stateHandler){
		super();
		
		this.isAppear = false;
		this.stateHandler = stateHandler;
		this.setPrefWidth(prefWidth);
		this.setPrefHeight(prefHeight);
		
		this.stateIcon1 = new ImageView(Images.STATE_ICON_1);
		this.stateIcon2 = new ImageView(Images.STATE_ICON_2);
		this.stateIcon3 = new ImageView(Images.STATE_ICON_3);
		this.stateIcon4 = new ImageView(Images.STATE_ICON_4);
		this.stateIcon5 = new ImageView(Images.STATE_ICON_5);
		this.stateIcon6 = new ImageView(Images.STATE_ICON_6);
		
		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setWidth(200);
		bgRect.setHeight(120);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		
		
		triangle = new Polygon();
		triangle.setFill(Color.WHITE);
		
		bgCircle = new Circle();
		bgCircle.setCenterX(100.0);
		bgCircle.setRadius(25);
		bgCircle.setStroke(Color.WHITE);
		bgCircle.setStrokeWidth(strokeWidth);
		bgCircle.setStrokeType(StrokeType.OUTSIDE);
		bgCircle.setFill(Color.WHITE);
		
		bloodArc = new Arc();
		bloodArc.setCenterX(100.0);
		bloodArc.setRadiusX(25);
		bloodArc.setRadiusY(25);
		bloodArc.setStartAngle(0);
		bloodArc.setLength(-270);
		bloodArc.setType(ArcType.ROUND);
		bloodArc.setFill(GameColor.getOtherColor(3));
		//这个圆以后换成图片
		centralCircle = new Circle();
		centralCircle.setCenterX(100.0);
		centralCircle.setRadius(22);
		centralCircle.setFill(Color.WHITE);
		
		//icon
		iconGroup = new Group();
		
		stateIcon1.setFitWidth(25);
		stateIcon2.setFitWidth(25);
		stateIcon3.setFitWidth(25);
		stateIcon4.setFitWidth(29);
		stateIcon5.setFitWidth(26);
		stateIcon6.setFitWidth(25);
		
		stateIcon1.setPreserveRatio(true);
		stateIcon2.setPreserveRatio(true);
		stateIcon3.setPreserveRatio(true);
		stateIcon4.setPreserveRatio(true);
		stateIcon5.setPreserveRatio(true);
		stateIcon6.setPreserveRatio(true);
		
		stateIcon1.setLayoutX(0);
		stateIcon1.setLayoutY(0);
		stateIcon2.setLayoutX(61);
		stateIcon2.setLayoutY(0);
		stateIcon3.setLayoutX(120);
		stateIcon3.setLayoutY(0);
		stateIcon4.setLayoutX(-2);
		stateIcon4.setLayoutY(45);
		stateIcon5.setLayoutX(60);
		stateIcon5.setLayoutY(42);
		stateIcon6.setLayoutX(120);
		stateIcon6.setLayoutY(43);
		
		iconGroup.getChildren().addAll(stateIcon1, stateIcon2, stateIcon3, stateIcon4, stateIcon5, stateIcon6);
		this.getChildren().addAll(bgRect, triangle, bgCircle, bloodArc, centralCircle, iconGroup);
		this.setVisible(false);
		
	}
	
	public void setUpLocation(){
		bgRect.setY(25+strokeWidth); 
		
		triangle.getPoints().addAll(new Double[]{
		    95.0, 147.0,
		    105.0, 147.0,
		    100.0, 157.0 });
		
		bgCircle.setCenterY(25+strokeWidth);
		bloodArc.setCenterY(25+strokeWidth);
		centralCircle.setCenterY(25+strokeWidth);
		iconGroup.setLayoutX(25);
		iconGroup.setLayoutY(62);		
	}
	
	public void setDownLocation(){
		bgRect.setY(10);
		
		triangle.getPoints().addAll(new Double[]{
		    95.0, 10.0,
		    105.0, 10.0,
		    100.0, 0.0 });

		
		bgCircle.setCenterY(prefHeight-25-strokeWidth);
		bloodArc.setCenterY(prefHeight-25-strokeWidth);
		centralCircle.setCenterY(prefHeight-25-strokeWidth);
		
		iconGroup.setLayoutX(25);
		iconGroup.setLayoutY(26);
	}
	


	public void setCurrentSamurai(SamuraiPanel samurai) {
		// TODO Auto-generated method stub
		this.currentSamurai = samurai;
		this.setActualLocation();
		
	}
	
	public void setActualLocation(){
		this.setLayoutX(currentSamurai.getLayoutX() +SAMURAI_WIDTH/2-prefWidth/2);
		if (currentSamurai.getLayoutY()-prefHeight+10>0) {		
			this.setLayoutY(currentSamurai.getLayoutY()-prefHeight+10);
			this.setUpLocation();
		}else{
			this.setLayoutY(currentSamurai.getLayoutY()+currentSamurai.getHeight());
			this.setDownLocation();
		}
	}
	public void setAppear(boolean isAppear) {
		// TODO Auto-generated method stub
		this.isAppear = isAppear;
		this.setVisible(isAppear);
	}
}
