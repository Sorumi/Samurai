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

	public SelectPanel(EventHandler eventHandler) {
		this.setPrefSize(300, 220);
		this.setLayoutX(450);
		this.setLayoutY(300);
		this.setId("archive-view");
		
		messageLabel = new Label("确定退出吗？");
		messageLabel.setLayoutX(70);
		messageLabel.setLayoutY(30);
		messageLabel.setId("item-description"); 

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(275);
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
		yesBtn.setPrefSize(160, 40);
		yesBtn.setLayoutX(70);
		yesBtn.setLayoutY(72);
		yesBtn.setId("Aload-btn");
		// yesBtn.setOnMouseEntered(menuHandler.serverBtnEnterEvent);
		// yesBtn.setOnMouseExited(menuHandler.serverBtnExitEvent);
		// yesBtn.setOnMouseClicked(menuHandler.serverEvent);

		noBtn = new Button("取 消");
		noBtn.setPrefSize(160, 40);
		noBtn.setLayoutX(70);
		noBtn.setLayoutY(142);
		noBtn.setId("Asave-btn");
		// noBtn.setOnMouseEntered(menuHandler.clientBtnEnterEvent);
		// noBtn.setOnMouseExited(menuHandler.clientBtnExitEvent);
		// noBtn.setOnMouseClicked(menuHandler.clientEvent);
		btnAbled(0);
		btnAbled(1);

		this.getChildren().addAll(yesBtn, noBtn, messageLabel);

	}

	public void btnPressed(int num) {
		if (num == 0) {
			yesBtn.setLayoutY(76);
			yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		} else {
			noBtn.setLayoutY(146);
			noBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if (num == 0) {
			yesBtn.setLayoutY(72);
			yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		} else {
			noBtn.setLayoutY(142);
			noBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}

}
