package view.guide;

import javafx.scene.layout.Pane;

public class GuidePanel extends Pane{ 
	private int WIDTH = 1100;
	private int HEIGHT = 700;
	
	public GuidePanel(){
		this.setPrefSize(WIDTH, HEIGHT);
		this.setLayoutX(50);
		this.setLayoutY(50);
		this.setId("guide-panel");
		
//		this.setVisible(true);
	}

}
