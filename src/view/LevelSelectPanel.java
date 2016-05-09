package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class LevelSelectPanel extends Pane{
	private int width = 400;
	private int height = 300;
	
	private int strokeWidth = 3;
	
	private boolean isAppear;
	
	private SystemButton closeBtn; 
	
	private Rectangle bgRect;
	private Circle centralCircle;	 
	private Circle materialCircleOne;
	private Circle materialCircleTwo;
	
	private Label levelName;
	private Label materialGet;
	private Label materialNameOne;
	private Label materialNameTwo;
	 
	private Button levelBtnOne;
	private Button levelBtnTwo;
	private Button levelBtnThree;
	
	public LevelSelectPanel(int itemNumOne, int itemNumTwo){
		this.setWidth(width);
		this.setHeight(height);
		
		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setWidth(400);
		bgRect.setHeight(300);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		
		centralCircle = new Circle();
		centralCircle.setCenterX(200.0);
		centralCircle.setRadius(50);
		centralCircle.setStroke(Color.ALICEBLUE);
		centralCircle.setStrokeWidth(strokeWidth);
		centralCircle.setStrokeType(StrokeType.OUTSIDE);
		centralCircle.setFill(Color.WHITE);
		
		levelName = new Label("关卡名称");
		levelName.setLayoutX(152);
		levelName.setLayoutY(70);
		levelName.setId("LevelName-label");
		
		materialGet = new Label("可获得素材"); 
		materialGet.setLayoutX(30);
		materialGet.setLayoutY(135);
		materialGet.setId("materialName-label");
		 
		materialNameOne = new Label("布料"); 
		materialNameOne.setLayoutX(215);
		materialNameOne.setLayoutY(135);
		materialNameOne.setId("materialName-label"); 
		
		materialNameTwo = new Label("木材"); 
		materialNameTwo.setLayoutX(335);
		materialNameTwo.setLayoutY(135);
		materialNameTwo.setId("materialName-label");
		

		
		materialCircleOne = new Circle();
		materialCircleOne.setCenterX(175);
		materialCircleOne.setCenterY(140);
		materialCircleOne.setRadius(25);
		materialCircleOne.setFill(GameColor.getMaterialColor(itemNumOne/10));
		materialCircleOne.setStroke(GameColor.getMaterialColor(itemNumOne/10+10));
		materialCircleOne.setStrokeType(StrokeType.INSIDE);
		materialCircleOne.setStrokeWidth(0);
		MaterialView materialOne = new MaterialView(itemNumOne);
		materialOne.setLayoutX(125);
		materialOne.setLayoutY(90);
		materialOne.setScaleX(0.5);
		materialOne.setScaleY(0.5);

		
		materialCircleTwo = new Circle();
		materialCircleTwo.setCenterX(295);
		materialCircleTwo.setCenterY(140);
		materialCircleTwo.setRadius(25);
		materialCircleTwo.setFill(GameColor.getMaterialColor(itemNumTwo/10));
		materialCircleTwo.setStroke(GameColor.getMaterialColor(itemNumTwo/10+10));
		materialCircleTwo.setStrokeType(StrokeType.INSIDE);
		materialCircleTwo.setStrokeWidth(0);
		MaterialView materialTwo = new MaterialView(itemNumTwo); 
		materialTwo.setLayoutX(245);
		materialTwo.setLayoutY(90);
		materialTwo.setScaleX(0.5);
		materialTwo.setScaleY(0.5);
		
		levelBtnOne = new Button("简 单");
		levelBtnOne.setPrefSize(100, 40);
		levelBtnOne.setId("Aload-btn");		
		levelBtnOne.setLayoutX(25);
		levelBtnOne.setLayoutY(220); 
		
		levelBtnTwo = new Button("普 通");
		levelBtnTwo.setPrefSize(100, 40);
		levelBtnTwo.setId("Aload-btn");		
		levelBtnTwo.setLayoutX(150);
		levelBtnTwo.setLayoutY(220);
		
		levelBtnThree = new Button("困 难");
		levelBtnThree.setPrefSize(100, 40);
		levelBtnThree.setId("Aload-btn");		
		levelBtnThree.setLayoutX(275);
		levelBtnThree.setLayoutY(220);
		
		 closeBtn = new SystemButton(0);
		    closeBtn.setLayoutX(375);
			closeBtn.setLayoutY(-25);
			closeBtn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					MapPanel parent = (MapPanel) LevelSelectPanel.this.getParent();
					parent.getChildren().remove(LevelSelectPanel.this);
//					parent.setBlur(false);
				}
			});
		
		this.getChildren().addAll(bgRect, centralCircle, levelName, materialGet, materialNameOne, materialNameTwo, materialCircleOne, materialCircleTwo, materialOne, materialTwo, levelBtnOne, levelBtnTwo, levelBtnThree, closeBtn);
		this.setVisible(false);
	}
	
	public void setAppear(boolean isAppear) {
		// TODO Auto-generated method stub
		this.isAppear = isAppear;
		this.setVisible(isAppear);
	}

}
