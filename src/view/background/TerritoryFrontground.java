package view.background;

import javafx.scene.layout.Pane;
import view.items.Rain;

public class TerritoryFrontground extends Pane{

	private Rain rain;
	private boolean isRain;
	
	public TerritoryFrontground(){
		rain = new Rain();
		
		this.getChildren().addAll(rain);
	}
	
	public void setRain(int count){
		isRain = true;
		rain.startRain(count);

	}
	public void removeAll(){
		rain.removeRain();
	}
	public void stopAll(){
		rain.stopRain();
	}
	public void restartAll(){
		if (isRain){
			rain.restartRain();
		}

	}
}
