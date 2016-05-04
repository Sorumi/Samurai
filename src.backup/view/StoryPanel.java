package view;

import javafx.scene.layout.Pane;

public class StoryPanel extends Pane {

	 private final int WINDOW_WIDTH = 1200;
	 private final int WINDOW_HEIGHT = 800;
	 
	 private TerritoryPanel territoryPanel;
	 private MapPanel mapPanel;
	 private GamePanel gamePanel;

	 public StoryPanel(){
		 this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		 this.setStyle("-fx-background-color: #dddddd");
		 territoryPanel = new TerritoryPanel();
		 this.getChildren().add(territoryPanel);
	 }
}
