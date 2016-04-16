package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class DirectionButton extends Pane {

	private ImageView imageV;
	private ImageView imageVHL;
	public int direction;
	
	public DirectionButton(int direction){
		this.direction = direction;
		this.imageV = new ImageView(Images.DIRECTION[direction]);
		this.imageVHL = new ImageView(Images.DIRECTION_HL[direction]);
		this.imageV.setFitWidth(49);
		this.imageV.setPreserveRatio(true);
		this.imageVHL.setFitWidth(49);
		this.imageVHL.setPreserveRatio(true);
		this.getChildren().add(imageV);
	}
	
	public void setHighLight(boolean isHL){
		if(isHL){
			//
		}else{
			//
		}
	}
}
