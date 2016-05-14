package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.TerritoryPanel;
import view.shop.ShopPanel;

public class ShopHandler {
	private ShopPanel shopPanel;
	
	public ShopHandler(ShopPanel shopPanel){
		this.shopPanel = shopPanel;
	}
	
	public EventHandler<MouseEvent> plusQuantityEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  int quantity= shopPanel.purchasePanel.quantity+1;
	    	  if(quantity>=0){
	    	  shopPanel.purchasePanel.setQuantity(quantity);
	    	  }
	      }
	};
	
	public EventHandler<MouseEvent> minusQuantityEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  int quantity= shopPanel.purchasePanel.quantity-1;
	    	  if(quantity>=0){
	    	  shopPanel.purchasePanel.setQuantity(quantity);
	    	  }
	      }
	}; 
	
	
	public EventHandler<MouseEvent> showBuyPanelEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  shopPanel.getChildren().add(shopPanel.purchasePanel);
	    	  shopPanel.setVisible(true);
	    	  }
	       
	};
	
	public EventHandler<MouseEvent> showSellPanelEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  shopPanel.getChildren().add(shopPanel.sellPanel); 
	    	  shopPanel.setVisible(true);
	    	  }
	      
	};
	 
	public EventHandler<MouseEvent> buyBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryPanel territory = (TerritoryPanel)shopPanel.getParent();
	    	  territory.shopSelectPanel.btnPressed(0);
	      }
	};
	
	public EventHandler<MouseEvent> buyBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryPanel territory = (TerritoryPanel)shopPanel.getParent();
	    	  territory.shopSelectPanel.btnAbled(0);
	      }
	};
	 
	public EventHandler<MouseEvent> sellBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryPanel territory = (TerritoryPanel)shopPanel.getParent();
	    	  territory.shopSelectPanel.btnPressed(1);
	      }
	};
	 
	public EventHandler<MouseEvent> sellBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryPanel territory = (TerritoryPanel)shopPanel.getParent();
	    	  territory.shopSelectPanel.btnAbled(1);
	      }
	};

}
