package controller.msgqueue;

import model.GameModel;

/**
 * Created by Kray on 16/5/6.
 */
public class PseudoOccupyOperation extends Operation{

    private boolean HL;
    private int direction;

    public PseudoOccupyOperation(boolean HL, int direction) {
        this.HL = HL;
        this.direction = direction;
    }

    public void execute(){
        GameModel model = OperationQueue.getGameModel();
        model.updatePseudo0ccupy(HL,direction);
    }

}
