package view.smithy;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import view.GameColor;
import view.Images;

public class SmithyButton extends Button {

	int num;
	
	public SmithyButton(int num){
		this.num = num;
		
		this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(num));
		this.setId("smithy-btn");
		this.setPrefSize(100, 100);
		this.setLayoutX(50);
		this.setLayoutY(50+102*(num));
		
		ImageView imgV = new ImageView(Images.WEAPON_ICON[num]);
		imgV.setFitWidth(80);
		imgV.setPreserveRatio(true);
		
		this.setGraphic(imgV);
		
	}
}
