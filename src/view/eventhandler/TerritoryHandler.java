package view.eventhandler;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import view.TerritoryPanel;
import view.TerritoryPanel.TerritoryButton;
import view.campsite.CampsitePanel;
import view.smithy.SmithyPanel;

public class TerritoryHandler {
	
	private TerritoryPanel territoryPanel;

//	DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.WHITE, 0, 1, 0, 0);
//	ColorAdjust light = new ColorAdjust();
	  
	public TerritoryHandler(TerritoryPanel territoryPanel){
		this.territoryPanel = territoryPanel;
	}
	
	public EventHandler<MouseEvent> campsiteEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.campsitePanel = new CampsitePanel();
	    	  territoryPanel.getChildren().add(territoryPanel.campsitePanel);
	      }
	};
	
	public EventHandler<MouseEvent> smithyEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  territoryPanel.smithyPanel = new SmithyPanel();
	    	  territoryPanel.getChildren().add(territoryPanel.smithyPanel);
	      }
	};
	
	public EventHandler<MouseEvent> flagEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  //TODO
	    	  //map
//	    	  territoryPanel.smithyPanel = new SmithyPanel();
//	    	  territoryPanel.getChildren().add(territoryPanel.smithyPanel);
	      }
	};
	
	public EventHandler<MouseEvent> buttonEnterEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryButton btn = (TerritoryButton) event.getSource();
	    	  btn.setHighlight();
	      }
	};
	
	public EventHandler<MouseEvent> buttonExitEvent= new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  TerritoryButton btn = (TerritoryButton) event.getSource();
	    	 btn.setNormal();
	      }
	};

}
