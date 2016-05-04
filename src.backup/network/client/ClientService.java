package network.client;

import controller.msgqueue.Operation;

/**
 * Created by Kray on 16/4/17.
 */

public abstract class ClientService {

    public boolean init(String addr,ClientHandler handler){
        return ClientAdapter.init(addr, handler);
    }

    public void close(){
        ClientAdapter.close();
    }

    /**
     * 上传从服务器端的相关操作。
     * @param op
     */
    public abstract void submitOperation(Operation op);

}
