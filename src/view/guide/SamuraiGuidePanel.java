package view.guide;

import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.po.Position;
import view.OrderPanel;
import view.SamuraiView;

public class SamuraiGuidePanel extends OrderPanel {

	private final int WINDOW_WIDTH = 1100;
	private final int WINDOW_HEIGHT = 700;
	private final int BLOCK_WIDTH = 70;
	private final int BLOCK_HEIGHT = 40;
	private final int FIELD_FIX = 80;
	private final int SAMURAI_WIDTH = 60;
	private final int SAMURAI_HEIGHT = 120;

	private int fieldWidth;
	private int fieldHeight;
	
	private int chessBoardWidthOffset;
	private int chessBoardHeightOffset;

	private int blockWidthOffset = 35;
	private int blockHeightOffset = 20;
	
	private final int selfWidthOffset = -SAMURAI_WIDTH/2;
	private final int selfHeightOffset = -90;
		
	private int number;
	public SamuraiView samuraiV;
	
	public int x;
	public int y;
	private boolean isHide;
	private boolean canHide;
	private BooleanProperty canAction;
	
	private Text missText;
	private Text attackedText;
	
	public SamuraiGuidePanel(int number, int size){
		this.number = number;
		
		fieldWidth = BLOCK_WIDTH * size;
		fieldHeight = BLOCK_HEIGHT * size;
		
		chessBoardWidthOffset = (WINDOW_WIDTH-fieldWidth)/2;
		chessBoardHeightOffset = WINDOW_HEIGHT-fieldHeight-FIELD_FIX;
		
		this.setPrefWidth(SAMURAI_WIDTH);
		this.setPrefHeight(SAMURAI_HEIGHT);
		
		this.samuraiV = new SamuraiView(number, 1);
		this.isHide = false;
		this.canHide = false;
		this.canAction = new SimpleBooleanProperty(true);
		
		this.getChildren().add(samuraiV);

		samuraiV.setDirection(2);
		
		//text
		missText = new Text("Miss");
		missText.setId("text-miss");
		missText.setX(0);
		missText.setOpacity(0);
		
		attackedText = new Text();
		attackedText.setId("text-attacked");
		attackedText.setX(0);
		attackedText.setOpacity(0);
		this.getChildren().addAll(missText, attackedText);
	}
	
	public void setActualLocation(int x, int y){
		this.x = x;
		this.y = y;
		this.setLayoutX(chessBoardWidthOffset+fieldWidth/2+(y-x)*blockWidthOffset +selfWidthOffset);
		this.setLayoutY(chessBoardHeightOffset+(x+y)*blockHeightOffset +selfHeightOffset);
		this.zOrder = x + y;
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

	public boolean canHide(){

		return false;
	}

	public int getNum(){
		return this.number;
	}

	public boolean isHide() {
		return isHide;
	}

	public Position getPos(){
		return new Position(x, y);
	}

	public void occupy(int direction){
		samuraiV.occupy(direction);
	}
	
	public void move(int x, int y){
		canAction.setValue(false);
		if( x < this.x ){
			samuraiV.move(0);
		}else if( x > this.x ){
			samuraiV.move(3);
		}else if( y < this.y ){
			samuraiV.move(1);
		}else if( y > this.y ){
			samuraiV.move(2);
		}

		Timeline timeline = new Timeline(
				new KeyFrame(Duration.millis(1200), new KeyValue(this.layoutXProperty(), chessBoardWidthOffset+fieldWidth/2+(y-x)*blockWidthOffset +selfWidthOffset)),
				new KeyFrame(Duration.millis(1200), new KeyValue(this.layoutYProperty(), chessBoardHeightOffset+(x+y)*blockHeightOffset +selfHeightOffset))
				);
		timeline.play();
		this.x = x;
		this.y = y;
		this.zOrder = x + y;
		
		timeline.setOnFinished(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				canAction.setValue(true);
			}
		});
	}

	public void setWeapon(int weapon){
		samuraiV.setWeapon(weapon * 100 + 11);
	}
	
	public void setRandomArmor(){
		int armor[] = {11, 23, 34};
		Random random = new Random();
		int x = random.nextInt(3);
		System.out.println(armor[x]);
		samuraiV.setArmor(armor[x]);
	}

	public BooleanProperty canActionProperty(){
		return this.canAction;
	}
	
	public void setCanActionProperty(boolean canAction){
		this.canAction.set(canAction);
	}

	public void setCanHide(boolean canHide) {
		this.canHide = canHide;
	}

	public boolean isCanHide() {
		return canHide;
	}
}
