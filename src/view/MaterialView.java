package view;


import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MaterialView extends StackPane{
//	private double SCALE = 1;
	private ImageView imgV;
	
	public MaterialView(int number){
		this(number,1);
	}
	
	public MaterialView(int number, int scale){
		if(Images.MATERIAL[number/10][number%10]!= null){
			imgV = new ImageView(Images.MATERIAL[number/10][number%10]);
			imgV.setFitWidth(Images.MATERIAL[number/10][number%10].getWidth()/2);
			imgV.setPreserveRatio(true);
			imgV.setSmooth(true);
		}
		
		this.getChildren().add(imgV);
	}

}
 