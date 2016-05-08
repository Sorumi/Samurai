package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.MapPanel;
import view.TerritoryPanel;
import view.MapPanel.LandButton;

public class MapHandler {

	private MapPanel mapPanel;

	  
	public MapHandler(MapPanel mapPanel){
		this.mapPanel = mapPanel;
	}
	
	public EventHandler<MouseEvent> homeEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryPanel parent =  (TerritoryPanel) mapPanel.getParent();
	    	  parent.getChildren().remove(mapPanel);
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
