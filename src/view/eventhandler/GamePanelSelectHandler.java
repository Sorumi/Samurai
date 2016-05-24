package view.eventhandler;

import controller.msgqueue.ContinueOperation;
import controller.msgqueue.EndOperation;
import controller.msgqueue.OperationQueue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import musics.Musics;
import view.GamePanel;
import view.MenuPanel;
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
					Pane basePanel = (Pane) gamePanel.getParent(); 
					basePanel.getChildren().remove(gamePanel);
					gamePanel = null;
					MenuPanel menu = (MenuPanel)basePanel.getChildren().get(0);
					menu.setAllAnimation(true);

					OperationQueue.addOperation(new EndOperation(false));
					break;
				case 0:
					basePanel = (Pane) gamePanel.getParent();
					basePanel.getChildren().remove(gamePanel);
					menu = (MenuPanel)basePanel.getChildren().get(0);
					menu.setAllAnimation(true);


					OperationQueue.addOperation(new EndOperation(false));


					break;
				default:
					StoryPanel storyPanel = (StoryPanel) gamePanel.getParent();
					storyPanel.mapPanel.toFront();
					storyPanel.mapPanel.mapHandler.update();
					storyPanel.gamePanel.getChildren().remove(gamePanel);
					storyPanel.gamePanel = null;

					OperationQueue.addOperation(new EndOperation(false));
					break;
	    	  }
	    	  Musics.playEffectMusic(1);

	      }
	};
	
	public EventHandler<MouseEvent> noEvent = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  gamePanel.selectPanel.setVisible(false);	
	    	  OperationQueue.addOperation(new ContinueOperation());
	    	  Musics.playEffectMusic(1);
	      }
	};
}
