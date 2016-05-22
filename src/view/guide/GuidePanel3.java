package view.guide;

import controller.GuideController;
import model.GameModelGuide;

public class GuidePanel3 extends GuidePanel {

	public GuidePanel3(){
		GameGuidePanel gamePanel = new GameGuidePanel(11);
		this.getChildren().add(gamePanel);

		GameModelGuide gameModel = new GameModelGuide(gamePanel);
		gameModel.addObserver(gamePanel);
		gameModel.getChessBoardModel().addObserver(gamePanel);

		GuideController guideController = new GuideController(gameModel);
		GuideController.start();
	}

}
