package view.items;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import view.GameColor;
import view.OrderPanel;

public class CircleLight extends OrderPanel{ 
	
	private final int RADIOUS = 70;
	
//	private Circle[] circles;
	private Circle stroke;

	public CircleLight(){
		this.setPrefSize(RADIOUS*2, RADIOUS*2);
		stroke = new Circle();
		stroke.setFill(null);
		stroke.setStroke(Color.WHITE);
		stroke.setCenterX(RADIOUS);
		stroke.setCenterY(RADIOUS);
	}
	
	public void setNum(int num){
		
		this.getChildren().clear();
		
		this.getChildren().add(stroke);
		Color color = GameColor.getLightColor(num);
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
		System.out.println(num); 
	}
	
	public void setActualacation(double x, double y){ 
		this.setLayoutX(x);
		this.setLayoutY(y);
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
