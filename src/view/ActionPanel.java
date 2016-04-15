package view;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.NextOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ActionPanel extends Pane {
	private final int BUTTONPANEL_WIDTH = 208;
	private final int BUTTONPANEL_HEIGHT = 300;
	
	private final int BUTTON_WIDTH = 58;

	private int action;
	private ActionButton moveButton;
	private ActionButton occupyButton;
	private ActionButton hideButton;
	private ActionButton exitButton;
	private ActionButton backButton;
	private DirectionPanel directionPanel;
	
	private SamuraiView currentSamurai;
	
	public ActionPanel(){
		
		occupyButton = new ActionButton(0);	
		moveButton = new ActionButton(1);
		hideButton = new ActionButton(2);
		exitButton = new ActionButton(3);
		backButton = new ActionButton(4);

		this.setVisible(false);
		
		moveButton.setLayoutX(40);
		moveButton.setLayoutY(0);
		occupyButton.setLayoutX(0);
		occupyButton.setLayoutY(60);
		hideButton.setLayoutX(110);
		hideButton.setLayoutY(0);
		exitButton.setLayoutX(150);
		exitButton.setLayoutY(60);
		backButton.setLayoutX(150);
		backButton.setLayoutY(60);
		
		backButton.setVisible(false);
		
		directionPanel = new DirectionPanel();
		directionPanel.setLayoutX((BUTTONPANEL_WIDTH-directionPanel.getBoundsInParent().getWidth())/2);
		directionPanel.setLayoutY(130);
		directionPanel.setVisible(false);
		
		moveButton.setOnMouseClicked(secondaryEvent);
		occupyButton.setOnMouseClicked(secondaryEvent);
		hideButton.setOnMouseClicked(hideEvent);
		exitButton.setOnMouseClicked(exitEvent);
		backButton.setOnMouseClicked(backEvent);
		
		this.getChildren().add(moveButton);
		this.getChildren().add(occupyButton);
		this.getChildren().add(hideButton);
		this.getChildren().add(exitButton);
		this.getChildren().add(backButton);
		this.getChildren().add(directionPanel);
	}
	
	public void setCurrentSamurai(SamuraiView samurai){
		this.currentSamurai = samurai;
		this.setVisible(false);
		this.setSecondary(false);
		this.setActualLocation();
	}
	
	public void setActualLocation(){
		this.setLayoutX(currentSamurai.getLayoutX() +34 -this.getBoundsInParent().getWidth()/2);
		this.setLayoutY(currentSamurai.getLayoutY()-70);
	}
	
	public void setSecondary(boolean isVisible){
		backButton.setVisible(isVisible);
		exitButton.setVisible(!isVisible);
		moveButton.setVisible(!isVisible);
		occupyButton.setVisible(!isVisible);
		hideButton.setVisible(!isVisible);
		directionPanel.setVisible(isVisible);
	}
	
	EventHandler<MouseEvent> secondaryEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  directionPanel.setAction(action);
	    	  backButton.setVisible(true);
	    	  exitButton.setVisible(false);
	    	  moveButton.setVisible(false);
	    	  occupyButton.setVisible(false);
	    	  hideButton.setVisible(false);
	    	  directionPanel.setVisible(true);
	      }
	};
	
	EventHandler<MouseEvent> hideEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  System.out.println("hide");
	    	  Operation op = new ActionOperation(action, 0);
	    	  OperationQueue.addOperation(op);
	      }
	};
	
	EventHandler<MouseEvent> backEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionButton btn = (ActionButton)event.getSource();
	    	  action = btn.action;
	    	  backButton.setVisible(false);
	    	  exitButton.setVisible(true);
	    	  moveButton.setVisible(true);
	    	  occupyButton.setVisible(true);
	    	  hideButton.setVisible(true);
	    	  directionPanel.setVisible(false);
	      }
	};
	
	EventHandler<MouseEvent> exitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  backButton.setVisible(false);
	    	  exitButton.setVisible(true);
	    	  moveButton.setVisible(true);
	    	  occupyButton.setVisible(true);
	    	  hideButton.setVisible(true);
	    	  directionPanel.setVisible(false);
	    	  Operation op = new NextOperation();
	    	  OperationQueue.addOperation(op);
	      }
	};

}
