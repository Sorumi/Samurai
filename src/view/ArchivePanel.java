package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class ArchivePanel extends Pane{
	private int width = 500;
	private int height = 700;
	
	private Rectangle bgRect;
	
	private SystemButton closeBtn;
	
	private ArchiveView arcVone;
	private ArchiveView arcVtwo;
	private ArchiveView arcVthree;
	

	
	public ArchivePanel(){
		this.setWidth(width);
		this.setHeight(height);
		
		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setWidth(width); 
		bgRect.setHeight(height); 
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.AZURE); 
		this.getChildren().add(bgRect);
		
	    closeBtn = new SystemButton(0);
	    closeBtn.setLayoutX(475);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel parent = (TerritoryPanel) ArchivePanel.this.getParent();
				parent.getChildren().remove(ArchivePanel.this);
				parent.setBlur(false);
//				parent.routeGroup.setVisible(true);
			}
		});
		this.getChildren().add(closeBtn);
		
		arcVone = new ArchiveView(1);
		arcVone.setLayoutX(50);
		arcVone.setLayoutY(50);
		arcVtwo = new ArchiveView(2);
		arcVtwo.setLayoutX(50);
		arcVtwo.setLayoutY(260);
		arcVthree = new ArchiveView(3);
		arcVthree.setLayoutX(50);
		arcVthree.setLayoutY(470);
		this.getChildren().addAll(arcVone, arcVtwo, arcVthree);
	}
	

}
