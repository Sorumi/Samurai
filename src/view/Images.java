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
	
	public static final Image BG_0 = createImage("images/bg_0.png");
	
	public static final BufferedImage SAMURAI_A1 = createBufferedImage("images/samurai_A1.png");
	public static final BufferedImage SAMURAI_A2 = createBufferedImage("images/samurai_A2.png");
	public static final BufferedImage SAMURAI_A3 = createBufferedImage("images/samurai_A3.png");
	public static final BufferedImage SAMURAI_B1 = createBufferedImage("images/samurai_B1.png");
	public static final BufferedImage SAMURAI_B2 = createBufferedImage("images/samurai_B2.png");
	public static final BufferedImage SAMURAI_B3 = createBufferedImage("images/samurai_B3.png");
	
	
	
	
	
	
	
	
	
	//缩放图片 不用了！！！
//	public static BufferedImage getBlockByProportion(int proportion){
//		int width = BLOCK_DEFAULT_1.getWidth() / proportion;
//		int height = BLOCK_DEFAULT_1.getHeight() / proportion;
//		BufferedImage image = new BufferedImage(width, height, BLOCK_DEFAULT_1.getType());
//		Graphics g = image.getGraphics();
//        g.drawImage(BLOCK_DEFAULT_1, 0,0,width,height,null);
//        g.dispose();
//		return image;
//	}
}
