package main;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import fonts.FontManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.GameModel;
import musics.Musics;
import view.GamePanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import view.MenuPanel;
import view.StartLogoPanel;
import view.StoryPanel;

/*
	*********************
	*     SamuraINF     *
	*    Produced by    *
	*       Sorumi      *
	*       KrayC       *
	*  SilverNarcissus  *
	*     Vivian-SJ     *
	*    Version 1.0    *
	*     2016-5-18     *
	*********************
 */

public class Main extends Application {
	
	private Scene scene;
	public Pane basePanel;
	
	public StartLogoPanel logoPanel;
	public MenuPanel menuPanel; 
	
	public GamePanel gamePanel; 
	public GameModel gameModel;
	
	public StoryPanel storyPanel;  

	public Thread operationThread;
	
	@Override
	public void start(Stage primaryStage) {
		FontManager.loadAllFont();
		
		basePanel = new Pane();
		scene = new Scene(basePanel);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		
//		logoPanel = new StartLogoPanel(this);
		menuPanel = new MenuPanel(this);
		
		basePanel.getChildren().addAll(menuPanel );//TODO logoPanel
		setMenu();
		Musics.playBgMusic(0);
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}
	
	public void setMenu(){
		menuPanel.setAllAnimation(true);
	}
	public void startGame(){
		menuPanel.setAllAnimation(false);
		basePanel.getChildren().add(gamePanel);
		this.gameModel = new GameModel(24, 14, gamePanel, 0);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(this.gameModel,this.gamePanel);
		operationThread = new Thread(operationQueue);
		operationThread.start();
	}

	public void startClassicGame(){
		menuPanel.setAllAnimation(false);
		gamePanel = new GamePanel(15, 99);
		
		basePanel.getChildren().add(gamePanel);
		this.gameModel = new GameModel(120, 14, gamePanel, 99);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(this.gameModel,this.gamePanel);
		OperationQueue.addOperation(new StartGameOperation());
		
		operationThread = new Thread(operationQueue);
		operationThread.start();
	}
	
	public void startStory(){
		menuPanel.setAllAnimation(false);
		this.storyPanel = new StoryPanel();
		basePanel.getChildren().add(storyPanel);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
