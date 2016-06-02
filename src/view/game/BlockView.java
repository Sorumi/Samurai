package view.game;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import view.GameColor;

public class BlockView extends Polygon {
	
	private final int BLOCK_WIDTH = 70;
	private final int BLOCK_HEIGHT = 40;
	
	private int x;
	private int y;
	private Color color = GameColor.getBlockColor(0); //GameColor.getBlockColor(0);
	
	private double feildWidth;
	private double feildHeight;
	private int stateStrokeSize;
	private int currentStrokeSize;
	
	private int state = 0;
	
	private Timeline tl;
	
	public BlockView(int x, int y, int size){
		this.x = x;
		this.y = y;
		this.feildWidth = BLOCK_WIDTH * size;
		this.feildHeight = BLOCK_HEIGHT * size;
		this.stateStrokeSize = 1;
		
		//paint
		this.getPoints().addAll(new Double[]{
			    0.0, (double)BLOCK_HEIGHT/2,
			    (double)BLOCK_WIDTH/2, 0.0,
			    (double)BLOCK_WIDTH, (double)BLOCK_HEIGHT/2,
			    (double)BLOCK_WIDTH/2,(double)BLOCK_HEIGHT});
		this.setStroke(Color.WHITE);
		this.setStrokeType(StrokeType.INSIDE);
		this.setStrokeWidth(stateStrokeSize);
		this.setFill(color);
		
		//bounds
		this.setLayoutX(feildWidth/2 + (y-x-1)*BLOCK_WIDTH/2);
		this.setLayoutY((x+y)*BLOCK_HEIGHT/2);
	}

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

	public int getState() {
		return state;
	}
}
