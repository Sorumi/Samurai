package view.guide;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import view.ActionPanel;
import view.eventhandler.ActionGuideHandler;

public class GameGuidePanel extends Pane implements Observer {
	private final int WINDOW_WIDTH = 1100;
	private final int WINDOW_HEIGHT = 700;
	private final int BLOCK_WIDTH = 70;
	private final int BLOCK_HEIGHT = 40;

	private int size;
	private int feildWidth;
	private int feildHeight;

	private ChessBoardGuidePanel chessBoard;
	private SamuraiGuidePanel samurai;
	
	public ActionGuidePanel actionPanel;
	private ActionGuideHandler actionHandler;
	
	public GameGuidePanel(int size) {
		this.size = size;
		this.feildWidth = BLOCK_WIDTH * size;
		this.feildHeight = BLOCK_HEIGHT * size;

		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		chessBoard = new ChessBoardGuidePanel(size);
		this.getChildren().add(chessBoard);
		
		//actionHandler
		actionHandler = new ActionGuideHandler(this);
		this.setOnMouseClicked(actionHandler.actionPanelDisappearEvent);

		//actionpanel
		actionPanel = new ActionGuidePanel(actionHandler);
		actionPanel.setSize(this.size);
		this.getChildren().add(actionPanel);
		
		
		// samurai
		samurai = new SamuraiGuidePanel(1, size);
		samurai.samuraiV.setRandomAnimation(false);
		samurai.setOnMouseClicked(actionHandler.samuraiEvent);
		this.getChildren().add(samurai);
		
		actionPanel.setCurrentSamurai(samurai);
		
		
		//TODO
		samurai.setActualLocation(3, 3);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
