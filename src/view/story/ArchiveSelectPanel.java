package view.story;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.SelectPanel;
import view.eventhandler.ArchiveSelectHandler;

public class ArchiveSelectPanel extends SelectPanel{
	
	public boolean isSave; 
	public ArchiveSelectHandler archiveSelectHandler;
	
	public ArchiveSelectPanel(ArchivePanel archivePanel){
		super("");
		archiveSelectHandler = new ArchiveSelectHandler(archivePanel);
		
		this.setPrefSize(350, 230);
		this.messageLabel.setId("select-message");
		this.close();
	}
	
	public void close(){
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ArchiveSelectPanel.this.setVisible(false);
			}
		});
	}
	public void updateIsSave(boolean b){
		this.isSave = b;
		if(isSave){
			archiveSelectHandler.isSave = true;
			this.updateMessage("此操作可能会覆盖之前的存档，确定继续吗？");
		}else{
			archiveSelectHandler.isSave = false;
			this.updateMessage("此操作可能会改变现在的游戏进度，确定继续吗？");
		}
		this.yesBtn.setOnMouseClicked(archiveSelectHandler.yesEvent);
		this.noBtn.setOnMouseClicked(archiveSelectHandler.noEvent);
	}

}
