package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.campsite.CampsiteItemView;

public class CampsiteHandler {

	public EventHandler<MouseEvent> itemEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  CampsiteItemView item = (CampsiteItemView) event.getSource();
	    	  item.setHighlight();
	      }
	};
	
	public EventHandler<MouseEvent> itemExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  CampsiteItemView item = (CampsiteItemView) event.getSource();
	    	  item.setNormal();
	      }
	};
}
