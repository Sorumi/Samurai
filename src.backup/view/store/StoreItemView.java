package view.store;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import view.GameColor;
import view.MaterialView;
import view.WeaponView;

public class StoreItemView extends StackPane{
	
	private final int RADIUS = 50;
	private int itemNum;
	private Circle bgCircle;
	private Label quantityLabel;
	
	public StoreItemView(int itemNum, int quantity){
		this.itemNum = itemNum;
		
		this.setPrefSize(RADIUS*2, RADIUS*2);
		
		bgCircle = new Circle();
		bgCircle.setCenterX(RADIUS);
		bgCircle.setCenterY(RADIUS);
		bgCircle.setRadius(RADIUS);
		bgCircle.setFill(GameColor.getMaterialColor(itemNum/10));
		bgCircle.setStroke(GameColor.getMaterialColor(itemNum/10+10));
		bgCircle.setStrokeType(StrokeType.INSIDE);
		bgCircle.setStrokeWidth(0);
		this.getChildren().add(bgCircle);
		
		quantityLabel = new Label(quantity + "");
		quantityLabel.setPrefSize(30, 30);
		quantityLabel.setId("item-quantity");
		this.getChildren().add(quantityLabel);
		StackPane.setAlignment(quantityLabel,Pos.BOTTOM_RIGHT);
		
		MaterialView material = new MaterialView(itemNum);
		this.getChildren().add(material);
		StackPane.setAlignment(material,Pos.CENTER);

	}

	public void setHighlight() {		
		Timeline tl= new Timeline(
				new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.fillProperty(), GameColor.getMaterialColor(itemNum/10+5),  Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.strokeWidthProperty(), 2, Interpolator.EASE_IN))
				);
		tl.play();
	}
	
	public void setNormal(){
		Timeline tl= new Timeline(
				new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.fillProperty(), GameColor.getMaterialColor(itemNum/10),  Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(300), new KeyValue(bgCircle.strokeWidthProperty(), 0, Interpolator.EASE_IN))
				);
		tl.play();	
	}
	
	public int getNum(){
		return this.itemNum;
	}

}
