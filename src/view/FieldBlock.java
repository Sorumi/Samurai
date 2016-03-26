package view;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * 土地块
 * @author Sorumi
 *
 */
public class FieldBlock extends JPanel{
	private  Location location;
	private Image image;
	private ImageIcon imageIcon;
	
	FieldBlock(Location alocation){
		super();
		this.location=alocation;
	}
	FieldBlock(int x,int y){
		super();
		location=new Location(x,y);
	}
	public Location getLocation(Location location){
		return location;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(image!=null){
			Graphics2D g2d=(Graphics2D) g;
			g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}
	public void draw(ImageIcon imageIcon){
		this.imageIcon=imageIcon;
		repaint();
	}

}
