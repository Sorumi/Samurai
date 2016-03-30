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
import javax.swing.ImageIcon;

/**
 * 棋盘单元块
 * @author Sorumi
 *
 */
public class FieldBlock extends JPanel{

	private Location location;
	private BufferedImage image;
	
	int width = 105;
	int height = 60;
	int strokeSize = 2;
	
	FieldBlock(Location location) {
		super();
		this.location = location;
		this.setTransparentBackground();
	}
	FieldBlock(int x, int y) {
		super();
		location = new Location(x, y);
		this.setTransparentBackground();
	}
	
	public Location getMyLocation() {
		return location;
	}
	
	public void setTransparentBackground()
	{
		this.setBackground(null);
		this.setOpaque(false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			Graphics2D g2 = (Graphics2D) g;
//			g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			

			//设置菱形边框
			Stroke stroke = new BasicStroke((float)strokeSize);
			g2.setStroke(stroke);
			g2.setColor(Color.white);
			//画菱形TODO
			int[] xPoints = {strokeSize,width/2,width-strokeSize,width/2};
			int[] yPoints = {height/2,strokeSize,height/2,height-strokeSize};
			g2.drawPolygon(xPoints, yPoints, 4);
			g2.setColor(Color.gray);
			g2.fillPolygon(xPoints, yPoints, 4);

			this.setSize(width, height);
//			this.setSize(image.getWidth(), image.getHeight());
		}
	}
	
	public void draw(BufferedImage image){
//		this.imageIcon = imageIcon;
		this.image = image;
		repaint();
	}
}
