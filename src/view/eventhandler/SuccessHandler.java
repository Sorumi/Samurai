package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import musics.Musics;
import view.SuccessPanel;

public class SuccessHandler {
	private SuccessPanel successPanel;
	
	public SuccessHandler(SuccessPanel successPanel){
		this.successPanel = successPanel;
	}
	
	public EventHandler<MouseEvent> yesBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  successPanel.btnPressed(); 
	      }
	};
	
	public EventHandler<MouseEvent> yesBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  successPanel.btnAbled();
	      }
	};
	
	public EventHandler<MouseEvent> yesBtnClickedEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  successPanel.setVisible(false); 
	    	  Musics.playEffectMusic(1);
	      }
	};

}
