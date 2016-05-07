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
	
	private int width = 540;
	private int itemNum;
	private WeaponView weapon;
	private Button buildBtn;
	private SystemButton closeBtn;
	
	private Group materialGroup;
	
	private Circle strokeCircle;
	private Circle fillCircle;
	
	public SmithyBuilder(int itemNum, SmithyHandler smithyHandler){
		this.itemNum = itemNum;
		this.smithyHandler = smithyHandler;
		
//		this.setPrefSize(width, 700);
//		this.setLayoutX((1200-width)/2);
		this.setLayoutY(50);
		this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum/100));
		this.setId("smithy-builder");
		
		//item circle
		strokeCircle = new Circle();
//		strokeCircle.setCenterX(width/2);
		strokeCircle.setCenterY(RADIUS+70);
		strokeCircle.setRadius(RADIUS);
		strokeCircle.setFill(null);
		strokeCircle.setStroke(Color.WHITE);
		strokeCircle.setStrokeWidth(15);
		strokeCircle.setStrokeType(StrokeType.INSIDE);
		this.getChildren().add(strokeCircle);
		
		fillCircle = new Circle();
//		fillCircle.setCenterX(width/2);
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
//		buildBtn.setLayoutX(width/2-50);
		buildBtn.setId("build-btn");
		this.getChildren().add(buildBtn);
		
		//closeBtn
		closeBtn = new SystemButton(0);
//		closeBtn.setLayoutX(width-25);
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


	public void setMaterial(int materialQuantity, int[] materialNum, String[] materialName, int[]currentQuantity, int[] materialNumber) {
		int x = 130;
		if (materialQuantity<=3){
			x = 170;
		}
			
		for (int i=0; i<materialQuantity; i++){
			SmithyBuilderMaterialView materialView = new SmithyBuilderMaterialView(itemNum, materialNum[i], materialName[i], currentQuantity[i], materialNumber[i] );
			materialView.setLayoutX(x * i);
			materialGroup.getChildren().add(materialView);
		}
		materialGroup.setLayoutY(420);
		switch(materialQuantity){
		case 2:
			materialGroup.setLayoutX(135);break;
		case 3:
			materialGroup.setLayoutX(50);break;
		case 4:	
			materialGroup.setLayoutX(25);break;
		case 5:
			materialGroup.setLayoutX(25);
			this.width = 670;break;
		case 6:
			materialGroup.setLayoutX(25);
			this.width = 800;break;
		}
		this.setPrefSize(width, 700);
		this.setLayoutX((1200-width)/2);
		strokeCircle.setCenterX(width/2);
		fillCircle.setCenterX(width/2);
		closeBtn.setLayoutX(width-25);
		buildBtn.setLayoutX(width/2-50);
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
