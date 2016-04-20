package view;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private BooleanProperty canAction;
	
	public SamuraiPanel(int number, int size){
		this.number = number;
		
		this.setPrefWidth(SAMURAI_WIDTH);
		this.setPrefHeight(SAMURAI_HEIGHT);
		
//		this.setStyle("-fx-background-color: rgba(255,0,0,0.5)");
		this.samuraiV = new SamuraiView(number);
		this.isHide = false;
		this.canAction = new SimpleBooleanProperty(true);
		
		this.getChildren().add(samuraiV);
		
		blockWidthOffset = FIELD_WIDTH / size / 2;
		blockHeightOffset = FIELD_HEIGHT / size / 2;
		
		
		if(number < 4){
			samuraiV.setDirection(2);
		}else{
			samuraiV.setDirection(1);
		}
		
		//TODO
		switch(number){
		case 1:
		case 4:
			samuraiV.setWeapon(000);
			break;
		case 2:
		case 5:
			samuraiV.setWeapon(100);
			break;
		case 3:
		case 6:
			samuraiV.setWeapon(200);
			break;
		}
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

	public void occupy(int direction){
		samuraiV.occupy(direction);
	}
	
	public void move(int x, int y){
		canAction.setValue(false);
		samuraiV.move(2);
		Timeline timeline = new Timeline(
				new KeyFrame(Duration.millis(1200), new KeyValue(this.layoutXProperty(), chessBoardWidthOffset+FIELD_WIDTH/2+(y-x)*blockWidthOffset +selfWidthOffset)),
				new KeyFrame(Duration.millis(1200), new KeyValue(this.layoutYProperty(), chessBoardHeightOffset+(x+y)*blockHeightOffset +selfHeightOffset))
				);
		timeline.play();
		this.x = x;
		this.y = y;

		timeline.setOnFinished(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				canAction.setValue(true);
			}
			
		});
	}
	
	public BooleanProperty canActionProperty(){
		return this.canAction;
	}

}
