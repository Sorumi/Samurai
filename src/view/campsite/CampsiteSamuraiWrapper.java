package view.campsite;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.Images;
import view.SamuraiView;

public class CampsiteSamuraiWrapper extends Pane {

	private SamuraiView samurai;
	private Group samuraiBtns;
	private Button samuraiBtn1;
	private Button samuraiBtn2;
	private Button samuraiBtn3;
	
	public CampsiteSamuraiWrapper(){
		this.setPrefSize(500, 430);
		this.setLayoutX(600);
		this.setLayoutY(270);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(2.0);
		dropShadow.setOffsetX(0.0);
		dropShadow.setOffsetY(1.0);
		dropShadow.setColor(Color.rgb(0,0,0,0.5));
		
		Rectangle bgRect = new Rectangle();
		bgRect.setWidth(500);
		bgRect.setHeight(430);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		bgRect.setEffect(dropShadow);
		this.getChildren().add(bgRect);
		
		samurai = new SamuraiView(1, 3);//TODO default
		samurai.setLayoutX(40);
		samurai.setLayoutY(50);
		this.getChildren().add(samurai);
		
		samuraiBtns = new Group();
		samuraiBtns.setLayoutX(280);
		samuraiBtns.setLayoutY(30);
		
		ImageView btnV1 = new ImageView(Images.SAMURAI_BTN_1);
		btnV1.setFitWidth(52);
		btnV1.setPreserveRatio(true);
		ImageView btnV2 = new ImageView(Images.SAMURAI_BTN_2);
		btnV2.setFitWidth(52);
		btnV2.setPreserveRatio(true);
		ImageView btnV3 = new ImageView(Images.SAMURAI_BTN_3);
		btnV3.setFitWidth(52);
		btnV3.setPreserveRatio(true);
		
		samuraiBtn1 = new Button();
		samuraiBtn1.setGraphic(btnV1);
		samuraiBtn1.setLayoutX(0);
		samuraiBtn1.setLayoutY(0);
		
		samuraiBtn2 = new Button();
		samuraiBtn2.setGraphic(btnV2);
		samuraiBtn2.setLayoutX(70);
		samuraiBtn2.setLayoutY(0);
		
		samuraiBtn3 = new Button();
		samuraiBtn3.setGraphic(btnV3);
		samuraiBtn3.setLayoutX(0);
		samuraiBtn3.setLayoutY(140);
		
		samuraiBtns.getChildren().addAll(samuraiBtn1, samuraiBtn2, samuraiBtn3);
		this.getChildren().add(samuraiBtns);
	}
}
