package view;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import javafx.scene.layout.Pane;
import model.GameModel;

public class BasePanel extends Pane {
	public StartLogoPanel logoPanel;
	public MenuPanel menuPanel; 
	
	public GamePanel gamePanel; 
	public GameModel gameModel;
	
	public StoryPanel storyPanel;  

	public Thread operationThread;
	
	
	public BasePanel(){
		this.setPrefSize(1200, 800); 
		setMenu();
	}
	
	public void startLogo(){
		logoPanel = new StartLogoPanel(this);
		
		this.getChildren().addAll(logoPanel);//TODO 
	}
	
	public void setMenu(){
		menuPanel = new MenuPanel();
		menuPanel.setAllAnimation(true);
		this.getChildren().add(menuPanel);
		logoPanel = null;
//		Musics.playBgMusic(0);
	}
	
	public void startDoubleGame(){
		menuPanel.setAllAnimation(false);
		
		this.gamePanel = new GamePanelOL(15);
		this.getChildren().add(gamePanel);
		this.gameModel = new GameModel(24, 14, gamePanel, 0);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(this.gameModel,this.gamePanel);
		operationThread = new Thread(operationQueue);
		operationThread.start();
		removeMenu();
	}

	public void startClassicGame(){
		menuPanel.setAllAnimation(false);
		gamePanel = new GamePanel(15, 99);
		
		this.getChildren().add(gamePanel);
		this.gameModel = new GameModel(120, 14, gamePanel, 99);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(this.gameModel,this.gamePanel);
		OperationQueue.addOperation(new StartGameOperation());
		
		operationThread = new Thread(operationQueue);
		operationThread.start();
		removeMenu();
	}
	
	public void startStory(){
		menuPanel.setAllAnimation(false);
		this.storyPanel = new StoryPanel();
		this.getChildren().add(storyPanel);
		removeMenu();
	}
	
	private void removeMenu(){
		this.getChildren().remove(menuPanel);
		menuPanel = null;
	}
}
