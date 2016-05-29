package view.eventhandler;

import controller.msgqueue.*;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.ActionButton;
import view.DirectionButton;
import view.GamePanel;
import view.SamuraiPanel;
import view.StartLogoPanel;

public class ActionHandler {

	private GamePanel gamePanel;
	private int action;
	private int direction;

	// add
	// private boolean isAction;
	// private boolean isDirection;

	public ActionHandler(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		// isAction = false;
		// isDirection = false;
	}

	// public EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {
	//
	// @Override
	// public void handle(KeyEvent event) {
	// // TODO Auto-generated method stub
	// switch (event.getCode()) {
	// case SPACE:
	// SamuraiPanel currentSamurai = gamePanel.currentSamurai;
	// if (currentSamurai.canActionProperty().get()) {
	// if (!isAction) {
	// gamePanel.actionPanel.setAppear(true, true);
	// gamePanel.arrow.setAppear(false);
	// gamePanel.setOrder();
	// isAction = true;
	// } else {
	// gamePanel.actionPanel.setAppear(false, true);
	// gamePanel.arrow.setAppear(true);
	// gamePanel.setOrder();
	// }
	// }
	// break;
	// case O:
	// if (isAction) {
	// action = 0;
	// gamePanel.actionPanel.setSecondary(new boolean[] { true, true, true, true
	// });// TODO
	// }
	// break;
	// case M:
	// if (isAction) {
	// action = 1;
	// gamePanel.actionPanel.setSecondary(new boolean[] { true, true, true, true
	// });// TODO
	// }
	// break;
	// case H:
	// if (isAction) {
	// Operation op = new ActionOperation(2, 0);
	// OperationQueue.addOperation(op);
	// }
	// break;
	// case X:
	// if (isAction) {
	// gamePanel.actionPanel.closeSecondary();
	// Operation op1 = new SkipOperation();
	// OperationQueue.addOperation(op1);
	// }
	// break;
	// case B:
	// if(isAction){
	// gamePanel.actionPanel.closeSecondary();
	// }
	// break;
	// case UP:
	// if(isDirection){
	// Operation op = new ActionOperation(action, 0);
	// OperationQueue.addOperation(op);
	// }
	// break;
	// case LEFT:
	// if(isDirection){
	// Operation op = new ActionOperation(action, 1);
	// OperationQueue.addOperation(op);
	// }
	// break;
	// case RIGHT:
	// if(isDirection){
	// Operation op = new ActionOperation(action, 2);
	// OperationQueue.addOperation(op);
	// }
	// break;
	// case DOWN:
	// if(isDirection){
	// Operation op = new ActionOperation(action, 3);
	// OperationQueue.addOperation(op);
	// }
	// break;
	// }
	//
	// }
	//
	// };

	public EventHandler<MouseEvent> overlayEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			Timeline tl = new Timeline(new KeyFrame(Duration.millis(2000),
					new KeyValue(gamePanel.overlayPanel.opacityProperty(), 0, Interpolator.EASE_IN)));
			gamePanel.overlayPanel.setOnMouseClicked(null);

			tl.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					gamePanel.orderList.remove(gamePanel.overlayPanel);
					gamePanel.setOrder();

					OperationQueue.addOperation(new ContinueOperation());
				}

			});
			tl.play();
		}
	};

	public EventHandler<MouseEvent> samuraiActionClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			if (gamePanel.currentSamurai.canActionProperty().get() && event.getButton() == MouseButton.PRIMARY) {
				gamePanel.actionPanel.setAppear(true, true);
				gamePanel.arrow.setAppear(false);
				gamePanel.setOrder();
			}
		}
	};

	public EventHandler<MouseEvent> samuraiActionEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			gamePanel.currentSamurai.setHighlight();
		}
	};
	
	public EventHandler<MouseEvent> samuraiActionExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			gamePanel.currentSamurai.setNormal();
		}
	};

	public EventHandler<MouseEvent> samuraiClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			SamuraiPanel currentSamurai = (SamuraiPanel) event.getSource();
			if (currentSamurai.canActionProperty().get() && event.getButton() == MouseButton.PRIMARY) {
				gamePanel.actionPanel.setAppear(true, true);
				gamePanel.arrow.setAppear(false);
				gamePanel.setOrder();
			}
		}
	};

	public EventHandler<MouseEvent> samuraiEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			SamuraiPanel samurai = (SamuraiPanel) event.getSource();
			samurai.setHighlight();
		}
	};

	public EventHandler<MouseEvent> samuraiExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			SamuraiPanel samurai = (SamuraiPanel) event.getSource();
			samurai.setNormal();
		}
	};

	public EventHandler<MouseEvent> actionPanelDisappearEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			if (event.getButton() == MouseButton.SECONDARY) {
				gamePanel.actionPanel.setAppear(false, true);
				gamePanel.arrow.setAppear(true);
				gamePanel.setOrder();
			}
		}
	};

	public EventHandler<MouseEvent> secondaryEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			ActionButton btn = (ActionButton) event.getSource();
			action = btn.action;
			// 分move occupy两种情况
			gamePanel.actionPanel.setSecondary(new boolean[] { true, true, true, true });// TODO
		}
	};

	public EventHandler<MouseEvent> hideEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			ActionButton btn = (ActionButton) event.getSource();
//			action = btn.action;
			Operation op = new ActionOperation(2, 0);
			OperationQueue.addOperation(op);
		}
	};

	public EventHandler<MouseEvent> backEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			ActionButton btn = (ActionButton) event.getSource();
			action = btn.action;
			gamePanel.actionPanel.closeSecondary();
		}
	};

	public EventHandler<MouseEvent> exitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			ActionButton btn = (ActionButton) event.getSource();
			action = btn.action;
			gamePanel.actionPanel.closeSecondary();
			Operation op = new SkipOperation();
			OperationQueue.addOperation(op);
		}
	};

	public EventHandler<MouseEvent> directionEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			DirectionButton btn = (DirectionButton) event.getSource();
			direction = btn.direction;
			Operation op = new ActionOperation(action, direction);
			OperationQueue.addOperation(op);
		}
	};

	public EventHandler<MouseEvent> directionEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			DirectionButton btn = (DirectionButton) event.getSource();
			btn.setHighLight(true);

			if (action == 0) {
				direction = btn.direction;
				Operation op = new PseudoOccupyOperation(true, direction);
				OperationQueue.addOperation(op);
			}

		}
	};

	public EventHandler<MouseEvent> directionExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			DirectionButton btn = (DirectionButton) event.getSource();
			btn.setHighLight(false);

			if (action == 0) {
				direction = btn.direction;
				Operation op = new PseudoOccupyOperation(false, direction);
				OperationQueue.addOperation(op);
			}

		}
	};

}
