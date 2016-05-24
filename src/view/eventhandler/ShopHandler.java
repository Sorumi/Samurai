package view.eventhandler;

import controller.ShopController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Information;
import model.po.PropsInG;
import musics.Musics;
import view.TerritoryPanel;
import view.shop.ShopItemView;
import view.shop.ShopPanel;

public class ShopHandler {
	private ShopPanel shopPanel;
	private ShopController shopController;
	private int num;
	private int quantity;

	public ShopHandler(ShopPanel shopPanel) {
		this.shopPanel = shopPanel;
		this.shopController = new ShopController();
		this.shopController.setStoryModel(StoryModel.getStoryModel());
		this.shopController.setPropsStore();
	}

	public EventHandler<MouseEvent> plusQuantityEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			int quantity = shopPanel.purchasePanel.quantity + 1;
			int total = (shopController.getPropsStore().getProps(num).getPrice()) * quantity;
			if (total < getShopController().getPropsStore().getMoney()) {
				shopPanel.purchasePanel.setQuantity(quantity);
			}
		}
	};

	public EventHandler<MouseEvent> minusQuantityEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			int quantity = shopPanel.purchasePanel.quantity - 1;
			if (quantity > 0) {
				shopPanel.purchasePanel.buyBtnAbled();
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
			ShopItemView item = (ShopItemView) event.getSource();
			num = PropsInG.get7Type(item.getNum());

			Information information = shopController.getInformationOfTag(num);
			shopPanel.infoPanel.updatePropInfo(information.getTag(), information.getName(),
					information.getDescription());
			shopPanel.purchasePanel.setPrice(shopController.getPropsStore().getProps(num).getPrice());
			shopPanel.purchasePanel.setQuantity(1);

			int total = shopController.getPropsStore().getProps(num).getPrice();
			if (total > getShopController().getPropsStore().getMoney()) {
				shopPanel.purchasePanel.buyBtnUnable();
			} else {
				shopPanel.purchasePanel.buyBtnAbled();
			}
			Musics.playEffectMusic(1);
		}
	};

	// 购买按钮
	public EventHandler<MouseEvent> buyBtnClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			quantity = shopPanel.purchasePanel.getQuantity();

			int total = (shopController.getPropsStore().getProps(num).getPrice()) * quantity;
			if (total > getShopController().getPropsStore().getMoney()) {
				System.out.println("You money isn't enough.");
			}else {
				getShopController().getPropsStore().getProps(num).changeNumber(quantity);
				getShopController().updateMoney(-total);
				TerritoryPanel parent = (TerritoryPanel) shopPanel.getParent();
				parent.updateMoney();
				shopPanel.successPanel.setVisible(true);
				//add
				shopPanel.purchasePanel.setQuantity(1);
				total = shopController.getPropsStore().getProps(num).getPrice();
				if (total > getShopController().getPropsStore().getMoney()) {
					shopPanel.purchasePanel.buyBtnUnable();
				}
			}
			Musics.playEffectMusic(1);
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

	public int getQuantity() {
		return quantity;
	}

	public int getNum() {
		return num;
	}
}
