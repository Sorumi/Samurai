package view.shop;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import view.eventhandler.ShopHandler;


public class ShopItemsWrapper extends Pane{
	private TilePane tile;
	
	public ShopItemsWrapper(ShopHandler shopHandler){
		
		this.setPrefSize(560, 560);
		this.setLayoutX(50);
		this.setLayoutY(50);
		this.setId("campsite-wrapper");

		tile = new TilePane();
		tile.setLayoutX(50);
		tile.setLayoutY(52);
		tile.setVgap(20);
		tile.setHgap(20);
		tile.setPrefColumns(4);
		
		for(int i=1;i<=14;i++){
			ShopItemView item = new ShopItemView(i);
			item.setOnMouseEntered(shopHandler.itemEnterEvent);
			item.setOnMouseExited(shopHandler.itemExitEvent);
//			item.setOnMouseClicked(shopHandler.itemClickEvent);
			tile.getChildren().add(item);
		}
		
		this.getChildren().add(tile);
	}

}
