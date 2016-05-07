package view.smithy;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import model.po.Weapon;
import view.GameColor;
import view.eventhandler.SmithyHandler;

public abstract class SmithyItemWrapper extends Pane{

	protected SmithyHandler smithyHandler;
	
	protected int num;//0:spear 1:sword 2:battleax 3:shuriken 4:bow and arrow
	protected Group lockGroup;
	protected Group buildGroup;

	protected ObservableList<SmithyItemView> list;
	
	public SmithyItemWrapper(int num, SmithyHandler smithyHandler){
		this.num = num;
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
		this.showState();
		this.closeState();
	
	}
	
	private void showState(){
		for(int i=0; i<buildGroup.getChildren().size(); i++){
			SmithyItemView tmpItem = (SmithyItemView) buildGroup.getChildren().get(i);
			tmpItem.weaponGroup.setOnMouseEntered(smithyHandler.showStatePanel);
		}
	}
	
	private void closeState(){ 
		for(int i=0; i<buildGroup.getChildren().size(); i++){
			SmithyItemView tmpItem = (SmithyItemView) buildGroup.getChildren().get(i);
			tmpItem.weaponGroup.setOnMouseExited(smithyHandler.closeStatePanel); 
		}
	}
	 
	
	private void addClickEvent(){
		for(int i=0; i<buildGroup.getChildren().size(); i++){
			SmithyItemView tmpItem = (SmithyItemView) buildGroup.getChildren().get(i);
			tmpItem.weaponGroup.setOnMouseClicked(smithyHandler.itemClickEvent);
			tmpItem.weapon.setOpacity(1);
		}
	}
	
	private void setLock(){
		for(int i=0; i<lockGroup.getChildren().size(); i++){
			SmithyItemView tmpItem = (SmithyItemView) lockGroup.getChildren().get(i);
			tmpItem.weapon.setOpacity(0.1);
		}
	}
	
	public void updateItem(ArrayList<Weapon> weapons) {
		// TODO Auto-generated method stub
		for (Weapon weapon : weapons){
			if(weapon.getType()/100 == num){
				for (SmithyItemView view : list){
					if (view.itemNum == weapon.getType()){
						buildGroup.getChildren().add(view);
						lockGroup.getChildren().remove(view);
					}
				}
			}
		}
		initWeaponView();
	}

}
