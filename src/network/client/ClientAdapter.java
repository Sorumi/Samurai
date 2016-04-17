package network.client;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by Kray on 16/4/17.
 */
public class ClientAdapter {

    protected static ClientThread socket;
    protected static ClientHandler handler;

    static boolean init(String addr, ClientHandler h){
        try {
            socket = new ClientThread(addr);
            handler = h;
            socket.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void write(Object o){
        socket.write(o);
    }

    public static void readData(Object data){
        handler.inputHandle(data);
    }

    public static void close(){
        socket.close();
    }

}
