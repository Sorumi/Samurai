package view;

import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ActionButton extends Pane {

	private ImageView imageFront;
	public int pointsCost;
	public int action;
	public boolean canAction;
	
	public ActionButton(int action){
		this.action = action;
		this.imageFront = new ImageView(Images.ACTION_BUTTON[action]);
		this.imageFront.setFitWidth(58);
		this.imageFront.setPreserveRatio(true);
		this.getChildren().add(imageFront);
		
		switch(action){
		case 0:
			pointsCost = 4;break;
		case 1:
			pointsCost = 2;break;
		case 2:
			pointsCost = 1;break;
		case 3:
			pointsCost = 0;break;
		}
		this.canAction = true;
	}

	public void setFalse() {
		// TODO Auto-generated method stub

		 ColorAdjust grayColor = new ColorAdjust();
		 grayColor.setSaturation(-0.9);
		 
		 imageFront.setEffect(grayColor);
		 this.canAction = false;
	}
	
	public void setTrue(){
		imageFront.setEffect(null);
		this.canAction = true;
	}
}
