package view.shop;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import view.Images;
import view.eventhandler.ShopHandler;

public class ShopItemPurchase extends Pane{
	private ImageView img1;
	private ImageView img2;
	
	private Label perPriceLabel;
	private Label quantityLabel;
	private Label totalPriceLabel;
	
	public int quantity = 0;
	private int perPrice;
	private Group plusGroup;  
	private Group minusGroup;  
	
	private Button buyButton;

	private ShopHandler shopHandler;
	
	public ShopItemPurchase(ShopHandler shopHandler){  
		this.setPrefSize(500, 340);
		this.setLayoutX(650);
		this.setLayoutY(270);
		this.setId("campsite-wrapper");

		this.shopHandler = shopHandler;



		img1 = new ImageView(Images.COIN);
		img1.setFitWidth(30);
		img1.setPreserveRatio(true);
		img1.setLayoutX(50);
		img1.setLayoutY(50);
		img2 = new ImageView(Images.COIN);
		img2.setFitWidth(30);
		img2.setPreserveRatio(true);
		img2.setLayoutX(50);
		img2.setLayoutY(110);
		
		perPriceLabel = new Label("- "+perPrice);
		perPriceLabel.setLayoutX(93);
		perPriceLabel.setLayoutY(55);
		perPriceLabel.setId("perprice-label");
		
		quantityLabel = new Label(""+quantity); 
		quantityLabel.setLayoutX(384);
		quantityLabel.setLayoutY(112);
		quantityLabel.setId("quantity-label"); 
		
		totalPriceLabel = new Label("- "+perPrice*quantity); 
		totalPriceLabel.setLayoutX(93);
		totalPriceLabel.setLayoutY(114);
		totalPriceLabel.setId("perprice-label");
		
		Circle circle1 = new Circle();
		circle1.setCenterX(345);
		circle1.setCenterY(123);
		circle1.setRadius(15);
		circle1.setFill(Color.web("#D7ECF0"));
		
		Label minusLabel = new Label("-");
		minusLabel.setLayoutX(341);
		minusLabel.setLayoutY(111);
		minusLabel.setId("plus-label");
		
		minusGroup = new Group();
		minusGroup.getChildren().addAll(circle1, minusLabel);
		minusGroup.setOnMouseClicked(shopHandler.minusQuantityEvent); 
		
		Circle circle2 = new Circle();
		circle2.setCenterX(435);
		circle2.setCenterY(123);
		circle2.setRadius(15);
		circle2.setFill(Color.web("#D7ECF0"));
				
		Label plusLabel = new Label("+");
		plusLabel.setLayoutX(430);
		plusLabel.setLayoutY(110);
		plusLabel.setId("plus-label");
		
		plusGroup = new Group(); 
		plusGroup.getChildren().addAll(circle2, plusLabel);
		plusGroup.setOnMouseClicked(shopHandler.plusQuantityEvent);
		
		buyButton = new Button("购 买");
		buyButton.setPrefSize(100, 40);
		buyButton.setId("buy-btn");
		buyButton.setLayoutX(50);
		buyButton.setLayoutY(242);
		buyButton.setOnMouseEntered(shopHandler.buyBtnEnterEvent);
		buyButton.setOnMouseExited(shopHandler.buyBtnExitEvent);
		buyButton.setOnMouseClicked(shopHandler.buyBtnClickEvent);
		
		buyBtnAbled();
		
		this.getChildren().addAll(img1, img2, perPriceLabel, quantityLabel, totalPriceLabel, plusGroup, minusGroup, buyButton);
	}
	
	public void buyBtnPressed() {
		buyButton.setLayoutY(246);
		buyButton.setStyle("-fx-effect: dropshadow(gaussian, #B4D1D6, 0, 0, 0, 4);");

//		this.shopHandler.getShopController().getPropsStore().getProps(this.shopHandler)
	}

	public void buyBtnAbled() {
		buyButton.setLayoutY(242);
		buyButton.setStyle("-fx-effect: dropshadow(gaussian, #B4D1D6, 0, 0, 0, 8);");
	}
	
	public void setQuantity(int i){  
		quantityLabel.setText(i + "");
		totalPriceLabel.setText("- "+perPrice*i); 

		this.quantity = i;
	}

	public void setPrice(int perPrice){
		this.perPrice = perPrice;
		perPriceLabel.setText("- "+perPrice);
		this.setQuantity(0);
	}
	
	public int getQuantity(){
		return this.quantity;
	}
}
