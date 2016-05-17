package view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import view.eventhandler.TerToMenuSelectHandler;

public class TerToMenuSelectPanel extends SelectPanel{
	public TerToMenuSelectPanel(TerToMenuSelectHandler terToMenuSelectHandler){
		super("确定已存档并退出游戏吗？");
		this.setPrefSize(350, 230);
		
		this.yesBtn.setOnMouseClicked(terToMenuSelectHandler.yesEvent);
		this.noBtn.setOnMouseClicked(terToMenuSelectHandler.noEvent);
		this.close();
	}
	
	public void close(){
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerToMenuSelectPanel.this.setVisible(false);
//				OperationQueue.addOperation(new ContinueOperation());
			}
		});
	}


	

}
