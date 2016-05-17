package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.eventhandler.ArchiveSelectHandler;
import view.eventhandler.TerritoryHandler;

public class ArchivePanel extends Pane {
	private int width = 500;
	private int height = 700;

	private int type;

	private SystemButton closeBtn;

	private ArchiveView arcV0;
	private ArchiveView arcV1;
	private ArchiveView arcV2;
	public Group archiveGroup;

	public ArchiveSelectPanel archiveSelectPanel;

	/*
	 * num: 0: in territoryPanel 1: in menuPanel
	 */
	public ArchivePanel(int type) {
		this.type = type;

		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setId("archive-panel");

		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(475);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (type == 0) {
					TerritoryPanel parent = (TerritoryPanel) ArchivePanel.this.getParent();
					parent.getChildren().remove(ArchivePanel.this);
					parent.setBlur(false);
				} else {
					MenuPanel parent = (MenuPanel) ArchivePanel.this.getParent();
					parent.getChildren().remove(ArchivePanel.this);
				}

			}
		});
		this.getChildren().add(closeBtn);

		arcV0 = new ArchiveView(0, type);
		arcV0.setLayoutX(50);
		arcV0.setLayoutY(50);
		arcV1 = new ArchiveView(1, type);
		arcV1.setLayoutX(50);
		arcV1.setLayoutY(260);
		arcV2 = new ArchiveView(2, type);
		arcV2.setLayoutX(50);
		arcV2.setLayoutY(470);
		
		archiveGroup = new Group();
		
		archiveGroup.getChildren().addAll(arcV0, arcV1, arcV2);
		
		archiveSelectPanel = new ArchiveSelectPanel(this);
		archiveSelectPanel.setLayoutX(75);
		archiveSelectPanel.setLayoutY(250);
		
		this.getChildren().addAll(archiveGroup, archiveSelectPanel);
		archiveSelectPanel.setVisible(false);
	}

}
