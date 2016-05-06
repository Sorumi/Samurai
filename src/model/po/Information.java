package model.po;

import java.io.Serializable;

public class Information implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tag;
	private String name;
	private String description;
	public Information(int tag, String name, String description) {
		this.tag=tag;
		this.name=name;
		this.description=description;	
	}
	public int getTag(){
		return tag;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
}
