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
import view.items.Moon;
import view.items.Star;

public class TerritoryBackground extends Pane{

	private static int WIDTH = 1200;
	private static int HEIGHT = 800;
	
	private boolean isDay;
	
	private Rectangle skyDay;
	private Rectangle skyNight;
	
	private Moon moon;
	private Group stars;
	
	private ImageView landDay;
	private ImageView landNight;
	
	public TerritoryBackground(){
		Stop[] stops;
		LinearGradient lg;
		
		isDay = true;
		
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
		
		stars.getChildren().addAll(star1, star2);
		stars.setVisible(false);
		
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
		
		this.getChildren().addAll(skyDay, skyNight, mountains, moon, stars, landDay, landNight, items);
		
	}
	
	public void setDay(){
		if (!isDay){
			 Timeline nightTL= new Timeline(
						new KeyFrame(Duration.millis(1000), new KeyValue(skyNight.opacityProperty(), 0)),
						new KeyFrame(Duration.millis(1000), new KeyValue(landNight.opacityProperty(), 0))
						);
			 nightTL.play();
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
	public void setMoon(){
		moon.setVisible(true);
		moon.lightAnimation();
	}
	
	public void setStars(){
		stars.setVisible(true);
		for(int i=0; i<stars.getChildren().size(); i++){
			Star star = (Star) stars.getChildren().get(i);
			star.lightAnimation();
		}
	}
}
