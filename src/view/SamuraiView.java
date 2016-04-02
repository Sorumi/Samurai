package view;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class SamuraiView extends JPanel {

	private int number;
	private BufferedImage image;
	
	private int x;
	private int y;
	
	public SamuraiView(int number, int x, int y){
		this.number = number;
		this.x = x;
		this.y = y;
	}
	
	
}
