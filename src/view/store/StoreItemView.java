package view.store;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import view.GameColor;
import view.MaterialView;
import view.PropView;
import view.WeaponView;

public class StoreItemView extends StackPane {

	private final int RADIUS = 50;
	private int itemNum;
	private Circle bgCircle;
	private Label quantityLabel;
	private ColorAdjust light;

	public StoreItemView(int itemNum, int quantity) {
		this.itemNum = itemNum;

		this.setPrefSize(RADIUS * 2, RADIUS * 2);

		bgCircle = new Circle();
		bgCircle.setCenterX(RADIUS);
		bgCircle.setCenterY(RADIUS);
		bgCircle.setRadius(RADIUS);
		if (itemNum / 100 != 7) {
			bgCircle.setFill(GameColor.getMaterialColor(itemNum / 10));
			bgCircle.setStroke(GameColor.getMaterialColor(itemNum / 10 + 10));
		}else{
			light = new ColorAdjust();
			this.setEffect(light);
		}

		bgCircle.setStrokeType(StrokeType.INSIDE);
		bgCircle.setStrokeWidth(0);
		this.getChildren().add(bgCircle);

		quantityLabel = new Label(quantity + "");
		quantityLabel.setPrefSize(30, 30);
		quantityLabel.setId("item-quantity");
		this.getChildren().add(quantityLabel);
		StackPane.setAlignment(quantityLabel, Pos.BOTTOM_RIGHT);

		if (itemNum / 100 != 7) {
			MaterialView material = new MaterialView(itemNum);
			this.getChildren().add(material);
			StackPane.setAlignment(material, Pos.CENTER);
		} else {
			PropView prop = new PropView(itemNum - 700, 3);
			this.getChildren().add(prop);
			StackPane.setAlignment(prop, Pos.CENTER);
		}
	}

	public void setHighlight() {
		if (itemNum / 100 != 7) {
			Timeline tl = new Timeline(
					new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.fillProperty(), GameColor.getMaterialColor(itemNum / 10 + 5), Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.strokeWidthProperty(), 2, Interpolator.EASE_IN)));
			tl.play();
		} else {
			Timeline tl= new Timeline(
					new KeyFrame(Duration.millis(300), new KeyValue(light.brightnessProperty(), 0.4, Interpolator.EASE_IN))
					);
			tl.play();
		}

	}

	public void setNormal() {
		if (itemNum / 100 != 7) {
			Timeline tl = new Timeline(
					new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.fillProperty(), GameColor.getMaterialColor(itemNum / 10), Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.strokeWidthProperty(), 0, Interpolator.EASE_IN)));
			tl.play();
		} else {
			Timeline tl= new Timeline(
					new KeyFrame(Duration.millis(300), new KeyValue(light.brightnessProperty(), 0, Interpolator.EASE_IN))
					);
			tl.play();
		}
	}

	public int getNum() {
		return this.itemNum;
	}

}
