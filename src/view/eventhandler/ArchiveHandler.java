package view.eventhandler;

import controller.ArchiveController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import musics.Musics;
import view.story.ArchivePanel;
import view.story.ArchiveView;

public class ArchiveHandler {

	private ArchiveView archiveView;
	private ArchiveController archiveController;
	
	public ArchiveHandler(ArchiveView archiveView, int num){
		this.archiveView = archiveView;
		this.archiveController = new ArchiveController();
		this.archiveController.setStoryModel(StoryModel.getStoryModel());
	}
	
	public EventHandler<MouseEvent> loadBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
			  //读取存档 num
	    	  ArchivePanel archivePanel = (ArchivePanel)archiveView.getParent().getParent();
	    	  archivePanel.archiveSelectPanel.archiveSelectHandler.num = archiveView.num;
			  archivePanel.archiveSelectPanel.archiveSelectHandler.setStoryModel();
			  archivePanel.archiveSelectPanel.updateIsSave(false);
			  archivePanel.archiveSelectPanel.setVisible(true);
			  Musics.playEffectMusic(1);
		  }
	};
	
	public EventHandler<MouseEvent> saveBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
			  //保存存档 num
	    	  ArchivePanel archivePanel = (ArchivePanel)archiveView.getParent().getParent();
	    	  archivePanel.archiveSelectPanel.archiveSelectHandler.num = archiveView.num;
	    	  archivePanel.archiveSelectPanel.updateIsSave(true); 
			  archivePanel.archiveSelectPanel.setVisible(true);
			  Musics.playEffectMusic(1);
	      }
	};
	
	public EventHandler<MouseEvent> loadBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnPressed(0);
	      }
	};
	
	public EventHandler<MouseEvent> loadBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnAbled(0);
	      }
	};
	
	public EventHandler<MouseEvent> saveBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnPressed(1);
	      }
	};
	
	public EventHandler<MouseEvent> saveBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnAbled(1);
	      }
	};

	public ArchiveController getArchiveController() {
		return archiveController;
	}
}
