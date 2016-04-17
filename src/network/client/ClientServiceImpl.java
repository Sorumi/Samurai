package network.client;

import controller.msgqueue.Operation;

/**
 * Created by Kray on 16/4/17.
 */
public class ClientServiceImpl extends ClientService{
    public void submitOperation(Operation op) {
        ClientAdapter.write(op);
    }
}
