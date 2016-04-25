package view.campsite;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CampsiteItemsWrapper extends Pane{
	
	public CampsiteItemsWrapper(){
		this.setPrefSize(560, 700);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(2.0);
		dropShadow.setOffsetX(0.0);
		dropShadow.setOffsetY(1.0);
		dropShadow.setColor(Color.rgb(0,0,0,0.5));
		 
		this.setId("campsite-items-wrapper");
		Rectangle bgRect = new Rectangle();
		bgRect.setWidth(560);
		bgRect.setHeight(700);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		bgRect.setEffect(dropShadow);
		this.getChildren().add(bgRect);
		
		TilePane tile = new TilePane();
		tile.setVgap(20);
		tile.setHgap(20);
		tile.setPrefColumns(4);
		
		for (int i=0; i<=4; i++){
			for(int j=0; j<=8; j++){
				CampsiteItemView item = new CampsiteItemView(i*100);
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
