package view.eventhandler;

import controller.SmithyController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
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

	//合成按钮
	public EventHandler<MouseEvent> buildBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  //合成武器！
	    	  //TODO
	    	  smithyPanel.buildPanel.build();
			  smithyController.createWeapon(smithyPanel.buildPanel.getItemNum());
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
