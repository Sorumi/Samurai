package controller.msgqueue;

import javafx.scene.layout.Pane;
import model.GameModel;
import view.GamePanel;
import view.MenuPanel;

/**
 * Created by Kray on 16/4/22.
 */
public class EndOperation extends Operation {

    private boolean isRealEnd;

    public EndOperation(boolean isRealEnd){
        this.isRealEnd = isRealEnd;
    }

    public void execute() {
        GameModel model = OperationQueue.getGameModel();
        if(model.getLevel() == 0){
            System.out.println("Close window");
        }
        if(isRealEnd) {
            model.gameOver();
        }else{
            model.exit();
        }
    }
}
