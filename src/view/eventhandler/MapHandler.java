package view.eventhandler;

import controller.MapController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import view.ArchivePanel;
import view.LevelSelectPanel;

import view.GamePanel;

import view.MapPanel;
import view.TerritoryPanel;
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
	
	public EventHandler<MouseEvent> buttonClickEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  LandButton btn = (LandButton) event.getSource();
	    	  //TODO
	    	  //开始游戏！！！
	    	  StoryPanel parent =  (StoryPanel) mapPanel.getParent();
	    	  parent.gamePanel = new GamePanel(15, btn.levelNum);
			  parent.getChildren().add(parent.gamePanel);

			  mapController.setGamePanel(parent.gamePanel);
			  mapController.startGameAtLevel(btn.levelNum);

			  parent.gamePanel.toFront();
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
	    	  mapPanel.levelSelectPanel = new LevelSelectPanel(00,10);
	    	  mapPanel.levelSelectPanel.setLayoutX(400);
	    	  mapPanel.levelSelectPanel.setLayoutY(250);
	    	  mapPanel.getChildren().add(mapPanel.levelSelectPanel);
	    	  mapPanel.levelSelectPanel.setAppear(true); 
	 

	      }
	};
	
}
