package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import controller.msgqueue.EndOperation;
import controller.msgqueue.OperationQueue;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Position;
import model.po.SamuraiPO;
import view.background.BackgroundPanel;
import view.background.BackgroundPanel0;
import view.background.BackgroundPanel1;
import view.background.BackgroundPanel2;
import view.background.BackgroundPanel3;
import view.background.BackgroundPanel4;
import view.background.BackgroundPanel5;
import view.eventhandler.ActionHandler;
import view.eventhandler.StateHandler;

public class GamePanel extends Pane implements Observer{

	protected final int WINDOW_WIDTH = 1200;
	protected final int WINDOW_HEIGHT = 800;
	protected final int FIELD_WIDTH = 1050;
	protected final int FIELD_HEIGHT = 600;

	protected int level;
	protected int size;
	protected int blockWidth;
	protected int blockHeight;

	protected SystemButton closeBtn;
	protected BackgroundPanel backgroundPanel;
	public ChessBoardPanel chessBoard;

	//TODO
	protected int timeTotal = 30;
	protected int roundTotal = 24;

	protected SamuraiPanel currentSamurai; //0：无 1 2 3 4 5 6

	protected SamuraiPanel A1;
	protected SamuraiPanel A2;
	protected SamuraiPanel A3;
	protected SamuraiPanel B1;
	protected SamuraiPanel B2;
	protected SamuraiPanel B3;

	private int[] samuraiProperties_1;
	private int[] samuraiProperties_2;
	private int[] samuraiProperties_3;
	private int[] samuraiProperties_4;
	private int[] samuraiProperties_5;
	private int[] samuraiProperties_6;

	protected PlayerPanel currentPlayer;
	protected PlayerPanel playerA;
	protected PlayerPanel playerB;
	
	private ImageView bg;

	protected RoundPanel roundPanel;
	
	protected ResultPanel resultPanel;
	
	private ImageView bgImage;

	public Arrow arrow;
	public ActionPanel actionPanel;
	protected ActionHandler actionHandler;
	public StatePanel statePanel;
	protected StateHandler stateHandler;
	protected ObservableList<OrderPanel>  orderList;

	/*
	 * level:
	 * 0: 双人
	 * 99:经典
	 * 11-53:故事
	 */
	public GamePanel(int size, int level){
		this.size = size;
		this.level = level; 
		this.setBackground(level);
	
		//bounds
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		//systembutton
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				switch(level){
				case 0:
				case 99:
					OperationQueue.addOperation(new EndOperation());
					Pane basePanel = (Pane) GamePanel.this.getParent();
					basePanel.getChildren().remove(GamePanel.this);
					break;
				default:
					//TODO
					StoryPanel storyPanel = (StoryPanel) GamePanel.this.getParent();
					storyPanel.mapPanel.toFront();
					storyPanel.gamePanel.getChildren().remove(GamePanel.this);
					storyPanel.gamePanel = null;

					OperationQueue.addOperation(new EndOperation());
				}

			}
		});
		OrderPanel systemPanel = new OrderPanel();
		systemPanel.getChildren().add(closeBtn);
		this.getChildren().add(systemPanel);

		//chessboard
		chessBoard = new ChessBoardPanel(size);
		this.getChildren().add(chessBoard);

		//round
		roundPanel = new RoundPanel(roundTotal);
		this.getChildren().add(roundPanel);

		//player
		playerA = new PlayerPanel(0, timeTotal);
		playerB = new PlayerPanel(1, timeTotal);
		this.getChildren().addAll(playerA, playerB);

		//arrow
		arrow = new Arrow();
		this.getChildren().add(arrow);

		//actionHandler
		actionHandler = new ActionHandler(this);
		this.setOnMouseClicked(actionHandler.actionPanelDisappearEvent);

		//actionpanel
		actionPanel = new ActionPanel(actionHandler);
		actionPanel.setSize(this.size);
		this.getChildren().add(actionPanel);

		//resultpanel
		resultPanel = new ResultPanel(this);
		this.getChildren().add(resultPanel);

		//samurai
		A1 = new SamuraiPanel(1, size);
		A2 = new SamuraiPanel(2, size);
		A3 = new SamuraiPanel(3, size);
		B1 = new SamuraiPanel(4, size);
		B2 = new SamuraiPanel(5, size);
		B3 = new SamuraiPanel(6, size);
		this.getChildren().addAll(A1, A2, A3, B1, B2, B3);

		if(level < 99 && level > 0) {
			//stateHandler
			stateHandler = new StateHandler(this);
			//statepanel
			statePanel = new StatePanel(stateHandler,1);
			this.getChildren().add(statePanel);
			statePanel.setZOrder(-1);

			A1.setOnMouseEntered(stateHandler.showStatePanelInG);
			A1.setOnMouseExited(stateHandler.closeStatePanelInG);
			A2.setOnMouseEntered(stateHandler.showStatePanelInG);
			A2.setOnMouseExited(stateHandler.closeStatePanelInG);
			A3.setOnMouseEntered(stateHandler.showStatePanelInG);
			A3.setOnMouseExited(stateHandler.closeStatePanelInG);
			B1.setOnMouseEntered(stateHandler.showStatePanelInG);
			B1.setOnMouseExited(stateHandler.closeStatePanelInG);
			B2.setOnMouseEntered(stateHandler.showStatePanelInG);
			B2.setOnMouseExited(stateHandler.closeStatePanelInG);
			B3.setOnMouseEntered(stateHandler.showStatePanelInG);
			B3.setOnMouseExited(stateHandler.closeStatePanelInG); 

		}

		//resultpanel
		resultPanel = new ResultPanel(this);
		this.getChildren().add(resultPanel);

		//add
		backgroundPanel.setZOrder(-2);
		systemPanel.setZOrder(1000);
		chessBoard.setZOrder(-3);
		arrow.setZOrder(-1);
		actionPanel.setZOrder(-1);
		playerA.setZOrder(999);
		playerB.setZOrder(999);
		roundPanel.setZOrder(999);
		resultPanel.setZOrder(999);

		if(level < 99 && level > 0) {
			orderList = FXCollections.observableArrayList(backgroundPanel, chessBoard, A1, A2, A3, B1, B2, B3, arrow, actionPanel, statePanel, playerA, playerB, roundPanel, systemPanel, resultPanel);
		}else{
			orderList = FXCollections.observableArrayList(backgroundPanel, chessBoard, A1, A2, A3, B1, B2, B3, arrow, actionPanel, playerA, playerB, roundPanel, systemPanel, resultPanel);
		}

	}

	public void set6Properties(int samurai, int[] properties){
		switch (samurai) {
			case 1:
				this.samuraiProperties_1 = properties;
				break;
			case 2:
				this.samuraiProperties_2 = properties;
				break;
			case 3:
				this.samuraiProperties_3 = properties;
				break;
		}
	}

	public int[] get6Properties(int samurai){
		switch (samurai) {
			case 1:
				return this.samuraiProperties_1;
			case 2:
				return this.samuraiProperties_2;
			case 3:
				return this.samuraiProperties_3;
			default:
				return new int[]{0};
		}
	}

	public void setSamuraiWeapon(int samurai, int weapon){
		switch (samurai) {
			case 1:
				this.A1.samuraiV.setWeapon(weapon);
				break;
			case 2:
				this.A2.samuraiV.setWeapon(weapon);
				break;
			case 3:
				this.A3.samuraiV.setWeapon(weapon);
				break;
		}
	}
	
	public void setBackground(int level){		
	    this.setStyle("-fx-background-image: url("+Images.BG[level/10]+") ;"
	    		+ "-fx-background-size: 100% 100%; ");
		switch(level/10){
		case 0: backgroundPanel = new BackgroundPanel0();break;
		case 1: backgroundPanel = new BackgroundPanel1();break;
		case 2: backgroundPanel = new BackgroundPanel2();break;
		case 3: backgroundPanel = new BackgroundPanel3();break;
		case 4: backgroundPanel = new BackgroundPanel4();break;
		case 5: backgroundPanel = new BackgroundPanel5();break;
		default: backgroundPanel = new BackgroundPanel0();
		}
		this.getChildren().add(backgroundPanel);
	}

	public void setOrder(){
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Collections.sort(orderList);
				GamePanel.this.getChildren().setAll(orderList);
			}
		});
	}

	private SamuraiPanel getSamurai(int num){
		SamuraiPanel tmpSamurai = null;
		switch (num){
		case 1:
			tmpSamurai = A1;
			break;
		case 2:
			tmpSamurai = A2;
			break;
		case 3:
			tmpSamurai = A3;
			break;
		case 4:
			tmpSamurai = B1;
			break;
		case 5:
			tmpSamurai = B2;
			break;
		case 6:
			tmpSamurai = B3;
			break;
		}
		return tmpSamurai;
	}
	
	public void setCurrentSamurai(int num){
		if(currentSamurai != null){
			currentSamurai.setOnMouseClicked(null);
			currentSamurai.samuraiV.setRandomAnimation(true);
		}
		
		this.currentSamurai = getSamurai(num);

		currentSamurai.setCanActionProperty(true);
		currentSamurai.setOnMouseClicked(actionHandler.samuraiEvent);
		currentSamurai.samuraiV.setRandomAnimation(false);
		
		roundPanel.setCurrentSamurai(currentSamurai.getNum());
		playerA.pointsPanel.setCurrentSamurai(currentSamurai.getNum());
        actionPanel.setCurrentSamurai(currentSamurai);
		if(currentPlayer == playerA) {
            arrow.setCurrentSamurai(currentSamurai);
		}
		//add
		currentSamurai.canActionProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue o,Object oldVal,Object newVal){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						boolean canAction= (boolean) newVal;
						if (canAction) {
							if(currentPlayer == playerA) {
								arrow.setActualLocation();
								arrow.setVisible(true);
								if(level < 99 && level > 0) {
									currentSamurai.setOnMouseEntered(stateHandler.showStatePanelInG);
								}
							}
						} else {
							arrow.setVisible(false);
							currentSamurai.setOnMouseEntered(null);
						}
					}
				});
			}
		});
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
				break;
		}
	}

	public void setCurrentRound(int round){
		roundPanel.setRoundCurrent(round);
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
			this.setCurrentSamurai((int) notifingObject.getValue());
		}else if(key.equals("player")){
			this.setCurrentPlayer((int) notifingObject.getValue());
		}else if(key.equals("round")){
			this.setCurrentRound((int)notifingObject.getValue());
		}else if(key.equals("time")){
			this.currentPlayer.circlePanel.setTimeRest((int) notifingObject.getValue());
		}else if(key.equals("state")){

		}else if(key.equals("actionPoint")){
			this.currentPlayer.pointsPanel.setPointsRest((int)notifingObject.getValue());
			this.actionPanel.setPointsRest((int)notifingObject.getValue());
		}else if(key.equals("pointsTotal")){
			this.currentPlayer.pointsPanel.setPointsTotal((int)notifingObject.getValue());
		}else if(key.equals("samuraiMove")){
			Position position = (Position)notifingObject.getValue();
			this.currentSamurai.move(position.getX(), position.getY());

			if (this.currentPlayer.getPlayer() == 0) {
				this.actionPanel.reset();
				this.setOrder();
			}
		}else if(key.equals("samuraiHide")){
			this.currentSamurai.setHide((boolean)notifingObject.getValue());
		}else if(key.equals("samuraiOccupy")){
			this.currentSamurai.occupy((int)notifingObject.getValue());
			if (this.currentPlayer.getPlayer() == 0) {
				this.actionPanel.reset();
				this.arrow.setVisible(true);
			}
		}else if(key.equals("samuraiKilled")){
			getSamurai((int)notifingObject.getValue()).setInjured(true);
			
		}else if(key.equals("visible")) {
            System.out.println("visible");
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
		}else if(key.equals("vision")){
			System.out.println("vision");
			this.chessBoard.see((ArrayList<ActualBlock>) notifingObject.getValue());
			this.chessBoard.setTmpBlocks((ArrayList<ActualBlock>) notifingObject.getValue());
		}else if(key.equals("home")){
			SamuraiPO samuraiPO = (SamuraiPO)notifingObject.getValue();
			SamuraiPanel tmpView = null;
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
			this.chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();
		}else if(key.equals("occupiedBlocks")){
			int[] n = (int [])notifingObject.getValue();
			this.playerA.circlePanel.setBlocks(new int[]{n[1], n[2], n[3]});
			this.playerB.circlePanel.setBlocks(new int[]{n[4], n[5], n[6]});
		}else if(key.equals("revive")){
            System.out.println("Samurai revive!" + (int)notifingObject.getValue());
            getSamurai((int)notifingObject.getValue()).setInjured(false);
        }else if(key.equals("pseudoOccupy")){
			this.chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), true);
		}else if(key.equals("a-pseudoOccupy")){
			this.chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), false);
		}else if(key.equals("over")){
			this.resultPanel.setResults((int [])notifingObject.getValue());
		}
	}

}
