package fonts;

import javafx.scene.text.Font;

public class FontManager {

	public static void loadAllFont(){
		
		Font tsukushi = Font.loadFont(FontManager.class.getResourceAsStream("main/Tsukushi.ttc"), 10);

		Font pingfangRegular = Font.loadFont(FontManager.class.getResource("main/PingFang-Regular.ttf").toExternalForm(), 10);
		Font pingfangLight = Font.loadFont(FontManager.class.getResource("main/PingFang-Light.ttf").toExternalForm(), 10);
		Font pingfangMedium = Font.loadFont(FontManager.class.getResource("main/PingFang-Medium.ttf").toExternalForm(), 20);
		Font langqian = Font.loadFont(FontManager.class.getResource("main/MFLangQian.ttf").toExternalForm(), 10);
		
//		System.out.println(tsukushi.getName());
//		System.out.println(pingfangRegular.getName());
//		System.out.println(pingfangLight.getName());
//		System.out.println(pingfangMedium.getName());
//		System.out.println(langqian.getName());
		
	}

}
