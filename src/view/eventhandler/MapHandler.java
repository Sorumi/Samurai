package view.eventhandler;

import controller.MapController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import view.LevelSelectPanel;
import view.GamePanel;
import view.MapPanel;
import view.MapPanel.LandButton;
import view.StoryPanel;

public class MapHandler {

	private MapPanel mapPanel;
	private MapController mapController;
	  
	public MapHandler(MapPanel mapPanel){ 
		this.mapPanel = mapPanel;
		this.mapController = new MapController();
	}
	
	public EventHandler<MouseEvent> homeEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {	    	  
	    	  StoryPanel parent =  (StoryPanel) mapPanel.getParent();
	    	  parent.territoryPanel.toFront();
	      }
	};
	
	public EventHandler<MouseEvent> startGameEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Button btn = (Button) event.getSource();
	    	  //TODO
	    	  //开始游戏！！！
	    	  StoryPanel storyPanel =  (StoryPanel) mapPanel.getParent();
	    	  LevelSelectPanel selectPanel = (LevelSelectPanel)btn.getParent();
	    	  storyPanel.gamePanel = new GamePanel(15, selectPanel.level);
	    	  storyPanel.getChildren().add(storyPanel.gamePanel);

			  mapController.setGamePanel(storyPanel.gamePanel);
			  mapController.startGameAtLevel(selectPanel.level);

			  storyPanel.gamePanel.toFront();
	      }
	};
	
	public EventHandler<MouseEvent> buttonEnterEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  LandButton btn = (LandButton) event.getSource();
	    	  btn.setHighlight();
	      }
	};
	
	public EventHandler<MouseEvent> buttonExitEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  LandButton btn = (LandButton) event.getSource();
	    	  btn.setNormal();
	      }
	};
	
	public EventHandler<MouseEvent> levelSelectEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mapPanel.levelSelectPanel.setAppear(true); 
	      }
	};
	
}
