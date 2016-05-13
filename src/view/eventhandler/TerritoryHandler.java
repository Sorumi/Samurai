package view.eventhandler;

import controller.TerritoryController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import view.ArchivePanel;
import view.MapPanel;
import view.StoryPanel;
import view.TerritoryPanel;
import view.TerritoryPanel.TerritoryButton;
import view.campsite.CampsitePanel;
import view.shop.ShopPanel;
import view.smithy.SmithyPanel;
import view.store.StorePanel;

public class TerritoryHandler {
	
	private TerritoryPanel territoryPanel;
	private TerritoryController territoryController;
	  
	public TerritoryHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
		this.territoryController = TerritoryController.territoryController();

		this.territoryController.setStoryModel(StoryModel.getStoryModel());

		//在这里可以获取武器
//		this.territoryController.getWeaponOfSamurai(1);
	}
	
	public void updateSamurai(){
		territoryPanel.samurai1.setWeapon(territoryController.getWeaponOfSamurai(1).getType());
		territoryPanel.samurai2.setWeapon(territoryController.getWeaponOfSamurai(2).getType());
		territoryPanel.samurai3.setWeapon(territoryController.getWeaponOfSamurai(3).getType());
	}
	
	public EventHandler<MouseEvent> campsiteEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.campsitePanel = new CampsitePanel();
	    	  territoryPanel.getChildren().add(territoryPanel.campsitePanel);
	      }
	};
	
	public EventHandler<MouseEvent> smithyEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.smithyPanel = new SmithyPanel();
	    	  territoryPanel.getChildren().add(territoryPanel.smithyPanel);
	      }
	};
	
	public EventHandler<MouseEvent> flagEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  StoryPanel parent = (StoryPanel) territoryPanel.getParent();
	    	  parent.mapPanel.toFront();
	    	  territoryPanel.territoryBg.stopAll();
	      }
	};
	
	public EventHandler<MouseEvent> shopEvent = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.shopPanel = new ShopPanel();
	    	  territoryPanel.getChildren().add(territoryPanel.shopPanel); 
	      }
	};
	
	public EventHandler<MouseEvent> archiveEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.archivePanel = new ArchivePanel();
	    	  territoryPanel.archivePanel.setLayoutX(350);
	    	  territoryPanel.archivePanel.setLayoutY(50);
	    	  territoryPanel.getChildren().add(territoryPanel.archivePanel);
	      }
	};
	
	public EventHandler<MouseEvent> storeEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.storePanel = new StorePanel();
	    	  territoryPanel.getChildren().add(territoryPanel.storePanel);
	      }
	};
	
	public EventHandler<MouseEvent> buttonEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryButton btn = (TerritoryButton) event.getSource();
	    	  btn.setHighlight();
	      }
	};
	
	public EventHandler<MouseEvent> buttonExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryButton btn = (TerritoryButton) event.getSource();
	    	  btn.setNormal();
	      }
	};

	public TerritoryController getTerritoryController(){
		return this.territoryController;
	}

}
