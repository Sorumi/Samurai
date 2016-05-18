package view.smithy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import model.StoryModel;
import view.ArmorView;
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
	private ArmorView armor;
	private Button buildBtn;
	private SystemButton closeBtn;

	private Group materialGroup;

	private StackPane circlePane;

	public SmithyBuilder(int itemNum, SmithyHandler smithyHandler) {
		this.itemNum = itemNum;
		this.smithyHandler = smithyHandler;

		this.setLayoutY(50);
		if (itemNum / 100 != 9) {
			this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum / 100));
		} else {
			this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(5));
		}

		this.setId("smithy-builder");

		// item circle
		circlePane = new StackPane();
		circlePane.setPrefSize(RADIUS * 2, RADIUS * 2);
		circlePane.setLayoutY(70);

		Circle strokeCircle = new Circle();
		strokeCircle.setCenterX(RADIUS);
		strokeCircle.setCenterY(RADIUS);
		strokeCircle.setRadius(RADIUS);
		strokeCircle.setFill(null);
		strokeCircle.setStroke(Color.WHITE);
		strokeCircle.setStrokeWidth(15);
		strokeCircle.setStrokeType(StrokeType.INSIDE);
		circlePane.getChildren().add(strokeCircle);

		Circle fillCircle = new Circle();
		fillCircle.setCenterX(RADIUS);
		fillCircle.setCenterY(RADIUS);
		fillCircle.setRadius(RADIUS - 30);
		fillCircle.setFill(Color.WHITE);
		circlePane.getChildren().add(fillCircle);

		if (itemNum / 100 != 9) {
			weapon = new WeaponView(itemNum, 3);
			weapon.setGray();
			circlePane.getChildren().add(weapon);
			StackPane.setAlignment(weapon, Pos.CENTER);
		} else {
			armor = new ArmorView(itemNum, 3);
			armor.setGray();
			circlePane.getChildren().add(armor);
			StackPane.setAlignment(armor, Pos.CENTER);
		}

		this.getChildren().add(circlePane);

		// material
		materialGroup = new Group();
		this.getChildren().add(materialGroup);

		// buildBtn
		buildBtn = new Button("合 成");
		buildBtn.setPrefSize(100, 40);
		buildBtn.setId("build-btn");
		this.getChildren().add(buildBtn);

		// closeBtn
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				SmithyPanel parent = (SmithyPanel) SmithyBuilder.this.getParent();
				parent.getChildren().remove(SmithyBuilder.this);
				parent.routeGroup.setVisible(true);
			}
		});
		this.getChildren().add(closeBtn);

		buildBtnAbled();
		buildBtn.setOnMouseEntered(smithyHandler.buildBtnEnterEvent);
		buildBtn.setOnMouseExited(smithyHandler.buildBtnExitEvent);
		buildBtn.setOnMouseClicked(smithyHandler.buildBtnClickEvent);
	}

	public void setMaterial(int materialQuantity, int[] materialNum, String[] materialName, int[] currentQuantity,
			int[] materialNumber) {
		materialGroup.getChildren().remove(0, materialGroup.getChildren().size());
		int x = 130;
		if (materialQuantity <= 3) {
			x = 170;
		}

		for (int i = 0; i < materialQuantity; i++) {
			SmithyBuilderMaterialView materialView = new SmithyBuilderMaterialView(itemNum, materialNum[i],
					materialName[i], currentQuantity[i], materialNumber[i]);
			materialView.setLayoutX(x * i);
			materialGroup.getChildren().add(materialView);
			if (currentQuantity[i] < materialNumber[i]) {
				buildBtnUnabled();
				buildBtn.setOnMouseEntered(null);
				buildBtn.setOnMouseExited(null);
				buildBtn.setOnMouseClicked(null);

			}
		}
		materialGroup.setLayoutY(420);
		switch (materialQuantity) {
		case 2:
			materialGroup.setLayoutX(135);
			break;
		case 3:
			materialGroup.setLayoutX(50);
			break;
		case 4:
			materialGroup.setLayoutX(25);
			break;
		case 5:
			materialGroup.setLayoutX(25);
			this.width = 670;
			break;
		case 6:
			materialGroup.setLayoutX(25);
			this.width = 800;
			break;
		}
		this.setPrefSize(width, 700);
		this.setLayoutX((1200 - width) / 2);
		circlePane.setLayoutX(width / 2 - RADIUS);
		closeBtn.setLayoutX(width - 25);
		buildBtn.setLayoutX(width / 2 - 50);

	}

	public int getItemNum() {
		return this.itemNum;
	}

	// 造武器成功调用此方法
	public void build() {
		if (itemNum / 100 != 9) {
			weapon.setColored();
		} else {
			armor.setColored();
		}
	}

	public void buildBtnPressed() {
		buildBtn.setLayoutY(624);
		if (itemNum / 100 != 9) {
			buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum / 100 + 6) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(itemNum / 100 + 12)
					+ ", 0, 0, 0, 4);");
		} else {
			buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(11) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(17) + ", 0, 0, 0, 4);");
		}

	}

	public void buildBtnAbled() {
		buildBtn.setLayoutY(620);
		if (itemNum / 100 != 9) {
			buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum / 100 + 6) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(itemNum / 100 + 12)
					+ ", 0, 0, 0, 8);");
		} else {
			buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(11) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(17) + ", 0, 0, 0, 8);");
		}
	}

	public void buildBtnUnabled() {
		buildBtn.setLayoutY(624);
		buildBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(-1) + ";"
				+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(-2) + ", 0, 0, 0, 4);");

	}

}
