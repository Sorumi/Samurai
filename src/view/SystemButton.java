package view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SystemButton extends Button {
	
	/*
	 * num:
	 * 0: close exit
	 * 1: save
	 * 2:
	 */
	public SystemButton(int num){
		this.setId("system-btn");
		ImageView img = null;

		switch(num){
		case 0:
			img = new ImageView(Images.SYSTEM_CLOSE_BTN);
			img.setFitWidth(25);
			break;
		case 1:
			img = new ImageView(Images.SYSTEM_SAVE_BTN);
			img.setFitWidth(32);
		}
		img.setPreserveRatio(true);
		if(img != null){
			this.setGraphic(img);
		}
	}

}
