package view;

import java.awt.Color;


public class BlockColor {
	
	public static Color getBlockColor(int x) {
		Color color;
		
		switch(x) {
		case 0: color =  new Color(0,0,0);break;//black
		case 1: color = new Color(255,0,0);break;//red
		case 2: color = new Color(0,255,0);break;//green
		case 3: color = new Color(0,0,255);break;//blue
		case 4: color = new Color(255,255,255);break;//white
		default: color = new Color(200,200,200);//grey
		}
		
		return color;
	}
}
