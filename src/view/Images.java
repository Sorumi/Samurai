package view;

import javafx.scene.image.Image;

public class Images {

	//BG
//	public static String BG_0 = Images.class.getResource("/./images/bg_0.png").toExternalForm();
	public static Image BG_0 = new Image("/./images/bg_0.png");
	//cloud 
	public static Image CLOUD_0 = new Image("/./images/cloud_0.png",true);
	public static Image CLOUD_1 = new Image("/./images/cloud_1.png",true);
	public static Image CLOUD_2 = new Image("/./images/cloud_2.png",true);
	//samurai
	public static Image SAMURAI_A1 = new Image("/./images/samurai_A1.png",true);
	public static Image SAMURAI_A2 = new Image("/./images/samurai_A2.png",true);
	public static Image SAMURAI_A3 = new Image("/./images/samurai_A3.png",true);
	public static Image SAMURAI_B1 = new Image("/./images/samurai_B1.png",true);
	public static Image SAMURAI_B2 = new Image("/./images/samurai_B2.png",true);
	public static Image SAMURAI_B3 = new Image("/./images/samurai_B3.png",true);
	public static Image[] SAMURAI = {null, SAMURAI_A1, SAMURAI_A2, SAMURAI_A3, SAMURAI_B1, SAMURAI_B2, SAMURAI_B3};

	//player
	public static final Image PLAYER_LOGO_A = new Image("/./images/PLAYER_LOGO_A.png");
	public static final Image PLAYER_LOGO_B = new Image("/./images/PLAYER_LOGO_B.png");
	public static final Image[] PLAYER_LOGO = {PLAYER_LOGO_A, PLAYER_LOGO_B};
	

	
	//arrow
	public static final Image ARROW = new Image("/./images/arrow.png");
	
	//button
	public static final Image BUTTON_OCCUPY = new Image("/./images/button_occupy.png");
	public static final Image BUTTON_MOVE = new Image("/./images/button_move.png");
	public static final Image BUTTON_HIDE = new Image("/./images/button_hide.png");
	public static final Image BUTTON_EXIT = new Image("/./images/button_exit.png");
	public static final Image BUTTON_BACK = new Image("/./images/button_back.png");
	public static final Image ACTION_BUTTON[] = {BUTTON_OCCUPY, BUTTON_MOVE, BUTTON_HIDE, BUTTON_EXIT, BUTTON_BACK };
	
	//direction
	public static final Image DIRECTION_0 = new Image("/./images/direction_0.png");
	public static final Image DIRECTION_1 = new Image("/./images/direction_1.png");
	public static final Image DIRECTION_2 = new Image("/./images/direction_2.png");
	public static final Image DIRECTION_3 = new Image("/./images/direction_3.png");
	public static final Image[] DIRECTION = {DIRECTION_0, DIRECTION_1, DIRECTION_2, DIRECTION_3};
	public static final Image DIRECTION_HL_0 = new Image("/./images/direction_highlight_0.png");
	public static final Image DIRECTION_HL_1 = new Image("/./images/direction_highlight_1.png");
	public static final Image DIRECTION_HL_2 = new Image("/./images/direction_highlight_2.png");
	public static final Image DIRECTION_HL_3 = new Image("/./images/direction_highlight_3.png");
	public static final Image[] DIRECTION_HL = {DIRECTION_HL_0, DIRECTION_HL_1, DIRECTION_HL_2, DIRECTION_HL_3};
}
