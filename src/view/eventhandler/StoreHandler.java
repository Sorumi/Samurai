package view.eventhandler;

import controller.StoreController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import view.campsite.CampsiteItemView;
import view.store.StoreItemView;
import view.store.StorePanel;

public class StoreHandler {
	
	private StorePanel storePanel;
	private StoreController storeController;
	
	public StoreHandler(StorePanel storePanel){
		this.storePanel = storePanel;
		this.storeController = new StoreController();
		this.storeController.setStoryModel(StoryModel.getStoryModel());

		//加入更新 Panel 数量的方法


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
