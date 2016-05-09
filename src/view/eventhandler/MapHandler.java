package view.eventhandler;

import controller.MapController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.MapPanel;
import view.TerritoryPanel;
import view.MapPanel.LandButton;

public class MapHandler {

	private MapPanel mapPanel;
	private MapController mapController;
	  
	public MapHandler(MapPanel mapPanel){
		this.mapPanel = mapPanel;
		this.mapController = new MapController();
	}
	
	public EventHandler<MouseEvent> homeEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryPanel parent =  (TerritoryPanel) mapPanel.getParent();
	    	  parent.getChildren().remove(mapPanel);
	      }
	};
	
	public EventHandler<MouseEvent> buttonClickEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  LandButton btn = (LandButton) event.getSource();
	    	  //TODO
	    	  //开始游戏！！！
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
