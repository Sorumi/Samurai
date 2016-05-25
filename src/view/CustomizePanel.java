package view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.po.Position;
import view.eventhandler.CustomizeHandler;

public class CustomizePanel extends Pane {
	
	private CustomizeHandler customizeHandler;
	
	public ChessBoardPanel chessBoard;
	
	private Button startBtn;
	
	private SamuraiView A1;
	private SamuraiView A2;
	private SamuraiView A3;
	private SamuraiView B1;
	private SamuraiView B2;
	private SamuraiView B3;
	
	public Position[] positions;
	
	public CustomizePanel(){
		
		this.setPrefSize(1200, 800);
		this.setStyle("-fx-background-image: url("+Images.BG[0]+") ;"
	    		+ "-fx-background-size: 100% 100%; ");
		
		customizeHandler = new CustomizeHandler(this);
		
		//chessBoard
		chessBoard = new ChessBoardPanel(15);
		
		//btn
        startBtn = new Button("开始游戏");
        startBtn.setId("customize-start-btn");
        startBtn.setPrefSize(140, 50);
        startBtn.setLayoutX(530);
        startBtn.setLayoutY(50);
        startBtn.setOnMouseClicked(customizeHandler.startEvent);
        
		//samuraiWrapper
		Rectangle rect1= new Rectangle(280, 160);
		rect1.setFill(Color.WHITE);
		rect1.setArcWidth(10);
		rect1.setArcHeight(10);
		rect1.setId("shadow-rect");
		rect1.setLayoutX(5);
		rect1.setLayoutY(635);
		
		Rectangle rect2= new Rectangle(280, 160);
		rect2.setFill(Color.WHITE);
		rect2.setArcWidth(10);
		rect2.setArcHeight(10);
		rect2.setId("shadow-rect");
		rect2.setLayoutX(915);
		rect2.setLayoutY(635);
		
		//samurai
		A1 = new SamuraiView(1,1);
		A2 = new SamuraiView(2,1);
		A3 = new SamuraiView(3,1);
		B1 = new SamuraiView(4,1);
		B2 = new SamuraiView(5,1);
		B3 = new SamuraiView(6,1);

		setDraggableSamurai(A1);
		setDraggableSamurai(A2);
		setDraggableSamurai(A3);
		setDraggableSamurai(B1);
		setDraggableSamurai(B2);
		setDraggableSamurai(B3);
		
		positions = new Position[6];
		for(int i=0; i<6; i++){
			positions[i] = new Position(-1, -1);
		}
		
		this.getChildren().addAll(chessBoard, rect1, rect2, A1, A2, A3, B1, B2, B3, startBtn);
	}
	
	public void setDraggableSamurai(SamuraiView samurai){
		if (samurai.getNumber()<4){
			samurai.setLayoutX(30+85*(samurai.getNumber()-1));
			samurai.setDirection(2);
		}else{
			samurai.setLayoutX(940+85*(samurai.getNumber()-4));
			samurai.setDirection(3);
		}
		
		samurai.setLayoutY(655);
		samurai.setOnMouseClicked(null);
		samurai.setOnMousePressed(customizeHandler.samuraiOnMousePressedEventHandler);
		samurai.setOnMouseDragged(customizeHandler.samuraiOnMouseDraggedEventHandler);
		samurai.setOnMouseReleased(customizeHandler.samuraiOnMouseReleasedEventHandler);
	}
	
}
