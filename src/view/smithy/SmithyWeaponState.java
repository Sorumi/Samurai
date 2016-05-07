package view.smithy;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import view.GameColor;
import view.Images;
import view.SamuraiPanel;
import view.eventhandler.SmithyHandler;
import view.eventhandler.StateHandler;

public class SmithyWeaponState extends Pane{ 
	private int prefWidth = 300;
	private int prefHeight = 157;
	private int strokeWidth = 2;
	
	private boolean isAppear;
	
	private Rectangle bgRect;
	private Polygon triangle;

	private Group iconGroup;
	private ImageView stateIcon2;
	private ImageView stateIcon4;
	private ImageView stateIcon6;
	
	private Label stateLabel2;
	private Label stateLabel4;
	private Label stateLabel6;
	private Label nameLabel;
	private Label amountLabel;
	
	private SmithyItemView smithyItemView;
	
	public SmithyWeaponState(){
		super();
		
		this.isAppear = false;
		this.setPrefWidth(prefWidth);
		this.setPrefHeight(prefHeight);
		this.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 2, 0, 0, 1);");
		this.stateIcon2 = new ImageView(Images.STATE_ICON_2);
		this.stateIcon4 = new ImageView(Images.STATE_ICON_4);
		this.stateIcon6 = new ImageView(Images.STATE_ICON_6);

		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setWidth(300);
		bgRect.setHeight(137);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		triangle = new Polygon();
		triangle.setFill(Color.WHITE);
		
		//icon
		iconGroup = new Group();
		iconGroup.setLayoutX(15);

		stateIcon2.setFitWidth(25);
		stateIcon4.setFitWidth(29);
		stateIcon6.setFitWidth(25);
		
		stateIcon2.setPreserveRatio(true);
		stateIcon4.setPreserveRatio(true);
		stateIcon6.setPreserveRatio(true);
		
		stateIcon2.setLayoutX(-2);
		stateIcon2.setLayoutY(43);
		stateIcon4.setLayoutX(92);
		stateIcon4.setLayoutY(42);
		stateIcon6.setLayoutX(186);
		stateIcon6.setLayoutY(43);
		
		stateLabel2 = new Label("100-900");
		stateLabel2.setLayoutX(25);
		stateLabel2.setLayoutY(52);
		stateLabel2.setId("weaponstate-lable");

		stateLabel4 = new Label("100-900");
		stateLabel4.setLayoutX(119);
		stateLabel4.setLayoutY(52);
		stateLabel4.setId("weaponstate-lable");
		
		stateLabel6 = new Label("100-900");
		stateLabel6.setLayoutX(213);
		stateLabel6.setLayoutY(52);
		stateLabel6.setId("weaponstate-lable");
		
		nameLabel = new Label("武器名字");
		nameLabel.setLayoutX(10);
		nameLabel.setId("weapon-name");  
		
		amountLabel = new Label("库存：2");
		amountLabel.setLayoutX(11);
		amountLabel.setId("weaponamount-lable"); 
		
		iconGroup.getChildren().addAll(stateIcon2, stateIcon4, stateIcon6,  stateLabel2, stateLabel4, stateLabel6);
		this.getChildren().addAll(bgRect, triangle, iconGroup, nameLabel, amountLabel);
		this.setVisible(false);
		
	}
	
	public void setUpLocation(){
		bgRect.setY(0);
		
		triangle.getPoints().addAll(new Double[]{
		    140.0, 137.0,
		    160.0, 137.0,
		    150.0, 157.0 });

		iconGroup.setLayoutY(52);
		nameLabel.setLayoutY(10);
		amountLabel.setLayoutY(40);
	}
	
	public void setDownLocation(){
		bgRect.setY(20);
		
		triangle.getPoints().addAll(new Double[]{
		    140.0, 20.0,
		    160.0, 20.0,
		    150.0, 0.0 });

		iconGroup.setLayoutY(82);
		nameLabel.setLayoutY(30);
		amountLabel.setLayoutY(60);
	}
	


	public void setCurrentItem(SmithyItemView item) {
		// TODO Auto-generated method stub
		this.smithyItemView = item;
		this.setActualLocation();
	}
	
	public void setActualLocation(){
		this.setLayoutX(smithyItemView.getLayoutX()+50);
		if (smithyItemView.getLayoutY()-prefHeight+10>0) {		
			this.setLayoutY(smithyItemView.getLayoutY()-prefHeight+45);
			this.setUpLocation();
		}else{
			this.setLayoutY(smithyItemView.getLayoutY()+smithyItemView.getHeight()+50);
			this.setDownLocation();
		}
	}
	public void setAppear(boolean isAppear) {
		// TODO Auto-generated method stub
		this.isAppear = isAppear;
		this.setVisible(isAppear);
	}

}
