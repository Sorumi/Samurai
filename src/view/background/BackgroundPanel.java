package view.background;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.Images;

public class BackgroundPanel extends Pane{
	private ImageView bg;
	
	public BackgroundPanel(){
		this.bg = new ImageView(Images.BG_0);
		this.bg.setFitWidth(1200);
		this.bg.setPreserveRatio(true);
		this.getChildren().add(bg);
		
		
		
		
		
	}

}
