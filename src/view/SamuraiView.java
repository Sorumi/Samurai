package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class SamuraiView extends JPanel {
	
    private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;

	private int chessBoardWidthOffset = (WINDOW_WIDTH-FIELD_WIDTH)/2 ;
	private int chessBoardHeightOffset = WINDOW_HEIGHT-FIELD_HEIGHT-FIELD_FIX;
	private int blockWidthOffset;
	private int blockHeightOffset;
	
	private final int selfWidthOffset = -34;
	private final int selfHeightOffset = -95;

	private int number;
	private BufferedImage image;
	private BufferedImage shadowImage;
	
	private int x;
	private int y;
	
	public SamuraiView(int number, int size, int x, int y){
  		
		this.number = number;
		this.image = Images.SAMURAI_CLASSIC[number];
		
		blockWidthOffset = FIELD_WIDTH / size / 2;
		blockHeightOffset = FIELD_HEIGHT / size / 2;
				
		this.setSize(image.getWidth(), image.getHeight());
		this.setActualLocation(x, y);
		this.setBackground(null);
		this.setOpaque(false);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		if (image != null){
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			
		}
	}
	
	public void setActualLocation(int x, int y){
		this.x = x;
		this.y = y;
		this.setLocation(chessBoardWidthOffset+(x+y+1)*blockWidthOffset+selfWidthOffset,chessBoardHeightOffset+FIELD_HEIGHT/2+(x-y)*blockHeightOffset+selfHeightOffset);
	}
	
	
}
