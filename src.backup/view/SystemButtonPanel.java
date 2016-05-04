package view;

import controller.msgqueue.EndOperation;
import controller.msgqueue.OperationQueue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.GameModel;

public class SystemButtonPanel extends OrderPanel{

	private Button exitBtn;
	private Button backBtn;
	
	public SystemButtonPanel(){
		this.setPrefWidth(1200);
		
		this.exitBtn = new Button("Exit");
		exitBtn.setLayoutX(100);
		exitBtn.setLayoutY(50);
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
			@Override
			public void handle(ActionEvent e) {
				OperationQueue.addOperation(new EndOperation());

//				System.exit(0);
			}
		});
		this.getChildren().add(exitBtn);
		
		this.backBtn = new Button("Back");
		backBtn.setLayoutX(50);
		backBtn.setLayoutY(50);
		backBtn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
			@Override
			public void handle(ActionEvent e) {
				//TODO
				//从栈中出栈
			}
		});
		this.getChildren().add(backBtn);
	}
}
