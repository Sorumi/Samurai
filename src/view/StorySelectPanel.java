
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.eventhandler.MenuHandler;

public class StorySelectPanel extends Pane {

	private SystemButton closeBtn;
	
	public Button newBtn;
	public Button oldBtn;

	public StorySelectPanel(MenuHandler menuHandler) {
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
				StorySelectPanel.this.setVisible(false);
			}
		});
		this.getChildren().add(closeBtn);
		
		newBtn = new Button("新的旅程");
		newBtn.setPrefSize(160, 40);
		newBtn.setLayoutX(70);
		newBtn.setLayoutY(72);
		newBtn.setId("Aload-btn");
//		newBtn.setOnMouseEntered(menuHandler.newBtnEnterEvent);
//		newBtn.setOnMouseExited(menuHandler.newBtnExitEvent);
//		newBtn.setOnMouseClicked(menuHandler.newStoryEvent);
		
		oldBtn = new Button("继续冒险");
		oldBtn.setPrefSize(160, 40);
		oldBtn.setLayoutX(70);
		oldBtn.setLayoutY(142);
		oldBtn.setId("Asave-btn");
//		oldBtn.setOnMouseEntered(menuHandler.oldBtnEnterEvent);
//		oldBtn.setOnMouseExited(menuHandler.oldBtnExitEvent);
//		oldBtn.setOnMouseClicked(menuHandler.archiveEvent);
		btnAbled(0);
		btnAbled(1);
		
		this.getChildren().addAll(newBtn, oldBtn);
		
	}

	public void btnPressed(int num) {
		if(num == 0){
			newBtn.setLayoutY(76);
			newBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		}else{
			oldBtn.setLayoutY(146);
			oldBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if(num == 0){
			newBtn.setLayoutY(72);
			newBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		}else{
			oldBtn.setLayoutY(142);
			oldBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}
}
