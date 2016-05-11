package view.items;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Rain extends Group {

	private static int COUNT = 500;
	private static final int ANGLE = 30;
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;

	private Line[] lines;
	private int[] length;
	private long[] startX;
	private long[] startY;
	private int[] v;
	
	private AnimationTimer timer;
	    
	private final Random random = new Random();
	
	private void rain(int count){
		
		lines = new Line[COUNT];
		length = new int[COUNT];
		startX = new long[COUNT];
		startY = new long[COUNT];
		v = new int[COUNT];
		
		for (int i=0; i<COUNT; i++) {
			length[i] = random.nextInt(30)+15;
			lines[i] = new Line(0, 0, length[i]*Math.cos(ANGLE), length[i]*Math.sin(ANGLE));
			lines[i].setStroke(Color.rgb(255, 255, 255, 0.5));
			startX[i] = random.nextInt(WIDTH * 100);
            startY[i] = random.nextInt(HEIGHT * 100);
			v[i] = random.nextInt(3)+2;
		}
		
		this.getChildren().addAll(lines);
		
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i=0; i<COUNT; i++) {
                    final Node node = lines[i];
                    final double d = now / (v[i]*1000000);
                    node.setTranslateX((-Math.cos(ANGLE) * d + startX[i]/100)%WIDTH > 0 ? (-Math.cos(ANGLE) * d + startX[i]/100)%WIDTH : (-Math.cos(ANGLE) * d + startX[i]/100)%WIDTH+WIDTH);
                    node.setTranslateY((-Math.sin(ANGLE) * d + startY[i]/100)%HEIGHT);
                }
            }
        };
        
        timer.start();
	}
	//新的下雨
	public void startRain(int count){
		if(timer == null){
			this.rain(count);
		}
	}
	//移除下雨效果
	public void removeRain(){
		if(timer != null){
			timer.stop();
			timer = null;
			this.getChildren().removeAll(lines);
		}
	}
	//暂停下雨 保留了下雨效果
	public void stopRain(){
		if(timer != null){
			timer.stop();
		}
	}
	//继续下雨
	public void restartRain(){
		if(timer != null){
			timer.start();
		}
	}
	//切换下雨
//	public void toggleRain(int count){
//		if(timer != null){
//			timer.stop();
//			timer = null;
//			this.getChildren().removeAll(lines);
//		}else{
//			this.rain(count);
//		}
//	}
}
