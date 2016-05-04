package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class WeaponView extends StackPane{

	private double SCALE = 1;
	private ImageView imgV;
	private ImageView imgVExtra;
	
	public WeaponView(int number){
		this.setPrefSize(100, 100);
		
		if(Images.WEAPON[number/100][number%100/10][number%10] != null){
			imgV = new ImageView(Images.WEAPON[number/100][number%100/10][number%10]);
			imgV.setFitWidth(Images.WEAPON[number/100][number%100/10][number%10].getWidth()/6*SCALE);
			imgV.setPreserveRatio(true);
			imgV.setSmooth(true);
			
			if(Images.WEAPON[number/100][number%100/10][number%10].getHeight()/6*SCALE > 100){
				imgV.setScaleX(1.2);
				imgV.setScaleY(1.2);
			}else{
				imgV.setScaleX(1.5);
				imgV.setScaleY(1.5);
			}
			
			if(number/100 != 4){
				imgV.setRotate(45);
			}else{
				imgV.setRotate(-45);
				imgVExtra = new ImageView(Images.WEAPON[number/100+1][number%100/10][number%10]);
				imgVExtra.setFitWidth(Images.WEAPON[number/100+1][number%100/10][number%10].getWidth()/6*SCALE);
				imgVExtra.setPreserveRatio(true);
				imgVExtra.setSmooth(true);
				imgVExtra.setScaleX(1.5);
				imgVExtra.setScaleY(1.5);
				imgVExtra.setRotate(-45);
				this.getChildren().add(imgVExtra);
				this.setAlignment(imgVExtra, Pos.CENTER);
			}
			
			this.getChildren().add(imgV);
			this.setAlignment(imgV, Pos.CENTER);
		}

		this.setStyle("-fx-content-display: center;"
				+ "-fx-alignment: center;");
	}
}
