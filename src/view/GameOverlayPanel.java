package view;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

public class GameOverlayPanel extends OrderPanel {

	private Label levelNum;
	private Label levelName;
	private Label levelDescription;
	
	public GameOverlayPanel(){
		this.setPrefSize(1200, 800);
		this.setStyle("-fx-background-color: rgba(0,0,0,0.3)");
		
		OverlayLine lineTop = new OverlayLine();
		lineTop.setLayoutX(200);
		lineTop.setLayoutY(70);
		
		OverlayLine lineDown = new OverlayLine();
		lineDown.setLayoutX(200);
		lineDown.setLayoutY(650);
		lineDown.setScaleY(-1);
		
		Line line = new Line();
		line.setStartX(570);
		line.setStartY(380);
		line.setEndX(630);
		line.setEndY(380);
		line.setStroke(Color.WHITE);
		
		levelNum = new Label("I");
		levelNum.setId("overlay-level-num");
		levelNum.setPrefSize(20, 30);
		levelNum.setLayoutX(590);
		levelNum.setLayoutY(190);
		
		levelName = new Label("盛夏之园");
		levelName.setId("overlay-level-name");
		levelName.setPrefSize(100, 30);
		levelName.setLayoutX(550);
		levelName.setLayoutY(230);
		
		levelDescription = new Label("这是写剧情的地方");
		levelDescription.setId("overlay-level-description");
		levelDescription.setPrefSize(600, 100);
		levelDescription.setLayoutX(300);
		levelDescription.setLayoutY(470);
		
		this.getChildren().addAll(lineTop, lineDown, line, levelNum, levelName, levelDescription);
	}
	
	public class OverlayLine extends Polyline{
		public OverlayLine(){
			this.getPoints().addAll(new Double[]{
				    0.0, 80.0,
				    320.0, 80.0,
				    340.0, 60.0,
				    360.0, 80.0,
				    420.0, 20.0,
				    400.0, 0.0,
				    380.0, 20.0,
				    440.0, 80.0,
				    460.0, 60.0,
				    480.0, 80.0,
				    800.0, 80.0});
			this.setStroke(Color.WHITE);
		}
	}
}
