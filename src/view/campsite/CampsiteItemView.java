package view.campsite;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import view.GameColor;
import view.WeaponView;

public class CampsiteItemView extends StackPane {

	private final int RADIUS = 50;
	private int itemNum;
	private Circle bgCircle;
	
	public CampsiteItemView(int itemNum){
		this.itemNum = itemNum;
		
		this.setPrefSize(RADIUS*2, RADIUS*2);
		
		bgCircle = new Circle();
		bgCircle.setCenterX(RADIUS);
		bgCircle.setCenterY(RADIUS);
		bgCircle.setRadius(RADIUS);
		bgCircle.setFill(GameColor.getWeaponColor(itemNum/100));
		bgCircle.setStroke(GameColor.getWeaponColor(itemNum/100+10));
		bgCircle.setStrokeType(StrokeType.INSIDE);
		bgCircle.setStrokeWidth(0);
		this.getChildren().add(bgCircle);
		
		WeaponView weapon = new WeaponView(itemNum);
		this.getChildren().add(weapon);
		StackPane.setAlignment(weapon,Pos.CENTER);

	}

	public void setHighlight() {
		bgCircle.setFill(GameColor.getWeaponColor(itemNum/100+5));
		bgCircle.setStrokeWidth(2);
	}
	
	public void setNormal(){
		bgCircle.setFill(GameColor.getWeaponColor(itemNum/100));
		bgCircle.setStrokeWidth(0);
	}
	
	public int getNum(){
		return this.itemNum;
	}
}