package view.smithy;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class SmithyItemLine extends Group {

	private final int WIDTH = 50;
	private final int STROKE_WIDTH = 3;
	private final int RADIUS = 5;
	/*
	 * height:
	 * 0: 直线
	 * 1: 折线
	 */
	public SmithyItemLine(int height){
		if (height == 0){
			this.straightLine();
		}else{
			this.brokenLine(height);
		}
	}
	
	public SmithyItemLine(int height1, int height2) {
		if (height1 != 0 && height2 != 0){
			this.brokenLine(height1);
			this.brokenLine(height2);
		}
	}

	//直线
	private void straightLine(){
		Line line = new Line();
		line.setStartX(-WIDTH);
		line.setStartY(0);
		line.setEndX(0);
		line.setEndY(0);
		line.setStroke(Color.WHITE);
		line.setStrokeWidth(STROKE_WIDTH);
		this.getChildren().add(line);
	}

	//折线
	private void brokenLine(int height){
		Line line1 = new Line();
		line1.setStartX(-WIDTH/2);
		line1.setStartY(0);
		line1.setEndX(0);
		line1.setEndY(0);
		line1.setStroke(Color.WHITE);
		line1.setStrokeWidth(STROKE_WIDTH);
		this.getChildren().add(line1);
		
		Line line2 = new Line();
		line2.setStartX(-WIDTH);
		line2.setStartY(-height);
		line2.setEndX(-WIDTH/2);
		line2.setEndY(-height);
		line2.setStroke(Color.WHITE);
		line2.setStrokeWidth(STROKE_WIDTH);
		this.getChildren().add(line2);
		
		Line line3 = new Line();
		line3.setStartX(-WIDTH/2);
		line3.setStartY(0);
		line3.setEndX(-WIDTH/2);
		line3.setEndY(-height);
		line3.setStroke(Color.WHITE);
		line3.setStrokeWidth(STROKE_WIDTH);
		this.getChildren().add(line3);
		
		Circle circle1 = new Circle();
		circle1.setCenterX(-WIDTH/2);
		circle1.setCenterY(0);
		circle1.setRadius(RADIUS);
		circle1.setFill(Color.WHITE);
		this.getChildren().add(circle1);
		
		Circle circle2 = new Circle();
		circle2.setCenterX(-WIDTH/2);
		circle2.setCenterY(-height);
		circle2.setRadius(RADIUS);
		circle2.setFill(Color.WHITE);
		this.getChildren().add(circle2);
	}

}
