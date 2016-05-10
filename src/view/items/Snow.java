package view.items;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Snow extends Group {

	private static int COUNT = 700;
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 800;

	private Circle[] circles;
	private long[] startX;
	private long[] startY;
	private int[] v;
	
	private AnimationTimer timer;
	    
	private final Random random = new Random();
	
	private void snow(int count){
		
		circles = new Circle[COUNT];
		startX = new long[COUNT];
		startY = new long[COUNT];
		v = new int[COUNT];
		
		for (int i=0; i<COUNT; i++) {
			circles[i] = new Circle(3, 3, 3, Color.rgb(255, 255, 255, 0.5));
			startX[i] = random.nextInt(WIDTH * 100);
            startY[i] = random.nextInt(HEIGHT * 100);
			v[i] = random.nextInt(5)+5;
		}
		
		this.getChildren().addAll(circles);
		
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i=0; i<COUNT; i++) {
                    final Node node = circles[i];
                    final double d = now / (v[i]*500000);
                    node.setTranslateX( startX[i]/100%800 );
                    node.setTranslateY( (d + startY[i]/100) %600 );
                }
            }
        };
        
        timer.start();
	}
	//新的下雪
	public void startSnow(int count){
		if(timer == null){
			this.snow(count);
		}
	}
	//移除下雪效果
	public void removeSnow(){
		if(timer != null){
			timer.stop();
			timer = null;
			this.getChildren().removeAll(circles);
		}
	}
	//暂停下雪 保留了下雪效果
	public void stopSnow(){
		if(timer != null){
			timer.stop();
		}
	}
	//继续下雪
	public void restartSnow(){
		if(timer != null){
			timer.start();
		}
	}

}
