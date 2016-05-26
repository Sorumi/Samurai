package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.StoryPanel;

public class StoryHandler {
	
	private StoryPanel storyPanel;
	
	public StoryHandler(StoryPanel storyPanel){
		this.storyPanel = storyPanel;
	}
	
	public EventHandler<MouseEvent> nextEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			if(storyPanel.startPanel.storyNum > 0){
				storyPanel.startPanel.setDialog();
			}
		}
	};
	
	public EventHandler<MouseEvent> skipStoryEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			storyPanel.getChildren().remove(storyPanel.startPanel);
			storyPanel.startPanel = null;
			storyPanel.startGame();
		}
	};
	
	
}
