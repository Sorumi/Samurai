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
		smithyPanel.spearPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.swordPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.battleaxPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.shurikenPanel.updateItem(smithyController.getUnlockedWeapons());
		smithyPanel.bowPanel.updateItem(smithyController.getUnlockedWeapons());
	}
	
	public void updateBuilder(int itemNum){
		Weapon weapon = smithyController.getWeaponOfTag(itemNum);
		int[] materialNum = new int[weapon.getMaterialQuantity()];
		String[] materialName = new String[weapon.getMaterialQuantity()];
		int[] currentQuantity = new int[weapon.getMaterialQuantity()];

		for (int i=0; i<weapon.getMaterialQuantity(); i++){
			materialNum[i] = weapon.getMaterialTag()[i] * 10 + weapon.getMaterialItem()[i];
			materialName[i] = smithyController.getInformationOfTag(materialNum[i]+800).getName();
			currentQuantity[i] = smithyController.getNumOfMaterialOfTag(materialNum[i]+800);
		}
		
		smithyPanel.buildPanel.setMaterial(weapon.getMaterialQuantity(), materialNum, materialName, currentQuantity, weapon.getMaterialNumber());
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
	    	  
	    	  //武器需要的材料
	    	  updateBuilder(item.getItemNum());
	      }
	};
	
	//显示状态界面
	public EventHandler<MouseEvent> showStatePanel = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Group weaponGroup = (Group) event.getSource();
	    	  SmithyItemView item = (SmithyItemView) weaponGroup.getParent();
	    	  smithyPanel.smithyWeaponState.setCurrentItem(item);
	    	  smithyPanel.smithyWeaponState.setAppear(true);

			  Weapon weapon = smithyController.getWeaponOfTag(item.getItemNum());
			  Information information = smithyController.getInformationOfTag(item.getItemNum());

			  smithyPanel.smithyWeaponState.setWeaponInfo(weapon.getType(), weapon.getNumber(), information.getName(), weapon.getLowAttackPoint(), weapon.getHighAttackPoint(), weapon.getCriticalRate(), weapon.getArmorPenetration());
		  }
	};
	
	public EventHandler<MouseEvent> closeStatePanel = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  Group weaponGroup = (Group) event.getSource();
	    	  SmithyItemView item = (SmithyItemView) weaponGroup.getParent();
//	    	  smithyPanel.smithyWeaponState.setCurrentItem(item);
	    	  smithyPanel.smithyWeaponState.setAppear(false); 	    	  
	      }
	};

	//合成按钮
	public EventHandler<MouseEvent> buildBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  smithyPanel.buildPanel.build();
			  smithyController.createWeapon(smithyPanel.buildPanel.getItemNum());
			  update();
			  updateBuilder(smithyPanel.buildPanel.getItemNum());
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
