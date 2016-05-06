package model.po;

public class Information {
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
