package view.eventhandler;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
	      }
	};

}
