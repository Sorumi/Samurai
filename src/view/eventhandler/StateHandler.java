package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.GamePanel;
import view.SamuraiPanel;
import view.SamuraiView;
import view.TerritoryPanel;

public class StateHandler {
	private GamePanel gamePanel;
	private TerritoryPanel territoryPanel;
	
	public StateHandler(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}
	
	public StateHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
	}
	
	public EventHandler<MouseEvent> showStatePanelInG = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();	 
	    	  gamePanel.statePanel.setCurrentSamuraiInG(currentSamurai); 
	    	  gamePanel.statePanel.setAppear(true);
	    	  
	      }
	};
	
	public EventHandler<MouseEvent> showStatePanelInT = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiView currentSamurai = (SamuraiView) event.getSource();	  
	    	  territoryPanel.statePanel.setCurrentSamuraiInT(currentSamurai);
	    	  territoryPanel.statePanel.setAppear(true);

	      }
	};
	
	public EventHandler<MouseEvent> closeStatePanelInG = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();	    	  
	    	  gamePanel.statePanel.setAppear(false);
	    	   
	      }
	};
	
	public EventHandler<MouseEvent> closeStatePanelInT = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiView currentSamurai = (SamuraiView) event.getSource();	  
	    	  territoryPanel.statePanel.setCurrentSamuraiInT(currentSamurai);
	    	  territoryPanel.statePanel.setAppear(false);
	    	  
	      }
	};

}
