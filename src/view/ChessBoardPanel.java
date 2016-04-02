package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.UpdateMessage;
import model.po.DisplayBlock;


/**
 * 棋盘界面
 * @author Sorumi
 *
 */

public class ChessBoardPanel extends JPanel implements Observer {
	
	static FieldBlock[][] blocks;
	private static int SideBlockQuantity;//width

    private final int imageFix = 20;
    private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int fieldWidth = 1050;
	private final int fieldHeight = 600;
	
    private final BufferedImage bgImage = Images.BLOCK_FIELD;
	private int blockWidth;
	private int blockHeight;

	public ChessBoardPanel(int sideBlockQuantity){
  		ChessBoardPanel.SideBlockQuantity = sideBlockQuantity;
  		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
  		this.setBounds((WINDOW_WIDTH-fieldWidth)/2, WINDOW_HEIGHT-fieldHeight-imageFix, fieldWidth, fieldHeight);
  		
  		blocks = new FieldBlock[SideBlockQuantity][SideBlockQuantity];
  		blockWidth = fieldWidth / sideBlockQuantity;
  		blockHeight = fieldHeight / sideBlockQuantity;
		
		for(int i=0; i<SideBlockQuantity; i++){
			for(int j=0; j<SideBlockQuantity; j++){

				blocks[i][j] = new FieldBlock(i,j,sideBlockQuantity);
				blocks[i][j].setBounds( (i+j) * blockWidth/2, fieldHeight/2 + (i-j-1) * blockHeight/2, blockWidth,
						blockHeight);
				this.add(blocks[i][j]);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bgImage, 0, 0, fieldWidth, fieldHeight, null);
		this.setSize(fieldWidth, fieldHeight);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();
		
		//如果听到的消息是‘block’时
		if (key == "block") {
			DisplayBlock displayBlock = (DisplayBlock) notifingObject.getValue();
			
			Color blockColor = BlockColor.getBlockColor(displayBlock.getState());
			int x = displayBlock.getX();
			int y = displayBlock.getY();
			System.out.println("x " + x + " y " + y);
			blocks[x][y].setColor(blockColor);
			blocks[x][y].repaint();
			
		}
	}
}
