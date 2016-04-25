package view;



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
		
		Rectangle bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setY(25+strokeWidth);
		bgRect.setWidth(200);
		bgRect.setHeight(120);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		
		
		Polygon triangle = new Polygon();
		triangle.getPoints().addAll(new Double[]{
		    95.0, 147.0,
		    105.0, 147.0,
		    100.0, 157.0 });
		triangle.setFill(Color.WHITE);
		
		
		Circle bgCircle = new Circle();
		bgCircle.setCenterX(100.0);
		bgCircle.setCenterY(25+strokeWidth);
		bgCircle.setRadius(25);
		bgCircle.setStroke(Color.WHITE);
		bgCircle.setStrokeWidth(strokeWidth);
		bgCircle.setStrokeType(StrokeType.OUTSIDE);
		bgCircle.setFill(Color.WHITE);
		
		Arc bloodArc = new Arc();
		bloodArc.setCenterX(100.0);
		bloodArc.setCenterY(25+strokeWidth);
		bloodArc.setRadiusX(25);
		bloodArc.setRadiusY(25);
		bloodArc.setStartAngle(0);
		bloodArc.setLength(-270);
		bloodArc.setType(ArcType.ROUND);
		bloodArc.setFill(GameColor.getOtherColor(3));
		//这个圆以后换成图片
		Circle centralCircle = new Circle();
		centralCircle.setCenterX(100.0);
		centralCircle.setCenterY(25+strokeWidth);
		centralCircle.setRadius(22);
		centralCircle.setFill(Color.WHITE);
		
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
		
		stateIcon1.setLayoutX(15);
		stateIcon1.setLayoutY(62);
		stateIcon2.setLayoutX(76);
		stateIcon2.setLayoutY(62);
		stateIcon3.setLayoutX(135);
		stateIcon3.setLayoutY(62);
		stateIcon4.setLayoutX(13);
		stateIcon4.setLayoutY(107);
		stateIcon5.setLayoutX(75);
		stateIcon5.setLayoutY(104);
		stateIcon6.setLayoutX(135);
		stateIcon6.setLayoutY(107);
		
		this.getChildren().add(bgRect);
		this.getChildren().add(triangle);
		this.getChildren().add(bgCircle);		
		this.getChildren().add(bloodArc);
		this.getChildren().add(centralCircle);
		this.getChildren().add(stateIcon1);
		this.getChildren().add(stateIcon2);
		this.getChildren().add(stateIcon3);
		this.getChildren().add(stateIcon4);
		this.getChildren().add(stateIcon5);
		this.getChildren().add(stateIcon6);
		
		this.setVisible(false);
		
	}	
	
	public void setAppear(boolean isAppear) {
		// TODO Auto-generated method stub
		this.isAppear = isAppear;
		this.setVisible(isAppear);
	}

	public void setCurrentSamurai(SamuraiPanel samurai) {
		// TODO Auto-generated method stub
		this.currentSamurai = samurai;
		this.setActualLocation();
		
	}
	
	public void setActualLocation(){
		this.setLayoutX(currentSamurai.getLayoutX() +SAMURAI_WIDTH/2-prefWidth/2);
		this.setLayoutY(currentSamurai.getLayoutY()-prefHeight+10);
	}

}
