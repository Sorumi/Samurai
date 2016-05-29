package view;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.eventhandler.ActionHandler;

public class ActionButton extends Pane {

	private ImageView imageFront;
	public int pointsCost;
	public int action;
	private ActionHandler actionHandler;

	public ActionButton(int action, ActionHandler actionHandler) {
		this.actionHandler = actionHandler;

		System.out.println(action);
		this.action = action;
		this.imageFront = new ImageView(Images.ACTION_BUTTON[action]);
		this.imageFront.setFitWidth(58);
		this.imageFront.setPreserveRatio(true);
		this.getChildren().add(imageFront);

		switch (action) {
		case 0:
			pointsCost = 4;
			this.setOnMouseClicked(actionHandler.secondaryEvent);
			break;
		case 1:
			pointsCost = 2;
			this.setOnMouseClicked(actionHandler.secondaryEvent);
			break;
		case 2:
			pointsCost = 1;
			this.setOnMouseClicked(actionHandler.hideEvent);
			break;
		case 3:
			pointsCost = 0;
			setOnMouseClicked(actionHandler.exitEvent);
			break;
		case 4:
			this.setOnMouseClicked(actionHandler.backEvent);
			break;
		case 5://hide3
			pointsCost = 3;
			this.setOnMouseClicked(actionHandler.hideEvent);
			break;
		}

//		this.canAction = true;
	}

	private void setHandler() {
		switch (action) {
		case 0:
			this.setOnMouseClicked(actionHandler.secondaryEvent);
			break;
		case 1:
			this.setOnMouseClicked(actionHandler.secondaryEvent);
			break;
		case 2:
			this.setOnMouseClicked(actionHandler.hideEvent);
			break;
		case 3:
			this.setOnMouseClicked(actionHandler.exitEvent);
			break;
		case 4:
			this.setOnMouseClicked(actionHandler.backEvent);
			break;
		case 5:
			this.setOnMouseClicked(actionHandler.hideEvent);
			break;

		}
	}

	public void setFalse() {
		// TODO Auto-generated method stub
		this.setOnMouseClicked(null);
		ColorAdjust grayColor = new ColorAdjust();
		grayColor.setSaturation(-0.9);

		imageFront.setEffect(grayColor);
//		this.canAction = false;
	}

	public void setTrue() {
		imageFront.setEffect(null);
		this.setHandler();
//		this.canAction = true;
	}
}
