package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import view.eventhandler.PropHandler;

public class PropPanel extends OrderPanel {
	private int width = 390;
	private int height = 130;

	private Rectangle bgRect;
	private Polygon triangle1;
	private Polygon triangle2;

	private Group propGroup;

	private PropHandler propHandler;

	public PropPanel() {
		this.setPrefHeight(height);
		this.setPrefWidth(width);

		this.propHandler = new PropHandler(this);
		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setY(15);
		bgRect.setWidth(width);
		bgRect.setHeight(115);
		bgRect.setArcWidth(30);
		bgRect.setArcHeight(30);
		bgRect.setFill(Color.WHITE);

		triangle1 = new Polygon();
		triangle1.setFill(Color.web("#FFFFFF"));
		triangle1.getPoints().addAll(new Double[] { 180.0, 15.0, 210.0, 15.0, 195.0, 0.0 });

		triangle2 = new Polygon();
		triangle2.setFill(Color.web("#F9F1F1"));
		triangle2.getPoints().addAll(new Double[] { 183.0, 15.0, 207.0, 15.0, 195.0, 3.0 });
		triangle2.setOnMouseEntered(propHandler.showPropPanel);

		this.getChildren().addAll(bgRect, triangle1, triangle2);

		propGroup = new Group();
		// TODO
		propGroup.setLayoutX(5);
		propGroup.setLayoutY(20);

		for (int i = 1; i <= 6; i++) {
			PropItem item = new PropItem(i, 3);
			item.setLayoutX(55 * (i - 1));
			item.setLayoutY(0);
			propGroup.getChildren().add(item);
		}
		for (int i = 1; i <= 6; i++) {
			PropItem item = new PropItem(i + 6, 3);
			item.setLayoutX(55 * (i - 1));
			item.setLayoutY(55);
			propGroup.getChildren().add(item);
		}
		for (int i = 13; i <= 14; i++) {
			PropItem item = new PropItem(i, 3);
			item.setLayoutX(55 * 6);
			item.setLayoutY(55 * (i - 13));
			propGroup.getChildren().add(item);
		}
		this.getChildren().add(propGroup);
		this.setOnMouseExited(propHandler.hidePropPanel);
		this.setLayoutX(370);
		this.setLayoutY(785);
		this.setVisible(true);

	}

	public void show() {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(this.layoutYProperty(), 705)));
		timeline.play();

	}

	public void hide() {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(this.layoutYProperty(), 785)));
		timeline.play();

	}

	public class PropItem extends StackPane {
		private Label quantityLabel;
		private int RADIUS = 25;

		public PropItem(int itemNum, int quantity) {
			this.setPrefSize(RADIUS * 2, RADIUS * 2);

			PropView prop = new PropView(itemNum, 2);

			quantityLabel = new Label(quantity + "");
			quantityLabel.setPrefSize(30, 30);
			quantityLabel.setId("item-quantity");
			this.getChildren().addAll(prop, quantityLabel);
			StackPane.setAlignment(quantityLabel, Pos.BOTTOM_RIGHT);
		}
	}

	// public void addProp(int num){
	//
	// PropItem item = new PropItem(0, 3);
	// item.setLayoutX(5+75*i);
	// item.setLayoutY(20);
	// this.getChildren().add(item);
	// }
	//

}
