package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 图片库
 * @author Sorumi
 *
 */

public class Images {
	protected static ImageIcon createImageIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}

	protected static BufferedImage createBufferedImage(String path) {
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	protected static Image createImage(String path) {
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	
	public static final BufferedImage BLOCK_FIELD = createBufferedImage("images/block_field.png");
	
	//bg
	public static final BufferedImage BG_0 = createBufferedImage("images/bg_0.png");
	
	//arrow
	public static final BufferedImage ARROW = createBufferedImage("images/arrow.png");
	
	//button
	public static final ImageIcon BUTTON_OCCUPY = createImageIcon("images/button_occupy.png");
	public static final ImageIcon BUTTON_MOVE = createImageIcon("images/button_move.png");
	public static final ImageIcon BUTTON_HIDE = createImageIcon("images/button_hide.png");
	public static final ImageIcon BUTTON_EXIT = createImageIcon("images/button_exit.png");
	public static final ImageIcon BUTTON_BACK = createImageIcon("images/button_back.png");
	
	//classic
	public static final BufferedImage SAMURAI_A1 = createBufferedImage("images/samurai_A1.png");
	public static final BufferedImage SAMURAI_A2 = createBufferedImage("images/samurai_A2.png");
	public static final BufferedImage SAMURAI_A3 = createBufferedImage("images/samurai_A3.png");
	public static final BufferedImage SAMURAI_B1 = createBufferedImage("images/samurai_B1.png");
	public static final BufferedImage SAMURAI_B2 = createBufferedImage("images/samurai_B2.png");
	public static final BufferedImage SAMURAI_B3 = createBufferedImage("images/samurai_B3.png");
	public static final BufferedImage[] SAMURAI_CLASSIC = {null,SAMURAI_A1,SAMURAI_A2,SAMURAI_A3,SAMURAI_B1,SAMURAI_B2,SAMURAI_B3};
	
	public static final BufferedImage SAMURAI_CLASSIC_SHADOW_1 = createBufferedImage("images/samurai_shadow_1.png");
	public static final BufferedImage[] SAMURAI_CLASSIC_SHADOW = {SAMURAI_CLASSIC_SHADOW_1};
}
