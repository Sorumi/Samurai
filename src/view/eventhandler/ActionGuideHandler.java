package view.eventhandler;


import controller.msgqueue.ActionOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.PseudoOccupyOperation;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import view.ActionButton;
import view.DirectionButton;
import view.SamuraiPanel;
import view.guide.ActionGuideButton;
import view.guide.GameGuidePanel;
import view.guide.SamuraiGuidePanel;

public class ActionGuideHandler {


	private GameGuidePanel gamePanel;
	private int action;
	private int direction;
	
	public ActionGuideHandler(GameGuidePanel gamePanel){
		this.gamePanel = gamePanel;
	}
	
	public EventHandler<MouseEvent> samuraiEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiGuidePanel currentSamurai = (SamuraiGuidePanel) event.getSource();
	    	  if(currentSamurai.canActionProperty().get()){
	    		  gamePanel.actionPanel.setAppear(true, true);
	    	  }
	      }
	};
	
	public EventHandler<MouseEvent> actionPanelDisappearEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  if (event.getButton() == MouseButton.SECONDARY) {
	    		  gamePanel.actionPanel.setAppear(false, true);
	    	  }  
	      }
	};

	public EventHandler<MouseEvent> secondaryEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionGuideButton btn = (ActionGuideButton)event.getSource();
	    	  action = btn.action;
	    	  //分move occupy两种情况
	    	  gamePanel.actionPanel.setSecondary(new boolean[]{true, true, true, true});//TODO
	      }
	};
	
	public EventHandler<MouseEvent> hideEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionGuideButton btn = (ActionGuideButton)event.getSource();
	    	  action = btn.action;
//	    	  Operation op = new ActionOperation(action, 0);
//	    	  OperationQueue.addOperation(op);
	      }
	};
	
	public EventHandler<MouseEvent> backEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionGuideButton btn = (ActionGuideButton)event.getSource();
	    	  action = btn.action;
	    	  gamePanel.actionPanel.closeSecondary();
	      }
	};
	
	public EventHandler<MouseEvent> directionEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  direction = btn.direction;
//	    	  Operation op = new ActionOperation(action, direction);
//	    	  OperationQueue.addOperation(op);
	      }
	};
	
	public EventHandler<MouseEvent> directionEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  btn.setHighLight(true);

			  if(action == 0) {
				  direction = btn.direction;
//				  Operation op = new PseudoOccupyOperation(true, direction);
//				  OperationQueue.addOperation(op);
			  }

	      }
	};

	public EventHandler<MouseEvent> directionExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  btn.setHighLight(false);

			  if(action == 0) {
				  direction = btn.direction;
//				  Operation op = new PseudoOccupyOperation(false, direction);
//				  OperationQueue.addOperation(op);
			  }

	      }
	};

}
