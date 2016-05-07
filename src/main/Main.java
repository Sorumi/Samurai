package main;

import controller.msgqueue.OperationQueue;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.GameModel;
import view.GamePanel;
import javafx.scene.Scene;
import view.MenuPanel;
import view.StoryPanel;

public class Main extends Application {
	
	private Scene scene;
	
	public MenuPanel menuPanel;
	
	public GamePanel gamePanel; 
	public GameModel gameModel;
	
	public StoryPanel storyPanel;
	
	@Override
	public void start(Stage primaryStage) {

		menuPanel = new MenuPanel(this);
		menuPanel.setPrefWidth(1200);
		menuPanel.setPrefHeight(800);
		
		scene = new Scene(menuPanel);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}

	public void startGame(){
		scene.setRoot(gamePanel);
		this.gameModel = new GameModel(24, 14, this, 0);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(gameModel);
		Thread operationThread = new Thread(operationQueue);
		operationThread.start();
	}

	public void startClassicGame(){
		scene.setRoot(gamePanel);
		this.gameModel = new GameModel(24, 14, this, 99);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(gameModel);
		Thread operationThread = new Thread(operationQueue);
		operationThread.start();
	}
	
	public void startStory(){
		this.storyPanel = new StoryPanel();
		scene.setRoot(storyPanel);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
