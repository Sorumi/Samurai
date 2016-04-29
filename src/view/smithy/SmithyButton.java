package view.smithy;

import javafx.scene.control.Button;
import view.GameColor;

public class SmithyButton extends Button {

	int num;
	
	public SmithyButton(int num){
		this.num = num;
		
		this.setStyle("-fx-background-color: " + GameColor.getColorString(num));
		this.setId("smithy-btn");
		this.setPrefSize(100, 100);
		this.setLayoutX(50);
		this.setLayoutY(50+102*(num));
	}
}
