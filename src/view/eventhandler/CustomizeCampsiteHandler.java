package view.eventhandler;

import controller.CampsiteController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import musics.Musics;
import view.campsite.CampsitePanel;
import view.campsite.CampsiteSamuraiWrapper.SamuraiButton;

public class CustomizeCampsiteHandler {

	private CampsitePanel campsitePanel;
	private CampsiteController campsiteController;
	
	public CustomizeCampsiteHandler(CampsitePanel campsitePanel) {
		this.campsitePanel = campsitePanel;
		
		this.campsiteController = new CampsiteController();
		this.campsiteController.setStoryModel(StoryModel.getStoryModel());

		this.campsiteController.setWeaponNum();
	}
	
	public void updateSamurai(int num) {
		campsitePanel.samuraiPanel.setSamurai(num);
//		campsitePanel.samuraiPanel.setWeapon(campsiteController.getWeaponOfSamurai(num).getType());
//		campsitePanel.samuraiPanel.setArmor(campsiteController.getArmorOfSamurai(num).getType() - 900);
//		campsitePanel.samuraiPanel.lastWeapon = campsiteController.getWeaponOfSamurai(num).getType();
//		campsitePanel.samuraiPanel.lastArmor = campsiteController.getArmorOfSamurai(num).getType() - 900;

	}
	
	public EventHandler<MouseEvent> samuraiClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			SamuraiButton samurai = (SamuraiButton) event.getSource();
//			updateSamurai(samurai.num);
		}
	};
	
	// 设置武器按钮
		public EventHandler<MouseEvent> setItemClickEvent = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				// 用 controller 换武器
				if (campsitePanel.samuraiPanel.isWeapon) {
//					campsiteController.changeWeapon(campsitePanel.samuraiPanel.getSamuraiNum(),
//							campsitePanel.samuraiPanel.currentWeapon);
					//customize
				}
				
				if (campsitePanel.samuraiPanel.isArmor) {
//					campsiteController.changeArmor(campsitePanel.samuraiPanel.getSamuraiNum(),
//							campsitePanel.samuraiPanel.currentArmor + 900);
				}

				updateSamurai(campsitePanel.samuraiPanel.samuraiNum);
				Musics.playEffectMusic(1);
			}
		};
	
}
