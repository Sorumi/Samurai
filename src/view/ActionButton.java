package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ActionButton extends Pane {

	private ImageView imageV;
	public int action;
	
	public ActionButton(int action){
		this.action = action;
		this.imageV = new ImageView(Images.ACTION_BUTTON[action]);
		this.imageV.setFitWidth(58);
		this.imageV.setPreserveRatio(true);
		this.getChildren().add(imageV);
	}
	
}
