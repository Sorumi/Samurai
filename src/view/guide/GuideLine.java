package view.guide;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GuideLine extends Pane {
	private int width = 160;
	private int height = 42;
	private int straightLineLength = 120;
	private int brokenLineWidth = 40;
	private int STROKE_WIDTH = 1;

	// 第一个数字：0表示直线在斜线左边，1表示直线在斜线右边
	// 第二个数字：0表示斜线斜向下，1表示斜向上
	// 第三个数字：0表示直线在斜线上边，1表示直线在斜线下边
	public GuideLine(int i, int j, int z) {
		Line line1 = new Line();
		Line line2 = new Line();
		
		line1.setStartX(i * brokenLineWidth);
		line1.setEndX(i * brokenLineWidth + straightLineLength);
		line1.setStartY(z * height);
		line1.setEndY(z * height);

		line2.setStartX((1-i) * straightLineLength);
		line2.setEndX((1-i) * straightLineLength + brokenLineWidth);
		line2.setStartY(j * height);
		line2.setEndY(height - j * height);

		line1.setStroke(Color.web("#DDDDDD"));
		line1.setStrokeWidth(STROKE_WIDTH);
		line2.setStroke(Color.web("#DDDDDD"));
		line2.setStrokeWidth(STROKE_WIDTH);
		this.getChildren().addAll(line1, line2);
	}

}
