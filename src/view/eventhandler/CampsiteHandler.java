package view.eventhandler;

import controller.CampsiteController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Armor;
import model.po.Information;
import model.po.Weapon;
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

	public void update() {
		campsitePanel.getItemsPanel().updateWeapon(campsiteController.getWeapons());
		campsitePanel.getItemsPanel().updateArmor(campsiteController.getArmors());

		campsitePanel.samuraiPanel.setSamurai(1);
		campsitePanel.samuraiPanel.setWeapon(campsiteController.getWeaponOfSamurai(1).getType());
		campsitePanel.samuraiPanel.setArmor(campsiteController.getArmorOfSamurai(1).getType() - 900);
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
			if (item.getNum() / 100 != 9) {
				campsitePanel.samuraiPanel.setWeapon(item.getNum());

				Information information = campsiteController.getInformationOfTag(item.getNum());
				Weapon weapon = campsiteController.getWeaponOfTag(item.getNum());

				campsitePanel.infoPanel.setWeaponInfo(information.getTag(), information.getName(),
						information.getDescription(), weapon.getLowAttackPoint(), weapon.getHighAttackPoint(),
						weapon.getCriticalRate(), weapon.getArmorPenetration());

			} else {
				campsitePanel.samuraiPanel.setArmor(item.getNum() - 900);

				Information information = campsiteController.getInformationOfTag(item.getNum());
				Armor armor = campsiteController.getArmorOfTag(item.getNum());

				campsitePanel.infoPanel.setArmorInfo(information.getTag(), information.getName(),
						information.getDescription(), armor.getArmorValue(), armor.getDodgeRate());
			}
		}
	};

	public EventHandler<MouseEvent> samuraiClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			SamuraiButton samurai = (SamuraiButton) event.getSource();
			// 换装备 显示名字描述属性
			campsitePanel.samuraiPanel.setSamurai(samurai.num);
			campsitePanel.samuraiPanel.samurai.setWeapon(campsiteController.getWeaponOfSamurai(samurai.num).getType());
		}
	};

	// 设置武器按钮
	public EventHandler<MouseEvent> setItemClickEvent = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event) {
			// 用 controller 换武器
			campsiteController.changeWeapon(campsitePanel.samuraiPanel.getSamuraiNum(),
					campsitePanel.samuraiPanel.currentWeapon);

			if (campsitePanel.samuraiPanel.isArmor) {
				campsiteController.changeArmor(campsitePanel.samuraiPanel.getSamuraiNum(),
						campsitePanel.samuraiPanel.currentArmor+900);
			}
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
