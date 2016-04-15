package view;

import javafx.scene.paint.Color;

public class GameColor {
	public static Color getBlockColor(int x) {
		Color color;
		
		switch(x) {
		case 0: color = Color.rgb(200,200,200,0.7);break;//grey
		case 1: color = Color.rgb(194,90,62);break;
		case 2: color = Color.rgb(211,131,63);break;
		case 3: color = Color.rgb(206,174,60);break;
		case 4: color = Color.rgb(67,114,199);break;
		case 5: color = Color.rgb(72,150,178);break;
		case 6: color = Color.rgb(74,192,210);break;
		//highlight
		case 7: color = Color.rgb(255,134,102);break;
		case 8: color = Color.rgb(255,168,94);break;
		case 9: color = Color.rgb(255,228,134);break;
		case 10: color = Color.rgb(158,236,248);break;
		case 11: color = Color.rgb(103,197,255);break;
		case 12: color = Color.rgb(104,157,255);break;
		//alpha
		case 99:color = new Color(0,0,0,0);break;
		default: color = new Color(0,0,0,0);//alpha
		}
		
		return color;
	}
	
	public static Color getOtherColor(int x) {
		Color color;
		switch(x) {
		case 0: color = Color.rgb(205,223,203);break;//PlayerA
		case 1: color = Color.rgb(196,187,216);break;//PlayerB
		case 2: color = Color.rgb(128,128,128);break;//Font
		default: color = Color.rgb(200,200,200,0.1);//grey
		}
		
		return color;
	}
}
