package view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SystemCloseButton extends Button {
	
	public SystemCloseButton(){
		this.setId("close-btn");
		ImageView img = new ImageView(Images.SYSTEM_CLOSE_BTN);
		img.setFitWidth(25);
		img.setPreserveRatio(true);
		this.setGraphic(img);
	}

}
