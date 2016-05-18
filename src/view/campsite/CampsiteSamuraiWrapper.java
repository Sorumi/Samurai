package view.campsite;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.GameColor;
import images.Images;
import view.SamuraiView;
import view.eventhandler.CampsiteHandler;

public class CampsiteSamuraiWrapper extends Pane {

	private CampsiteHandler campsiteHandler;
	
	public SamuraiView samurai;
	
	private Group samuraiBtns;
	private SamuraiButton samuraiBtn1;
	private SamuraiButton samuraiBtn2;
	private SamuraiButton samuraiBtn3;
	
	private Button setItemBtn;
	
	private int samuraiNum;
	
	public boolean isArmor;
	
	public int currentWeapon;
	public int currentArmor;
	
	public CampsiteSamuraiWrapper(CampsiteHandler campsiteHandler){
		this.campsiteHandler = campsiteHandler;
		
		this.setPrefSize(500, 430);
		this.setLayoutX(650);
		this.setLayoutY(320);
		this.setId("campsite-wrapper");
		
		samurai = new SamuraiView(3);
		samurai.setLayoutX(30);
		samurai.setLayoutY(60);
		
		samuraiBtns = new Group();
		samuraiBtns.setLayoutX(280);
		samuraiBtns.setLayoutY(30);
		
		samuraiBtn1 = new SamuraiButton(1);
		samuraiBtn2 = new SamuraiButton(2);
		samuraiBtn3 = new SamuraiButton(3);
		
		samuraiBtns.getChildren().addAll(samuraiBtn1, samuraiBtn2, samuraiBtn3);
		this.getChildren().add(samuraiBtns);
		
		setItemBtn = new Button("确 定");
		setItemBtn.setPrefSize(100, 40);
		setItemBtn.setLayoutX(370);
		setItemBtn.setLayoutY(360);
		setItemBtn.setId("set-item-btn");
		setItemBtn.setOnMouseEntered(campsiteHandler.setItemEnterEvent);
		setItemBtn.setOnMouseExited(campsiteHandler.setItemExitEvent);
		setItemBtn.setOnMouseClicked(campsiteHandler.setItemClickEvent);
		this.getChildren().add(setItemBtn);
		
		this.getChildren().add(samurai);
		
		isArmor = false;
	}
	
	public class SamuraiButton extends Button{
		public int num;
		public SamuraiButton(int num){
			this.num = num;
			ImageView btnV = new ImageView(Images.SAMURAI_BTN[num]);
			btnV.setFitWidth(52);
			btnV.setPreserveRatio(true);
			this.setGraphic(btnV);
			this.setLayoutX(70*(num-1));
			this.setLayoutY(0);
			this.setOnMouseClicked(campsiteHandler.samuraiClickEvent);
		}
	}

	public void setWeapon(int num) {
		currentWeapon = num;
		samurai.setWeapon(num);
		samurai.occupy(2);
		//TODO
		//如果库存大于0 则abled 否则unabled
	}
	
	public void setArmor(int num) {
		isArmor = true;
		currentArmor = num;
		samurai.setArmor(num);
	}

	public void setSamurai(int num) {
		this.samuraiNum = num;
		samurai.setSamurai(samuraiNum);
		this.setItemBtnAbled();
	}

	public int getSamuraiNum(){
		return this.samuraiNum;
	}

	public void setItemBtnPressed() {
		setItemBtn.setLayoutY(364);
		setItemBtn.setStyle("-fx-background-color: " + GameColor.getSamuraiColorString(samuraiNum) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getSamuraiColorString(samuraiNum+6) +", 0, 0, 0, 4);");
	}
	public void setItemBtnAbled() {
		setItemBtn.setLayoutY(360);
		setItemBtn.setStyle("-fx-background-color: " + GameColor.getSamuraiColorString(samuraiNum) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getSamuraiColorString(samuraiNum+6) +", 0, 0, 0, 8);");
	}
	
	public void setItemBtnUnabled() {
		setItemBtn.setLayoutY(364);
		setItemBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(-1) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(-2) +", 0, 0, 0, 4);");

	}

}
