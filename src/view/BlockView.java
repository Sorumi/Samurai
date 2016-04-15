package view;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
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
	
	public void setInvision(int state){
		currentStrokeSize = stateStrokeSize;
		Color newColor = GameColor.getBlockColor(state);
//		FillTransition ft = new FillTransition(Duration.millis(800), this, this.color, newColor);
//		ft.play();
		this.color = newColor;
		this.setFill(newColor);
		
	}
	
	public void setOutvision(){
		currentStrokeSize = 0;//TODO
		Color newColor = GameColor.getBlockColor(99);
		this.setFill(newColor);
	}

	public void setHome() {
		stateStrokeSize = 3;
	}
}
