package view;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Arrow extends JPanel{
	
	private BufferedImage image;
	private SamuraiView currentSamurai;
	
	public Arrow(){
		image = Images.ARROW;
		this.setSize(image.getWidth(), image.getHeight());
		this.setBackground(null);
		this.setOpaque(false);
	}
	
	public void setCurrentSamurai(SamuraiView samurai){
		this.currentSamurai = samurai;
		this.setLocation(currentSamurai.getLocation().x +34 -getWidth()/2, currentSamurai.getLocation().y-getHeight());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		if (image != null){
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}

	
}
