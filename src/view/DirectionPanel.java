package view;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DirectionPanel extends Pane {
	
	private final int DIRECTION_WIDTH = 49;
	private final int DIRECTION_HEIGHT = 35;
	private final int WIDTH_FIX = 18;
	private final int HEIGHT_FIX = 8;
	
	private int action;
	private int direction;
	
	private boolean canUp;
	private boolean canLeft;
	private boolean canRight;
	private boolean canDown;
	
	private DirectionButton upButton;
	private DirectionButton leftButton;
	private DirectionButton rightButton;
	private DirectionButton downButton;
	private DirectionButton[] buttons;
	
	public DirectionPanel(){

		upButton = new DirectionButton(0);
		leftButton = new DirectionButton(1);
		rightButton = new DirectionButton(2);
		downButton = new DirectionButton(3);
		
		buttons = new DirectionButton[]{upButton, leftButton, rightButton, downButton};
		
		upButton.setLayoutX(DIRECTION_WIDTH+WIDTH_FIX);
		upButton.setLayoutY(0);
		leftButton.setLayoutX(0);
		leftButton.setLayoutY(0);
		rightButton.setLayoutX(DIRECTION_WIDTH+WIDTH_FIX);
		rightButton.setLayoutY(DIRECTION_HEIGHT+HEIGHT_FIX);
		downButton.setLayoutX(0);
		downButton.setLayoutY(DIRECTION_HEIGHT+HEIGHT_FIX);
		
		upButton.setOnMouseClicked(directionEvent);
		leftButton.setOnMouseClicked(directionEvent);
		rightButton.setOnMouseClicked(directionEvent);
		downButton.setOnMouseClicked(directionEvent);
		
		this.getChildren().add(upButton);
		this.getChildren().add(leftButton);
		this.getChildren().add(rightButton);
		this.getChildren().add(downButton);
	}
	

	public void setHighLight(int direction, boolean isHL){
		buttons[direction].setHighLight(isHL);
	}
	
	EventHandler<MouseEvent> directionEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  direction = btn.direction;
	    	  Operation op = new ActionOperation(action, direction);
	    	  OperationQueue.addOperation(op);
	      }
	};
	
	public void setAction(int action){
		this.action = action;
	}
}
