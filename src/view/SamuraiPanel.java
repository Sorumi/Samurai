package view;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.po.Position;
import musics.Musics;

public class SamuraiPanel extends OrderPanel {

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
	public SamuraiView samuraiV;
	
	public int x;
	public int y;
	private boolean isHide;
	private boolean canHide;
	private BooleanProperty canAction;
	
	private Text missText;
	private Text attackedText;
	
	private DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.WHITE, 0, 1, 0, 0);
	private ColorAdjust light = new ColorAdjust();
	
	public SamuraiPanel(int number, int size){
		this.number = number;
		
		this.setPrefWidth(SAMURAI_WIDTH);
		this.setPrefHeight(SAMURAI_HEIGHT);
		
//		this.setStyle("-fx-background-color: rgba(255,0,0,0.5)");
		this.samuraiV = new SamuraiView(number, 1);
		this.isHide = false;
		this.canHide = false;
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
		
		shadow.setInput(light);
		this.setEffect(shadow);
		
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
		this.setLayoutX(chessBoardWidthOffset+FIELD_WIDTH/2+(y-x)*blockWidthOffset +selfWidthOffset);
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
		switch(samuraiV.getWeaponNumber()/100){
		case 0: Musics.playEffectMusic(3);break;
		case 1: Musics.playEffectMusic(4);break;
		case 2: Musics.playEffectMusic(5);break;
		case 3: Musics.playEffectMusic(6);break;
		case 4: Musics.playEffectMusic(7);break;
		
		}
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
				new KeyFrame(Duration.millis(1200), new KeyValue(this.layoutXProperty(), chessBoardWidthOffset+FIELD_WIDTH/2+(y-x)*blockWidthOffset +selfWidthOffset)),
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
		Musics.playEffectMusic(2);
	}
	
	public void setInjured(boolean isInjured){
		if ( number/4 == 0 ){
			samuraiV.setInjured(isInjured, 2);
		}else{
			samuraiV.setInjured(isInjured, 3);
		}
		Musics.playEffectMusic(9); 
	}
	
	public void setMiss(){
		Timeline missTL= new Timeline(
				//text
				new KeyFrame(Duration.ZERO, new KeyValue(missText.opacityProperty(), 1)),
				new KeyFrame(Duration.millis(800), new KeyValue(missText.opacityProperty(), 1)),
				new KeyFrame(Duration.millis(1200), new KeyValue(missText.opacityProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.ZERO, new KeyValue(missText.yProperty(), 10)),
				new KeyFrame(Duration.millis(1200), new KeyValue(missText.yProperty(), -20, Interpolator.EASE_IN))
				);
		missTL.play();
		samuraiV.setMiss();
	}
	
	public void setAttacked(int num){
		attackedText.setText("- " + num);//TODO
		Timeline attackTL= new Timeline(
				//text
				new KeyFrame(Duration.ZERO, new KeyValue(attackedText.opacityProperty(), 1)),
				new KeyFrame(Duration.millis(800), new KeyValue(attackedText.opacityProperty(), 1)),
				new KeyFrame(Duration.millis(1200), new KeyValue(attackedText.opacityProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.ZERO, new KeyValue(attackedText.yProperty(), 10)),
				new KeyFrame(Duration.millis(1200), new KeyValue(attackedText.yProperty(), -20, Interpolator.EASE_IN))
				);
		attackTL.play();
		samuraiV.setAttacked();
		Musics.playEffectMusic(8);
	}

	public void setDoubleAttacked(int num){
		attackedText.setText("- " + num + "×2");//TODO

		Timeline attackTL= new Timeline(
				//text
				new KeyFrame(Duration.ZERO, new KeyValue(attackedText.opacityProperty(), 1)),
				new KeyFrame(Duration.millis(800), new KeyValue(attackedText.opacityProperty(), 1)),
				new KeyFrame(Duration.millis(1200), new KeyValue(attackedText.opacityProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.ZERO, new KeyValue(attackedText.yProperty(), 10)),
				new KeyFrame(Duration.millis(1200), new KeyValue(attackedText.yProperty(), -20, Interpolator.EASE_IN))
				
				);
		attackTL.play();
		samuraiV.setDoubleAttacked();
		Musics.playEffectMusic(8);
	}
	
	public void setHighlight() {
		Timeline effectTL = new Timeline(
				new KeyFrame(Duration.millis(300),
						new KeyValue(light.brightnessProperty(), 0.2, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(300), new KeyValue(shadow.radiusProperty(), 2, Interpolator.EASE_IN)));
		effectTL.play();
	}

	public void setNormal() {
		Timeline effectTL = new Timeline(
				new KeyFrame(Duration.millis(300),
						new KeyValue(light.brightnessProperty(), 0, Interpolator.EASE_IN)),
				new KeyFrame(Duration.millis(300), new KeyValue(shadow.radiusProperty(), 0, Interpolator.EASE_IN)));
		effectTL.play();
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
