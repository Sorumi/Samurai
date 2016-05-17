package view.smithy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.StoryModel;
import view.SystemButton;
import view.TerritoryPanel;
import view.TransitionPanel;
import view.campsite.CampsitePanel;
import view.eventhandler.SmithyHandler;
import view.eventhandler.StateHandler;

public class SmithyPanel extends TransitionPanel {
	
	private SmithyHandler smithyHandler;

	public Group routeGroup;
	private SmithyGroup spearGroup;
	private SmithyGroup swordGroup;
	private SmithyGroup battleaxGroup;
	private SmithyGroup shurikenGroup;
	private SmithyGroup bowGroup;
	private SmithyGroup armorGroup; 
	
	public SmithyItemWrapper0 spearPanel;
	public SmithyItemWrapper1 swordPanel;
	public SmithyItemWrapper2 battleaxPanel;
	public SmithyItemWrapper3 shurikenPanel;
	public SmithyItemWrapper4 bowPanel;
	public SmithyItemWrapper5 armorPanel;
	
	
	public SmithyBuilder buildPanel;
	public SmithyWeaponState smithyWeaponState;
	
	
	
	public SystemButton closeBtn;
	
	public SmithyPanel(){
		super();
		
		this.setPrefSize(1200, 800);
		
		smithyHandler = new SmithyHandler(this);
//		smithyWeaponState = new SmithyWeaponState();
//		this.getChildren().add(smithyWeaponState);

		spearGroup = new SmithyGroup();
		swordGroup = new SmithyGroup();
		battleaxGroup = new SmithyGroup();
		shurikenGroup = new SmithyGroup();
		bowGroup = new SmithyGroup();
		armorGroup = new SmithyGroup();
		
		Button spearBtn = new SmithyButton(0);
		spearPanel = new SmithyItemWrapper0(smithyHandler);
		spearGroup.getChildren().addAll(spearBtn, spearPanel);

		Button swordBtn = new SmithyButton(1);
		swordPanel = new SmithyItemWrapper1(smithyHandler);
		swordGroup.getChildren().addAll(swordBtn, swordPanel);
		
		Button battleaxBtn = new SmithyButton(2);
		battleaxPanel = new SmithyItemWrapper2(smithyHandler);
		battleaxGroup.getChildren().addAll(battleaxBtn, battleaxPanel);
		
		Button shurikenBtn = new SmithyButton(3);
		shurikenPanel = new SmithyItemWrapper3(smithyHandler);
		shurikenGroup.getChildren().addAll(shurikenBtn, shurikenPanel);
		
		Button bowBtn = new SmithyButton(4);
		bowPanel = new SmithyItemWrapper4(smithyHandler);
		bowGroup.getChildren().addAll(bowBtn, bowPanel);
		
		Button armorBtn = new SmithyButton(5);
		armorBtn.setLayoutY(650);
//		armorBtn.setStyle("-fx-background-color: #dddddd" );
		armorPanel = new SmithyItemWrapper5(smithyHandler); 
		armorGroup.getChildren().addAll(armorBtn, armorPanel);
		
		spearBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		swordBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		battleaxBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		shurikenBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		bowBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		armorBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent); 
		
		//closeBtn
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel parent =  (TerritoryPanel) SmithyPanel.this.getParent();
				parent.getChildren().remove(SmithyPanel.this);
				parent.setBlur(false);
			}
		});
		
		routeGroup = new Group();
		routeGroup.getChildren().addAll(armorGroup, bowGroup, shurikenGroup, battleaxGroup, swordGroup, spearGroup, closeBtn);
		this.getChildren().add(routeGroup);
		
		smithyWeaponState = new SmithyWeaponState();
		this.getChildren().add(smithyWeaponState);
		
		smithyHandler.update();
		this.transitionAnimation(true);

	}

	public int weaponNum(){
		return this.buildPanel.getItemNum();
	}
	
	//内部类
	private class SmithyGroup extends Group {
		public SmithyGroup(){
			this.setStyle("-fx-effect: dropshadow(gaussian, rgb(128,128,128), 2, 0, 0, 1)");
		}
	}
	
}
