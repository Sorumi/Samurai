package view;

import images.Images;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MoneyPanel extends Pane {

	private Label money;
	
	public MoneyPanel(){
		this.setPrefSize(120, 50);
		this.setId("money-panel");
		
		ImageView coin = new ImageView(Images.COIN);
		coin.setFitWidth(30);
		coin.setPreserveRatio(true);
		coin.setLayoutX(10);
		coin.setLayoutY(10);
		
		money = new Label("1030");
		money.setId("money-label");
		money.setPrefSize(60, 30);
		money.setLayoutX(45);
		money.setLayoutY(10);
		
		this.getChildren().addAll(coin, money);
	}
	
	public void setMoney(int money){
		this.money.setText(money + "");
	}
}
