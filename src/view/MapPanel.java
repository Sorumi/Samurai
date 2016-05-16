	package view;

import controller.MapController;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import view.eventhandler.MapHandler;

public class MapPanel extends Pane {
	
	private MapHandler mapHandler;
	private MapController mapController;
	
	private Group landGroup;
	private LandButton home;
	private LandButton level1;
	private LandButton level2;
	private LandButton level3;
	private LandButton level4;
	private LandButton level5;
	
	private Group bridgeGroup;
	private Group cloudGroup;
	
	public FogGroup fogs2;
	public FogGroup fogs3;
	public FogGroup fogs4;
	public FogGroup fogs5; 
	
	public LevelSelectPanel levelSelectPanel; 

	public MapPanel(){
		this.setPrefSize(1200, 800);
		
		mapHandler = new MapHandler(this);
		
		//bg
		ImageView imgV = new ImageView(Images.MAP_BG);
		this.getChildren().add(imgV);
		
		//landBtn
		landGroup = new Group();
		
		home = new LandButton(0);
		home.setLayoutX(6);
		home.setLayoutY(93);
		
		level1 = new LandButton(1);
		level1.setLayoutX(258);
		level1.setLayoutY(298);
		
		level2 = new LandButton(2);
		level2.setLayoutX(511);
		level2.setLayoutY(495);
		
		level3 = new LandButton(3);
		level3.setLayoutX(807);
		level3.setLayoutY(381);
		
		level4 = new LandButton(4);
		level4.setLayoutX(570);
		level4.setLayoutY(98);
		
		level5 = new LandButton(5);
		level5.setLayoutX(902);
		level5.setLayoutY(26);
		
		landGroup.getChildren().addAll(home, level5, level4, level3, level2, level1);
		this.getChildren().add(landGroup);
		
		//bridge
		bridgeGroup = new Group();
		
		BridgeView bridge1 = new BridgeView(true);
		bridge1.setLayoutX(188);
		bridge1.setLayoutY(280);
		
		BridgeView bridge2 = new BridgeView(true);
		bridge2.setLayoutX(422);
		bridge2.setLayoutY(487);
		
		BridgeView bridge3 = new BridgeView(false);
		bridge3.setLayoutX(759);
		bridge3.setLayoutY(484);
		
		BridgeView bridge4 = new BridgeView(true);
		bridge4.setLayoutX(732);
		bridge4.setLayoutY(340);
		
		BridgeView bridge5 = new BridgeView(false);
		bridge5.setLayoutX(810);
		bridge5.setLayoutY(203);
		
		bridgeGroup.getChildren().addAll(bridge1, bridge2, bridge3, bridge4, bridge5);
		this.getChildren().add(bridgeGroup);
		
		//cloud
		cloudGroup = new Group();
		
		ImageView cloud0 =  new ImageView(Images.MAP_CLOUD_0);
		cloud0.setFitWidth(637);
		cloud0.setPreserveRatio(true);
		cloud0.setLayoutX(-360);
		cloud0.setLayoutY(262);
		
		ImageView cloud1 =  new ImageView(Images.MAP_CLOUD_1);
		cloud1.setFitWidth(606);
		cloud1.setPreserveRatio(true);
		cloud1.setLayoutX(202);
		cloud1.setLayoutY(523);
		
		ImageView cloud2 =  new ImageView(Images.MAP_CLOUD_2);
		cloud2.setFitWidth(356);
		cloud2.setPreserveRatio(true);
		cloud2.setLayoutX(514);
		cloud2.setLayoutY(340);
		
		ImageView cloud3 =  new ImageView(Images.MAP_CLOUD_3);
		cloud3.setFitWidth(684);
		cloud3.setPreserveRatio(true);
		cloud3.setLayoutX(809);
		cloud3.setLayoutY(529);
		
		ImageView cloud4 =  new ImageView(Images.MAP_CLOUD_4);
		cloud4.setFitWidth(541);
		cloud4.setPreserveRatio(true);
		cloud4.setLayoutX(1005);
		cloud4.setLayoutY(180);
		
		cloudGroup.getChildren().addAll(cloud0, cloud1, cloud2, cloud3, cloud4);
		this.getChildren().add(cloudGroup);

		//fog
		fogs2 = new FogGroup(2);
		fogs3 = new FogGroup(3);
		fogs4 = new FogGroup(4);
		fogs5 = new FogGroup(5);
		this.getChildren().addAll(fogs2, fogs3, fogs4, fogs5);
		
		//select panel
		levelSelectPanel = new LevelSelectPanel(mapHandler);
		levelSelectPanel.setLayoutX(400);
		levelSelectPanel.setLayoutY(250);
		this.getChildren().add(levelSelectPanel);
		
		//TODO
		updateMap(new boolean[]{true, false, false, false, false});
	}
	
	//内部类
	public class LandButton extends Button{
		public int levelNum;
		private DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.WHITE, 0, 1, 0, 0);
		private ColorAdjust light = new ColorAdjust();
		
		public LandButton(int num){
			this.levelNum = num;
			ImageView imgV = new ImageView(Images.MAP_LAND[num]);
			switch(num){
				case 0: imgV.setFitWidth(313);break;
				case 1: imgV.setFitWidth(294);break;
				case 2: imgV.setFitWidth(294);break;
				case 3: imgV.setFitWidth(302);break;
				case 4: imgV.setFitWidth(284);break;
				case 5: imgV.setFitWidth(287);break;
			}
			imgV.setPreserveRatio(true);
			this.setGraphic(imgV);
			
			shadow.setInput(light);
			this.setEffect(shadow);
			this.setOnMouseEntered(mapHandler.buttonEnterEvent);
			this.setOnMouseExited(mapHandler.buttonExitEvent);
			if(num == 0){
				this.setOnMouseClicked(mapHandler.homeEvent);
			}else{
				this.setOnMouseClicked(mapHandler.levelSelectEvent);
			}
		}
		
		public void setHighlight(){
	    	  Timeline effectTL= new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(light.brightnessProperty(), 0)),
						new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0)),
						new KeyFrame(Duration.millis(300), new KeyValue(light.brightnessProperty(), 0.2,  Interpolator.EASE_IN)),
						new KeyFrame(Duration.millis(300), new KeyValue(shadow.radiusProperty(), 3,  Interpolator.EASE_IN))
						);
	    	  effectTL.play();
		}
		public void setNormal(){
			 Timeline effectTL= new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(light.brightnessProperty(), 0.2)),
						new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 3)),
						new KeyFrame(Duration.millis(300), new KeyValue(light.brightnessProperty(), 0,  Interpolator.EASE_IN)),
						new KeyFrame(Duration.millis(300), new KeyValue(shadow.radiusProperty(), 0,  Interpolator.EASE_IN))
						);
	    	  effectTL.play();
		}
	}
	
	public class BridgeView extends ImageView{
		public BridgeView(boolean flip){
			super(Images.MAP_BRIDGE);
			this.setFitWidth(148);
			this.setPreserveRatio(true);
			if (!flip){
				this.setScaleX(-1);
			}
		}
		
		public void setAppear(){
			this.setVisible(true);
			if (this.opacityProperty().intValue() == 0) {
				FadeTransition ft = new FadeTransition(Duration.millis(2000), this);
				ft.setFromValue(0);
				ft.setToValue(1);
				ft.play();
			}
		}
	}
	
	public class FogGroup extends Group{
		public FogGroup(int num){
			int foglength = Images.MAP_FOG[num-2].length;
			for(int i=0; i<foglength; i++){
				ImageView fogImg = init(num, i);
				this.getChildren().add(fogImg);
			}
		}
		
		private ImageView init(int num, int i){
			Image[] fogs = Images.MAP_FOG[num-2];
			ImageView imgV = new ImageView(fogs[i]);
			imgV.setPreserveRatio(true);
			imgV.setSmooth(true);
			switch(num){
			case 2:
				switch(i){
				case 0:
					imgV.setFitWidth(835);
					imgV.setLayoutX(70);
					imgV.setLayoutY(460);
					break;
				case 1:
					imgV.setFitWidth(831);
					imgV.setLayoutX(367);
					imgV.setLayoutY(451);
				}
				break;
			case 3:
				switch(i){
				case 0:
					imgV.setFitWidth(518);
					imgV.setLayoutX(739-50);
					imgV.setLayoutY(363-50);
					break;
				case 1:
					imgV.setFitWidth(651);
					imgV.setLayoutX(748-50);
					imgV.setLayoutY(239-50);
					break;
				}
				break;
			case 4:
				switch(i){
				case 0:
					imgV.setFitWidth(518);
					imgV.setLayoutX(489-50);
					imgV.setLayoutY(25-50);
					break;
				case 1:
					imgV.setFitWidth(606);
					imgV.setLayoutX(383-50);
					imgV.setLayoutY(160-50);
					break;
				case 2:
					imgV.setFitWidth(494);
					imgV.setLayoutX(537-55);
					imgV.setLayoutY(288-55);
					break;
				}
				break;
			case 5:
				switch(i){
				case 0:
					imgV.setFitWidth(518);
					imgV.setLayoutX(817-50);
					imgV.setLayoutY(0-50);
					break;
				case 1:
					imgV.setFitWidth(831);
					imgV.setLayoutX(836-55);
					imgV.setLayoutY(59-55);
					break;
				}
				break;
			}
			return imgV;
		}
		
		public void setFade(){
			Timeline tl = new Timeline();
			for(int i=0; i<this.getChildren().size(); i++){
				if (i%2 == 0){
					ImageView fog = (ImageView)this.getChildren().get(i);
					tl.getKeyFrames().add(
							new KeyFrame(Duration.millis(3000), new KeyValue(fog.layoutXProperty(), -fog.getFitWidth())));
				}else{
					ImageView fog = (ImageView)this.getChildren().get(i);
					tl.getKeyFrames().add(
							new KeyFrame(Duration.millis(3000), new KeyValue(fog.layoutXProperty(), 1200)));
				}
			}
			tl.play();
		}
	}
	
	//更新解锁的关卡
	public void updateMap(boolean[] isUnlock){
		for (int i=0; i<5; i++){
			BridgeView bridge = (BridgeView) bridgeGroup.getChildren().get(i);
			bridge.setVisible(isUnlock[i]);
			if(!isUnlock[i]){
				bridge.setOpacity(0);
			}
		}
	}
	
	public void UnlockLevel(int level){
		if(level>1 && level<6){
			fogs2.setFade();
			BridgeView bridge = (BridgeView) bridgeGroup.getChildren().get(level-1);
			bridge.setAppear();
		}
	}
}
