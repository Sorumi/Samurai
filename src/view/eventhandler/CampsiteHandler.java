package view.eventhandler;

import controller.CampsiteController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Armor;
import model.po.Information;
import model.po.Weapon;
import musics.Musics;
import view.campsite.CampsiteItemView;
import view.campsite.CampsitePanel;
import view.campsite.CampsiteSamuraiWrapper.SamuraiButton;

public class CampsiteHandler {

	private CampsitePanel campsitePanel;
	private CampsiteController campsiteController;

	public CampsiteHandler(CampsitePanel campsitePanel) {
		this.campsitePanel = campsitePanel;
		this.campsiteController = new CampsiteController();
		this.campsiteController.setStoryModel(StoryModel.getStoryModel());

		this.campsiteController.setWeaponNum();
	}

	public void updateWeaponArmor() {
		campsitePanel.getItemsPanel().clearAll();
		campsitePanel.getItemsPanel().updateWeapon(campsiteController.getWeapons());
		campsitePanel.getItemsPanel().updateArmor(campsiteController.getArmors());
	}

	public void updateSamurai(int num) {
		campsitePanel.samuraiPanel.setSamurai(num);
		campsitePanel.samuraiPanel.setWeapon(campsiteController.getWeaponOfSamurai(num).getType());
		campsitePanel.samuraiPanel.setArmor(campsiteController.getArmorOfSamurai(num).getType() - 900);
		campsitePanel.samuraiPanel.lastWeapon = campsiteController.getWeaponOfSamurai(num).getType();
		campsitePanel.samuraiPanel.lastArmor = campsiteController.getArmorOfSamurai(num).getType() - 900;

	}

	public EventHandler<MouseEvent> itemEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			CampsiteItemView item = (CampsiteItemView) event.getSource();
			item.setHighlight();
		}
	};

	public EventHandler<MouseEvent> itemExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			CampsiteItemView item = (CampsiteItemView) event.getSource();
			item.setNormal();
		}
	};

	public EventHandler<MouseEvent> itemClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			CampsiteItemView item = (CampsiteItemView) event.getSource();
			if (item.getNum() / 100 != 9) {// weapon
				campsitePanel.samuraiPanel.setWeaponWithAnimation(item.getNum());

				Information information = campsiteController.getInformationOfTag(item.getNum());
				Weapon weapon = campsiteController.getWeaponOfTag(item.getNum());

				campsitePanel.infoPanel.setWeaponInfo(information.getTag(), information.getName(),
						information.getDescription(), weapon.getLowAttackPoint(), weapon.getHighAttackPoint(),
						weapon.getCriticalRate(), weapon.getArmorPenetration());
				
				if (weapon.getNumber() == 0 && !campsitePanel.isCustomized){
					campsitePanel.samuraiPanel.setItemBtnUnabled();
				} else {
					campsitePanel.samuraiPanel.setItemBtnAbled();
				}

			} else {// armor
				campsitePanel.samuraiPanel.setArmor(item.getNum() - 900);

				Information information = campsiteController.getInformationOfTag(item.getNum());
				Armor armor = campsiteController.getArmorOfTag(item.getNum());

				campsitePanel.infoPanel.setArmorInfo(information.getTag(), information.getName(),
						information.getDescription(), armor.getArmorValue(), armor.getDodgeRate());
				
				if (armor.getNumber() == 0 && !campsitePanel.isCustomized){
					campsitePanel.samuraiPanel.setItemBtnUnabled();
				} else {
					campsitePanel.samuraiPanel.setItemBtnAbled();
				}
			}
		}		
	};

	public EventHandler<MouseEvent> samuraiClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			SamuraiButton samurai = (SamuraiButton) event.getSource();
			updateSamurai(samurai.num);
		}
	};

	// 设置武器按钮
	public EventHandler<MouseEvent> setItemClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			// 用 controller 换武器
			if (campsitePanel.samuraiPanel.isWeapon) {
				campsiteController.changeWeapon(campsitePanel.samuraiPanel.getSamuraiNum(),
						campsitePanel.samuraiPanel.currentWeapon);
				//数量修正
				Weapon currentWeapon = campsiteController.getWeaponOfTag(campsitePanel.samuraiPanel.currentWeapon);
				currentWeapon.setNumber(currentWeapon.getNumber() - 1);
				Weapon lastWeapon = campsiteController.getWeaponOfTag(campsitePanel.samuraiPanel.lastWeapon);
				lastWeapon.setNumber(lastWeapon.getNumber() + 1);

			}
			
			if (campsitePanel.samuraiPanel.isArmor) {
				campsiteController.changeArmor(campsitePanel.samuraiPanel.getSamuraiNum(),
						campsitePanel.samuraiPanel.currentArmor + 900);

				//数量修正
				Armor currentArmor = campsiteController.getArmorOfTag(campsitePanel.samuraiPanel.currentArmor + 900);
				currentArmor.setNumber(currentArmor.getNumber() - 1);
				Armor lastArmor = campsiteController.getArmorOfTag(campsitePanel.samuraiPanel.lastArmor + 900);
				lastArmor.setNumber(lastArmor.getNumber() + 1);
			}
			
			campsitePanel.samuraiPanel.setItemBtnUnabled();
			updateWeaponArmor();
			updateSamurai(campsitePanel.samuraiPanel.samuraiNum);
			Musics.playEffectMusic(1);
		}
	};

	public EventHandler<MouseEvent> setItemEnterEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			campsitePanel.samuraiPanel.setItemBtnPressed();
		}
	};

	public EventHandler<MouseEvent> setItemExitEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			campsitePanel.samuraiPanel.setItemBtnAbled();
		}
	};

	public CampsiteController getCampsiteController() {
		return this.campsiteController;
	}
}
