package view;

import images.Images;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MaterialView extends StackPane {
	private int num;

	private ImageView imgV;
	
	public MaterialView() {
		this.setPrefSize(100, 100);
	}

	public MaterialView(int number) {
		this.num = number;

		this.setPrefSize(100, 100);


		if (Images.MATERIAL[number / 10][number % 10] != null) {
			imgV = new ImageView(Images.MATERIAL[number / 10][number % 10]);
			imgV.setPreserveRatio(true);
			imgV.setSmooth(true);
		}
		this.setInit(); 
		this.getChildren().add(imgV);
		StackPane.setAlignment(imgV, Pos.CENTER);

	}

	private void setInit(){ 
		switch (num) {
		case 0:imgV.setFitWidth(79);break;
		case 1:imgV.setFitWidth(79);break;
		case 2:imgV.setFitWidth(79);break;
		case 3:imgV.setFitWidth(79);break;
		case 10:imgV.setFitWidth(69);break;
		case 11:imgV.setFitWidth(69);break;
		case 12:imgV.setFitWidth(68);break;
		case 13:imgV.setFitWidth(68);break;
		case 20:imgV.setFitWidth(68);break;
		case 21:imgV.setFitWidth(82);break;
		case 22:imgV.setFitWidth(82);break;
		case 23:imgV.setFitWidth(78);break;
		case 30:imgV.setFitWidth(77);break;
		case 31:imgV.setFitWidth(77);break;
		case 32:imgV.setFitWidth(77);break;
		case 33:imgV.setFitWidth(77);break;
		case 40:imgV.setFitWidth(57);break;
		case 41:imgV.setFitWidth(57);break;
		case 42:imgV.setFitWidth(55);break;
		case 43:imgV.setFitWidth(63);break;
		
		}

	}

}
