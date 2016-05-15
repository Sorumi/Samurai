package view.smithy;

import javafx.collections.FXCollections;
import view.eventhandler.SmithyHandler;

public class SmithyItemWrapper5 extends SmithyItemWrapper {
	public SmithyItemWrapper5(SmithyHandler smithyHandler) {
		super(5, smithyHandler);
		
		SmithyItemView item911 = new SmithyItemView(911, -1);
		item911.setLayoutY(362.5);

		SmithyItemView item912 = new SmithyItemView(912, 0);
		item912.setLayoutY(362.5);

		SmithyItemView item913 = new SmithyItemView(913, -312);
		item913.setLayoutY(50);

		SmithyItemView item914 = new SmithyItemView(914, 0);
		item914.setLayoutY(50);

		SmithyItemView item915 = new SmithyItemView(915, 0);
		item915.setLayoutY(50);

		SmithyItemView item916 = new SmithyItemView(916, 0);
		item916.setLayoutY(50);

		SmithyItemView item923 = new SmithyItemView(923, 62);
		item923.setLayoutY(425);

		SmithyItemView item924 = new SmithyItemView(924, -125);
		item924.setLayoutY(300);

		SmithyItemView item925 = new SmithyItemView(925, 0);
		item925.setLayoutY(300);

		SmithyItemView item926 = new SmithyItemView(926, 0);
		item926.setLayoutY(300);
		
		SmithyItemView item934 = new SmithyItemView(934, 125);
		item934.setLayoutY(550);
		
		SmithyItemView item935 = new SmithyItemView(935, 0);
		item935.setLayoutY(550);
		
		SmithyItemView item936 = new SmithyItemView(936, 0);
		item936.setLayoutY(550);

		// TODO
		list = FXCollections.observableArrayList(item911, item912, item913, item914, item915, item916, item923, item924,
				item925, item926, item934, item935, item936);


		this.lockGroup.getChildren().addAll(item911, item912, item913, item914, item915, item916, item923, item924,
				item925, item926, item934, item935, item936);
		
		this.initWeaponView();
	}

}
