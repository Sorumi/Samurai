package network.client;

import network.TransformObject;

import java.util.Observable;

/**
 * Created by Kray on 16/4/17.
 */
public class ClientHandlerImpl extends Observable implements ClientHandler {
    public void inputHandle(Object data) {
        TransformObject obj = (TransformObject) data;
        this.setChanged();
        this.notifyObservers(obj);
        System.out.println(obj.getSource() + obj.getMsg().getValue());
    }
}
