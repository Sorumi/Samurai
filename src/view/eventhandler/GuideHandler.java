package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.guide.GuideGroup;

public class GuideHandler {

	private GuideGroup guideGroup;
	
	public GuideHandler(GuideGroup guideGroup){
		this.guideGroup = guideGroup;
	}
	
	public EventHandler<MouseEvent> previousBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  guideGroup.setPage(guideGroup.currentPage-1);
	      }
	};
	public EventHandler<MouseEvent> nextBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  guideGroup.setPage(guideGroup.currentPage+1);
	      }
	};
	public EventHandler<MouseEvent> previousBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  guideGroup.btnPressed(0);
	      }
	};
	public EventHandler<MouseEvent> previousBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  guideGroup.btnAbled(0);
	      }
	};
	public EventHandler<MouseEvent> nextBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  guideGroup.btnPressed(1);
	      }
	};
	public EventHandler<MouseEvent> nextBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  guideGroup.btnAbled(1);
	      }
	};
	
}
