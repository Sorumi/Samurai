package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.SelectPanel;

public class SelectHandler {
	private SelectPanel selectPanel;
	
	public SelectHandler(SelectPanel selectPanel){
		this.selectPanel = selectPanel;
	}
	
	public EventHandler<MouseEvent> yesBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  selectPanel.btnPressed(0); 
	      }
	};
	
	public EventHandler<MouseEvent> yesBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  selectPanel.btnAbled(0);
	      }
	};
	
	public EventHandler<MouseEvent> noBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  selectPanel.btnPressed(1); 
	      }
	};
	
	public EventHandler<MouseEvent> noBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  selectPanel.btnAbled(1);
	      }
	};

}
