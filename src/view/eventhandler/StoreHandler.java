package view.eventhandler;

import controller.StoreController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Information;
import model.po.PropsInG;
import view.TerritoryPanel;
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
		storePanel.getItemsPanel().updateMaterial(storeController.getMaterials());
		storePanel.getItemsPanel().updateProp(storeController.getProps());
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
			if (item.getNum() / 100 != 7) {
				Information information = storeController.getInformationOfTag(item.getNum() + 800);
				storePanel.infoPanel.updateMaterialInfo(information.getTag() - 800, information.getName(),
						information.getDescription());
			}else{
//				Information information = storeController.getInformationOfTag(item.getNum() + 700);
//				storePanel.infoPanel.updatePropInfo(information.getTag() - 700, information.getName(),
//						information.getDescription());
			}
			if(storePanel.sellPanel != null){
				num = item.getNum();
				storePanel.sellPanel.setQuantity(0);
				storePanel.sellPanel.quantityTotal = item.quantity;
			}
			
		}
	};

	public EventHandler<MouseEvent> plusQuantityEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			int quantity = storePanel.sellPanel.quantity + 1;
			if (quantity >= 0 && quantity<=storePanel.sellPanel.quantityTotal) {
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
			System.out.println("N  " + num);
			if(num > 800){
				storeController.getMaterialLibrary().changeItem(num, -quantity);
				//材料暂时不能卖
			}else{
				storeController.getPropsStore().getProps(num).changeNumber(-quantity);
				storeController.updateMoney((int)(0.6 * storeController.getPropsStore().getProps(num).getPrice()) * quantity);
			}
			TerritoryPanel parent = (TerritoryPanel) storePanel.getParent();
			parent.updateMoney();
			update();
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
	
	public int getQuantity() {
		return quantity;
	}

	public int getNum() {
		return num;
	}
}
