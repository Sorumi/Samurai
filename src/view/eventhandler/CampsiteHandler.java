package view.eventhandler;

import controller.CampsiteController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Information;
import model.po.Weapon;
import view.campsite.CampsiteItemView;
import view.campsite.CampsitePanel;
import view.campsite.CampsiteSamuraiWrapper.SamuraiButton;

public class CampsiteHandler {
	
	private CampsitePanel campsitePanel;
	private CampsiteController campsiteController;
	
	public CampsiteHandler(CampsitePanel campsitePanel){
		this.campsitePanel = campsitePanel;
		this.campsiteController = new CampsiteController();
		this.campsiteController.setStoryModel(StoryModel.getStoryModel());

		this.campsiteController.setWeaponNum();
	}

	public void update(){
		campsitePanel.getItemsPanel().updateItem(campsiteController.getWeapons());
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
	    	  campsitePanel.samuraiPanel.setWeapon(item.getNum());

//	    	  System.out.println(item.getNum());
			  Information information = campsiteController.getInformationOfTag(item.getNum());
			  Weapon weapon = campsiteController.getWeaponOfTag(item.getNum());

			  campsitePanel.infoPanel.setWeaponInfo(information.getTag(), information.getName(), information.getDescription(), weapon.getLowAttackPoint(), weapon.getHighAttackPoint(), weapon.getCriticalRate(), weapon.getArmorPenetration());
		  }
	};
	
	public EventHandler<MouseEvent> samuraiClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiButton samurai = (SamuraiButton) event.getSource();
	    	  //换装备 显示名字描述属性
	    	  campsitePanel.samuraiPanel.setSamurai(samurai.num);
	      }
	};
	
	//设置武器按钮
	public EventHandler<MouseEvent> setItemClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
			  //用 controller 换武器
//	    	  campsitePanel.samuraiPanel.setItemBtnPressed();
	    	  campsiteController.changeWeapon(campsitePanel.samuraiPanel.getSamuraiNum(), campsitePanel.samuraiPanel.currentWeapon);
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

	public CampsiteController getCampsiteController(){
		return this.campsiteController;
	}
}
