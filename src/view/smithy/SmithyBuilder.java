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
import view.SystemCloseButton;
import view.WeaponView;
import view.eventhandler.SmithyHandler;

public class SmithyBuilder extends Pane {

	private final int RADIUS = 150;
	
	private SmithyHandler smithyHandler;
	
	private int itemNum;
	private WeaponView weapon;
	private Button buildBtn;
	private SystemCloseButton closeBtn;
	
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
		
		//material circle
		Group materialGroup = new Group();
		materialGroup.setLayoutX(25);
		materialGroup.setLayoutY(440);
		
		MaterialCircle materialCircle1 = new MaterialCircle(1);
		MaterialCircle materialCircle2 = new MaterialCircle(2);
		MaterialCircle materialCircle3 = new MaterialCircle(3);
		MaterialCircle materialCircle4 = new MaterialCircle(4);
		
		materialGroup.getChildren().addAll(materialCircle1, materialCircle2, materialCircle3, materialCircle4);
		this.getChildren().add(materialGroup);
		
		//TODO
		//素材View 数量的Label
		
		//buildBtn
		buildBtn = new Button("合 成");
		buildBtn.setPrefSize(100, 40);
		buildBtn.setLayoutX(210);
		buildBtn.setLayoutY(610);
		buildBtn.setId("build-btn");
		this.getChildren().add(buildBtn);
		
		//closeBtn
		closeBtn = new SystemCloseButton();
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
			buildBtnUnabled();
		}
	}

	public int getItemNum(){
		return this.itemNum;
	}
	
	//内部类
	public class MaterialCircle extends Circle{
		public MaterialCircle(int num){
			this.setRadius(50);
			this.setFill(Color.WHITE);
			this.setCenterX(50+130*(num-1));
			this.setCenterY(50);
		}
	}



	//造武器成功调用此方法
	public void build(){
		weapon.setColored();
	}

	public void buildBtnPressed() {
		buildBtn.setLayoutY(614);
		buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum/100+5) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(itemNum/100+10) +", 0, 0, 0, 4);");
	}
	public void buildBtnAbled() {
		buildBtn.setLayoutY(610);
		buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum/100+5) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(itemNum/100+10) +", 0, 0, 0, 8);");
	}
	
	public void buildBtnUnabled() {
		buildBtn.setLayoutY(614);
		buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(-1) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(-2) +", 0, 0, 0, 4);");

	}

}
