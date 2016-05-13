package view.shop;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ShopItemInfo extends Pane {
	private Label itemName;
	private Label itemDescription;
	
	public ShopItemInfo(){
		this.setPrefSize(500, 180);
		this.setLayoutX(650);
		this.setLayoutY(50);
		this.setId("campsite-wrapper");
		
		itemName = new Label("大起大落");
		itemName.setLayoutX(50);
		itemName.setLayoutY(50);
		itemName.setId("item-name");
		this.getChildren().add(itemName);
		
		itemDescription = new Label("描述");
		itemDescription.setMaxWidth(400);
		itemDescription.setLayoutX(50);
		itemDescription.setLayoutY(90);
		itemDescription.setId("item-description");
		this.getChildren().add(itemDescription);
	}

}
