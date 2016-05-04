package network.server;

import java.io.IOException;

/**
 * Created by Kray on 16/4/17.
 */
public class ServerAdapter {
    protected static HostThread socket;
    protected static HostHandler handler;

    static boolean init(HostHandler h){
        try {
            socket = new HostThread();
            handler = h;
            socket.start();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void write(Object o){
        socket.write(o);
    }

    //from read
    public static void readData(Object data){
        handler.inputHandle(data);
    }

    public static void close(){
        socket.close();
    }
}
