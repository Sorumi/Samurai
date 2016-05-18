package view;

import images.Images;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.po.PropsInG;

public class PropView extends Pane{

	private int num;
	public int x;
	public int y;
	
	private int chessBoardWidthOffset = 150 / 2 ;
	private int chessBoardHeightOffset = 200 - 20;
	private int blockWidthOffset = 1050 / 15 / 2;
	private int blockHeightOffset = 600 / 15 / 2;
	private int width = 35;
	
	public PropView(int num, int SCALE){

		if(num/100 == 7){
			num = PropsInG.get14Type(num);
		}
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

		ImageView imgV = new ImageView(Images.PROP[num]); 
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
