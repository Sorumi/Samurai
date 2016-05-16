package view.eventhandler;

import java.text.SimpleDateFormat;

import controller.ArchiveController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import view.ArchivePanel;
import view.ArchiveSelectPanel;
import view.ArchiveView;
import view.MenuPanel;

public class ArchiveSelectHandler implements EventHandler {
	// private ArchiveSelectPanel archiveSelectPanel;
	// private ArchiveHandler archiveHandler;
	private ArchiveView archiveView;
	private int num;
	private ArchiveController archiveController;

	public ArchiveSelectHandler(ArchiveView archiveView, int num) {
		this.num = num;
		this.archiveView = archiveView;
		// this.archiveHandler = archiveView.archiveHandler;
		this.archiveController = new ArchiveController();
		this.archiveController.setStoryModel(StoryModel.getStoryModel());
	}

	public EventHandler<MouseEvent> yesEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			// 读取存档 num
			archiveController.save(num);
			SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			archiveView.setTime(ft.format(archiveController.getTime(num)));
			ArchivePanel archivePanel = (ArchivePanel) archiveView.getParent();
			archivePanel.archiveSelectPanel.setVisible(false);

		}
	};

	public EventHandler<MouseEvent> noEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			// 读取存档 num
			ArchivePanel archivePanel = (ArchivePanel) archiveView.getParent();
			archivePanel.archiveSelectPanel.setVisible(false);
		}
	};

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub

	}

}
