package view;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ArchiveView extends Pane{
	private int width = 400;
	private int height = 180;
	
	private Rectangle bgRect;
	
	private Label nameLabel;
	private Label timeLabel;
	
	private Button loadBtn;
	private Button saveBtn;
	private SystemButton closeBtn;
	
	public ArchiveView(int num){
		this.setWidth(width);
		this.setHeight(height);
		
		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setWidth(width); 
		bgRect.setHeight(height); 
		bgRect.setArcWidth(50);
		bgRect.setArcHeight(50);
		bgRect.setFill(Color.WHITE);
		this.getChildren().add(bgRect);
		
		nameLabel = new Label("存档"+num); 
		nameLabel.setLayoutX(25);
		nameLabel.setLayoutY(25);
		nameLabel.setId("Aname-label");
		this.getChildren().add(nameLabel);
		
		timeLabel = new Label("存储时间"); 
		timeLabel.setLayoutX(25);
		timeLabel.setLayoutY(60);
		timeLabel.setId("Atime-label");
		this.getChildren().add(timeLabel);
		
		loadBtn = new Button("读 取");
		loadBtn.setPrefSize(100, 40);
		loadBtn.setId("Aload-btn");		
		loadBtn.setLayoutX(25);
		loadBtn.setLayoutY(115);
		this.getChildren().add(loadBtn);
		
		saveBtn = new Button("保 存");
		saveBtn.setPrefSize(100, 40);
		saveBtn.setId("Asave-btn");		
		saveBtn.setLayoutX(275);
		saveBtn.setLayoutY(115);
		this.getChildren().add(saveBtn);
		
		closeBtn = new SystemButton(0);
	    closeBtn.setLayoutX(375);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				ArchivePanel parent = (ArchivePanel) ArchiveView.this.getParent();
				parent.getChildren().remove(ArchiveView.this);

			}
		});
		
		this.getChildren().add(closeBtn);
		
		this.setVisible(true);
				
	}
	

}
