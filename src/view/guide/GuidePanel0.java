package view.guide;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import view.Images;

public class GuidePanel0 extends GuidePanel {
	private Rectangle bgRect;

	private Label mainLabel1;
	private Label mainLabel2;
	private Label explainLabel1;
	private Label explainLabel2;
	private Label explainLabel3;

	private Group lineGroup;

	public GuidePanel0() {
		super();

		bgRect = new Rectangle();
		bgRect.setWidth(1100);
		bgRect.setHeight(700);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		bgRect.setLayoutX(0);
		bgRect.setLayoutY(0);

		mainLabel1 = new Label("概 述");
		mainLabel1.setLayoutX(100);
		mainLabel1.setLayoutY(100);
		mainLabel1.setId("main-label");

		mainLabel2 = new Label("基本概念");
		mainLabel2.setLayoutX(100);
		mainLabel2.setLayoutY(300);
		mainLabel2.setId("main-label");

		explainLabel1 = new Label("本游戏是一个即时战略类的战棋类游戏，通过游戏双方操控自己的三个武士进行武装占领和互相作战，争取最大的领地，登上王者的宝座。游戏终了时，通过判断领地的多少来决定胜负。");
		explainLabel1.setLayoutX(100);
		explainLabel1.setLayoutY(120);
		explainLabel1.setPrefSize(800, 100);
		explainLabel1.setId("explain-label");

		explainLabel2 = new Label(
				"作战区域：战场上15*15的区域，武士任何的行为都要在该区域之内。" + "\n" + "视野：每个武士有自己能看到的视野范围，每个玩家的三个武士可以共享视野范围，视野之外的地图将显示为灰色空白。"
						+ "\n" + "出生地：每个武士有自己的出生位置，该位置仅用于出生和复活，一旦离开，便不能反回。" + "\n" + "冻结轮数：武士被击退后，会在复活点处休息一定回合，不能操作。");
		explainLabel2.setLayoutX(100);
		explainLabel2.setLayoutY(350);
		explainLabel2.setId("explain-label");

		explainLabel3 = new Label("行动顺序：");
		explainLabel3.setLayoutX(100);
		explainLabel3.setLayoutY(532);
		explainLabel3.setId("explain-label");
		this.getChildren().addAll(bgRect, mainLabel1, mainLabel2, explainLabel1, explainLabel2, explainLabel3);
		
		for (int num = 1; num <= 6; num++) {
			ImageView samurai = new ImageView(Images.SAMURAI_BTN[num]);
			samurai.setFitWidth(52);
			samurai.setPreserveRatio(true);
			samurai.setLayoutX(305 + 110 * (num - 1));
			samurai.setLayoutY(516);
			this.getChildren().add(samurai);
		}

		for (int i = 0; i < 5; i++) {
			lineGroup group = new lineGroup();
			group.setLayoutX(362 + 110 * i);
			group.setLayoutY(532);
			this.getChildren().add(group);
		}
	}

	public class lineGroup extends Group {
		public lineGroup() {
			Line line1 = new Line();
			line1.setStartX(0);
			line1.setStartY(11);
			line1.setEndX(46);
			line1.setEndY(11);
			line1.setStroke(Color.web("#DDDDDD"));
			line1.setStrokeWidth(3);

			Line line2 = new Line();
			line2.setStartX(31);
			line2.setStartY(0);
			line2.setEndX(46);
			line2.setEndY(11);
			line2.setStroke(Color.web("#DDDDDD"));
			line2.setStrokeWidth(3);

			Line line3 = new Line();
			line3.setStartX(31);
			line3.setStartY(26);
			line3.setEndX(46);
			line3.setEndY(11);
			line3.setStroke(Color.web("#DDDDDD"));
			line3.setStrokeWidth(3);

			this.getChildren().addAll(line1, line2, line3);
		}
	}

}
