package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import view.smithy.SmithyBuilder;
import view.smithy.SmithyItemView;
import view.smithy.SmithyPanel;

public class SmithyHandler {
	
	private SmithyPanel smithyPanel;
	
	public SmithyHandler(SmithyPanel smithyPanel){
		this.smithyPanel = smithyPanel;
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
}
