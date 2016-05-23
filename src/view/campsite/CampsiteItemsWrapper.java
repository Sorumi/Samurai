package view.campsite;

import java.util.ArrayList;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.po.Armor;
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

	}
	
	public void clearAll(){
		tile.getChildren().clear();
	}
	
	public void updateWeapon(ArrayList<Weapon> list){
		
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
	
	public void updateArmor(ArrayList<Armor> list){
		
		for (Armor armor : list){
			int num9 = armor.getType();
			int num = (num9-900)*10;
			if(Images.ARMOR[num/100][num%100/10]!= null){
				CampsiteItemView item = new CampsiteItemView(num9, armor.getNumber());
				item.setOnMouseEntered(campsiteHandler.itemEnterEvent);
				item.setOnMouseExited(campsiteHandler.itemExitEvent);
				item.setOnMouseClicked(campsiteHandler.itemClickEvent);
				tile.getChildren().add(item);
			}				
		}
	}

}
