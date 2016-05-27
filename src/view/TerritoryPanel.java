package view;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.StoryModel;
import musics.Musics;
import view.background.TerritoryBackground;
import view.background.TerritoryFrontground;
import view.background.WeatherSelectPanel;
import view.campsite.CampsitePanel;
import view.eventhandler.StateHandler;
import view.eventhandler.TerToMenuSelectHandler;
import view.eventhandler.TerritoryHandler;
import view.eventhandler.WeatherHandler;
import view.items.NumenView;
import view.shop.ShopPanel;
import view.shop.ShopSelectPanel;
import view.smithy.SmithyPanel;
import view.store.StorePanel;

public class TerritoryPanel extends Pane {

	// storeBtn: 仓库
	// smithyBtn: 铁匠铺
	// campsiteBtn: 营地
	//
	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;

	private SystemButton exitBtn;
	private SystemButton saveBtn;

	private TerritoryHandler territoryHandler;
	private Group territoryGroup;

	public TerritoryBackground territoryBg;
	public TerritoryFrontground territoryFg;

	private TerritoryButton campsiteBtn;
	private TerritoryButton smithyBtn;
	private TerritoryButton storeBtn;
	private TerritoryButton shopBtn;
	private TerritoryButton flagBtn;
	private TerritoryButton customizeBtn;

	public CampsitePanel campsitePanel;
	public SmithyPanel smithyPanel;
	public StorePanel storePanel;
	public ShopPanel shopPanel;
	public ShopSelectPanel shopSelectPanel;

	public ArchivePanel archivePanel;
	public StatePanel statePanel;
	public MoneyPanel moneyPanel;
	public TerToMenuSelectPanel terToMenuSelectPanel;
	public TerToMenuSelectHandler terToMenuSelectHandler;

	protected StateHandler stateHandler;

	public SamuraiView samurai1;
	public SamuraiView samurai2;
	public SamuraiView samurai3;
	private NumenView numen;
	
	private ParallelTransition allAnimation;

	private GaussianBlur blur;

	public WeatherSelectPanel weatherPanel;

	public TerritoryPanel() {
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// this.setStyle("-fx-background-color: #eeeeee");

		territoryGroup = new Group();

		territoryBg = new TerritoryBackground();

		territoryHandler = new TerritoryHandler(this);
		terToMenuSelectHandler = new TerToMenuSelectHandler(this);
		terToMenuSelectPanel = new TerToMenuSelectPanel(terToMenuSelectHandler);

		// exit btn
		exitBtn = new SystemButton(0);
		exitBtn.setLayoutX(1125);
		exitBtn.setLayoutY(25);
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// StoryPanel storyPanel = (StoryPanel)
				// TerritoryPanel.this.getParent();
				// Pane basePanel = (Pane) storyPanel.getParent();
				// basePanel.getChildren().remove(storyPanel);
				// MenuPanel menu = (MenuPanel) basePanel.getChildren().get(0);
				// menu.samuraiTimer.start();
				TerritoryPanel.this.terToMenuSelectPanel.setVisible(true);
			}
		});

		// save btn
		saveBtn = new SystemButton(1);
		saveBtn.setLayoutX(1055);
		saveBtn.setLayoutY(25);
		saveBtn.setOnMouseClicked(territoryHandler.archiveEvent);

		// campsite
		ImageView campsiteImg = new ImageView(Images.TERRITORY_CAMPSITE);
		campsiteImg.setFitWidth(214);
		campsiteImg.setPreserveRatio(true);

		campsiteBtn = new TerritoryButton(0);
		campsiteBtn.setGraphic(campsiteImg);
		campsiteBtn.setLayoutX(497);
		campsiteBtn.setLayoutY(262);

		// smithy
		ImageView smithyImg = new ImageView(Images.TERRITORY_SMITHY);
		smithyImg.setFitWidth(242);
		smithyImg.setPreserveRatio(true);

		smithyBtn = new TerritoryButton(1);
		smithyBtn.setGraphic(smithyImg);
		smithyBtn.setLayoutX(678);
		smithyBtn.setLayoutY(43);

		// store
		ImageView storeImg = new ImageView(Images.TERRITORY_STORE);
		storeImg.setFitWidth(182);
		storeImg.setPreserveRatio(true);

		storeBtn = new TerritoryButton(2);
		storeBtn.setGraphic(storeImg);
		storeBtn.setLayoutX(377);
		storeBtn.setLayoutY(51);

		// shop
		ImageView shopImg = new ImageView(Images.TERRITORY_SHOP);
		shopImg.setFitWidth(194);
		shopImg.setPreserveRatio(true);

		shopBtn = new TerritoryButton(3);
		shopBtn.setGraphic(shopImg);
		shopBtn.setLayoutX(787);
		shopBtn.setLayoutY(274);

		// customize
		ImageView dojoImg = new ImageView(Images.TERRITORY_DOJO);
		dojoImg.setFitWidth(234);
		dojoImg.setPreserveRatio(true);

		customizeBtn = new TerritoryButton(4);
		customizeBtn.setGraphic(dojoImg);
		customizeBtn.setLayoutX(184);
		customizeBtn.setLayoutY(300);

		// flag
		ImageView flagImg = new ImageView(Images.TERRITORY_FLAG);
		flagImg.setFitWidth(95);
		flagImg.setPreserveRatio(true);

		flagBtn = new TerritoryButton(5);
		flagBtn.setGraphic(flagImg);
		flagBtn.setLayoutX(711);
		flagBtn.setLayoutY(442);
		
		shopSelectPanel = new ShopSelectPanel(territoryHandler);
		shopSelectPanel.setVisible(false);

		// state
		stateHandler = new StateHandler(this);
		statePanel = new StatePanel(stateHandler, 2);

		// samurai
		samurai1 = new SamuraiView(1, 2);
		samurai1.setLayoutX(580);
		samurai1.setLayoutY(520);
		samurai1.setOnMouseEntered(stateHandler.showStatePanelInT);
		samurai1.setOnMouseExited(stateHandler.closeStatePanelInT);

		samurai2 = new SamuraiView(2, 2);
		samurai2.setLayoutX(440);
		samurai2.setLayoutY(520);
		samurai2.setOnMouseEntered(stateHandler.showStatePanelInT);
		samurai2.setOnMouseExited(stateHandler.closeStatePanelInT);

		samurai3 = new SamuraiView(3, 2);
		samurai3.setLayoutX(300);
		samurai3.setLayoutY(520);
		samurai3.setOnMouseEntered(stateHandler.showStatePanelInT);
		samurai3.setOnMouseExited(stateHandler.closeStatePanelInT);

		samurai1.blink(false);
		samurai2.blink(false);
		samurai3.blink(false);
		
		// numen
		numen = new NumenView();
		numen.setLayoutY(500);
		TranslateTransition tt = new TranslateTransition(Duration.millis(2000), numen);
		tt.setFromX(750);
		tt.setToX(850);
		tt.setInterpolator(Interpolator.EASE_BOTH);
		tt.setCycleCount(Timeline.INDEFINITE);
		tt.setAutoReverse(true);
		
		allAnimation = new ParallelTransition(); 
		allAnimation.getChildren().addAll(tt, samurai1.getBlinkTL(), samurai2.getBlinkTL(), samurai3.getBlinkTL());
		allAnimation.play();
		
		// frontground
		territoryFg = new TerritoryFrontground();

		// weather select
		WeatherHandler weatherHandler = new WeatherHandler(this);
		weatherPanel = new WeatherSelectPanel(weatherHandler);
		weatherPanel.setLayoutX(1125);
		weatherPanel.setLayoutY(725);
		
		// money
		moneyPanel = new MoneyPanel();
		moneyPanel.setLayoutX(50);
		moneyPanel.setLayoutY(700);

		// blur
		blur = new GaussianBlur(0);
		territoryGroup.setEffect(blur);

		territoryGroup.getChildren().addAll(territoryBg, campsiteBtn, smithyBtn, storeBtn, flagBtn, shopBtn,
				customizeBtn, samurai1, samurai2, samurai3, numen, statePanel, territoryFg, weatherPanel, exitBtn,
				saveBtn);
		this.getChildren().addAll(territoryGroup, shopSelectPanel, moneyPanel);
		this.getChildren().add(terToMenuSelectPanel);
		this.terToMenuSelectPanel.setVisible(false);

		// init
		updateSamurai();
		updateMoney();
		this.setRandomWeather();

	}

	// 内部类
	public class TerritoryButton extends Button {

		public int num;

		private DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.WHITE, 0, 1, 0, 0);
		private ColorAdjust light = new ColorAdjust();

		public TerritoryButton(int num) {
			this.num = num;

			shadow.setInput(light);
			this.setEffect(shadow);
			this.setOnMouseClicked(territoryHandler.introduceEvent);
			this.setOnMouseEntered(territoryHandler.buttonEnterEvent);
			this.setOnMouseExited(territoryHandler.buttonExitEvent);
		}

		public void setHighlight() {
			Timeline effectTL = new Timeline(
					new KeyFrame(Duration.millis(300),
							new KeyValue(light.brightnessProperty(), 0.2, Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300), new KeyValue(shadow.radiusProperty(), 3, Interpolator.EASE_IN)));
			effectTL.play();
		}

		public void setNormal() {
			Timeline effectTL = new Timeline(
					new KeyFrame(Duration.millis(300),
							new KeyValue(light.brightnessProperty(), 0, Interpolator.EASE_IN)),
					new KeyFrame(Duration.millis(300), new KeyValue(shadow.radiusProperty(), 0, Interpolator.EASE_IN)));
			effectTL.play();
		}
	}

	public void startIntroduction(int num) {
		switch(num){
		case 0:
			numen.setDialog(3, "这是大本营中属于你的仓库，你的所有武器和护甲都会存放与此。合成了厉害的装备不要忘了更换哦~");
			campsiteBtn.setOnMouseClicked(territoryHandler.campsiteEvent);
			break;
		case 1:
			numen.setDialog(3, "工欲善其事，必先利其器，这里是铁匠铺哦，合成武器或者护甲都可以在这里进行。");
			smithyBtn.setOnMouseClicked(territoryHandler.smithyEvent);
			break;
		case 2:
			numen.setDialog(4, "材料是所有物质的最小单元，什么？你说你的物理老师不是这么说的？不对不对，这里可是武士的世界。这里就是存放材料的地方，快来欣赏一下你的战利品吧~");
			storeBtn.setOnMouseClicked(territoryHandler.storeEvent);
			break;
		case 3:
			numen.setDialog(4, "这里是商店，在敌我双方势均力敌的情况下，道具往往是致胜的关键~有不需要的材料也可以在这里出售，有句话怎么说的来着？在口袋里的钱才是真的钱~");
			shopBtn.setOnMouseClicked(territoryHandler.shopSelectEvent);
			break;
		case 4:
			numen.setDialog(3, "锵锵~，听到兵器碰撞的声音了么？出征前想要试试新装备和战术？没问题，武士村道场欢迎您的到来~");
			customizeBtn.setOnMouseClicked(territoryHandler.customizeEvent);
			break;
		case 5:
			numen.setDialog(3, "一切准备就绪后，就从这里开始出征吧！");
			flagBtn.setOnMouseClicked(territoryHandler.flagEvent);
			break;
		}
	}
	
	public void resetButtons(){
		campsiteBtn.setOnMouseClicked(territoryHandler.campsiteEvent);
		smithyBtn.setOnMouseClicked(territoryHandler.smithyEvent);
		storeBtn.setOnMouseClicked(territoryHandler.storeEvent);
		shopBtn.setOnMouseClicked(territoryHandler.shopSelectEvent);
		customizeBtn.setOnMouseClicked(territoryHandler.customizeEvent);
		flagBtn.setOnMouseClicked(territoryHandler.flagEvent);
	}

	public void updateMoney() {
		moneyPanel.setMoney(
				this.getTerritoryHandler().getTerritoryController().getStoryModel().getPropsStore().getMoney());
	}

	public void updateSamurai() {
		territoryHandler.updateSamurai();
	}

	public void setBlur(boolean isBlur) {
		if (isBlur) {
			this.blur.setRadius(7);
			territoryBg.stopAll();
			territoryFg.stopAll();
			setSamuraiAnimation(false);
		} else {
			updateSamurai();
			this.blur.setRadius(0);
			territoryBg.restartAll();
			territoryFg.restartAll();
			setSamuraiAnimation(true);
		}
	}

	public void setSamuraiAnimation(boolean isAnimate) {

		if(isAnimate){
			allAnimation.play();
		}else{
			allAnimation.pause();
			numen.removeDialog();
		}
	}

	public void setRandomWeather() {
		Random random = new Random();
		int x = random.nextInt(5) + 1;
		setWeather(x);
		if (x == 4) {
			Musics.playEffectMusic(0);
		}
	}

	public void setWeather(int num) {
		switch (num) {
		case 1:// sun
			territoryBg.removeAll();
			territoryFg.removeAll();
			territoryBg.setSky(0);
			territoryBg.setSun(true);
			territoryBg.restartAll();
			break;
		case 2:// moon and stars
			territoryBg.removeAll();
			territoryFg.removeAll();
			territoryBg.setSky(1);
			territoryBg.setMoon(true);
			territoryBg.setStars(true);
			territoryBg.restartAll();
			break;
		case 3:// stars
			territoryBg.removeAll();
			territoryFg.removeAll();
			territoryBg.setSky(1);
			territoryBg.setStars(true);
			territoryBg.restartAll();
			break;
		case 4:// rain
			territoryBg.removeAll();
			territoryFg.removeAll();
			territoryBg.setSky(2);
			territoryFg.setRain(700);
			break;
		case 5:// snow
			territoryBg.removeAll();
			territoryFg.removeAll();
			territoryBg.setSky(3);
			territoryFg.setSnow(500);
			break;
		}
	}

	public int[] get6PropertiesOfSamurai(int i) {
		if (i > 0 && i < 4) {
			return this.territoryHandler.getTerritoryController().get6Properties(i);
		} else {
			return new int[] { 0 };
		}
	}

	public int getBloodTotalOfSamurai(int samurai) {
		return this.territoryHandler.getTerritoryController().getBlood(samurai);
	}

	public int[] getExperienceOfSamurai(int i) {
		return new int[] { this.territoryHandler.getTerritoryController().getExperienceOfSamurai(i),
				this.territoryHandler.getTerritoryController().getNextLevelExperienceOfSamurai(i) };
	}
	
	public TerritoryHandler getTerritoryHandler() {
		return this.territoryHandler;
	}

}
