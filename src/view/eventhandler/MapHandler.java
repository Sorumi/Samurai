package view.eventhandler;

import controller.MapController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import model.StoryModel;
import view.LevelSelectPanel;
import view.LevelSelectPanel.LevelButton;
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
		this.mapController.setStoryModel(StoryModel.getStoryModel());
	}
	
	public EventHandler<MouseEvent> homeEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {	    	  
	    	  StoryPanel parent =  (StoryPanel) mapPanel.getParent();
	    	  parent.territoryPanel.toFront();
	      }
	};
	
	public EventHandler<MouseEvent> startGameEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  LevelButton btn = (LevelButton) event.getSource();
	    	  //TODO
	    	  //开始游戏！！！
	    	  /*
	    	   * 11, 12, 13
	    	   * 21, 22, 23
	    	   * 31, 32, 33
	    	   * 41, 42, 43
	    	   * 51, 52, 53
	    	   */
	    	  StoryPanel storyPanel =  (StoryPanel) mapPanel.getParent();
	    	  LevelSelectPanel selectPanel = (LevelSelectPanel)btn.getParent();
	    	  int num = selectPanel.level*10 + btn.num;
	    	  storyPanel.gamePanel = new GamePanel(15, num);
	    	  storyPanel.getChildren().add(storyPanel.gamePanel);

			  mapController.setGamePanel(storyPanel.gamePanel);
			  mapController.startGameAtLevel(num);

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
	    	  LandButton btn = (LandButton) event.getSource();
	    	  mapPanel.levelSelectPanel.setLevel(btn.levelNum);
	    	  mapPanel.levelSelectPanel.setAppear(true); 
	    	  
	      }
	};
	
}
