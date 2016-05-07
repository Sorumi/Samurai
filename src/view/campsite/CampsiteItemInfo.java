package view.campsite;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GameColor;
import view.GameFont;
import view.Images;

public class CampsiteItemInfo extends Pane {

	private Label itemName;
	private Label itemDescription;
	
	private Group weaponState;
	private Label weaponState1;
	private Label weaponState2;
	private Label weaponState3;
	
	public CampsiteItemInfo(){
		this.setPrefSize(500, 230);
		this.setLayoutX(650);
		this.setLayoutY(50);
		this.setId("campsite-wrapper");
		
		itemName = new Label();
		itemName.setLayoutX(40);
		itemName.setLayoutY(40);
		itemName.setId("item-name");
		this.getChildren().add(itemName);
		
		itemDescription = new Label("这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述这是一段很长的描述");
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
		
		//stateIcon
		weaponState = new Group();
		weaponState.setLayoutX(40);
		weaponState.setLayoutY(155);
		
		ImageView weaponStateIcon1 = new ImageView(Images.WEAPON_STATE_1);
		ImageView weaponStateIcon2 = new ImageView(Images.WEAPON_STATE_2);
		ImageView weaponStateIcon3 = new ImageView(Images.WEAPON_STATE_3);
		
		weaponStateIcon1.setFitWidth(40);
		weaponStateIcon2.setFitWidth(54);
		weaponStateIcon3.setFitWidth(40);
		
		weaponStateIcon1.setPreserveRatio(true);
		weaponStateIcon2.setPreserveRatio(true);
		weaponStateIcon3.setPreserveRatio(true);
		
		weaponStateIcon1.setLayoutX(0);
		weaponStateIcon1.setLayoutY(0);
		weaponStateIcon2.setLayoutX(134);
		weaponStateIcon2.setLayoutY(-4);
		weaponStateIcon3.setLayoutX(280);
		weaponStateIcon3.setLayoutY(1);
		
		weaponState1 = new Label("");
		weaponState1.setLayoutX(50);
		weaponState1.setLayoutY(13);
		weaponState1.setId("item-state");
		
		weaponState2 = new Label("");
		weaponState2.setLayoutX(190);
		weaponState2.setLayoutY(13);
		weaponState2.setId("item-state");
		
		weaponState3 = new Label("");
		weaponState3.setLayoutX(330);
		weaponState3.setLayoutY(13);
		weaponState3.setId("item-state");
		
		weaponState.getChildren().addAll(weaponStateIcon1, weaponStateIcon2, weaponStateIcon3, weaponState1, weaponState2, weaponState3);
		weaponState.setVisible(false);
		this.getChildren().add(weaponState);
		
	}
	
	public void setWeaponInfo(int weaponNum, String name, String description, int lowAttackPoint, int highAttackPoint, int criticalRate, int armorPenetration){
		itemName.setText(name);
		itemDescription.setText(description);
		
		weaponState1.setText(lowAttackPoint + " - " + highAttackPoint);
		weaponState2.setText(criticalRate + "");
		weaponState3.setText(armorPenetration + "");
		weaponState.setVisible(true);
		
	}
}
