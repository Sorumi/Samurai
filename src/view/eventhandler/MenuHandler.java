package view.eventhandler;

import java.util.Collections;

import controller.ClientController;
import controller.GameController;
import controller.HostController;
import controller.MenuController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import main.Main;
import model.GameModel;
import network.Configure;
import view.GamePanel;
import view.GamePanelOL;

public class MenuHandler {
	
	private Main mainFrame;

	public MenuHandler(Main mainFrame){
		this.mainFrame = mainFrame;
	}
	
	public EventHandler<MouseEvent> classicEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Platform.runLater(new Runnable(){
	  			@Override
	  			public void run() {
	  				// TODO Auto-generated method stub
	  	    	  mainFrame.gamePanel = new GamePanel(15, 0);
		    	  mainFrame.startClassicGame();

		    	  MenuController menuController = new MenuController();
		    	  menuController.startGame();
	  			}
	  		});
	  		
	      }
	};
	
	public EventHandler<MouseEvent> serverEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Platform.runLater(new Runnable(){
		  			@Override
		  			public void run() {
		  	    	  mainFrame.gamePanel = new GamePanelOL(15, 10);
			    	  mainFrame.startGame();
			    	  
			    	  System.out.println("Waiting for client...");
			    	  HostController hostController = new HostController();
			    	  hostController.serviceSetupHost(mainFrame);
		  			}
	    	  });
	    	 
	      }
	};
	
	public EventHandler<MouseEvent> clientEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Platform.runLater(new Runnable(){
		  			@Override
		  			public void run() {
		  	    	  mainFrame.gamePanel = new GamePanelOL(15, 10);
			    	  mainFrame.startGame();
			    	  
			    	  ClientController clientController = new ClientController();
			    	  clientController.setupClient(Configure.SERVER_ADDRESS);
		  			}
	    	  });
	      }
	};
	
	public EventHandler<MouseEvent> storyEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Platform.runLater(new Runnable(){
		  			@Override
		  			public void run() {
			    	  mainFrame.startStory();
		  			}
	    	  });
	      }
	};
	
	public EventHandler<ActionEvent> exitEvent = new EventHandler<ActionEvent>() {//注册事件handler
		@Override
		public void handle(ActionEvent e) {
			System.exit(0);
		}
	};
}
