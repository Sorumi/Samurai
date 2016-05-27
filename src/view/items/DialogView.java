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
			width = 300;
			height = 120;
		}else{
			width = size * 100;
			height = 80;
		}
		

		Rectangle rect = new Rectangle(width, height);
		rect.setArcWidth(20);
		rect.setArcHeight(20);
		rect.setFill(Color.rgb(255,255,255,0.9));

		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] {
				(double) (width/2-15), (double) (height),
				(double) (width/2+15), (double) (height),
				(double) width/2, (double) (height+35) });
		polygon.setFill(Color.rgb(255,255,255,0.9));
		
		Label textLabel = new Label(text);
		textLabel.setPrefSize(width-20, height-10);
		textLabel.setLayoutX(10);
		textLabel.setLayoutY(5);
		textLabel.setId("dialog-text");
		
		this.getChildren().addAll(rect, polygon, textLabel);
	}
}
