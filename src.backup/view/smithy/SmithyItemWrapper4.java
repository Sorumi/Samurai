package view.smithy;

import javafx.collections.FXCollections;
import view.eventhandler.SmithyHandler;

public class SmithyItemWrapper4 extends SmithyItemWrapper {

	//lockGroup
	
	//bow and arrow
	public SmithyItemWrapper4(SmithyHandler smithyHandler) {
		super(4, smithyHandler);
		
		SmithyItemView item411 = new SmithyItemView(411, -1);
		item411.setLayoutY(300);
		
		SmithyItemView item412 = new SmithyItemView(412, -200);
		item412.setLayoutY(100);
		
		SmithyItemView item413 = new SmithyItemView(413, 0);
		item413.setLayoutY(100);
		
		SmithyItemView item414 = new SmithyItemView(414, 0);
		item414.setLayoutY(100);
		
		SmithyItemView item415 = new SmithyItemView(415, 0);
		item415.setLayoutY(100);
		
		SmithyItemView item416 = new SmithyItemView(416, 0);
		item416.setLayoutY(100);
		
		SmithyItemView item422 = new SmithyItemView(422, 200);
		item422.setLayoutY(500);
		
		SmithyItemView item423 = new SmithyItemView(423, 0);
		item423.setLayoutY(500);
		
		SmithyItemView item424 = new SmithyItemView(424, 0);
		item424.setLayoutY(500);
		
		SmithyItemView item425 = new SmithyItemView(425, 0);
		item425.setLayoutY(500);
		
		SmithyItemView item426 = new SmithyItemView(426, 0);
		item426.setLayoutY(500);
		
		//TODO
		list = FXCollections.observableArrayList(item411, item412,item422, item413, item414, item415, item416,item423, item424, item425, item426);
		
//		this.buildGroup.getChildren().addAll();
		this.lockGroup.getChildren().addAll(item411, item412,item422, item413, item414, item415, item416,item423, item424, item425, item426);
		
		this.initWeaponView();
	}

}
