package view.smithy;

import view.eventhandler.SmithyHandler;

public class SmithyItemWrapper3 extends SmithyItemWrapper {

	//lockGroup
	
	//shuriken
	public SmithyItemWrapper3(SmithyHandler smithyHandler) {
		super(3, smithyHandler);
		
		SmithyItemView item311 = new SmithyItemView(311, -1);
		item311.setLayoutY(300);
		
		SmithyItemView item312 = new SmithyItemView(312, 0);
		item312.setLayoutY(300);
		
		SmithyItemView item313 = new SmithyItemView(313, -200);
		item313.setLayoutY(100);
		
		SmithyItemView item314 = new SmithyItemView(314, 0);
		item314.setLayoutY(100);
		
		SmithyItemView item315 = new SmithyItemView(315, 0);
		item315.setLayoutY(100);
		
		SmithyItemView item316 = new SmithyItemView(316, 0);
		item316.setLayoutY(100);
		
		SmithyItemView item323 = new SmithyItemView(323, 200);
		item323.setLayoutY(500);
		
		SmithyItemView item324 = new SmithyItemView(324, 0);
		item324.setLayoutY(500);
		
		SmithyItemView item325 = new SmithyItemView(325, 0);
		item325.setLayoutY(500);
		
		SmithyItemView item326 = new SmithyItemView(326, 0);
		item326.setLayoutY(500);
		
		
		this.buildGroup.getChildren().addAll(item311, item312);
		this.lockGroup.getChildren().addAll(item313, item314, item315, item316,item323, item324, item325, item326);
		
		this.addClickEvent();
	}

}
