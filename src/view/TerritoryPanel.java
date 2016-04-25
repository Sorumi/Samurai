package view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.campsite.CampsiteItemView;
import view.campsite.CampsitePanel;
import view.eventhandler.TerritoryHandler;

public class TerritoryPanel extends Pane {

	//storeBtn: 仓库
	//smithyBtn: 铁匠铺
	//campsiteBtn: 营地
	//
	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	 
	private TerritoryHandler territoryHandler;
	private Button campsiteBtn;
	public CampsitePanel campsitePanel;
	
	public TerritoryPanel(){
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setStyle("-fx-background-color: #eeeeee");
		territoryHandler = new TerritoryHandler(this);
		campsiteBtn = new Button("营地：用来查看武器，换装备");
		campsiteBtn.setOnMouseClicked(territoryHandler.CampsiteEvent);
		this.getChildren().add(campsiteBtn);
	}
	
}
