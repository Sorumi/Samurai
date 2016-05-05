package view.store;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class StoreItemInfo extends Pane{
	
	private Label itemName;
	private Label itemDescription;
	private Label levelLable;
	
	public StoreItemInfo(){
		this.setPrefSize(500, 180);
		this.setLayoutX(650);
		this.setLayoutY(50);
		this.setId("store-wrapper"); 
		
		itemName = new Label("雪山云杉");
		itemName.setLayoutX(50);
		itemName.setLayoutY(50);
		itemName.setId("item-name");
		this.getChildren().add(itemName);
		
		itemDescription = new Label("确定这是描述的部分这是描述的部分这是描述的部分这是描述的部分这是描述的部分这是描述的部分这是描述的部分这是描述的部分这是描述的部分这是描述的部分这是描述的部分");
		itemDescription.setLayoutX(50);
		itemDescription.setLayoutY(80);
		itemDescription.setMaxWidth(400);
		itemDescription.setMaxHeight(60);
		itemDescription.setId("item-description");
		this.getChildren().add(itemDescription);
		
		levelLable = new Label("稀有");
		levelLable.setPrefSize(50, 20);
		levelLable.setLayoutX(180);
		levelLable.setLayoutY(50);
		levelLable.setId("material-levelLable");
		this.getChildren().add(levelLable);
	}

}
