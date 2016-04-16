package main;
	
import java.util.Collections;

import controller.GameController;
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


public class Main extends Application {
	
	public GamePanel gamePanel;
	private GameModel gameModel;
	@Override
	public void start(Stage primaryStage) {
		
			this.gamePanel = new GamePanel(15);
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
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
	        gameModel = new GameModel(24, 14, this, 1);

	        gameModel.addObserver(gamePanel);
	        gameModel.getChessBoardModel().addObserver(gamePanel);
	        MenuController menuController = new MenuController();
	        GameController gameController = new GameController();

	        OperationQueue operationQueue = new OperationQueue(gameModel);
	        Thread operationThread = new Thread(operationQueue);
	        operationThread.start();

	        menuController.startGame();
		        
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
