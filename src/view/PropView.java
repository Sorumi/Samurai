package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PropView extends Pane{

	private int num;
	private int x;
	private int y;
	
	private int chessBoardWidthOffset = 150 / 2 ;
	private int chessBoardHeightOffset = 200 - 20;
	private int blockWidthOffset = 1050 / 15 / 2;
	private int blockHeightOffset = 600 / 15 / 2;
	private int width = 35;
	
	public PropView(int num, int SCALE){

		switch(SCALE){
		case 1:
			 width = 30;
			 break;
		case 2:
			 width = 50;
			 break;
		case 3:
			 width = 100;
			 break;
		}
		this.setPrefSize(width, width);

		ImageView imgV = new ImageView(Images.PROP_0);
		imgV.setFitWidth(width);
		imgV.setPreserveRatio(true);
		
		this.getChildren().add(imgV);
	}
	
	public void setActualLocation(int x, int y){
		this.x = x;
		this.y = y;
		this.setLayoutX(chessBoardWidthOffset+ 1050 /2+(y-x)*blockWidthOffset-15);
		this.setLayoutY(chessBoardHeightOffset+(x+y)*blockHeightOffset-10);
	}
}
