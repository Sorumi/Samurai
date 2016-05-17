package view.guide;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.po.Position;
import view.eventhandler.ActionGuideHandler;

public class ActionGuidePanel extends Pane{

	private final int BUTTONPANEL_WIDTH = 208;
	private final int BUTTONPANEL_HEIGHT = 300;
	private final int BUTTON_WIDTH = 58;
	private final int BUTTON_Y = 120;
	private final int SAMURAI_WIDTH = 60;

	private boolean isAppear;

	private int size;

	private ActionGuideButton moveButton;
	private ActionGuideButton occupyButton;
	private ActionGuideButton hideButton;

	private ActionGuideButton backButton;
	private DirectionGuidePanel directionPanel;

	private SamuraiGuidePanel currentSamurai;


	public ActionGuidePanel(ActionGuideHandler actionHandler) {


		occupyButton = new ActionGuideButton(0, actionHandler);
		moveButton = new ActionGuideButton(1, actionHandler);
		hideButton = new ActionGuideButton(2, actionHandler);
		
		backButton = new ActionGuideButton(4, actionHandler);

		this.setPrefWidth(BUTTONPANEL_WIDTH);
		this.setPrefHeight(BUTTONPANEL_HEIGHT);
		this.setVisible(false);
		this.isAppear = false;
		// this.setStyle("-fx-background-color: #DDDDDD");

		backButton.setVisible(false);

		directionPanel = new DirectionGuidePanel(actionHandler);
		directionPanel.setLayoutX((BUTTONPANEL_WIDTH - directionPanel.getBoundsInParent().getWidth()) / 2);
		directionPanel.setLayoutY(143);
		directionPanel.setVisible(false);

		this.getChildren().addAll(moveButton, occupyButton, hideButton, backButton, directionPanel);

	}

	public void setCurrentSamurai(SamuraiGuidePanel samurai) {
		this.currentSamurai = samurai;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setActualLocation() {
		this.setLayoutX(currentSamurai.getLayoutX() + SAMURAI_WIDTH / 2 - BUTTONPANEL_WIDTH / 2);
		this.setLayoutY(currentSamurai.getLayoutY() - 70);
	}

	public void setSecondary(boolean[] directions) {
		backButton.setVisible(true);

		moveButton.setVisible(false);
		occupyButton.setVisible(false);
		hideButton.setVisible(false);
		directionPanel.setVisible(true);

		// 决定显示哪些箭头
		Position position = this.currentSamurai.getPos();
		if (position.getX() == 0) {
			directions[0] = false;
		}
		if (position.getY() == 0) {
			directions[1] = false;
		}
		if (position.getX() == this.size - 1) {
			directions[3] = false;
		}
		if (position.getY() == this.size - 1) {
			directions[2] = false;
		}
		directionPanel.setVisible(directions);

	}

	public void closeSecondary() {
		backButton.setVisible(false);

		moveButton.setVisible(true);
		occupyButton.setVisible(true);
		hideButton.setVisible(true);
		directionPanel.setVisible(false);
	}

	public void setAppear(boolean isAppear, boolean animation) {
		if (isAppear == this.isAppear) {
			return;
		}
		this.setActualLocation();
		if (animation) {
			setAppearAnimation(isAppear);
		} else {
			this.setVisible(isAppear);
		}
		this.isAppear = isAppear;
	}

	public boolean isAppear() {
		return isAppear;
	}

	public void setAppearAnimation(boolean isAppear) {

		if (isAppear == this.isAppear) {
			return;
		}
		if (isAppear) {
			this.setVisible(isAppear);
			TranslateTransition tt1 = new TranslateTransition(Duration.millis(500), occupyButton);
			tt1.setFromX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt1.setFromY(BUTTON_Y);
			tt1.setToX(0);
			tt1.setToY(60);
			tt1.setInterpolator(Interpolator.EASE_BOTH);
			tt1.play();

			TranslateTransition tt2 = new TranslateTransition(Duration.millis(500), moveButton);
			tt2.setFromX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt2.setFromY(BUTTON_Y);
			tt2.setToX(40);
			tt2.setToY(0);
			tt2.play();

			TranslateTransition tt3 = new TranslateTransition(Duration.millis(500), hideButton);
			tt3.setFromX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt3.setFromY(BUTTON_Y);
			tt3.setToX(110);
			tt3.setToY(0);
			tt3.play();

//			TranslateTransition tt4 = new TranslateTransition(Duration.millis(500), exitButton);
//			tt4.setFromX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
//			tt4.setFromY(BUTTON_Y);
//			tt4.setToX(150);
//			tt4.setToY(60);
//			tt4.play();

			TranslateTransition tt5 = new TranslateTransition(Duration.millis(500), backButton);
			tt5.setFromX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt5.setFromY(BUTTON_Y);
			tt5.setToX(150);
			tt5.setToY(60);
			tt5.play();

		} else {
			TranslateTransition tt1 = new TranslateTransition(Duration.millis(500), occupyButton);
			tt1.setFromX(0);
			tt1.setFromY(60);
			tt1.setToX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt1.setToY(BUTTON_Y);
			tt1.play();

			TranslateTransition tt2 = new TranslateTransition(Duration.millis(500), moveButton);
			tt2.setFromX(40);
			tt2.setFromY(0);
			tt2.setToX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt2.setToY(BUTTON_Y);
			tt2.play();

			TranslateTransition tt3 = new TranslateTransition(Duration.millis(500), hideButton);
			tt3.setFromX(110);
			tt3.setFromY(0);
			tt3.setToX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt3.setToY(BUTTON_Y);
			tt3.play();

//			TranslateTransition tt4 = new TranslateTransition(Duration.millis(500), exitButton);
//			tt4.setFromX(150);
//			tt4.setFromY(60);
//			tt4.setToX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
//			tt4.setToY(BUTTON_Y);
//			tt4.play();

			TranslateTransition tt5 = new TranslateTransition(Duration.millis(500), backButton);
			tt5.setFromX(150);
			tt5.setFromY(60);
			tt5.setToX((BUTTONPANEL_WIDTH - BUTTON_WIDTH) / 2);
			tt5.setToY(BUTTON_Y);
			tt5.play();

			tt5.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					ActionGuidePanel.this.setVisible(isAppear);
				}
			});
		}
	}

}
