package view.smithy;

import javafx.collections.FXCollections;
import view.eventhandler.SmithyHandler;

public class SmithyItemWrapper0 extends SmithyItemWrapper {

	//lockGroup
	
	//spear
	public SmithyItemWrapper0(SmithyHandler smithyHandler) {
		super(0, smithyHandler);
		
		SmithyItemView item011 = new SmithyItemView(11, -1);
		item011.setLayoutY(300);
		
		SmithyItemView item012 = new SmithyItemView(12, 0);
		item012.setLayoutY(300);
		
		SmithyItemView item013 = new SmithyItemView(13, -250);
		item013.setLayoutY(50);		
		
		SmithyItemView item014 = new SmithyItemView(14, -125, 125);
		item014.setLayoutY(175);
		
		SmithyItemView item015 = new SmithyItemView(15, -125);
		item015.setLayoutY(50);
		
		SmithyItemView item016 = new SmithyItemView(16, 0);
		item016.setLayoutY(50);
		
		SmithyItemView item023 = new SmithyItemView(23, 0);
		item023.setLayoutY(300);
		
		SmithyItemView item025 = new SmithyItemView(25, 125);
		item025.setLayoutY(300);
		
		SmithyItemView item026 = new SmithyItemView(26, 0);
		item026.setLayoutY(300);
		
		SmithyItemView item033 = new SmithyItemView(33, 250);
		item033.setLayoutY(550);
		
		SmithyItemView item034 = new SmithyItemView(34, 0);
		item034.setLayoutY(550);
		
		SmithyItemView item035 = new SmithyItemView(35, 0);
		item035.setLayoutY(550);
		
		SmithyItemView item036 = new SmithyItemView(36, 0);
		item036.setLayoutY(550);
		
		//TODO
		list = FXCollections.observableArrayList(item011, item012, item013, item014, item015, item016, item023, item025, item026, item033, item034, item035, item036);

//		this.buildGroup.getChildren().addAll();
		this.lockGroup.getChildren().addAll(item011, item012, item013, item014, item015, item016, item023, item025, item026, item033, item034, item035, item036);
		
		this.initWeaponView();
	}


}
