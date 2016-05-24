package view;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import view.items.DialogView;
import view.items.NumenView;

public class StartStoryPanel extends Pane{

	private NumenView numen;
	private Rectangle overlay;
	
	private SamuraiView samurai1;
	private SamuraiView samurai2;
	private SamuraiView samurai3;
	private Group samuraiGroup;
	
	public StartStoryPanel(){
		this.setPrefSize(1200, 800);
		this.setStyle("-fx-background-color: #000");
		
		//samurai
		samurai1 = new SamuraiView(1, 2);
		samurai1.setLayoutX(300);
		samurai2 = new SamuraiView(2, 2);
		samurai2.setLayoutX(150);
		samurai3 = new SamuraiView(3, 2);
		samurai3.setLayoutX(0);
		
		samuraiGroup = new Group();
		samuraiGroup.setLayoutX(400);
		samuraiGroup.setLayoutY(400);
		samuraiGroup.getChildren().addAll(samurai1, samurai2, samurai3);
		
		overlay = new Rectangle(1200, 800);
		overlay.setFill(Color.BLACK);
		
		numen = new NumenView();
		
		DialogView dialog = new DialogView(2, "这是一段对话");
		dialog.setLayoutX(100);
		dialog.setLayoutY(100);
		
		this.getChildren().addAll(samuraiGroup, overlay, numen, dialog);

		setPathAnimation();
	}
	
	public void setPathAnimation(){
		//numen path
		Path path = new Path();
		path.getElements().add(new MoveTo(211,285));
		path.getElements().add(new CubicCurveTo(211, 285, 326, 410, 460, 410));
		path.getElements().add(new CubicCurveTo(600, 410, 660, 302, 750, 285));
		path.getElements().add(new CubicCurveTo(842, 267, 933, 298, 950, 400));
		path.getElements().add(new CubicCurveTo(967, 502, 750, 574, 620, 575));
		path.getElements().add(new CubicCurveTo(487, 574, 298, 518, 336, 447));
		path.getElements().add(new CubicCurveTo(374, 376, 482, 298, 580, 313));
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(10000));
		pt.setPath(path);
		pt.setNode(numen);
		pt.play();
		
		//overlay fade
		FadeTransition ft = new FadeTransition(Duration.millis(7000), overlay);
		ft.setFromValue(1);
		ft.setToValue(0.5);
		ft.setDelay(Duration.millis(3000));
		ft.play();
	}
}
