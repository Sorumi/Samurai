package view.shop;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.DoubleSelectPanel;
import view.SystemButton;
import view.eventhandler.MenuHandler;
import view.eventhandler.ShopHandler;

public class ShopSelectPanel extends Pane{
	private SystemButton closeBtn;
	
	public Button buyBtn;
	public Button sellBtn;

	public ShopSelectPanel(ShopHandler shopHandler) {  
		this.setPrefSize(300, 220);
		this.setLayoutX(450);
		this.setLayoutY(300);
		this.setId("archive-view");

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(275);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ShopSelectPanel.this.setVisible(false);
			}
		});
		this.getChildren().add(closeBtn);
		
		buyBtn = new Button("购买道具");
		buyBtn.setPrefSize(160, 40);
		buyBtn.setLayoutX(70);
		buyBtn.setLayoutY(72);
		buyBtn.setId("Aload-btn");
		buyBtn.setOnMouseEntered(shopHandler.buyBtnEnterEvent);
		buyBtn.setOnMouseExited(shopHandler.buyBtnExitEvent); 
		buyBtn.setOnMouseClicked(shopHandler.showBuyPanelEvent); 
		
		sellBtn = new Button("出售材料");
		sellBtn.setPrefSize(160, 40);
		sellBtn.setLayoutX(70);
		sellBtn.setLayoutY(142);
		sellBtn.setId("Asave-btn");
		sellBtn.setOnMouseEntered(shopHandler.sellBtnEnterEvent);
		sellBtn.setOnMouseExited(shopHandler.sellBtnExitEvent); 
		sellBtn.setOnMouseClicked(shopHandler.showSellPanelEvent);
		btnAbled(0);
		btnAbled(1);
		
		this.getChildren().addAll(buyBtn, sellBtn);
		this.setVisible(true); 
		
	}

	public void btnPressed(int num) {
		if(num == 0){
			buyBtn.setLayoutY(76); 
			buyBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		}else{
			sellBtn.setLayoutY(146);  
			sellBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if(num == 0){
			buyBtn.setLayoutY(72);
			buyBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		}else{
			sellBtn.setLayoutY(142);  
			sellBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}

}
