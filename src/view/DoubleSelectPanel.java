package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.eventhandler.MenuHandler;

public class DoubleSelectPanel extends Pane {

	private SystemButton closeBtn;
	
	public Button serverBtn;
	public Button clientBtn;

	public DoubleSelectPanel(MenuHandler menuHandler) {
		this.setPrefSize(300, 220);
		this.setLayoutX(450);
		this.setLayoutY(300);
		this.setId("archive-view");

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(275);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				DoubleSelectPanel.this.setVisible(false);
			}
		});
		this.getChildren().add(closeBtn);
		
		serverBtn = new Button("创建连接");
		serverBtn.setPrefSize(160, 40);
		serverBtn.setLayoutX(70);
		serverBtn.setLayoutY(72);
		serverBtn.setId("Aload-btn");
		serverBtn.setOnMouseEntered(menuHandler.serverBtnEnterEvent);
		serverBtn.setOnMouseExited(menuHandler.serverBtnExitEvent);
		serverBtn.setOnMouseClicked(menuHandler.serverEvent);
		
		clientBtn = new Button("寻找连接");
		clientBtn.setPrefSize(160, 40);
		clientBtn.setLayoutX(70);
		clientBtn.setLayoutY(142);
		clientBtn.setId("Asave-btn");
		clientBtn.setOnMouseEntered(menuHandler.clientBtnEnterEvent);
		clientBtn.setOnMouseExited(menuHandler.clientBtnExitEvent);
		clientBtn.setOnMouseClicked(menuHandler.clientEvent);
		btnAbled(0);
		btnAbled(1);
		
		this.getChildren().addAll(serverBtn, clientBtn);
		
	}

	public void btnPressed(int num) {
		if(num == 0){
			serverBtn.setLayoutY(76);
			serverBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		}else{
			clientBtn.setLayoutY(146);
			clientBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if(num == 0){
			serverBtn.setLayoutY(72);
			serverBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		}else{
			clientBtn.setLayoutY(142);
			clientBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}
}
