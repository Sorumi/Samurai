package view.smithy;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import view.story.ArmorView;
import view.story.WeaponView;

public class SmithyItemView extends Pane{

	private final int RADIUS = 50;
	public int itemNum;
//	
//	public ImageView item;
	public WeaponView weapon;
	public ArmorView armor;
	
	public Group group;
	private SmithyItemLine line;
	
	/*
	 * line:
	 * -1: 无线
	 * 0: 直线
	 * -700 -- 700: 折线
	 */
	public SmithyItemView(int itemNum){
		this.itemNum = itemNum;
		
		this.setPrefSize(RADIUS*2, RADIUS*2);
		this.setLayoutX(-80+(itemNum%10)*150);		
		
		Circle strokeCircle = new Circle();
		strokeCircle.setCenterX(RADIUS);
		strokeCircle.setCenterY(RADIUS);
		strokeCircle.setRadius(RADIUS);
		strokeCircle.setFill(null);
		strokeCircle.setStroke(Color.WHITE);
		strokeCircle.setStrokeWidth(5);
		strokeCircle.setStrokeType(StrokeType.INSIDE);
		
		Circle fillCircle = new Circle();
		fillCircle.setCenterX(RADIUS);
		fillCircle.setCenterY(RADIUS);
		fillCircle.setRadius(RADIUS-10);
		fillCircle.setFill(Color.WHITE);
		
		if (itemNum/100 != 9){
			weapon = new WeaponView(itemNum);
			StackPane.setAlignment(weapon,Pos.CENTER);
			group = new Group();
			group.getChildren().addAll(strokeCircle, fillCircle, weapon);
		}else{
			armor = new ArmorView(itemNum);
			StackPane.setAlignment(armor,Pos.CENTER);
			group = new Group();
			group.getChildren().addAll(strokeCircle, fillCircle, armor);
		}
		
		

		this.getChildren().add(group);
		
	}
	public SmithyItemView(int itemNum, int lineHeight){
		this(itemNum);
		if(lineHeight != -1){
			line = new SmithyItemLine(lineHeight);
			line.setLayoutY(RADIUS);
			this.getChildren().add(line);
		}
	}
	public SmithyItemView(int itemNum, int lineHeight1, int lineHeight2){
		this(itemNum);
		if(lineHeight1 != -1 && lineHeight2 != -1){
			line = new SmithyItemLine(lineHeight1, lineHeight2);
			line.setLayoutY(RADIUS);
			this.getChildren().add(line);
		}
	}
	
	public int getItemNum(){
		return this.itemNum;
	}

}
