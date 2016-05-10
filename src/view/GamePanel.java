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
import view.smithy.SmithyPanel;

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
	 * 0: 经典模式
	 * 1-9：剧情模式的level
	 * 10：双人模式
	 * 99：测试模式： 红蓝双方都可见
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
				System.exit(0);
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
		//stateHandler
		stateHandler = new StateHandler(this);
		//statepanel
		statePanel = new StatePanel(stateHandler);
		this.getChildren().add(statePanel);
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
		backgroundPanel.setZOrder(-2);
		systemPanel.setZOrder(-1);
		chessBoard.setZOrder(-3);
		arrow.setZOrder(-1);
		actionPanel.setZOrder(-1);
		statePanel.setZOrder(-1);
		playerA.setZOrder(999);
		playerB.setZOrder(999);
		roundPanel.setZOrder(999);
		resultPanel.setZOrder(999); 

		orderList = FXCollections.observableArrayList(backgroundPanel, chessBoard, A1, A2, A3, B1, B2, B3, arrow, actionPanel, statePanel, playerA, playerB, roundPanel, systemPanel, resultPanel);

	}

	public void set6Properties(int samurai, int[] properties){
//		switch (samurai) {
//			case 1:
//				this.A1.samuraiV.setWeapon(weapon);
//				break;
//			case 2:
//				this.A2.samuraiV.setWeapon(weapon);
//				break;
//			case 3:
//				this.A3.samuraiV.setWeapon(weapon);
//				break;
//		}
	}

	public int[] get6Properties(int samurai){
		switch (samurai) {
			case 1:
				return new int[]{1,2,3,4,5,6};
			case 2:
				return new int[]{7,8,9,10,11,12};
			case 3:
				return new int[]{13,14,15,16,17,18};
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
//		playerB.pointsPanel.setCurrentSamurai(currentSamurai.getNum());
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
								currentSamurai.setOnMouseEntered(stateHandler.showStatePanel);
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
//				playerA.pointsPanel.setIsShow(false);
//				playerB.pointsPanel.setIsShow(true);
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

		//待添加
		//点move或者occupy之后的方向选择信息
		//点方向之后的block高亮信息

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
		}
	}

}
