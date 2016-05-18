package view.guide;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import images.Images;

public class GuidePanel2 extends GuidePanel {
	private Label mainLabel;
	private Label explainLabel1;
	private Label explainLabel2;
	private Label explainLabel3;
	private Label explainLabel4;

	public GuidePanel2() {
		mainLabel = new Label("基本操作");
		mainLabel.setLayoutX(100);
		mainLabel.setLayoutY(100);
		mainLabel.setId("main-label");

		explainLabel1 = new Label("占领 / 攻击：消耗四个行动点，武士使用自己的武器向周围任意一个方向做出攻击动作，占领相应区域，若区域内有敌方武士，则对其发动攻击。在经典模式中，敌方武士将会被击退回到老家；在故事模式中，则有相应的伤害计算，我们将稍后对其进行说明。");
		explainLabel1.setLayoutX(180);
		explainLabel1.setLayoutY(157);
		explainLabel1.setPrefSize(800, 100);
		explainLabel1.setId("explain-label");

		explainLabel2 = new Label("移动：消耗两个行动点，可以向武士的周围空格移动一步。");
		explainLabel2.setLayoutX(180);
		explainLabel2.setLayoutY(285);
		explainLabel2.setPrefSize(800, 102);
		explainLabel2.setId("explain-label");

		explainLabel3 = new Label("隐身：消耗一个行动点，武士可以在己方的领地内隐身，隐身的武士不会被敌人发现，隐身的武士可以与未隐身的武士在同一块土地上，隐身的武士不能走出己方的领地。" + "\n"
				+ "现身：消耗一个行动点，如果武士处于隐身状态，再次点击则会现身，回到正常状态，隐身武士不能在有现身武士的格子里现身。");
		explainLabel3.setLayoutX(180);
		explainLabel3.setLayoutY(380);
		explainLabel3.setPrefSize(800, 165);
		explainLabel3.setId("explain-label");

		explainLabel4 = new Label("听了以上的说明，您是不是跃跃欲试了呢?" + "\n" + "您可以动手操作一下下一页中的武士，下页中的武士的行动时间无限，行动点数也无限。" + "\n"
				+ "在您的武士附近(视野之外)有一个稻草人标靶，找到他并将其击退之后，让我们进入第二部分。");
		explainLabel4.setLayoutX(180);
		explainLabel4.setLayoutY(550);
		explainLabel4.setPrefSize(800, 100);
		explainLabel4.setId("explain-label");
		this.getChildren().addAll(mainLabel, explainLabel1, explainLabel2, explainLabel3, explainLabel4);
		for (int num = 0; num <= 2; num++) {
			ImageView action_btn = new ImageView(Images.ACTION_BUTTON[num]);
			action_btn.setFitWidth(58);
			action_btn.setPreserveRatio(true);
			action_btn.setLayoutX(100);
			action_btn.setLayoutY(170 + 100 * num);
			this.getChildren().add(action_btn);
		}
		this.setVisible(true);
	}

}
