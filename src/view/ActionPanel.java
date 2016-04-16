package view;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.NextOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import javafx.animation.ParallelTransition;
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
	private final int BUTTON_Y = 120;
	
	private boolean isAppear;

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
		this.isAppear = false;
		
		this.setStartLocation();
		
		backButton.setVisible(false);
		
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
		this.setAppear(false);
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
	
	public void setAppear(boolean isAppear){
		
		if(isAppear == this.isAppear){
			return;
		}
		if(isAppear){
			this.setVisible(isAppear);
			TranslateTransition tt1 = new TranslateTransition(Duration.millis(500), occupyButton);
			tt1.setFromX(0);
			tt1.setFromY(0);
	        tt1.setToX(-(BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
	        tt1.setToY(-BUTTON_Y+60);
	        tt1.play();
	        
			TranslateTransition tt2 = new TranslateTransition(Duration.millis(500), moveButton);
			tt2.setFromX(0);
			tt2.setFromY(0);
	        tt2.setToX(-(BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2+40);
	        tt2.setToY(-BUTTON_Y);
	        tt2.setDelay(Duration.millis(50));
	        tt2.play();
	        
	        TranslateTransition tt3 = new TranslateTransition(Duration.millis(500), hideButton);
			tt3.setFromX(0);
			tt3.setFromY(0);
	        tt3.setToX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2-40);
	        tt3.setToY(-BUTTON_Y);
	        tt3.setDelay(Duration.millis(100));
	        tt3.play();

	        TranslateTransition tt4 = new TranslateTransition(Duration.millis(500), exitButton);
			tt4.setFromX(0);
			tt4.setFromY(0);
	        tt4.setToX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
	        tt4.setToY(-BUTTON_Y+60);
	        tt4.setDelay(Duration.millis(150));
	        tt4.play();

		}else{
			this.setStartLocation();
			System.out.println("startLoaction");
			this.setVisible(isAppear);
		}
		
        
        this.isAppear = isAppear;
	}
	
	public void setStartLocation(){
		moveButton.setLayoutX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
		moveButton.setLayoutY(BUTTON_Y);
		occupyButton.setLayoutX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
		occupyButton.setLayoutY(BUTTON_Y);
		hideButton.setLayoutX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
		hideButton.setLayoutY(BUTTON_Y);
		exitButton.setLayoutX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
		exitButton.setLayoutY(BUTTON_Y);
		backButton.setLayoutX(150);
		backButton.setLayoutY(60);
	}
	
}
