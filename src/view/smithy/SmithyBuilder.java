package view.smithy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import view.GameColor;
import view.SystemButton;
import view.WeaponView;
import view.eventhandler.SmithyHandler;

public class SmithyBuilder extends Pane {

	private final int RADIUS = 150;
	
	private SmithyHandler smithyHandler;
	
	private int itemNum;
	private WeaponView weapon;
	private Button buildBtn;
	private SystemButton closeBtn;
	
	private Group materialGroup;
	
	public SmithyBuilder(int itemNum, SmithyHandler smithyHandler){
		this.itemNum = itemNum;
		this.smithyHandler = smithyHandler;
		
		this.setPrefSize(540, 700);
		this.setLayoutX(330);
		this.setLayoutY(50);
		this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum/100));
		this.setId("smithy-builder");
		
		//item circle
		Circle strokeCircle = new Circle();
		strokeCircle.setCenterX(RADIUS+110);
		strokeCircle.setCenterY(RADIUS+70);
		strokeCircle.setRadius(RADIUS);
		strokeCircle.setFill(null);
		strokeCircle.setStroke(Color.WHITE);
		strokeCircle.setStrokeWidth(15);
		strokeCircle.setStrokeType(StrokeType.INSIDE);
		this.getChildren().add(strokeCircle);
		
		Circle fillCircle = new Circle();
		fillCircle.setCenterX(RADIUS+110);
		fillCircle.setCenterY(RADIUS+70);
		fillCircle.setRadius(RADIUS-30);
		fillCircle.setFill(Color.WHITE);
		this.getChildren().add(fillCircle);
		
		weapon = new WeaponView(itemNum, 3);
		weapon.setGray();
		weapon.setLayoutX(110);
		weapon.setLayoutY(70);
		this.getChildren().add(weapon);
		
		//material
		materialGroup = new Group();
		this.getChildren().add(materialGroup);

		//buildBtn
		buildBtn = new Button("合 成");
		buildBtn.setPrefSize(100, 40);
		buildBtn.setLayoutX(210);
		buildBtn.setId("build-btn");
		this.getChildren().add(buildBtn);
		
		//closeBtn
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(515);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				SmithyPanel parent = (SmithyPanel) SmithyBuilder.this.getParent();
				parent.getChildren().remove(SmithyBuilder.this);
				parent.routeGroup.setVisible(true);
			}
		});
		this.getChildren().add(closeBtn);
		
		//可否被制造
		if(true){
			buildBtnAbled();
			buildBtn.setOnMouseEntered(smithyHandler.buildBtnEnterEvent);
			buildBtn.setOnMouseExited(smithyHandler.buildBtnExitEvent);
			buildBtn.setOnMouseClicked(smithyHandler.buildBtnClickEvent);
		}else{
			this.buildBtnUnabled();
		}
	}

	public void setMaterial(int num){
//		materialGroup.setLayoutX(25);
//		materialGroup.setLayoutY(420);
		
		for (int i=1; i<=num; i++){
			SmithyBuilderMaterialView material1 = new SmithyBuilderMaterialView(itemNum);
//			material1.setLayoutX(0);
//			material2 = new SmithyBuilderMaterialView(itemNum);
//			material2.setLayoutX(130);
//			material3 = new SmithyBuilderMaterialView(itemNum);
//			material3.setLayoutX(260);
//			material4 = new SmithyBuilderMaterialView(itemNum);
//			material4.setLayoutX(390);
		}

		
//		materialGroup.getChildren().addAll(material1, material2, material3, material4);
	}
	//TODO
	//传数据时调用此方法
	
	public int getItemNum(){
		return this.itemNum;
	}

	//造武器成功调用此方法
	public void build(){
		weapon.setColored();
	}

	public void buildBtnPressed() {
		buildBtn.setLayoutY(624);
		buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum/100+5) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(itemNum/100+10) +", 0, 0, 0, 4);");
	}
	public void buildBtnAbled() {
		buildBtn.setLayoutY(620);
		buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum/100+5) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(itemNum/100+10) +", 0, 0, 0, 8);");
	}
	
	public void buildBtnUnabled() {
		buildBtn.setLayoutY(624);
		buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(-1) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(-2) +", 0, 0, 0, 4);");

	}

}
