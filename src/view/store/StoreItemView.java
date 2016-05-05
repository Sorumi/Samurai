package view.store;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import view.GameColor;
import view.MaterialView;
import view.WeaponView;

public class StoreItemView extends StackPane{
	
	private final int RADIUS = 50;
	private int itemNum;
	private Circle bgCircle;
	private Label quantityLabel;
	
	public StoreItemView(int itemNum){
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
		
		quantityLabel = new Label("1");
		quantityLabel.setPrefSize(30, 30);
		quantityLabel.setId("item-quantity");
		this.getChildren().add(quantityLabel);
		StackPane.setAlignment(quantityLabel,Pos.BOTTOM_RIGHT);
		
		MaterialView material = new MaterialView(itemNum);
		this.getChildren().add(material);
		StackPane.setAlignment(material,Pos.CENTER);

	}

	public void setHighlight() {
		bgCircle.setFill(GameColor.getMaterialColor(itemNum/10+5));
		bgCircle.setStrokeWidth(2);
	}
	
	public void setNormal(){
		bgCircle.setFill(GameColor.getMaterialColor(itemNum/10));
		bgCircle.setStrokeWidth(0);
	}
	
	public int getNum(){
		return this.itemNum;
	}

}
