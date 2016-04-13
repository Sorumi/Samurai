package view;

import java.awt.Color;


public class BlockColor {
	
	public static Color getBlockColor(int x) {
		Color color;
		
		switch(x) {
		case 0: color = new Color(200,200,200,70);break;//grey
		case 1: color = new Color(194,90,62);break;
		case 2: color = new Color(211,131,63);break;
		case 3: color = new Color(206,174,60);break;
		case 4: color = new Color(67,114,199);break;
		case 5: color = new Color(72,150,178);break;
		case 6: color = new Color(74,192,210);break;
		//highlight
		case 7: color = new Color(255,134,102);break;
		case 8: color = new Color(255,168,94);break;
		case 9: color = new Color(255,228,134);break;
		case 10: color = new Color(158,236,248);break;
		case 11: color = new Color(103,197,255);break;
		case 12: color = new Color(104,157,255);break;
		//alpha
		case 99:color = new Color(0,0,0,0);break;
		default: color = new Color(0,0,0,0);//alpha
		}
		
		return color;
	}
	
	public static Color getOtherColor(int x) {
		Color color;
		switch(x) {
		case 0: color = new Color(205,223,203);break;//PlayerA
		case 1: color = new Color(196,187,216);break;//PlayerB
		case 2: color = new Color(128,128,128);break;//Font
		default: color = new Color(200,200,200,10);//grey
		}
		
		return color;
	}
}
