package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import view.TerritoryPanel;
import view.campsite.CampsitePanel;

public class TerritoryHandler {
	
	private TerritoryPanel territoryPanel;

	public TerritoryHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
	}
	
	public EventHandler<MouseEvent> CampsiteEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.campsitePanel = new CampsitePanel();
	    	  territoryPanel.getChildren().add(territoryPanel.campsitePanel);
	      }
	};
}
