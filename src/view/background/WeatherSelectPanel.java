package view.background;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import images.Images;
import view.eventhandler.WeatherHandler;

public class WeatherSelectPanel extends Pane {
	
	private WeatherHandler weatherHandler;
	
	public WeatherSelectPanel(WeatherHandler weatherHandler){
		this.weatherHandler = weatherHandler;
		
		this.setPrefSize(50, 330);
		for (int i=1; i<=5; i++){
			WeatherButton btn = new WeatherButton(i);
			btn.setLayoutY(70*(i-1));
			this.getChildren().add(btn);
		}
	}

	public class WeatherButton extends Button{
		public int num;
		
		public WeatherButton(int num){
			this.setId("system-btn");
			ImageView img = new ImageView(Images.WEATHER[num]);

			switch(num){
			case 1:
			case 4:
			case 5:
				img.setFitWidth(38);
				break;
			case 2:
				img.setFitWidth(34);
				break;
			case 3:
				img.setFitWidth(35);
				break;
			}
			img.setPreserveRatio(true);
			this.setGraphic(img);
			switch(num){
			case 1: this.setOnMouseClicked(weatherHandler.sunEvent);break;
			case 2: this.setOnMouseClicked(weatherHandler.moonEvent);break;
			case 3: this.setOnMouseClicked(weatherHandler.starsEvent);break;
			case 4: this.setOnMouseClicked(weatherHandler.rainEvent);break;
			case 5: this.setOnMouseClicked(weatherHandler.snowEvent);break;
			}
		}
	}

}
