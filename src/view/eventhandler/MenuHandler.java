package view.eventhandler;

import controller.ClientController;
import controller.HostController;
import controller.TerritoryController;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import main.Main;
import model.StoryModel;
import musics.Musics;
import network.Configure;
import view.ArchivePanel;
import view.BasePanel;
import view.GamePanelOL;
import view.MenuPanel;
import view.guide.GuideGroup;

public class MenuHandler {

	private MenuPanel menuPanel;
	// private BasePanel basePanel;

	public MenuHandler(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
//		this.basePanel = (BasePanel) menuPanel.getParent();
	}

	public EventHandler<MouseEvent> leftClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.btnClick(0);
		}
	};
	public EventHandler<MouseEvent> rightClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.btnClick(1);
		}
	};

	public EventHandler<MouseEvent> leftBtnEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.leftBtnEnter();
		}
	};
	public EventHandler<MouseEvent> rightBtnEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.rightBtnEnter();
		}
	};
	public EventHandler<MouseEvent> leftBtnExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.leftBtnExit();
		}
	};
	public EventHandler<MouseEvent> rightBtnExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.rightBtnExit();
		}
	};

	//
	public EventHandler<MouseEvent> btnEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			BasePanel basePanel = (BasePanel) menuPanel.getParent();

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					switch (menuPanel.modeNum) {
					case 0:
						menuPanel.storySelectPanel.setVisible(true);
						break;
					case 1:
						basePanel.startClassicGame();
						break;
					case 2:
						menuPanel.doubleSelectPanel.setVisible(true);
					}
				}
			});
		}
	};

	public EventHandler<MouseEvent> newStoryEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			StoryModel.newStoryModel();
			TerritoryController.territoryController().setStoryModel(StoryModel.getStoryModel());
			startNewStory();
			Musics.playEffectMusic(1);
		}
	};

	public void startNewStory() {
		BasePanel basePanel = (BasePanel) menuPanel.getParent();
		basePanel.startStory();
		basePanel.storyPanel.startStory();
		menuPanel.getChildren().remove(menuPanel.archivePanel);
		menuPanel.storySelectPanel.setVisible(false);
	}
	
	public void startOldStory() {
		BasePanel basePanel = (BasePanel) menuPanel.getParent();
		basePanel.startStory();
		basePanel.storyPanel.startGame();
		basePanel.storyPanel.territoryPanel.resetButtons();
		menuPanel.getChildren().remove(menuPanel.archivePanel);
		menuPanel.storySelectPanel.setVisible(false);
	}

	public EventHandler<MouseEvent> archiveEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			menuPanel.archivePanel = new ArchivePanel(1);
			menuPanel.archivePanel.setLayoutX(350);
			menuPanel.archivePanel.setLayoutY(50);
			menuPanel.getChildren().add(menuPanel.archivePanel);
			Musics.playEffectMusic(1);
		}
	};

	public EventHandler<MouseEvent> serverEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					
					BasePanel basePanel = (BasePanel) menuPanel.getParent();
					basePanel.startDoubleGame();

					System.out.println("Waiting for client...");
					HostController hostController = new HostController();
					hostController.serviceSetupHost(basePanel);
				}
			});

		}
	};

	public EventHandler<MouseEvent> clientEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					BasePanel basePanel = (BasePanel) menuPanel.getParent();

					try {
						basePanel.startDoubleGame();
						ClientController clientController = new ClientController();
						if (clientController.setupClient(Configure.SERVER_ADDRESS)) {
							OperationQueue.addOperation(new StartGameOperation());
						} else {
							System.out.println("fail to connect server");
							basePanel.getChildren().remove(basePanel.gamePanel);
							MenuPanel menu = (MenuPanel) basePanel.getChildren().get(0);
							menu.setAllAnimation(true);
						}
					} catch (Exception e) {
						// e.printStackTrace();
					}
				}
			});
		}
	};
	public EventHandler<MouseEvent> serverBtnEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.doubleSelectPanel.btnPressed(0);
		}
	};

	public EventHandler<MouseEvent> serverBtnExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.doubleSelectPanel.btnAbled(0);
		}
	};

	public EventHandler<MouseEvent> clientBtnEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.doubleSelectPanel.btnPressed(1);
		}
	};

	public EventHandler<MouseEvent> clientBtnExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.doubleSelectPanel.btnAbled(1);
		}
	};

	public EventHandler<MouseEvent> newBtnEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.storySelectPanel.btnPressed(0);
		}
	};

	public EventHandler<MouseEvent> newBtnExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.storySelectPanel.btnAbled(0);
		}
	};

	public EventHandler<MouseEvent> oldBtnEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.storySelectPanel.btnPressed(1);
		}
	};

	public EventHandler<MouseEvent> oldBtnExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			menuPanel.storySelectPanel.btnAbled(1);
		}
	};

	public EventHandler<ActionEvent> exitEvent = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			System.exit(0);
		}
	};

	public EventHandler<ActionEvent> guideEvent = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			// menuPanel.guideGroup.setVisible(true);
			menuPanel.setAllAnimation(false);
			menuPanel.guideGroup = new GuideGroup();
			menuPanel.getChildren().add(menuPanel.guideGroup);
		}
	};

	public EventHandler<ActionEvent> musicEvent = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			Musics.isBgMusic = false;
			Musics.THEME.pause();
			menuPanel.musicBtn.setVisible(false);
		}
	};
	public EventHandler<ActionEvent> nomusicEvent = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
			Musics.isBgMusic = true;
			Musics.THEME.play();
			menuPanel.musicBtn.setVisible(true);
		}
	};
}
