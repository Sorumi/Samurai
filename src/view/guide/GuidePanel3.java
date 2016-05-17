package view.guide;

public class GuidePanel3 extends GuidePanel {

	public GuidePanel3(){
//		ChessBoardGuidePanel chessBoardCoursePanel = new ChessBoardGuidePanel(11);
//		this.getChildren().add(chessBoardCoursePanel);
		GameGuidePanel gamePanel = new GameGuidePanel(11);
		this.getChildren().add(gamePanel);
		this.setVisible(false);  
	}
}
