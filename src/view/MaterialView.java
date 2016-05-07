package view;


import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MaterialView extends StackPane{

	private ImageView imgV;
	

	public MaterialView(int number){

		this.setPrefSize(100, 100);
		
		if(Images.MATERIAL[number/10][number%10]!= null){
			imgV = new ImageView(Images.MATERIAL[number/10][number%10]);
			imgV.setFitWidth(Images.MATERIAL[number/10][number%10].getWidth()/2);
			imgV.setPreserveRatio(true);
			imgV.setSmooth(true);
		}
		
		this.getChildren().add(imgV);
		StackPane.setAlignment(imgV, Pos.CENTER);
	}
	
	

}
 