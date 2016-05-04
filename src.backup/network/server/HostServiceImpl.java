package network.server;

import model.UpdateMessage;
import network.TransformObject;

import java.util.Observable;

/**
 * Created by Kray on 16/4/17.
 */
public class HostServiceImpl extends HostService {

    public boolean init(HostHandler handler){
        return ServerAdapter.init(handler);
    }

    public void update(Observable o, Object arg) {
        UpdateMessage msg = (UpdateMessage) arg;
        String trigger_class = o.getClass().getName();
        TransformObject obj = new TransformObject(trigger_class, msg);
        this.publishData(obj);
    }

    public void publishData(TransformObject o) {
        ServerAdapter.write(o);
    }

    public void close(){
        ServerAdapter.close();
    }

}
