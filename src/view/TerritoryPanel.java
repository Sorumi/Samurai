package view;

import java.util.Random;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
	private Button customizeBtn;


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

	private GaussianBlur blur;

	private WeatherSelectPanel weatherPanel;

//	private int[] samuraiProperties_1;
//	private int[] samuraiProperties_2;
//	private int[] samuraiProperties_3;

//	private int[] bloodTotal = new int[4];

	// weather
	// private RainGroup rain;

	public TerritoryPanel() {
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setStyle("-fx-background-color: #eeeeee");

		territoryGroup = new Group();

		territoryBg = new TerritoryBackground();
		territoryGroup.getChildren().add(territoryBg);

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
		territoryGroup.getChildren().add(exitBtn);

		// save btn
		saveBtn = new SystemButton(1);
		saveBtn.setLayoutX(1055);
		saveBtn.setLayoutY(25);
		saveBtn.setOnMouseClicked(territoryHandler.archiveEvent);
		territoryGroup.getChildren().add(saveBtn);

		// campsite
		ImageView campsiteImg = new ImageView(Images.TERRITORY_CAMPSITE);
		campsiteImg.setFitWidth(268);
		campsiteImg.setPreserveRatio(true);

		campsiteBtn = new TerritoryButton();
		campsiteBtn.setGraphic(campsiteImg);
		campsiteBtn.setLayoutX(511);
		campsiteBtn.setLayoutY(268);
		campsiteBtn.setOnMouseClicked(territoryHandler.campsiteEvent);

		// smithy
		ImageView smithyImg = new ImageView(Images.TERRITORY_SMITHY);
		smithyImg.setFitWidth(302);
		smithyImg.setPreserveRatio(true);

		smithyBtn = new TerritoryButton();
		smithyBtn.setGraphic(smithyImg);
		smithyBtn.setLayoutX(680);
		smithyBtn.setLayoutY(6);
		smithyBtn.setOnMouseClicked(territoryHandler.smithyEvent);

		// store
		ImageView storeImg = new ImageView(Images.TERRITORY_STORE);
		storeImg.setFitWidth(227);
		storeImg.setPreserveRatio(true);

		storeBtn = new TerritoryButton();
		storeBtn.setGraphic(storeImg);
		storeBtn.setLayoutX(200);
		storeBtn.setLayoutY(293);
		storeBtn.setOnMouseClicked(territoryHandler.storeEvent);

		// shop
		ImageView shopImg = new ImageView(Images.TERRITORY_SHOP);
		shopImg.setFitWidth(242);
		shopImg.setPreserveRatio(true);

		shopBtn = new TerritoryButton();
		shopBtn.setGraphic(shopImg);
		shopBtn.setLayoutX(351);
		shopBtn.setLayoutY(34);
		shopBtn.setOnMouseClicked(territoryHandler.shopSelectEvent);

		//customize
		customizeBtn = new Button("Customize");
//		customizeBtn.setGraphic(customizeImg);
		customizeBtn.setLayoutX(500);
		customizeBtn.setLayoutY(500);
		customizeBtn.setOnMouseClicked(territoryHandler.customizeEvent);
		
		// flag
		ImageView flagImg = new ImageView(Images.TERRITORY_FLAG);
		flagImg.setFitWidth(95);
		flagImg.setPreserveRatio(true);

		flagBtn = new TerritoryButton();
		flagBtn.setGraphic(flagImg);
		flagBtn.setLayoutX(882);
		flagBtn.setLayoutY(446);
		flagBtn.setOnMouseClicked(territoryHandler.flagEvent);

		shopSelectPanel = new ShopSelectPanel(territoryHandler);
		shopSelectPanel.setVisible(false);

		territoryGroup.getChildren().addAll(campsiteBtn, smithyBtn, storeBtn, flagBtn, shopBtn, customizeBtn);
		stateHandler = new StateHandler(this);
		statePanel = new StatePanel(stateHandler, 2);
		territoryGroup.getChildren().add(statePanel);

		// samurai
		samurai1 = new SamuraiView(1, 2);
		samurai1.setLayoutX(720);
		samurai1.setLayoutY(520);
		samurai1.setOnMouseEntered(stateHandler.showStatePanelInT);
		samurai1.setOnMouseExited(stateHandler.closeStatePanelInT);

		samurai2 = new SamuraiView(2, 2);
		samurai2.setLayoutX(560);
		samurai2.setLayoutY(520);
		samurai2.setOnMouseEntered(stateHandler.showStatePanelInT);
		samurai2.setOnMouseExited(stateHandler.closeStatePanelInT);

		samurai3 = new SamuraiView(3, 2);
		samurai3.setLayoutX(400);
		samurai3.setLayoutY(520);
		samurai3.setOnMouseEntered(stateHandler.showStatePanelInT);
		samurai3.setOnMouseExited(stateHandler.closeStatePanelInT);

		territoryGroup.getChildren().addAll(samurai1, samurai2, samurai3);

		// frontground
		territoryFg = new TerritoryFrontground();
		territoryGroup.getChildren().add(territoryFg);

		// weather select
		WeatherHandler weatherHandler = new WeatherHandler(this);
		WeatherSelectPanel weatherPanel = new WeatherSelectPanel(weatherHandler);
		weatherPanel.setLayoutX(1125);
		weatherPanel.setLayoutY(445);// 445
		territoryGroup.getChildren().add(weatherPanel);

		// money
		moneyPanel = new MoneyPanel();
		moneyPanel.setLayoutX(50);
		moneyPanel.setLayoutY(700);

		// blur
		blur = new GaussianBlur(0);
		territoryGroup.setEffect(blur);

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
		private DropShadow shadow = new DropShadow(BlurType.GAUSSIAN, Color.WHITE, 0, 1, 0, 0);
		private ColorAdjust light = new ColorAdjust();

		public TerritoryButton() {
			shadow.setInput(light);

			this.setEffect(shadow);
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
		samurai1.blink(isAnimate);
		samurai2.blink(isAnimate);
		samurai3.blink(isAnimate);
	}

	public void setRandomWeather() {
		Random random = new Random();
		int x = random.nextInt(5) + 1;
		setWeather(x);
		if(x==4){
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

	// public void set6Properties() {
	// this.samuraiProperties_1 =
	// this.territoryHandler.getTerritoryController().get6Properties(1);
	// this.samuraiProperties_2 =
	// this.territoryHandler.getTerritoryController().get6Properties(2);
	// this.samuraiProperties_3 =
	// this.territoryHandler.getTerritoryController().get6Properties(3);
	// }

	// public void setBloodTotal() {
	// for (int i = 1; i <= 3; i++) {
	// this.bloodTotal[i] =
	// }
	// }

	public TerritoryHandler getTerritoryHandler() {
		return this.territoryHandler;
	}

}
