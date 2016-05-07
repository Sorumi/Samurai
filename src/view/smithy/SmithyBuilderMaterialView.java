package view.smithy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.GameColor;
import view.MaterialView;

public class SmithyBuilderMaterialView extends Pane {

	/*
	 * itemNum: 制造的武器的编号
	 * materialNum: 材料的编号
	 * currentQuantity: 目前拥有的数量
	 * neededQuantity: 需要的数量
	 */
	private Label materialQuantity;
	private Label materialNameLabel;
	
	public SmithyBuilderMaterialView(int itemNum){
		this(itemNum, 0, " ", 0, 0);
	}
	public SmithyBuilderMaterialView(int itemNum, int materialNum, String materialName, int currentQuantity, int neededQuantity){

		this.setPrefSize(100, 160);
		
		Circle bgCircle = new Circle();
		bgCircle.setRadius(50);
		bgCircle.setFill(Color.WHITE);
		bgCircle.setCenterX(50);
		bgCircle.setCenterY(50);

		MaterialView materialView = new MaterialView(materialNum);
		
		materialNameLabel = new Label(materialName);
		materialNameLabel.setPrefSize(80, 20);
		materialNameLabel.setLayoutX(10);
		materialNameLabel.setLayoutY(110);
		materialNameLabel.setId("material-name");
		materialNameLabel.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(itemNum/100+5));
		
		materialQuantity = new Label(currentQuantity + " / " + neededQuantity);
		materialQuantity.setPrefSize(80, 20);
		materialQuantity.setLayoutX(10);
		materialQuantity.setLayoutY(140);
		materialQuantity.setId("material-quantity");
		materialQuantity.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(itemNum/100+10));

		this.getChildren().addAll(bgCircle, materialView, materialNameLabel, materialQuantity);
	}
	
	public void setMaterial(int currentQuantity){
		
	}
}
