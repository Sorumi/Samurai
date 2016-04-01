package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.color.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 棋盘单元块
 * @author Sorumi
 *
 */
public class FieldBlock extends JPanel{

	private Location location;
	private Color color = Color.gray;
	
	int width = 105;
	int height = 60;
	int strokeSize = 2;
	

	FieldBlock(Location location) {
		super();
		this.location = location;
		this.setTransparentBackground();
	}

	FieldBlock(int x, int y,int z) {
		super();
		location = new Location(x, y);
		this.setTransparentBackground();
		switch(z){
		case 6:
			width=175;
			height=100;
			strokeSize = 3;
			break;
		case 10:
			width=105;
			height=60;
			strokeSize = 2;
			break;
		case 12:
			width=87;
			height=50;
			strokeSize = 2;
			break;
		case 15:
			width=70;
			height=40;
			strokeSize = 1;
			break;
		}
		
	}
	
	public Location getMyLocation() {
		return location;
	}
	
	public void setTransparentBackground()
	{
		this.setBackground(null);
		this.setOpaque(false);
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	public Color getColor(){
		return color;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
			Graphics2D g2 = (Graphics2D) g;
		
			//设置菱形边框
			Stroke stroke = new BasicStroke((float)strokeSize);
			g2.setStroke(stroke);
			g2.setColor(Color.white);
			//画菱形TODO
			int[] xPoints = {strokeSize,width/2,width-strokeSize,width/2};
			int[] yPoints = {height/2,strokeSize,height/2,height-strokeSize};
			g2.drawPolygon(xPoints, yPoints, 4);
			g2.setColor(color);
			g2.fillPolygon(xPoints, yPoints, 4);

			this.setSize(width, height);
//			this.setSize(image.getWidth(), image.getHeight());
		
	}
	

}
