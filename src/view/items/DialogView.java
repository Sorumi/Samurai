package view.items;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class DialogView extends Group {

	// 200:130
	// 1:0.65
	public DialogView(int size, String text) {
		int width = size * 100;
		int height = size * 66;

		Rectangle rect = new Rectangle(width, height);
		rect.setArcWidth(width/2);
		rect.setArcHeight(height/2);
		rect.setFill(Color.web("#eeeeee"));
		
//		Arc arc = new Arc();
//		arc.setCenterX(radiusX);
//		arc.setCenterY(radiusY);
//		arc.setRadiusX(radiusX);
//		arc.setRadiusY(radiusY);
//		arc.setStartAngle(0);
//		arc.setLength(360);
//		arc.setType(ArcType.ROUND);
//		arc.setFill(Color.web("eeeeee"));

		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] {
				(double) (width/2-15), (double) (height),
				(double) (width/2+15), (double) (height),
				(double) width/2, (double) (height+35) });
		polygon.setFill(Color.web("eeeeee"));
		
		Label textLabel = new Label(text);
		textLabel.setPrefSize(size*90, size*60);
		textLabel.setLayoutX(size*5);
		textLabel.setLayoutY(size*3);
		textLabel.setId("dialog-text");
		
		this.getChildren().addAll(rect, polygon, textLabel);
	}
}
