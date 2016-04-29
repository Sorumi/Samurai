package view.smithy;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class SmithyPanel extends Pane {
	
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

		SmithyGroup spearGroup = new SmithyGroup();
		SmithyGroup swordGroup = new SmithyGroup();
		SmithyGroup battleaxGroup = new SmithyGroup();
		SmithyGroup shurikenGroup = new SmithyGroup();
		SmithyGroup bowGroup = new SmithyGroup();
		
		spearBtn = new SmithyButton(0);
		spearGroup.getChildren().add(spearBtn);
		spearPanel = new SmithyItemWrapper0();
		spearGroup.getChildren().add(spearPanel);
		
		swordBtn = new SmithyButton(1);
		swordGroup.getChildren().add(swordBtn);
		swordPanel = new SmithyItemWrapper1();
		swordGroup.getChildren().add(swordPanel);
		
		battleaxBtn = new SmithyButton(2);
		battleaxGroup.getChildren().add(battleaxBtn);
		battleaxPanel = new SmithyItemWrapper2();
		battleaxGroup.getChildren().add(battleaxPanel);
		
		shurikenBtn = new SmithyButton(3);
		shurikenGroup.getChildren().add(shurikenBtn);
		shurikenPanel = new SmithyItemWrapper3();
		shurikenGroup.getChildren().add(shurikenPanel);
		
		bowBtn = new SmithyButton(4);
		bowGroup.getChildren().add(bowBtn);
		bowPanel = new SmithyItemWrapper4();
		bowGroup.getChildren().add(bowPanel);
		
		this.getChildren().add(bowGroup);
		this.getChildren().add(shurikenGroup);
		this.getChildren().add(battleaxGroup);
		this.getChildren().add(swordGroup);
		this.getChildren().add(spearGroup);
	}
	
	//内部类
	private class SmithyGroup extends Group {
		public SmithyGroup(){
			this.setStyle("-fx-effect: dropshadow(gaussian, rgb(128,128,128), 2, 0, 0, 1)");
		}
	}
	
}
