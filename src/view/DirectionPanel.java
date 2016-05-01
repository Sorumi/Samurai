package view;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.eventhandler.ActionHandler;

public class DirectionPanel extends Pane {
	
	private final int DIRECTION_WIDTH = 49;
	private final int DIRECTION_HEIGHT = 35;
	private final int WIDTH_FIX = 24;
	private final int HEIGHT_FIX = 12;

	private boolean canUp;
	private boolean canLeft;
	private boolean canRight;
	private boolean canDown;
	
	private DirectionButton upButton;
	private DirectionButton leftButton;
	private DirectionButton rightButton;
	private DirectionButton downButton;
	private DirectionButton[] buttons;
	
	private ActionHandler actionHandler;
	
	public DirectionPanel(ActionHandler actionHandler){
		this.actionHandler = actionHandler;

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
		
		upButton.setOnMouseClicked(actionHandler.directionEvent);
		leftButton.setOnMouseClicked(actionHandler.directionEvent);
		rightButton.setOnMouseClicked(actionHandler.directionEvent);
		downButton.setOnMouseClicked(actionHandler.directionEvent);
		
		upButton.setOnMouseEntered(actionHandler.directionEnterEvent);
		leftButton.setOnMouseEntered(actionHandler.directionEnterEvent);
		rightButton.setOnMouseEntered(actionHandler.directionEnterEvent);
		downButton.setOnMouseEntered(actionHandler.directionEnterEvent);
		
		upButton.setOnMouseExited(actionHandler.directionExitEvent);
		leftButton.setOnMouseExited(actionHandler.directionExitEvent);
		rightButton.setOnMouseExited(actionHandler.directionExitEvent);
		downButton.setOnMouseExited(actionHandler.directionExitEvent);
		
		this.getChildren().addAll(upButton, leftButton, rightButton, downButton);
	}

	public void setHighLight(int direction, boolean isHL){
		buttons[direction].setHighLight(isHL);
	}

	public void setVisible(boolean[] directions) {
		upButton.setVisible(directions[0]);
		leftButton.setVisible(directions[1]);
		rightButton.setVisible(directions[2]);
		downButton.setVisible(directions[3]);
	}

}
