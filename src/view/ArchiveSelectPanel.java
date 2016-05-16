package view;

import view.eventhandler.ArchiveSelectHandler;

public class ArchiveSelectPanel extends SelectPanel{
	
	public ArchiveSelectPanel(ArchiveSelectHandler archiveSelectHandler){
		super(archiveSelectHandler,"此操作可能会覆盖之前的存档，确定继续吗？");
		
		this.yesBtn.setOnMouseClicked(archiveSelectHandler.yesEvent);
		this.noBtn.setOnMouseClicked(archiveSelectHandler.noEvent);
		
	}

}
