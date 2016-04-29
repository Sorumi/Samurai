package view;

import javafx.scene.paint.Color;

public class GameColor {
	public static Color getBlockColor(int x) {
		Color color;
		
		switch(x) {
			case 0: color = Color.rgb(200,200,200,0.7);break;//gray
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
	
	public static Color getWeaponColor(int x) {
		Color color;
		switch(x) {
		//fill
			case 0: color = Color.web("#FFB3B3");break;//spear
			case 1: color = Color.web("#FFF3BB");break;//sword
			case 2: color = Color.web("#E0ED99");break;//battleax
			case 3: color = Color.web("#BBECF4");break;//shuriken
			case 4: color = Color.web("#D7C3FF");break;//bow and arrow
			//highlight
			case 5: color = Color.web("#E46767");break;//spear
			case 6: color = Color.web("#F7E07B");break;//sword
			case 7: color = Color.web("#C0D25C");break;//battleax
			case 8: color = Color.web("#A1E0EB");break;//shuriken
			case 9: color = Color.web("#B19BDC");break;//bow and arrow
			//stroke
			case 10: color = Color.web("#C35050");break;//spear
			case 11: color = Color.web("#DDC766");break;//sword
			case 12: color = Color.web("#A4B44B");break;//battleax
			case 13: color = Color.web("#84BFC9");break;//shuriken
			case 14: color = Color.web("#927EB9");break;//bow and arrow
			//background
			case 15: color = Color.web("#E2B2B0");break;//spear
			case 16: color = Color.web("#EEE0AE");break;//sword
			case 17: color = Color.web("#DCE2C8");break;//battleax
			case 18: color = Color.web("#D2E0ED");break;//shuriken
			case 19: color = Color.web("#DCD5E6");break;//bow and arrow
		
		default: color = Color.web("#EEEEEE");
		}
		
		return color;
	}
	
	public static Color getOtherColor(int x) {
		Color color;
		switch(x) {
			case 0: color = Color.rgb(205,223,203);break;//PlayerA
			case 1: color = Color.rgb(196,187,216);break;//PlayerB
			case 2: color = Color.rgb(128,128,128);break;//Font
			case 3: color = Color.rgb(247, 166, 166);break;//bloodArc
			default: color = Color.rgb(200,200,200,0.1);//gray
		}
		
		return color;
	}
}
