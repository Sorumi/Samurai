package view.background;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import view.Images;
import view.items.*;

public class TerritoryBackground extends Pane{

	private static int WIDTH = 1200;
	private static int HEIGHT = 800;
	
	private boolean isDay;
	private boolean isSun;
	private boolean isMoon;
	private boolean isStars;
	
	private Rectangle skyDay;
	private Rectangle skyNight;
	
	private Sun sun;
	private Moon moon;
	private Group stars;
	private Group starCircles;
	
	private ImageView landDay;
	private ImageView landNight;
	
	private Timeline timeline;
	
	public TerritoryBackground(){
		Stop[] stops;
		LinearGradient lg;
		
		isDay = true;
		isSun = false;
		isMoon = false;
		isStars = false;
		
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
	
		//mountains
		ImageView mountains = new ImageView(Images.TERRITORY_MOUNTAIN);
		mountains.setFitWidth(WIDTH);
		mountains.setPreserveRatio(true);
		mountains.setSmooth(true);
		
		//items
		sun = new Sun();
		sun.setLayoutX(46);
		sun.setLayoutY(21);
		sun.setVisible(false);
		
		moon = new Moon();
		moon.setLayoutX(50);
		moon.setLayoutY(11);
		moon.setVisible(false);
		
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
		stars.setVisible(false);

		
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
		starCircles.setVisible(false);
		
		//land
		landDay = new ImageView(Images.TERRITORY_LAND_0);
		landDay.setFitWidth(1148);
		landDay.setPreserveRatio(true);
		landDay.setSmooth(true);
		landDay.setLayoutX(39);
		landDay.setLayoutY(108);
		
		landNight = new ImageView(Images.TERRITORY_LAND_1);
		landNight.setFitWidth(1148);
		landNight.setPreserveRatio(true);
		landNight.setSmooth(true);
		landNight.setLayoutX(39);
		landNight.setLayoutY(108);
		landNight.setOpacity(0);
		
		ImageView items = new ImageView(Images.TERRITORY_ITEMS);
		items.setFitWidth(981);
		items.setPreserveRatio(true);
		items.setSmooth(true);
		items.setLayoutX(74);
		items.setLayoutY(102);
		
		this.getChildren().addAll(skyDay, skyNight, mountains, sun, moon, stars, starCircles, landDay, landNight, items);
		
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		//TODO
		
		this.setMoon(true);
		this.setStars(true);
		
		timeline.play();
	}
	
	public void setDay(){
		if (!isDay){
			 Timeline dayTL= new Timeline(
						new KeyFrame(Duration.millis(1000), new KeyValue(skyNight.opacityProperty(), 0)),
						new KeyFrame(Duration.millis(1000), new KeyValue(landNight.opacityProperty(), 0))
						);
			 dayTL.play();
		}
	}
	public void setNight(){
		if(isDay){
			 Timeline nightTL= new Timeline(
						new KeyFrame(Duration.millis(1000), new KeyValue(skyNight.opacityProperty(), 1)),
						new KeyFrame(Duration.millis(1000), new KeyValue(landNight.opacityProperty(), 1))
						);
			 nightTL.play();
		}
	}
	
	public void setSun(boolean isSun){
		this.isSun = isSun;
		moon.setVisible(isSun);
		if (isSun) {
			timeline.getKeyFrames().addAll(sun.lightAnimation());
		}
	}
	
	public void setMoon(boolean isMoon){
		this.isMoon = isMoon;
		moon.setVisible(isMoon);
		if (isMoon) {
			timeline.getKeyFrames().addAll(moon.lightAnimation());
		}
	}
	
	public void setStars(boolean isStars){
		this.isStars = isStars;
		stars.setVisible(isStars);
		starCircles.setVisible(isStars);
		if (isStars){
			for(int i=0; i<stars.getChildren().size(); i++){
				Star star = (Star) stars.getChildren().get(i);
				timeline.getKeyFrames().addAll(star.lightAnimation());
			}
		}
	}
	
	public void stopAll() {
		timeline.stop();
	}
	
	public void restartAll(){
		timeline.play();
	}
}
