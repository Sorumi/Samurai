package view.eventhandler;


import controller.GuideController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import view.DirectionButton;
import view.guide.ActionGuideButton;
import view.guide.GameGuidePanel;
import view.guide.GameGuidePanel.WeaponButton;
import view.guide.SamuraiGuidePanel;

public class ActionGuideHandler {

	private GameGuidePanel gameGuidePanel;
	private int action;
	private int direction;
	
	public ActionGuideHandler(GameGuidePanel gameGuidePanel){
		this.gameGuidePanel = gameGuidePanel;
	}
	
	public EventHandler<MouseEvent> samuraiEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  SamuraiGuidePanel currentSamurai = (SamuraiGuidePanel) event.getSource();
	    	  if(currentSamurai.canActionProperty().get()){
	    		  gameGuidePanel.actionPanel.setAppear(true, true);
	    	  }
	      }
	};
	
	public EventHandler<MouseEvent> actionPanelDisappearEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  if (event.getButton() == MouseButton.SECONDARY) {
	    		  gameGuidePanel.actionPanel.setAppear(false, true);
	    	  }  
	      }
	};

	public EventHandler<MouseEvent> secondaryEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionGuideButton btn = (ActionGuideButton)event.getSource();
	    	  action = btn.action;
	    	  //分move occupy两种情况
	    	  gameGuidePanel.actionPanel.setSecondary(new boolean[]{true, true, true, true});//TODO
	      }
	};
	
	public EventHandler<MouseEvent> hideEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionGuideButton btn = (ActionGuideButton)event.getSource();
	    	  action = btn.action;
			  GuideController.sendMsg(action, direction);
	      }
	};
	
	public EventHandler<MouseEvent> backEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  ActionGuideButton btn = (ActionGuideButton)event.getSource();
	    	  action = btn.action;
	    	  gameGuidePanel.actionPanel.closeSecondary();
	      }
	};
	
	public EventHandler<MouseEvent> directionEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  direction = btn.direction;
			  GuideController.sendMsg(action, direction);
	      }
	};
	
	public EventHandler<MouseEvent> directionEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  btn.setHighLight(true);

			  if(action == 0) {
				  direction = btn.direction;
				  GuideController.pseudoOccupy(true,direction);
			  }

	      }
	};

	public EventHandler<MouseEvent> directionExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  DirectionButton btn = (DirectionButton)event.getSource();
	    	  btn.setHighLight(false);

			  if(action == 0) {
				  direction = btn.direction;
				  GuideController.pseudoOccupy(false,direction);
			  }

	      }
	};
	
	public EventHandler<MouseEvent> weaponEvent = new EventHandler<MouseEvent>() { 
		public void handle(MouseEvent event) {
			WeaponButton btn = (WeaponButton) event.getSource();
			System.out.println(btn.num);
		}
	};

}
