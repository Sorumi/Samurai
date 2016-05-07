package view.smithy;

import javafx.collections.FXCollections;
import view.eventhandler.SmithyHandler;

public class SmithyItemWrapper1 extends SmithyItemWrapper {

	//lockGroup
	
	//sword
	public SmithyItemWrapper1(SmithyHandler smithyHandler) {
		super(1, smithyHandler);
		
		SmithyItemView item111 = new SmithyItemView(111, -1);
		item111.setLayoutY(362.5);
		
		SmithyItemView item112 = new SmithyItemView(112, -188);
		item112.setLayoutY(175);
		
		SmithyItemView item113 = new SmithyItemView(113, 0);
		item113.setLayoutY(175);
		
		SmithyItemView item114 = new SmithyItemView(114, 125);
		item114.setLayoutY(300);
		
		SmithyItemView item115 = new SmithyItemView(115, 0);
		item115.setLayoutY(300);
		
		SmithyItemView item116 = new SmithyItemView(116, 0);
		item116.setLayoutY(300);
		
		SmithyItemView item124 = new SmithyItemView(124, -125);
		item124.setLayoutY(50);
		
		SmithyItemView item125 = new SmithyItemView(125, 0);
		item125.setLayoutY(50);
		
		SmithyItemView item126 = new SmithyItemView(126, 0);
		item126.setLayoutY(50);
		
		SmithyItemView item132 = new SmithyItemView(132, 187);
		item132.setLayoutY(550);
		
		SmithyItemView item133 = new SmithyItemView(133, 0);
		item133.setLayoutY(550);
		
		SmithyItemView item134 = new SmithyItemView(134, 0);
		item134.setLayoutY(550);
		
		SmithyItemView item135 = new SmithyItemView(135, 0);
		item135.setLayoutY(550);
		
		SmithyItemView item136 = new SmithyItemView(136, 0);
		item136.setLayoutY(550);
		
		//TODO
		list = FXCollections.observableArrayList(item111, item112,item132, item113, item114, item115, item116, item124, item125, item126, item133, item134, item135, item136);
		
		this.buildGroup.getChildren().addAll(item111, item112,item132);
		this.lockGroup.getChildren().addAll(item111, item112,item132, item113, item114, item115, item116, item124, item125, item126, item133, item134, item135, item136);

		this.initWeaponView();
	}

}
