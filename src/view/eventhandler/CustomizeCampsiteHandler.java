package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import musics.Musics;
import view.CustomizePanel;
import view.campsite.CampsitePanel;
import view.campsite.CampsiteSamuraiWrapper.SamuraiButton;

public class CustomizeCampsiteHandler {

	private CustomizePanel customizePanel;
	private CampsitePanel campsitePanel;

	
	public CustomizeCampsiteHandler(CampsitePanel campsitePanel, CustomizePanel customizePanel) {
		this.campsitePanel = campsitePanel;
		this.customizePanel = customizePanel;
	
	}
	
	public void updateSamurai(int num) {
		campsitePanel.samuraiPanel.setSamurai(num);
		campsitePanel.samuraiPanel.setWeapon(customizePanel.weapons[num]);
		campsitePanel.samuraiPanel.setArmor(customizePanel.armors[num]);
	}
	
	public EventHandler<MouseEvent> samuraiClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			SamuraiButton samurai = (SamuraiButton) event.getSource();
			updateSamurai(samurai.num);
		}
	};
	
	// 设置武器按钮
		public EventHandler<MouseEvent> setItemClickEvent = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				int num = campsitePanel.samuraiPanel.getSamuraiNum();
				if (campsitePanel.samuraiPanel.isWeapon) {
					customizePanel.weapons[num] = campsitePanel.samuraiPanel.currentWeapon;
				}
				
				if (campsitePanel.samuraiPanel.isArmor) {
					customizePanel.armors[num] = campsitePanel.samuraiPanel.currentArmor;
				}

				updateSamurai(campsitePanel.samuraiPanel.samuraiNum);
				Musics.playEffectMusic(1);
			}
		};
	
}
