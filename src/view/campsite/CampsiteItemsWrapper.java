package view.campsite;

import java.util.ArrayList;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.po.Weapon;
import view.Images;
import view.eventhandler.CampsiteHandler;
import view.store.StoreItemView;

public class CampsiteItemsWrapper extends Pane{
	
	private CampsiteHandler campsiteHandler;
	
	private TilePane tile;
	
	public CampsiteItemsWrapper(CampsiteHandler campsiteHandler){
		this.campsiteHandler = campsiteHandler;
		
		this.setPrefSize(560, 700);
		this.setLayoutX(50);
		this.setLayoutY(50);
		this.setId("campsite-wrapper");

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
		scroll.setPrefHeight(600);
		this.getChildren().add(scroll);
		
		//TODO
		//增加武器
//		for (int i=0; i<=2; i++){
//			for (int j=1; j<=3; j++){
//				for (int k=1; k<=6; k++){
//					if(Images.WEAPON[i][j][k] != null){
//						CampsiteItemView item = new CampsiteItemView(i*100+j*10+k);
//						item.setOnMouseEntered(campsiteHandler.itemEnterEvent);
//						item.setOnMouseExited(campsiteHandler.itemExitEvent);
//						item.setOnMouseClicked(campsiteHandler.itemClickEvent);
//						tile.getChildren().add(item);
//					}
//				}
//				
//			}
//		}
//		
//		for (int i=3; i<=4; i++){
//			for (int j=1; j<=2; j++){
//				for (int k=1; k<=6; k++){
//					if(Images.WEAPON[i][j][k] != null){
//						CampsiteItemView item = new CampsiteItemView(i*100+j*10+k);
//						item.setOnMouseEntered(campsiteHandler.itemEnterEvent);
//						item.setOnMouseExited(campsiteHandler.itemExitEvent);
//						item.setOnMouseClicked(campsiteHandler.itemClickEvent);
//						tile.getChildren().add(item);
//					}
//				}
//				
//			}
//		}
		

	}
	
	public void updateItem(ArrayList<Weapon> list){
		
		for (Weapon weapon : list){
			int num = weapon.getType();
			if(Images.WEAPON[num/100][num%100/10][num%10] != null){
				CampsiteItemView item = new CampsiteItemView(num, weapon.getNumber());
				item.setOnMouseEntered(campsiteHandler.itemEnterEvent);
				item.setOnMouseExited(campsiteHandler.itemExitEvent);
				item.setOnMouseClicked(campsiteHandler.itemClickEvent);
				tile.getChildren().add(item);
			}				
		}
	}

}
