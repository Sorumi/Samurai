package view.guide;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import view.MenuPanel;
import view.SystemButton;
import view.eventhandler.GuideHandler;

public class GuideGroup extends Group {
	
	private SystemButton closeBtn;
	private Button previousBtn;
	private Button nextBtn;
	private Group buttonGroup;
	
	public int currentPage;
	private GuidePanel[] pages;
	private GuideHandler guideHandler;
	
	public GuideGroup(){
		
		currentPage = 0;
		
		guideHandler = new GuideHandler(this);
		GuidePanel guidePanel0= new GuidePanel0();		
		GuidePanel guidePanel1= new GuidePanel1();
		GuidePanel guidePanel2= new GuidePanel2();
		GuidePanel guidePanel3= new GuidePanel3();
		GuidePanel guidePanel4= new GuidePanel4();
		
		pages = new GuidePanel[]{guidePanel0, guidePanel1, guidePanel2, guidePanel3, guidePanel4};
		this.getChildren().addAll(guidePanel4, guidePanel3, guidePanel2, guidePanel1, guidePanel0);
		
		buttonGroup = new Group();
		
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				GuideGroup.this.setVisible(false);
				MenuPanel menu = (MenuPanel) GuideGroup.this.getParent();
				menu.samuraiTimer.start();
			}
		});
		
		previousBtn = new Button("上一页");
		previousBtn.setPrefSize(100, 40);
		previousBtn.setLayoutX(100);
		previousBtn.setLayoutY(662);				
		previousBtn.setId("Aload-btn");
		previousBtn.setOnMouseEntered(guideHandler.previousBtnEnterEvent);
		previousBtn.setOnMouseExited(guideHandler.previousBtnExitEvent);
		previousBtn.setOnMouseClicked(guideHandler.previousBtnClickEvent);
		
		nextBtn = new Button("下一页");
		nextBtn.setPrefSize(100, 40);
		nextBtn.setLayoutX(1000);
		nextBtn.setLayoutY(662);
		nextBtn.setId("Asave-btn");
		nextBtn.setOnMouseEntered(guideHandler.nextBtnEnterEvent);
		nextBtn.setOnMouseExited(guideHandler.nextBtnExitEvent);
		nextBtn.setOnMouseClicked(guideHandler.nextBtnClickEvent);
		btnAbled(0);
		btnAbled(1);
		
		buttonGroup.getChildren().addAll(closeBtn, previousBtn, nextBtn);
		this.getChildren().add(buttonGroup);
		
		this.setPage(0);
	}
	
	public void btnPressed(int num) {
		if (num == 0) {
			previousBtn.setLayoutY(666);
			previousBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 4);");
		} else {
			nextBtn.setLayoutY(666);
			nextBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 4);");
		}
	}

	public void btnAbled(int num) {
		if (num == 0) {
			previousBtn.setLayoutY(662);
			previousBtn.setStyle("-fx-effect: dropshadow(gaussian, #AFD5D1, 0, 0, 0, 8);");
		} else {
			nextBtn.setLayoutY(662);
			nextBtn.setStyle("-fx-effect: dropshadow(gaussian, #DDB4B0, 0, 0, 0, 8);");
		}
	}
	
	public void setPage(int page){
//		System.out.println("page: " + page);
		if(page>=0 && page<6){
			previousBtn.setVisible(true);
			nextBtn.setVisible(true);
			pages[page].toFront();
			buttonGroup.toFront();
			if(page == 0){
				previousBtn.setVisible(false);
			}else if(page == 5){
				nextBtn.setVisible(false);
			}
			currentPage = page;
		}
	}
}
