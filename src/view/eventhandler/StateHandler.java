package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.game.GamePanel;
import view.samurai.SamuraiPanel;
import view.samurai.SamuraiView;
import view.story.TerritoryPanel;

public class StateHandler {
	private GamePanel gamePanel;
	private TerritoryPanel territoryPanel;
	
	public StateHandler(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}
	
	public StateHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
	}
	
	public EventHandler<MouseEvent> currentSamuraiShowStateEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = gamePanel.currentSamurai;
	    	  currentSamurai.setHighlight();
	    	  gamePanel.statePanel.setCurrentSamuraiInG(currentSamurai); 
	    	  gamePanel.statePanel.setAppear(true);
			  gamePanel.setOrder();
	    	  gamePanel.statePanel.set6Properties(gamePanel.get6Properties(currentSamurai.getNum()));
			  gamePanel.statePanel.setBloodTotal(gamePanel.getBloodTotalOfSamurai(currentSamurai.getNum()));
			  gamePanel.statePanel.setBloodRest(gamePanel.getBloodRestOfSamurai(currentSamurai.getNum()));
	      }
	};
	
	public EventHandler<MouseEvent> currentSamuraiHideStateEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = gamePanel.currentSamurai;
	    	  currentSamurai.setNormal();
	    	  gamePanel.statePanel.setAppear(false);
	      }
	};
	
	public EventHandler<MouseEvent> showStatePanelInG = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();
	    	  currentSamurai.setHighlight();
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

	    	  int i = currentSamurai.getNumber();
			  territoryPanel.statePanel.set6Properties(territoryPanel.get6PropertiesOfSamurai(i));
			  territoryPanel.statePanel.setBloodTotal(territoryPanel.getBloodTotalOfSamurai(i));
			  territoryPanel.statePanel.setExperience(territoryPanel.getExperienceOfSamurai(i));
		  }
	};
	
	public EventHandler<MouseEvent> closeStatePanelInG = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();	
	    	  currentSamurai.setNormal();
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
