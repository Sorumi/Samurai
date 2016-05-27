package view;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

public class GameOverlayPanel extends OrderPanel {

	private Label levelNumLabel;
	private Label levelNameLabel;
	private Label levelDescriptionLabel;
	
	public GameOverlayPanel(int num){
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
		
		levelNumLabel = new Label();
		levelNumLabel.setId("overlay-level-num");
		levelNumLabel.setPrefSize(20, 30);
		levelNumLabel.setLayoutX(590);
		levelNumLabel.setLayoutY(190);
		
		levelNameLabel = new Label();
		levelNameLabel.setId("overlay-level-name");
		levelNameLabel.setPrefSize(100, 30);
		levelNameLabel.setLayoutX(550);
		levelNameLabel.setLayoutY(230);
		
		levelDescriptionLabel = new Label();
		levelDescriptionLabel.setId("overlay-level-description");
		levelDescriptionLabel.setPrefSize(600, 100);
		levelDescriptionLabel.setLayoutX(300);
		levelDescriptionLabel.setLayoutY(470);
		
		setLevel(num);
		this.getChildren().addAll(lineTop, lineDown, line, levelNumLabel, levelNameLabel, levelDescriptionLabel);
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
	
	private void setLevel(int num){
		String levelNum = "";
		String levelName = "";
		String levelDescription = "";
		
		switch(num){
		case 1:
			levelNum = "I";
			levelName = "盛夏之园";
			levelDescription = "骄阳之下，密林之中，蝉鸣之时";
			break;
		case 2:
			levelNum = "II";
			levelName = "秋雨之谷";
			levelDescription = "秋雨绵绵，滴滴牵魂，鸿雁阵阵，声声入梦";
			break;
		case 3:
			levelNum = "III";
			levelName = "清莲之塘";
			levelDescription = "舞蹈吧，让水面波澜；歌唱吧，让花瓣缤纷";
			break;
		case 4:
			levelNum = "IV";
			levelName = "星耀之夜";
			levelDescription = "从赤手空拳，到顶盔掼甲，让苍穹见证你们的胜利";
			break;
		case 5:
			levelNum = "V";
			levelName = "樱花之源";
			levelDescription = "二月初开，四月落得一地缤纷，这生命短暂，却在凋落之时最为绚烂";
			break;
		}
		
		levelNumLabel.setText(levelNum);
		levelNameLabel.setText(levelName);
		levelDescriptionLabel.setText(levelDescription);
	}
}
