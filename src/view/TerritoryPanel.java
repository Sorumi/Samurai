package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.campsite.CampsiteItemView;
import view.campsite.CampsitePanel;
import view.eventhandler.TerritoryHandler;
import view.smithy.SmithyPanel;

public class TerritoryPanel extends Pane {

	//storeBtn: 仓库
	//smithyBtn: 铁匠铺
	//campsiteBtn: 营地
	//
	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	 
	private TerritoryHandler territoryHandler;
	public SystemCloseButton systemCloseBtn;

	
	private Button campsiteBtn;
	private Button smithyBtn;
	
	public CampsitePanel campsitePanel;
	public SmithyPanel smithyPanel;
	
	public TerritoryPanel(){
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setStyle("-fx-background-color: #eeeeee");
		
		territoryHandler = new TerritoryHandler(this);
		
		systemCloseBtn = new SystemCloseButton();
		systemCloseBtn.setLayoutX(1125);
		systemCloseBtn.setLayoutY(25);
		systemCloseBtn.setVisible(false);
		systemCloseBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel.this.getChildren().removeAll(campsitePanel, smithyPanel);
				campsitePanel = null;
				smithyPanel = null;
				systemCloseBtn.setVisible(false);
			}
		});

		campsiteBtn = new Button("营地：用来查看武器，换装备");
		campsiteBtn.setLayoutX(300);
		campsiteBtn.setLayoutY(300);
		campsiteBtn.setOnMouseClicked(territoryHandler.campsiteEvent);
		
		smithyBtn = new Button("铁匠铺：用来制造武器和护甲");
		smithyBtn.setLayoutX(300);
		smithyBtn.setLayoutY(400);
		smithyBtn.setOnMouseClicked(territoryHandler.smithyEvent);
		
		this.getChildren().addAll(campsiteBtn, smithyBtn, systemCloseBtn);

	}
	
}
