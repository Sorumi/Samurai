package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.listener.GameListener;

public class ActionButtonPanel extends JPanel {
	
	private final int BUTTONPANEL_WIDTH = 160;
	private final int BUTTONPANEL_HEIGHT = 220;
	
	private final int BUTTON_WIDTH = 50;

	private ActionButton moveButton;
	private ActionButton occupyButton;
	private ActionButton hideButton;
	private ActionButton exitButton;
	private ActionButton backButton;
	
	private SamuraiView currentSamurai;
	private GameListener gamelistener;
	
	public ActionButtonPanel(GameListener gamelistener){
		this.gamelistener = gamelistener;
		moveButton = new ActionButton(Images.BUTTON_MOVE, gamelistener);
		occupyButton = new ActionButton(Images.BUTTON_OCCUPY, gamelistener);	
		hideButton = new ActionButton(Images.BUTTON_HIDE, gamelistener);
		exitButton = new ActionButton(Images.BUTTON_EXIT, gamelistener);
		backButton = new ActionButton(Images.BUTTON_MOVE, gamelistener);

		this.setLayout(null);
		this.setSize(BUTTONPANEL_WIDTH, BUTTONPANEL_HEIGHT);
		this.setBackground(Color.gray);
		this.setOpaque(false);
		this.setVisible(false);
		
		moveButton.setLocation(0, 15);
		occupyButton.setLocation((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2, 0);
		hideButton.setLocation(BUTTONPANEL_WIDTH-BUTTON_WIDTH, 15);
		exitButton.setLocation((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2, BUTTONPANEL_HEIGHT-BUTTON_WIDTH);
		backButton.setLocation((BUTTONPANEL_WIDTH-BUTTON_WIDTH)/2, BUTTONPANEL_HEIGHT-BUTTON_WIDTH);
		
		this.add(moveButton);
		this.add(occupyButton);
		this.add(hideButton);
		this.add(exitButton);
		this.add(backButton);
	}
	
	public void setCurrentSamurai(SamuraiView samurai){
		this.currentSamurai = samurai;
		this.setLocation(currentSamurai.getLocation().x +34 -getWidth()/2, currentSamurai.getLocation().y-50);
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
	//设置返回按钮显现的接口
	//TODO
}
