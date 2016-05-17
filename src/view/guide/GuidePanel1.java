package view.guide;

import javafx.scene.control.Label;
import view.GameColor;
import view.PlayerPanel;
import view.RoundPanel;

public class GuidePanel1 {
	private GuideLine guideLine;
	
	public GuidePanel1(){
		RoundPanel roundPanel = new RoundPanel(24);
		roundPanel.setLayoutX(503);
		roundPanel.setLayoutY(175);
		
		PlayerPanel playerPanel = new PlayerPanel(0,30);
		playerPanel.pointsPanel.pointsLabel.setText(20+"");
		playerPanel.pointsPanel.fillRect.setFill(GameColor.getBlockColor(0));
		playerPanel.setLayoutX(450);
		playerPanel.setLayoutY(417);
		
		Label label1 = new Label("当前回合数");
		label1.setLayoutX(360);
		label1.setLayoutY(229);
		label1.setId("explain-label");
		
		Label label2 = new Label("行动时间");
		label2.setLayoutX(330);
		label2.setLayoutY(417);
		label2.setId("explain-label");
		
		Label label3 = new Label("每个武士每回合有一定时间来执行操作，时间终了时，操作权将交给下一位武士。");
		label3.setPrefSize(100, 100);
		label3.setLayoutX(188);
		label3.setLayoutY(474);
		label3.setId("explain-label");
		
		Label label4 = new Label("总回合数");
		label4.setLayoutX(688);
		label4.setLayoutY(102);
		label4.setId("explain-label");
		
		Label label5 = new Label("领地");
		label5.setLayoutX(671);
		label5.setLayoutY(331);
		label5.setId("explain-label");
		
		Label label6 = new Label("当前回合数");
		label6.setLayoutX(360);
		label6.setLayoutY(229);
		label6.setId("explain-label");
		
		Label label7 = new Label("当前回合数");
		label7.setLayoutX(360);
		label7.setLayoutY(229);
		label7.setId("explain-label");
		
		Label label8 = new Label("当前回合数");
		label8.setLayoutX(360);
		label8.setLayoutY(229);
		label8.setId("explain-label");
	}

}
