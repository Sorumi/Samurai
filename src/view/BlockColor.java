package view;

import java.awt.Color;


public class BlockColor {
	
	public static Color getBlockColor(int x) {
		Color color;
		
		switch(x) {
		case 0: color =  new Color(200,200,200,10);break;//grey
		case 1: color = new Color(194,90,62);break;
		case 2: color = new Color(211,131,63);break;
		case 3: color = new Color(206,174,60);break;
		case 4: color = new Color(67,114,199);break;
		case 5: color = new Color(72,150,178);break;
		case 6: color = new Color(74,192,210);break;
		default: color = new Color(200,200,200,10);//grey
		}
		
		return color;
	}
}
