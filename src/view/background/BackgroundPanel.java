package view.background;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.Images;

public class BackgroundPanel extends Pane{
	private ImageView bg;
	
	public BackgroundPanel(Image image){
		this.bg = new ImageView(image);
		this.bg.setFitWidth(1200);
		this.bg.setPreserveRatio(true);
		this.getChildren().add(bg);
		
		
		
		
		
	}

}
