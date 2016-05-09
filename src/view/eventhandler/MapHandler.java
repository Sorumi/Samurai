package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.ArchivePanel;
import view.LevelSelectPanel;
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
