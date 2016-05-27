package view;

import javafx.scene.layout.Pane;
import view.eventhandler.StoryHandler;

public class StoryPanel extends Pane {

	 private final int WINDOW_WIDTH = 1200;
	 private final int WINDOW_HEIGHT = 800;
	 
	 private StoryHandler storyHandler;
	 
	 public StartStoryPanel startPanel;
	 public TerritoryPanel territoryPanel;
	 public CustomizePanel customizePanel;
	 public MapPanel mapPanel;
	 public GamePanel gamePanel;

	 public StoryPanel(){
		 this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		 
		 storyHandler = new StoryHandler(this);
	 }
	 
	 public void startStory(){
		 startPanel = new StartStoryPanel(storyHandler);
		 this.getChildren().add(startPanel);
	 }
	 
	 public void startGame(){
		 
		 territoryPanel = new TerritoryPanel();
		 mapPanel = new MapPanel();
		 
		 this.getChildren().addAll(mapPanel, territoryPanel);
		 this.getChildren().remove(startPanel);
		 startPanel = null;
	 }
}
