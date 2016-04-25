package view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import main.Main;
import view.eventhandler.MenuHandler;

public class MenuPanel extends Pane {
	
	Main mainFrame;
	MenuHandler menuHandler;
	
	Button classicBtn;
	Button doubleBtn;
	Button serverBtn;
	Button clientBtn;
	Button storyBtn;
	Button exitBtn;
	
	public MenuPanel(Main mainFrame){
		this.mainFrame = mainFrame;
		
		classicBtn = new Button("Classic");
		doubleBtn = new Button("Double");
		serverBtn = new Button("Server");
		clientBtn = new Button("Client");
		storyBtn = new Button("Story");
		exitBtn = new Button("Exit");
		
		this.getChildren().add(classicBtn);
		this.getChildren().add(serverBtn);
		this.getChildren().add(clientBtn);
		this.getChildren().add(storyBtn);
		this.getChildren().add(exitBtn);
		
		classicBtn.setLayoutX(500);
		classicBtn.setLayoutY(100);
		serverBtn.setLayoutX(500);
		serverBtn.setLayoutY(200);
		clientBtn.setLayoutX(500);
		clientBtn.setLayoutY(300);
		storyBtn.setLayoutX(500);
		storyBtn.setLayoutY(400);
		menuHandler = new MenuHandler(mainFrame);
		
		classicBtn.setOnMouseClicked(menuHandler.classicEvent);
		serverBtn.setOnMouseClicked(menuHandler.serverEvent);
		clientBtn.setOnMouseClicked(menuHandler.clientEvent);
		storyBtn.setOnMouseClicked(menuHandler.storyEvent);
		exitBtn.setOnAction(menuHandler.exitEvent);
	}
}
