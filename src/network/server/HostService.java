package network.server;

import network.TransformObject;

import java.util.Observer;

/**
 * Created by Kray on 16/4/17.
 */
public abstract class HostService implements Observer {

    public boolean init(HostHandler handler){
        boolean succeed = ServerAdapter.init(handler);
        return succeed;
    }

    public void close(){
        ServerAdapter.close();
    }

    public abstract void publishData(TransformObject o);

}
