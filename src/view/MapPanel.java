package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MapPanel extends Pane {

	/*
	 * 关卡的按钮
	 */
	private SystemButton closeBtn;
	
	public MapPanel(){
		this.setPrefSize(1200, 800);
		this.setStyle("-fx-background-color: #dddddd");
		//levelBtn
		Button gameBtn1 = new Button("第一关");
		gameBtn1.setLayoutX(300);
		gameBtn1.setLayoutY(300);
		
		this.getChildren().add(gameBtn1);
		
		//closeBtn
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel parent =  (TerritoryPanel) MapPanel.this.getParent();
				parent.getChildren().remove(MapPanel.this);
			}
		});
		this.getChildren().add(closeBtn);
	}
}
