package view;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ArmorView extends StackPane {

	private double SCALE = 1;
	private int BODY_X;
	private int BODY_Y;

	private int num;
	private ImageView left;
	private ImageView body;
	private ImageView right;

	private ColorAdjust grayscale;

	public ArmorView(int number) {
		this(number, 1);
	}
	public ArmorView(int number, int scale) {
		number = number - 900;
		this.num = number;
		this.SCALE = scale;
		this.BODY_X = 28;
		this.BODY_Y = 20;

		this.setPrefSize(100 * SCALE, 100 * SCALE);

		if (Images.ARMOR[number / 100][number % 100 / 10] != null) {
			left = new ImageView(Images.WEAPON[number / 100][number % 100 / 10][0]);
			body = new ImageView(Images.WEAPON[number / 100][number % 100 / 10][1]);
			right = new ImageView(Images.WEAPON[number / 100][number % 100 / 10][3]);
			left.setPreserveRatio(true);
			body.setPreserveRatio(true);
			right.setPreserveRatio(true);
			left.setSmooth(true);
			body.setSmooth(true);
			right.setSmooth(true);

			this.setInit();
			this.getChildren().addAll(right, body, left);
		}

	}

	private void setInit() {
		switch (num / 100) {
		// 布甲
		case 1:

			left.setFitWidth(16 * SCALE);
			left.setLayoutX(BODY_X - 1 * SCALE);
			left.setLayoutY(BODY_Y + 2 * SCALE);

			body.setFitWidth(29 * SCALE);
			body.setLayoutX(BODY_X);
			body.setLayoutY(BODY_Y);

			right.setFitWidth(11 * SCALE);
			right.setLayoutX(BODY_X + 15 * SCALE);
			right.setLayoutY(BODY_Y - 1 * SCALE);

			break;

		// 皮甲
		case 2:

			left.setFitWidth(13 * SCALE);
			left.setLayoutX(BODY_X - 3 * SCALE);
			left.setLayoutY(BODY_Y + 4 * SCALE);

			body.setFitWidth(29 * SCALE);
			body.setLayoutX(BODY_X);
			body.setLayoutY(BODY_Y);

			right.setFitWidth(11 * SCALE);
			right.setLayoutX(BODY_X + 17 * SCALE);
			right.setLayoutY(BODY_Y + 2 * SCALE);

			break;

		// 铁甲
		case 3:

			left.setFitWidth(10 * SCALE);
			left.setLayoutX(BODY_X);
			left.setLayoutY(BODY_Y + 2 * SCALE);

			body.setFitWidth(32 * SCALE);
			body.setLayoutX(BODY_X - 1 * SCALE);
			body.setLayoutY(BODY_Y);

			right.setFitWidth(9 * SCALE);
			right.setLayoutX(BODY_X + 17 * SCALE);
			right.setLayoutY(BODY_Y);

			break;
		}
	}

}
