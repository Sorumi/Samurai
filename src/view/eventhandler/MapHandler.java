package view.eventhandler;

import controller.MapController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
//	    	  parent.gamePanel = new GamePanel();
	    	  parent.gamePanel.toFront();
	    	  System.out.println(btn.levelNum);
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
	
}
