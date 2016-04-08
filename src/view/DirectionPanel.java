package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.listener.GameListener;

public class DirectionPanel extends JPanel {

	private final int DIRECTION_WIDTH = 49;
	private final int DIRECTION_HEIGHT = 35;
	private final int DIRECTION_FIX = 6;
	
	private boolean canUp;
	private boolean canLeft;
	private boolean canRight;
	private boolean canDown;
	
	private DirectionButton upButton;
	private DirectionButton leftButton;
	private DirectionButton rightButton;
	private DirectionButton downButton;
	private DirectionButton[] buttons;
	
	private GameListener gamelistener;
	
	public DirectionPanel(GameListener gamelistener){

		upButton = new DirectionButton(0, gamelistener);
		leftButton = new DirectionButton(1, gamelistener);
		rightButton = new DirectionButton(2, gamelistener);
		downButton = new DirectionButton(3, gamelistener);
	
		buttons = new DirectionButton[]{upButton, leftButton, rightButton, downButton};
		
		upButton.setLocation(0, 0);
		leftButton.setLocation(0, DIRECTION_HEIGHT);
		rightButton.setLocation(DIRECTION_WIDTH+DIRECTION_FIX, 0);
		downButton.setLocation(DIRECTION_WIDTH+DIRECTION_FIX, DIRECTION_HEIGHT);
		
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
		this.setSize(DIRECTION_WIDTH*2+DIRECTION_FIX, DIRECTION_HEIGHT*2);
		
		this.add(upButton);
		this.add(leftButton);
		this.add(rightButton);
		this.add(downButton);
	}
	
	public DirectionButton getUpButton(){
		return this.upButton;
	}
	public DirectionButton getLeftButton(){
		return this.leftButton;
	}
	public DirectionButton getRightButton(){
		return this.rightButton;
	}
	public DirectionButton getDownButton(){
		return this.downButton;
	}
	public void setHighLight(int direction, boolean isHL){
		buttons[direction].setHighLight(isHL);
	}
	
}
