package model;

import java.io.Serializable;

/**
 * Observable给Observer发送的消息
 * @author Sorumi
 *
 */

public class UpdateMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	private String key;
	private Object value;
	
	//构造方法
	public UpdateMessage(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
