package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import musics.Musics;
import view.story.TerritoryPanel;

public class WeatherHandler {

	private TerritoryPanel territoryPanel;

	public WeatherHandler(TerritoryPanel territoryPanel) {
		this.territoryPanel = territoryPanel;
	}
	
	public EventHandler<MouseEvent> enterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.weatherPanel.show();
		}
	};
	
	public EventHandler<MouseEvent> exitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.weatherPanel.hide();
		}
	};

	public EventHandler<MouseEvent> sunEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(1);
			Musics.stopEffectMusic();
		}
	};

	public EventHandler<MouseEvent> moonEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(2);
			Musics.stopEffectMusic();
		}
	};

	public EventHandler<MouseEvent> starsEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(3);
			Musics.stopEffectMusic();
		}
	};

	public EventHandler<MouseEvent> rainEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(4);
			Musics.stopEffectMusic();
			Musics.playEffectMusic(0);
		}
	};

	public EventHandler<MouseEvent> snowEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(5);
			Musics.stopEffectMusic();
		}
	};

}
