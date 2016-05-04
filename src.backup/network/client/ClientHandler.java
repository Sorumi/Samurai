package network.client;

/**
 * Created by Kray on 16/4/17.
 */
public interface ClientHandler {

    /**从服务器端
     * 获得传来的TransformObject，将其中的UpdateMessage传给对应的Proxy.
     * @param data
     */
    public void inputHandle(Object data);
}
