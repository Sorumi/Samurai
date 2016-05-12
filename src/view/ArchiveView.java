package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.StoryModel;
import view.eventhandler.ArchiveHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchiveView extends Pane{
	private int width = 400;
	private int height = 180;
	
	private ArchiveHandler archiveHandler;
	
	private int num;
	private Label nameLabel;
	private Label timeLabel;
	
	public Button loadBtn;
	public Button saveBtn;
	
	public ArchiveView(int num){
		this.num = num;
		this.archiveHandler = new ArchiveHandler(this, num);
		
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setId("archive-view");

		nameLabel = new Label("存档"+(num+1));

		nameLabel.setLayoutX(25);
		nameLabel.setLayoutY(25);
		nameLabel.setId("Aname-label");
		this.getChildren().add(nameLabel);
		
		timeLabel = new Label("存档时间");
		timeLabel.setLayoutX(25);
		timeLabel.setLayoutY(60);
		timeLabel.setId("Atime-label");
		this.getChildren().add(timeLabel);
		
		loadBtn = new Button("读 取");
		loadBtn.setPrefSize(100, 40);
		loadBtn.setId("Aload-btn");		
		loadBtn.setLayoutX(25);
		loadBtn.setLayoutY(115);
		loadBtn.setOnMouseEntered(archiveHandler.loadBtnEnterEvent);
		loadBtn.setOnMouseExited(archiveHandler.loadBtnExitEvent);
		loadBtn.setOnMouseClicked(archiveHandler.loadBtnClickEvent);
		this.getChildren().add(loadBtn);
		
		saveBtn = new Button("保 存");
		saveBtn.setPrefSize(100, 40);
		saveBtn.setId("Asave-btn");		
		saveBtn.setLayoutX(275);
		saveBtn.setLayoutY(115);
		saveBtn.setOnMouseEntered(archiveHandler.saveBtnEnterEvent);
		saveBtn.setOnMouseExited(archiveHandler.saveBtnExitEvent);
		saveBtn.setOnMouseClicked(archiveHandler.saveBtnClickEvent);
		this.getChildren().add(saveBtn);
		
		this.btnAbled(0);
		this.btnAbled(1);
		
		this.setVisible(true);

		Date time;
		if(((time = archiveHandler.getArchiveController().getTime(num)) != null)){
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss");
			setTime(ft.format(time));
		}

	}

	public void btnPressed(int num) {
		if(num == 0){
			loadBtn.setLayoutY(119);
			loadBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		}else{
			saveBtn.setLayoutY(119);
			saveBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if(num == 0){
			loadBtn.setLayoutY(115);
			loadBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		}else{
			saveBtn.setLayoutY(115);
			saveBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}

	public void setTime(String time){
		timeLabel.setText("存档时间： " + time);
	}

}
