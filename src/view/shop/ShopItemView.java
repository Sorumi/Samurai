package view.shop;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import view.GameColor;
import view.story.PropView;
import view.story.WeaponView;

public class ShopItemView extends StackPane {
	private final int RADIUS = 50;
	private int itemNum;
	private Circle bgCircle;
	private ColorAdjust light;
	
	public ShopItemView(int itemNum){
		this.itemNum = itemNum;
		
		this.setPrefSize(RADIUS*2, RADIUS*2);
		//颜色以后根据里面的东西改
		bgCircle = new Circle();
		bgCircle.setCenterX(RADIUS);
		bgCircle.setCenterY(RADIUS);
		bgCircle.setRadius(RADIUS);
		bgCircle.setFill(Color.web("#E2ECEE"));
		bgCircle.setStroke(Color.web("#AECDD2"));
		bgCircle.setStrokeType(StrokeType.INSIDE);
		bgCircle.setStrokeWidth(0);
		this.getChildren().add(bgCircle);
		
		PropView prop = new PropView(itemNum,3);  
		this.getChildren().add(prop);
		StackPane.setAlignment(prop,Pos.CENTER);
		
		light = new ColorAdjust();
		this.setEffect(light);
	}
	
	public void setHighlight() {		
		Timeline tl= new Timeline(
				new KeyFrame(Duration.millis(300), new KeyValue(light.brightnessProperty(), 0.4, Interpolator.EASE_IN))
				);
		tl.play();
	}
	
	public void setNormal(){
		Timeline tl= new Timeline(
				new KeyFrame(Duration.millis(300), new KeyValue(light.brightnessProperty(), 0,  Interpolator.EASE_IN))
				);
		tl.play();	
	}
	public int getNum(){
		return this.itemNum;
	}

}
