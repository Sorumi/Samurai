package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.campsite.CampsiteItemView;
import view.store.StoreItemView;
import view.store.StorePanel;

public class StoreHandler {
	
	private StorePanel storePanel;
	
	public StoreHandler(StorePanel storePanel){
		this.storePanel = storePanel;
		
		
	}
	
	public EventHandler<MouseEvent> itemEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  StoreItemView item = (StoreItemView) event.getSource(); 
	    	  item.setHighlight();
	      }
	};
	
	public EventHandler<MouseEvent> itemExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  StoreItemView item = (StoreItemView) event.getSource();
	    	  item.setNormal();
	      }
	};

}
