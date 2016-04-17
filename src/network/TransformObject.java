package network;

import model.UpdateMessage;

import java.io.Serializable;

/**
 * Created by Kray on 16/4/17.
 */
public class TransformObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String source;
    private UpdateMessage msg;

    public TransformObject(String src, UpdateMessage msg){
        this.source = src;
        this.msg = msg;
    }

    public String getSource(){
        return this.source;
    }

    public UpdateMessage getMsg(){
        return this.msg;
    }

    public void setSource(String src){
        this.source = src;
    }

    public void setMsg(UpdateMessage msg){
        this.msg = msg;
    }
}
