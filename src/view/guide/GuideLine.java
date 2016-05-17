package view.guide;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GuideLine extends Pane {
	private int width = 160;
	private int height = 42;
	private int straightLineLength = 120;
	private int brokenLineWidth = 40;
	private int STROKE_WIDTH = 3;

	// 第一个数字：0表示直线在斜线右边，1表示斜线在直线左边
	// 第二个数字：0表示斜线斜向上，1表示斜向下
	public GuideLine(int i, int j) {
		Line line1 = new Line();
		Line line2 = new Line();
		line1.setStartY(j * height);
		line1.setEndY(j * height);
		if (i == 0) {
			line1.setStartX(0);
			line1.setEndX(straightLineLength);
			line2.setStartX(straightLineLength);
			line2.setStartY(0);
			line2.setEndX(width);
			line2.setEndY(height);
		} else if (i == 1) {
			line1.setStartX(brokenLineWidth);
			line1.setEndX(width);
			line2.setStartX(0);
			line2.setStartY(height);
			line2.setEndX(brokenLineWidth);
			line2.setEndY(0);
		}
		line1.setStroke(Color.web("#DDDDDD"));
		line1.setStrokeWidth(STROKE_WIDTH);
		line2.setStroke(Color.web("#DDDDDD"));
		line2.setStrokeWidth(STROKE_WIDTH);
		this.getChildren().addAll(line1, line2);
	}

}
