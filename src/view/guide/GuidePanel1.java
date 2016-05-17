package view.guide;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import view.GameColor;
import view.Images;
import view.PlayerPanel;
import view.RoundPanel;

public class GuidePanel1 extends GuidePanel {

	public GuidePanel1() {
		super();
		RoundPanel roundPanel = new RoundPanel(24);
		roundPanel.setLayoutX(503);
		roundPanel.setLayoutY(175);
		roundPanel.currentRing.setStroke(GameColor.getBlockColor(1));

//		Rectangle bgRect = new Rectangle();
//		bgRect.setWidth(200);
//		bgRect.setHeight(30);
//		bgRect.setArcWidth(100);
//		bgRect.setArcHeight(10);
//		bgRect.setFill(Color.ALICEBLUE);
//		bgRect.setLayoutX(585);
//		bgRect.setLayoutY(585);
//		Rectangle fillRect = new Rectangle();
//		fillRect.setWidth(150);
//		fillRect.setHeight(30);
//		fillRect.setFill(GameColor.getBlockColor(1));
//		fillRect.setLayoutX(583);
//		fillRect.setLayoutY(585);
//		Label pointsLabel = new Label("" + 4);
//		pointsLabel.setLayoutX(695);
//		pointsLabel.setLayoutY(585);
//		pointsLabel.setId("main-label");
//		pointsLabel.setTextFill(Color.WHITE);
		
		PlayerPanel playerPanel = new PlayerPanel(0, 30);
		playerPanel.circlePanel.timeArc.setStartAngle(90);
		playerPanel.circlePanel.timeArc.setLength(120);
		// playerPanel.pointsPanel.bgRect.setFill(GameColor.getBlockColor(1));
		// playerPanel.pointsPanel.pointsLabel.setText(20+"");
		// playerPanel.pointsPanel.fillRect.setFill(GameColor.getBlockColor(1));
		// for(int i=1;i<=3;i++){
		// Arc arc = new Arc();
		// arc.setCenterX(102);
		// arc.setCenterY(102);
		// arc.setRadiusX(100);
		// arc.setRadiusY(100);
		// arc.setStartAngle(90-30*(i-1));
		// arc.setLength(-70);
		// arc.setType(ArcType.ROUND);
		// arc.setFill(GameColor.getBlockColor(i));
		// playerPanel.getChildren().add(arc);
		// }
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
		label3.setPrefSize(200, 100);
		label3.setLayoutX(188);
		label3.setLayoutY(474);
		label3.setId("explain-label");

		Label label4 = new Label("总回合数");
		label4.setLayoutX(688);
		label4.setLayoutY(102);
		label4.setId("explain-label");

		Label label5 = new Label("领地");
		label5.setLayoutX(671);
		label5.setLayoutY(335);
		label5.setId("explain-label");

		Label label6 = new Label("武士通过占领获得的与自己颜色相同的地区，是判定胜负的决定性因素。移动到扇形图上可显示已占领的地区数。");
		label6.setPrefSize(300, 100);
		label6.setLayoutX(667);
		label6.setLayoutY(385);
		label6.setId("explain-label");

		Label label7 = new Label("行动点");
		label7.setLayoutX(838);
		label7.setLayoutY(510);
		label7.setId("explain-label");

		Label label8 = new Label("武士的不同行为需要消耗不同的行动点。");
		label8.setPrefSize(200, 100);
		label8.setLayoutX(842);
		label8.setLayoutY(566);
		label8.setId("explain-label");

		GuideLine guideLine1 = new GuideLine(0, 1, 1);
		guideLine1.setLayoutX(349);
		guideLine1.setLayoutY(233);
		
		GuideLine guideLine2 = new GuideLine(0, 0, 0);
		guideLine2.setLayoutX(302);
		guideLine2.setLayoutY(464);
		
		GuideLine guideLine3 = new GuideLine(1, 1, 0);
		guideLine3.setLayoutX(625);
		guideLine3.setLayoutY(143);
		
		GuideLine guideLine4 = new GuideLine(1, 1, 0);
		guideLine4.setLayoutX(618);
		guideLine4.setLayoutY(380);
		
		GuideLine guideLine5 = new GuideLine(1, 1, 0);
		guideLine5.setLayoutX(785);
		guideLine5.setLayoutY(557);

		this.getChildren().addAll(roundPanel, playerPanel, label1, label2, label3, label4, label5, label6, label7,
				label8, guideLine1, guideLine2, guideLine3, guideLine4, guideLine5);
		this.setVisible(true);
	}

}
