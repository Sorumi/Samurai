package view;

import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class WeaponView extends OrderImageView {
	
	private final int WIDTH = 60;
	private final int BODY_X = WIDTH/2-10;
	private final int BODY_Y = 60;
	
	//zOrder
	public int number;
	public int frontZOrder;
	public int backZOrder;
	public int[] frontRotatePivot;
	public int[] backRotatePivot;
	public int[] frontLayout;
	public int[] backLayout;
	public int[] frontAngle;
	public int[] backAngle;
	public int[] armAngle;//move时拿武器的arm 0: front right 1: back left

	/*
	 * frontAngle[] / backAngel[]:
	 * weapon: move1 occupy2
	 * leftArm: move2 occupy2
	 * rightArm: move2 occupy2
	 * 
	*/
	public WeaponView(int number) {
		super(Images.WEAPON[number/100][number%100]);

		this.setSmooth(true);
		this.setPreserveRatio(true);	
		this.number = number;
		this.setInit();		
	}

	private void setInit(){
		
		switch(number){
		case 000:
			this.setFitWidth(6);
			frontZOrder = 6;
			backZOrder = 15;
			frontRotatePivot = new int[]{-10, 52};
			backRotatePivot = new int[]{-9, 52};
			frontLayout = new int[]{BODY_X+30, BODY_Y-45};
			backLayout = new int[]{BODY_X-10, BODY_Y-45};
			//
			//front left: -20 # 50      right: -15 # 50
			//back  left: -85 # 50     right: 30 # 50
			armAngle = new int[]{-20, -60};
			frontAngle = new int[]{0, 90, 50,
					-40, 25, 20, -20,
					-25, -25, 15, -15};
			backAngle = new int[]{0, 90, 50,
					-75, -75, -35, -85,
					-25, 35, -10, 30};
			break;
		case 100:
			this.setFitWidth(14);
			frontZOrder = 17;
			backZOrder = 21;
			frontRotatePivot = new int[]{-10, 57};
			backRotatePivot = new int[]{-11, 59};
			frontLayout = new int[]{BODY_X+30, BODY_Y-53};
			backLayout = new int[]{BODY_X-22, BODY_Y-52};
			//
			//front right: -15 # 40
			//back left: -65 # 40
			armAngle = new int[]{-25, -75};
			frontAngle = new int[]{30, 95, 50,
					-40, 25, 0, 25,
					-25, -25, 35, -5};
			backAngle = new int[]{30, 95, 50,
					-75, -75, -10, -75,
					-25, 35, 0, -25};
			break;
		case 200:
			this.setFitWidth(18);
			frontZOrder = 17;
			backZOrder = 21;
			frontRotatePivot = new int[]{-8, 54};
			backRotatePivot = new int[]{-9, 42};
			frontLayout = new int[]{BODY_X+28, BODY_Y-48};
			backLayout = new int[]{BODY_X-25, BODY_Y-35};
			//
			//front right: -50 # 30
			//back left: -60 # 30
			armAngle = new int[]{-40, -50};
			frontAngle = new int[]{40, 10, 80,
					-40, 25, 0, 25,
					-40, -40, -70, 0};
			backAngle = new int[]{40, 10, 80,
					-50, -50, -80, -10,
					-25, 35, 0, -25};
			break;
		}
		
		/*
		 * frontAngle[] / backAngel[]:
		 * weapon: move1 occupy2
		 * leftArm: move2 occupy2
		 * rightArm: move2 occupy2
		 * 
		*/

	}

}
