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
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class SamuraiView extends Pane{
	
	private int SCALE;
	private int WIDTH = 60*SCALE;
	private int HEIGHT = 120*SCALE;
	private int BODY_X = WIDTH/2-10*SCALE;
	private int BODY_Y = 60*SCALE;

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
	
	private SamuraiWeaponView weapon;
	private SamuraiWeaponView weaponExtra;
	
	private Rotate leftArmRo;
	private Rotate rightArmRo;
	private Rotate leftLegRo;
	private Rotate rightLegRo;
	private Rotate weaponRo;
	private Rotate weaponExtraRo;
	
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
	
	public SamuraiView(int number, int scale){
		this.number = number;
		this.SCALE = scale;
		this.WIDTH = 60*SCALE;
		this.HEIGHT = 120*SCALE;
		this.BODY_X = WIDTH/2-10*SCALE;
		this.BODY_Y = 60*SCALE;
		
		//bounds
		this.setPrefWidth(WIDTH);
		this.setPrefHeight(HEIGHT);
//		this.setStyle("-fx-background-color: #dddddd");

		this.direction = 2;
		
		group = new Group();
		this.getChildren().add(group);
		
		//rotation
		leftArmRo = new Rotate();
		rightArmRo = new Rotate();
		leftLegRo = new Rotate();
		rightLegRo = new Rotate();
		weaponRo = new Rotate();
		weaponExtraRo = new Rotate();
		
		this.setSamurai(number);
	}

	public void setSamurai(int number){
		this.number = number;
		group.getChildren().remove(0, group.getChildren().size());
		
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
		
		//fitsize
		helmetBack.setFitWidth(53*SCALE);
		leftShoulder.setFitWidth(14*SCALE);
		leftArm.setFitWidth(17*SCALE);
		headInjured.setFitWidth(32*SCALE);
		head.setFitWidth(32*SCALE);
		body.setFitWidth(29*SCALE);
		leftLeg.setFitWidth(12*SCALE);
		rightLeg.setFitWidth(10*SCALE);
		rightShoulder.setFitWidth(12*SCALE);
		rightArm.setFitWidth(18*SCALE);
		helmet.setFitWidth(55*SCALE);
		
		//layout
		body.setLayoutX(BODY_X);
		body.setLayoutY(BODY_Y);
		helmet.setLayoutX(BODY_X-16*SCALE);
		helmet.setLayoutY(BODY_Y-53*SCALE);
		helmetBack.setLayoutX(BODY_X-16*SCALE);
		helmetBack.setLayoutY(BODY_Y-40*SCALE);
		headInjured.setLayoutX(BODY_X-3*SCALE);
		headInjured.setLayoutY(BODY_Y-26*SCALE);
		head.setLayoutX(BODY_X-3*SCALE);
		head.setLayoutY(BODY_Y-26*SCALE);
		leftShoulder.setLayoutX(BODY_X-3*SCALE);
		leftShoulder.setLayoutY(BODY_Y+3*SCALE);
		leftArm.setLayoutX(BODY_X-8*SCALE);
		leftArm.setLayoutY(BODY_Y+5*SCALE);
		leftLeg.setLayoutX(BODY_X+1*SCALE);
		leftLeg.setLayoutY(BODY_Y+29*SCALE);
		rightShoulder.setLayoutX(BODY_X+17*SCALE);
		rightShoulder.setLayoutY(BODY_Y+2*SCALE);
		rightArm.setLayoutX(BODY_X+18*SCALE);
		rightArm.setLayoutY(BODY_Y+3*SCALE);
		rightLeg.setLayoutX(BODY_X+17*SCALE);
		rightLeg.setLayoutY(BODY_Y+28*SCALE);
		
		orderList = FXCollections.observableArrayList(helmetBack, leftShoulder, leftArm, headInjured, head, body, leftLeg, rightLeg, rightShoulder, rightArm, helmet);
		
		for(int i=orderList.size()-1; i>=0; i--){
			OrderImageView tmpImg = orderList.get(i);
			tmpImg.setSmooth(true);
			tmpImg.setPreserveRatio(true);
			tmpImg.setZOrder(2*i);
			group.getChildren().add(tmpImg);
		}
		
		//rotation
		leftArmRo.pivotXProperty().bind(leftArm.xProperty().add(14*SCALE));
		leftArmRo.pivotYProperty().bind(leftArm.yProperty().add(3*SCALE));
		leftArmRo.setAngle(0);
		leftArm.getTransforms().add(leftArmRo);
		
		rightArmRo.pivotXProperty().bind(rightArm.xProperty().add(3*SCALE));
		rightArmRo.pivotYProperty().bind(rightArm.yProperty().add(3*SCALE));
		rightArmRo.setAngle(0);
		rightArm.getTransforms().add(rightArmRo);
		
		leftLegRo.pivotXProperty().bind(leftLeg.xProperty().add(9*SCALE));
		leftLegRo.pivotYProperty().bind(leftLeg.yProperty().add(4*SCALE));
		leftLegRo.setAngle(0);
		leftLeg.getTransforms().add(leftLegRo);
		
		rightLegRo.pivotXProperty().bind(rightLeg.xProperty().add(3*SCALE));
		rightLegRo.pivotYProperty().bind(rightLeg.yProperty().add(4*SCALE));
		rightLegRo.setAngle(0);
		rightLeg.getTransforms().add(rightLegRo);
		
		this.weapon = null;
		this.weaponExtra = null;
		
		this.setDirection(direction);//初始方向
	}
	
	public void setWeapon(int number){
		this.weaponNum = number;
		group.getChildren().remove(weapon);
		orderList.remove(weapon);
		if(weaponExtra != null){
			group.getChildren().remove(weaponExtra);
			orderList.remove(weaponExtra);
		}
		
		this.weapon = new SamuraiWeaponView(number, SCALE);
		group.getChildren().add(weapon);
		orderList.add(weapon);

		weapon.getTransforms().add(weaponRo);
		
		//ADD 400
		if(number/100 == 4){
			weaponExtra = new SamuraiWeaponView(number+100, SCALE);
			group.getChildren().add(weaponExtra);
			orderList.add(weaponExtra);
			weaponExtra.getTransforms().add(weaponExtraRo);
		}
		resetWeapon();
		
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
		if(weaponExtra != null){
			resetWeaponExtra();
		}
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				SamuraiView.this.setOrder();
			}
		});
		
	}
	
	private void resetWeaponExtra(){
		int[] layout;
		int[] rotatePivot;
		//rotatepivot & layout & angle     zorder scale
		if (back == 1){
			layout = weaponExtra.frontLayout;
			rotatePivot = weaponExtra.frontRotatePivot;
			weaponExtraRo.setAngle(weaponExtra.frontAngle[0]);
			weaponExtra.setScaleX(1);
			weaponExtra.zOrder = weaponExtra.frontZOrder;
		}else{
			layout = weaponExtra.backLayout;
			rotatePivot = weaponExtra.backRotatePivot;
			weaponExtraRo.setAngle(weaponExtra.backAngle[0]);
			weaponExtra.setScaleX(-1);
			weaponExtra.zOrder = weaponExtra.backZOrder;
		}
		weaponExtra.setLayoutX(layout[0]);
		weaponExtra.setLayoutY(layout[1]);
		weaponExtraRo.pivotXProperty().bind(weaponExtra.xProperty().add(rotatePivot[0]));
		weaponExtraRo.pivotYProperty().bind(weaponExtra.yProperty().add(rotatePivot[1]));
		//move的初始角度
	}
	
	//zOrder重排
	private void setOrder(){
		Collections.sort(orderList);
		group.getChildren().setAll(orderList);
	}

	private void setBack(int back){
		this.back = back;
		if(back == 1){
			
			leftLegAngle = new double[]{35,-30};
			rightLegAngle = new double[]{-30,40};
			if( weapon!=null ){
				leftArmAngle = new double[]{weapon.frontAngle[3],weapon.frontAngle[4]};
				rightArmAngle = new double[]{weapon.frontAngle[7],weapon.frontAngle[8]};
			}else{
				leftArmAngle = new double[]{-40,25};
				rightArmAngle = new double[]{35,-25};
			}
			
			leftArm.setScaleX(1);
			leftArm.setLayoutX(BODY_X-8*SCALE);
			leftArm.setLayoutY(BODY_Y+5*SCALE);
			
			this.helmetBack.setVisible(false);
		}else{
			
			leftLegAngle = new double[]{-30,35};
			rightLegAngle = new double[]{40,-30};
			if( weapon!=null ){
				leftArmAngle = new double[]{weapon.backAngle[3],weapon.backAngle[4]};
				rightArmAngle = new double[]{weapon.backAngle[7],weapon.backAngle[8]};
			}else{
				leftArmAngle = new double[]{-60,5};
				rightArmAngle = new double[]{-25,35};
			}
			
			leftArm.setScaleX(-1);
			leftArm.setLayoutX(BODY_X);
			leftArm.setLayoutY(BODY_Y+4*SCALE);
			
			this.helmetBack.setVisible(true);
		}
	}
	
	private void setflip(int flip){
		this.flip = flip;
		this.setScaleX(flip);
	}
	
	public void move(int direction){
		this.setDirection(direction);
		Timeline moveTL = new Timeline(
				//leftLeg
				new KeyFrame(Duration.ZERO, new KeyValue(leftLegRo.angleProperty(), 0)),
				new KeyFrame(Duration.millis(300), new KeyValue(leftLegRo.angleProperty(), leftLegAngle[0])),
				new KeyFrame(Duration.millis(900), new KeyValue(leftLegRo.angleProperty(), leftLegAngle[1])),
				new KeyFrame(Duration.millis(1200), new KeyValue(leftLegRo.angleProperty(), 0)),
				//rightLeg
				new KeyFrame(Duration.ZERO, new KeyValue(rightLegRo.angleProperty(), 0)),
				new KeyFrame(Duration.millis(300), new KeyValue(rightLegRo.angleProperty(), rightLegAngle[0])),
				new KeyFrame(Duration.millis(900), new KeyValue(rightLegRo.angleProperty(), rightLegAngle[1])),
				new KeyFrame(Duration.millis(1200), new KeyValue(rightLegRo.angleProperty(), 0)));
		
		if(back == 1){
			moveTL.getKeyFrames().addAll(
					new KeyFrame(Duration.ZERO, new KeyValue(leftArmRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(300), new KeyValue(leftArmRo.angleProperty(), leftArmAngle[0])),
					new KeyFrame(Duration.millis(900), new KeyValue(leftArmRo.angleProperty(), leftArmAngle[1])),
					new KeyFrame(Duration.millis(1200), new KeyValue(leftArmRo.angleProperty(), 0)));
		}else{
			moveTL.getKeyFrames().addAll(
					new KeyFrame(Duration.ZERO, new KeyValue(rightArmRo.angleProperty(), 0)),
					new KeyFrame(Duration.millis(300), new KeyValue(rightArmRo.angleProperty(), rightArmAngle[0])),
					new KeyFrame(Duration.millis(900), new KeyValue(rightArmRo.angleProperty(), rightArmAngle[1])),
					new KeyFrame(Duration.millis(1200), new KeyValue(rightArmRo.angleProperty(), 0)));
		}

		moveTL.play();
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
			//ADD 300
			if(weaponNum/100 == 3){
				occupyTL.getKeyFrames().addAll(
						new KeyFrame(Duration.ZERO, new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue())),
						new KeyFrame(Duration.millis(400), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()-5*SCALE)),
						new KeyFrame(Duration.millis(600), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()+80*SCALE)),
						new KeyFrame(Duration.millis(800), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()-5*SCALE)),
						new KeyFrame(Duration.millis(1200), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()))
						);
			}
			//ADD 400
			if(weaponExtra != null){
				occupyTL.getKeyFrames().addAll(
						new KeyFrame(Duration.ZERO, new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.frontAngle[0])),
						new KeyFrame(Duration.millis(400), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.frontAngle[1])),
						new KeyFrame(Duration.millis(600), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.frontAngle[2])),
						new KeyFrame(Duration.millis(800), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.frontAngle[1])),
						new KeyFrame(Duration.millis(1200), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.frontAngle[0]))
						);
			}
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
			//ADD 300
			if(weaponNum/100 == 3){
				occupyTL.getKeyFrames().addAll(
						new KeyFrame(Duration.ZERO, new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue())),
						new KeyFrame(Duration.millis(400), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()+5)),
						new KeyFrame(Duration.millis(600), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()-80)),
						new KeyFrame(Duration.millis(800), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()+5)),
						new KeyFrame(Duration.millis(1200), new KeyValue(weapon.layoutXProperty(), weapon.layoutXProperty().intValue()))
						);
			}
			//ADD 400
			if(weaponExtra != null){
				occupyTL.getKeyFrames().addAll(
						new KeyFrame(Duration.ZERO, new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.backAngle[0])),
						new KeyFrame(Duration.millis(400), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.backAngle[1])),
						new KeyFrame(Duration.millis(600), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.backAngle[2])),
						new KeyFrame(Duration.millis(800), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.backAngle[1])),
						new KeyFrame(Duration.millis(1200), new KeyValue(weaponExtraRo.angleProperty(), weaponExtra.backAngle[0]))
						);
			}
			occupyTL.play();
		}
		return true;		
	}
	
	public void setInjured(boolean isInjured){
		this.isInjured = isInjured;
		this.headInjured.setVisible(isInjured);
		if(isInjured){
			Rotate injuredRo = new Rotate();
			injuredRo.pivotXProperty().bind(group.layoutXProperty().add(BODY_X+14*SCALE));
			injuredRo.pivotYProperty().bind(group.layoutYProperty().add(BODY_Y+40*SCALE));
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
