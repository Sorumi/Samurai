package view.guide;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class GuideGroup extends Group {

	private Button previousBtn;
	private Button nextBtn;
	
	public GuideGroup(){
		
		
		GuidePanel0 guidePanel0= new GuidePanel0();
		this.getChildren().add(guidePanel0);
		
		GuidePanel3 guidePanel3= new GuidePanel3();
		this.getChildren().add(guidePanel3);
		

		previousBtn = new Button("上一页");
		previousBtn.setPrefSize(100, 40);
		previousBtn.setLayoutX(100);
		previousBtn.setLayoutY(662);				
		previousBtn.setId("Aload-btn");
//		previousBtn.setOnMouseEntered(selectHandler.previousBtnEnterEvent);
//		previousBtn.setOnMouseExited(selectHandler.previousBtnExitEvent);

		nextBtn = new Button("下一页");
		nextBtn.setPrefSize(100, 40);
		nextBtn.setLayoutX(1000);
		nextBtn.setLayoutY(662);
		nextBtn.setId("Asave-btn");
//		nextBtn.setOnMouseEntered(selectHandler.nextBtnEnterEvent);
//		nextBtn.setOnMouseExited(selectHandler.nextBtnExitEvent);
		
		this.getChildren().addAll(previousBtn, nextBtn);
	}
}
