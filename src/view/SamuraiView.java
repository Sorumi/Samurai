package view;

import model.po.Position;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	private final int selfHeightOffset = -75;

	private int number;
	private BufferedImage image;
	
	private int x;
	private int y;
	private boolean isHide;
	
	public SamuraiView(int number, int size){
  		
		this.number = number;
		this.image = Images.SAMURAI_CLASSIC[number];
		this.isHide = false;
		
		blockWidthOffset = FIELD_WIDTH / size / 2;
		blockHeightOffset = FIELD_HEIGHT / size / 2;
				
		this.setSize(image.getWidth(), image.getHeight());
		this.setBackground(null);
		this.setOpaque(false);
	}
	public SamuraiView(int number, int size, int x, int y){
  		this(number, size);
		this.setActualLocation(x, y);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		if (image != null){
			Graphics2D g2 = (Graphics2D) g;
			//平滑效果！！！
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			if(isHide){
				 AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f); 
		            g2.setComposite(ac); 
		            g2.drawImage(image, 0, 0, getWidth(), getHeight(), null, null); 
			}else{
				g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			}	
		}
	}
	
	public void setActualLocation(int x, int y){
		this.x = x;
		this.y = y;
		this.setLocation(chessBoardWidthOffset+FIELD_WIDTH/2+(y-x)*blockWidthOffset+selfWidthOffset, chessBoardHeightOffset+(x+y)*blockHeightOffset+selfHeightOffset);
	}

	public Position getPosition(){
		return new Position(x,y);
	}
	
	public int getNum(){
		return this.number;
	}
	
	public void setHide(boolean isHide){
		this.isHide = isHide;
		this.repaint();
	}

}
