package network.server;

import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;

/**
 * Created by Kray on 16/4/17.
 */
public class HostHandlerImpl  implements HostHandler{
    /**
     * 主服务器端，得到Operation，并把它加入到OperationQueue.
     */
    public void inputHandle(Object data) {
        Operation op = (Operation) data;
        OperationQueue.addOperation(op);
        System.out.println(op.toString());
    }
}
