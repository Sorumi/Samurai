package view.store;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import view.SystemButton;
import view.TerritoryPanel;
import view.TransitionPanel;
import view.eventhandler.StoreHandler;

public class StorePanel extends TransitionPanel{
	private StoreHandler storeHandler;
	
	private StoreItemsWrapper itemsPanel;
	public StoreItemInfo infoPanel;
	
	private SystemButton closeBtn;
	public  StorePanel(){
		super();
		
		this.setPrefSize(1200, 800);
		storeHandler = new StoreHandler(this); 
		
		itemsPanel = new StoreItemsWrapper(storeHandler);
		infoPanel = new StoreItemInfo();
		
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override 
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				transitionAnimation(false);
				TerritoryPanel parent =  (TerritoryPanel) StorePanel.this.getParent();
				parent.getChildren().remove(StorePanel.this);
				parent.setBlur(false);
			}
		});

		this.getChildren().addAll(itemsPanel, infoPanel, closeBtn); 
		
		storeHandler.update();
		this.transitionAnimation(true);
	}

	public StoreItemsWrapper getItemsPanel(){
		return this.itemsPanel;
	}

}
