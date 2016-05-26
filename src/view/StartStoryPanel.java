package view;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import view.eventhandler.StoryHandler;
import view.items.DialogView;
import view.items.NumenView;

public class StartStoryPanel extends Pane {

	private SystemButton skipBtn;

	private NumenView numen;
	private Rectangle overlay;

	private SamuraiView samurai1;
	private SamuraiView samurai2;
	private SamuraiView samurai3;
	private Group samuraiGroup;

	private DialogView dialog;
	public int storyNum;

	private TranslateTransition tt1;
	private TranslateTransition tt2;
	private TranslateTransition tt3;

	public StartStoryPanel(StoryHandler storyHandler) {
		this.setPrefSize(1200, 800);
		this.setStyle("-fx-background-color: #000");
		this.setOnMouseClicked(storyHandler.nextEvent);

		// skip btn
		skipBtn = new SystemButton(7);
		skipBtn.setLayoutX(1125);
		skipBtn.setLayoutY(25);
		skipBtn.setOnMouseClicked(storyHandler.skipStoryEvent);
		
		// samurai
		samurai1 = new SamuraiView(1, 2);
		samurai1.setWeapon(11);
		samurai1.setArmor(11);
		samurai1.setLayoutX(300);
		samurai2 = new SamuraiView(2, 2);
		samurai2.setWeapon(111);
		samurai2.setArmor(11);
		samurai2.setLayoutX(150);
		samurai3 = new SamuraiView(3, 2);
		samurai3.setWeapon(211);
		samurai3.setArmor(11);
		samurai3.setLayoutX(0);

		samuraiGroup = new Group();
		samuraiGroup.setLayoutX(400);
		samuraiGroup.setLayoutY(500);
		samuraiGroup.getChildren().addAll(samurai1, samurai2, samurai3);

		overlay = new Rectangle(1200, 800);
		overlay.setFill(Color.BLACK);

		numen = new NumenView();

		this.getChildren().addAll(samuraiGroup, overlay, numen, skipBtn);

		setPathAnimation();
		storyNum = 0;
	}

	public void setPathAnimation() {
		// numen path
		Path path = new Path();
		path.getElements().add(new MoveTo(211, 285));
		path.getElements().add(new CubicCurveTo(211, 385, 326, 510, 460, 510));
		path.getElements().add(new CubicCurveTo(600, 510, 660, 402, 750, 385));
		path.getElements().add(new CubicCurveTo(842, 367, 933, 398, 950, 500));
		path.getElements().add(new CubicCurveTo(967, 602, 750, 674, 620, 675));
		path.getElements().add(new CubicCurveTo(487, 674, 336, 614, 336, 547));
		path.getElements().add(new CubicCurveTo(336, 480, 256, 360, 180, 360));

		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(10000));
		pt.setPath(path);
		pt.setNode(numen);
		pt.play();

		// overlay fade
		FadeTransition ft = new FadeTransition(Duration.millis(6000), overlay);
		ft.setFromValue(1);
		ft.setToValue(0.5);
		ft.setDelay(Duration.millis(4000));
		ft.play();

		tt1 = new TranslateTransition(Duration.millis(3000), numen);
		tt1.setToX(80);
		tt1.setInterpolator(Interpolator.EASE_BOTH);
		tt1.setCycleCount(Timeline.INDEFINITE);
		tt1.setAutoReverse(true);

		tt2 = new TranslateTransition(Duration.millis(1200), numen);
		tt2.setToX(-100);
		tt2.setInterpolator(Interpolator.EASE_BOTH);

		tt3 = new TranslateTransition(Duration.millis(1200), samuraiGroup);
		tt3.setToX(-300);
		tt3.setInterpolator(Interpolator.EASE_BOTH);

		pt.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tt1.play();
				setDialog();
			}
		});
	}

	public void setDialog() {
		switch (storyNum) {
		case 0:
			numen.setDialog(2, "且听风吟，但闻鸟鸣，光与影汇聚于此。");
			samurai1.setDirection(3);
			break;
		case 1:
			numen.removeDialog();
			dialog = new DialogView(2, "喂，你是谁？\n哦不，你是什么……");
			dialog.setLayoutX(650);
			dialog.setLayoutY(350);
			this.getChildren().add(dialog);
			break;
		case 2:
			this.getChildren().remove(dialog);
			numen.setDialog(2, "与其在虚幻的梦境中消磨灵魂，不如将爱与希望装进行囊。");
			samurai2.setDirection(3);
			samurai3.setDirection(3);
			break;
		case 3:
			numen.setDialog(2, "小小的朝圣者啊，让我赐予你远行的力量。");
			break;
		case 4:
			numen.removeDialog();
			dialog = new DialogView(2, "我们为什么会在这里？");
			dialog.setLayoutX(350);
			dialog.setLayoutY(350);
			this.getChildren().add(dialog);
			break;
		case 5:
			this.getChildren().remove(dialog);
			numen.setDialog(2, "出发吧，不要问那路在哪……");
			break;
		case 6:
			tt1.stop();
			tt2.play();
			tt3.play();
			samurai1.move(3);
			samurai2.move(3);
			samurai3.move(3);
			FadeTransition ft = new FadeTransition(Duration.millis(1200), this);
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					StoryPanel storyPanel = (StoryPanel) getParent();
					storyPanel.getChildren().remove(storyPanel.startPanel);
					storyPanel.startPanel = null;
					storyPanel.startGame();
				}
			});
			ft.play();
			break;
		}

		storyNum++;
	}

}
