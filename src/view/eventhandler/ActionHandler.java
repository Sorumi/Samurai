package view.eventhandler;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.NextOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.ActionButton;
import view.DirectionButton;
import view.GamePanel;

public class ActionHandler {
	
	private GamePanel gamePanel;
	private int action;
	private int direction;
	
	
	public ActionHandler(GamePanel gamePanel){
		this.gamePanel = gamePanel;
	}

	public EventHandler<MouseEvent> secondaryEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  gamePanel.actionPanel.setSecondary(true);
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
	    	  gamePanel.actionPanel.setSecondary(false);
	      }
	};
	
	public EventHandler<MouseEvent> exitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  gamePanel.actionPanel.setSecondary(false);
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
	

}
