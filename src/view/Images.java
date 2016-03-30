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

	protected static BufferedImage createImage(String path) {
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	
	
	public static final BufferedImage BLOCK_FIELD = createImage("images/block_field.png");
	
	
	
	
	
	
	
	
	
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
