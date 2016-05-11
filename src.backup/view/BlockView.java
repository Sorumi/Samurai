package view;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

public class BlockView extends Polygon {
	
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	
	private int x;
	private int y;
	private Color color = GameColor.getBlockColor(0); //GameColor.getBlockColor(0);
	
	private double width;
	private double height;
	private int stateStrokeSize;
	private int currentStrokeSize;
	
	private int state = 0;
	
	private Timeline tl;
	
	public BlockView(int x, int y, int size){
		this.x = x;
		this.y = y;
		this.width = FIELD_WIDTH / size;
		this.height = FIELD_HEIGHT / size;
		this.stateStrokeSize = 1;
		
		//paint
		this.getPoints().addAll(new Double[]{
			    0.0, height/2,
			    width/2, 0.0,
			    width, height/2,
			    width/2, height});
		this.setStroke(Color.WHITE);
		this.setStrokeType(StrokeType.INSIDE);
		this.setStrokeWidth(stateStrokeSize);
		this.setFill(color);
		
		//bounds
		this.setLayoutX(FIELD_WIDTH/2 + (y-x-1)*width/2);
		this.setLayoutY((x+y)*height/2);
	}
	
	//没用的方法，，，
//	public void changeState(int state){
//		this.state = state;
//		
//		Color newColor = GameColor.getBlockColor(state);
//		if(!newColor.equals(color)){
//				tl = new Timeline(new KeyFrame(Duration.millis(300), new KeyValue(this.fillProperty(), newColor)));
//				tl.play();
//		}
//		this.color = newColor;
//
//	}
	public void setInvision(int state){
		currentStrokeSize = stateStrokeSize;
		
		//add
		Color newColor = GameColor.getBlockColor(state);
		if(!newColor.equals(color) && this.state != state){
				tl = new Timeline(new KeyFrame(Duration.millis(300), new KeyValue(this.fillProperty(), newColor)));
				tl.play();
		}else{
			this.setFill(newColor);
		}
		this.color = newColor;
		this.state = state;
	
		this.setStrokeWidth(currentStrokeSize);
	}
	
	public void setOutvision(){
		if(tl!=null){
			tl.stop();
		}

		currentStrokeSize = 0;
		Color newColor = GameColor.getBlockColor(99);
		this.setFill(newColor);
		this.color = newColor;
		this.setStrokeWidth(currentStrokeSize);

	}

	public void setHome() {
		stateStrokeSize = 3;
	}
	
	public void setHighlight(boolean isHL){
		Color newColor;
		if (isHL){
			newColor = GameColor.getBlockColor(state+7);
		}else{
			newColor = GameColor.getBlockColor(state);
		}

		if(!newColor.equals(color)){
				tl = new Timeline(new KeyFrame(Duration.millis(300), new KeyValue(this.fillProperty(), newColor)));
				tl.play();
		}
		this.color = newColor;
	}
}
