package main;
	
import java.util.Collections;
import java.util.Scanner;

import controller.ClientController;
import controller.HostController;
import controller.MenuController;
import controller.msgqueue.OperationQueue;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.GameModel;
import view.GamePanel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import view.GamePanelOL;
import view.MenuPanel;
import view.StoryPanel;
import view.eventhandler.MenuHandler;


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
