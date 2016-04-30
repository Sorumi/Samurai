package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class SamuraiWeaponView extends OrderImageView {
	
	private int SCALE;
	private int WIDTH = 60*SCALE;
	private int BODY_X = WIDTH/2-10*SCALE;
	private int BODY_Y = 60*SCALE;
	
	private int height_fix = 0;
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
	
	private boolean extraAnimation;
	private ImageView extraImg;

	/*
	 * frontAngle[] / backAngel[]:
	 * weapon: move1 occupy2
	 * leftArm: move2 occupy2
	 * rightArm: move2 occupy2
	 * 
	*/
	public SamuraiWeaponView(int number, int scale) {
		super(Images.WEAPON[number/100][number%100/10][number%10]);
		
		this.SCALE = scale;
		this.WIDTH = 60*SCALE;
		this.BODY_X = WIDTH/2-10*SCALE;
		this.BODY_Y = 60*SCALE;
		
		this.setFitWidth(Images.WEAPON[number/100][number%100/10][number%10].getWidth()/6*SCALE);
		this.setSmooth(true);
		this.setPreserveRatio(true);	
		this.number = number;
		this.setInit();		
	}

	private void setInit(){
		switch(number){
		case 000:
			this.setFitWidth(6*SCALE);
			break;
		case 100:
		case 113:
			this.setFitWidth(14*SCALE);
			break;
		case 111:
			this.setFitWidth(12*SCALE);
			break;
		case 112:
			this.setFitWidth(8*SCALE);
			height_fix = -10*SCALE;
			break;
		case 114:
			this.setFitWidth(10*SCALE);
			height_fix = -3*SCALE;
			break;
		case 115:
			this.setFitWidth(18*SCALE);
			height_fix = -5*SCALE;
			break;
		case 116:
			this.setFitWidth(24*SCALE);
			height_fix = -5*SCALE;
			break;
		case 124:
			this.setFitWidth(14*SCALE);
			height_fix = -11*SCALE;
			break;
		case 125:
			this.setFitWidth(20*SCALE);
			height_fix = -9*SCALE;
			break;
		case 126:
			this.setFitWidth(16*SCALE);
			height_fix = -11*SCALE;
			break;
		case 132:
			this.setFitWidth(10*SCALE);
			height_fix = 26*SCALE;
			break;
		case 133:
			this.setFitWidth(7*SCALE);
			height_fix = 27*SCALE;
			break;
		case 134:
			this.setFitWidth(11*SCALE);
			height_fix = 27*SCALE;
			break;
		case 135:
			this.setFitWidth(12*SCALE);
			height_fix = 27*SCALE;
			break;
		case 136:
			this.setFitWidth(8*SCALE);
			height_fix = 29*SCALE;
			break;
			
		case 200:
			this.setFitWidth(18*SCALE);
			break;
		case 300:
			this.setFitWidth(16*SCALE);
			break;			
		case 400:
			this.setFitWidth(18*SCALE);
			break;
		case 500:
			this.setFitWidth(50*SCALE);
			break;
		}
		switch(number/100){
		case 0:
			frontZOrder = 6;
			backZOrder = 15;
			
			frontLayout = new int[]{BODY_X+30*SCALE, BODY_Y-45*SCALE};
			backLayout = new int[]{BODY_X-10*SCALE, BODY_Y-45*SCALE};
			frontRotatePivot = new int[]{-10*SCALE, 52*SCALE};
			backRotatePivot = new int[]{-9*SCALE, 52*SCALE};
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
		case 1:
			int centerX = 7*SCALE;
			int offsetX = centerX-this.fitWidthProperty().intValue()/2;
			frontZOrder = 17;
			backZOrder = 21;

			frontLayout = new int[]{BODY_X+30*SCALE+offsetX, BODY_Y-56*SCALE+height_fix};
			backLayout = new int[]{BODY_X-22*SCALE+offsetX, BODY_Y-52*SCALE+height_fix};
			frontRotatePivot = new int[]{-8*SCALE-offsetX, 61*SCALE-height_fix};
			backRotatePivot = new int[]{-11*SCALE-offsetX, 59*SCALE-height_fix};
			//
			//front right: -15 # 40
			//back left: -65 # 40
			armAngle = new int[]{-25, -75};
			frontAngle = new int[]{30, 95, 50,
					-40, 25, 0, 25,
					-25, -25, 35, -5};
			backAngle = new int[]{30, 95, 50,
					-75, -75, -10, -55,
					-25, 35, 0, -25};
			break;
		case 2:
			frontZOrder = 17;
			backZOrder = 21;
			
			frontLayout = new int[]{BODY_X+28*SCALE, BODY_Y-48*SCALE};
			backLayout = new int[]{BODY_X-25*SCALE, BODY_Y-35*SCALE};
			frontRotatePivot = new int[]{-8*SCALE, 54*SCALE};
			backRotatePivot = new int[]{-9*SCALE, 42*SCALE};
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
		case 3:
			frontZOrder = 17;
			backZOrder = 21;
			
			frontLayout = new int[]{BODY_X+26*SCALE, BODY_Y+9*SCALE};
			backLayout = new int[]{BODY_X-18*SCALE, BODY_Y+13*SCALE};//
			frontRotatePivot = new int[]{this.fitWidthProperty().intValue()/2, this.fitWidthProperty().intValue()/2};
			backRotatePivot = new int[]{this.fitWidthProperty().intValue()/2, this.fitWidthProperty().intValue()/2};//
			//
			//front right: -50 # 30
			//back left: -60 # 30
			armAngle = new int[]{-10, -50};
			frontAngle = new int[]{0, 10, 720,
					-40, 25, 0, 25,
					-10, -10, 10, -30};
			backAngle = new int[]{0, 10, 720,//
					-50, -50, -30, -70,//
					-25, 35, 0, -25};//
			break;
		case 4:
			frontZOrder = 6;
			backZOrder = 15;
			
			frontLayout = new int[]{BODY_X+15*SCALE, BODY_Y-19*SCALE};
			backLayout = new int[]{BODY_X-15*SCALE, BODY_Y-20*SCALE};
			frontRotatePivot = new int[]{-6*SCALE, 23*SCALE};
			backRotatePivot = new int[]{-1*SCALE, 27*SCALE};
			//front right: -10 # 0
			//back left: -75 # 0
			armAngle = new int[]{-10, -75};
			frontAngle = new int[]{0, -25, -25,
					0, 0, 0, -130,
					-10, -10, -35, -35};
			backAngle = new int[]{0, -25, -25,
					-75, -75, -100, -100,
					0, 0, 0, 60};
			break;
		case 5:
			frontZOrder = 6;
			backZOrder = 15;
			
			frontLayout = new int[]{BODY_X-28*SCALE, BODY_Y+24*SCALE};
			backLayout = new int[]{BODY_X-0*SCALE, BODY_Y+18*SCALE};
			frontRotatePivot = new int[]{-5*SCALE, -58*SCALE};
			backRotatePivot = new int[]{13*SCALE, -60*SCALE};

			frontAngle = new int[]{0, -25, -25};
			backAngle = new int[]{0, -25, -25};
			
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
