package view.campsite;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
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
		itemName.setLayoutX(50);
		itemName.setLayoutY(50);
		itemName.setId("item-name");
		this.getChildren().add(itemName);
		
		itemDescription = new Label();
		itemDescription.setLayoutX(50);
		itemDescription.setLayoutY(80);
		itemDescription.setMaxWidth(400);
		itemDescription.setMaxHeight(60);
		itemDescription.setId("item-description");
		this.getChildren().add(itemDescription);
		
		//stateIcon
		weaponState = new Group();
		ImageView weaponStateIcon1 = new ImageView(Images.WEAPON_STATE_1);
		ImageView weaponStateIcon2 = new ImageView(Images.WEAPON_STATE_2);
		ImageView weaponStateIcon3 = new ImageView(Images.WEAPON_STATE_3);
		
		weaponStateIcon1.setFitWidth(40);
		weaponStateIcon2.setFitWidth(54);
		weaponStateIcon3.setFitWidth(40);
		
		weaponStateIcon1.setPreserveRatio(true);
		weaponStateIcon2.setPreserveRatio(true);
		weaponStateIcon3.setPreserveRatio(true);
		
		weaponStateIcon1.setLayoutX(50);
		weaponStateIcon1.setLayoutY(145);
		weaponStateIcon2.setLayoutX(184);
		weaponStateIcon2.setLayoutY(141);
		weaponStateIcon3.setLayoutX(330);
		weaponStateIcon3.setLayoutY(146);
		
		weaponState1 = new Label("100");
		weaponState1.setLayoutX(100);
		weaponState1.setLayoutY(158);
		weaponState1.setId("item-state");
		
		weaponState2 = new Label("100");
		weaponState2.setLayoutX(240);
		weaponState2.setLayoutY(158);
		weaponState2.setId("item-state");
		
		weaponState3 = new Label("100");
		weaponState3.setLayoutX(380);
		weaponState3.setLayoutY(158);
		weaponState3.setId("item-state");
		
		weaponState.getChildren().addAll(weaponStateIcon1, weaponStateIcon2, weaponStateIcon3, weaponState1, weaponState2, weaponState3);
		this.getChildren().add(weaponState);
		
	}
	
	public void setInfo(int num, String name, String description){
		itemName.setText(name);
		itemDescription.setText(description);
	}
}
