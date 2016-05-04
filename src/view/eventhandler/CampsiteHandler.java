package view.eventhandler;

import controller.CampsiteController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
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
	    	  //换装备 显示名字描述属性
	    	  campsitePanel.samuraiPanel.setWeapon(item.getNum());			 
	      }
	};
	
	public EventHandler<MouseEvent> samuraiClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiButton samurai = (SamuraiButton) event.getSource();
	    	  //换装备 显示名字描述属性
	    	  campsitePanel.samuraiPanel.setSamurai(samurai.num);
	      }
	};
	
	public EventHandler<MouseEvent> setItemClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
			  //用 controller 换武器
	    	  //点击确定才换武器~
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
	    	  campsitePanel.samuraiPanel.setItemBtnNormal();
	      }
	};

	public CampsiteController getCampsiteController(){
		return this.campsiteController;
	}
}
