package view.campsite;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import view.GameColor;
import view.eventhandler.CampsiteHandler;

public class CampsiteItemView extends Pane {

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
		
//		this.setOnMouseEntered(campsiteHandler.itemEnterEvent);
	}

	public void setHighlight() {
		bgCircle.setFill(GameColor.getWeaponColor(itemNum/100+5));
		bgCircle.setStrokeWidth(2);
	}
	
	public void setNormal(){
		bgCircle.setFill(GameColor.getWeaponColor(itemNum/100));
		bgCircle.setStrokeWidth(0);
	}
	
}
