package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import view.eventhandler.SuccessHandler;

public class SuccessPanel extends Pane{
	public SystemButton closeBtn;
	public Label messageLabel;
	public SuccessHandler successHandler;

	public Button yesBtn;
	
	public SuccessPanel(String message){ 
		this.setPrefSize(350, 230);
		this.setLayoutX(450);
		this.setLayoutY(300);
		this.setId("archive-view");
		this.successHandler = new SuccessHandler(this);  
		 
		messageLabel = new Label(message); 
		messageLabel.setPrefSize(250, 100);
		messageLabel.setLayoutX(120);
		messageLabel.setLayoutY(50);
		messageLabel.setId("select-message");
		messageLabel.setStyle("-fx-alignment: center-left;");  
		
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(325);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnMouseClicked(successHandler.yesBtnClickedEvent);
		
		yesBtn = new Button("确 认");
		yesBtn.setPrefSize(100, 40);
		yesBtn.setLayoutX(118);
		yesBtn.setLayoutY(150);				
		yesBtn.setId("Aload-btn");
		yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		yesBtn.setOnMouseEntered(successHandler.yesBtnEnterEvent);
		yesBtn.setOnMouseExited(successHandler.yesBtnExitEvent);
		yesBtn.setOnMouseClicked(successHandler.yesBtnClickedEvent);
		this.getChildren().addAll(closeBtn, messageLabel, yesBtn);
	}
	
	public void btnPressed() {
		yesBtn.setLayoutY(154);
		yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
	}
	
	public void btnAbled() {
		yesBtn.setLayoutY(150);
		yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
	}
	
	

}
