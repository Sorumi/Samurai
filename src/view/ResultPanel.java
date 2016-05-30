package view;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
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
import model.po.Material;
import musics.Musics;

public class ResultPanel extends OrderPanel {

	private final int CIRCLE_RADIUS = 300;
	private final int RATIO = 2; // 比例
	private final int strokeSize = 10;

	private int size;
	private int width;
	private int height;

	private ImageView logo;
	private ImageView rateImg;

	private Circle resultCircle;
	private Circle materialCircle;
//	private Circle circle3;

	private Label winLabel;
	private Label loseLabel;

	private Group resultGroup;
	private Group materialGroup;
	private TilePane tile;

	private BlockArc[] arcsOne;
	private BlockArc[] arcsTwo;
	
	private Label moneyLabel;
	
	private int[] blocks = {0,0,0,0,0,0,0};
	
	private Pane samuraiPanel;

	private Timeline timeline;

	private class BlockArc extends Arc {
		private int blockNum;

		BlockArc() {
			blockNum = 0;
		}
	}

	public ResultPanel(GamePanel gamePanel) {
		logo = new ImageView(Images.A_WIN);
		logo.setFitWidth(504);
		logo.setPreserveRatio(true);
		logo.setLayoutX(strokeSize + CIRCLE_RADIUS - 504 / RATIO);
		logo.setLayoutY(strokeSize + CIRCLE_RADIUS - 504 / RATIO);

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
		winLabel.setLayoutX(CIRCLE_RADIUS + strokeSize - 148);
		winLabel.setLayoutY(CIRCLE_RADIUS + strokeSize - 102);
		winLabel.setId("win-label");
		winLabel.setVisible(false);

		loseLabel = new Label("Lose");
		loseLabel.setLayoutX(CIRCLE_RADIUS + strokeSize - 148);
		loseLabel.setLayoutY(CIRCLE_RADIUS + strokeSize - 102);
		loseLabel.setId("lose-label");
		loseLabel.setVisible(false);
		
		resultGroup.getChildren().addAll(resultCircle, winLabel, loseLabel);
		resultGroup.setRotationAxis(Rotate.Y_AXIS);
		resultGroup.setRotate(270);

		materialCircle = new Circle();
		materialCircle.setCenterX(CIRCLE_RADIUS + strokeSize);
		materialCircle.setCenterY(CIRCLE_RADIUS + strokeSize);
		materialCircle.setRadius(252);
		materialCircle.setFill(Color.web("#ffffff"));

		tile = new TilePane();
		tile.setVgap(10);
		tile.setHgap(20);
		tile.setPrefColumns(4);
		tile.setPrefRows(2);
		tile.setLayoutX(80);
		tile.setLayoutY(200);

		samuraiPanel = new Pane();
		for (int num = 1; num <= 3; num++) {
			ImageView samurai = new ImageView(Images.SAMURAI_BTN[num]);
			samurai.setFitWidth(52);
			samurai.setPreserveRatio(true);
			samurai.setLayoutX(140 * (num - 1));
			samurai.setLayoutY(0);
			Label samuraiLabel = new Label("");
			samuraiLabel.setLayoutX(60 + 140 * (num - 1));
			samuraiLabel.setLayoutY(20);
			samuraiLabel.setId("amount-label");
			Label levelUpLabel = new Label("Lv. Up!");
			levelUpLabel.setPrefSize(52, 20);
			levelUpLabel.setLayoutX(140 * (num - 1));
			levelUpLabel.setLayoutY(-25);
			levelUpLabel.setId("level-up-label");
			levelUpLabel.setTextFill(GameColor.getBlockColor(num));
			levelUpLabel.setVisible(false);
			samuraiPanel.getChildren().addAll(samurai, samuraiLabel, levelUpLabel);
			
		}
		samuraiPanel.setLayoutX(120);
		samuraiPanel.setLayoutY(380);
		
		ImageView coin = new ImageView(Images.COIN);
		coin.setFitWidth(30);
		coin.setSmooth(true);
		coin.setPreserveRatio(true);
		coin.setLayoutX(240);
		coin.setLayoutY(480);
		
		moneyLabel = new Label();
		moneyLabel.setPrefSize(100, 30);
		moneyLabel.setLayoutX(280);
		moneyLabel.setLayoutY(480);
		moneyLabel.setId("money-label");
		
		materialGroup.getChildren().addAll(materialCircle, tile, samuraiPanel, coin, moneyLabel);
		materialGroup.setRotationAxis(Rotate.Y_AXIS);
		materialGroup.setRotate(270);

//		circle3 = new Circle();
//		circle3.setCenterX(CIRCLE_RADIUS + strokeSize);
//		circle3.setCenterY(CIRCLE_RADIUS + strokeSize);
//		circle3.setRadius(252);
//		circle3.setFill(Color.PINK);
//		circle3.setRotationAxis(Rotate.Y_AXIS);
//		circle3.setRotate(270);

		// player0
		arcsOne = new BlockArc[3];
		double startAngleOne = 90.0;
		double preAngleOne = 360.0 / (size * size);
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
		double preAngleTwo = -360.0 / (size * size);
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


		this.getChildren().add(logo);
		this.getChildren().addAll(resultGroup, materialGroup);	

		this.setVisible(false);

	}
	
	private void setTimeline(){
		
		double startAngle = 90.0;
		double preAngleOne = 360.0 / (size * size);
		double preAngleTwo = -360.0 / (size * size);
		timeline = new Timeline(
				new KeyFrame(Duration.millis(500), new KeyValue(arcsOne[0].lengthProperty(), preAngleOne * blocks[1])),
				new KeyFrame(Duration.millis(500), new KeyValue(arcsTwo[0].lengthProperty(), preAngleTwo * blocks[4])),
				new KeyFrame(Duration.millis(700),
						new KeyValue(arcsOne[1].startAngleProperty(), startAngle + preAngleOne * blocks[1])),
				new KeyFrame(Duration.millis(700), new KeyValue(arcsOne[1].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1200), new KeyValue(arcsOne[1].lengthProperty(), preAngleOne * blocks[2])),
				new KeyFrame(Duration.millis(700),
						new KeyValue(arcsTwo[1].startAngleProperty(), startAngle + preAngleTwo * blocks[4])),
				new KeyFrame(Duration.millis(700), new KeyValue(arcsTwo[1].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1200), new KeyValue(arcsTwo[1].lengthProperty(), preAngleTwo * blocks[5])),
				new KeyFrame(Duration.millis(1400),
						new KeyValue(arcsOne[2].startAngleProperty(),
								startAngle + preAngleOne * blocks[1] + preAngleOne * blocks[2])),
				new KeyFrame(Duration.millis(1400), new KeyValue(arcsOne[2].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1900), new KeyValue(arcsOne[2].lengthProperty(), preAngleOne * blocks[3])),
				new KeyFrame(Duration.millis(1400),
						new KeyValue(arcsTwo[2].startAngleProperty(),
								startAngle + preAngleTwo * blocks[4] + preAngleTwo * blocks[5])),
				new KeyFrame(Duration.millis(1400), new KeyValue(arcsTwo[2].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(1900), new KeyValue(arcsTwo[2].lengthProperty(), preAngleTwo * blocks[6])));
	}

	public void setBlocks(int[] results) {
		for (int i=0; i<results.length; i++) {
			blocks[i] = results[i];
		}
	}
	
	public void setMaterials(ArrayList<Material> list) {
		for (Material material : list){
			MaterialPanel materialPanel = new MaterialPanel(material.getType(), material.getNumber());
			tile.getChildren().add(materialPanel);
		}
	}
	
	public void setExperiences(int[] expertiences) {
		for(int i=0; i<expertiences.length; i++){
			Label label = (Label) samuraiPanel.getChildren().get(i*3+1);
			label.setText(expertiences[i] + "");
		}
	}
	
	public void setLevelUp(int samuraiNum) {
		Label label = (Label) samuraiPanel.getChildren().get(samuraiNum*3+2);
		label.setVisible(true);
	}


	public void setMoney(int money) {
		moneyLabel.setText(money + "");
	}

	public void setRate(int rate) {
		rateImg = new ImageView(Images.RATE[rate]);
		rateImg.setFitWidth(492);
		rateImg.setPreserveRatio(true);
		rateImg.setLayoutX(strokeSize + CIRCLE_RADIUS - 492 / RATIO);
		rateImg.setLayoutY(strokeSize + CIRCLE_RADIUS - 492 / RATIO);
		rateImg.setRotationAxis(Rotate.Y_AXIS);
		rateImg.setRotate(270);
		this.getChildren().add(rateImg);
		if(rate <= 5){
			winLabel.setVisible(true);
		}else{
			loseLabel.setVisible(true);
		}
	}

	public void setStart() {
		this.setVisible(true);
		this.setTimeline();
		timeline.play();
		this.flip();
		Musics.playBgMusic(1);
	}

	private void flip() {

		Timeline timeline0 = new Timeline(new KeyFrame(Duration.millis(3000), new KeyValue(logo.rotateProperty(), 0)));

		// logo换成circle1
		RotateTransition rotator1 = new RotateTransition(Duration.millis(1000), logo);
		rotator1.setAxis(Rotate.Y_AXIS);
		rotator1.setFromAngle(0);
		rotator1.setToAngle(90);

		RotateTransition rotator2 = new RotateTransition(Duration.millis(1000), resultGroup);
		rotator2.setAxis(Rotate.Y_AXIS);
		rotator2.setFromAngle(270);
		rotator2.setToAngle(360);

		Timeline timeline1 = new Timeline(
				new KeyFrame(Duration.millis(3000), new KeyValue(resultGroup.rotateProperty(), 360)));
		// circle1换成circle2
		RotateTransition rotator3 = new RotateTransition(Duration.millis(1000), resultGroup);
		rotator3.setAxis(Rotate.Y_AXIS);
		rotator3.setFromAngle(0);
		rotator3.setToAngle(90);

		RotateTransition rotator4 = new RotateTransition(Duration.millis(1000), materialGroup);
		rotator4.setAxis(Rotate.Y_AXIS);
		rotator4.setFromAngle(270);
		rotator4.setToAngle(360);

		Timeline timeline2 = new Timeline(
				new KeyFrame(Duration.millis(5000), new KeyValue(materialGroup.rotateProperty(), 360)));
		// circle2换成circle3
		RotateTransition rotator5 = new RotateTransition(Duration.millis(1000), materialGroup);
		rotator5.setAxis(Rotate.Y_AXIS);
		rotator5.setFromAngle(0);
		rotator5.setToAngle(90);

		RotateTransition rotator6 = new RotateTransition(Duration.millis(1000), rateImg);
		rotator6.setAxis(Rotate.Y_AXIS);
		rotator6.setFromAngle(270);
		rotator6.setToAngle(360);

		Timeline timeline3 = new Timeline(
				new KeyFrame(Duration.millis(3000), new KeyValue(rateImg.rotateProperty(), 360)));

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

	// 内部类
	public class MaterialPanel extends Pane {
		private int width = 90;
		private int height = 50;

		// private MaterialView materialView;

		public MaterialPanel(int materialnum, int amount) {
			materialnum = materialnum-800;
			this.setWidth(width);
			this.setHeight(height);

			Circle circle = new Circle();
			circle.setCenterX(25);
			circle.setCenterY(25);
			circle.setRadius(25);

			circle.setFill(GameColor.getMaterialColor(materialnum/10));

			MaterialView material = new MaterialView(materialnum);
			material.setLayoutX(-25);
			material.setLayoutY(-25);
			material.setScaleX(0.5);
			material.setScaleY(0.5);

			Label amountLabel = new Label(" × " + amount);
			amountLabel.setLayoutX(53);
			amountLabel.setLayoutY(22);
			amountLabel.setId("amount-label");

			this.getChildren().addAll(circle, amountLabel, material);
		}
	}

}
