package view.story;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import view.GameColor;
import view.eventhandler.ArchiveHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchiveView extends Pane {
	private int width = 400;
	private int height = 180;

	public ArchiveHandler archiveHandler;

	// public ArchiveSelectPanel archiveSelectPanel;
	// private ArchiveSelectHandler archiveSelectHandler;

	public int num;
	public int type;
	private Label nameLabel;
	private Label timeLabel;

	public Button loadBtn;
	public Button saveBtn;

	/*
	 * type: 0: in Story 1: in Menu
	 */

	public ArchiveView(int num, int type) {
		this.num = num;
		this.type = type;
		this.archiveHandler = new ArchiveHandler(this, num);

		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setId("archive-view");

		nameLabel = new Label("存档" + (num + 1));

		nameLabel.setLayoutX(25);
		nameLabel.setLayoutY(25);
		nameLabel.setId("Aname-label");
		this.getChildren().add(nameLabel);

		timeLabel = new Label("存档时间");
		timeLabel.setLayoutX(25);
		timeLabel.setLayoutY(60);
		timeLabel.setId("Atime-label");
		this.getChildren().add(timeLabel);

		if (type == 1) {
			loadBtn = new Button("读 取");
			loadBtn.setPrefSize(100, 40);
			loadBtn.setId("Aload-btn");
			loadBtn.setLayoutX(25);
			loadBtn.setLayoutY(115);
			loadBtn.setOnMouseEntered(archiveHandler.loadBtnEnterEvent);
			loadBtn.setOnMouseExited(archiveHandler.loadBtnExitEvent);
			loadBtn.setOnMouseClicked(archiveHandler.loadBtnClickEvent);
			this.getChildren().add(loadBtn);
			
		}

		if (type == 0) {
			saveBtn = new Button("保 存");
			saveBtn.setPrefSize(100, 40);
			saveBtn.setId("Asave-btn");
			saveBtn.setLayoutX(275);
			saveBtn.setLayoutY(115);
			saveBtn.setOnMouseEntered(archiveHandler.saveBtnEnterEvent);
			saveBtn.setOnMouseExited(archiveHandler.saveBtnExitEvent);
			saveBtn.setOnMouseClicked(archiveHandler.saveBtnClickEvent);
			this.getChildren().add(saveBtn);
			this.btnAbled(1);
		}

		this.setVisible(true);

		Date time;
		if (((time = archiveHandler.getArchiveController().getTime(num)) != null)) {
			SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			setTime(ft.format(time));
			if(type == 1){
				this.btnAbled(0);
			}
		} else {
			if(type == 1){
				this.btnUnabled(0);
				loadBtn.setOnMouseEntered(null);
				loadBtn.setOnMouseExited(null);
				loadBtn.setOnMouseClicked(null);
			}
		}

	}

	public void btnPressed(int num) {
		if (num == 0) {
			loadBtn.setLayoutY(119);
			loadBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		} else {
			saveBtn.setLayoutY(119);
			saveBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if (num == 0) {
			loadBtn.setLayoutY(115);
			loadBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		} else {
			saveBtn.setLayoutY(115);
			saveBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}

	public void btnUnabled(int num) {
		if (num == 0) {
			loadBtn.setLayoutY(119);
			loadBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(-1) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(-2) + ", 0, 0, 0, 4);"
					+ "-fx-text-fill: #ffffff;");
		} else {
			loadBtn.setLayoutY(119);
			loadBtn.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(-1) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getWeaponColorString(-2) + ", 0, 0, 0, 4);"
					+ "-fx-text-fill: #ffffff;");
		}

	}

	public void setTime(String time) {
		timeLabel.setText("存档时间： " + time);
	}

}