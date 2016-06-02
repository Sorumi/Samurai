package view.campsite;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import view.GameColor;
import view.story.ArmorView;
import view.story.WeaponView;

public class CampsiteItemView extends StackPane {

	private final int RADIUS = 50;
	private int itemNum;
	private Circle bgCircle;
	private Label quantityLabel;

	public CampsiteItemView(int itemNum, int quantity) {
		this.itemNum = itemNum;

		this.setPrefSize(RADIUS * 2, RADIUS * 2);

		bgCircle = new Circle();
		bgCircle.setCenterX(RADIUS);
		bgCircle.setCenterY(RADIUS);
		bgCircle.setRadius(RADIUS);
		if (itemNum / 100 != 9) {
			bgCircle.setFill(GameColor.getWeaponColor(itemNum / 100));
			bgCircle.setStroke(GameColor.getWeaponColor(itemNum / 100 + 12));
		} else {
			bgCircle.setFill(GameColor.getWeaponColor(5));
			bgCircle.setStroke(GameColor.getWeaponColor(17));
		}

		bgCircle.setStrokeType(StrokeType.INSIDE);
		bgCircle.setStrokeWidth(0);
		this.getChildren().add(bgCircle);

		quantityLabel = new Label(quantity + "");
		quantityLabel.setPrefSize(30, 30);
		quantityLabel.setId("item-quantity");
		this.getChildren().add(quantityLabel);
		StackPane.setAlignment(quantityLabel, Pos.BOTTOM_RIGHT);

		if (itemNum / 100 != 9) {
			WeaponView weapon = new WeaponView(itemNum);
			this.getChildren().add(weapon);
			StackPane.setAlignment(weapon, Pos.CENTER);
		} else {
			ArmorView armor = new ArmorView(itemNum);
			this.getChildren().add(armor);
			StackPane.setAlignment(armor, Pos.CENTER);
		}

	}

	public void setHighlight() {
		if (itemNum / 100 != 9) {
			Timeline tl = new Timeline(
					new KeyFrame(Duration.millis(300),
							new KeyValue(bgCircle.fillProperty(), GameColor.getWeaponColor(itemNum / 100 + 6),
									Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300),
							new KeyValue(bgCircle.strokeWidthProperty(), 2, Interpolator.EASE_IN)));
			tl.play();
		} else {
			Timeline tl = new Timeline(
					new KeyFrame(Duration.millis(300),new KeyValue(bgCircle.fillProperty(), GameColor.getWeaponColor(11), Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300),new KeyValue(bgCircle.strokeWidthProperty(), 2, Interpolator.EASE_IN)));
			tl.play();
		}
	}

	public void setNormal() {
		if (itemNum / 100 != 9) {
			Timeline tl = new Timeline(
					new KeyFrame(Duration.millis(300),new KeyValue(bgCircle.fillProperty(), GameColor.getWeaponColor(itemNum / 100),
									Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300),
							new KeyValue(bgCircle.strokeWidthProperty(), 0, Interpolator.EASE_IN)));
			tl.play();
		} else {
			Timeline tl = new Timeline(
					new KeyFrame(Duration.millis(300),new KeyValue(bgCircle.fillProperty(), GameColor.getWeaponColor(5), Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300),new KeyValue(bgCircle.strokeWidthProperty(), 0, Interpolator.EASE_IN)));
			tl.play();
		}
	}

	public int getNum() {
		return this.itemNum;
	}
}
