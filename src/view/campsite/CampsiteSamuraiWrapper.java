package view.campsite;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.Images;
import view.SamuraiView;
import view.eventhandler.CampsiteHandler;

public class CampsiteSamuraiWrapper extends Pane {

	private CampsiteHandler campsiteHandler;
	
	private SamuraiView samurai;
	private Group samuraiBtns;
	private SamuraiButton samuraiBtn1;
	private SamuraiButton samuraiBtn2;
	private SamuraiButton samuraiBtn3;
	
	public CampsiteSamuraiWrapper(CampsiteHandler campsiteHandler){
		this.campsiteHandler = campsiteHandler;
		
		this.setPrefSize(500, 430);
		this.setLayoutX(650);
		this.setLayoutY(320);
		this.setId("campsite-wrapper");
		
		samurai = new SamuraiView(1, 3);//TODO default
		samurai.setLayoutX(30);
		samurai.setLayoutY(60);
		this.getChildren().add(samurai);
		
		samuraiBtns = new Group();
		samuraiBtns.setLayoutX(280);
		samuraiBtns.setLayoutY(30);
		
		samuraiBtn1 = new SamuraiButton(1);
		samuraiBtn2 = new SamuraiButton(2);
		samuraiBtn3 = new SamuraiButton(3);
		
		samuraiBtns.getChildren().addAll(samuraiBtn1, samuraiBtn2, samuraiBtn3);
		this.getChildren().add(samuraiBtns);
	}
	
	public class SamuraiButton extends Button{
		public int num;
		public SamuraiButton(int num){
			this.num = num;
			ImageView btnV = new ImageView(Images.SAMURAI_BTN[num]);
			btnV.setFitWidth(52);
			btnV.setPreserveRatio(true);
			this.setGraphic(btnV);
			this.setLayoutX(70*(num-1));
			this.setLayoutY(0);
			this.setOnMouseClicked(campsiteHandler.samuraiClickEvent);
		}
	}

	public void setWeapon(int num) {
		samurai.setWeapon(num);
		samurai.occupy(2);
	}

	public void setSamurai(int num) {
		samurai.setSamurai(num);
		//TODO
		//武器
	}
}
