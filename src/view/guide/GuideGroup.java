package view.guide;

import javafx.scene.Group;

public class GuideGroup extends Group {

	public GuideGroup(){
		GuidePanel3 guidePanel3= new GuidePanel3();
		this.getChildren().add(guidePanel3);
	}
}
