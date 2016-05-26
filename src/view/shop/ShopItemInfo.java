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
		
		itemName = new Label("");
		itemName.setLayoutX(40);
		itemName.setLayoutY(40);
		itemName.setId("item-name");
		this.getChildren().add(itemName);
		
		itemDescription = new Label("");
		itemDescription.setMaxWidth(400);
		itemDescription.setLayoutX(40);
		itemDescription.setLayoutY(70);
		itemDescription.setId("item-description");
		this.getChildren().add(itemDescription);
	}

	public void updatePropInfo(int num, String name, String description) {
		this.itemName.setText(name);
		this.itemDescription.setText(description);
	}

}
