package view.guide;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import view.ActionPanel;
import view.eventhandler.ActionHandler;

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
	
	public ActionPanel actionPanel;
	private ActionHandler actionHandler;
	
	public GameGuidePanel(int size) {
		this.size = size;
		this.feildWidth = BLOCK_WIDTH * size;
		this.feildHeight = BLOCK_HEIGHT * size;

		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		chessBoard = new ChessBoardGuidePanel(size);
		this.getChildren().add(chessBoard);

		// samurai
		samurai = new SamuraiGuidePanel(1, size);
		this.getChildren().add(samurai);
		
		//TODO
		samurai.setActualLocation(3, 3);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
