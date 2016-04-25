package view.campsite;

import javafx.scene.layout.Pane;

public class CampsitePanel extends Pane{

	private CampsiteItemsWrapper itemsPanel;
	
	public CampsitePanel(){
		this.setLayoutX(50);
		this.setLayoutY(50);
		
		itemsPanel = new CampsiteItemsWrapper();
		this.getChildren().add(itemsPanel);
	}
}
