package view.eventhandler;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.PropOperation;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.game.PropPanel;
import view.game.PropPanel.PropItem;
import view.shop.ShopItemView;

public class PropHandler {

	private PropPanel propPanel;
	private int num;
	private int quantity;
	
	public PropHandler(PropPanel propPanel){
		this.propPanel = propPanel;
	}
	
	public EventHandler<MouseEvent> showPropPanel = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  propPanel.show();
	      }
	};
	
	public EventHandler<MouseEvent> hidePropPanel = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  propPanel.hide();
	      }
	};

	public EventHandler<MouseEvent> itemClickEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			PropItem item = (PropItem) event.getSource();  
			num = item.getNum();
			quantity = item.getQuantity();
			if(quantity > 0){
				OperationQueue.addOperation(new PropOperation(num));
			}
		}
	};

}
