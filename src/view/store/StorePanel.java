package view.store;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import view.SystemButton;
import view.TerritoryPanel;
import view.campsite.CampsiteItemInfo;
import view.campsite.CampsitePanel;
import view.eventhandler.StoreHandler;

public class StorePanel extends Pane{
	private StoreHandler storeHandler;
	
	private StoreItemsWrapper itemsPanel;
	private StoreItemInfo infoPanel;
	
	private SystemButton closeBtn;
	public  StorePanel(){
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
				TerritoryPanel parent =  (TerritoryPanel) StorePanel.this.getParent();
				parent.getChildren().remove(StorePanel.this);
			}
		});

		this.getChildren().addAll(itemsPanel, infoPanel, closeBtn); 
		
		
	}

}
