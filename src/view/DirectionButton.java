package view;

import javax.swing.Icon;
import javax.swing.JButton;

import view.listener.GameListener;

public class DirectionButton extends JButton {

	private Icon image;
	private Icon imageHL;
	
	public DirectionButton(int direction, GameListener gamelistener){
		this.image = Images.DIRECTION[direction];
		this.imageHL = Images.DIRECTION_HL[direction];
		this.setIcon(image);
		this.setBorderPainted(false);  
		this.setContentAreaFilled(false);  
		this.setSize(image.getIconWidth(), image.getIconHeight());
		this.addMouseListener(gamelistener);
	}
	
	public void setHighLight(boolean isHL){
		if(isHL){
			this.setIcon(imageHL);
		}else{
			this.setIcon(image);
		}
	}
}
