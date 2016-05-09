package view;

import javafx.scene.layout.Pane;

public class StoryPanel extends Pane {

	 private final int WINDOW_WIDTH = 1200;
	 private final int WINDOW_HEIGHT = 800;
	 
	 public TerritoryPanel territoryPanel;
	 public MapPanel mapPanel;
	 public GamePanel gamePanel;

	 public StoryPanel(){
		 this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		 
		 territoryPanel = new TerritoryPanel();
		 mapPanel = new MapPanel();
		 
		 this.getChildren().addAll(mapPanel, territoryPanel);

	 }
}
