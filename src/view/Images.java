package view;

import javafx.scene.image.Image;

public class Images {

	//BG
	public static String BG_0 = Images.class.getResource("/./images/bg_0.png").toExternalForm();
	public static String BG_1 = Images.class.getResource("/./images/bg_1.png").toExternalForm();
	public static String BG_2 = Images.class.getResource("/./images/bg_2.png").toExternalForm();
	public static String BG_3 = Images.class.getResource("/./images/bg_3.png").toExternalForm();
	public static String BG_4 = Images.class.getResource("/./images/bg_4.png").toExternalForm();
	public static String BG_5 = Images.class.getResource("/./images/bg_5.png").toExternalForm();	
	public static String[] BG = {BG_0, BG_1, BG_2, BG_3, BG_4, BG_5};
	//cloud 
	public static Image CLOUD_0 = new Image("/./images/cloud_0.png",true);
	public static Image CLOUD_1 = new Image("/./images/cloud_1.png",true);
	public static Image CLOUD_2 = new Image("/./images/cloud_2.png",true);
	//fish
	public static Image FISH_0 = new Image("/./images/fish_0.png",true);
	public static Image FISH_1 = new Image("/./images/fish_1.png",true);
	public static Image FISH_2 = new Image("/./images/fish_2.png",true);
	public static Image FISH_3 = new Image("/./images/fish_3.png",true);
	//leaf
	public static Image LEAF_0 = new Image("/./images/leaf_0.png",true);
	public static Image LEAF_1 = new Image("/./images/leaf_1.png",true);
	//lotus
	public static Image LOTUS_0 = new Image("/./images/lotus_0.png",true);
	
	//system
	public static Image SYSTEM_BACK_BTN = new Image("/./images/system_back_button.png",true);
	public static Image SYSTEM_CLOSE_BTN = new Image("/./images/system_close_button.png",true);
	public static Image SYSTEM_SAVE_BTN = new Image("/./images/system_save_button.png",true);

	//samurai state
	public static Image STATE_ICON_1 = new Image("/./images/state_icon_1.png",true);
	public static Image STATE_ICON_2 = new Image("/./images/state_icon_2.png",true);
	public static Image STATE_ICON_3 = new Image("/./images/state_icon_3.png",true);
	public static Image STATE_ICON_4 = new Image("/./images/state_icon_4.png",true);
	public static Image STATE_ICON_5 = new Image("/./images/state_icon_5.png",true);
	public static Image STATE_ICON_6 = new Image("/./images/state_icon_6.png",true);

	//weapon state
	public static Image WEAPON_STATE_1 = new Image("/./images/weapon_state_1.png",true);
	public static Image WEAPON_STATE_2 = new Image("/./images/weapon_state_2.png",true);
	public static Image WEAPON_STATE_3 = new Image("/./images/weapon_state_3.png",true);
	
	//samurai btn
	public static Image SAMURAI_BTN_1 = new Image("/./images/samurai_btn_1.png",true);
	public static Image SAMURAI_BTN_2 = new Image("/./images/samurai_btn_2.png",true);
	public static Image SAMURAI_BTN_3 = new Image("/./images/samurai_btn_3.png",true);
	public static Image[]  SAMURAI_BTN = {null, SAMURAI_BTN_1, SAMURAI_BTN_2, SAMURAI_BTN_3};
	
	//player
	public static final Image PLAYER_LOGO_A = new Image("/./images/PLAYER_LOGO_A.png");
	public static final Image PLAYER_LOGO_B = new Image("/./images/PLAYER_LOGO_B.png");
	public static final Image[] PLAYER_LOGO = {PLAYER_LOGO_A, PLAYER_LOGO_B};
	
	//resultPanel
	public static Image A_WIN = new Image("/./images/player_logo_A_big.png",true); 
	
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
	
	//territory
	public static final Image TERRITORY_BG = new Image("/./images/territory_bg.png");
	public static final Image TERRITORY_MOUNTAIN = new Image("/./images/territory_mountain.png");
	public static final Image TERRITORY_LAND_0 = new Image("/./images/territory_land_0.png");
	public static final Image TERRITORY_LAND_1 = new Image("/./images/territory_land_1.png");
	public static final Image TERRITORY_ITEMS = new Image("/./images/territory_items.png");
	public static final Image TERRITORY_CAMPSITE = new Image("/./images/territory_campsite.png");
	public static final Image TERRITORY_SMITHY = new Image("/./images/territory_smithy.png");
	public static final Image TERRITORY_STORE = new Image("/./images/territory_store.png");
	public static final Image TERRITORY_FLAG = new Image("/./images/territory_flag.png");
	
	//weather
	public static final Image WEATHER_1 = new Image("/./images/weather_1_sun.png");
	public static final Image WEATHER_2 = new Image("/./images/weather_2_moon.png");
	public static final Image WEATHER_3 = new Image("/./images/weather_3_stars.png");
	public static final Image WEATHER_4 = new Image("/./images/weather_4_rain.png");
	public static final Image WEATHER_5 = new Image("/./images/weather_5_snow.png");
	public static final Image[] WEATHER = {null, WEATHER_1, WEATHER_2, WEATHER_3, WEATHER_4, WEATHER_5};
	
	//map
	public static final Image MAP_BG = new Image("/./images/map/map_bg.png");
	public static final Image MAP_HOME = new Image("/./images/map/map_home.png");
	public static final Image MAP_LEVEL1 = new Image("/./images/map/map_level1.png");
	public static final Image MAP_LEVEL2 = new Image("/./images/map/map_level2.png");
	public static final Image MAP_LEVEL3 = new Image("/./images/map/map_level3.png");
	public static final Image MAP_LEVEL4 = new Image("/./images/map/map_level4.png");
	public static final Image MAP_LEVEL5 = new Image("/./images/map/map_level5.png");
	public static final Image[] MAP_LAND = {MAP_HOME, MAP_LEVEL1, MAP_LEVEL2, MAP_LEVEL3, MAP_LEVEL4, MAP_LEVEL5};
	//bridge
	public static final Image MAP_BRIDGE = new Image("/./images/map/map_bridge.png");
	//fog
	public static final Image MAP_FOG2_0 = new Image("/./images/map/map_fog2_0.png");
	public static final Image MAP_FOG2_1 = new Image("/./images/map/map_fog2_1.png");
	public static final Image MAP_FOG3_0 = new Image("/./images/map/map_fog3_0.png");
	public static final Image MAP_FOG3_1 = new Image("/./images/map/map_fog3_1.png");
	public static final Image MAP_FOG4_0 = new Image("/./images/map/map_fog4_0.png");
	public static final Image MAP_FOG4_1 = new Image("/./images/map/map_fog4_1.png");
	public static final Image MAP_FOG4_2 = new Image("/./images/map/map_fog4_2.png");
	public static final Image MAP_FOG5_0 = new Image("/./images/map/map_fog5_0.png");
	public static final Image MAP_FOG5_1 = new Image("/./images/map/map_fog5_1.png");
	//cloud
	public static final Image MAP_CLOUD_0 = new Image("/./images/map/map_cloud_0.png");
	public static final Image MAP_CLOUD_1 = new Image("/./images/map/map_cloud_1.png");
	public static final Image MAP_CLOUD_2 = new Image("/./images/map/map_cloud_2.png");
	public static final Image MAP_CLOUD_3 = new Image("/./images/map/map_cloud_3.png");
	public static final Image MAP_CLOUD_4 = new Image("/./images/map/map_cloud_4.png");
	public static final Image[] MAP_CLOUD = {MAP_CLOUD_0, MAP_CLOUD_1, MAP_CLOUD_2, MAP_CLOUD_3, MAP_CLOUD_4};
	
	//samurai
	public static Image SAMURAI_0042 = new Image("/./images/samurai/samurai_004_eyeleft.png",true);
	public static Image SAMURAI_0043 = new Image("/./images/samurai/samurai_004_eyeright.png",true);
	public static Image[] SAMURAI_0 = {SAMURAI_0043, SAMURAI_0043};
	
	public static Image SAMURAI_003 = new Image("/./images/samurai/samurai_003_leftarm.png",true);
	public static Image SAMURAI_0040 = new Image("/./images/samurai/samurai_004_head_injured.png",true);
	public static Image SAMURAI_0041 = new Image("/./images/samurai/samurai_004_head_occupy.png",true);
	public static Image SAMURAI_005 = new Image("/./images/samurai/samurai_005_head.png",true);
	public static Image SAMURAI_010 = new Image("/./images/samurai/samurai_010_rightarm.png",true);
	
	public static Image SAMURAI_101 = new Image("/./images/samurai/samurai_101_helmet_back.png",true);
	public static Image SAMURAI_102 = new Image("/./images/samurai/samurai_102_leftshoulder.png",true);
	public static Image SAMURAI_106 = new Image("/./images/samurai/samurai_106_body.png",true);
	public static Image SAMURAI_107 = new Image("/./images/samurai/samurai_107_leftleg.png",true);
	public static Image SAMURAI_108 = new Image("/./images/samurai/samurai_108_rightleg.png",true);
	public static Image SAMURAI_109 = new Image("/./images/samurai/samurai_109_rightshoulder.png",true);
	public static Image SAMURAI_111 = new Image("/./images/samurai/samurai_111_helmet.png",true);
	public static Image[] SAMURAI_1 = {null, SAMURAI_101, SAMURAI_102, SAMURAI_003, SAMURAI_0040, SAMURAI_0041, SAMURAI_005, SAMURAI_106, SAMURAI_107, SAMURAI_108, SAMURAI_109, SAMURAI_010, SAMURAI_111};

	public static Image SAMURAI_201 = new Image("/./images/samurai/SAMURAI_201_helmet_back.png",true);
	public static Image SAMURAI_202 = new Image("/./images/samurai/SAMURAI_202_leftshoulder.png",true);
	public static Image SAMURAI_206 = new Image("/./images/samurai/SAMURAI_206_body.png",true);
	public static Image SAMURAI_207 = new Image("/./images/samurai/SAMURAI_207_leftleg.png",true);
	public static Image SAMURAI_208 = new Image("/./images/samurai/SAMURAI_208_rightleg.png",true);
	public static Image SAMURAI_209 = new Image("/./images/samurai/SAMURAI_209_rightshoulder.png",true);
	public static Image SAMURAI_211 = new Image("/./images/samurai/SAMURAI_211_helmet.png",true);
	public static Image[] SAMURAI_2 = {null, SAMURAI_201, SAMURAI_202, SAMURAI_003, SAMURAI_0040, SAMURAI_0041, SAMURAI_005, SAMURAI_206, SAMURAI_207, SAMURAI_208, SAMURAI_209, SAMURAI_010, SAMURAI_211};

	public static Image SAMURAI_301 = new Image("/./images/samurai/SAMURAI_301_helmet_back.png",true);
	public static Image SAMURAI_302 = new Image("/./images/samurai/SAMURAI_302_leftshoulder.png",true);
	public static Image SAMURAI_306 = new Image("/./images/samurai/SAMURAI_306_body.png",true);
	public static Image SAMURAI_307 = new Image("/./images/samurai/SAMURAI_307_leftleg.png",true);
	public static Image SAMURAI_308 = new Image("/./images/samurai/SAMURAI_308_rightleg.png",true);
	public static Image SAMURAI_309 = new Image("/./images/samurai/SAMURAI_309_rightshoulder.png",true);
	public static Image SAMURAI_311 = new Image("/./images/samurai/SAMURAI_311_helmet.png",true);
	public static Image[] SAMURAI_3 = {null, SAMURAI_301, SAMURAI_302, SAMURAI_003, SAMURAI_0040, SAMURAI_0041, SAMURAI_005, SAMURAI_306, SAMURAI_307, SAMURAI_308, SAMURAI_309, SAMURAI_010, SAMURAI_311};

	public static Image SAMURAI_401 = new Image("/./images/samurai/SAMURAI_401_helmet_back.png",true);
	public static Image SAMURAI_402 = new Image("/./images/samurai/SAMURAI_402_leftshoulder.png",true);
	public static Image SAMURAI_406 = new Image("/./images/samurai/SAMURAI_406_body.png",true);
	public static Image SAMURAI_407 = new Image("/./images/samurai/SAMURAI_407_leftleg.png",true);
	public static Image SAMURAI_408 = new Image("/./images/samurai/SAMURAI_408_rightleg.png",true);
	public static Image SAMURAI_409 = new Image("/./images/samurai/SAMURAI_409_rightshoulder.png",true);
	public static Image SAMURAI_411 = new Image("/./images/samurai/SAMURAI_411_helmet.png",true);
	public static Image[] SAMURAI_4 = {null, SAMURAI_401, SAMURAI_402, SAMURAI_003, SAMURAI_0040, SAMURAI_0041, SAMURAI_005, SAMURAI_406, SAMURAI_407, SAMURAI_408, SAMURAI_409, SAMURAI_010, SAMURAI_411};

	public static Image SAMURAI_501 = new Image("/./images/samurai/SAMURAI_501_helmet_back.png",true);
	public static Image SAMURAI_502 = new Image("/./images/samurai/SAMURAI_502_leftshoulder.png",true);
	public static Image SAMURAI_506 = new Image("/./images/samurai/SAMURAI_506_body.png",true);
	public static Image SAMURAI_507 = new Image("/./images/samurai/SAMURAI_507_leftleg.png",true);
	public static Image SAMURAI_508 = new Image("/./images/samurai/SAMURAI_508_rightleg.png",true);
	public static Image SAMURAI_509 = new Image("/./images/samurai/SAMURAI_509_rightshoulder.png",true);
	public static Image SAMURAI_511 = new Image("/./images/samurai/SAMURAI_511_helmet.png",true);
	public static Image[] SAMURAI_5 = {null, SAMURAI_501, SAMURAI_502, SAMURAI_003, SAMURAI_0040, SAMURAI_0041, SAMURAI_005, SAMURAI_506, SAMURAI_507, SAMURAI_508, SAMURAI_509, SAMURAI_010, SAMURAI_511};

	public static Image SAMURAI_601 = new Image("/./images/samurai/SAMURAI_601_helmet_back.png",true);
	public static Image SAMURAI_602 = new Image("/./images/samurai/SAMURAI_602_leftshoulder.png",true);
	public static Image SAMURAI_606 = new Image("/./images/samurai/SAMURAI_606_body.png",true);
	public static Image SAMURAI_607 = new Image("/./images/samurai/SAMURAI_607_leftleg.png",true);
	public static Image SAMURAI_608 = new Image("/./images/samurai/SAMURAI_608_rightleg.png",true);
	public static Image SAMURAI_609 = new Image("/./images/samurai/SAMURAI_609_rightshoulder.png",true);
	public static Image SAMURAI_611 = new Image("/./images/samurai/SAMURAI_611_helmet.png",true);
	public static Image[] SAMURAI_6 = {null, SAMURAI_601, SAMURAI_602, SAMURAI_003, SAMURAI_0040, SAMURAI_0041, SAMURAI_005, SAMURAI_606, SAMURAI_607, SAMURAI_608, SAMURAI_609, SAMURAI_010, SAMURAI_611};

	public static Image[][] SAMURAI = {null, SAMURAI_1, SAMURAI_2, SAMURAI_3, SAMURAI_4, SAMURAI_5, SAMURAI_6};

	//weapon
	//icon
	public static Image WEAPON_ICON_0 = new Image("/./images/weapon_icon_0_spear.png",true);
	public static Image WEAPON_ICON_1 = new Image("/./images/weapon_icon_1_sword.png",true);
	public static Image WEAPON_ICON_2 = new Image("/./images/weapon_icon_2_battleax.png",true);
	public static Image WEAPON_ICON_3 = new Image("/./images/weapon_icon_3_shuriken.png",true);
	public static Image WEAPON_ICON_4 = new Image("/./images/weapon_icon_4_bow.png",true);
	public static Image[] WEAPON_ICON = {WEAPON_ICON_0, WEAPON_ICON_1, WEAPON_ICON_2, WEAPON_ICON_3, WEAPON_ICON_4};
	
	//spear
	public static Image WEAPON_000 = new Image("/./images/weapon/weapon_000_spear.png",true);

	public static Image WEAPON_011 = new Image("/./images/weapon/weapon_011_spear.png",true);
	public static Image WEAPON_012 = new Image("/./images/weapon/weapon_012_spear.png",true);
	public static Image WEAPON_013 = new Image("/./images/weapon/weapon_013_spear.png",true);
	public static Image WEAPON_014 = new Image("/./images/weapon/weapon_014_spear.png",true);
	public static Image WEAPON_015 = new Image("/./images/weapon/weapon_015_spear.png",true);
	public static Image WEAPON_016 = new Image("/./images/weapon/weapon_016_spear.png",true);
	
	public static Image WEAPON_023 = new Image("/./images/weapon/weapon_023_spear.png",true);
	public static Image WEAPON_025 = new Image("/./images/weapon/weapon_025_spear.png",true);
	public static Image WEAPON_026 = new Image("/./images/weapon/weapon_026_spear.png",true);
	
	public static Image WEAPON_033 = new Image("/./images/weapon/weapon_033_spear.png",true);
	public static Image WEAPON_034 = new Image("/./images/weapon/weapon_034_spear.png",true);
	public static Image WEAPON_035 = new Image("/./images/weapon/weapon_035_spear.png",true);
	public static Image WEAPON_036 = new Image("/./images/weapon/weapon_036_spear.png",true);
	
	//sword
	public static Image WEAPON_100 = new Image("/./images/weapon/weapon_100_sword.png",true);
	
	public static Image WEAPON_111 = new Image("/./images/weapon/weapon_111_sword.png",true);
	public static Image WEAPON_112 = new Image("/./images/weapon/weapon_112_sword.png",true);
	public static Image WEAPON_113 = new Image("/./images/weapon/weapon_113_sword.png",true);
	public static Image WEAPON_114 = new Image("/./images/weapon/weapon_114_sword.png",true);
	public static Image WEAPON_115 = new Image("/./images/weapon/weapon_115_sword.png",true);
	public static Image WEAPON_116 = new Image("/./images/weapon/weapon_116_sword.png",true);
	
	public static Image WEAPON_124 = new Image("/./images/weapon/weapon_124_sword.png",true);
	public static Image WEAPON_125 = new Image("/./images/weapon/weapon_125_sword.png",true);
	public static Image WEAPON_126 = new Image("/./images/weapon/weapon_126_sword.png",true);
	
	public static Image WEAPON_132 = new Image("/./images/weapon/weapon_132_sword.png",true);
	public static Image WEAPON_133 = new Image("/./images/weapon/weapon_133_sword.png",true);
	public static Image WEAPON_134 = new Image("/./images/weapon/weapon_134_sword.png",true);
	public static Image WEAPON_135 = new Image("/./images/weapon/weapon_135_sword.png",true);
	public static Image WEAPON_136 = new Image("/./images/weapon/weapon_136_sword.png",true);
	
	//battleax
	public static Image WEAPON_200 = new Image("/./images/weapon/weapon_200_battleax.png",true);
	
	public static Image WEAPON_211 = new Image("/./images/weapon/weapon_211_battleax.png",true);
	public static Image WEAPON_212 = new Image("/./images/weapon/weapon_212_battleax.png",true);
	public static Image WEAPON_213 = new Image("/./images/weapon/weapon_213_battleax.png",true);
	public static Image WEAPON_214 = new Image("/./images/weapon/weapon_214_battleax.png",true);
	public static Image WEAPON_215 = new Image("/./images/weapon/weapon_215_battleax.png",true);
	public static Image WEAPON_216 = new Image("/./images/weapon/weapon_216_battleax.png",true);
	
	public static Image WEAPON_225 = new Image("/./images/weapon/weapon_225_battleax.png",true);
	public static Image WEAPON_226 = new Image("/./images/weapon/weapon_226_battleax.png",true);
	
	public static Image WEAPON_233 = new Image("/./images/weapon/weapon_233_battleax.png",true);
	public static Image WEAPON_234 = new Image("/./images/weapon/weapon_234_battleax.png",true);
	public static Image WEAPON_235 = new Image("/./images/weapon/weapon_235_battleax.png",true);
	public static Image WEAPON_236 = new Image("/./images/weapon/weapon_236_battleax.png",true);

	//shuriken
	public static Image WEAPON_300 = new Image("/./images/weapon/weapon_300_shuriken.png",true);
	
	public static Image WEAPON_311 = new Image("/./images/weapon/weapon_311_shuriken.png",true);
	public static Image WEAPON_312 = new Image("/./images/weapon/weapon_312_shuriken.png",true);
	public static Image WEAPON_313 = new Image("/./images/weapon/weapon_313_shuriken.png",true);
	public static Image WEAPON_314 = new Image("/./images/weapon/weapon_314_shuriken.png",true);
	public static Image WEAPON_315 = new Image("/./images/weapon/weapon_315_shuriken.png",true);
	public static Image WEAPON_316 = new Image("/./images/weapon/weapon_316_shuriken.png",true);
	
	public static Image WEAPON_323 = new Image("/./images/weapon/weapon_323_shuriken.png",true);
	public static Image WEAPON_324 = new Image("/./images/weapon/weapon_324_shuriken.png",true);
	public static Image WEAPON_325 = new Image("/./images/weapon/weapon_325_shuriken.png",true);
	public static Image WEAPON_326 = new Image("/./images/weapon/weapon_326_shuriken.png",true);
	
	//bow and arrow
	public static Image WEAPON_400 = new Image("/./images/weapon/weapon_400_bow.png",true);
	public static Image WEAPON_500 = new Image("/./images/weapon/weapon_500_arrow.png",true);
	
	public static Image[] WEAPON_00 = {WEAPON_000};
	public static Image[] WEAPON_01 = {null, WEAPON_011, WEAPON_012, WEAPON_013, WEAPON_014, WEAPON_015, WEAPON_016};
	public static Image[] WEAPON_02 = {null, null, null, WEAPON_023, null,  WEAPON_025, WEAPON_026};
	public static Image[] WEAPON_03 = {null, null, null, WEAPON_033, WEAPON_034, WEAPON_035, WEAPON_036};
	
	public static Image[] WEAPON_10 = {WEAPON_100};
	public static Image[] WEAPON_11 = {null, WEAPON_111, WEAPON_112, WEAPON_113, WEAPON_114, WEAPON_115, WEAPON_116};
	public static Image[] WEAPON_12 = {null, null, null, null, WEAPON_124, WEAPON_125, WEAPON_126};
	public static Image[] WEAPON_13 = {null, null, WEAPON_132, WEAPON_133, WEAPON_134, WEAPON_135, WEAPON_136};
	
	public static Image[] WEAPON_20 = {WEAPON_200};
	public static Image[] WEAPON_21 = {null, WEAPON_211, WEAPON_212, WEAPON_213, WEAPON_214, WEAPON_215, WEAPON_216};
	public static Image[] WEAPON_22 = {null, null, null, null, null,  WEAPON_225, WEAPON_226};
	public static Image[] WEAPON_23 = {null, null, null, WEAPON_233, WEAPON_234, WEAPON_235, WEAPON_236};
	
	public static Image[] WEAPON_30 = {WEAPON_300};
	public static Image[] WEAPON_31 = {null, WEAPON_311, WEAPON_312, WEAPON_313, WEAPON_314, WEAPON_315, WEAPON_316};
	public static Image[] WEAPON_32 = {null, null, null, WEAPON_323, WEAPON_324, WEAPON_325, WEAPON_326};
	
	//TODO
	public static Image[] WEAPON_40 = {WEAPON_400};
	public static Image[] WEAPON_41 = {WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400};
	public static Image[] WEAPON_42 = {WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400};
	public static Image[] WEAPON_43 = {WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400, WEAPON_400};
	public static Image[] WEAPON_50 = {WEAPON_500};
	public static Image[] WEAPON_51 = {WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500};
	public static Image[] WEAPON_52 = {WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500};
	public static Image[] WEAPON_53 = {WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500, WEAPON_500};
	
	public static Image[][] WEAPON_0 = {WEAPON_00, WEAPON_01, WEAPON_02, WEAPON_03};
	public static Image[][] WEAPON_1 = {WEAPON_10, WEAPON_11, WEAPON_12, WEAPON_13};
	public static Image[][] WEAPON_2 = {WEAPON_20, WEAPON_21, WEAPON_22, WEAPON_23};
	public static Image[][] WEAPON_3 = {WEAPON_30, WEAPON_31, WEAPON_32, null};
	public static Image[][] WEAPON_4 = {WEAPON_40, WEAPON_41, WEAPON_42, WEAPON_43};
	public static Image[][] WEAPON_5 = {WEAPON_50, WEAPON_51, WEAPON_52, WEAPON_53};
	
	public static Image[][][] WEAPON = {WEAPON_0, WEAPON_1, WEAPON_2, WEAPON_3, WEAPON_4, WEAPON_5};
	
	//material
	//cloth 
	public static Image MATERIAL_00 = new Image("/./images/material/material_cloth_1.png",true);
	public static Image MATERIAL_01 = new Image("/./images/material/material_cloth_2.png",true);
	public static Image MATERIAL_02 = new Image("/./images/material/material_cloth_3.png",true);
	public static Image MATERIAL_03 = new Image("/./images/material/material_cloth_4.png",true);
	 
	//wood
	public static Image MATERIAL_10 = new Image("/./images/material/material_wood_1.png",true);
	public static Image MATERIAL_11 = new Image("/./images/material/material_wood_2.png",true);
	public static Image MATERIAL_12 = new Image("/./images/material/material_wood_3.png",true);
	public static Image MATERIAL_13 = new Image("/./images/material/material_wood_4.png",true);
	
	//stone 
	public static Image MATERIAL_20 = new Image("/./images/material/material_stone_1.png",true);
	public static Image MATERIAL_21 = new Image("/./images/material/material_stone_2.png",true);
	public static Image MATERIAL_22 = new Image("/./images/material/material_stone_3.png",true);
	public static Image MATERIAL_23 = new Image("/./images/material/material_stone_4.png",true);
	
	//metal 
	public static Image MATERIAL_30 = new Image("/./images/material/material_metal_1.png",true);
	public static Image MATERIAL_31 = new Image("/./images/material/material_metal_2.png",true);
	public static Image MATERIAL_32 = new Image("/./images/material/material_metal_3.png",true);
	public static Image MATERIAL_33 = new Image("/./images/material/material_metal_4.png",true);
	
	//crystal 
	public static Image MATERIAL_40 = new Image("/./images/material/material_crystal_1.png",true);
	public static Image MATERIAL_41 = new Image("/./images/material/material_crystal_2.png",true);
	public static Image MATERIAL_42 = new Image("/./images/material/material_crystal_3.png",true);
	public static Image MATERIAL_43 = new Image("/./images/material/material_crystal_4.png",true);
	 
	public static Image[] MATERIAL_0 = {MATERIAL_00, MATERIAL_01, MATERIAL_02, MATERIAL_03};
	public static Image[] MATERIAL_1 = {MATERIAL_10, MATERIAL_11, MATERIAL_12, MATERIAL_13};
	public static Image[] MATERIAL_2 = {MATERIAL_20, MATERIAL_21, MATERIAL_22, MATERIAL_23};
	public static Image[] MATERIAL_3 = {MATERIAL_30, MATERIAL_31, MATERIAL_32, MATERIAL_33};
	public static Image[] MATERIAL_4 = {MATERIAL_40, MATERIAL_41, MATERIAL_42, MATERIAL_43};
	
	public static Image[][] MATERIAL = {MATERIAL_0, MATERIAL_1, MATERIAL_2, MATERIAL_3, MATERIAL_4};
 
}
