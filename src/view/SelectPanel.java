package view;

import controller.msgqueue.ContinueOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.StopOperation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import view.eventhandler.MenuHandler;
import view.eventhandler.SelectHandler;

public class SelectPanel extends OrderPanel {
	private SystemButton closeBtn;
	public Label messageLabel;

	public Button yesBtn;
	public Button noBtn;
	private SelectHandler selectHandler;

	public SelectPanel(String message) { 
		this.setPrefSize(350, 230);
		this.setLayoutX(450);
		this.setLayoutY(300);
		this.setId("archive-view");
		this.selectHandler = new SelectHandler(this);
		
		messageLabel = new Label(message);
		messageLabel.setPrefSize(250, 100);
		messageLabel.setLayoutX(50);
		messageLabel.setLayoutY(50);
		messageLabel.setId("select-message"); 

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(325);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				SelectPanel.this.setVisible(false);
				OperationQueue.addOperation(new ContinueOperation());
			}
		});
		this.getChildren().add(closeBtn);

		yesBtn = new Button("确 认");
		yesBtn.setPrefSize(100, 40);
		yesBtn.setLayoutX(50);
		yesBtn.setLayoutY(150);				
		yesBtn.setId("Aload-btn");
		yesBtn.setOnMouseEntered(selectHandler.yesBtnEnterEvent);
		yesBtn.setOnMouseExited(selectHandler.yesBtnExitEvent);

		noBtn = new Button("取 消");
		noBtn.setPrefSize(100, 40);
		noBtn.setLayoutX(200);
		noBtn.setLayoutY(150);
		noBtn.setId("Asave-btn");
		noBtn.setOnMouseEntered(selectHandler.noBtnEnterEvent);
		noBtn.setOnMouseExited(selectHandler.noBtnExitEvent);
		
		btnAbled(0);
		btnAbled(1);

		this.getChildren().addAll(yesBtn, noBtn, messageLabel);

	}

	public void btnPressed(int num) {
		if (num == 0) {
			yesBtn.setLayoutY(154);
			yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		} else {
			noBtn.setLayoutY(154);
			noBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if (num == 0) {
			yesBtn.setLayoutY(150);
			yesBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		} else {
			noBtn.setLayoutY(150);
			noBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}
	
	public void updateMessage(String s){
		messageLabel.setText(s);
	}

}
