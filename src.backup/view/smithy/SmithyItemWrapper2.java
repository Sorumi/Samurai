package view.smithy;

import javafx.collections.FXCollections;
import view.eventhandler.SmithyHandler;

public class SmithyItemWrapper2 extends SmithyItemWrapper {

	//lockGroup
	
	//battleax
	public SmithyItemWrapper2(SmithyHandler smithyHandler) {
		super(2, smithyHandler);
		
		SmithyItemView item211 = new SmithyItemView(211, -1);
		item211.setLayoutY(300);
		
		SmithyItemView item212 = new SmithyItemView(212, 0);
		item212.setLayoutY(300);
		
		SmithyItemView item213 = new SmithyItemView(213, -125);
		item213.setLayoutY(175);
		
		SmithyItemView item214 = new SmithyItemView(214, 0);
		item214.setLayoutY(175);
		
		SmithyItemView item215 = new SmithyItemView(215, -125);
		item215.setLayoutY(50);
		
		SmithyItemView item216 = new SmithyItemView(216, 0);
		item216.setLayoutY(50);
		
		SmithyItemView item225 = new SmithyItemView(225, -125, 125);
		item225.setLayoutY(300);
		
		SmithyItemView item226 = new SmithyItemView(226, 0);
		item226.setLayoutY(300);
		
		SmithyItemView item233 = new SmithyItemView(233, 125);
		item233.setLayoutY(425);
		
		SmithyItemView item234 = new SmithyItemView(234, 0);
		item234.setLayoutY(425);
		
		SmithyItemView item235 = new SmithyItemView(235, 125);
		item235.setLayoutY(550);
		
		SmithyItemView item236 = new SmithyItemView(236, 0);
		item236.setLayoutY(550);
		
		//TODO
		list = FXCollections.observableArrayList(item211, item212, item213, item214, item215, item216, item225, item226, item233, item234, item235, item236);
		
//		this.buildGroup.getChildren().addAll();
		this.lockGroup.getChildren().addAll(item211, item212, item213, item214, item215, item216, item225, item226, item233, item234, item235, item236);
		
		this.initWeaponView();
	}

}
