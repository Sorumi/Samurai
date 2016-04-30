package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Position;
import model.po.SamuraiPO;
import view.background.BackgroundPanel;
import view.background.BackgroundPanel0;
import view.background.BackgroundPanel3;
import view.eventhandler.ActionHandler;
import view.eventhandler.StateHandler;
import view.StatePanel; 

public class GamePanel extends Pane implements Observer{

    protected final int WINDOW_WIDTH = 1200;
	protected final int WINDOW_HEIGHT = 800;
	protected final int FIELD_WIDTH = 1050;
	protected final int FIELD_HEIGHT = 600;
//	protected final int FIELD_FIX = 20;

	protected int level;
	protected int size;
	protected int blockWidth;
	protected int blockHeight;

	protected SystemButtonPanel systemButtonPanel;
	protected BackgroundPanel backgroundPanel;
	public ChessBoardPanel chessBoard;
	
	//TODO
	protected int timeTotal = 30;
	protected int roundTotal = 12;

	protected SamuraiPanel currentSamurai; //0：无 1 2 3 4 5 6

	protected SamuraiPanel A1;
	protected SamuraiPanel A2;
	protected SamuraiPanel A3;
	protected SamuraiPanel B1;
	protected SamuraiPanel B2;
	protected SamuraiPanel B3;

	protected PlayerPanel currentPlayer;
	protected PlayerPanel playerA;
	protected PlayerPanel playerB;
	
	protected RoundPanel roundPanel;

	public Arrow arrow;
	public ActionPanel actionPanel;
	protected ActionHandler actionHandler;
	public StatePanel statePanel; 
	protected StateHandler stateHandler; 
	protected  ObservableList<OrderPanel>  orderList;

	/*
	 * level:
	 * 0: 经典模式
	 * 1-9：剧情模式的level
	 * 10：双人模式
	 * 99：测试模式： 红蓝双方都可见
	 */
	public GamePanel(int size, int level){
		this.size = size;
		this.level = level;

		//bounds
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		//background

		backgroundPanel = new BackgroundPanel0();
//		backgroundPanel = new BackgroundPanel3();
		this.getChildren().add(backgroundPanel);
				

		//systembutton
		systemButtonPanel = new SystemButtonPanel();
		this.getChildren().add(systemButtonPanel);
		
		//chessboard
		chessBoard = new ChessBoardPanel(size);
		this.getChildren().add(chessBoard);

		//round
		roundPanel = new RoundPanel(roundTotal);
		this.getChildren().add(roundPanel);
		
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
		actionPanel.setSize(this.size);
		this.getChildren().add(actionPanel);
		//stateHandler
		stateHandler = new StateHandler(this);
		//statepanel 
		statePanel = new StatePanel(stateHandler);
		this.getChildren().add(statePanel);

		//samurai
		A1 = new SamuraiPanel(1, size);
		A2 = new SamuraiPanel(2, size);
		A3 = new SamuraiPanel(3, size);
		B1 = new SamuraiPanel(4, size);
		B2 = new SamuraiPanel(5, size);
		B3 = new SamuraiPanel(6, size);
		this.getChildren().add(A1);
		this.getChildren().add(A2);
		this.getChildren().add(A3);
		this.getChildren().add(B1);
		this.getChildren().add(B2);
		this.getChildren().add(B3);
		
		A1.setOnMouseEntered(stateHandler.showStatePanel);
		A1.setOnMouseExited(stateHandler.closeStatePanel);
		A2.setOnMouseEntered(stateHandler.showStatePanel);
		A2.setOnMouseExited(stateHandler.closeStatePanel);
		A3.setOnMouseEntered(stateHandler.showStatePanel);
		A3.setOnMouseExited(stateHandler.closeStatePanel);
		B1.setOnMouseEntered(stateHandler.showStatePanel);
		B1.setOnMouseExited(stateHandler.closeStatePanel);
		B2.setOnMouseEntered(stateHandler.showStatePanel);
		B2.setOnMouseExited(stateHandler.closeStatePanel);
		B3.setOnMouseEntered(stateHandler.showStatePanel);
		B3.setOnMouseExited(stateHandler.closeStatePanel);

		//add
		backgroundPanel.setZOrder(-999);
		systemButtonPanel.setZOrder(-3);
		chessBoard.setZOrder(-2);
		arrow.setZOrder(-1);
		actionPanel.setZOrder(-1);
		statePanel.setZOrder(-1);
		playerA.setZOrder(999);
		playerB.setZOrder(999);
		roundPanel.setZOrder(999);

		orderList = FXCollections.observableArrayList(backgroundPanel, chessBoard, A1, A2, A3, B1, B2, B3, arrow, actionPanel, statePanel, playerA, playerB, roundPanel, systemButtonPanel);
		
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
		currentSamurai.setCanActionProperty(true);
		currentSamurai.setOnMouseClicked(actionHandler.samuraiEvent);
		arrow.setCurrentSamurai(currentSamurai);
		actionPanel.setCurrentSamurai(currentSamurai); 
		playerA.pointsPanel.setCurrentSamurai(currentSamurai.getNum());
		playerB.pointsPanel.setCurrentSamurai(currentSamurai.getNum());
		roundPanel.setCurrentSamurai(currentSamurai.getNum());
		
		//add
		currentSamurai.canActionProperty().addListener(new ChangeListener(){
	         public void changed(ObservableValue o,Object oldVal,Object newVal){
	        	 Platform.runLater(new Runnable(){
	 	  			@Override
	 	  			public void run() {
	 	  				// TODO Auto-generated method stub
	 		            boolean canAction= (boolean) newVal;
	 		            if(canAction){
	 		            	arrow.setActualLocation();
	 		            	arrow.setVisible(true);
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
				playerB.pointsPanel.setIsShow(true);
				break;
		}
	}

	public void setCurrentRound(int round){
		roundPanel.setRoundCurrent(round);
//		System.out.println(round);
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
		
		//待添加
		//每个武士占领的block数
		//点move或者occupy之后的方向选择信息
		//点方向之后的block高亮信息
		
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

		}else if(key.equals("state")){
			
		}else if(key.equals("actionPoint")){
			this.currentPlayer.pointsPanel.setPointsRest((int)notifingObject.getValue());
			this.actionPanel.setPointsRest((int)notifingObject.getValue());

		}else if(key.equals("pointsTotal")){
			this.currentPlayer.pointsPanel.setPointsTotal((int)notifingObject.getValue());

		}else if(key.equals("samuraiMove")){
			Position position = (Position)notifingObject.getValue();
			this.currentSamurai.move(position.getX(), position.getY());
			this.actionPanel.reset();
			this.setOrder();
			
		}else if(key.equals("samuraiHide")){
			this.currentSamurai.setHide((boolean)notifingObject.getValue());
			
		}else if(key.equals("samuraiOccupy")){
			this.currentSamurai.occupy((int)notifingObject.getValue());
			this.actionPanel.reset();
			this.arrow.setVisible(true);

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
			System.out.println("vision");
			this.chessBoard.see((ArrayList<ActualBlock>)notifingObject.getValue());
			this.chessBoard.setTmpBlocks((ArrayList<ActualBlock>)notifingObject.getValue());
			
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
			chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();
			
		}else if(key.equals("occupiedBlocks")){
			int[] n = (int [])notifingObject.getValue();
			this.playerA.circlePanel.setBlocks(new int[]{n[1], n[2], n[3]});
			this.playerB.circlePanel.setBlocks(new int[]{n[4], n[5], n[6]});
		}
	}
	
}
