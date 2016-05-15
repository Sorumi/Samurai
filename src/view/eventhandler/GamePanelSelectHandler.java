package view.eventhandler;

import controller.msgqueue.EndOperation;
import controller.msgqueue.OperationQueue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.GamePanel;
import view.MenuPanel;
import view.StoryPanel;

public class GamePanelSelectHandler implements EventHandler {
	private GamePanel gamePanel;
	public int level; 

	public GamePanelSelectHandler(GamePanel gamePanel,int level){
		this.gamePanel = gamePanel;
		this.level = level;
	}
	
	public EventHandler<MouseEvent> yesEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  switch(level){
	    	  case 99:
					Pane basePanel = (Pane) gamePanel.getParent(); 
					basePanel.getChildren().remove(gamePanel);
					MenuPanel menu = (MenuPanel)basePanel.getChildren().get(0);
					menu.samuraiTimer.start();

					OperationQueue.addOperation(new EndOperation(false));
					break;
				case 0:
					OperationQueue.addOperation(new EndOperation(false));
					break;
				default:
					//TODO
					StoryPanel storyPanel = (StoryPanel) gamePanel.getParent();
					storyPanel.mapPanel.toFront();
					storyPanel.gamePanel.getChildren().remove(gamePanel);
					storyPanel.gamePanel = null;

					OperationQueue.addOperation(new EndOperation(false));
					break;
	    	  }

	      }
	};
	
	public EventHandler<MouseEvent> noEvent = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  gamePanel.selectPanel.setVisible(false);	    	   
	      }
	};
	
	public EventHandler<MouseEvent> yesBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  gamePanel.selectPanel.btnPressed(0); 
	      }
	};
	
	public EventHandler<MouseEvent> yesBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  gamePanel.selectPanel.btnAbled(0);
	      }
	};
	
	public EventHandler<MouseEvent> noBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  gamePanel.selectPanel.btnPressed(1); 
	      }
	};
	
	public EventHandler<MouseEvent> noBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  gamePanel.selectPanel.btnAbled(1);
	      }
	};

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}

	
	

}
