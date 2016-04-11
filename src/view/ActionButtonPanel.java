package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.listener.GameListener;

public class ActionButtonPanel extends JPanel {
	
	private final int BUTTONPANEL_WIDTH = 218;
	private final int BUTTONPANEL_HEIGHT = 300;
	
	private final int BUTTON_WIDTH = 50;

	private ActionButton moveButton;
	private ActionButton occupyButton;
	private ActionButton hideButton;
	private ActionButton exitButton;
	private ActionButton backButton;
	private DirectionPanel directionPanel;
	
	private SamuraiView currentSamurai;
	private GameListener gamelistener;
	
	public ActionButtonPanel(GameListener gamelistener){
		this.gamelistener = gamelistener;
		moveButton = new ActionButton(Images.BUTTON_MOVE, gamelistener);
		occupyButton = new ActionButton(Images.BUTTON_OCCUPY, gamelistener);	
		hideButton = new ActionButton(Images.BUTTON_HIDE, gamelistener);
		exitButton = new ActionButton(Images.BUTTON_EXIT, gamelistener);
		backButton = new ActionButton(Images.BUTTON_BACK, gamelistener);

		this.setLayout(null);
		this.setSize(BUTTONPANEL_WIDTH, BUTTONPANEL_HEIGHT);
		this.setBackground(Color.gray);
		this.setOpaque(false);
		this.setVisible(false);
		
		moveButton.setLocation(0, 60);
		occupyButton.setLocation(40, 0);
		hideButton.setLocation(110, 0);
		exitButton.setLocation(150, 60);
		backButton.setLocation(150, 60);
		
		backButton.setVisible(false);
		
		directionPanel = new DirectionPanel(gamelistener);
		directionPanel.setLocation((BUTTONPANEL_WIDTH-directionPanel.getWidth())/2, 130);
		directionPanel.setVisible(false);
		
		this.add(moveButton);
		this.add(occupyButton);
		this.add(hideButton);
		this.add(exitButton);
		this.add(backButton);
		this.add(directionPanel);
	}
	
	public void setCurrentSamurai(SamuraiView samurai){
		this.currentSamurai = samurai;
		this.setVisible(false);
		this.setSecondary(false);
		this.setActualLocation();
	}
	
	public void setActualLocation(){
		this.setLocation(currentSamurai.getLocation().x +34 -getWidth()/2, currentSamurai.getLocation().y-70);
	}
	
	public ActionButton getMoveButton(){
		return this.moveButton;
	}
	public ActionButton getOccupyButton(){
		return this.occupyButton;
	}
	public ActionButton getHideButton(){
		return this.hideButton;
	}
	public ActionButton getExitButton(){
		return this.exitButton;
	}
	public ActionButton getBackButton(){
		return this.backButton;
	}
	public DirectionPanel getDirectionPanel(){
		return this.directionPanel;
	}
	//点击move occupy hide进入二级菜单
	public void setSecondary(boolean isVisible){
		backButton.setVisible(isVisible);
		exitButton.setVisible(!isVisible);
		moveButton.setVisible(!isVisible);
		occupyButton.setVisible(!isVisible);
		hideButton.setVisible(!isVisible);
		directionPanel.setVisible(isVisible);
	}
}
