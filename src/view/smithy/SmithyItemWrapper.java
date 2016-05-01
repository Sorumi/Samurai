package view.smithy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GameColor;

public class SmithyItemWrapper extends Pane{

	protected int num;//0:spear 1:sword 2: battleax 3:shuriken 4:bow and arrow

	public SmithyItemWrapper(int num){
		this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(num));
		
		this.setPrefSize(1000, 700);
		this.setLayoutX(150);
		this.setLayoutY(50);
		this.setId("smithy-wrapper");
	}
}
