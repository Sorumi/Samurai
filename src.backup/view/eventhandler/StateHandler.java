package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.GamePanel;
import view.SamuraiPanel;

public class StateHandler {
	private GamePanel gamePanel;
	
	public StateHandler(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}
	
	public EventHandler<MouseEvent> showStatePanel = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();	 
	    	  gamePanel.statePanel.setCurrentSamurai(currentSamurai);
	    	  gamePanel.statePanel.setAppear(true);
//	    		gamePanel.setOrder();
	    	  
	      }
	};
	
	public EventHandler<MouseEvent> closeStatePanel = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();	    	  
	    	  gamePanel.statePanel.setAppear(false);
//	    		  gamePanel.setOrder();
	    	  
	      }
	};

}
