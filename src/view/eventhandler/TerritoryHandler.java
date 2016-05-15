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
import view.shop.ShopSelectPanel;
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
//		if(territoryController.getArmorOfSamurai(1).getType() == null){
//			System.out.print("null!!!!!");
//		}
		territoryPanel.samurai1.setArmor(territoryController.getArmorOfSamurai(1).getType()-900);
		territoryPanel.samurai2.setArmor(territoryController.getArmorOfSamurai(2).getType()-900);
		territoryPanel.samurai3.setArmor(territoryController.getArmorOfSamurai(3).getType()-900);
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
	    	  territoryPanel.setSamuraiAnimation(false);
	    	  territoryPanel.territoryBg.removeAll();
	    	  territoryPanel.territoryFg.removeAll();
	      }
	}; 
	
	public EventHandler<MouseEvent> shopSelectEvent = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.shopSelectPanel.setVisible(true);
	      }
	};
	
	public EventHandler<MouseEvent> archiveEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.setBlur(true);
	    	  territoryPanel.archivePanel = new ArchivePanel(0);
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

	public EventHandler<MouseEvent> buyBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.shopSelectPanel.btnPressed(0);
	      }
	};
	
	public EventHandler<MouseEvent> buyBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.shopSelectPanel.btnAbled(0);
	      }
	};
	 
	public EventHandler<MouseEvent> sellBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.shopSelectPanel.btnPressed(1);
	      }
	};
	 
	public EventHandler<MouseEvent> sellBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.shopSelectPanel.btnAbled(1);
	      }
	};
	
	public EventHandler<MouseEvent> showBuyPanelEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.shopPanel = new ShopPanel();
	    	  territoryPanel.getChildren().add(territoryPanel.shopPanel);
	    	  territoryPanel.shopSelectPanel.setVisible(false);
	    	  }
	       
	};
	
//	public EventHandler<MouseEvent> showSellPanelEvent = new EventHandler<MouseEvent>() {  
//	      public void handle(MouseEvent event) {
//	    	  shopPanel.getChildren().add(shopPanel.sellPanel); 
//	    	  shopPanel.setVisible(true);
//	          territoryPanel.shopSelectPanel.setVisible(false);
//	    	  }
//	      
//	};
	public TerritoryController getTerritoryController(){
		return this.territoryController;
	}

}
