package view.course;

import javafx.scene.layout.Pane;

public class CoursePanel extends Pane{
	private int WIDTH = 1100;
	private int HEIGHT = 700;
	
	public CoursePanel(){
		this.setPrefSize(WIDTH, HEIGHT);
		
		ChessBoardCoursePanel chessBoardCoursePanel = new ChessBoardCoursePanel(11);
		this.getChildren().add(chessBoardCoursePanel);
		
		this.setVisible(true);
	}

}
