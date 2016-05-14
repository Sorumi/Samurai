package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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

}
