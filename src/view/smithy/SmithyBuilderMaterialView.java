package view.smithy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.GameColor;
import view.story.MaterialView;

public class SmithyBuilderMaterialView extends Pane {

	/*
	 * itemNum: 制造的武器的编号
	 * materialNum: 材料的编号
	 * currentQuantity: 目前拥有的数量
	 * neededQuantity: 需要的数量
	 */
	private Label materialCurrentQuantity;
	private Label materialNeededQuantity;
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
		if (itemNum/100 != 9){
			materialNameLabel.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(itemNum/100+6));
		}else{
			materialNameLabel.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(11));
		}
		
		materialCurrentQuantity = new Label(currentQuantity + " ");
		materialCurrentQuantity.setPrefSize(50, 20);
		materialCurrentQuantity.setLayoutX(0);
		materialCurrentQuantity.setLayoutY(140);
		materialCurrentQuantity.setId("material-current-quantity");	
		
		materialNeededQuantity = new Label("/ " + neededQuantity);
		materialNeededQuantity.setPrefSize(50, 20);
		materialNeededQuantity.setLayoutX(50);
		materialNeededQuantity.setLayoutY(140);
		materialNeededQuantity.setId("material-needed-quantity");
		
		if (itemNum/100 != 9){
			materialNeededQuantity.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(itemNum/100+12));
			materialCurrentQuantity.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(itemNum/100+12));
		}else{
			materialNeededQuantity.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(17));
			materialCurrentQuantity.setStyle("-fx-text-fill: " + GameColor.getWeaponColorString(17));
		}
		
		if(currentQuantity < neededQuantity){
			materialCurrentQuantity.setStyle("-fx-text-fill: #ffffff");
		}

		this.getChildren().addAll(bgCircle, materialView, materialNameLabel, materialCurrentQuantity, materialNeededQuantity);
	}
	
	public void setMaterial(int currentQuantity){
		
	}
}
