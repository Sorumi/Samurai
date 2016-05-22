package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import musics.Musics;
import view.TerritoryPanel;

public class WeatherHandler {

	private TerritoryPanel territoryPanel;

	public WeatherHandler(TerritoryPanel territoryPanel) {
		this.territoryPanel = territoryPanel;
	}

	public EventHandler<MouseEvent> sunEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(1);
			Musics.effectMusic[0].stop();
		}
	};

	public EventHandler<MouseEvent> moonEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(2);
			Musics.effectMusic[0].stop();
		}
	};

	public EventHandler<MouseEvent> starsEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(3);
			Musics.effectMusic[0].stop();
		}
	};

	public EventHandler<MouseEvent> rainEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(4);
			Musics.playEffectMusic(0);
		}
	};

	public EventHandler<MouseEvent> snowEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(5);
			Musics.effectMusic[0].stop();
		}
	};

}
