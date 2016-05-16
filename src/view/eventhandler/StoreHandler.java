package view.eventhandler;

import controller.StoreController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Information;
import model.po.PropsInG;
import view.store.StoreItemView;
import view.store.StorePanel;

public class StoreHandler {

	private StorePanel storePanel;
	private StoreController storeController;
	private int num;
	private int quantity; 
	
	public StoreHandler(StorePanel storePanel) {
		this.storePanel = storePanel;
		this.storeController = new StoreController();
		this.storeController.setStoryModel(StoryModel.getStoryModel());
		this.storeController.setPropsStore();

		this.storeController.getAllMaterial();
		this.storeController.getAllProps();

	}

	public void update() {
		storePanel.getItemsPanel().updateItem(storeController.getMaterials());
//		storePanel.getItemsPanel().updateItem(storeController.getProps());
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

	public EventHandler<MouseEvent> itemClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			StoreItemView item = (StoreItemView) event.getSource();

			Information information = storeController.getInformationOfTag(item.getNum() + 800);
			storePanel.infoPanel.updateInfo(information.getTag() - 800, information.getName(),
					information.getDescription());
		}
	};

	public EventHandler<MouseEvent> plusQuantityEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			int quantity = storePanel.sellPanel.quantity + 1;
			if (quantity >= 0) {
				storePanel.sellPanel.setQuantity(quantity);
			}
		}
	};

	public EventHandler<MouseEvent> minusQuantityEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			int quantity = storePanel.sellPanel.quantity - 1;
			if (quantity >= 0) {
				storePanel.sellPanel.setQuantity(quantity);
			}
		}
	};

	// 贩卖按钮
	public EventHandler<MouseEvent> sellBtnClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			quantity = storePanel.sellPanel.getQuantity();
			//要分是卖道具还是卖材料
			//这里的编号要弄弄对
			storeController.getPropsStore().getProps(PropsInG.get7Type(num)).changeNumber(-quantity);
			storeController.getMaterialLibrary().changeItem(num, -quantity);
//			加入加钱的方法
//			storeController.updateMoney(9999);
		}
	};

	public EventHandler<MouseEvent> sellBtnEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			storePanel.sellPanel.sellBtnPressed();
		}
	};

	public EventHandler<MouseEvent> sellBtnExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			storePanel.sellPanel.sellBtnAbled();
		}
	};
}
