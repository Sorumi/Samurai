package view.eventhandler;

import controller.TerritoryController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import view.MapPanel;
import view.TerritoryPanel;
import view.TerritoryPanel.TerritoryButton;
import view.campsite.CampsitePanel;
import view.smithy.SmithyPanel;
import view.store.StorePanel;

public class TerritoryHandler {
	
	private TerritoryPanel territoryPanel;
	private TerritoryController territoryController;

//	DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.WHITE, 0, 1, 0, 0);
//	ColorAdjust light = new ColorAdjust();
	  
	public TerritoryHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
		this.territoryController = new TerritoryController(); 

		this.territoryController.setStoryModel(StoryModel.getStoryModel());

		//在这里可以获取武器
		this.territoryController.getWeaponOfSamurai(1);
	}
	
	public EventHandler<MouseEvent> campsiteEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.campsitePanel = new CampsitePanel();
	    	  territoryPanel.getChildren().add(territoryPanel.campsitePanel);
	      }
	};
	
	public EventHandler<MouseEvent> smithyEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.smithyPanel = new SmithyPanel();
	    	  territoryPanel.getChildren().add(territoryPanel.smithyPanel);
	      }
	};
	
	public EventHandler<MouseEvent> flagEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.mapPanel = new MapPanel();
	    	  territoryPanel.getChildren().add(territoryPanel.mapPanel);
	      }
	};
	
	public EventHandler<MouseEvent> storeEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.storePanel = new StorePanel();
	    	  territoryPanel.getChildren().add(territoryPanel.storePanel);
	      }
	};
	
	public EventHandler<MouseEvent> buttonEnterEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryButton btn = (TerritoryButton) event.getSource();
	    	  btn.setHighlight();
	      }
	};
	
	public EventHandler<MouseEvent> buttonExitEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryButton btn = (TerritoryButton) event.getSource();
	    	  btn.setNormal();
	      }
	};

	public TerritoryController getTerritoryController(){
		return this.territoryController;
	}

}
