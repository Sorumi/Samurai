package view.background;

import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import view.items.FloatItemView;

public class FloatItemBackgrond extends Pane {

	private final int size = 10;
	private FloatItemView[] items;
	private ParallelTransition pt;
	
	public FloatItemBackgrond(){
		this.setPrefSize(1200, 800);
		
		pt = new ParallelTransition();
	}
	
	public void setNum(int num){
		this.getChildren().clear();
		pt.getChildren().clear();
		
		items = new FloatItemView[size];
		
		for(int i=0; i<size; i++){
			items[i] = new FloatItemView(num);
			this.getChildren().add(items[i]);
			pt.getChildren().addAll(items[i].getRotateAnimation(), items[i].getTranslateAnimation());
		}
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
	}
	
	
}
