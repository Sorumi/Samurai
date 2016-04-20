package view;

import java.util.Collections;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class SamuraiView extends Pane{
	
	private final int WIDTH = 60;
	private final int HEIGHT = 120;
	private final int BODY_X = WIDTH/2-10;
	private final int BODY_Y = 60;

	private int number;
	private int weaponNum;
	
	private OrderImageView helmetBack;
	private OrderImageView leftShoulder;
	private OrderImageView leftArm;
	private OrderImageView headInjured;
	private OrderImageView head;
	private OrderImageView body;
	private OrderImageView leftLeg;
	private OrderImageView rightLeg;
	private OrderImageView rightShoulder;
	private OrderImageView rightArm;
	private OrderImageView helmet;
	
	private WeaponView weapon;
	
	Rotate leftArmRo;
	Rotate rightArmRo;
	Rotate leftLegRo;
	Rotate rightLegRo;
	Rotate weaponRo;
	
	private Group group;
	
	private  ObservableList<OrderImageView>  orderList;
	
	private int direction;// 0 up 1 left 2 right 3 down 4 
	private int flip;
	private int back;
	private boolean isInjured;
	
	private double[] leftArmAngle;
	private double[] rightArmAngle;
	private double[] leftLegAngle;
	private double[] rightLegAngle;


	
	public SamuraiView(int number){
		this.number = number;
		
		//bounds
		this.setPrefWidth(WIDTH);
		this.setPrefHeight(HEIGHT);
//		this.setStyle("-fx-background-color: rgba(0,0,0,0.1)");

		this.direction = 2;
		
		group = new Group();
		this.getChildren().add(group);
		
		//images
		helmetBack = new OrderImageView(Images.SAMURAI[number][1]);
		leftShoulder = new OrderImageView(Images.SAMURAI[number][2]);
		leftArm = new OrderImageView(Images.SAMURAI[number][3]);
		headInjured = new OrderImageView(Images.SAMURAI[number][4]);
		head = new OrderImageView(Images.SAMURAI[number][5]);
		body = new OrderImageView(Images.SAMURAI[number][6]);
		leftLeg = new OrderImageView(Images.SAMURAI[number][7]);
		rightLeg = new OrderImageView(Images.SAMURAI[number][8]);
		rightShoulder = new OrderImageView(Images.SAMURAI[number][9]);
		rightArm = new OrderImageView(Images.SAMURAI[number][10]);
		helmet = new OrderImageView(Images.SAMURAI[number][11]);
		
		orderList = FXCollections.observableArrayList(helmetBack, leftShoulder, leftArm, headInjured, head, body, leftLeg, rightLeg, rightShoulder, rightArm, helmet);
		//fitSize
		helmetBack.setFitWidth(53);
		leftShoulder.setFitWidth(14);
		leftArm.setFitWidth(17);
		headInjured.setFitWidth(32);
		head.setFitWidth(32);
		body.setFitWidth(29);
		leftLeg.setFitWidth(12);
		rightLeg.setFitWidth(10);
		rightShoulder.setFitWidth(12);
		rightArm.setFitWidth(18);
		helmet.setFitWidth(55);
		
		for(int i=orderList.size()-1; i>=0; i--){
			OrderImageView tmpImg = orderList.get(i);
			tmpImg.setSmooth(true);
			tmpImg.setPreserveRatio(true);
			tmpImg.setZOrder(2*i);
			group.getChildren().add(tmpImg);
			
		}
		//weapon default
//		weapon = new WeaponView(300);//TODO
//		orderList.add(weapon);
//		group.getChildren().add(weapon);
		
		//layout
		body.setLayoutX(BODY_X);
		body.setLayoutY(BODY_Y);
		helmet.setLayoutX(BODY_X-16);
		helmet.setLayoutY(BODY_Y-53);
		helmetBack.setLayoutX(BODY_X-16);
		helmetBack.setLayoutY(BODY_Y-41);
		headInjured.setLayoutX(BODY_X-3);
		headInjured.setLayoutY(BODY_Y-26);
		head.setLayoutX(BODY_X-3);
		head.setLayoutY(BODY_Y-26);
		leftShoulder.setLayoutX(BODY_X-3);
		leftShoulder.setLayoutY(BODY_Y+3);
		leftArm.setLayoutX(BODY_X-8);
		leftArm.setLayoutY(BODY_Y+5);
		leftLeg.setLayoutX(BODY_X+1);
		leftLeg.setLayoutY(BODY_Y+29);
		rightShoulder.setLayoutX(BODY_X+17);
		rightShoulder.setLayoutY(BODY_Y+2);
		rightArm.setLayoutX(BODY_X+18);
		rightArm.setLayoutY(BODY_Y+3);
		rightLeg.setLayoutX(BODY_X+17);
		rightLeg.setLayoutY(BODY_Y+28);
		
		//rotation
		leftArmRo = new Rotate();
		leftArmRo.pivotXProperty().bind(leftArm.xProperty().add(14));
		leftArmRo.pivotYProperty().bind(leftArm.yProperty().add(3));
		leftArm.getTransforms().add(leftArmRo);
		
		rightArmRo = new Rotate();
		rightArmRo.pivotXProperty().bind(rightArm.xProperty().add(3));
		rightArmRo.pivotYProperty().bind(rightArm.yProperty().add(3));
		rightArm.getTransforms().add(rightArmRo);
		
		leftLegRo = new Rotate();
		leftLegRo.pivotXProperty().bind(leftLeg.xProperty().add(9));
		leftLegRo.pivotYProperty().bind(leftLeg.yProperty().add(4));
		leftLeg.getTransforms().add(leftLegRo);
		
		rightLegRo = new Rotate();
		rightLegRo.pivotXProperty().bind(rightLeg.xProperty().add(3));
		rightLegRo.pivotYProperty().bind(rightLeg.yProperty().add(4));
		rightLeg.getTransforms().add(rightLegRo);
		
		weaponRo = new Rotate();
//		weapon.getTransforms().add(weaponRo);
		
		this.setDirection(direction);//初始方向
	}
	
	
	public void setWeapon(int number){
		this.weaponNum = number;
		group.getChildren().remove(weapon);
		orderList.remove(weapon);
		this.weapon = new WeaponView(number);
		group.getChildren().add(weapon);
		orderList.add(weapon);

		weapon.getTransforms().add(weaponRo);
		resetWeapon();
		
		int x = this.group.getChildren().indexOf(weapon);
	}
	
	public void setDirection(int direction){
		switch(direction){
		case 0:
			setflip(-1);
			setBack(-1);
			break;
		case 1:
			setflip(1);
			setBack(-1);
			break;
		case 2:
			setflip(1);
			setBack(1);
			break;
		case 3:
			setflip(-1);
			setBack(1);
			break;
		}
		
		//reset
		this.setInjured(false);
		//所有旋转角度至为0
		if (weapon != null){
			this.resetWeapon();
		}
	}
	
	private void resetWeapon(){
		int[] layout;
		int[] rotatePivot;
		//rotatepivot & layout & angle     zorder scale
		if (back == 1){
			layout = weapon.frontLayout;
			rotatePivot = weapon.frontRotatePivot;
			weaponRo.setAngle(weapon.frontAngle[0]);
			rightArmRo.setAngle(weapon.armAngle[0]);
			weapon.setScaleX(1);
			weapon.zOrder = weapon.frontZOrder;
		}else{
			layout = weapon.backLayout;
			rotatePivot = weapon.backRotatePivot;
			weaponRo.setAngle(weapon.backAngle[0]);
			leftArmRo.setAngle(weapon.armAngle[1]);
			weapon.setScaleX(-1);
			weapon.zOrder = weapon.backZOrder;
		}
		weapon.setLayoutX(layout[0]);
		weapon.setLayoutY(layout[1]);
		weaponRo.pivotXProperty().bind(weapon.xProperty().add(rotatePivot[0]));
		weaponRo.pivotYProperty().bind(weapon.yProperty().add(rotatePivot[1]));
		//move的初始角度
		this.setOrder();
	}
	
	//zOrder重排
	private void setOrder(){
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Collections.sort(orderList);
				group.getChildren().setAll(orderList);
			}
		});
	}

	private void setBack(int back){
		this.back = back;
		if(back == 1){
			leftArmAngle = new double[]{-40,25};
			leftLegAngle = new double[]{35,-30};
			rightLegAngle = new double[]{-30,40};
			
			leftArm.setScaleX(1);
			leftArm.setLayoutX(BODY_X-8);
			leftArm.setLayoutY(BODY_Y+5);
			
			this.helmetBack.setVisible(false);
		}else{
			rightArmAngle = new double[]{-25,35};
			leftLegAngle = new double[]{-30,35};
			rightLegAngle = new double[]{40,-30};
			
			leftArm.setScaleX(-1);
			leftArm.setLayoutX(BODY_X);
			leftArm.setLayoutY(BODY_Y+4);
			
			this.helmetBack.setVisible(true);
		}
	}
	
	private void setflip(int flip){
		this.flip = flip;
		this.setScaleX(flip);
	}
	
	public void move(int direction){
		this.setDirection(direction);
		
		if (back == 1){
			Timeline leftArmTL= new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(leftArmRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(500), new KeyValue(leftArmRo.angleProperty(), leftArmAngle[0])),
					new KeyFrame(Duration.millis(1500), new KeyValue(leftArmRo.angleProperty(), leftArmAngle[1])),
					new KeyFrame(Duration.millis(2000), new KeyValue(leftArmRo.angleProperty(), 0))
					);
			leftArmTL.play();
		}else{
			Timeline rightArmTL= new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(rightArmRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(500), new KeyValue(rightArmRo.angleProperty(), rightArmAngle[0])),
					new KeyFrame(Duration.millis(1500), new KeyValue(rightArmRo.angleProperty(), rightArmAngle[1])),
					new KeyFrame(Duration.millis(2000), new KeyValue(rightArmRo.angleProperty(), 0)));
			rightArmTL.play();
		}
		
		Timeline LegTL= new Timeline(
				new KeyFrame(Duration.ZERO, new KeyValue(leftLegRo.angleProperty(), 0)),
				new KeyFrame(Duration.millis(500), new KeyValue(leftLegRo.angleProperty(), leftLegAngle[0])),
				new KeyFrame(Duration.millis(1500), new KeyValue(leftLegRo.angleProperty(), leftLegAngle[1])),
				new KeyFrame(Duration.millis(2000), new KeyValue(leftLegRo.angleProperty(), 0)),
				
				new KeyFrame(Duration.ZERO, new KeyValue(rightLegRo.angleProperty(), 0)),
				new KeyFrame(Duration.millis(500), new KeyValue(rightLegRo.angleProperty(), rightLegAngle[0])),
				new KeyFrame(Duration.millis(1500), new KeyValue(rightLegRo.angleProperty(), rightLegAngle[1])),
				new KeyFrame(Duration.millis(2000), new KeyValue(rightLegRo.angleProperty(), 0)));
		LegTL.play();
		
	}
	
	public boolean occupy(int direction){
		this.setDirection(direction);
		int[] angle;
		/*
		 * frontAngle[] / backAngle[]:
		 * 0,1,2    weapon: move1 occupy2
		 * 3,4,5,6  leftArm: move2 occupy2
		 * 7,8,9,10 rightArm: move2 occupy2
		 * 
		*/
		int leftLegAngle;
		int rightLegAngle;
		
		if(weapon == null){
			return false;
		}
		
		if (back == 1){
			angle = weapon.frontAngle;
			leftLegAngle = 30;
			rightLegAngle = -10;

			Timeline occupyTL= new Timeline(
					//leftLeg
					new KeyFrame(Duration.ZERO, new KeyValue(leftLegRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(400), new KeyValue(leftLegRo.angleProperty(), leftLegAngle)),
					new KeyFrame(Duration.millis(800), new KeyValue(leftLegRo.angleProperty(), leftLegAngle)),
					new KeyFrame(Duration.millis(1200), new KeyValue(leftLegRo.angleProperty(), 0)),
					//rightLeg
					new KeyFrame(Duration.ZERO, new KeyValue(rightLegRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(400), new KeyValue(rightLegRo.angleProperty(), rightLegAngle)),
					new KeyFrame(Duration.millis(800), new KeyValue(rightLegRo.angleProperty(), rightLegAngle)),
					new KeyFrame(Duration.millis(1200), new KeyValue(rightLegRo.angleProperty(), 0)),
					//weapon
					new KeyFrame(Duration.ZERO, new KeyValue(weaponRo.angleProperty(), angle[0])),
					new KeyFrame(Duration.millis(400), new KeyValue(weaponRo.angleProperty(), angle[1])),
					new KeyFrame(Duration.millis(600), new KeyValue(weaponRo.angleProperty(), angle[2])),
					new KeyFrame(Duration.millis(800), new KeyValue(weaponRo.angleProperty(), angle[1])),
					new KeyFrame(Duration.millis(1200), new KeyValue(weaponRo.angleProperty(), angle[0])),
					//leftArm
					new KeyFrame(Duration.ZERO, new KeyValue(leftArmRo.angleProperty(), angle[5])),
					new KeyFrame(Duration.millis(600), new KeyValue(leftArmRo.angleProperty(), angle[6])),
					new KeyFrame(Duration.millis(1200), new KeyValue(leftArmRo.angleProperty(), angle[5])),
					//rightArm
					new KeyFrame(Duration.ZERO, new KeyValue(rightArmRo.angleProperty(), angle[8])),
					new KeyFrame(Duration.millis(400), new KeyValue(rightArmRo.angleProperty(), angle[9])),
					new KeyFrame(Duration.millis(600), new KeyValue(rightArmRo.angleProperty(), angle[10])),
					new KeyFrame(Duration.millis(800), new KeyValue(rightArmRo.angleProperty(), angle[9])),
					new KeyFrame(Duration.millis(1200), new KeyValue(rightArmRo.angleProperty(), angle[8]))
					);
			occupyTL.play();
			
		}else{
			angle = weapon.backAngle;
			leftLegAngle = 10;
			rightLegAngle = -30;
			
			Timeline occupyTL= new Timeline(
					//leftLeg
					new KeyFrame(Duration.ZERO, new KeyValue(leftLegRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(400), new KeyValue(leftLegRo.angleProperty(), leftLegAngle)),
					new KeyFrame(Duration.millis(800), new KeyValue(leftLegRo.angleProperty(), leftLegAngle)),
					new KeyFrame(Duration.millis(1200), new KeyValue(leftLegRo.angleProperty(), 0)),
					//rightLeg
					new KeyFrame(Duration.ZERO, new KeyValue(rightLegRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(400), new KeyValue(rightLegRo.angleProperty(), rightLegAngle)),
					new KeyFrame(Duration.millis(800), new KeyValue(rightLegRo.angleProperty(), rightLegAngle)),
					new KeyFrame(Duration.millis(1200), new KeyValue(rightLegRo.angleProperty(), 0)),
					//weapon
					new KeyFrame(Duration.ZERO, new KeyValue(weaponRo.angleProperty(), angle[0])),
					new KeyFrame(Duration.millis(400), new KeyValue(weaponRo.angleProperty(), angle[1])),
					new KeyFrame(Duration.millis(600), new KeyValue(weaponRo.angleProperty(), angle[2])),
					new KeyFrame(Duration.millis(800), new KeyValue(weaponRo.angleProperty(), angle[1])),
					new KeyFrame(Duration.millis(1200), new KeyValue(weaponRo.angleProperty(), angle[0])),
					//leftArm
					new KeyFrame(Duration.ZERO, new KeyValue(leftArmRo.angleProperty(), angle[4])),
					new KeyFrame(Duration.millis(400), new KeyValue(leftArmRo.angleProperty(), angle[5])),
					new KeyFrame(Duration.millis(600), new KeyValue(leftArmRo.angleProperty(), angle[6])),
					new KeyFrame(Duration.millis(800), new KeyValue(leftArmRo.angleProperty(), angle[5])),
					new KeyFrame(Duration.millis(1200), new KeyValue(leftArmRo.angleProperty(), angle[4])),
					//rightArm
					new KeyFrame(Duration.ZERO, new KeyValue(rightArmRo.angleProperty(), angle[9])),
					new KeyFrame(Duration.millis(600), new KeyValue(rightArmRo.angleProperty(), angle[10])),
					new KeyFrame(Duration.millis(1200), new KeyValue(rightArmRo.angleProperty(), angle[9]))
					);
			occupyTL.play();
		}
		return true;		
	}
	
	public void setInjured(boolean isInjured){
		this.isInjured = isInjured;
		this.headInjured.setVisible(isInjured);
		if(isInjured){
			Rotate injuredRo = new Rotate();
			injuredRo.pivotXProperty().bind(group.layoutXProperty().add(BODY_X+14));
			injuredRo.pivotYProperty().bind(group.layoutYProperty().add(BODY_Y+40));
			group.getTransforms().add(injuredRo);
			Timeline injuredTL= new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(injuredRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(500), new KeyValue(injuredRo.angleProperty(), 100*back)),
					new KeyFrame(Duration.millis(1500), new KeyValue(injuredRo.angleProperty(), 100*back)));
			injuredTL.play();
			injuredTL.setOnFinished(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					injuredRo.setAngle(0);
				}
			});
		}
	}

}
