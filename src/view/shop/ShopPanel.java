package view.shop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import view.SuccessPanel;
import view.SystemButton;
import view.TerritoryPanel;
import view.campsite.CampsitePanel;
import view.eventhandler.ShopHandler;
import view.eventhandler.SuccessHandler;


public class ShopPanel extends Pane{
	private ShopItemsWrapper itemsPanel; 
	public ShopItemInfo infoPanel; 
	public ShopItemPurchase purchasePanel;
	private SystemButton closeBtn;  
	public SuccessPanel successPanel;
	public ShopHandler shopHandler;
//	public SuccessHandler successHandler;
	public ShopPanel(){
		this.setPrefSize(1200, 800);
		this.shopHandler = new ShopHandler(this);
		
		itemsPanel = new ShopItemsWrapper(shopHandler);
		infoPanel = new ShopItemInfo();
		purchasePanel = new ShopItemPurchase(shopHandler); 
		successPanel = new SuccessPanel("购买成功！");
		successPanel.setVisible(false);

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel parent =  (TerritoryPanel) ShopPanel.this.getParent();
				parent.getChildren().remove(ShopPanel.this); 
				parent.setBlur(false);
			}
		});
		
		this.getChildren().addAll(itemsPanel, infoPanel, purchasePanel, closeBtn, successPanel);
		
		
//		this.setVisible(false);
	}

}
