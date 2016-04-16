package view;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.NextOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.eventhandler.ActionHandler;

public class ActionPanel extends Pane {
	private final int BUTTONPANEL_WIDTH = 208;
	private final int BUTTONPANEL_HEIGHT = 300;
	
	private final int BUTTON_WIDTH = 58;

	private ActionButton moveButton;
	private ActionButton occupyButton;
	private ActionButton hideButton;
	private ActionButton exitButton;
	private ActionButton backButton;
	private DirectionPanel directionPanel;
	
	private SamuraiView currentSamurai;
	
	private ActionHandler actionHandler;
	
	public ActionPanel(ActionHandler actionHandler){
		
		this.actionHandler = actionHandler;
		
		occupyButton = new ActionButton(0);	
		moveButton = new ActionButton(1);
		hideButton = new ActionButton(2);
		exitButton = new ActionButton(3);
		backButton = new ActionButton(4);

		this.setVisible(false);
		
		moveButton.setLayoutX(75);
		moveButton.setLayoutY(121);
		occupyButton.setLayoutX(75);
		occupyButton.setLayoutY(121);
		hideButton.setLayoutX(75);
		hideButton.setLayoutY(121);
		exitButton.setLayoutX(75);
		exitButton.setLayoutY(121);
		backButton.setLayoutX(150);
		backButton.setLayoutY(60);
		
		backButton.setVisible(false);
		
		 TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(4000), moveButton);
	     translateTransition1.setFromX(0);
	     translateTransition1.setFromY(0);
         translateTransition1.setToX(-35);
         translateTransition1.setToY(-121);
	     translateTransition1.setAutoReverse(false);
         translateTransition1.play();
         
    	 TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(4000), occupyButton);
	     translateTransition2.setFromX(0);
	     translateTransition2.setFromY(0);
         translateTransition2.setToX(-75);
         translateTransition2.setToY(-61);
	     translateTransition2.setAutoReverse(false);
         translateTransition2.play();
         
         TranslateTransition translateTransition3 = new TranslateTransition(Duration.millis(4000), hideButton);
	     translateTransition3.setFromX(0);
	     translateTransition3.setFromY(0);
         translateTransition3.setToX(35);
         translateTransition3.setToY(-121);
	     translateTransition3.setAutoReverse(false);
         translateTransition3.play();
         
         TranslateTransition translateTransition4 = new TranslateTransition(Duration.millis(4000), exitButton);
   	     translateTransition4.setFromX(0);
   	     translateTransition4.setFromY(0);
         translateTransition4.setToX(75);
         translateTransition4.setToY(-61);
   	     translateTransition4.setAutoReverse(false);
         translateTransition4.play();
		
		directionPanel = new DirectionPanel(actionHandler);
		directionPanel.setLayoutX((BUTTONPANEL_WIDTH-directionPanel.getBoundsInParent().getWidth())/2);
		directionPanel.setLayoutY(130);
		directionPanel.setVisible(false);
		
		moveButton.setOnMouseClicked(actionHandler.secondaryEvent);
		occupyButton.setOnMouseClicked(actionHandler.secondaryEvent);
		hideButton.setOnMouseClicked(actionHandler.hideEvent);
		exitButton.setOnMouseClicked(actionHandler.exitEvent);
		backButton.setOnMouseClicked(actionHandler.backEvent);
		
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
	
	
	
	
}
