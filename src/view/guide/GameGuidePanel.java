package view.guide;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import view.Images;
import view.eventhandler.ActionGuideHandler;

public class GameGuidePanel extends Pane implements Observer {
	private final int WINDOW_WIDTH = 1100;
	private final int WINDOW_HEIGHT = 700;
//	private final int BLOCK_WIDTH = 70;
//	private final int BLOCK_HEIGHT = 40;

	private int size;
//	private int feildWidth;
//	private int feildHeight;

	public ChessBoardGuidePanel chessBoard;
	private SamuraiGuidePanel samurai;
	
	public ActionGuidePanel actionPanel;
	private ActionGuideHandler actionHandler;
	
	private Group weaponBtnGroup;
	
	public GameGuidePanel(int size) {
		this.size = size;
//		this.feildWidth = BLOCK_WIDTH * size;
//		this.feildHeight = BLOCK_HEIGHT * size;

		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		chessBoard = new ChessBoardGuidePanel(size);
		this.getChildren().add(chessBoard);
		
		//actionHandler
		actionHandler = new ActionGuideHandler(this);
		this.setOnMouseClicked(actionHandler.actionPanelDisappearEvent);

		//actionpanel
		actionPanel = new ActionGuidePanel(actionHandler);
		actionPanel.setSize(this.size);
		this.getChildren().add(actionPanel);
		
		// samurai
		samurai = new SamuraiGuidePanel(1, size);
		samurai.samuraiV.setRandomAnimation(false);
		samurai.setOnMouseClicked(actionHandler.samuraiEvent);
		this.getChildren().add(samurai);
		
		actionPanel.setCurrentSamurai(samurai);
		
		//weapon button
		WeaponButton spearBtn = new WeaponButton(0);
		WeaponButton swordBtn = new WeaponButton(1);
		WeaponButton battleaxBtn = new WeaponButton(2);
		WeaponButton shurikenBtn = new WeaponButton(3);
		WeaponButton bowBtn = new WeaponButton(4);
		WeaponButton armorBtn = new WeaponButton(5);
		
		weaponBtnGroup = new Group();
		weaponBtnGroup.setLayoutX(1000);
		weaponBtnGroup.setLayoutY(50);
		weaponBtnGroup.getChildren().addAll(spearBtn, swordBtn, battleaxBtn, shurikenBtn, bowBtn, armorBtn);
		this.getChildren().add(weaponBtnGroup);
		
		//TODO
		samurai.setActualLocation(3, 3);
	}

	public class WeaponButton extends Button{
		public int num;
		
		public WeaponButton(int num){
			ImageView imgV = new ImageView(Images.WEAPON_ICON[num+6]);
			imgV.setFitWidth(60);
			imgV.setPreserveRatio(true);
			
			this.setGraphic(imgV);
			this.setLayoutY(80*num);
			this.setOnMouseClicked(actionHandler.weaponEvent);
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
