package view;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel{
	
	private int player;
	
	private CirclePanel circle;
	
	public PlayerPanel(int player, int timeInAll){
		
		this.player = player;
		this.setLayout(null);
		
		circle = new CirclePanel(player, timeInAll);
		circle.setLocation(0, 0);

		this.add(circle);
		
		this.setSize(300, 240);
		this.setLocation(0, 0);
	}

	public void setTimeRest(int timeRest){
		circle.setTimeRest(timeRest);
	}
	//setRound
}
