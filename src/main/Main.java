package main;
	
import java.util.Collections;
import java.util.Scanner;

import controller.ClientController;
import controller.GameController;
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
import javafx.util.Duration;
import model.GameModel;
import view.GamePanel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import view.GamePanelOL;
import view.MenuPanel;
import view.eventhandler.MenuHandler;


public class Main extends Application {
	
	private Scene scene;
	
	public GamePanel gamePanel;
	public GameModel gameModel;
	
	public MenuPanel menuPanel;
	
	@Override
	public void start(Stage primaryStage) {

		
		//下面开始为联机测试方法 勿动 KrayC
//		System.out.println("Are you a server(0) or a client(1) or alone(2)?");
//		Scanner s = new Scanner(System.in);
//		int i = s.nextInt();
//		if(i == 0) {
//			this.gamePanel = new GamePanelOL(15);
//
//			this.initPanel(primaryStage);
//
//			System.out.println("Waiting for client...");
//			HostController hostController = new HostController();
//			hostController.serviceSetupHost(this);
//		}else if(i == 1){
//
//		}else{
//			this.gamePanel = new GamePanel(15);
//
//			this.initPanel(primaryStage);
//
//			MenuController menuController = new MenuController();
//			menuController.startGame();
//		}
		
		menuPanel = new MenuPanel(this);
		menuPanel.setPrefWidth(1200);
		menuPanel.setPrefHeight(800);
		
		scene = new Scene(menuPanel);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public void startGame(){
		scene.setRoot(gamePanel);
		this.gameModel = new GameModel(24, 14, this, 0);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		
		GameController gameController = new GameController();
		
		OperationQueue operationQueue = new OperationQueue(gameModel);
		Thread operationThread = new Thread(operationQueue);
		operationThread.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
