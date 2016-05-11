package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.background.TerritoryBackground;
import view.background.TerritoryFrontground;

public class WeatherHandler {
	
	private TerritoryBackground bg;
	private TerritoryFrontground fg;
	
	public WeatherHandler(TerritoryBackground bg, TerritoryFrontground fg){
		this.bg = bg;
		this.fg = fg;
	}
	
	public EventHandler<MouseEvent> sunEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  bg.removeAll();
	    	  fg.removeAll();
	    	  bg.setDay();
	    	  bg.setSun(true);
	      }
	};
	
	public EventHandler<MouseEvent> moonEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  bg.removeAll();
	    	  fg.removeAll();
	    	  bg.setNight();
	    	  bg.setMoon(true);
	    	  bg.setStars(true);
	      }
	};
	
	public EventHandler<MouseEvent> starsEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  bg.removeAll();
	    	  fg.removeAll();
	    	  bg.setNight();
	    	  bg.setStars(true);
	      }
	};
	
	public EventHandler<MouseEvent> rainEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  fg.removeAll();
	    	  fg.setRain(700);
	      }
	};
	
	public EventHandler<MouseEvent> snowEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  fg.removeAll();
	    	  fg.setSnow(500);
	      }
	};
	

}
