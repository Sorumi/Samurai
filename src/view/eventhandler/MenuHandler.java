package view.eventhandler;

import controller.ClientController;
import controller.HostController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.Main;
import network.Configure;
import view.GamePanelOL;

public class MenuHandler {
	
	private Main mainFrame;

	public MenuHandler(Main mainFrame){
		this.mainFrame = mainFrame;
	}
	
	public EventHandler<MouseEvent> leftClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.btnClick(0);
	      }
	};
	public EventHandler<MouseEvent> rightClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.btnClick(1);
	      }
	};
	
	public EventHandler<MouseEvent> leftBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.leftBtnEnter();
	      }
	};
	public EventHandler<MouseEvent> rightBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.rightBtnEnter();
	      }
	};
	public EventHandler<MouseEvent> leftBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.leftBtnExit();
	      }
	};
	public EventHandler<MouseEvent> rightBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.rightBtnExit();
	      }
	};
	
	
	//
	public EventHandler<MouseEvent> btnEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  	Platform.runLater(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					switch(mainFrame.menuPanel.modeNum){
					case 0:
						mainFrame.startStory();
						break;
					case 1:
						mainFrame.startClassicGame();
						break;
					case 2:
						//双人模式
					}
				}
				});
	      }
	};
	
	public EventHandler<MouseEvent> serverEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Platform.runLater(new Runnable(){
		  			@Override
		  			public void run() {
						mainFrame.gamePanel = new GamePanelOL(15);
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
						mainFrame.gamePanel = new GamePanelOL(15);
						mainFrame.startGame();

						ClientController clientController = new ClientController();
						clientController.setupClient(Configure.SERVER_ADDRESS);
		  			}
	    	  });
	      }
	};
	
	
	public EventHandler<ActionEvent> exitEvent = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			System.exit(0);
		}
	};
}
