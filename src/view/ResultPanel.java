package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;



public class ResultPanel extends OrderPanel{
	
	private final int CIRCLE_RADIUS = 290;
	private final int RATIO = 2; //比例
	private final int strokeSize = 10;
	
	private int size;
	private int width;
	private int height;
	
	private ImageView logo;
	
	private BlockArc[] arcsOne;
	private BlockArc[] arcsTwo;
	
	
	

	
	Timeline timeline;
	
	private class BlockArc extends Arc{
		private int blockNum;
		
		BlockArc(){
			blockNum = 0;
		} 
	}
	
	public ResultPanel(GamePanel gamePanel){
		this.logo = new ImageView(Images.A_WIN);
		this.logo.setFitWidth(504);
		this.logo.setPreserveRatio(true);

		this.width = this.CIRCLE_RADIUS+this.strokeSize;
		this.height = this.CIRCLE_RADIUS+this.strokeSize;
		
		size = 15;
		
		this.setLayoutX(gamePanel.getLayoutX()+gamePanel.FIELD_WIDTH/2-width/2-100);
		this.setLayoutY(gamePanel.getLayoutY()+gamePanel.FIELD_HEIGHT/2-height/2);
		
		
		Circle bgCircle = new Circle();
		bgCircle.setCenterX(CIRCLE_RADIUS+strokeSize); 
		bgCircle.setCenterY(CIRCLE_RADIUS+strokeSize);
		bgCircle.setRadius(CIRCLE_RADIUS);
		bgCircle.setFill(Color.WHITE);
		bgCircle.setStroke(Color.WHITE);
		bgCircle.setStrokeWidth(strokeSize);
		bgCircle.setStrokeType(StrokeType.OUTSIDE);
		this.getChildren().add(bgCircle);
		//player0
		arcsOne = new BlockArc[3];    
//		
		double startAngleOne = 90.0; 
		double preAngleOne = 180.0 / (size*size); 
		for (int i=0; i<arcsOne.length; i++){
			arcsOne[i] = new BlockArc();
			BlockArc tmpArc = arcsOne[i];
			tmpArc.setCenterX(CIRCLE_RADIUS+strokeSize);
			tmpArc.setCenterY(CIRCLE_RADIUS+strokeSize);
			tmpArc.setRadiusX(CIRCLE_RADIUS);
			tmpArc.setRadiusY(CIRCLE_RADIUS);
			tmpArc.setStartAngle(startAngleOne);
			tmpArc.setLength(preAngleOne * tmpArc.blockNum);
			tmpArc.setType(ArcType.ROUND);
			tmpArc.setFill(GameColor.getBlockColor(i+1));
			this.getChildren().add(tmpArc);
			startAngleOne += preAngleOne * tmpArc.blockNum;
		}
		//player1
		arcsTwo = new BlockArc[3];   
		
		    double startAngleTwo = 90.0; 
			double preAngleTwo = -180.0 / (size*size);
			for (int i=0; i<arcsTwo.length; i++){
				arcsTwo[i] = new BlockArc();
				BlockArc tmpArc = arcsTwo[i];
				tmpArc.setCenterX(CIRCLE_RADIUS+strokeSize);
				tmpArc.setCenterY(CIRCLE_RADIUS+strokeSize);
				tmpArc.setRadiusX(CIRCLE_RADIUS);
				tmpArc.setRadiusY(CIRCLE_RADIUS);
				tmpArc.setStartAngle(startAngleTwo);
				tmpArc.setLength(preAngleTwo * tmpArc.blockNum);
				tmpArc.setType(ArcType.ROUND);
				tmpArc.setFill(GameColor.getBlockColor(i+4));
				this.getChildren().add(tmpArc);
				startAngleTwo += preAngleTwo * tmpArc.blockNum;

			}
			
			logo.setLayoutX(strokeSize+CIRCLE_RADIUS-504/RATIO);
			logo.setLayoutY(strokeSize+CIRCLE_RADIUS-504/RATIO);
			this.getChildren().add(logo); 
						
			//40是假数字！！
			double startAngle = 90.0;
				timeline = new Timeline(
						new KeyFrame(Duration.millis(4000), new KeyValue(arcsOne[0].lengthProperty(), preAngleOne * 40)),
						new KeyFrame(Duration.millis(4000), new KeyValue(arcsTwo[0].lengthProperty(), preAngleTwo * 40)),
						new KeyFrame(Duration.millis(4200), new KeyValue(arcsOne[1].startAngleProperty(), startAngle+preAngleOne * 40)),				
						new KeyFrame(Duration.millis(4200), new KeyValue(arcsOne[1].lengthProperty(), 0)), 
						new KeyFrame(Duration.millis(8200), new KeyValue(arcsOne[1].lengthProperty(), preAngleOne * 40)),
						new KeyFrame(Duration.millis(4200), new KeyValue(arcsTwo[1].startAngleProperty(), startAngle+preAngleTwo * 40)),				
						new KeyFrame(Duration.millis(4200), new KeyValue(arcsTwo[1].lengthProperty(), 0)),
						new KeyFrame(Duration.millis(8200), new KeyValue(arcsTwo[1].lengthProperty(), preAngleTwo * 40)),
						new KeyFrame(Duration.millis(8400), new KeyValue(arcsOne[2].startAngleProperty(), startAngle+preAngleOne * 40+preAngleOne * 40)),
						new KeyFrame(Duration.millis(8400), new KeyValue(arcsOne[2].lengthProperty(), 0)),
						new KeyFrame(Duration.millis(12400), new KeyValue(arcsOne[2].lengthProperty(), preAngleOne * 40)),
				new KeyFrame(Duration.millis(8400), new KeyValue(arcsTwo[2].startAngleProperty(), startAngle+preAngleTwo * 40+preAngleTwo * 40)),
				new KeyFrame(Duration.millis(8400), new KeyValue(arcsTwo[2].lengthProperty(), 0)),
				new KeyFrame(Duration.millis(12400), new KeyValue(arcsTwo[2].lengthProperty(), preAngleTwo * 40)));
				


				timeline.play();
		    
				
			
		
		
		this.setVisible(true);
	}
	
	

}
