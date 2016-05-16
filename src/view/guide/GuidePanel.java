package view.guide;

import javafx.scene.layout.Pane;

public class GuidePanel extends Pane{ 
	private int WIDTH = 1100;
	private int HEIGHT = 700;
	
	public GuidePanel(){
		this.setPrefSize(WIDTH, HEIGHT);
		
		ChessBoardGuidePanel chessBoardCoursePanel = new ChessBoardGuidePanel(11);
		this.getChildren().add(chessBoardCoursePanel);
		
		this.setVisible(true);
	}

}
