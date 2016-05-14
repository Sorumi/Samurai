package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.TerritoryPanel;

public class WeatherHandler {

	private TerritoryPanel territoryPanel;

	public WeatherHandler(TerritoryPanel territoryPanel) {
		this.territoryPanel = territoryPanel;
	}

	public EventHandler<MouseEvent> sunEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(1);
		}
	};

	public EventHandler<MouseEvent> moonEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(2);
		}
	};

	public EventHandler<MouseEvent> starsEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(3);
		}
	};

	public EventHandler<MouseEvent> rainEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(4);
		}
	};

	public EventHandler<MouseEvent> snowEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			territoryPanel.setWeather(5);
		}
	};

}
