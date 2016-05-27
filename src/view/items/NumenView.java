package view.items;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.Images;

public class NumenView extends Group{
	
	private ImageView light;
	private ImageView numen;
	private FadeTransition ft;
	private DialogView dialog;
	
	public NumenView(){
		light = new ImageView(Images.NUMEN_LIGHT);
		light.setFitWidth(360);
		light.setPreserveRatio(true);
		
		numen = new ImageView(Images.NUMEN);
		numen.setFitWidth(68);
		numen.setPreserveRatio(true);
		numen.setLayoutX(146);
		numen.setLayoutY(146);
		
		this.getChildren().addAll(light, numen);
	}
	
	public FadeTransition getFt(){
		
		ft = new FadeTransition(Duration.millis(3000), light);
		ft.setFromValue(0.7);
		ft.setToValue(1);
		ft.setAutoReverse(true);
		ft.setCycleCount(Timeline.INDEFINITE);
		
		return ft;
	}
	
	public void setDialog(int size, String text){
		this.getChildren().remove(dialog);
		dialog = new DialogView(size, text);
		if (size > 3){
			dialog.setLayoutX(30);
			dialog.setLayoutY(-90);
		}else{
			dialog.setLayoutX(180 -size*50);
			dialog.setLayoutY(-50);
		}

		this.getChildren().add(dialog);
	}
	
	public void removeDialog(){
		this.getChildren().remove(dialog);
	}
	
	

}

