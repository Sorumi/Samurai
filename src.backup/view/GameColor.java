package view;

import javafx.scene.paint.Color;

public class GameColor {
	public static Color getBlockColor(int x) {
		Color color;
		
		switch(x) {
			case 0: color = Color.rgb(200,200,200,0.7);break;//gray
			case 1: color = Color.web("#DB7164");break;
			case 2: color = Color.web("#E09767");break;
			case 3: color = Color.web("#E2B66B");break;
			case 4: color = Color.web("#6B85D3");break;
			case 5: color = Color.web("#6AA0D5");break;
			case 6: color = Color.web("#6ABEDD");break;
			//highlight
			case 7: color = Color.rgb(230,230,230,0.7);break;
			case 8: color = Color.web("#FF8A7D");break;
			case 9: color = Color.web("#FFB27F");break;
			case 10: color = Color.web("#FFCE7B");break;
			case 11: color = Color.web("#81A0FF");break;
			case 12: color = Color.web("#7EC0FF");break;
			case 13: color = Color.web("#7EDCFF");break;
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
			case 2: color = Color.web("#E1E6C3");break;//battleax
			case 3: color = Color.web("#CBE5E9");break;//shuriken
			case 4: color = Color.web("#E3DBF2");break;//bow and arrow
			//highlight
			case 5: color = Color.web("#E46767");break;//spear
			case 6: color = Color.web("#F7E07B");break;//sword
			case 7: color = Color.web("#C3D26D");break;//battleax
			case 8: color = Color.web("#A1E0EB");break;//shuriken
			case 9: color = Color.web("#C2ABEE");break;//bow and arrow
			//stroke
			case 10: color = Color.web("#C35050");break;//spear
			case 11: color = Color.web("#DDC766");break;//sword
			case 12: color = Color.web("#A4B44B");break;//battleax
			case 13: color = Color.web("#84BFC9");break;//shuriken
			case 14: color = Color.web("#A592C9");break;//bow and arrow
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
	
	public static String getSamuraiColorString(int x) {
		String color;
		switch(x){
			case 0: color = "#ffffff";break;//null
			case 1: color = "#C25A3E";break;
			case 2: color = "#D3833F";break;
			case 3: color = "#CEAE3C";break;
			case 4: color = "#4372C7";break;
			case 5: color = "#4896C6";break;
			case 6: color = "#4AC0D2";break;
			//shadow
			case 7: color = "#9E3B20";break;
			case 8: color = "#B06423";break;
			case 9: color = "#AD8E22";break;
			case 10: color = "#2854A5";break;
			case 11: color = "#2B75A3";break;
			case 12: color = "#2EA1B3";break;
			default: color = "#000000";
		}
		return color;
	}
	
	public static String getWeaponColorString(int x) {
		String color;
		switch(x){
			case 0: color = "#E2B2B0";break;//spear
			case 1: color = "#EEE0AE";break;//sword
			case 2: color = "#DCE2C8";break;//battleax
			case 3: color = "#D2E0ED";break;//shuriken
			case 4: color = "#DCD5E6";break;//bow and arrow
			
			default: color = "#000000";
		}
		return color;
	}
}
