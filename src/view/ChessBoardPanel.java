package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


/**
 * 棋盘界面
 * @author Sorumi
 *
 */

public class ChessBoardPanel extends JPanel {
	
	static FieldBlock[][] blocks;
	private static int SideBlockQuantity;//width
	private final int window_fix = 22;
	
	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	
	private final BufferedImage bgImage = Images.BLOCK_FIELD;
	
	private final int fieldWidth = 1050;
	private final int fieldHeight = 600;
	
	private int blockWidth;
	private int blockHeight;
	
	
	public ChessBoardPanel(int sideBlockQuantity){
  		ChessBoardPanel.SideBlockQuantity = sideBlockQuantity;
  		BufferedImage[] blockImages = null;
  		this.setLayout(null);
  		
  		switch(sideBlockQuantity) {
  			case 10:
  				blockImages = Images.BLOCK_10;
  				break;
  			case 15:
  				blockImages = Images.BLOCK_15;
  				break;
  		}
  		
  		blockWidth = fieldWidth / sideBlockQuantity;
  		blockHeight = fieldHeight / sideBlockQuantity;
  		
		this.setBackground(Color.black);
//		this.setOpaque(false);
  		this.setBounds((WINDOW_WIDTH-fieldWidth)/2, WINDOW_HEIGHT-fieldHeight-window_fix, fieldWidth, fieldHeight);
  		
  		blocks = new FieldBlock[SideBlockQuantity][SideBlockQuantity];
		
		for(int i=0; i<SideBlockQuantity; i++){
			for(int j=0; j<SideBlockQuantity; j++){
				blocks[i][j] = new FieldBlock(i,j);
				blocks[i][j].setBounds( (i+j) * blockWidth/2, fieldHeight/2 + (i-j-1) * blockHeight/2, blockWidth,
						blockHeight);
				blocks[i][j].draw(blockImages[0]);
				this.add(blocks[i][j]);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
		this.setSize(fieldWidth, fieldHeight);
		
	}
}
