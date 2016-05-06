package view.campsite;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
		
		//TODO
		this.updateItem(new int[]{11, 12, 14, 15, 16, 25, 26, 35, 36, 115, 116, 125, 126, 135, 136, 215, 216, 225, 226, 235, 236, 315, 316, 325, 326, 400},
				new int[]{11, 12, 14, 15, 16, 25, 26, 35, 36, 115, 116, 125, 126, 135, 136, 215, 216, 225, 226, 235, 236, 315, 316, 325, 326, 400});
				
		
	}
	
	public void updateItem(int[] nums, int[] quantity){
		
		for (int i=0; i<nums.length; i++){
			int num = nums[i];
			if(Images.WEAPON[num/100][num%100/10][num%10] != null){
				CampsiteItemView item = new CampsiteItemView(num, quantity[i]);
				item.setOnMouseEntered(campsiteHandler.itemEnterEvent);
				item.setOnMouseExited(campsiteHandler.itemExitEvent);
				item.setOnMouseClicked(campsiteHandler.itemClickEvent);
				tile.getChildren().add(item);
			}				
		}
	}

}
