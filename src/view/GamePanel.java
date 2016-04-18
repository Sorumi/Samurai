package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.GameModel;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Position;
import model.po.SamuraiPO;
import view.background.BackgroundPanel;
import view.background.BackgroundPanel0;
import view.eventhandler.ActionHandler;


public class GamePanel extends Pane implements Observer{

    protected final int WINDOW_WIDTH = 1200;
	protected final int WINDOW_HEIGHT = 800;
	protected final int FIELD_WIDTH = 1050;
	protected final int FIELD_HEIGHT = 600;
	protected final int FIELD_FIX = 20;

	protected int size;
	protected int blockWidth;
	protected int blockHeight;

	public ChessBoardPanel chessBoard;
	//TODO
	protected int timeTotal = 30;
	protected int roundTotal = 12;

	protected SamuraiView currentSamurai; //0：无 1 2 3 4 5 6

	protected SamuraiView A1;
	protected SamuraiView A2;
	protected SamuraiView A3;
	protected SamuraiView B1;
	protected SamuraiView B2;
	protected SamuraiView B3;

	protected PlayerPanel currentPlayer;
	protected PlayerPanel playerA;
	protected PlayerPanel playerB;

	public Arrow arrow;
	public ActionPanel actionPanel;
	protected ActionHandler actionHandler;

	protected BackgroundPanel backgroundPanel;

	public GamePanel(int size){
		this.size = size;

		//bounds
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		//background
//		this.setStyle("-fx-background-image: url("+bgImagePath+");"
//				+ "-fx-background-size: 100% 100%; ");
		backgroundPanel = new BackgroundPanel0();
		this.getChildren().add(backgroundPanel);

		Button exitBtn = new Button("Exit");
		exitBtn.setLayoutX(1100);
		exitBtn.setLayoutY(100);
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		this.getChildren().add(exitBtn);
		
		//chessboard
		chessBoard = new ChessBoardPanel(size);
		this.getChildren().add(chessBoard);

		//player
		playerA = new PlayerPanel(0, timeTotal);
		playerB = new PlayerPanel(1, timeTotal);
		this.getChildren().add(playerA);
		this.getChildren().add(playerB);

		//arrow
		arrow = new Arrow();
		this.getChildren().add(arrow);

		//actionHandler
		actionHandler = new ActionHandler(this);
		this.setOnMouseClicked(actionHandler.actionPanelDisappearEvent);
		//actionpanel
		actionPanel = new ActionPanel(actionHandler);
		this.getChildren().add(actionPanel);

		//samurai
		A1 = new SamuraiView(1, size);
		A2 = new SamuraiView(2, size);
		A3 = new SamuraiView(3, size);
		B1 = new SamuraiView(4, size);
		B2 = new SamuraiView(5, size);
		B3 = new SamuraiView(6, size);
		this.getChildren().add(A1);
		this.getChildren().add(A2);
		this.getChildren().add(A3);
		this.getChildren().add(B1);
		this.getChildren().add(B2);
		this.getChildren().add(B3);

		//TODO
		A1.setActualLocation(0, 0);
	}

	public void setCurrentSamurai(int i){
		if(currentSamurai != null){
			currentSamurai.setOnMouseClicked(null);
		}
		switch (i){
			case 1:
				this.currentSamurai = A1;
				break;
			case 2:
				this.currentSamurai = A2;
				break;
			case 3:
				this.currentSamurai = A3;
				break;
			case 4:
				this.currentSamurai = B1;
				break;
			case 5:
				this.currentSamurai = B2;
				break;
			case 6:
				this.currentSamurai = B3;
				break;
		}
		currentSamurai.setOnMouseClicked(actionHandler.samuraiEvent);
		arrow.setCurrentSamurai(currentSamurai);
		actionPanel.setCurrentSamurai(currentSamurai);
		playerA.setCurrentSamurai(currentSamurai.getNum());
		playerB.setCurrentSamurai(currentSamurai.getNum());
	}

	public void setCurrentPlayer(int player){
		switch(player){
			case 0:
				this.currentPlayer = playerA;
				playerA.pointsPanel.setIsShow(true);
				playerB.pointsPanel.setIsShow(false);
				break;
			case 1:
				this.currentPlayer = playerB;
				playerA.pointsPanel.setIsShow(false);
				playerB.pointsPanel.setIsShow(true);
				break;
		}
	}

	public void setCurrentRound(int round){
		if(this.currentPlayer == playerA){
			playerA.circlePanel.setNewTime(true);
			playerB.circlePanel.setNewTime(false);
		}else{
			playerA.circlePanel.setNewTime(false);
			playerB.circlePanel.setNewTime(true);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();

		if(key.equals("samurai")){
			this.setCurrentSamurai((int)notifingObject.getValue());

		}else if(key.equals("player")){
			this.setCurrentPlayer((int)notifingObject.getValue());

		}else if(key.equals("round")){
			this.setCurrentRound((int)notifingObject.getValue());

		}else if(key.equals("time")){
			this.currentPlayer.circlePanel.setTimeRest((int) notifingObject.getValue());

		}else if(key.equals("actionPoint")){
			this.currentPlayer.pointsPanel.setPointsRest((int)notifingObject.getValue());

		}else if(key.equals("pointsTotal")){
			this.currentPlayer.pointsPanel.setPointsTotal((int)notifingObject.getValue());

		}else if(key.equals("samuraiMove")){
			Position position = (Position)notifingObject.getValue();
			this.currentSamurai.setActualLocation(position.getX(), position.getY());
			this.actionPanel.setActualLocation();
			this.arrow.setActualLocation();

		}else if(key.equals("samuraiHide")){
			this.currentSamurai.setHide((boolean)notifingObject.getValue());
			
		}else if(key.equals("samuraiOccupy")){

		}else if(key.equals("samuraiKilled")){

		}else if(key.equals("visible")) {
			if (this.currentPlayer.getPlayer() == 0) {
				this.A1.setVisible(true);
				this.A2.setVisible(true);
				this.A3.setVisible(true);
				this.B1.setVisible(false);
				this.B2.setVisible(false);
				this.B3.setVisible(false);
				for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()) {
					if (block.getX() == this.B1.x && block.getY() == this.B1.y) {
						if (!this.B1.isHide()) {
							this.B1.setVisible(true);
						}
					}
					if (block.getX() == this.B2.x && block.getY() == this.B2.y) {
						if (!this.B2.isHide()) {
							this.B2.setVisible(true);
						}
					}
					if (block.getX() == this.B3.x && block.getY() == this.B3.y) {
						if (!this.B3.isHide()) {
							this.B3.setVisible(true);
						}
					}
				}

			} else {
				this.B1.setVisible(true);
				this.B2.setVisible(true);
				this.B3.setVisible(true);
				this.A1.setVisible(false);
				this.A2.setVisible(false);
				this.A3.setVisible(false);
				for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()) {
					if (block.getX() == this.A1.x && block.getY() == this.A1.y) {
						if (!this.A1.isHide()) {
							this.A1.setVisible(true);
						}
					}
					if (block.getX() == this.A2.x && block.getY() == this.A2.y) {
						if (!this.A2.isHide()) {
							this.A2.setVisible(true);
						}
					}
					if (block.getX() == this.A3.x && block.getY() == this.A3.y) {
						if (!this.A3.isHide()) {
							this.A3.setVisible(true);
						}
					}
				}
			}

		}else if(key.equals("vision")){
			this.chessBoard.see((ArrayList<ActualBlock>)notifingObject.getValue());
			this.chessBoard.setTmpBlocks((ArrayList<ActualBlock>)notifingObject.getValue());
			
		}else if(key.equals("home")){
			SamuraiPO samuraiPO = (SamuraiPO)notifingObject.getValue();
			SamuraiView tmpView = null;
			switch (samuraiPO.getNumber()){
				case 1:
					tmpView = this.A1;
					break;
				case 2:
					tmpView = this.A2;
					break;
				case 3:
					tmpView = this.A3;
					break;
				case 4:
					tmpView = this.B1;
					break;
				case 5:
					tmpView = this.B2;
					break;
				case 6:
					tmpView = this.B3;
					break;
				default:
					break;
			}
			tmpView.setActualLocation(samuraiPO.getHome().getX(), samuraiPO.getHome().getY());
			chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();
		}
	}
	
}
