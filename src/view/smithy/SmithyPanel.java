package view.smithy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.SystemCloseButton;
import view.TerritoryPanel;
import view.campsite.CampsitePanel;
import view.eventhandler.SmithyHandler;

public class SmithyPanel extends Pane {
	
	private SmithyHandler smithyHandler;

	public Group routeGroup;
	private SmithyGroup spearGroup;
	private SmithyGroup swordGroup;
	private SmithyGroup battleaxGroup;
	private SmithyGroup shurikenGroup;
	private SmithyGroup bowGroup;
	
	public SmithyBuilder buildPanel;
	
	public SystemCloseButton closeBtn;
	
	public SmithyPanel(){
		this.setPrefSize(1200, 800);
		
		smithyHandler = new SmithyHandler(this);

		spearGroup = new SmithyGroup();
		swordGroup = new SmithyGroup();
		battleaxGroup = new SmithyGroup();
		shurikenGroup = new SmithyGroup();
		bowGroup = new SmithyGroup();
		
		Button spearBtn = new SmithyButton(0);
		SmithyItemWrapper0 spearPanel = new SmithyItemWrapper0(smithyHandler);
		spearGroup.getChildren().addAll(spearBtn, spearPanel);

		Button swordBtn = new SmithyButton(1);
		SmithyItemWrapper1 swordPanel = new SmithyItemWrapper1(smithyHandler);
		swordGroup.getChildren().addAll(swordBtn, swordPanel);
		
		Button battleaxBtn = new SmithyButton(2);
		SmithyItemWrapper2 battleaxPanel = new SmithyItemWrapper2(smithyHandler);
		battleaxGroup.getChildren().addAll(battleaxBtn, battleaxPanel);
		
		Button shurikenBtn = new SmithyButton(3);
		SmithyItemWrapper3 shurikenPanel = new SmithyItemWrapper3(smithyHandler);
		shurikenGroup.getChildren().addAll(shurikenBtn, shurikenPanel);
		
		Button bowBtn = new SmithyButton(4);
		SmithyItemWrapper4 bowPanel = new SmithyItemWrapper4(smithyHandler);
		bowGroup.getChildren().addAll(bowBtn, bowPanel);
		
		spearBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		swordBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		battleaxBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		shurikenBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		bowBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		
		//closeBtn
		closeBtn = new SystemCloseButton();
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel parent =  (TerritoryPanel) SmithyPanel.this.getParent();
				parent.getChildren().remove(SmithyPanel.this);
			}
		});
		
		routeGroup = new Group();
		routeGroup.getChildren().addAll(bowGroup, shurikenGroup, battleaxGroup, swordGroup, spearGroup, closeBtn);
		this.getChildren().add(routeGroup);

	}
	
	//内部类
	private class SmithyGroup extends Group {
		public SmithyGroup(){
			this.setStyle("-fx-effect: dropshadow(gaussian, rgb(128,128,128), 2, 0, 0, 1)");
		}
	}
	
}
