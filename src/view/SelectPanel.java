package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import view.eventhandler.MenuHandler;

public class SelectPanel extends OrderPanel {
	private SystemButton closeBtn;
	public Label messageLabel;

	public Button yesBtn;
	public Button noBtn;

	public SelectPanel(EventHandler eventHandler, String message) { 
		this.setPrefSize(350, 200);
		this.setLayoutX(450);
		this.setLayoutY(300);
		this.setId("archive-view");
		
		messageLabel = new Label(message);
		messageLabel.setPrefSize(300, 50);
		messageLabel.setLayoutX(30);
		messageLabel.setLayoutY(30);
		messageLabel.setId("item-description"); 

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(325);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				SelectPanel.this.setVisible(false);
			}
		});
		this.getChildren().add(closeBtn);

		yesBtn = new Button("确 认");
		yesBtn.setPrefSize(90, 50);
		yesBtn.setLayoutX(30);
		yesBtn.setLayoutY(100);				
		yesBtn.setId("Aload-btn");

		noBtn = new Button("取 消");
		noBtn.setPrefSize(90, 50);
		noBtn.setLayoutX(200);
		noBtn.setLayoutY(100);
		noBtn.setId("Asave-btn");
		
		btnAbled(0);
		btnAbled(1);

		this.getChildren().addAll(yesBtn, noBtn, messageLabel);

	}

	public void btnPressed(int num) {
		if (num == 0) {
			yesBtn.setLayoutY(104);
			yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		} else {
			noBtn.setLayoutY(104);
			noBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if (num == 0) {
			yesBtn.setLayoutY(104);
			yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		} else {
			noBtn.setLayoutY(104);
			noBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}

}
