package view.guide;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import view.GameColor;
import view.Images;

public class GuidePanel4 extends GuidePanel{
	private Label mainLabel1;
	private Label mainLabel2;
	private Label explainLabel1;
	private Label explainLabel2;
	private Label explainLabel3;
	private Label explainLabel4;
	
	private Group HP; 
	private ImageView coin;
	private Group experience; 
	private Group stateIconGroup;
	private Group stateExplain; 
	public GuidePanel4(){
		mainLabel1 = new Label("故事模式");
		mainLabel1.setLayoutX(100);
		mainLabel1.setLayoutY(100);
		mainLabel1.setId("main-label");
		
		mainLabel2 = new Label("属性参数");
		mainLabel2.setLayoutX(100);
		mainLabel2.setLayoutY(250);
		mainLabel2.setId("main-label");
		
		explainLabel1 = new Label("故事模式是一个在游戏中可以得到道具，材料，进行武器、护甲合成的冒险剧情模式，其中物品的描述满足了许多玩家的收集欲望。");
		explainLabel1.setLayoutX(100);
		explainLabel1.setLayoutY(130);
		explainLabel1.setPrefSize(800, 172);
		explainLabel1.setId("explain-label");
		
		explainLabel2 = new Label("HP值：武士的生命值，小于等于零之后武士将会被击退。");
		explainLabel2.setLayoutX(200);
		explainLabel2.setLayoutY(290);
		explainLabel2.setPrefSize(400, 80);
		explainLabel2.setId("explain-label");
		
		explainLabel3 = new Label("金钱：用来购买道具。");
		explainLabel3.setLayoutX(200);
		explainLabel3.setLayoutY(430);
		explainLabel3.setPrefSize(400, 41);
		explainLabel3.setId("explain-label");
		
		explainLabel4 = new Label("经验值：决定武士是否可以升级。");
		explainLabel4.setLayoutX(200);
		explainLabel4.setLayoutY(554);
		explainLabel4.setPrefSize(400, 40);
		explainLabel4.setId("explain-label");
		
		Circle bgCircle = new Circle();
		bgCircle.setCenterX(30);
		bgCircle.setRadius(30);
		bgCircle.setStroke(Color.WHITE);
		bgCircle.setStrokeWidth(2);
		bgCircle.setStrokeType(StrokeType.OUTSIDE);
		bgCircle.setFill(Color.WHITE);
		
		Arc bloodArc = new Arc();
		bloodArc.setCenterX(30);
		bloodArc.setRadiusX(30);
		bloodArc.setRadiusY(30);
		bloodArc.setStartAngle(0);
		bloodArc.setLength(-270);
		bloodArc.setType(ArcType.ROUND);
		bloodArc.setFill(GameColor.getOtherColor(3));
		
		Circle centerCircle = new Circle();
		centerCircle.setCenterX(30);
		centerCircle.setRadius(26);
		centerCircle.setFill(Color.WHITE);
		HP = new Group();
		HP.getChildren().addAll(bgCircle, bloodArc, centerCircle); 
		HP.setLayoutX(100);
		HP.setLayoutY(320);
		
		coin = new ImageView(Images.COIN);
		coin.setFitWidth(30);
		coin.setPreserveRatio(true);
		coin.setLayoutX(109);
		coin.setLayoutY(426);
		
		Rectangle exRect = new Rectangle();
		exRect.setWidth(60);
		exRect.setHeight(20);
		exRect.setArcWidth(20);
		exRect.setArcHeight(20);
		exRect.setFill(Color.web("#f9f9f9"));
				
		Rectangle fillRect = new Rectangle();
		fillRect.setWidth(30);
		fillRect.setHeight(20);
		fillRect.setArcWidth(20);
		fillRect.setArcHeight(20);
		fillRect.setFill(Color.web("#ddedff"));
		experience = new Group();
		experience.getChildren().addAll(exRect, fillRect);
		experience.setLayoutX(103);
		experience.setLayoutY(552);
				
		stateIconGroup = new Group();
		stateIconGroup.setLayoutX(629);
		stateIconGroup.setLayoutY(295);
		for(int i=0;i<6;i++){
			ImageView stateIcon = new ImageView(Images.STATE_ICON[i]);
			stateIcon.setFitWidth(25);
			stateIcon.setPreserveRatio(true);
			stateIcon.setLayoutX(0);
			stateIcon.setLayoutY(57*i);
			stateIconGroup.getChildren().add(stateIcon);
		}
		
		stateExplain = new Group();
		stateExplain.setLayoutX(687);
		stateExplain.setLayoutY(295);
		for(int i=0;i<6;i++){
			Label state = new Label();
			switch(i){
			case 0:state.setText("等级：武士的等级，等级越高，基本属性越高。");break;
			case 1:state.setText("攻击力：武士的攻击力指标。");break;
			case 2:state.setText("护甲值：武士的防御力指标。");break;
			case 3:state.setText("暴击率：决定了武士攻击时暴击的几率。");break;
			case 4:state.setText("闪避率：武士在被攻击时躲闪的可能性。");break;
			case 5:state.setText("护甲穿透：武士在攻击时无视敌方武士护甲的值。");break;
			}
			state.setLayoutX(0);
			state.setLayoutY(58*i);
			state.setPrefSize(400, 40);
			state.setId("explain-label");
			stateExplain.getChildren().add(state);
		}
		this.getChildren().addAll(mainLabel1, mainLabel2, explainLabel1, explainLabel2, explainLabel3, explainLabel4,HP, coin,
				experience, stateIconGroup, stateExplain);
		this.setVisible(true);
	}

}
