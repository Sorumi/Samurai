package view.eventhandler;

import java.text.SimpleDateFormat;

import controller.ArchiveController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import musics.Musics;
import view.ArchivePanel;
import view.ArchiveSelectPanel;
import view.ArchiveView;
import view.MenuPanel;

public class ArchiveSelectHandler{
	private ArchivePanel archivePanel;
	public int num;
	private ArchiveController archiveController;
	public boolean isSave;

	public ArchiveSelectHandler(ArchivePanel archivePanel) {
		this.archivePanel = archivePanel;
		this.archiveController = new ArchiveController();
	}

	public void setStoryModel(){
		this.archiveController.setStoryModel(StoryModel.loadStoryModel(num));
		this.archiveController.load(num);
	}

	public EventHandler<MouseEvent> yesEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			if (isSave) {
				archiveController.setStoryModel(StoryModel.getStoryModel());
				archiveController.save(num);
				ArchiveView archiveView = (ArchiveView) archivePanel.archiveGroup.getChildren().get(num);
				
				SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
				archiveView.setTime(ft.format(archiveController.getTime(num)));
				archivePanel.successPanel.setVisible(true); 
				archivePanel.archiveSelectPanel.setVisible(false);
			} else {
				ArchiveView archiveView = (ArchiveView) archivePanel.archiveGroup.getChildren().get(num);
				
				if (archiveView.type == 1) {
					MenuPanel menu = (MenuPanel) archiveView.getParent().getParent().getParent();
					menu.getMenuHandler().startOldStory();
				}

				archivePanel.archiveSelectPanel.setVisible(false);
			}
			Musics.playEffectMusic(1);
		}
	};

	public EventHandler<MouseEvent> noEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			archivePanel.archiveSelectPanel.setVisible(false);
			Musics.playEffectMusic(1);
		}
	};

}
