package view.eventhandler;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.PropOperation;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.PropPanel;

public class PropHandler {

	private PropPanel propPanel;
	
	public PropHandler(PropPanel propPanel){
		this.propPanel = propPanel;
	}
	
	public EventHandler<MouseEvent> showPropPanel = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  propPanel.show();
	      }
	};
	
	public EventHandler<MouseEvent> hidePropPanel = new EventHandler<MouseEvent>() {   
	      public void handle(MouseEvent event) {
	    	  propPanel.hide();
	      }
	};

	public EventHandler<MouseEvent> itemClickEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			OperationQueue.addOperation(new PropOperation(14));
		}
	};

}
