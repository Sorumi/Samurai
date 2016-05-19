package view.items;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import view.GameColor;

public class CircleLight extends Pane{
	
	private final int RADIOUS = 70;
	
//	private Circle[] circles;

	public CircleLight(int num){
		
		this.setPrefSize(RADIOUS*2, RADIOUS*2);
		
		Color color = GameColor.getLightColor(num);
		Circle stroke = new Circle();
		stroke.setFill(null);
		stroke.setStroke(Color.WHITE);
		stroke.setCenterX(RADIOUS);
		stroke.setCenterY(RADIOUS);
		this.getChildren().add(stroke);
		
		Timeline tl = new Timeline(
				new KeyFrame(Duration.millis(0), new KeyValue(stroke.radiusProperty(), 0)),
				new KeyFrame(Duration.millis(0), new KeyValue(stroke.opacityProperty(), 0.9)),
				new KeyFrame(Duration.millis(1000), new KeyValue(stroke.radiusProperty(), RADIOUS)),
				new KeyFrame(Duration.millis(1000), new KeyValue(stroke.opacityProperty(), 0))
				);
		
		for(int i=0; i<4; i++){
			CirclePart circle = new CirclePart(i, color);
			this.getChildren().add(circle);
			tl.getKeyFrames().addAll(circle.getFrames());
		}
		
		tl.play();
		
	}
	
	public class CirclePart extends Circle{
		private int num;
		private Color color;
		public CirclePart(int num, Color color){
			this.num = num;
			this.color = color;
			
			this.setFill(color);
			this.setCenterX(RADIOUS);
			this.setCenterY(RADIOUS);
		}
		
		public KeyFrame[] getFrames(){
			return new KeyFrame[]{new KeyFrame(Duration.millis(300*num), new KeyValue(this.radiusProperty(), 0)),
					new KeyFrame(Duration.millis(300*num), new KeyValue(this.opacityProperty(), 0.9)),
					new KeyFrame(Duration.millis(300*num), new KeyValue(this.fillProperty(), color)),
				
					new KeyFrame(Duration.millis(300*num+1400), new KeyValue(this.radiusProperty(), RADIOUS)),
					new KeyFrame(Duration.millis(300*num+1400), new KeyValue(this.opacityProperty(), 0)),
					new KeyFrame(Duration.millis(300*num+1400), new KeyValue(this.fillProperty(), Color.web("#ffffff"))),
					};
		}
	}
	
	
}
