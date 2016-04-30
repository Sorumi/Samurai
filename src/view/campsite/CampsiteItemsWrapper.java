package view.campsite;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.eventhandler.CampsiteHandler;

public class CampsiteItemsWrapper extends Pane{
	
	public CampsiteItemsWrapper(CampsiteHandler campsiteHandler){
		this.setPrefSize(560, 700);
		this.setLayoutX(50);
		this.setLayoutY(50);
		this.setId("campsite-wrapper");

		TilePane tile = new TilePane();
		tile.setVgap(20);
		tile.setHgap(20);
		tile.setPrefColumns(4);
		
		for (int i=0; i<=4; i++){
			for(int j=0; j<=6; j++){
				CampsiteItemView item = new CampsiteItemView(i*100);
				item.setOnMouseEntered(campsiteHandler.itemEnterEvent);
				item.setOnMouseExited(campsiteHandler.itemExitEvent);
				tile.getChildren().add(item);
			}
		}
		
		ScrollPane scroll = new ScrollPane(tile);
		scroll.getStyleClass().add("edge-to-edge"); 
		scroll.setStyle("-fx-background-color: transparent;"
				+ "-fx-control-inner-background: transparent;");
		scroll.setLayoutX(50);
		scroll.setLayoutY(50);
		scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
		scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scroll.setPrefWidth(500);
		scroll.setPrefHeight(600);
		this.getChildren().add(scroll);
	}

}
