package view.shop;

import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class ShopItemsWrapper extends Pane{
	private TilePane tile;
	
	public ShopItemsWrapper(){
		
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
		//10这个数字是暂定的，之后根据道具数量改
		for(int i=0;i<10;i++){
			ShopItemView item = new ShopItemView(1);
			tile.getChildren().add(item);
		}
		
		this.getChildren().add(tile);
	}

}
