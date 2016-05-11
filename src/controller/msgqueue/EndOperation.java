package controller.msgqueue;

import javafx.scene.layout.Pane;
import model.GameModel;
import view.GamePanel;

/**
 * Created by Kray on 16/4/22.
 */
public class EndOperation extends Operation {
    public void execute() {
        GameModel model = OperationQueue.getGameModel();
        model.gameOver();
        if(model.getLevel() == 99 || model.getLevel() == 0){
//            Pane basePanel = (Pane) OperationQueue.getGamePanel().getParent();
//            basePanel.getChildren().remove(OperationQueue.getGamePanel());
        }
    }
}
