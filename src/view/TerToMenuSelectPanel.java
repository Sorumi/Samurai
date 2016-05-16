package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import view.eventhandler.TerToMenuSelectHandler;

public class TerToMenuSelectPanel extends SelectPanel{
	public TerToMenuSelectPanel(TerToMenuSelectHandler terToMenuSelectHandler){
		super(terToMenuSelectHandler, "确定已存档并退出游戏吗？");
		this.setPrefSize(350, 230);
		
		this.yesBtn.setOnMouseClicked(terToMenuSelectHandler.yesEvent);
		this.noBtn.setOnMouseClicked(terToMenuSelectHandler.noEvent);
	}


	

}
