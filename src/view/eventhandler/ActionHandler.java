package view.eventhandler;

import controller.msgqueue.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import view.ActionButton;
import view.DirectionButton;
import view.GamePanel;
import view.SamuraiPanel;

public class ActionHandler {
	
	private GamePanel gamePanel;
	private int action;
	private int direction;
	
	public ActionHandler(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}
	
	public EventHandler<MouseEvent> samuraiEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();
	    	  if(currentSamurai.canActionProperty().get()){
	    		  gamePanel.actionPanel.setAppear(true, true);
	    		  gamePanel.arrow.setAppear(false);
	    		  gamePanel.setOrder();
	    	  }
	      }
	};
	
	public EventHandler<MouseEvent> actionPanelDisappearEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  if (event.getButton() == MouseButton.SECONDARY) {
	    		  gamePanel.actionPanel.setAppear(false, true);
	    		  gamePanel.arrow.setAppear(true);
	    		  gamePanel.setOrder();
	    	  }  
	      }
	};

	public EventHandler<MouseEvent> secondaryEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  //分move occupy两种情况
	    	  gamePanel.actionPanel.setSecondary(new boolean[]{true, true, true, true});//TODO
	      }
	};
	
	public EventHandler<MouseEvent> hideEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  Operation op = new ActionOperation(action, 0);
	    	  OperationQueue.addOperation(op);
	      }
	};
	
	public EventHandler<MouseEvent> backEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  gamePanel.actionPanel.closeSecondary();
	      }
	};
	
	public EventHandler<MouseEvent> exitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  gamePanel.actionPanel.closeSecondary();
	    	  Operation op = new NextOperation();
	    	  OperationQueue.addOperation(op);
	      }
	};
	
	public EventHandler<MouseEvent> directionEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  direction = btn.direction;
	    	  Operation op = new ActionOperation(action, direction);
	    	  OperationQueue.addOperation(op);
	      }
	};
	
	public EventHandler<MouseEvent> directionEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  btn.setHighLight(true);

			  System.out.println("MOUSE ENTER");

			  direction = btn.direction;
			  Operation op = new PseudoOccupyOperation(true,direction);
			  OperationQueue.addOperation(op);

	      }
	};

	public EventHandler<MouseEvent> directionExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  btn.setHighLight(false);

			  System.out.println("MOUSE EXIT");

			  direction = btn.direction;
			  Operation op = new PseudoOccupyOperation(false,direction);
			  OperationQueue.addOperation(op);

	      }
	};
	

}
