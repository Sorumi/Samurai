package view.items;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class DialogView extends Group {

	private int width;
	private int height;
	
	public DialogView(int size, String text) {
		if(size > 3){
			width = 300/2;
			height = 160/2;
		}else{
			width = size * 100/2;
			height = 120/2;
		}

		Arc arc = new Arc();
		arc.setCenterX(width);
		arc.setCenterY(height);
		arc.setRadiusX(width);
		arc.setRadiusY(height);
		arc.setLength(360);
		arc.setType(ArcType.ROUND);
		arc.setFill(Color.WHITE);
		
//		Rectangle rect = new Rectangle(width, height);
//		rect.setArcWidth(20);
//		rect.setArcHeight(20);
//		rect.setFill(Color.rgb(255,255,255,0.9));

		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] {
				(double) (width-15), (double) (height*2-10),
				(double) (width+15), (double) (height*2-10),
				(double) width, (double) (height*2+20) });
		polygon.setFill(Color.WHITE);
		
		Label textLabel = new Label(text);
		textLabel.setPrefSize(width*2-40, height*2-10);
		textLabel.setLayoutX(20);
		textLabel.setLayoutY(5);
		textLabel.setId("dialog-text");
		
		this.setOpacity(0.9);
		this.getChildren().addAll(arc, polygon, textLabel);
	}
}
