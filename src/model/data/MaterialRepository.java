package model.data;

public class MaterialRepository {

	/*
	 * 所有材料的名字，描述，写在这
	 * 要是加上材料的等级也可以。
	 */
	
	public static String[] clothName = {"纱布", "纺布", "丝绸", "云绵"};
	public static String[] clothDescription = {"纱布的描述", "纺布的描述", "丝绸的描述", "云绵的描述"};

	public static String[] woodName = {"松木", "槐木", "雪山云杉", "不朽神木"};
	public static String[] woodDescription = {"松木的描述", "槐木的描述", "雪山云杉的描述", "不朽神木的描述"};
	
	public static String[][] MaterialName = {clothName, woodName};
}
