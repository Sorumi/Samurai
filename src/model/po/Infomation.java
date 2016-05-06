package model.po;

public class Infomation {
	private int tag;
	private String name;
	private String description;
	public  Infomation(int tag,String name,String description) {
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
