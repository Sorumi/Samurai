package view.campsite;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import view.GameColor;
import view.Images;
import view.SamuraiView;
import view.eventhandler.CampsiteHandler;
import view.eventhandler.CustomizeCampsiteHandler;

public class CampsiteSamuraiWrapper extends Pane {

	private CampsiteHandler campsiteHandler;
	private CustomizeCampsiteHandler customizeCampsiteHandler;

	public SamuraiView samurai;

	private Group samuraiBtnA;
	private Group samuraiBtnB;

	private SamuraiButton samuraiBtn1;
	private SamuraiButton samuraiBtn2;
	private SamuraiButton samuraiBtn3;

	private SamuraiButton samuraiBtn4;
	private SamuraiButton samuraiBtn5;
	private SamuraiButton samuraiBtn6;

	private Button setItemBtn;

	public int samuraiNum;

	public boolean isWeapon;
	public boolean isArmor;

	public int currentWeapon;
	public int currentArmor;

	public int lastWeapon;
	public int lastArmor;

	private boolean isCustomized;

	public int currentLevel;
	private Group levelGroup;
	private Polygon polygonUp;
	private Polygon polygonDown;
	private Label levelLabel;

	public CampsiteSamuraiWrapper(CampsiteHandler campsiteHandler) {
		this.campsiteHandler = campsiteHandler;

		this.setPrefSize(500, 430);
		this.setLayoutX(650);
		this.setLayoutY(320);
		this.setId("campsite-wrapper");

		samurai = new SamuraiView(3);
		samurai.setLayoutX(30);
		samurai.setLayoutY(60);

		samuraiBtnA = new Group();
		samuraiBtnA.setLayoutX(280);
		samuraiBtnA.setLayoutY(30);

		samuraiBtn1 = new SamuraiButton(1);
		samuraiBtn2 = new SamuraiButton(2);
		samuraiBtn3 = new SamuraiButton(3);

		samuraiBtnA.getChildren().addAll(samuraiBtn1, samuraiBtn2, samuraiBtn3);

		setItemBtn = new Button("确 定");
		setItemBtn.setPrefSize(100, 40);
		setItemBtn.setLayoutX(370);
		setItemBtn.setLayoutY(360);
		setItemBtn.setId("set-item-btn");

		this.getChildren().addAll(samurai, setItemBtn, samuraiBtnA);

		isCustomized = false;
	}

	public class SamuraiButton extends Button {
		public int num;

		public SamuraiButton(int num) {
			this.num = num;
			ImageView btnV = new ImageView(Images.SAMURAI_BTN[num]);
			btnV.setFitWidth(52);
			btnV.setPreserveRatio(true);
			this.setGraphic(btnV);
			if (num < 4) {
				this.setLayoutX(70 * (num - 1));
			} else {
				this.setLayoutX(70 * (num - 4));
			}

			this.setLayoutY(0);
			this.setOnMouseClicked(campsiteHandler.samuraiClickEvent);
		}
	}

	public void setWeapon(int num) {
		isWeapon = true;
		currentWeapon = num;
		samurai.setWeapon(num);

	}

	public void setWeaponWithAnimation(int num) {
		setWeapon(num);
		samurai.occupy(2);
	}

	public void setArmor(int num) {
		isArmor = true;
		currentArmor = num;
		samurai.setArmor(num);
	}

	public void setSamurai(int num) {
		this.samuraiNum = num;
		samurai.setSamurai(samuraiNum);
		this.setItemBtnUnabled();
		isWeapon = false;
		isArmor = false;
	}

	public int getSamuraiNum() {
		return this.samuraiNum;
	}

	public void setItemBtnPressed() {
		setItemBtn.setLayoutY(364);
		setItemBtn.setStyle("-fx-background-color: " + GameColor.getSamuraiColorString(samuraiNum) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getSamuraiColorString(samuraiNum + 6)
				+ ", 0, 0, 0, 4);");
	}

	public void setItemBtnAbled() {
		setItemBtn.setLayoutY(360);
		setItemBtn.setStyle("-fx-background-color: " + GameColor.getSamuraiColorString(samuraiNum) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getSamuraiColorString(samuraiNum + 6)
				+ ", 0, 0, 0, 8);");
		setItemBtn.setOnMouseEntered(campsiteHandler.setItemEnterEvent);
		setItemBtn.setOnMouseExited(campsiteHandler.setItemExitEvent);
		if (isCustomized) {
			setItemBtn.setOnMouseClicked(customizeCampsiteHandler.setItemClickEvent);
		} else {
			setItemBtn.setOnMouseClicked(campsiteHandler.setItemClickEvent);
		}

	}

	public void setItemBtnUnabled() {
		setItemBtn.setLayoutY(364);
		setItemBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(-1) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(-2) + ", 0, 0, 0, 4);");
		setItemBtn.setOnMouseEntered(null);
		setItemBtn.setOnMouseExited(null);
		setItemBtn.setOnMouseClicked(null);
	}

	public void setCustomized(CustomizeCampsiteHandler customizeCampsiteHandler) {
		// System.out.println("I'm customized campsite!");
		this.customizeCampsiteHandler = customizeCampsiteHandler;
		isCustomized = true;

		samuraiBtnB = new Group();
		samuraiBtnB.setLayoutX(280);
		samuraiBtnB.setLayoutY(30);
		samuraiBtnA.setLayoutX(30);

		samuraiBtn4 = new SamuraiButton(4);
		samuraiBtn5 = new SamuraiButton(5);
		samuraiBtn6 = new SamuraiButton(6);

		samuraiBtn1.setOnMouseClicked(customizeCampsiteHandler.samuraiClickEvent);
		samuraiBtn2.setOnMouseClicked(customizeCampsiteHandler.samuraiClickEvent);
		samuraiBtn3.setOnMouseClicked(customizeCampsiteHandler.samuraiClickEvent);
		samuraiBtn4.setOnMouseClicked(customizeCampsiteHandler.samuraiClickEvent);
		samuraiBtn5.setOnMouseClicked(customizeCampsiteHandler.samuraiClickEvent);
		samuraiBtn6.setOnMouseClicked(customizeCampsiteHandler.samuraiClickEvent);

		samuraiBtnB.getChildren().addAll(samuraiBtn4, samuraiBtn5, samuraiBtn6);
		this.getChildren().add(samuraiBtnB);
		setItemBtn.setOnMouseClicked(customizeCampsiteHandler.setItemClickEvent);

		// level
		polygonUp = new Polygon();
		polygonUp.getPoints().addAll(new Double[] { 0.0, 12.0, 11.0, 0.0, 22.0, 12.0 });
		polygonUp.setLayoutX(446);
		polygonUp.setLayoutY(270);
		polygonUp.setOnMouseClicked(customizeCampsiteHandler.levelUpEvent);

		polygonDown = new Polygon();
		polygonDown.getPoints().addAll(new Double[] { 0.0, 0.0, 11.0, 12.0, 22.0, 0.0 });
		polygonDown.setLayoutX(446);
		polygonDown.setLayoutY(335);
		polygonDown.setOnMouseClicked(customizeCampsiteHandler.levelDownEvent);

		Label desLabel = new Label("等级：");
		desLabel.setId("set-level-des-label");
		desLabel.setLayoutX(370);
		desLabel.setLayoutY(297);

		levelLabel = new Label("3");
		levelLabel.setId("level-label");
		levelLabel.setPrefSize(14, 22);
		levelLabel.setLayoutX(450);
		levelLabel.setLayoutY(297);

		Group levelGroup = new Group();
		levelGroup.getChildren().addAll(polygonUp, polygonDown, desLabel, levelLabel);
		this.getChildren().add(levelGroup);
	}
	
	public void levelBtnAbled(int num) {
		if (num == 0) {
			polygonUp.setFill(Color.web(GameColor.getSamuraiColorString(samuraiNum)));
		} else {
			polygonDown.setFill(Color.web(GameColor.getSamuraiColorString(samuraiNum)));
		}
	}

	public void levelBtnUnabled(int num) {
		if (num == 0) {
			polygonUp.setFill(Color.web(GameColor.getSamuraiColorString(99)));
		} else {
			polygonDown.setFill(Color.web(GameColor.getSamuraiColorString(99)));
		}

	}

	public void updatePolygonColor() {
		if(currentLevel == 9){
			levelBtnUnabled(0);
		}else{
			levelBtnAbled(0);
		}
		
		if(currentLevel == 1){
			levelBtnUnabled(1);
		}else{
			levelBtnAbled(1);
		}
		
	}

	public void setlevel(int i) {
		if (i > 0 && i < 10) {
			currentLevel = i;
			levelLabel.setText(i + "");
		}
	}

}
