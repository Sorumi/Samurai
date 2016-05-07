package view.store;

import java.util.ArrayList;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import model.po.Material;
import view.Images;
import view.campsite.CampsiteItemView;
import view.eventhandler.StoreHandler;


public class StoreItemsWrapper extends Pane{
	
	private StoreHandler storeHandler;
	private TilePane tile;
	
	public StoreItemsWrapper(StoreHandler storeHandler){
		this.storeHandler = storeHandler;
		
		this.setPrefSize(560, 560);
		this.setLayoutX(50);
		this.setLayoutY(50);
		this.setId("store-wrapper");
		
		tile = new TilePane();
		tile.setVgap(20);
		tile.setHgap(20);
		tile.setPrefColumns(4);
		
		ScrollPane scroll = new ScrollPane(tile);
		scroll.getStyleClass().add("edge-to-edge"); 
		scroll.setStyle("-fx-background-color: transparent;"
				+ "-fx-control-inner-background: transparent;");
		scroll.setLayoutX(50);
		scroll.setLayoutY(50);
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setPrefWidth(500);
		scroll.setPrefHeight(460);
		this.getChildren().add(scroll);
		
		//TODO
//		this.updateItem(new int[]{0, 2, 11, 13, 20, 31, 42}, new int[]{2, 3, 5, 4, 1, 4, 6});
		
	}
	
	public void updateItem(ArrayList<Material> list){
		
		for (Material materail : list){
			int num = materail.getType()-800;
			if(Images.MATERIAL[num/10][num%10] != null){
				StoreItemView item = new StoreItemView(num, materail.getNumer());
				item.setOnMouseEntered(storeHandler.itemEnterEvent);
				item.setOnMouseExited(storeHandler.itemExitEvent);
//				item.setOnMouseClicked(storeHandler.itemClickEvent);
				tile.getChildren().add(item);
			}				
		}
	}

}
