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
			  gamePanel.setOrder();
	    	  gamePanel.statePanel.set6Properties(gamePanel.get6Properties(currentSamurai.getNum()));
			  gamePanel.statePanel.setBloodTotal(gamePanel.getBloodTotalOfSamurai(currentSamurai.getNum()));
			  gamePanel.statePanel.setBloodRest(gamePanel.getBloodRestOfSamurai(currentSamurai.getNum()));
	      }
	};
	
	public EventHandler<MouseEvent> showStatePanelInT = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiView currentSamurai = (SamuraiView) event.getSource();	  
	    	  territoryPanel.statePanel.setCurrentSamuraiInT(currentSamurai);
	    	  territoryPanel.statePanel.setAppear(true);

			  territoryPanel.statePanel.set6Properties(territoryPanel.get6PropertiesOfSamurai(currentSamurai.getNumber()));
			  territoryPanel.statePanel.setBloodTotal(territoryPanel.getBloodTotalOfSamurai(currentSamurai.getNumber()));
		  }
	};
	
	public EventHandler<MouseEvent> closeStatePanelInG = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
//	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();	    	  
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
