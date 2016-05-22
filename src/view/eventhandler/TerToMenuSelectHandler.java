package view.eventhandler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import view.ArchivePanel;
import view.MenuPanel;
import view.StoryPanel;
import view.TerToMenuSelectPanel;
import view.TerritoryPanel;

public class TerToMenuSelectHandler {
	private TerritoryPanel territoryPanel;
	
	public TerToMenuSelectHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
	
	}
	
	public EventHandler<MouseEvent> yesEvent = new EventHandler<MouseEvent>() { 
		public void handle(MouseEvent event) {
			// 读取存档 num
			StoryPanel storyPanel = (StoryPanel) territoryPanel.getParent();
			Pane basePanel = (Pane) storyPanel.getParent();
			basePanel.getChildren().remove(storyPanel);
			MenuPanel menu = (MenuPanel) basePanel.getChildren().get(0);
			menu.setAllAnimation(true);
		}
	};
	
	public EventHandler<MouseEvent> noEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			// 读取存档 num
			territoryPanel.terToMenuSelectPanel.setVisible(false); 
		}
	};

}
