package view.campsite;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import model.StoryModel;
import view.CustomizePanel;
import view.StoryPanel;
import view.SystemButton;
import view.TerritoryPanel;
import view.TransitionPanel;
import view.eventhandler.CampsiteHandler;
import view.eventhandler.CustomizeCampsiteHandler;

public class CampsitePanel extends TransitionPanel{

	private CampsiteHandler campsiteHandler;
	
	private CampsiteItemsWrapper itemsPanel;
	public CampsiteItemInfo infoPanel;
	public CampsiteSamuraiWrapper samuraiPanel;
	
	private SystemButton closeBtn;
	
	public boolean isCustomized;
	
	public CampsitePanel(){
		super();
		
		this.setPrefSize(1200, 800);
		campsiteHandler = new CampsiteHandler(this);
		
		itemsPanel = new CampsiteItemsWrapper(campsiteHandler);		
		infoPanel = new CampsiteItemInfo();
		samuraiPanel = new CampsiteSamuraiWrapper(campsiteHandler);

		//closeBtn
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel parent =  (TerritoryPanel) CampsitePanel.this.getParent();
				parent.getChildren().remove(CampsitePanel.this);
				parent.setBlur(false);
				parent.getTerritoryHandler().updateSamurai();
				parent.campsitePanel = null;
			}
		});

		this.getChildren().addAll(itemsPanel, infoPanel, samuraiPanel, closeBtn);
		
		campsiteHandler.updateWeaponArmor();
		campsiteHandler.updateSamurai(1);
		this.transitionAnimation(true);
		
		isCustomized = false;
	}

	public CampsiteHandler getCampsiteHandler() {
		return campsiteHandler;
	}
	
	public CampsiteItemsWrapper getItemsPanel(){
		return this.itemsPanel;
	}
	
	
	public void setCustomized(CustomizePanel customizePanel){
		isCustomized = true;
		CustomizeCampsiteHandler customizeCampsiteHandler = new CustomizeCampsiteHandler(this, customizePanel);
		samuraiPanel.setCustomized(customizeCampsiteHandler);
		
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				CustomizePanel parent =  (CustomizePanel) CampsitePanel.this.getParent();
				parent.getChildren().remove(CampsitePanel.this);
				parent.setBlur(false);
				parent.campsitePanel = null;
			}
		});
		
		customizeCampsiteHandler.updateSamurai(1);
	}
}
