package view.background;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import view.Images;
import view.items.Moon;
import view.items.Star;
import view.items.StarCircle;
import view.items.Sun;

public class MenuBackground extends Pane{
	private static int WIDTH = 1200;
	private static int HEIGHT = 800;
	
	private int currentSky;
	
	private Rectangle skyDay;
	private Rectangle skyNight;
	private Rectangle skyRain;
	private Rectangle skyDusk;
	private Group skyGroup;
	private Rectangle[] sky;
	
	private Sun sun;
	private Moon moon;
	private Group stars;
	private Group starCircles;
	
	private boolean isSun;
	private boolean isMoon;
	
	private Rotate sunRo;
	private Rotate moonRo;
	private Rotate starRo;
	
	private Circle land;
	private Color[] landColor;
	
	public FloatItemBackgrond floatBg;
	
	public MenuBackground(){
		Stop[] stops;
		LinearGradient lg;
		
		currentSky = 0;
		
		//sky day
		skyDay = new Rectangle();
		skyDay.setWidth(WIDTH);
		skyDay.setHeight(HEIGHT);
		stops = new Stop[]{new Stop(0, Color.web("#D3F4F9")), new Stop(0.55, Color.web("#F7F6F0")), new Stop(1, Color.web("#F7F6F0"))};
		lg = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);
		skyDay.setFill(lg);	
		
		//sky night
		skyNight = new Rectangle();
		skyNight.setWidth(WIDTH);
		skyNight.setHeight(HEIGHT);
		stops = new Stop[]{new Stop(0, Color.web("#3B5D88")), new Stop(1, Color.web("#31C8C0"))};
		lg = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);	
		skyNight.setFill(lg);
		skyNight.setOpacity(0);
		
		//sky rain
		skyRain = new Rectangle();
		skyRain.setWidth(WIDTH);
		skyRain.setHeight(HEIGHT);
		stops = new Stop[]{new Stop(0, Color.web("#E3E3E3")), new Stop(1, Color.web("#93AAA4"))};
		lg = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);	
		skyRain.setFill(lg);
		skyRain.setOpacity(0);
		
		//sky dust
		skyDusk = new Rectangle();
		skyDusk.setWidth(WIDTH);
		skyDusk.setHeight(HEIGHT);
		stops = new Stop[]{new Stop(0, Color.web("#FDEFDC")), new Stop(0.23, Color.web("#FDECE4")), new Stop(0.58, Color.web("#F9D8DE")), new Stop(0.77, Color.web("#EDD6EC")), new Stop(1, Color.web("#E0C5EF"))};
		lg = new LinearGradient(0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE, stops);	
		skyDusk.setFill(lg);
		skyDusk.setOpacity(0);
		
		sky = new Rectangle[]{skyDay, skyNight, skyRain, skyDusk};
		skyGroup = new Group();
		skyGroup.getChildren().addAll(skyNight, skyRain, skyDusk, skyDay);
	
		//mountains
		ImageView mountains = new ImageView(Images.TERRITORY_MOUNTAIN);
		mountains.setFitWidth(WIDTH);
		mountains.setPreserveRatio(true);
		mountains.setSmooth(true);
		
		//items
		sun = new Sun();
		sun.setLayoutX(WIDTH/2 - 60);
		sun.setLayoutY(50);
		
		moon = new Moon();
		moon.setLayoutX(WIDTH/2 - 85);
		moon.setLayoutY(50);
		
		stars = new Group();
		Star star1 = new Star(10);
		star1.setLayoutX(323);
		star1.setLayoutY(49);
		Star star2 = new Star(7);
		star2.setLayoutX(1159);
		star2.setLayoutY(151);
		Star star3 = new Star(7);
		star3.setLayoutX(40);
		star3.setLayoutY(173);
		Star star4 = new Star(10);
		star4.setLayoutX(7);
		star4.setLayoutY(400);
		Star star5 = new Star(13);
		star5.setLayoutX(1020);
		star5.setLayoutY(38);
		
		stars.getChildren().addAll(star1, star2, star3, star4, star5);
//		stars.setVisible(false);

		starCircles = new Group();
		StarCircle starC1 = new StarCircle(9);
		starC1.setLayoutX(65);
		starC1.setLayoutY(695);
		StarCircle starC2 = new StarCircle(4);
		starC2.setLayoutX(34);
		starC2.setLayoutY(754);
		StarCircle starC3 = new StarCircle(2);
		starC3.setLayoutX(81);
		starC3.setLayoutY(218);
		StarCircle starC4 = new StarCircle(3);
		starC4.setLayoutX(18);
		starC4.setLayoutY(254);
		StarCircle starC5 = new StarCircle(4);
		starC5.setLayoutX(70);
		starC5.setLayoutY(285);
		StarCircle starC6 = new StarCircle(4);
		starC6.setLayoutX(278);
		starC6.setLayoutY(99);
		StarCircle starC7 = new StarCircle(3);
		starC7.setLayoutX(385);
		starC7.setLayoutY(63);
		StarCircle starC8 = new StarCircle(2);
		starC8.setLayoutX(739);
		starC8.setLayoutY(87);
		StarCircle starC9 = new StarCircle(4);
		starC9.setLayoutX(796);
		starC9.setLayoutY(45);
		StarCircle starC10 = new StarCircle(4);
		starC10.setLayoutX(1075);
		starC10.setLayoutY(112);
		StarCircle starC11 = new StarCircle(6);
		starC11.setLayoutX(1057);
		starC11.setLayoutY(195);
		StarCircle starC12 = new StarCircle(9);
		starC12.setLayoutX(1169);
		starC12.setLayoutY(329);
		StarCircle starC13 = new StarCircle(7);
		starC13.setLayoutX(1174);
		starC13.setLayoutY(695);
		starCircles.getChildren().addAll(starC1, starC2, starC3, starC4, starC5, starC6, starC7, starC8, starC9, starC10, starC11, starC12, starC13);
		
		//rotate
		sunRo = new Rotate();
		sunRo.pivotXProperty().bind(sun.centerXProperty());
		sunRo.pivotYProperty().bind(sun.centerYProperty().add(1290));
		sunRo.setAngle(-20);
		sun.getTransforms().add(sunRo);
		isSun = true;
		
		moonRo = new Rotate();
		moonRo.pivotXProperty().bind(sun.centerXProperty());
		moonRo.pivotYProperty().bind(sun.centerYProperty().add(1290));
		moonRo.setAngle(-200);
		moon.getTransforms().add(moonRo);
		isMoon = false;
		
		starRo = new Rotate();
		starRo.pivotXProperty().bind(stars.layoutXProperty().add(600));
		starRo.pivotYProperty().bind(stars.layoutYProperty().add(1400));
		starRo.setAngle(-180);
		stars.getTransforms().add(starRo);
		starCircles.getTransforms().add(starRo);
		
		//float
		floatBg = new FloatItemBackgrond();
		
		//land
		land = new Circle();
		land.setRadius(900);
		land.setCenterX(600);
		land.setCenterY(1400);
		land.setFill(Color.web("#DEE6D6"));//TODO
		
		landColor = new Color[]{Color.web("#DEE6D6"), Color.web("#AFCBC8"), Color.web("#D2D6CD"), Color.web("#D5CED8")};
		
		this.getChildren().addAll(skyGroup, mountains, sun, moon, stars, starCircles, floatBg, land);
		
	}
	
	public void setSky(int num){
		if (currentSky != num){
			sky[num].setOpacity(0);
			sky[num].toFront();
			Timeline skyTL= new Timeline(
					new KeyFrame(Duration.millis(2000), new KeyValue(sky[num].opacityProperty(), 1)),
					new KeyFrame(Duration.millis(2000), new KeyValue(land.fillProperty(), landColor[num]))
						);
			skyTL.play();
		}
		currentSky = num;
	}
	
	public void setSun(boolean isSun){
		if(this.isSun != isSun){
			Timeline sunTL= new Timeline(
					new KeyFrame(Duration.millis(2000), new KeyValue(sunRo.angleProperty(), sunRo.angleProperty().intValue()+180, Interpolator.EASE_IN))
					);
			if (!isSun) {
				sunTL.setOnFinished(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						sunRo.setAngle(-200);
					}
				});
			}
			sunTL.play();
			this.isSun = isSun;
		}
	}
	
	public void setMoon(boolean isMoon){
		if(this.isMoon != isMoon){
			Timeline moonTL= new Timeline(
					new KeyFrame(Duration.millis(2000), new KeyValue(moonRo.angleProperty(), moonRo.angleProperty().intValue()+180, Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(2000), new KeyValue(starRo.angleProperty(), starRo.angleProperty().intValue()+180, Interpolator.EASE_IN))
					);
			if (!isMoon) {
				moonTL.setOnFinished(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						moonRo.setAngle(-200);
						starRo.setAngle(-180);
					}
				});
			}
			moonTL.play();
			this.isMoon = isMoon;
		}
		
	}
	
	//TODO
	public void setDay(int num){
		setSky(num);
		
		switch(num){
		case 0:
			setSun(true);
			setMoon(false);
			break;
		case 1:
			setSun(false);
			setMoon(true);
			break;
		case 2:
		case 3:
			setSun(false);
			setMoon(false);
			break;
		}


	}

}
