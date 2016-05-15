package view;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import main.Main;
import view.background.MenuBackground;
import view.eventhandler.MenuHandler;

public class MenuPanel extends Pane {
	
	private Main mainFrame;
	private MenuHandler menuHandler;

	private SystemButton exitBtn;
	
	private MenuBackground menuBg;
	public int modeNum;
	
	private Button modeBtn;
	
	public DoubleSelectPanel doubleSelectPanel;
	public StorySelectPanel storySelectPanel;
	public ArchivePanel archivePanel;
	
	private Group samuraiA;
	private Group samuraiB;
	
	private Rotate sARo;
	private Rotate sBRo;
	
	private Button leftBtn;
	private Button rightBtn;
	
	private Timeline leftTL;
	private Timeline rightTL;
	
	private SamuraiView samuraiA1;
	private SamuraiView samuraiA2;
	private SamuraiView samuraiA3;
	private SamuraiView samuraiB1;
	private SamuraiView samuraiB2;
	private SamuraiView samuraiB3;
	
	public AnimationTimer samuraiTimer;
	private int times;
	//
	private boolean isDay;
	
	public MenuPanel(Main mainFrame){
		this.mainFrame = mainFrame;
		
		menuHandler = new MenuHandler(mainFrame);
		
		exitBtn = new SystemButton(0);
	
		exitBtn.setLayoutX(1125);
		exitBtn.setLayoutY(25);
		exitBtn.setOnAction(menuHandler.exitEvent);
		
		//bg
		menuBg = new MenuBackground();
		this.getChildren().add(menuBg);
		
		modeNum = 1;
		
		//samurai
		samuraiA = new Group();
		samuraiA.setLayoutX(390);
		samuraiA.setLayoutY(320);
		
		samuraiA1 = new SamuraiView(1,2);
		samuraiA1.setWeapon(0);
		samuraiA1.setLayoutX(300);
		samuraiA1.setRotate(5);
		samuraiA2 = new SamuraiView(2,2);
		samuraiA2.setWeapon(100);
		samuraiA2.setLayoutX(150);
		samuraiA3 = new SamuraiView(3,2);
		samuraiA3.setWeapon(200);
		samuraiA3.setLayoutX(0);
		samuraiA3.setRotate(-5);
		
		samuraiA.getChildren().addAll(samuraiA3, samuraiA2, samuraiA1);
		sARo = new Rotate();
		sARo.pivotXProperty().bind(samuraiA.layoutXProperty().add(-180));
		sARo.pivotYProperty().bind(samuraiA.layoutYProperty().add(1080-240));
		sARo.setAngle(0);
		samuraiA.getTransforms().add(sARo);
		
		samuraiB = new Group();
		samuraiB.setLayoutX(390);
		samuraiB.setLayoutY(320);
		
		samuraiB1 = new SamuraiView(6,2);
		samuraiB1.setWeapon(200);
		samuraiB1.setDirection(3);
		samuraiB1.setLayoutX(300);
		samuraiB1.setRotate(5);
		samuraiB2 = new SamuraiView(5,2);
		samuraiB2.setWeapon(100);
		samuraiB2.setDirection(3);
		samuraiB2.setLayoutX(150);
		samuraiB3 = new SamuraiView(4,2);
		samuraiB3.setWeapon(0);
		samuraiB3.setDirection(3);
		samuraiB3.setLayoutX(0);
		samuraiB3.setRotate(-5);
		
		samuraiB.getChildren().addAll(samuraiB3, samuraiB2, samuraiB1);
		sBRo = new Rotate();
		sBRo.pivotXProperty().bind(samuraiB.layoutXProperty().add(-180));
		sBRo.pivotYProperty().bind(samuraiB.layoutYProperty().add(1080-240));
		sBRo.setAngle(60);
		samuraiB.getTransforms().add(sBRo);
		
		this.getChildren().addAll(samuraiA, samuraiB);
		
		times = 0;
		final long startNanoTime = System.nanoTime();
		samuraiTimer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
            	if(samuraiA1.state && times < 3){
            		 samuraiA1.move(2);
            		 samuraiA2.move(2);
            		 samuraiA3.move(2);
            		 samuraiB1.move(3);
            		 samuraiB2.move(3);
            		 samuraiB3.move(3);
            		 times++;
            	 }else if(samuraiA1.state){
            		 samuraiA1.occupy(2);
            		 samuraiA2.occupy(2);
            		 samuraiA3.occupy(2);
            		 samuraiB1.occupy(3);
            		 samuraiB2.occupy(3);
            		 samuraiB3.occupy(3);
            		 times = 0;
            	 }
            }
        };
        samuraiTimer.start();
		
        modeBtn = new Button("经典模式");
        modeBtn.setId("mode-btn");
        modeBtn.setPrefSize(140, 50);
        modeBtn.setLayoutX(530);
        modeBtn.setLayoutY(200);
        modeBtn.setOnMouseClicked(menuHandler.btnEvent);
        this.getChildren().add(modeBtn);
        
        ImageView leftImg = new ImageView(Images.MENU_BTN);
        ImageView rightImg = new ImageView(Images.MENU_BTN);
        leftImg.setFitWidth(53);
        rightImg.setFitWidth(53);
        leftImg.setPreserveRatio(true);
        rightImg.setPreserveRatio(true);
        leftImg.setScaleX(-1);
        
		leftBtn = new Button();
		leftBtn.setGraphic(leftImg);
		leftBtn.setLayoutX(50);
		leftBtn.setLayoutY(400);
		leftBtn.setOnMouseClicked(menuHandler.leftClickEvent);
		leftBtn.setOnMouseEntered(menuHandler.leftBtnEnterEvent);
		leftBtn.setOnMouseExited(menuHandler.leftBtnExitEvent);
		
		rightBtn = new Button();
		rightBtn.setGraphic(rightImg);
		rightBtn.setLayoutX(1097);
		rightBtn.setLayoutY(400);
		rightBtn.setOnMouseClicked(menuHandler.rightClickEvent);
		rightBtn.setOnMouseEntered(menuHandler.rightBtnEnterEvent);
		rightBtn.setOnMouseExited(menuHandler.rightBtnExitEvent);
		
		this.getChildren().addAll(leftBtn, rightBtn);
		
		leftTL = new Timeline(
				new KeyFrame(Duration.millis(500), new KeyValue(leftBtn.layoutXProperty(), 40, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000), new KeyValue(leftBtn.layoutXProperty(), 50, Interpolator.EASE_OUT))
				);
		rightTL = new Timeline(
				new KeyFrame(Duration.millis(500), new KeyValue(rightBtn.layoutXProperty(), 1107, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000), new KeyValue(rightBtn.layoutXProperty(), 1097, Interpolator.EASE_OUT))
				);
		this.leftBtnExit();
		this.rightBtnExit();
		//TODO
		isDay = true;
		
		doubleSelectPanel = new DoubleSelectPanel(menuHandler);
		doubleSelectPanel.setVisible(false);
		
		storySelectPanel = new StorySelectPanel(menuHandler);
		storySelectPanel.setVisible(false);
		
		
		this.getChildren().addAll(doubleSelectPanel, storySelectPanel, exitBtn);
	}
	public void btnClick(int btn){
		if(btn == 0){
			this.setMode((modeNum+2)%3);
		}else{
			this.setMode((modeNum+1)%3);
		}
	}
	
	public void setMode(int targetNum){
		switch(targetNum){
		case 0:
			modeBtn.setText("故事模式");
			break;
		case 1:
			modeBtn.setText("经典模式");
			break;
		case 2: 
			modeBtn.setText("双人模式");
			break;
		}
		Timeline samuraiTL = new Timeline();
		if (modeNum == 1 && targetNum == 2){
			samuraiTL.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(500), new KeyValue(sARo.angleProperty(), -20, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(500), new KeyValue(sBRo.angleProperty(), 20, Interpolator.EASE_IN))
			);
		}else if(modeNum == 1 && targetNum == 0){
			samuraiTL.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(500), new KeyValue(sARo.angleProperty(), 60, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000), new KeyValue(sARo.angleProperty(), 300, Interpolator.DISCRETE)),
				new KeyFrame(Duration.millis(1500), new KeyValue(sARo.angleProperty(), 360, Interpolator.EASE_IN))
			);
			samuraiA1.setWeapon(setRandomWeapon(0));
			samuraiA2.setWeapon(setRandomWeapon(1));
			samuraiA3.setWeapon(setRandomWeapon(2));
		}else if(modeNum == 0 && targetNum == 1){
			samuraiTL.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(500), new KeyValue(sARo.angleProperty(), 300, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000), new KeyValue(sARo.angleProperty(), 60, Interpolator.DISCRETE)),
				new KeyFrame(Duration.millis(1500), new KeyValue(sARo.angleProperty(), 0, Interpolator.EASE_IN))
			);
			samuraiA1.setWeapon(0);
			samuraiA2.setWeapon(100);
			samuraiA3.setWeapon(200);
		}else if(modeNum == 0 && targetNum == 2){
			samuraiTL.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(500), new KeyValue(sARo.angleProperty(), 300, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000), new KeyValue(sARo.angleProperty(), 60, Interpolator.DISCRETE)),
				new KeyFrame(Duration.millis(1500), new KeyValue(sARo.angleProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(2000), new KeyValue(sARo.angleProperty(), -20, Interpolator.EASE_IN)),
				
				new KeyFrame(Duration.millis(1500), new KeyValue(sBRo.angleProperty(), 60, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(2000), new KeyValue(sBRo.angleProperty(), 20, Interpolator.EASE_IN))
			);
			samuraiA1.setWeapon(0);
			samuraiA2.setWeapon(100);
			samuraiA3.setWeapon(200);
		}else if(modeNum == 2 && targetNum == 1){
			samuraiTL.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(500), new KeyValue(sARo.angleProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(500), new KeyValue(sBRo.angleProperty(), 60, Interpolator.EASE_IN))
			);
		}else if(modeNum == 2 && targetNum == 0){
			samuraiTL.getKeyFrames().addAll(
				new KeyFrame(Duration.millis(500), new KeyValue(sARo.angleProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1000), new KeyValue(sARo.angleProperty(), 60, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(1500), new KeyValue(sARo.angleProperty(), 300, Interpolator.DISCRETE)),
				new KeyFrame(Duration.millis(2000), new KeyValue(sARo.angleProperty(), 360, Interpolator.EASE_IN)),
					
				new KeyFrame(Duration.millis(500), new KeyValue(sBRo.angleProperty(), 60, Interpolator.EASE_IN))
			);
			samuraiA1.setWeapon(setRandomWeapon(0));
			samuraiA2.setWeapon(setRandomWeapon(1));
			samuraiA3.setWeapon(setRandomWeapon(2));
		}
		
		samuraiTL.play();
		setDay();
		this.modeNum = targetNum;
	}
	
	private int setRandomWeapon(int num){
		Random random = new Random();
		int x = random.nextInt(3)+1;
		int y = random.nextInt(2)+5;
		return num*100 + x*10 + y;
	}
	
	public void leftBtnEnter(){
		leftTL.setAutoReverse(true);
		leftTL.setCycleCount(Timeline.INDEFINITE);
		leftBtn.setOpacity(1);
		leftTL.play();
	}
	public void rightBtnEnter(){

		rightTL.setAutoReverse(true);
		rightTL.setCycleCount(Timeline.INDEFINITE);
		rightBtn.setOpacity(1);
		rightTL.play();
	}
	public void leftBtnExit(){
		leftTL.stop();
		leftBtn.setOpacity(0.7);
		leftBtn.setLayoutX(50);
	}
	public void rightBtnExit(){
		rightTL.stop();
		rightBtn.setOpacity(0.7);
		rightBtn.setLayoutX(1097);
	}
	//TODO
	public void setDay(){
		if(!isDay){
			this.menuBg.setSun(true);
			this.menuBg.setMoon(false);
			this.menuBg.setSky(0);
		}else{
			this.menuBg.setSun(false);
			this.menuBg.setMoon(true);
			this.menuBg.setSky(1);
		}
		isDay = !isDay;
	}
	
	public MenuHandler getMenuHandler(){
		return this.menuHandler;
	}
}
