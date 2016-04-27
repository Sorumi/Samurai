package view.campsite;

import javafx.scene.layout.Pane;
import view.eventhandler.CampsiteHandler;

public class CampsitePanel extends Pane{

	private CampsiteHandler campsiteHandler;
	
	private CampsiteItemsWrapper itemsPanel;
	private CampsiteItemInfo infoPanel;
	
	
	public CampsitePanel(){
		this.setLayoutX(50);
		this.setLayoutY(50);
		campsiteHandler = new CampsiteHandler();
		
		itemsPanel = new CampsiteItemsWrapper(campsiteHandler);
		this.getChildren().add(itemsPanel);
		
		infoPanel = new CampsiteItemInfo();
		this.getChildren().add(infoPanel);
		
	}
}
