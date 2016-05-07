package view.eventhandler;

import controller.SmithyController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import model.po.Information;
import model.po.Weapon;
import view.SamuraiPanel;
import view.smithy.SmithyBuilder;
import view.smithy.SmithyItemView;
import view.smithy.SmithyPanel;

public class SmithyHandler {
	
	private SmithyPanel smithyPanel;
	private SmithyController smithyController;
	
	public SmithyHandler(SmithyPanel smithyPanel){
		this.smithyPanel = smithyPanel;
		this.smithyController = new SmithyController();
		this.smithyController.setStoryModel(StoryModel.getStoryModel());
	}
	
	public void update(){
		for(Weapon weapon:smithyController.getUnlockedWeapons()){
			System.out.print(weapon.getType()  + " ");
		}
		smithyPanel.spearPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.swordPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.battleaxPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.shurikenPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.bowPanel.updateItem(smithyController.getUnlockedWeapons());
	}

	public EventHandler<MouseEvent> wrapperToFrontEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Button button = (Button) event.getSource();
	    	  button.getParent().toFront();
	    	  smithyPanel.closeBtn.toFront();
	      }
	};
	
	public EventHandler<MouseEvent> itemClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Group weaponGroup = (Group) event.getSource();
	    	  SmithyItemView item = (SmithyItemView) weaponGroup.getParent();
	    	  smithyPanel.routeGroup.setVisible(false);
	    	  smithyPanel.buildPanel = new SmithyBuilder(item.getItemNum(), SmithyHandler.this);
	    	  smithyPanel.getChildren().add(smithyPanel.buildPanel);
	    	  
	      }
	};
	
	//显示状态界面
	public EventHandler<MouseEvent> showStatePanel = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Group weaponGroup = (Group) event.getSource();
	    	  SmithyItemView item = (SmithyItemView) weaponGroup.getParent();
	    	  smithyPanel.smithyWeaponState.setCurrentItem(item);
	    	  smithyPanel.smithyWeaponState.setAppear(true);

//			  Weapon weapon = smithyController.getWeaponOfTag(item.getItemNum());
//			  Information information = smithyController.getInformationOfTag(item.getItemNum());


		  }
	};
	
	public EventHandler<MouseEvent> closeStatePanel = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Group weaponGroup = (Group) event.getSource();
	    	  SmithyItemView item = (SmithyItemView) weaponGroup.getParent();
	    	  smithyPanel.smithyWeaponState.setCurrentItem(item);
	    	  smithyPanel.smithyWeaponState.setAppear(false); 	    	  
	      }
	};

	//合成按钮
	public EventHandler<MouseEvent> buildBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  //合成武器！
	    	  //TODO
	    	  smithyPanel.buildPanel.build();
			  smithyController.createWeapon(smithyPanel.buildPanel.getItemNum());
			  update();
	      }
	};
	
	public EventHandler<MouseEvent> buildBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  smithyPanel.buildPanel.buildBtnPressed();
	      }
	};
	
	public EventHandler<MouseEvent> buildBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  smithyPanel.buildPanel.buildBtnAbled();
	      }
	};

	public SmithyController getSmithyController(){
		return this.smithyController;
	}

	//缺少smithy 调用smithyContoller 的 createWeapon
}
