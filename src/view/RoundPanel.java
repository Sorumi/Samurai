package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;

public class RoundPanel extends OrderPanel{
	
	private Label roundTotal;
	private Label roundCurrent;
	private Circle currentRing;

	public RoundPanel(int total){
		//bounds
		this.setLayoutX(1000);
		this.setLayoutY(30);
		this.setPrefWidth(137);
		this.setPrefHeight(72);
		this.setStyle("-fx-background-color: #DDDDDD");
		
		Rectangle totalCircle = new Rectangle();
		totalCircle.setWidth(100);
		totalCircle.setHeight(50);
		totalCircle.setX(36);
		totalCircle.setY(11);
		totalCircle.setArcWidth(50);
		totalCircle.setArcHeight(50);
		totalCircle.setFill(Color.WHITE);
		this.getChildren().add(totalCircle);
		
		Circle currentCircle = new Circle();
		currentCircle.setCenterX(36);
		currentCircle.setCenterY(36);
		currentCircle.setRadius(31);
		currentCircle.setStroke(Color.WHITE);
		currentCircle.setStrokeType(StrokeType.OUTSIDE);
		currentCircle.setStrokeWidth(5);
		currentCircle.setFill(Color.WHITE);
		this.getChildren().add(currentCircle);
		
		currentRing = new Circle();
		currentRing.setCenterX(36);
		currentRing.setCenterY(36);
		currentRing.setRadius(28);
		currentRing.setStrokeType(StrokeType.OUTSIDE);
		currentRing.setStrokeWidth(3);
		currentRing.setFill(Color.WHITE);
		this.getChildren().add(currentRing);
		
		Font fontBig = Font.font("Tsukushi B Round Gothic", 26);
		Font fontSmall = Font.font("Tsukushi B Round Gothic", 22);
		
		roundTotal = new Label(total + "");
		roundTotal.setFont(fontSmall);
		roundTotal.setTextFill(GameColor.getOtherColor(2));
		roundTotal.setAlignment(Pos.CENTER);
		roundTotal.setLayoutX(70);
		roundTotal.setLayoutY(23);
		roundTotal.setPrefWidth(50);
//		roundTotal.setStyle("-fx-background-color: #DDDDDD");
		this.getChildren().add(roundTotal);
		
		roundCurrent = new Label("30");
		roundCurrent.setFont(fontBig);
		roundCurrent.setTextFill(GameColor.getOtherColor(2));
		roundCurrent.setAlignment(Pos.CENTER);
		roundCurrent.setLayoutX(2);
		roundCurrent.setLayoutY(22);
		roundCurrent.setPrefWidth(70);
//		roundCurrent.setStyle("-fx-background-color: #DDDDDD");
		this.getChildren().add(roundCurrent);
		
	}
	
	public void setRoundTotal(int total){
		roundTotal.setText(total + "");
	}
	
	public void setRoundCurrent(int current){
		roundCurrent.setText(current + "");
		currentRing.setStroke(GameColor.getBlockColor(current%6));
	}
	
}
