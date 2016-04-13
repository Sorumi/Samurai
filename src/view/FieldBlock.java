package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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
	private Color color = BlockColor.getBlockColor(0);
	
	private int width;
	private int height;
	private int stateStrokeSize;
	private int currentStrokeSize;

	FieldBlock(int x, int y, int z) {
		super();
		location = new Location(x, y);
		this.setTransparentBackground();
		switch(z){
		case 6:
			width=175;
			height=100;
			stateStrokeSize = 3;
			break;
		case 10:
			width=105;
			height=60;
			stateStrokeSize = 2;
			break;
		case 12:
			width=87;
			height=50;
			stateStrokeSize = 2;
			break;
		case 15:
			width=70;
			height=40;
			stateStrokeSize = 1;
			break;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//平滑效果！！！
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//设置菱形边框
		Stroke stroke = new BasicStroke((float)currentStrokeSize);
		g2.setStroke(stroke);
		g2.setColor(Color.white);
		//画菱形
		int[] xPoints = {currentStrokeSize,width/2,width-currentStrokeSize,width/2};
		int[] yPoints = {height/2,currentStrokeSize,height/2,height-currentStrokeSize};
		g2.drawPolygon(xPoints, yPoints, 4);
		g2.setColor(color);
		g2.fillPolygon(xPoints, yPoints, 4);

		this.setSize(width, height);
	
	}
	
	public Location getMyLocation() {
		return location;
	}
	
	public void setTransparentBackground()
	{
		this.setBackground(null);
		this.setOpaque(false);
	}
//	public void setStrokeSize(int size){
//		this.currentStrokeSize = size;
//	}
//	public void setColor(Color color){
//		this.color = color;
//	}
	public Color getColor(){
		return color;
	}
	
	public void setHome(){
		this.stateStrokeSize = 4;
		this.repaint();
	}
	public void setOutvision(){
		currentStrokeSize = 0;
		color = BlockColor.getBlockColor(99);
		this.repaint();

	}
	
	public void setInvision(int state){
		currentStrokeSize = stateStrokeSize;
		color = BlockColor.getBlockColor(state);
		this.repaint();
	}
}
