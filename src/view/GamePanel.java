package view;

import java.util.*;

import controller.msgqueue.ContinueOperation;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.StopOperation;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Material;
import model.po.Position;
import model.po.PropsInG;
import model.po.SamuraiPO;
import view.background.BackgroundPanel;
import view.background.BackgroundPanel0;
import view.background.BackgroundPanel1;
import view.background.BackgroundPanel2;
import view.background.BackgroundPanel3;
import view.background.BackgroundPanel4;
import view.background.BackgroundPanel5;
import view.eventhandler.ActionHandler;
import view.eventhandler.GamePanelSelectHandler;
import view.eventhandler.StateHandler;
import view.items.CircleLight;

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
	protected SystemButton pauseBtn;
	protected SystemButton continueBtn;
	protected BackgroundPanel backgroundPanel;
	public ChessBoardPanel chessBoard;

	//TODO
	protected int timeTotal = 30;
	protected int roundTotal = 120;

	public SamuraiPanel currentSamurai; //0：无 1 2 3 4 5 6

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

	private int[] bloodTotal = new int[7];
	private int[] bloodRest = new int[7];

	protected PlayerPanel currentPlayer;
	protected PlayerPanel playerA;
	protected PlayerPanel playerB;

	protected RoundPanel roundPanel;
	protected PropPanel propPanel;
	protected ResultPanel resultPanel;

	protected OrderPanel propsGroup;
	protected CircleLight circleLight;
	
	public Arrow arrow;
	public ActionPanel actionPanel;
	protected ActionHandler actionHandler;
	public StatePanel statePanel;
	public SelectPanel selectPanel;
	protected GamePanelSelectHandler selectHandler;
	protected StateHandler stateHandler;
	public ObservableList<OrderPanel>  orderList;
	private boolean isOver; 

	private ArrayList<PropView> propViews;
	
	public GameOverlayPanel overlayPanel;

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
		
		this.selectHandler = new GamePanelSelectHandler(this,level); 
		this.selectPanel = new SelectPanel("确定退出吗?你将会丢失当前未存档的所有游戏进度(包括已获得的道具)!");
		selectPanel.yesBtn.setOnMouseClicked(selectHandler.yesEvent);
		selectPanel.noBtn.setOnMouseClicked(selectHandler.noEvent);
		selectPanel.setZOrder(999);
		selectPanel.setVisible(false);
		this.getChildren().add(selectPanel);
		this.isOver = false;
		
		//systembutton
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		this.close();
		
		pauseBtn = new SystemButton(3);
		pauseBtn.setLayoutX(1050);
		pauseBtn.setLayoutY(25);
		pauseBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (currentSamurai.getNum()/4 == 0){
					OperationQueue.addOperation(new StopOperation());
					pauseBtn.setVisible(false);
				}
			}
		});
		continueBtn = new SystemButton(4);
		continueBtn.setLayoutX(1050);
		continueBtn.setLayoutY(25);
		continueBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				OperationQueue.addOperation(new ContinueOperation());
				pauseBtn.setVisible(true);
			}
		});
		
		OrderPanel systemPanel = new OrderPanel();
		systemPanel.getChildren().addAll(closeBtn, continueBtn, pauseBtn);
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
//		this.setOnKeyPressed(actionHandler.keyEvent);

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
		
		//只有故事模式有 statePanel 和 resultPanel 和 propPanel
		if(level < 99 && level > 0) {
			//stateHandler
			stateHandler = new StateHandler(this);
			//statepanel
			statePanel = new StatePanel(stateHandler,1);
			this.getChildren().add(statePanel);
			statePanel.setZOrder(999);

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

			//resultpanel
			resultPanel = new ResultPanel(this);
			this.getChildren().add(resultPanel);
			resultPanel.setZOrder(999);
			
			//proppanel
			propPanel = new PropPanel();
			this.getChildren().add(propPanel);
			propPanel.setZOrder(999);
			
			propsGroup = new OrderPanel();
			this.getChildren().add(propsGroup);
			propsGroup.setZOrder(-3);

			this.propViews = new ArrayList<>();
			
			this.circleLight = new CircleLight();
			this.getChildren().add(circleLight);
			circleLight.setZOrder(-1);
			
			//overlay
			overlayPanel = new GameOverlayPanel();
			overlayPanel.setOnMouseClicked(actionHandler.overlayEvent);
			this.getChildren().add(overlayPanel);
			overlayPanel.setZOrder(1000);
		}else{
			A1.setOnMouseEntered(actionHandler.samuraiEnterEvent);
			A1.setOnMouseExited(actionHandler.samuraiEnterEvent);
			A2.setOnMouseEntered(actionHandler.samuraiExitEvent);
			A2.setOnMouseExited(actionHandler.samuraiEnterEvent);
			A3.setOnMouseEntered(actionHandler.samuraiExitEvent);
			A3.setOnMouseExited(actionHandler.samuraiEnterEvent);
			B1.setOnMouseEntered(actionHandler.samuraiExitEvent);
			B1.setOnMouseExited(actionHandler.samuraiEnterEvent);
			B2.setOnMouseEntered(actionHandler.samuraiExitEvent);
			B2.setOnMouseExited(actionHandler.samuraiEnterEvent);
			B3.setOnMouseEntered(actionHandler.samuraiExitEvent);
			B3.setOnMouseExited(actionHandler.samuraiEnterEvent);
		}

		backgroundPanel.setZOrder(-2);
		systemPanel.setZOrder(-1);
		chessBoard.setZOrder(-4);
		arrow.setZOrder(-1);
		actionPanel.setZOrder(-1);
		playerA.setZOrder(999);
		playerB.setZOrder(999);
		roundPanel.setZOrder(999);
		

		if(level < 99 && level > 0) {
			orderList = FXCollections.observableArrayList(backgroundPanel, chessBoard, A1, A2, A3, B1, B2, B3, arrow, actionPanel, statePanel, playerA, playerB, roundPanel, systemPanel, resultPanel, propPanel, propsGroup, selectPanel, overlayPanel, circleLight);
		}else{
			orderList = FXCollections.observableArrayList(backgroundPanel, chessBoard, A1, A2, A3, B1, B2, B3, arrow, actionPanel, playerA, playerB, roundPanel, systemPanel, selectPanel);
		}
		this.setOrder();
	}

	private void addProp(int x, int y, int num) {
		if (propsGroup != null){
			PropView prop = new PropView(num, 1);
			prop.setActualLocation(x, y);
			propsGroup.getChildren().add(prop);
			this.propViews.add(prop);
			prop.setVisible(false);
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
			case 4:
				this.samuraiProperties_4 = properties;
				break;
			case 5:
				this.samuraiProperties_5 = properties;
				break;
			case 6:
				this.samuraiProperties_6 = properties;
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
			case 4:
				return this.samuraiProperties_4;
			case 5:
				return this.samuraiProperties_5;
			case 6:
				return this.samuraiProperties_6;
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
			case 4:
				this.B1.samuraiV.setWeapon(weapon);
				break;
			case 5:
				this.B2.samuraiV.setWeapon(weapon);
				break;
			case 6:
				this.B3.samuraiV.setWeapon(weapon);
				break;
		}
	}

	public void setSamuraiArmor(int samurai, int Armor){
		switch (samurai) {
			case 1:
				this.A1.samuraiV.setArmor(Armor);
				break;
			case 2:
				this.A2.samuraiV.setArmor(Armor);
				break;
			case 3:
				this.A3.samuraiV.setArmor(Armor);
				break;
			case 4:
				this.B1.samuraiV.setArmor(Armor);
				break;
			case 5:
				this.B2.samuraiV.setArmor(Armor);
				break;
			case 6:
				this.B3.samuraiV.setArmor(Armor);
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
				Collections.sort(orderList);
				GamePanel.this.getChildren().setAll(orderList);
			}
		});
	}

	protected SamuraiPanel getSamurai(int num){
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
		currentSamurai.samuraiV.setRandomAnimation(false);
		currentSamurai.setCanHide(chessBoard.getState(currentSamurai.x, currentSamurai.y) / 4 == currentSamurai.getNum() / 4);

		roundPanel.setCurrentSamurai(currentSamurai.getNum());
		playerA.pointsPanel.setCurrentSamurai(currentSamurai.getNum());

		if(currentPlayer == playerA) {
			currentSamurai.setCanActionProperty(true);
			currentSamurai.setOnMouseClicked(actionHandler.samuraiClickEvent);
			actionPanel.setCurrentSamurai(currentSamurai);
            arrow.setCurrentSamurai(currentSamurai);
		}else{
			actionPanel.setAppear(false,true);
		}

		//add
		currentSamurai.canActionProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue o,Object oldVal,Object newVal){
				Platform.runLater(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						boolean canAction = (boolean) newVal;
						if (canAction) {
							if(level < 99 && level > 0) {
								currentSamurai.setOnMouseEntered(stateHandler.showStatePanelInG);
								if(currentPlayer == playerA) {
									arrow.setActualLocation();
									arrow.setVisible(true);
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
			playerA.circlePanel.flip(true);
			playerB.circlePanel.flip(false);
		}else{
			playerA.circlePanel.setNewTime(false);
			playerB.circlePanel.setNewTime(true);
			playerA.circlePanel.flip(false);
			playerB.circlePanel.flip(true);
		}
	}

	public int getBloodRestOfSamurai(int i) {
		return bloodRest[i];
	}

	public int getBloodTotalOfSamurai(int i){
		return bloodTotal[i];
	}
	
	public void updateIsOver(boolean b){ 
		isOver = b;
	}

	public void setRoundTotal(int roundTotal) {
		this.roundTotal = roundTotal;
		this.roundPanel.setRoundTotal(this.roundTotal);
	}

	public void useProp(int num){
		//TODO
		num = PropsInG.get7Type(num);		
		this.circleLight.setActualacation(this.currentSamurai.getLayoutX()-40, this.currentSamurai.getLayoutY());
		this.circleLight.setNum(num/10%10);		
	}
	
	public void close(){
		if(!isOver){
			switch(level){
			case -1:
			case 0:
			case 99:

				closeBtn.setOnMouseClicked(selectHandler.yesEvent);
				break;
			default:
				closeBtn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					selectPanel.setVisible(true);
					OperationQueue.addOperation(new StopOperation());
					System.out.println("LEVEL : " + level);
					switch(level){
						case 99:
							selectHandler.level = 99;
							break;
						case 0:
							selectHandler.level = 0;
							break;
					}
				}
			});
			}
		}else{
			closeBtn.setOnMouseClicked(selectHandler.yesEvent);			
		}
	}


	public void update(Observable o, Object arg) {
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();

		Platform.runLater(new Runnable(){
			public void run() {
				if(key.equals("samurai")){
					setCurrentSamurai((int) notifingObject.getValue());
					
				}else if(key.equals("player")){
					setCurrentPlayer((int) notifingObject.getValue());
					
				}else if(key.equals("round")){
					setCurrentRound((int)notifingObject.getValue());
					
				}else if(key.equals("totalRound")){
					setRoundTotal((int)notifingObject.getValue());

				}else if(key.equals("time")){
					currentPlayer.circlePanel.setTimeRest((int) notifingObject.getValue());
					
				}else if(key.equals("state")){

				}else if(key.equals("actionPoint")){
					currentPlayer.pointsPanel.setPointsRest((int)notifingObject.getValue());
					actionPanel.setPointsRest((int)notifingObject.getValue());
//					System.out.println("rest: " + (int)notifingObject.getValue());
					
				}else if(key.equals("pointsTotal")){
					currentPlayer.pointsPanel.setPointsTotal((int)notifingObject.getValue());
//					System.out.println("total: " + (int)notifingObject.getValue());
					
				}else if(key.equals("samuraiMove")){
					Position position = (Position)notifingObject.getValue();
					currentSamurai.move(position.getX(), position.getY());
					currentSamurai.setCanHide(chessBoard.getState(currentSamurai.x, currentSamurai.y) / 4 == currentSamurai.getNum() / 4);
					if (currentPlayer.getPlayer() == 0) {
						actionPanel.reset();
						setOrder();
					}

				}else if(key.equals("samuraiHide")){
					currentSamurai.setHide((boolean)notifingObject.getValue());
					
				}else if(key.equals("samuraiOccupy")){
					currentSamurai.occupy((int)notifingObject.getValue());
					if (currentPlayer.getPlayer() == 0) {
						currentSamurai.setCanHide(chessBoard.getState(currentSamurai.x, currentSamurai.y) / 4 == currentSamurai.getNum() / 4);
						actionPanel.reset();
						arrow.setVisible(true);
					}
				}else if(key.equals("samuraiKilled")){
					getSamurai((int)notifingObject.getValue()).setInjured(true);
					
				}else if(key.equals("visible")){
		            A1.setVisible(true);
		            A2.setVisible(true);
		            A3.setVisible(true);
		            B1.setVisible(false);
		            B2.setVisible(false);
		            B3.setVisible(false);
		            for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()) {
		                if (block.getX() == B1.x && block.getY() == B1.y) {
		                    if (!B1.isHide()) {
		                        B1.setVisible(true);
		                    }
		                }
		                if (block.getX() == B2.x && block.getY() == B2.y) {
		                    if (!B2.isHide()) {
		                        B2.setVisible(true);
		                    }
		                }
		                if (block.getX() == B3.x && block.getY() == B3.y) {
		                    if (!B3.isHide()) {
		                        B3.setVisible(true);
		                    }
		                }

		            }
					if(level != 99) {
						for (PropView propView : propViews) {
							propView.setVisible(false);
							for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()){
								if (block.getX() == propView.x && block.getY() == propView.y) {
									System.out.println("ADD PROP");
									propView.setVisible(true);
								}
							}
						}
					}

				}else if(key.equals("vision")){
					chessBoard.see((ArrayList<ActualBlock>) notifingObject.getValue());
					chessBoard.setTmpBlocks((ArrayList<ActualBlock>) notifingObject.getValue());
					
				}else if(key.equals("home")){
					SamuraiPO samuraiPO = (SamuraiPO)notifingObject.getValue();
					SamuraiPanel tmpView = null;
					switch (samuraiPO.getNumber()){
						case 1:
							tmpView = A1;
							break;
						case 2:
							tmpView = A2;
							break;
						case 3:
							tmpView = A3;
							break;
						case 4:
							tmpView = B1;
							break;
						case 5:
							tmpView = B2;
							break;
						case 6:
							tmpView = B3;
							break;
						default:
							break;
					}
//					if (currentPlayer.getPlayer() == 0) {
//						actionPanel.reset();
//						setOrder();
//					}
					tmpView.setActualLocation(samuraiPO.getHome().getX(), samuraiPO.getHome().getY());
					chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();
					
				}else if(key.equals("occupiedBlocks")){
					int[] n = (int [])notifingObject.getValue();
					playerA.circlePanel.setBlocks(new int[]{n[1], n[2], n[3]});
					playerB.circlePanel.setBlocks(new int[]{n[4], n[5], n[6]});
					
				}else if(key.equals("revive")){
		            System.out.println("Samurai revive!" + (int)notifingObject.getValue());
		            getSamurai((int)notifingObject.getValue()).setInjured(false);
		            
		        }else if(key.equals("pseudoOccupy")){
					chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), true);
					
				}else if(key.equals("a-pseudoOccupy")){
					chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), false);
					
				}else if(key.equals("over")){
					resultPanel.setBlocks((int [])notifingObject.getValue());
					GamePanel.this.updateIsOver(true); 
					GamePanel.this.close();
				}else if(key.equals("miss")){
					getSamurai((int)notifingObject.getValue()).setMiss();
					
				}else if(key.equals("normal-attack")){
					int[] t = (int [])notifingObject.getValue();
					getSamurai(t[0]).setAttacked(t[1]);
					
				}else if(key.equals("critical-attack")){
					int[] t = (int [])notifingObject.getValue();
					getSamurai(t[0]).setDoubleAttacked((int)(t[1] / 2));
					
				}else if(key.equals("levelup")){
					resultPanel.setLevelUp((int)notifingObject.getValue());
					
				}else if(key.equals("materials")){
					resultPanel.setMaterials((ArrayList<Material>)notifingObject.getValue());
					
				}else if(key.equals("experiences")){
					resultPanel.setExperiences((int[])notifingObject.getValue());

				}else if(key.equals("healthTotal")){
					int[] t = (int [])notifingObject.getValue();
					bloodTotal[t[0]] = t[1];
					bloodRest[t[0]] = t[1];

				}else if(key.equals("healthPoint")){
					int[] t = (int [])notifingObject.getValue();
					bloodRest[t[0]] = t[1];

				}else if(key.equals("rating")){
					resultPanel.setRate((int)notifingObject.getValue());
					resultPanel.setStart();
					
				}else if(key.equals("prop")){
					int[] t = (int [])notifingObject.getValue();
					addProp(t[0], t[1], t[2]);

				}else if(key.equals("goodbyeactionpanel")){
					actionPanel.setAppear(false,false);

				}else if(key.equals("getProp")){
					int[] t = (int [])notifingObject.getValue();
					System.out.println("Position : " + t[0] + " , " + t[1] + " get prop ");
					int size = propsGroup.getChildren().size();
					for(int i = 0; i < size; i++){
						PropView prop = (PropView) propsGroup.getChildren().get(i);
						if(prop.x == t[0] && prop.y == t[1]){
							propsGroup.getChildren().remove(i);
							propViews.remove(prop);
							break;
						}
					}

				}else if(key.equals("allProps")) {
					int[] propList = (int[]) notifingObject.getValue();
					//更新 propPanel 的消息
					for (int i = 1; i <= 14; i++) {
						propPanel.setProp(i,propList[i]);
					}
				}else if(key.equals("useProp")){
					int[] t = (int [])notifingObject.getValue();
					propPanel.useProp(t[0]);
					useProp(t[0]);
					set6Properties(t[1],new int[]{t[2],t[3],t[4],t[5],t[6],t[7],t[8]});
					
				}else if(key.equals("replace")){
					int[] t = (int [])notifingObject.getValue();
					set6Properties(t[0],new int[]{t[1],t[2],t[3],t[4],t[5],t[6],t[7]});
				}
				

			}
		});
	}

}
