package controller.msgqueue;

import javafx.scene.layout.Pane;
import model.GameModel;
import view.GamePanel;
import view.MenuPanel;

/**
 * Created by Kray on 16/4/22.
 */
public class EndOperation extends Operation {
    public void execute() {
        GameModel model = OperationQueue.getGameModel();
        System.out.println("Lvl " + model.getLevel());
        if(model.getLevel() == 0){
            System.out.println("Close window");
        }
        model.gameOver();
    }
}
