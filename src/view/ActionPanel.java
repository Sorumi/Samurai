package view;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.NextOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
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
	
	private final int SAMURAI_WIDTH = 60;
	
	private boolean isAppear;

	private ActionButton moveButton;
	private ActionButton occupyButton;
	private ActionButton hideButton;
	private ActionButton exitButton;
	private ActionButton backButton;
	private DirectionPanel directionPanel;
	
	private SamuraiPanel currentSamurai;
	
	private ActionHandler actionHandler;
	
	public ActionPanel(ActionHandler actionHandler){
		
		this.actionHandler = actionHandler;
		
		occupyButton = new ActionButton(0);	
		moveButton = new ActionButton(1);
		hideButton = new ActionButton(2);
		exitButton = new ActionButton(3);
		backButton = new ActionButton(4);

		this.setPrefWidth(BUTTONPANEL_WIDTH);
		this.setPrefHeight(BUTTONPANEL_HEIGHT);
		this.setVisible(false);
		this.isAppear = false;
//		this.setStyle("-fx-background-color: #DDDDDD");
		
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
	
	public void setCurrentSamurai(SamuraiPanel samurai){
		this.currentSamurai = samurai;
		this.setAppear(false);
		this.setSecondary(false);
		this.setActualLocation();
		
	}
	
	public void setActualLocation(){
		this.setLayoutX(currentSamurai.getLayoutX() +SAMURAI_WIDTH/2 -BUTTONPANEL_WIDTH/2);
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
			tt1.setFromX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
			tt1.setFromY(BUTTON_Y);
	        tt1.setToX(0);
	        tt1.setToY(60);
	        tt1.play();
	        
			TranslateTransition tt2 = new TranslateTransition(Duration.millis(500), moveButton);
			tt2.setFromX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
			tt2.setFromY(BUTTON_Y);
	        tt2.setToX(40);
	        tt2.setToY(0);
	        tt2.play();
	        
	        TranslateTransition tt3 = new TranslateTransition(Duration.millis(500), hideButton);
			tt3.setFromX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
			tt3.setFromY(BUTTON_Y);
	        tt3.setToX(110);
	        tt3.setToY(0);
	        tt3.play();

	        TranslateTransition tt4 = new TranslateTransition(Duration.millis(500), exitButton);
			tt4.setFromX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
			tt4.setFromY(BUTTON_Y);
	        tt4.setToX(150);
	        tt4.setToY(60);
	        tt4.play();
	        
	        TranslateTransition tt5 = new TranslateTransition(Duration.millis(500), backButton);
			tt5.setFromX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
			tt5.setFromY(BUTTON_Y);
	        tt5.setToX(150);
	        tt5.setToY(60);
	        tt5.play();

		}else{
			TranslateTransition tt1 = new TranslateTransition(Duration.millis(500), occupyButton);
			tt1.setFromX(0);
			tt1.setFromY(60);
	        tt1.setToX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
	        tt1.setToY(BUTTON_Y);
	        tt1.play();
	        
			TranslateTransition tt2 = new TranslateTransition(Duration.millis(500), moveButton);
			tt2.setFromX(40);
			tt2.setFromY(0);
	        tt2.setToX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
	        tt2.setToY(BUTTON_Y);
	        tt2.play();
	        
	        TranslateTransition tt3 = new TranslateTransition(Duration.millis(500), hideButton);
			tt3.setFromX(110);
			tt3.setFromY(0);
	        tt3.setToX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
	        tt3.setToY(BUTTON_Y);
	        tt3.play();

	        TranslateTransition tt4 = new TranslateTransition(Duration.millis(500), exitButton);
			tt4.setFromX(150);
			tt4.setFromY(60);
	        tt4.setToX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
	        tt4.setToY(BUTTON_Y);
	        tt4.play();
	        
	        TranslateTransition tt5 = new TranslateTransition(Duration.millis(500), backButton);
			tt5.setFromX(150);
			tt5.setFromY(60);
	        tt5.setToX((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2);
	        tt5.setToY(BUTTON_Y);
	        tt5.play();
	        
	        tt5.setOnFinished(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					ActionPanel.this.setVisible(isAppear);
				}
	        });
			
		} 
        this.isAppear = isAppear;
	}
	
}
