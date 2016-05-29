package view.store;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import view.GameColor;

public class StoreItemInfo extends Pane{
	
	private Label itemName;
	private Label itemDescription;
	private Label levelLable;
	
	public StoreItemInfo(){
		this.setPrefSize(500, 180);
		this.setLayoutX(650);
		this.setLayoutY(50);
		this.setId("store-wrapper"); 
		
		itemName = new Label("");
		itemName.setLayoutX(40);
		itemName.setLayoutY(40);
		itemName.setId("item-name");
		this.getChildren().add(itemName);
		
		itemDescription = new Label();
		itemDescription.setMaxWidth(400);
		itemDescription.setId("item-description");
		
		ScrollPane descriptionScroll = new ScrollPane(itemDescription);
		descriptionScroll.getStyleClass().add("edge-to-edge"); 
		descriptionScroll.setStyle("-fx-background-color: transparent;"
				+ "-fx-control-inner-background: transparent;");
		descriptionScroll.setLayoutX(40);
		descriptionScroll.setLayoutY(70);
		descriptionScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		descriptionScroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		descriptionScroll.setPrefWidth(430);
		descriptionScroll.setPrefHeight(70);
		this.getChildren().add(descriptionScroll);
		
		levelLable = new Label("");
		levelLable.setPrefSize(50, 20);
		levelLable.setLayoutX(180);
		levelLable.setLayoutY(42);
		levelLable.setId("material-levelLable");
		this.getChildren().add(levelLable);
		
	}

	public void updateMaterialInfo(int itemNum, String itemName, String itemDescription){
		this.itemName.setText(itemName);
		this.itemDescription.setText(itemDescription);
		switch(itemNum%10){
		case 0:
		case 1:
			this.levelLable.setText("普通");break;
		case 2:
			this.levelLable.setText("稀有");break;
		case 3:
			this.levelLable.setText("史诗");break;
		}
		this.levelLable.setStyle("-fx-background-color: " + GameColor.getMaterialColorString(itemNum%10) + ";"
			+ "-fx-text-fill: " + GameColor.getMaterialColorString(itemNum%10+4) );
		levelLable.setVisible(true);
	}
	
	public void updatePropInfo(int itemNum, String itemName, String itemDescription){
		this.itemName.setText(itemName);
		this.itemDescription.setText(itemDescription);
		levelLable.setVisible(false);
	}
}
