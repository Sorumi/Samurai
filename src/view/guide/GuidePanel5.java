package view.guide;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GuidePanel5 extends GuidePanel{

	private Label mainLabel;
	private Label explainLabel1;
	private Label explainLabel2;
	private Label explainLabel3;
	private Label explainLabel4;
	
	public GuidePanel5(){
		
		mainLabel = new Label("游戏提示");
		mainLabel.setLayoutX(100);
		mainLabel.setLayoutY(100);
		mainLabel.setId("main-label");
		
		explainLabel1 = new Label("不同关卡可以得到不同的材料，可以得到的材料已经在面板中写明，需要注意的是，只有进行普通难度的游戏，才有可能获得稀有的材料，只有进行困难难度的游戏，才有可能获得史诗的材料，需要说明的是，每关只能获得本关的第一种材料的史诗级材料，需要特别注意。");
		explainLabel1.setLayoutX(100);
		explainLabel1.setLayoutY(150);
		explainLabel1.setPrefSize(800, 100);
		explainLabel1.setId("explain-label");
		
		explainLabel2 = new Label("材料可以卖出获得金钱，更重要的是材料可以用来合成装备，更新你的装备是战胜更高级的敌人的最基本保障。");
		explainLabel2.setLayoutX(100);
		explainLabel2.setLayoutY(300);
		explainLabel2.setPrefSize(800, 100);
		explainLabel2.setId("explain-label");
		
		explainLabel3 = new Label("道具可以在商店购买，也可以在关卡中捡到，但要注意，如果在战斗中逃跑或失败，那么你在这局中得到的道具将不会加入到你的道具栏中。");
		explainLabel3.setLayoutX(100);
		explainLabel3.setLayoutY(400);
		explainLabel3.setPrefSize(800, 100);
		explainLabel3.setId("explain-label");
	
		explainLabel4 = new Label("只有完成了之前关卡的简单模式才能进入下一个关卡。");
		explainLabel4.setLayoutX(100);
		explainLabel4.setLayoutY(500);
		explainLabel4.setPrefSize(800, 100);
		explainLabel4.setId("explain-label");
		
		this.getChildren().addAll(mainLabel, explainLabel1, explainLabel2, explainLabel3, explainLabel4);
	}

}
