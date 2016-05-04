package view.smithy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import view.GameColor;
import view.SystemCloseButton;

public class SmithyBuilder extends Pane {

	private SystemCloseButton closeBtn;
	
	public SmithyBuilder(int itemNum){
		
		this.setPrefSize(540, 700);
		this.setLayoutX(330);
		this.setLayoutY(50);
		this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(itemNum/100));
		this.setId("smithy-builder");
		
		//itemCircle
		Circle itemCircle = new Circle();
		
		//closeBtn
		closeBtn = new SystemCloseButton();
		closeBtn.setLayoutX(515);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				SmithyPanel parent = (SmithyPanel) SmithyBuilder.this.getParent();
				parent.getChildren().remove(SmithyBuilder.this);
				parent.routeGroup.setVisible(true);
			}
		});
		this.getChildren().add(closeBtn);
	}
}
