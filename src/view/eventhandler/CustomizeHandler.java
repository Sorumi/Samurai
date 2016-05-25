package view.eventhandler;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import musics.Musics;
import view.CustomizePanel;
import view.GamePanel;
import view.SamuraiView;
import view.StoryPanel;
import view.campsite.CampsitePanel;

public class CustomizeHandler {

	private CustomizePanel customizePanel;

	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;

	private final int chessBoardWidthOffset = 75;
	private final int chessBoardHeightOffset = 180;
	private final int blockWidthOffset = 35;
	private final int blockHeightOffset = 20;
	private final int selfWidthOffset = -30;
	private final int selfHeightOffset = -90;

	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;

	public CustomizeHandler(CustomizePanel customizePanel) {
		this.customizePanel = customizePanel;
	}

	public EventHandler<MouseEvent> startEvent = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			StoryPanel storyPanel = (StoryPanel) customizePanel.getParent();
			storyPanel.getChildren().remove(storyPanel.customizePanel);
			storyPanel.customizePanel = null;

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					storyPanel.gamePanel = new GamePanel(15, -1);
					storyPanel.getChildren().add(storyPanel.gamePanel);

					storyPanel.gamePanel.toFront();
				}
			});
		}

	};

	public EventHandler<MouseEvent> campsiteEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			customizePanel.setBlur(true);
			customizePanel.campsitePanel = new CampsitePanel();
			customizePanel.campsitePanel.setCustomized(customizePanel);
			customizePanel.getChildren().add(customizePanel.campsitePanel);
		}

	};

	public EventHandler<MouseEvent> samuraiOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Node) (t.getSource())).getTranslateX();
			orgTranslateY = ((Node) (t.getSource())).getTranslateY();
		}
	};

	public EventHandler<MouseEvent> samuraiOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Node) (t.getSource())).setTranslateX(newTranslateX);
			((Node) (t.getSource())).setTranslateY(newTranslateY);
		}
	};

	public EventHandler<MouseEvent> samuraiOnMouseReleasedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			SamuraiView samurai = (SamuraiView) (t.getSource());
			double layoutX = samurai.getLayoutX() + samurai.getTranslateX();
			double layoutY = samurai.getLayoutY() + samurai.getTranslateY();
			int positionX = -1;
			int positionY = -1;
			double minOffsetX = 1200;
			double minOffsetY = 800;

			for (int x = 0; x < 15; x++) {
				for (int y = 0; y < 15; y++) {
					int actualX = chessBoardWidthOffset + FIELD_WIDTH / 2 + (y - x) * blockWidthOffset
							+ selfWidthOffset;
					int actualY = chessBoardHeightOffset + (x + y) * blockHeightOffset + selfHeightOffset;
					double offsetX = Math.abs(layoutX - actualX);
					double offsetY = Math.abs(layoutY - actualY);
					if (offsetX <= 35 && offsetY <= 20 && offsetX < minOffsetX & offsetY < minOffsetY) {
						positionX = x;
						positionY = y;
						minOffsetX = layoutX - actualX;
						minOffsetY = layoutY - actualY;
					}
				}
			}
			if (positionX >= 0 && positionY >= 0) {
				double translateX = chessBoardWidthOffset + FIELD_WIDTH / 2 + (positionY - positionX) * blockWidthOffset
						+ selfWidthOffset - samurai.getLayoutX();
				double translateY = chessBoardHeightOffset + (positionX + positionY) * blockHeightOffset
						+ selfHeightOffset - samurai.getLayoutY();
				samurai.setTranslateX(translateX);
				samurai.setTranslateY(translateY);
				customizePanel.positions[samurai.getNumber()].setX(positionX);
				customizePanel.positions[samurai.getNumber()].setY(positionY);

			} else {
				samurai.setTranslateX(0);
				samurai.setTranslateY(0);
			}

		}
	};
}
