package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.campsite.CampsiteItemView;
import view.campsite.CampsitePanel;
import view.campsite.CampsiteSamuraiWrapper.SamuraiButton;

public class CampsiteHandler {
	
	private CampsitePanel campsitePanel;
	
	public CampsiteHandler(CampsitePanel campsitePanel){
		this.campsitePanel = campsitePanel;
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
}
