package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import musics.Musics;
import view.BasePanel;
import view.story.StoryPanel;
import view.story.TerritoryPanel;

public class TerToMenuSelectHandler {
	private TerritoryPanel territoryPanel;
	
	public TerToMenuSelectHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
	
	}
	
	public EventHandler<MouseEvent> yesEvent = new EventHandler<MouseEvent>() { 
		public void handle(MouseEvent event) {
			StoryPanel storyPanel = (StoryPanel) territoryPanel.getParent();
			BasePanel basePanel = (BasePanel) storyPanel.getParent();
			basePanel.getChildren().remove(storyPanel);
			basePanel.setMenu();
//			menu.setAllAnimation(true);
			Musics.playEffectMusic(1);
		}
	};
	
	public EventHandler<MouseEvent> noEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.terToMenuSelectPanel.setVisible(false); 
			Musics.playEffectMusic(1);
		}
	};

}
