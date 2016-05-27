package view;

import java.util.Collections;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.po.Position;
import view.campsite.CampsitePanel;
import view.eventhandler.CustomizeHandler;

public class CustomizePanel extends Pane {

	private CustomizeHandler customizeHandler;

	private SystemButton closeBtn;
	private SystemButton startBtn;
	private SystemButton campsiteBtn;
	private OrderPanel systemPanel;

	public ChessBoardPanel chessBoard;
	public CampsitePanel campsitePanel;
	public SuccessPanel hintPanel;

	private SamuraiView A1;
	private SamuraiView A2;
	private SamuraiView A3;
	private SamuraiView B1;
	private SamuraiView B2;
	private SamuraiView B3;

	private SamuraiView[] samurais;

	public Position[] positions;
	public int[] weapons;
	public int[] armors;
	public int[] levels;

	private Group customizeGroup;
	private GaussianBlur blur;

	private ObservableList<OrderPanel> orderList;

	public CustomizePanel() {

		this.setPrefSize(1200, 800);
		this.setStyle("-fx-background-image: url(" + Images.BG[0] + ") ;" + "-fx-background-size: 100% 100%; ");

		customizeHandler = new CustomizeHandler(this);

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				StoryPanel storyPanel = (StoryPanel) CustomizePanel.this.getParent();
				storyPanel.getChildren().remove(storyPanel.customizePanel);
				storyPanel.customizePanel = null;
				storyPanel.territoryPanel.setSamuraiAnimation(true);
			}
		});

		startBtn = new SystemButton(8);
		startBtn.setLayoutX(25);
		startBtn.setLayoutY(25);
		startBtn.setOnMouseClicked(customizeHandler.startEvent);

		campsiteBtn = new SystemButton(9);
		campsiteBtn.setLayoutX(100);
		campsiteBtn.setLayoutY(25);
		campsiteBtn.setOnMouseClicked(customizeHandler.campsiteEvent);

		// chessBoard
		chessBoard = new ChessBoardPanel(15);

		// samuraiWrapper
		Rectangle rect1 = new Rectangle(300, 160);
		rect1.setFill(Color.WHITE);
		rect1.setArcWidth(10);
		rect1.setArcHeight(10);
		rect1.setId("shadow-rect");
		rect1.setLayoutX(5);
		rect1.setLayoutY(635);

		Rectangle rect2 = new Rectangle(300, 160);
		rect2.setFill(Color.WHITE);
		rect2.setArcWidth(10);
		rect2.setArcHeight(10);
		rect2.setId("shadow-rect");
		rect2.setLayoutX(895);
		rect2.setLayoutY(635);

		// samurai
		A1 = new SamuraiView(1, 1);
		A2 = new SamuraiView(2, 1);
		A3 = new SamuraiView(3, 1);
		B1 = new SamuraiView(4, 1);
		B2 = new SamuraiView(5, 1);
		B3 = new SamuraiView(6, 1);

		samurais = new SamuraiView[] { null, A1, A2, A3, B1, B2, B3 };

		positions = new Position[7];
		weapons = new int[7];
		armors = new int[7];
		levels = new int[6];
		
		positions[0] = new Position(0, 0);

		for (int i = 1; i < 7; i++) {
			positions[i] = new Position(-1, -1);
			switch (i % 3) {
			case 1:
				weapons[i] = 11;
				break;
			case 2:
				weapons[i] = 111;
				break;
			case 0:
				weapons[i] = 211;
				break;
			}
			armors[i] = 11;
			levels[i-1] = 1;
			samurais[i].blink(false);
			setDraggableSamurai(samurais[i]);
			samurais[i].setWeapon(weapons[i]);
			samurais[i].setArmor(armors[i]);
		}

		//hint
		hintPanel = new SuccessPanel("请将武士放在棋盘上的正确位置（不能在同一坐标）");
		hintPanel.setVisible(false);
		//
		systemPanel = new OrderPanel();
		systemPanel.getChildren().addAll(rect1, rect2, closeBtn, startBtn, campsiteBtn);

		customizeGroup = new Group();
		customizeGroup.getChildren().addAll(chessBoard, systemPanel, A1, A2, A3, B1, B2, B3);

		orderList = FXCollections.observableArrayList(chessBoard, systemPanel, A1, A2, A3, B1, B2, B3);

		chessBoard.setZOrder(-2);
		systemPanel.setZOrder(-1);

		this.getChildren().addAll(customizeGroup, hintPanel);

		// blur
		blur = new GaussianBlur(0);
		customizeGroup.setEffect(blur);
	}

	public void setOrder() {
		Collections.sort(orderList);
		customizeGroup.getChildren().setAll(orderList);
	}

	public void updateSamurais() {
		for (int i = 1; i < 7; i++) {
			samurais[i].setWeapon(weapons[i]);
			samurais[i].setArmor(armors[i]);
		}
	}

	public void setDraggableSamurai(SamuraiView samurai) {
		if (samurai.getNumber() < 4) {
			samurai.setLayoutX(30 + 90 * (samurai.getNumber() - 1));
			samurai.setDirection(2);
		} else {
			samurai.setLayoutX(940 + 90 * (samurai.getNumber() - 4));
			samurai.setDirection(3);
		}

		samurai.setLayoutY(655);
		samurai.setOnMouseClicked(null);
		samurai.setOnMousePressed(customizeHandler.samuraiOnMousePressedEventHandler);
		samurai.setOnMouseDragged(customizeHandler.samuraiOnMouseDraggedEventHandler);
		samurai.setOnMouseReleased(customizeHandler.samuraiOnMouseReleasedEventHandler);
	}

	public void setBlur(boolean isBlur) {
		if (isBlur) {
			this.blur.setRadius(7);
		} else {
			this.blur.setRadius(0);
		}
	}

}
