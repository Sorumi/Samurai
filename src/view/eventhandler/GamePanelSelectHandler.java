package view.eventhandler;

import controller.msgqueue.ContinueOperation;
import controller.msgqueue.EndOperation;
import controller.msgqueue.OperationQueue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import musics.Musics;
import view.BasePanel;
import view.GamePanel;
import view.StoryPanel;

public class GamePanelSelectHandler {
	private GamePanel gamePanel;
	public int level;
	public boolean IsClassic;

	public GamePanelSelectHandler(GamePanel gamePanel,int level){
		this.gamePanel = gamePanel;
		this.level = level;
	}
	
	public void updateIsClassic(boolean b){
		IsClassic = b;
	}
	public EventHandler<MouseEvent> yesEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  switch(level){
	    	  case 99:
					BasePanel basePanel = (BasePanel) gamePanel.getParent(); 
					basePanel.getChildren().remove(gamePanel);
					basePanel.setMenu();

					OperationQueue.addOperation(new EndOperation(false));
					gamePanel = null;
					basePanel.operationThread = null;
					
					break;
					
				case 0:
					basePanel = (BasePanel) gamePanel.getParent();
					basePanel.getChildren().remove(gamePanel);
					basePanel.setMenu();

					OperationQueue.addOperation(new EndOperation(false));
					gamePanel = null;
					basePanel.operationThread = null;
					
					break;
					
				case -1:
					StoryPanel storyPanel = (StoryPanel) gamePanel.getParent();
					storyPanel.territoryPanel.setSamuraiAnimation(true);
					storyPanel.territoryPanel.toFront();
					storyPanel.getChildren().remove(gamePanel);
					storyPanel.gamePanel = null;
					
					OperationQueue.addOperation(new EndOperation(false));
					break;
					
				default:
					storyPanel = (StoryPanel) gamePanel.getParent();
					storyPanel.mapPanel.toFront();
					storyPanel.mapPanel.mapHandler.update();
					storyPanel.getChildren().remove(gamePanel);
					storyPanel.gamePanel = null;

					OperationQueue.addOperation(new EndOperation(false));
					
					break;
	    	  }
	    	  Musics.playEffectMusic(1);
	    	  Musics.playBgMusic(0);

	      }
	};
	
	public EventHandler<MouseEvent> noEvent = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  gamePanel.selectPanel.setVisible(false);	
	    	  OperationQueue.addOperation(new ContinueOperation());
	    	  gamePanel.pausePanel.setVisible(false);
	    	  Musics.playEffectMusic(1);
	      }
	};
}
