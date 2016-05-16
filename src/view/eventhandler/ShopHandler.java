package view.eventhandler;

import controller.ShopController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Information;
import model.po.PropsInG;
import model.po.Weapon;
import view.TerritoryPanel;
import view.campsite.CampsiteItemView;
import view.shop.ShopItemView;
import view.shop.ShopPanel;
import view.store.StoreItemView;

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

		// 加入初始化钱数的方法
		// this.shopController.getMoney();
		// 加入更新道具数量的方法
		// this.shopController
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
			ShopItemView item = (ShopItemView) event.getSource();
			num = item.getNum();

			Information information = shopController.getInformationOfTag(item.getNum() + 700);
			shopPanel.infoPanel.updatePropInfo(information.getTag() - 700, information.getName(),
					information.getDescription());
			// TODO 价格！！！
			shopPanel.purchasePanel.setQuantity(0);
		}
	};

	// 购买按钮
	public EventHandler<MouseEvent> buyBtnClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			quantity = shopPanel.purchasePanel.getQuantity();
			getShopController().getPropsStore().getProps(PropsInG.get7Type(num)).changeNumber(quantity);
			// 加入扣钱的方法
			// getShopController().updateMoney(9999);
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
