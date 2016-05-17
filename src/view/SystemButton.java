package view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SystemButton extends Button {
	
	/*
	 * num:
	 * 0: close exit
	 * 1: save
	 * 2: help
	 */
	public SystemButton(int num){
		this.setId("system-btn");
		ImageView img = new ImageView(Images.SYSTEM_BTN[num]);
//		img.setFitWidth(Images.SYSTEM_BTN[num].widthProperty().intValue()/2);

		switch(num){
		case 0://close
			img.setFitWidth(25);
			break;
		case 1://save
			img.setFitWidth(32);
			break;
		case 2://help
			img.setFitWidth(19);
			break;
		case 3://pause
			img.setFitWidth(19);
			break;
		case 4://continue
			img.setFitWidth(19);
			break;
			
		}
		
		img.setPreserveRatio(true);
		if(img != null){
			this.setGraphic(img);
		}
	}

}
