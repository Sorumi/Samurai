package network.server;

/**
 * Created by Kray on 16/4/17.
 */
public interface HostHandler {
    /**
     * 主服务器端，得到MineOperation，并把它加入到OperationQueue.
     */
    public void inputHandle(Object data);
}
