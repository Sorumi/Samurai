package view.smithy;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GameColor;
import view.eventhandler.SmithyHandler;

public abstract class SmithyItemWrapper extends Pane{

	protected SmithyHandler smithyHandler;
	
	protected int num;//0:spear 1:sword 2:battleax 3:shuriken 4:bow and arrow
	protected Group lockGroup;
	protected Group buildGroup;

	public SmithyItemWrapper(int num, SmithyHandler smithyHandler){
		this.smithyHandler = smithyHandler;
		this.setStyle("-fx-background-color: " + GameColor.getWeaponColorString(num));
		
		this.setPrefSize(1000, 700);
		this.setLayoutX(150);
		this.setLayoutY(50);
		this.setId("smithy-wrapper");
		
		buildGroup = new Group();
		lockGroup = new Group();		
		lockGroup.setOpacity(0.5);
		
		this.getChildren().addAll(buildGroup, lockGroup);
	}
	
	protected void initWeaponView(){
		this.addClickEvent();
		this.setLock();
	}
	
	private void addClickEvent(){
		for(int i=0; i<buildGroup.getChildren().size(); i++){
			SmithyItemView tmpItem = (SmithyItemView) buildGroup.getChildren().get(i);
			tmpItem.weaponGroup.setOnMouseClicked(smithyHandler.itemClickEvent);
		}
	}
	
	private void setLock(){
		for(int i=0; i<lockGroup.getChildren().size(); i++){
			SmithyItemView tmpItem = (SmithyItemView) lockGroup.getChildren().get(i);
			tmpItem.weapon.setOpacity(0.1);
		}
	}
}
