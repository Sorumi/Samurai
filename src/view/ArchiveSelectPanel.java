package view;

import view.eventhandler.ArchiveSelectHandler;

public class ArchiveSelectPanel extends SelectPanel{
	public boolean isSave; 
	private ArchiveSelectHandler archiveSelectHandler;
	
	public ArchiveSelectPanel(ArchiveSelectHandler archiveSelectHandler){
		super(archiveSelectHandler,"");
		this.archiveSelectHandler = archiveSelectHandler;
		
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
