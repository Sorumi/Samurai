package view;

import javax.swing.Icon;
import javax.swing.JButton;

import view.listener.GameListener;

public class ActionButton extends JButton {

	private Icon image;
	
	public ActionButton(Icon image, GameListener gamelistener){
		this.image = image;
		this.setIcon(image);
		this.setBorderPainted(false);  
		this.setContentAreaFilled(false);  
		this.setSize(image.getIconWidth(), image.getIconHeight());
		this.addMouseListener(gamelistener);
	}
}
