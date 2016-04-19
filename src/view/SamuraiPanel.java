package view;

import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SamuraiPanel extends Pane {

	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;
	private final int SAMURAI_WIDTH = 60;
	private final int SAMURAI_HEIGHT = 120;

	private int chessBoardWidthOffset = (WINDOW_WIDTH-FIELD_WIDTH)/2 ;
	private int chessBoardHeightOffset = WINDOW_HEIGHT-FIELD_HEIGHT-FIELD_FIX;
	private int blockWidthOffset;
	private int blockHeightOffset;
	
	private final int selfWidthOffset = -SAMURAI_WIDTH/2;
	private final int selfHeightOffset = -90;
		
	private int number;
	private SamuraiView samuraiV;
	
	public int x;
	public int y;
	private boolean isHide;
	
	public SamuraiPanel(int number, int size){
		this.number = number;
		
		this.setPrefWidth(SAMURAI_WIDTH);
		this.setPrefHeight(SAMURAI_HEIGHT);
		
//		this.setStyle("-fx-background-color: rgba(255,0,0,0.5)");
		this.samuraiV = new SamuraiView(number);
		this.isHide = false;
		
		this.getChildren().add(samuraiV);
		
		blockWidthOffset = FIELD_WIDTH / size / 2;
		blockHeightOffset = FIELD_HEIGHT / size / 2;
		
		
//		this.setSize(imageV.getFitWidth(), image.getHeight());
	}
	
	public void setActualLocation(int x, int y){
		this.x = x;
		this.y = y;
		this.setLayoutX(chessBoardWidthOffset+FIELD_WIDTH/2+(y-x)*blockWidthOffset +selfWidthOffset);
		this.setLayoutY(chessBoardHeightOffset+(x+y)*blockHeightOffset +selfHeightOffset);
	}

	public void setHide(boolean isHide) {
		if (isHide != this.isHide){
			FadeTransition ft = new FadeTransition(Duration.millis(1000), this);
			ft.setAutoReverse(false);
			if (isHide){
				ft.setFromValue(1.0f);
				ft.setToValue(0.5f);
			} else {
				ft.setFromValue(0.5f);
				ft.setToValue(1.0f);ft.play();
			}
			ft.play();
		}
		this.isHide = isHide;
	}
	
	public int getNum(){
		return this.number;
	}

	public boolean isHide() {
		return isHide;
	}

}
