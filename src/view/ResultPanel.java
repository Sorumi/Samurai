package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class ResultPanel extends OrderPanel {

	private final int CIRCLE_RADIUS = 300;
	private final int RATIO = 2; // 比例
	private final int strokeSize = 10;

	private int size;
	private int width;
	private int height;

	private ImageView logo;

	private Circle resultCircle; 
	private Circle materialCircle;
	private Circle circle3;
	
	private Label winLabel;
	private Label loseLabel; 
	
	private Group resultGroup;
	private Group materialGroup;
	
	

	private BlockArc[] arcsOne;
	private BlockArc[] arcsTwo;

	Timeline timeline;

	private class BlockArc extends Arc {
		private int blockNum;

		BlockArc() {
			blockNum = 0;
		}
	}

	public ResultPanel(GamePanel gamePanel) {
		this.logo = new ImageView(Images.A_WIN);
		this.logo.setFitWidth(504);
		this.logo.setPreserveRatio(true);

		this.width = this.CIRCLE_RADIUS + this.strokeSize;
		this.height = this.CIRCLE_RADIUS + this.strokeSize;

		size = 15;

		this.setLayoutX(gamePanel.getLayoutX() + gamePanel.FIELD_WIDTH / 2 - width / 2 - 100);
		this.setLayoutY(gamePanel.getLayoutY() + gamePanel.FIELD_HEIGHT / 2 - height / 2);
		
		resultGroup = new Group();
		materialGroup = new Group();

		Circle bgCircle = new Circle();
		bgCircle.setCenterX(CIRCLE_RADIUS + strokeSize);
		bgCircle.setCenterY(CIRCLE_RADIUS + strokeSize);
		bgCircle.setRadius(CIRCLE_RADIUS);
		bgCircle.setFill(Color.web("#f9f9f9"));
		bgCircle.setStroke(Color.WHITE);
		bgCircle.setStrokeWidth(strokeSize);
		bgCircle.setStrokeType(StrokeType.OUTSIDE);
		this.getChildren().add(bgCircle);
		
		resultCircle = new Circle();
		resultCircle.setCenterX(CIRCLE_RADIUS + strokeSize);
		resultCircle.setCenterY(CIRCLE_RADIUS + strokeSize);
		resultCircle.setRadius(246);
		resultCircle.setFill(Color.web("#ffffff"));
				
		winLabel = new Label("Win");
		winLabel.setLayoutX(CIRCLE_RADIUS + strokeSize-148);
		winLabel.setLayoutY(CIRCLE_RADIUS + strokeSize-102);
		winLabel.setId("win-label");
		
		loseLabel = new Label("Lose"); 
		loseLabel.setLayoutX(CIRCLE_RADIUS + strokeSize-148); 
		loseLabel.setLayoutY(CIRCLE_RADIUS + strokeSize-102);
		loseLabel.setId("lose-label");
		resultGroup.getChildren().addAll(resultCircle, winLabel);
		resultGroup.setRotationAxis(Rotate.Y_AXIS);
		resultGroup.setRotate(270);
		
		
		
		materialCircle = new Circle(); 
		materialCircle.setCenterX(CIRCLE_RADIUS + strokeSize);
		materialCircle.setCenterY(CIRCLE_RADIUS + strokeSize);
		materialCircle.setRadius(252);
		materialCircle.setFill(Color.web("#ffffff"));
		
		TilePane tile = new TilePane();
		tile.setVgap(10);
		tile.setHgap(20);
		tile.setPrefColumns(4);
		tile.setPrefRows(2);
		for(int i=0;i<4;i++){
			MaterialPanel materialPanel= new MaterialPanel(0,00,3);
			tile.getChildren().add(materialPanel);
		}
		for(int i=0;i<4;i++){
			MaterialPanel materialPanel= new MaterialPanel(1,00,3);
			tile.getChildren().add(materialPanel);
		}
		tile.setLayoutX(120);
		tile.setLayoutY(200);
		
		Pane samuraiPanel = new Pane();
		for(int num=1;num<=3;num++){ 
		ImageView samurai = new ImageView(Images.SAMURAI_BTN[num]);
		samurai.setFitWidth(52);
		samurai.setPreserveRatio(true);
		samurai.setLayoutX(140*(num-1));
		samurai.setLayoutY(0);
		Label samuraiLabel = new Label("230");
		samuraiLabel.setLayoutX(60+140*(num-1)); 
		samuraiLabel.setLayoutY(25);
		samuraiLabel.setId("amount-label"); 
		samuraiPanel.getChildren().addAll(samurai, samuraiLabel);
		}		
		samuraiPanel.setLayoutX(120);
		samuraiPanel.setLayoutY(380);
		materialGroup.getChildren().addAll(materialCircle, tile, samuraiPanel); 
		materialGroup.setRotationAxis(Rotate.Y_AXIS);
		materialGroup.setRotate(270);
		
		
		
		circle3 = new Circle(); 
		circle3.setCenterX(CIRCLE_RADIUS + strokeSize);
		circle3.setCenterY(CIRCLE_RADIUS + strokeSize);
		circle3.setRadius(252);
		circle3.setFill(Color.PINK);
		circle3.setRotationAxis(Rotate.Y_AXIS);
		circle3.setRotate(270);
		
		
		
		
		
		// player0
		arcsOne = new BlockArc[3];
		double startAngleOne = 90.0;
		double preAngleOne = 180.0 / (size * size);
		for (int i = 0; i < arcsOne.length; i++) {
			arcsOne[i] = new BlockArc();
			BlockArc tmpArc = arcsOne[i];
			tmpArc.setCenterX(CIRCLE_RADIUS + strokeSize);
			tmpArc.setCenterY(CIRCLE_RADIUS + strokeSize);
			tmpArc.setRadiusX(CIRCLE_RADIUS);
			tmpArc.setRadiusY(CIRCLE_RADIUS);
			tmpArc.setStartAngle(startAngleOne);
			tmpArc.setLength(preAngleOne * tmpArc.blockNum);
			tmpArc.setType(ArcType.ROUND);
			tmpArc.setFill(GameColor.getBlockColor(i + 1));
			this.getChildren().add(tmpArc);
			startAngleOne += preAngleOne * tmpArc.blockNum;
		}
		// player1
		arcsTwo = new BlockArc[3];
		double startAngleTwo = 90.0;
		double preAngleTwo = -180.0 / (size * size);
		for (int i = 0; i < arcsTwo.length; i++) {
			arcsTwo[i] = new BlockArc();
			BlockArc tmpArc = arcsTwo[i];
			tmpArc.setCenterX(CIRCLE_RADIUS + strokeSize);
			tmpArc.setCenterY(CIRCLE_RADIUS + strokeSize);
			tmpArc.setRadiusX(CIRCLE_RADIUS);
			tmpArc.setRadiusY(CIRCLE_RADIUS);
			tmpArc.setStartAngle(startAngleTwo);
			tmpArc.setLength(preAngleTwo * tmpArc.blockNum);
			tmpArc.setType(ArcType.ROUND);
			tmpArc.setFill(GameColor.getBlockColor(i + 4));
			this.getChildren().add(tmpArc);
			startAngleTwo += preAngleTwo * tmpArc.blockNum;

		}

		logo.setLayoutX(strokeSize + CIRCLE_RADIUS - 504 / RATIO);
		logo.setLayoutY(strokeSize + CIRCLE_RADIUS - 504 / RATIO);
		this.getChildren().add(logo);
		this.getChildren().addAll(circle3, resultGroup, materialGroup); 

		// 40是假数字！！
		double startAngle = 90.0;
		timeline = new Timeline(
				new KeyFrame(Duration.millis(500), new KeyValue(arcsOne[0].lengthProperty(), preAngleOne * 40)),
				new KeyFrame(Duration.millis(500), new KeyValue(arcsTwo[0].lengthProperty(), preAngleTwo * 40)),
				new KeyFrame(Duration.millis(700),
						new KeyValue(arcsOne[1].startAngleProperty(), startAngle + preAngleOne * 40)),
				new KeyFrame(Duration.millis(700), new KeyValue(arcsOne[1].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1200), new KeyValue(arcsOne[1].lengthProperty(), preAngleOne * 40)),
				new KeyFrame(Duration.millis(700),
						new KeyValue(arcsTwo[1].startAngleProperty(), startAngle + preAngleTwo * 40)),
				new KeyFrame(Duration.millis(700), new KeyValue(arcsTwo[1].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1200), new KeyValue(arcsTwo[1].lengthProperty(), preAngleTwo * 40)),
				new KeyFrame(Duration.millis(1400),
						new KeyValue(arcsOne[2].startAngleProperty(),
								startAngle + preAngleOne * 40 + preAngleOne * 40)),
				new KeyFrame(Duration.millis(1400), new KeyValue(arcsOne[2].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1900), new KeyValue(arcsOne[2].lengthProperty(), preAngleOne * 40)),
				new KeyFrame(Duration.millis(1400),
						new KeyValue(arcsTwo[2].startAngleProperty(),
								startAngle + preAngleTwo * 40 + preAngleTwo * 40)),
				new KeyFrame(Duration.millis(1400), new KeyValue(arcsTwo[2].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1900), new KeyValue(arcsTwo[2].lengthProperty(), preAngleTwo * 40)));

		timeline.play();

		this.setVisible(true);   
		
		this.flip();
	}
	
	public void flip(){
		
		Timeline timeline0 = new Timeline(new KeyFrame(Duration.millis(3000), new KeyValue(logo.rotateProperty(), 0)));

		//logo换成circle1
		RotateTransition rotator1 = new RotateTransition(Duration.millis(1000), logo);
		rotator1.setAxis(Rotate.Y_AXIS);
		rotator1.setFromAngle(0);
		rotator1.setToAngle(90);

		RotateTransition rotator2 = new RotateTransition(Duration.millis(1000), resultGroup);
		rotator2.setAxis(Rotate.Y_AXIS);
		rotator2.setFromAngle(270);
		rotator2.setToAngle(360);
		
		Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(3000), new KeyValue(resultGroup.rotateProperty(), 360)));
		//circle1换成circle2
		RotateTransition rotator3 = new RotateTransition(Duration.millis(1000), resultGroup);
		rotator3.setAxis(Rotate.Y_AXIS);
		rotator3.setFromAngle(0);
		rotator3.setToAngle(90);
		
		RotateTransition rotator4 = new RotateTransition(Duration.millis(1000), materialGroup);
		rotator4.setAxis(Rotate.Y_AXIS);
		rotator4.setFromAngle(270);
		rotator4.setToAngle(360);
		
		Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(3000), new KeyValue(materialGroup.rotateProperty(), 360)));
		//circle2换成circle3
		RotateTransition rotator5 = new RotateTransition(Duration.millis(1000), materialGroup);
		rotator5.setAxis(Rotate.Y_AXIS);
		rotator5.setFromAngle(0);
		rotator5.setToAngle(90);
		
		RotateTransition rotator6 = new RotateTransition(Duration.millis(1000), circle3);
		rotator6.setAxis(Rotate.Y_AXIS);
		rotator6.setFromAngle(270);
		rotator6.setToAngle(360);
		
		Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(3000), new KeyValue(circle3.rotateProperty(), 360)));
		
		timeline0.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	rotator1.play();
		    	
		    }
		});
		
		rotator1.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	rotator2.play();
		    	
		    }
		});
		
		rotator2.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	timeline1.play();
		    	
		    }
		});
		
		timeline1.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	rotator3.play();
		    	
		    }
		});
		
		rotator3.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	rotator4.play();
		    	
		    }
		});
		
		rotator4.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	timeline2.play();
		    	
		    }
		});
		
		timeline2.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	rotator5.play();
		    	
		    }
		});
		
		rotator5.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	rotator6.play();
		    	
		    }
		});
		
		rotator6.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent t) {
		    	timeline3.play();
		    	
		    }
		});
		timeline0.play();
	}
	//内部类
	public class MaterialPanel extends Pane{
		private int width = 90;
		private int height = 50;
		
//		private MaterialView materialView;
		
		public MaterialPanel(int colorNum, int materialnum, int amount){
			this.setWidth(width);
			this.setHeight(height);
			
			Circle circle = new Circle();
			circle.setCenterX(25);
			circle.setCenterY(25);
			circle.setRadius(25);
			
			switch(colorNum){
			case 0 :circle.setFill(Color.web("#FFD3D3"));break;
			case 1:circle.setFill(Color.web("FFFDE1"));break;
			}
			
			MaterialView material = new MaterialView(materialnum);
			material.setLayoutX(10);
			material.setLayoutY(10);
			material.setScaleX(0.5);
			material.setScaleY(0.5);
			
			Label amountLabel = new Label("×"+amount);
			amountLabel.setLayoutX(53);
			amountLabel.setLayoutY(22);
			amountLabel.setId("amount-label");
			
			this.getChildren().addAll(circle, amountLabel);  
			
		}
	}

}
