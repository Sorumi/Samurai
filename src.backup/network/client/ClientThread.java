package network.client;

import network.Configure;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Kray on 16/4/17.
 */
public class ClientThread extends Thread{

    private Socket server;
    private ObjectInputStream reader;
    private ObjectOutputStream out;

    public ClientThread(String addr) throws IOException {
        super();
        server = new Socket(addr, Configure.PORT);
        out = new ObjectOutputStream(server.getOutputStream());
        reader = new ObjectInputStream(new BufferedInputStream(server.getInputStream()));
    }

    public void run(){
        while(!this.isInterrupted()){
            try {
                Object obj = reader.readObject();
                ClientAdapter.readData(obj);
            } catch(SocketException se){
                this.close();
                break;
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
        try {
            reader.close();
            out.close();
            server.close();
            this.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object write(Object o) {
        try {
            out.writeObject(o);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
