package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.ArchiveView;

public class ArchiveHandler {

	private ArchiveView archiveView;
	private int num;
	
	public ArchiveHandler(ArchiveView archiveView, int num){
		this.archiveView = archiveView;
		this.num = num;
	}
	
	public EventHandler<MouseEvent> loadBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  //读取存档 num
	      }
	};
	
	public EventHandler<MouseEvent> saveBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  //保存存档 num
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

}
