package view.guide;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GuideLine {
	
	public GuideLine(int height){
		if (height == 0){
			this.straightLine();
		}else{
//			this.brokenLine(height);
		}
	}
	
	
	private void straightLine(){
		Line line = new Line();
		line.setStartX(0);
		line.setStartY(0);
		line.setEndX(46);
		line.setEndY(0);
		line.setFill(Color.web("#DDDDDD"));
//		line.setStroke(Color.WHITE);
//		line.setStrokeWidth(STROKE_WIDTH);
//		this.getChildren().add(line);
	}
	
//	private void brokenLine(int height){
//		Line line1 = new Line();
//		line1.setStartX(-WIDTH/2);
//		line1.setStartY(0);
//		line1.setEndX(0);
//		line1.setEndY(0);
//		line1.setStroke(Color.WHITE);
//		line1.setStrokeWidth(STROKE_WIDTH);
//		this.getChildren().add(line1);
//		
//		Line line2 = new Line();
//		line2.setStartX(-WIDTH);
//		line2.setStartY(-height);
//		line2.setEndX(-WIDTH/2);
//		line2.setEndY(-height);
//		line2.setStroke(Color.WHITE);
//		line2.setStrokeWidth(STROKE_WIDTH);
//		this.getChildren().add(line2);
//	}

}
