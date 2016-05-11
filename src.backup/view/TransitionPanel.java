package view;

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class TransitionPanel extends Pane {

	public TransitionPanel(){
		this.setOpacity(0);
	}
	
	public void transitionAnimation(boolean isAppear){
		
		FadeTransition ft = new FadeTransition(Duration.millis(200), this);
		if (isAppear){
			ft.setFromValue(0);
			ft.setToValue(1);
		}else{
			ft.setFromValue(1);
			ft.setToValue(0);
		}
		ft.play();
	}
}
