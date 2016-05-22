package view.guide;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.Images;
import view.eventhandler.ActionGuideHandler;

public class ActionGuideButton extends Pane {

	private ImageView imageFront;
	public int action;
	private ActionGuideHandler actionHandler;

	public ActionGuideButton(int action, ActionGuideHandler actionHandler) {
		this.actionHandler = actionHandler;

		this.action = action;
		this.imageFront = new ImageView(Images.ACTION_BUTTON[action]);
		this.imageFront.setFitWidth(58);
		this.imageFront.setPreserveRatio(true);
		this.getChildren().add(imageFront);

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
		case 4:
			this.setOnMouseClicked(actionHandler.backEvent);
			break;
		}

	}

	public void setTrue() {
		imageFront.setEffect(null);
		this.setHandler();
	}

	public void setFalse() {
		this.setOnMouseClicked(null);
		ColorAdjust grayColor = new ColorAdjust();
		grayColor.setSaturation(-0.9);

		imageFront.setEffect(grayColor);
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
			case 4:
				this.setOnMouseClicked(actionHandler.backEvent);
				break;
		}
	}
}