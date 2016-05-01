package view.smithy;

import view.GameColor;

public class SmithyItemWrapper0 extends SmithyItemWrapper {

	//spear
	public SmithyItemWrapper0() {
		super();
		this.setStyle("-fx-background-color: " + GameColor.getColorString(0));
		
		
		SmithyItemView item011 = new SmithyItemView(11, -1);
		item011.setLayoutY(300);
		this.getChildren().add(item011);
		
		SmithyItemView item012 = new SmithyItemView(12, 0);
		item012.setLayoutY(300);
		this.getChildren().add(item012);
		
		SmithyItemView item013 = new SmithyItemView(13, -250);
		item013.setLayoutY(50);
		//TODO
		item013.setUnlocked(false);
		this.getChildren().add(item013);
		
		
		SmithyItemView item014 = new SmithyItemView(14, -125, 125);
		item014.setLayoutY(175);
		//TODO
		item014.setUnlocked(false);
		this.getChildren().add(item014);
		
		SmithyItemView item015 = new SmithyItemView(15, -125);
		item015.setLayoutY(50);
		//TODO
		item015.setUnlocked(false);
		this.getChildren().add(item015);
		
		SmithyItemView item016 = new SmithyItemView(16, 0);
		item016.setLayoutY(50);
		//TODO
		item016.setUnlocked(false);
		this.getChildren().add(item016);
		
		SmithyItemView item023 = new SmithyItemView(23, 0);
		item023.setLayoutY(300);
		//TODO
		item023.setUnlocked(false);
		this.getChildren().add(item023);
		
		SmithyItemView item025 = new SmithyItemView(25, 125);
		item025.setLayoutY(300);
		//TODO
		item025.setUnlocked(false);
		this.getChildren().add(item025);
		
		SmithyItemView item026 = new SmithyItemView(26, 0);
		item026.setLayoutY(300);
		//TODO
		item026.setUnlocked(false);
		this.getChildren().add(item026);
		
		SmithyItemView item033 = new SmithyItemView(33, 250);
		item033.setLayoutY(550);
		//TODO
		item033.setUnlocked(false);
		this.getChildren().add(item033);
		
		SmithyItemView item034 = new SmithyItemView(34, 0);
		item034.setLayoutY(550);
		//TODO
		item034.setUnlocked(false);
		this.getChildren().add(item034);
		
		SmithyItemView item035 = new SmithyItemView(35, 0);
		item035.setLayoutY(550);
		//TODO
		item035.setUnlocked(false);
		this.getChildren().add(item035);
		
		SmithyItemView item036 = new SmithyItemView(36, 0);
		item036.setLayoutY(550);
		//TODO
		item036.setUnlocked(false);
		this.getChildren().add(item036);
	}

}
