package view.items;

import java.util.Random;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import view.Images;

public class FloatItemView extends ImageView{
	
	private int type;
	private int num;
	
	public FloatItemView(int type, int num){
		super(Images.FLOAT[type]);
		
		this.type = type;
		this.num = num;
		this.setPreserveRatio(true);
		init();
	}
	
	public void init(){
		switch(type){
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
		int time = random.nextInt(1000)+4000;
		RotateTransition rt = new RotateTransition(Duration.millis(time), this);
		rt.setByAngle(360);
		rt.setCycleCount(Timeline.INDEFINITE);
		return rt;
	}
	
	public TranslateTransition getTranslateAnimation(){
		Random random = new Random();
		TranslateTransition tt = new TranslateTransition(Duration.millis(20000), this);
		int fromX = -100;
		int toX = random.nextInt(600) + 1200;
		int fromY = (random.nextInt(25)-5)*20;
		int toY = random.nextInt(600)+200;
		tt.setFromX(fromX);
		tt.setFromY(fromY);
		tt.setToX(toX);
		tt.setToY(toY);
		tt.setCycleCount(Timeline.INDEFINITE);
		if(num < 3){
			tt.setDelay(Duration.millis(random.nextInt(num*2+4)*2000));
		}else if(num < 6){
			tt.setDelay(Duration.millis(random.nextInt(num*2+1)*6000+3000));
		}else{
			tt.setDelay(Duration.millis(random.nextInt(200)*50+10000));
		}

		return tt;
	}
	
}
