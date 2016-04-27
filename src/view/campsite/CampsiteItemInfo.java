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
		this.setLayoutX(600);
		this.setLayoutY(0);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(2.0);
		dropShadow.setOffsetX(0.0);
		dropShadow.setOffsetY(1.0);
		dropShadow.setColor(Color.rgb(0,0,0,0.5));
		
		Rectangle bgRect = new Rectangle();
		bgRect.setWidth(500);
		bgRect.setHeight(230);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		bgRect.setEffect(dropShadow);
		this.getChildren().add(bgRect);
		
		itemName = new Label("正义裁决");
		itemName.setTextFill(GameColor.getOtherColor(2));
		itemName.setLayoutX(50);
		itemName.setLayoutY(50);
		itemName.setFont(GameFont.C20R);
		itemName.setAlignment(Pos.CENTER_LEFT);
		this.getChildren().add(itemName);
		
		itemDescription = new Label("这是描述的部分");
		itemDescription.setWrapText(true);
		itemDescription.setTextFill(GameColor.getOtherColor(2));
		itemDescription.setLayoutX(50);
		itemDescription.setLayoutY(80);
		itemDescription.setMaxWidth(400);
		itemDescription.setFont(GameFont.C18L);
		itemDescription.setAlignment(Pos.CENTER_LEFT);
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
		weaponStateIcon2.setLayoutX(185);
		weaponStateIcon2.setLayoutY(141);
		weaponStateIcon3.setLayoutX(330);
		weaponStateIcon3.setLayoutY(146);
		
		Label weaponState1 = new Label("100");
		weaponState1.setStyle("-fx-background-color: #dddddd");
		weaponState1.setFont(GameFont.F18);
		weaponState1.setTextFill(GameColor.getOtherColor(2));
		weaponState1.setAlignment(Pos.CENTER_LEFT);
		weaponState1.setLayoutX(100);
		weaponState1.setLayoutY(158);
		
		Label weaponState2 = new Label("100");
		weaponState2.setStyle("-fx-background-color: #dddddd");
		weaponState2.setFont(GameFont.F18);
		weaponState2.setTextFill(GameColor.getOtherColor(2));
		weaponState2.setAlignment(Pos.CENTER_LEFT);
		weaponState2.setLayoutX(240);
		weaponState2.setLayoutY(158);
		
		Label weaponState3 = new Label("100");
		weaponState3.setStyle("-fx-background-color: #dddddd");
		weaponState3.setFont(GameFont.F18);
		weaponState3.setTextFill(GameColor.getOtherColor(2));
		weaponState3.setAlignment(Pos.CENTER_LEFT);
		weaponState3.setLayoutX(380);
		weaponState3.setLayoutY(158);
		
		
		weaponState.getChildren().addAll(weaponStateIcon1, weaponStateIcon2, weaponStateIcon3, weaponState1, weaponState2, weaponState3);
		this.getChildren().add(weaponState);
		
	}
}
