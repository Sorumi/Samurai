package view;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

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
		this.imageVHL.setOpacity(0);
		this.getChildren().add(imageV);
		this.getChildren().add(imageVHL);
	}
	
	public void setHighLight(boolean isHL){
		if(isHL){
			FadeTransition ft = new FadeTransition(Duration.millis(300), imageVHL);
			ft.setFromValue(0);
			ft.setToValue(1);
			ft.play();
		}else{
			FadeTransition ft = new FadeTransition(Duration.millis(300), imageVHL);
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.play();
		}
	}
}
