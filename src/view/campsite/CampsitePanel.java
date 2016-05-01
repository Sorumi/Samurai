package view.campsite;

import javafx.scene.layout.Pane;
import view.eventhandler.CampsiteHandler;

public class CampsitePanel extends Pane{

	private CampsiteHandler campsiteHandler;
	
	private CampsiteItemsWrapper itemsPanel;
	private CampsiteItemInfo infoPanel;
	public CampsiteSamuraiWrapper samuraiPanel;
	
	public CampsitePanel(){
		this.setPrefSize(1200, 800);
		campsiteHandler = new CampsiteHandler(this);
		
		itemsPanel = new CampsiteItemsWrapper(campsiteHandler);		
		infoPanel = new CampsiteItemInfo();
		samuraiPanel = new CampsiteSamuraiWrapper(campsiteHandler);

		this.getChildren().addAll(itemsPanel, infoPanel, samuraiPanel);
	}
}
