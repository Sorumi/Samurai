package view.samurai;

import view.Images;
import view.OrderImageView;

public class SamuraiArmorView extends OrderImageView {
	
	private int SCALE;
	private int WIDTH = 60*SCALE;
	private int BODY_X = WIDTH/2-10*SCALE;
	private int BODY_Y = 60*SCALE;
	
	private int number;//1X:布甲 2X:皮甲 3X:铁甲   0:left 1:body 2:back 3:right
	
	public SamuraiArmorView(int number, int scale){
		super(Images.ARMOR[number/100][number%100/10][number%10]);
		
		this.number = number;
		this.SCALE = scale;
		this.WIDTH = 60*SCALE;
		this.BODY_X = WIDTH/2-10*SCALE;
		this.BODY_Y = 60*SCALE;

		this.setSmooth(true);
		this.setPreserveRatio(true);	
		this.setInit();
		
	}
	
	private void setInit(){
		switch(number/100){
		//布甲
		case 1:
			switch(number%10){
			case 0:
				this.setFitWidth(16*SCALE);
				this.setLayoutX(BODY_X-1*SCALE);
				this.setLayoutY(BODY_Y+2*SCALE);
				break;
			case 1:
			case 2:
				this.setFitWidth(29*SCALE);
				this.setLayoutX(BODY_X);
				this.setLayoutY(BODY_Y);
				break;
			case 3:
				this.setFitWidth(11*SCALE);
				this.setLayoutX(BODY_X+15*SCALE);
				this.setLayoutY(BODY_Y-1*SCALE);
				break;
			}
			break;
			
		//皮甲
		case 2:
			switch(number%10){
			case 0:
				this.setFitWidth(13*SCALE);
				this.setLayoutX(BODY_X-3*SCALE);
				this.setLayoutY(BODY_Y+4*SCALE);
				break;
			case 1:
			case 2:
				this.setFitWidth(29*SCALE);
				this.setLayoutX(BODY_X);
				this.setLayoutY(BODY_Y);
				break;
			case 3:
				this.setFitWidth(11*SCALE);
				this.setLayoutX(BODY_X+17*SCALE);
				this.setLayoutY(BODY_Y+2*SCALE);
				break;
			}
			break;
			
		//铁甲
		case 3:
			switch(number%10){
			case 0:
				this.setFitWidth(10*SCALE);
				this.setLayoutX(BODY_X);
				this.setLayoutY(BODY_Y+2*SCALE);
				break;
			case 1:
			case 2:
				this.setFitWidth(32*SCALE);
				this.setLayoutX(BODY_X-1*SCALE);
				this.setLayoutY(BODY_Y);
				break;
			case 3:
				this.setFitWidth(9*SCALE);
				this.setLayoutX(BODY_X+17*SCALE);
				this.setLayoutY(BODY_Y);
				break;
			}
			break;
		}
		
		
		//zOrder
		switch(number%10){
		case 0:
			this.setZOrder(2);
			break;
		case 1:
		case 2:
			this.setZOrder(16);
			break;
		case 3:
			this.setZOrder(22);
			break;
		}

	}
	
}
