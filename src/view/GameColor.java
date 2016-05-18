package view;

import javafx.scene.paint.Color;

public class GameColor {
	public static Color getBlockColor(int x) {
		Color color;
		
		switch(x) {
			case 0: color = Color.rgb(200,200,200,0.3);break;//gray
			case 1: color = Color.web("#DB7164");break;
			case 2: color = Color.web("#E09767");break;
			case 3: color = Color.web("#E2B66B");break;
			case 4: color = Color.web("#6B85D3");break;
			case 5: color = Color.web("#6AA0D5");break;
			case 6: color = Color.web("#6ABEDD");break;
			//highlight
			case 7: color = Color.rgb(230,230,230,0.5);break;
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
	
	public static Color getMaterialColor(int x) { 
		Color color;
		switch(x) {
			//fill
			case 0: color = Color.web("#FCEAEC");break;//cloth 
			case 1: color = Color.web("#FAF9E7");break;//wood
			case 2: color = Color.web("#E5F1D9");break;//stone
			case 3: color = Color.web("#E8F9FB");break;//metal
			case 4: color = Color.web("#EFEAF3");break;//crystal
			//highlight
			case 5: color = Color.web("#FDDDE1");break;//cloth 
			case 6: color = Color.web("#FEFBD2");break;//wood
			case 7: color = Color.web("#D8F0C0");break;//stone
			case 8: color = Color.web("#D1F3F7");break;//metal
			case 9: color = Color.web("#E9DCF4");break;//crystal
			//stroke
			case 10: color = Color.web("#F5C1C8");break;//cloth 
			case 11: color = Color.web("#ECE8B5");break;//wood
			case 12: color = Color.web("#C1DEA5");break;//stone
			case 13: color = Color.web("#B9E3E8");break;//metal
			case 14: color = Color.web("#D6C4E6");break;//crystal
				
			default: color = Color.web("#EEEEEE");
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
		case 5: color = Color.web("#F2E1F3");break;//armor
		//highlight
		case 6: color = Color.web("#E46767");break;//spear
		case 7: color = Color.web("#F7E07B");break;//sword
		case 8: color = Color.web("#C3D26D");break;//battleax
		case 9: color = Color.web("#A1E0EB");break;//shuriken
		case 10: color = Color.web("#C2ABEE");break;//bow and arrow
		case 11: color = Color.web("#E8C6EB");break;//armor
		//stroke
		case 12: color = Color.web("#C35050");break;//spear
		case 13: color = Color.web("#DDC766");break;//sword
		case 14: color = Color.web("#A4B44B");break;//battleax
		case 15: color = Color.web("#84BFC9");break;//shuriken
		case 16: color = Color.web("#A592C9");break;//bow and arrow
		case 17: color = Color.web("#C9A0CC");break;//armor
		//background
//		case 15: color = Color.web("#E2B2B0");break;//spear
//		case 16: color = Color.web("#EEE0AE");break;//sword
//		case 17: color = Color.web("#DCE2C8");break;//battleax
//		case 18: color = Color.web("#D2E0ED");break;//shuriken
//		case 19: color = Color.web("#DCD5E6");break;//bow and arrow
	
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
			case 1: color = "#F0E8CD";break;//sword
			case 2: color = "#DCE2C8";break;//battleax
			case 3: color = "#D2E0ED";break;//shuriken
			case 4: color = "#DCD5E6";break;//bow and arrow
			case 5: color = "#F6ECF8";break;//armor
			
			//button
			case 6: color = "#975C5A";break;//spear
			case 7: color = "#C9B881";break;//sword
			case 8: color = "#919B6E";break;//battleax
			case 9: color = "#6183A2";break;//shuriken
			case 10: color = "#A593BE";break;//bow and arrow
			case 11: color = "#DDCAE1";break;//armor
			
			//button shadow
			case 12: color = "#74403E";break;//spear
			case 13: color = "#AF9F6B";break;//sword
			case 14: color = "#798453";break;//battleax
			case 15: color = "#4A6B8A";break;//shuriken
			case 16: color = "#846FA1";break;//bow and arrow
			case 17: color = "#B9A0BE";break;//armor
			
			//button unabled
			case -1: color = "#b4b4b4";break;
			case -2: color = "#9b9b9b";break;
			default: color = "#000000";
		}
		return color;
	}
	
	
	
	public static String getMaterialColorString(int x) {
		String color;
		switch(x){
		
		//level bg
		case 0:
		case 1:
			color = "#C8EEFF";break;
		case 2:
			color = "#FFFABD";break;
		case 3:
			color = "#FCD9D9";break;
		//level text
		case 4:
		case 5:
			color = "#0081BA";break;
		case 6:
			color = "#D29013";break;
		case 7:
			color = "#D0021B";break;
		
		default: color = "#000000";
		}
		return color;
	}
	
	
	public static String getLevelColorString(int x) {
		String color;
		switch(x){
		
		//button fill
		case 1: color = "#C8EEFF";break;
		case 2: color = "#FFFABD";break;
		case 3: color = "#FCD9D9";break;
		//button shadow
		case 4: color = "#A6CBDC";break;
		case 5: color = "#E2DD9F";break;
		case 6: color = "#D3A6A6";break;
		//button text
		case 7: color = "#0081BA";break;
		case 8: color = "#D29013";break;
		case 9: color = "#D0021B";break;
		
		default: color = "#000000";
		}
		return color;
	}

}
