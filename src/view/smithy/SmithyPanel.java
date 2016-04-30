package view.smithy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.SystemCloseButton;
import view.eventhandler.SmithyHandler;

public class SmithyPanel extends Pane {
	
	private SmithyHandler smithyHandler;
	
	private Button spearBtn;
	private Button swordBtn;
	private Button battleaxBtn;
	private Button shurikenBtn;
	private Button bowBtn;
	
	private SmithyItemWrapper0 spearPanel;
	private SmithyItemWrapper1 swordPanel;
	private SmithyItemWrapper2 battleaxPanel;
	private SmithyItemWrapper3 shurikenPanel;
	private SmithyItemWrapper4 bowPanel;
	
	public SmithyPanel(){
		this.setPrefSize(1200, 800);
		
		smithyHandler = new SmithyHandler(this);

		SmithyGroup spearGroup = new SmithyGroup();
		SmithyGroup swordGroup = new SmithyGroup();
		SmithyGroup battleaxGroup = new SmithyGroup();
		SmithyGroup shurikenGroup = new SmithyGroup();
		SmithyGroup bowGroup = new SmithyGroup();
		
		spearBtn = new SmithyButton(0);
		spearPanel = new SmithyItemWrapper0();
		spearGroup.getChildren().addAll(spearBtn, spearPanel);
		
		swordBtn = new SmithyButton(1);
		swordPanel = new SmithyItemWrapper1();
		swordGroup.getChildren().addAll(swordBtn, swordPanel);
		
		battleaxBtn = new SmithyButton(2);
		battleaxPanel = new SmithyItemWrapper2();
		battleaxGroup.getChildren().addAll(battleaxBtn, battleaxPanel);
		
		shurikenBtn = new SmithyButton(3);
		shurikenPanel = new SmithyItemWrapper3();
		shurikenGroup.getChildren().addAll(shurikenBtn, shurikenPanel);
		
		bowBtn = new SmithyButton(4);
		bowPanel = new SmithyItemWrapper4();
		bowGroup.getChildren().addAll(bowBtn, bowPanel);
		
		spearBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		swordBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		battleaxBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		shurikenBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		bowBtn.setOnMouseClicked(smithyHandler.wrapperToFrontEvent);
		
		this.getChildren().addAll(bowGroup, shurikenGroup, battleaxGroup, swordGroup, spearGroup);
		
	}
	
	//内部类
	public class SmithyGroup extends Group {
		public SmithyGroup(){
			this.setStyle("-fx-effect: dropshadow(gaussian, rgb(128,128,128), 2, 0, 0, 1)");
		}
	}
	
}
