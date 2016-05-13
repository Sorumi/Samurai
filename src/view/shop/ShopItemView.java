package view.shop;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import view.GameColor;

public class ShopItemView extends StackPane {
	private final int RADIUS = 50;
	private int itemNum;
	private Circle bgCircle;
	
	public ShopItemView(int itemNum){
		this.itemNum = itemNum;
		
		this.setPrefSize(RADIUS*2, RADIUS*2);
		//颜色以后根据里面的东西改
		bgCircle = new Circle();
		bgCircle.setCenterX(RADIUS);
		bgCircle.setCenterY(RADIUS);
		bgCircle.setRadius(RADIUS);
		bgCircle.setFill(Color.web("#E2ECEE"));
		bgCircle.setStroke(Color.web("#B4D1D6"));
		bgCircle.setStrokeType(StrokeType.INSIDE);
		bgCircle.setStrokeWidth(0);
		this.getChildren().add(bgCircle);
	}

}
