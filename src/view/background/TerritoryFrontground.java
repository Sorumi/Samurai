package view.background;

import javafx.scene.Group;
import view.items.Rain;
import view.items.Snow;

public class TerritoryFrontground extends Group{

	private Rain rain;
	private Snow snow;
	private boolean isRain;
	private boolean isSnow;
	
	public TerritoryFrontground(){
		rain = new Rain();
		snow = new Snow();
		
		this.getChildren().addAll(rain, snow);
	}
	
	public void setRain(int count){
		isRain = true;
		rain.startRain(count);
	}
	public void setSnow(int count){
		isSnow = true;
		snow.startSnow(count);
	}
	
	
	public void removeAll(){
		isRain = false;
		isSnow = false;
		
		rain.removeRain();
		snow.removeSnow();
	}
	public void stopAll(){
		rain.stopRain();
		snow.stopSnow();
	}
	public void restartAll(){
		if (isRain){
			rain.restartRain();
		}else if (isSnow){
			snow.restartSnow();
		}

	}
}
