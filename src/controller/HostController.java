package controller;

import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import model.GameModel;
import network.server.HostHandlerImpl;
import network.server.HostServiceImpl;
import view.BasePanel;

/**
 * Created by Kray on 16/4/17.
 */
public class HostController {
    public boolean serviceSetupHost(BasePanel basePanel) {

        HostServiceImpl host = new HostServiceImpl();
        HostHandlerImpl hostH = new HostHandlerImpl();

        GameModel game = new GameModel(24, 14, basePanel.gamePanel, 0);
        GameModel.setServer(true);
        game.addObserver(host);

        Operation.setServer(true);

        if (host.init(hostH)) {
            OperationQueue.addOperation(new StartGameOperation());
        }

        return false;
    }
}
