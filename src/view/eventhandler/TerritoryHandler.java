package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import view.TerritoryPanel;
import view.campsite.CampsitePanel;
import view.smithy.SmithyPanel;

public class TerritoryHandler {
	
	private TerritoryPanel territoryPanel;

	public TerritoryHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
	}
	
	public EventHandler<MouseEvent> campsiteEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.campsitePanel = new CampsitePanel();
	    	  territoryPanel.getChildren().add(territoryPanel.campsitePanel);
	    	  territoryPanel.systemCloseBtn.toFront();
	    	  territoryPanel.systemCloseBtn.setVisible(true);
	      }
	};
	public EventHandler<MouseEvent> smithyEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.smithyPanel = new SmithyPanel();
	    	  territoryPanel.getChildren().add(territoryPanel.smithyPanel);
	    	  territoryPanel.systemCloseBtn.toFront();
	    	  territoryPanel.systemCloseBtn.setVisible(true);
	      }
	};
}
