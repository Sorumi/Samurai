package controller;

import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import controller.msgqueue.TimeOperation;
import model.GameModel;
import network.client.ClientHandlerImpl;
import network.client.ClientServiceImpl;

/**
 * Created by Kray on 16/4/17.
 */
public class ClientController {
    public boolean setupClient(String ip){

        ClientServiceImpl client = new ClientServiceImpl();
        ClientHandlerImpl clientH = new ClientHandlerImpl();

        GameModel gameModel = new GameModel(client);
        clientH.addObserver(gameModel);

        Operation.setServer(false);

        if(client.init(ip, clientH)) {
            OperationQueue.addOperation(new StartGameOperation());
        }

        return false;
    }
}
