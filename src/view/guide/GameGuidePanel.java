package view.guide;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import controller.GuideController;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Material;
import model.po.Position;
import model.po.SamuraiPO;
import view.Images;
import view.PropView;
import view.SamuraiPanel;
import view.eventhandler.ActionGuideHandler;

public class GameGuidePanel extends Pane implements Observer {
	private final int WINDOW_WIDTH = 1100;
	private final int WINDOW_HEIGHT = 700;

	private int size;

	public ChessBoardGuidePanel chessBoard;
	private SamuraiGuidePanel samurai;
	
	public ActionGuidePanel actionPanel;
	private ActionGuideHandler actionHandler;
	
	private Group weaponBtnGroup;
	
	public GameGuidePanel(int size) {
		this.size = size;

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

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();

		Platform.runLater(new Runnable(){
			public void run() {
				if (key.equals("samuraiMove")) {
					Position position = (Position) notifingObject.getValue();
					samurai.move(position.getX(), position.getY());
					samurai.setCanHide(chessBoard.getState(samurai.x, samurai.y) / 4 == samurai.getNum() / 4);
					actionPanel.reset();

				} else if (key.equals("samuraiHide")) {
					samurai.setHide((boolean) notifingObject.getValue());

				} else if (key.equals("samuraiOccupy")) {
					samurai.occupy((int) notifingObject.getValue());
					samurai.setCanHide(chessBoard.getState(samurai.x, samurai.y) / 4 == samurai.getNum() / 4);
					actionPanel.reset();

				} else if (key.equals("visible")) {
					samurai.setVisible(true);

				} else if (key.equals("vision")) {
					chessBoard.see((ArrayList<ActualBlock>) notifingObject.getValue());
					chessBoard.setTmpBlocks((ArrayList<ActualBlock>) notifingObject.getValue());

				} else if (key.equals("pseudoOccupy")) {
					chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), true);

				} else if (key.equals("a-pseudoOccupy")) {
					chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), false);

				} else if(key.equals("home")){
					SamuraiPO samuraiPO = (SamuraiPO)notifingObject.getValue();
					samurai.setActualLocation(samuraiPO.getHome().getX(), samuraiPO.getHome().getY());
					chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();

				}
			}
		});
	}
}
