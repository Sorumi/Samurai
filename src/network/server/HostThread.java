package network.server;

import network.Configure;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Kray on 16/4/17.
 */
public class HostThread extends Thread{

    private ServerSocket server;
    private Socket client;
    private ObjectInputStream reader;
    private ObjectOutputStream out;

    public HostThread() throws IOException {
        super();
        try{
            server = new ServerSocket(Configure.PORT);
        }catch (BindException be){
            be.printStackTrace();
        }
        client = server.accept();
        reader = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
        out = new ObjectOutputStream(client.getOutputStream());
    }

    public void run(){
        while(!this.isInterrupted()){
            try {
                Object obj = reader.readObject();
                if(obj != null){
                    ServerAdapter.readData(obj);
                }
            } catch(SocketException se){
                this.close();
                break;
            }catch (IOException e1) {
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
            client.close();
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
