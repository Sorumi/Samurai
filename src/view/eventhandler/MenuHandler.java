package view.eventhandler;

import controller.ClientController;
import controller.HostController;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import main.Main;
import network.Configure;
import view.ArchivePanel;
import view.GamePanelOL;
import view.MenuPanel;

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
						mainFrame.menuPanel.storySelectPanel.setVisible(true);
						break;
					case 1:
						mainFrame.startClassicGame();
						break;
					case 2:
						mainFrame.menuPanel.doubleSelectPanel.setVisible(true);
					}
				}
				});
	      }
	};
	public EventHandler<MouseEvent> newStoryEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			startStory();
			
		}  
	};
	public void startStory(){
		mainFrame.startStory();
		mainFrame.menuPanel.getChildren().remove(mainFrame.menuPanel.archivePanel);
		mainFrame.menuPanel.storySelectPanel.setVisible(false);
	}
	
	public EventHandler<MouseEvent> archiveEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			mainFrame.menuPanel.archivePanel = new ArchivePanel(1);
			mainFrame.menuPanel.archivePanel.setLayoutX(350);
			mainFrame.menuPanel.archivePanel.setLayoutY(50);
			mainFrame.menuPanel.getChildren().add(mainFrame.menuPanel.archivePanel);
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

						try {
							mainFrame.startGame();
							ClientController clientController = new ClientController();
							if(clientController.setupClient(Configure.SERVER_ADDRESS)) {
								OperationQueue.addOperation(new StartGameOperation());
							}else{
								System.out.println("fail to connect server");
								Pane basePanel = (Pane) mainFrame.gamePanel.getParent();
								basePanel.getChildren().remove(mainFrame.gamePanel);
								MenuPanel menu = (MenuPanel)basePanel.getChildren().get(0);
								menu.samuraiTimer.start();
							}
						} catch (Exception e){
//							e.printStackTrace();
						}
		  			}
	    	  });
	      }
	};
	public EventHandler<MouseEvent> serverBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.doubleSelectPanel.btnPressed(0);
	      }
	};
	
	public EventHandler<MouseEvent> serverBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.doubleSelectPanel.btnAbled(0);
	      }
	};
	
	public EventHandler<MouseEvent> clientBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.doubleSelectPanel.btnPressed(1);
	      }
	};
	
	public EventHandler<MouseEvent> clientBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.doubleSelectPanel.btnAbled(1);
	      }
	};

	public EventHandler<MouseEvent> newBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.storySelectPanel.btnPressed(0);
	      }
	};
	
	public EventHandler<MouseEvent> newBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.storySelectPanel.btnAbled(0);
	      }
	};
	
	public EventHandler<MouseEvent> oldBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.storySelectPanel.btnPressed(1);
	      }
	};
	
	public EventHandler<MouseEvent> oldBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  mainFrame.menuPanel.storySelectPanel.btnAbled(1);
	      }
	};
	
	public EventHandler<ActionEvent> exitEvent = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			System.exit(0);
		}
	};
	
	public EventHandler<ActionEvent> courseEvent = new EventHandler<ActionEvent>() {
		@Override 
		public void handle(ActionEvent e) {
			mainFrame.menuPanel.guidePanel.setVisible(true);
		}
	};
}
