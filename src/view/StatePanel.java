package view;

import javafx.scene.Group;
import javafx.scene.control.Label;
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
	private int SCALE = 1;
	
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
	
	private Label stateLabel1;
	private Label stateLabel2;
	private Label stateLabel3;
	private Label stateLabel4;
	private Label stateLabel5;
	private Label stateLabel6;
	
	private SamuraiPanel currentSamurai;
	private SamuraiView currentSamuraiV;
	
	private StateHandler stateHandler;
	
	public StatePanel(StateHandler stateHandler, int SCALE){
		super();
		
		this.isAppear = false;
		this.stateHandler = stateHandler;
		this.SCALE = SCALE;
		this.setPrefWidth(prefWidth*SCALE); 
		this.setPrefHeight(prefHeight*SCALE);
		
		this.stateIcon1 = new ImageView(Images.STATE_ICON_1);
		this.stateIcon2 = new ImageView(Images.STATE_ICON_2);
		this.stateIcon3 = new ImageView(Images.STATE_ICON_3);
		this.stateIcon4 = new ImageView(Images.STATE_ICON_4);
		this.stateIcon5 = new ImageView(Images.STATE_ICON_5);
		this.stateIcon6 = new ImageView(Images.STATE_ICON_6);
		

		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setWidth(200*SCALE);
		bgRect.setHeight(120*SCALE);
		bgRect.setArcWidth(10*SCALE);
		bgRect.setArcHeight(10*SCALE);
		bgRect.setFill(Color.WHITE);
		
		triangle = new Polygon();
		triangle.setFill(Color.WHITE);
		
		bgCircle = new Circle();
		bgCircle.setCenterX(100.0*SCALE);
		bgCircle.setRadius(25*SCALE);
		bgCircle.setStroke(Color.WHITE);
		bgCircle.setStrokeWidth(strokeWidth*SCALE);
		bgCircle.setStrokeType(StrokeType.OUTSIDE);
		bgCircle.setFill(Color.WHITE);
		
		bloodArc = new Arc();
		bloodArc.setCenterX(100.0*SCALE);
		bloodArc.setRadiusX(25*SCALE);
		bloodArc.setRadiusY(25*SCALE);
		bloodArc.setStartAngle(0);
		bloodArc.setLength(-270);
		bloodArc.setType(ArcType.ROUND);
		bloodArc.setFill(GameColor.getOtherColor(3));
		//这个圆以后换成图片
		centralCircle = new Circle();
		centralCircle.setCenterX(100.0*SCALE);
		centralCircle.setRadius(22*SCALE);
		centralCircle.setFill(Color.WHITE);
		
		//icon
		iconGroup = new Group();
		iconGroup.setLayoutX(15*SCALE);
		
		stateIcon1.setFitWidth(25*SCALE);
		stateIcon2.setFitWidth(25*SCALE);
		stateIcon3.setFitWidth(25*SCALE);
		stateIcon4.setFitWidth(29*SCALE);
		stateIcon5.setFitWidth(26*SCALE);
		stateIcon6.setFitWidth(25*SCALE);
		
		stateIcon1.setPreserveRatio(true);
		stateIcon2.setPreserveRatio(true);
		stateIcon3.setPreserveRatio(true);
		stateIcon4.setPreserveRatio(true);
		stateIcon5.setPreserveRatio(true);
		stateIcon6.setPreserveRatio(true);
		
		stateIcon1.setLayoutX(0);
		stateIcon1.setLayoutY(0);
		stateIcon2.setLayoutX(61*SCALE);
		stateIcon2.setLayoutY(0);
		stateIcon3.setLayoutX(120*SCALE);
		stateIcon3.setLayoutY(0);
		stateIcon4.setLayoutX(-2*SCALE);
		stateIcon4.setLayoutY(43*SCALE);
		stateIcon5.setLayoutX(60*SCALE);
		stateIcon5.setLayoutY(42*SCALE);
		stateIcon6.setLayoutX(120*SCALE);
		stateIcon6.setLayoutY(43*SCALE);
		

		stateLabel1 = new Label("100");
		stateLabel1.setLayoutX(30*SCALE);
		stateLabel1.setLayoutY(7*SCALE);
		stateLabel1.setId("state-lable");
		
		stateLabel2 = new Label("100");
		stateLabel2.setLayoutX(90*SCALE);
		stateLabel2.setLayoutY(7*SCALE);
		stateLabel2.setId("state-lable");
		
		stateLabel3 = new Label("100");
		stateLabel3.setLayoutX(150*SCALE);
		stateLabel3.setLayoutY(7*SCALE);
		stateLabel3.setId("state-lable");
	
		stateLabel4 = new Label("100");
		stateLabel4.setLayoutX(30*SCALE);
		stateLabel4.setLayoutY(52*SCALE);
		stateLabel4.setId("state-lable");
		
		stateLabel5 = new Label("100");
		stateLabel5.setLayoutX(90*SCALE);
		stateLabel5.setLayoutY(52*SCALE);
		stateLabel5.setId("state-lable");
		
		stateLabel6 = new Label("100");
		stateLabel6.setLayoutX(150*SCALE);
		stateLabel6.setLayoutY(52*SCALE);

		stateLabel1 = new Label();
		stateLabel1.setLayoutX(30);
		stateLabel1.setLayoutY(7);
		stateLabel1.setId("state-lable");
		
		stateLabel2 = new Label();
		stateLabel2.setLayoutX(90);
		stateLabel2.setLayoutY(7);
		stateLabel2.setId("state-lable");
		
		stateLabel3 = new Label();
		stateLabel3.setLayoutX(150);
		stateLabel3.setLayoutY(7);
		stateLabel3.setId("state-lable");
	
		stateLabel4 = new Label();
		stateLabel4.setLayoutX(30);
		stateLabel4.setLayoutY(52);
		stateLabel4.setId("state-lable");
		
		stateLabel5 = new Label();
		stateLabel5.setLayoutX(90);
		stateLabel5.setLayoutY(52);
		stateLabel5.setId("state-lable");
		
		stateLabel6 = new Label();
		stateLabel6.setLayoutX(150);
		stateLabel6.setLayoutY(52);

		stateLabel6.setId("state-lable");
		
		iconGroup.getChildren().addAll(stateIcon1, stateIcon2, stateIcon3, stateIcon4, stateIcon5, stateIcon6, stateLabel1, stateLabel2, stateLabel3, stateLabel4, stateLabel5, stateLabel6);
		this.getChildren().addAll(bgRect, triangle, bgCircle, bloodArc, centralCircle, iconGroup);
		this.setVisible(false);  
		
	}
	

 

	private void setUpLocation(){
		bgRect.setY((25+strokeWidth)*SCALE);  

		
		triangle.getPoints().addAll(new Double[]{
		    95.0*SCALE, 147.0*SCALE,
		    105.0*SCALE, 147.0*SCALE,
		    100.0*SCALE, 157.0*SCALE });
		
		bgCircle.setCenterY((25+strokeWidth)*SCALE);
		bloodArc.setCenterY((25+strokeWidth)*SCALE);
		centralCircle.setCenterY((25+strokeWidth)*SCALE);
		iconGroup.setLayoutY(62*SCALE);		
	}
	


	private void setDownLocation(){
		bgRect.setY(10*SCALE); 
		
		triangle.getPoints().addAll(new Double[]{
		    95.0, 10.0,
		    105.0, 10.0,
		    100.0, 0.0 });

		
		bgCircle.setCenterY((prefHeight-25-strokeWidth)*SCALE);
		bloodArc.setCenterY((prefHeight-25-strokeWidth)*SCALE);
		centralCircle.setCenterY((prefHeight-25-strokeWidth)*SCALE);
		iconGroup.setLayoutY(26*SCALE);
	}

	public void setCurrentSamuraiInG(SamuraiPanel samurai) { 
		// TODO Auto-generated method stub
		this.currentSamurai = samurai;

		this.setActualLocationInG(); 
		
	}
	
	public void setActualLocationInG(){
		this.setLayoutX((currentSamurai.getLayoutX() +SAMURAI_WIDTH/2-prefWidth/2)*SCALE);
		if (currentSamurai.getLayoutY()-prefHeight*SCALE+10>0) {		
			this.setLayoutY(currentSamurai.getLayoutY()-prefHeight*SCALE+10);
			this.setUpLocation();
		}else{
			this.setLayoutY(currentSamurai.getLayoutY()+currentSamurai.getHeight());
			this.setDownLocation();
		}
	}

	
	


	public void setCurrentSamuraiInT(SamuraiView samurai) {  
		// TODO Auto-generated method stub
		this.currentSamuraiV = samurai;
		this.setActualLocationInT(); 
		
	}
	
	public void setActualLocationInT(){
		this.setLayoutX(currentSamuraiV.getLayoutX() +SAMURAI_WIDTH/2-prefWidth/2-70);		
		if (currentSamuraiV.getLayoutY()-prefHeight*SCALE+10>0) {		
			this.setLayoutY(currentSamuraiV.getLayoutY()-prefHeight*SCALE+35);
			this.setUpLocation();
		}else{
			this.setLayoutY(currentSamuraiV.getLayoutY()+currentSamuraiV.getHeight());
			this.setDownLocation();
		}
	}



	public void setAppear(boolean isAppear) {
		// TODO Auto-generated method stub
		this.isAppear = isAppear;
		this.setVisible(isAppear); 
	}
	
	public void set6Properties(int[] states){
		if(states.length == 6){
			stateLabel1.setText(states[0] + "");
			stateLabel2.setText(states[1] + "");
			stateLabel3.setText(states[2] + "");
			stateLabel4.setText(states[3] + "");
			stateLabel5.setText(states[4] + "");
			stateLabel6.setText(states[5] + "");	

		}else{
			stateLabel1.setText("");
			stateLabel2.setText("");
			stateLabel3.setText("");
			stateLabel4.setText("");
			stateLabel5.setText("");
			stateLabel6.setText("");
		}
	}

}
