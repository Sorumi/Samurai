package view.background;

import javafx.animation.FillTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import view.Images;

public class TerritoryBackground extends Pane{

	private static int WIDTH = 1200;
	private static int HEIGHT = 800;
	
	private Rectangle skyDay;
	private Rectangle skyNight;
	
	public TerritoryBackground(){
		Stop[] stops;
		LinearGradient lg;
		
		//skyday
		skyDay = new Rectangle();
		skyDay.setWidth(WIDTH);
		skyDay.setHeight(HEIGHT);
		stops = new Stop[]{new Stop(0, Color.web("#D3F4F9")), new Stop(0.55, Color.web("#F7F6F0")), new Stop(1, Color.web("#F7F6F0"))};
		lg = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);
		skyDay.setFill(lg);	
		
		//night
		skyNight = new Rectangle();
		skyNight.setWidth(WIDTH);
		skyNight.setHeight(HEIGHT);
		stops = new Stop[]{new Stop(0, Color.web("#3B5D88")), new Stop(1, Color.web("#31C8C0"))};
		lg = new LinearGradient(0.5, 0, 0.5, 1, true, CycleMethod.NO_CYCLE, stops);	
		skyNight.setFill(lg);	
		
		//mountains
		ImageView mountains = new ImageView(Images.TERRITORY_MOUNTAIN);
		mountains.setFitWidth(WIDTH);
		mountains.setPreserveRatio(true);
		mountains.setSmooth(true);
		
		ImageView land_0 = new ImageView(Images.TERRITORY_LAND_0);
		land_0.setFitWidth(1148);
		land_0.setPreserveRatio(true);
		land_0.setSmooth(true);
		land_0.setLayoutX(39);
		land_0.setLayoutY(108);
		
		ImageView land_1 = new ImageView(Images.TERRITORY_LAND_1);
		land_1.setFitWidth(1148);
		land_1.setPreserveRatio(true);
		land_1.setSmooth(true);
		land_1.setLayoutX(39);
		land_1.setLayoutY(108);
		land_1.setOpacity(0);
		
		this.getChildren().addAll(skyDay, skyNight, mountains, land_0, land_1);
	}
	
	public void setNight(){

	}
}
