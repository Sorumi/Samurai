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


public class Main extends Application {
	
	public GamePanel gamePanel;
	private GameModel gameModel;
	@Override
	public void start(Stage primaryStage) {

		//下面开始为联机测试方法 勿动 KrayC
		System.out.println("Are you a server(0) or a client(1) or alone(2)?");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		if(i == 0) {
			this.gamePanel = new GamePanelOL(15);

			this.initPanel(primaryStage);

			System.out.println("Waiting for client...");
			HostController hostController = new HostController();
			hostController.serviceSetupHost(this);
		}else if(i == 1){
			this.gamePanel = new GamePanelOL(15);

			this.initPanel(primaryStage);

			ClientController clientController = new ClientController();
			clientController.setupClient("127.0.0.1");
		}else{
			this.gamePanel = new GamePanel(15);

			this.initPanel(primaryStage);

			MenuController menuController = new MenuController();
			menuController.startGame();
		}

	}

	public void initPanel(Stage primaryStage){
		Button exitBtn = new Button("Exit");
		exitBtn.setLayoutX(1100);
		exitBtn.setLayoutY(100);
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		gamePanel.getChildren().add(exitBtn);
		Scene scene = new Scene(gamePanel);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();

		gameModel = new GameModel(24, 14, this, 0);
		gameModel.addObserver(gamePanel);
		gameModel.getChessBoardModel().addObserver(gamePanel);
		GameController gameController = new GameController();

		OperationQueue operationQueue = new OperationQueue(gameModel);
		Thread operationThread = new Thread(operationQueue);
		operationThread.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}