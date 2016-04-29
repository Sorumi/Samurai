package view.smithy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

public class SmithyItemView extends Pane{

	private final int RADIUS = 50;
	private int itemNum;
	public SmithyItemView(int itemNum){
		this.itemNum = itemNum;
		
		this.setPrefSize(RADIUS*2, RADIUS*2);
		
		Circle strokeCircle = new Circle();
		strokeCircle.setCenterX(RADIUS);
		strokeCircle.setCenterY(RADIUS);
		strokeCircle.setRadius(RADIUS);
		strokeCircle.setStroke(Color.WHITE);
		strokeCircle.setStrokeWidth(5);
		strokeCircle.setStrokeType(StrokeType.INSIDE);
		this.getChildren().add(strokeCircle);
		
		Circle fillCircle = new Circle();
		fillCircle.setCenterX(RADIUS);
		fillCircle.setCenterY(RADIUS);
		fillCircle.setRadius(RADIUS-10);
		fillCircle.setFill(Color.WHITE);
		this.getChildren().add(fillCircle);
	}
}
