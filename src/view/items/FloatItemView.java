package view.items;

import java.util.Random;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.Images;

public class FloatItemView extends ImageView{
	
	private int num;
	
	public FloatItemView(int num){
		super(Images.FLOAT[num]);
		
		this.num = num;
		this.setPreserveRatio(true);
		init();
	}
	
	public void init(){
		switch(num){
		case 0:
			this.setFitWidth(54);
			break;
		case 1:
			this.setFitWidth(44);
			break;
		case 2:
			this.setFitWidth(44);
			break;
		case 3:
			this.setFitWidth(44);
			break;
		case 4:
			this.setFitWidth(29);
			break;
		case 5:
			this.setFitWidth(29);
			break;
		case 6:
			this.setFitWidth(46);
			break;
		case 7:
			this.setFitWidth(46);
			break;
		}
	}
	
	public RotateTransition getRotateAnimation(){
		Random random = new Random();
		int time = random.nextInt(1000)+2000;
		RotateTransition rt = new RotateTransition(Duration.millis(time), this);
		rt.setByAngle(360);
		rt.setCycleCount(Timeline.INDEFINITE);
		return rt;
	}
	
	public TranslateTransition getTranslateAnimation(){
		Random random = new Random();
		TranslateTransition tt = new TranslateTransition(Duration.millis(30000), this);
		int fromX = (random.nextInt(60)-60)*20;
		int toX = fromX + (random.nextInt(60)+60)*20;
		int fromY = (random.nextInt(25)-20)*20;
		int toY = random.nextInt(600)+200;
		tt.setFromX(fromX);
		tt.setFromY(fromY);
		tt.setToX(toX);
		tt.setToY(toY);
		tt.setCycleCount(Timeline.INDEFINITE);
		return tt;
	}
	
}
