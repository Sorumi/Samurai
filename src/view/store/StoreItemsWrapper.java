package view.store;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import view.Images;
import view.campsite.CampsiteItemView;
import view.eventhandler.StoreHandler;


public class StoreItemsWrapper extends Pane{
	
	public StoreItemsWrapper(StoreHandler storeHandler){
		this.setPrefSize(560, 560);
		this.setLayoutX(50);
		this.setLayoutY(50);
		this.setId("store-wrapper");
		
		TilePane tile = new TilePane();
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
		
		for (int i=0; i<=3; i++){
			for (int j=0; j<=3; j++){
				if(Images.MATERIAL[i][j] != null){
					StoreItemView item = new StoreItemView(i*10+j);
					item.setOnMouseEntered(storeHandler.itemEnterEvent);
					item.setOnMouseExited(storeHandler.itemExitEvent);
	//				item.setOnMouseClicked(storeHandler.itemClickEvent);
					tile.getChildren().add(item);
				}				
			}
		}
		
		for (int j=0; j<=3; j++){
			StoreItemView item = new StoreItemView(4*10+j);
			item.setOnMouseEntered(storeHandler.itemEnterEvent);
			item.setOnMouseExited(storeHandler.itemExitEvent);
//			item.setOnMouseClicked(campsiteHandler.itemClickEvent);
			tile.getChildren().add(item);
		}
			
		

	}
	

}
