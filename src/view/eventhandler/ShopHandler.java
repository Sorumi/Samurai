package view.eventhandler;

import controller.ShopController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import view.TerritoryPanel;
import view.shop.ShopItemView;
import view.shop.ShopPanel;
import view.store.StoreItemView;

public class ShopHandler {
	private ShopPanel shopPanel;
	private ShopController shopController;

	public ShopHandler(ShopPanel shopPanel) {
		this.shopPanel = shopPanel;
		this.shopController = new ShopController();
		this.shopController.setStoryModel(StoryModel.getStoryModel());

		this.shopController.setPropsStore();

		//加入更新钱数的方法
		//this.shopController.getMoney();
		//加入更新道具数量的方法
//		this.shopController
	}

	public EventHandler<MouseEvent> plusQuantityEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			int quantity = shopPanel.purchasePanel.quantity + 1;
			if (quantity >= 0) {
				shopPanel.purchasePanel.setQuantity(quantity);
			}
		}
	};

	public EventHandler<MouseEvent> minusQuantityEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			int quantity = shopPanel.purchasePanel.quantity - 1;
			if (quantity >= 0) {
				shopPanel.purchasePanel.setQuantity(quantity);
			}
		}
	};

	public EventHandler<MouseEvent> itemEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			ShopItemView item = (ShopItemView) event.getSource();
			item.setHighlight();
		}
	};

	public EventHandler<MouseEvent> itemExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			ShopItemView item = (ShopItemView) event.getSource();
			item.setNormal();
		}
	};

	public EventHandler<MouseEvent> itemClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			// TODO
			// 显示价格
		}
	};

	// 购买按钮
	public EventHandler<MouseEvent> buyBtnClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			//TODO
		}
	};
	public EventHandler<MouseEvent> buyBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  shopPanel.purchasePanel.buyBtnPressed();
	      }
	};
	
	public EventHandler<MouseEvent> buyBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  shopPanel.purchasePanel.buyBtnAbled();
	      }
	};

	public ShopController getShopController() {
		return shopController;
	}
}
