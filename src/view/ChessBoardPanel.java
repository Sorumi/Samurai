package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Position;


/**
 * 棋盘界面
 * @author Sorumi
 *
 */

public class ChessBoardPanel extends JPanel implements Observer {
	
	static FieldBlock[][] blocks;
	private int sideBlockQuantity;//width
    
    private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;
	
    private final BufferedImage bgImage = Images.BLOCK_FIELD;
	private int blockWidth;
	private int blockHeight;

	public ChessBoardPanel(int sideBlockQuantity){
  		this.sideBlockQuantity = sideBlockQuantity;

  		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
  		this.setBounds((WINDOW_WIDTH-FIELD_WIDTH)/2, WINDOW_HEIGHT-FIELD_HEIGHT-FIELD_FIX, FIELD_WIDTH, FIELD_HEIGHT);
  		
  		blocks = new FieldBlock[sideBlockQuantity][sideBlockQuantity];
  		blockWidth = FIELD_WIDTH / sideBlockQuantity;
  		blockHeight = FIELD_HEIGHT / sideBlockQuantity;
		
		for(int i=0; i<sideBlockQuantity; i++){
			for(int j=0; j<sideBlockQuantity; j++){
				blocks[i][j] = new FieldBlock(i,j,sideBlockQuantity);
				blocks[i][j].setBounds(FIELD_WIDTH/2 + (j-i-1)*blockWidth/2, (i+j)*blockHeight/2, blockWidth,
						blockHeight);
				this.add(blocks[i][j]);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//平滑效果！！！
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.drawImage(bgImage, 0, 0, FIELD_WIDTH, FIELD_HEIGHT, null);
		this.setSize(FIELD_WIDTH, FIELD_HEIGHT);
	}
	
	public FieldBlock getBlock(int x, int y){
		return blocks[x][y];
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();

		//如果听到的消息是‘block’时
		if(key.equals("block")){
			ActualBlock actualBlock = (ActualBlock)notifingObject.getValue();
			Color blockColor = BlockColor.getBlockColor(actualBlock.getState());
			int x = actualBlock.getX();
			int y = actualBlock.getY();
			blocks[x][y].setColor(blockColor);
			blocks[x][y].repaint();
		}
	}

	//返回视野
	public void see(ArrayList<ActualBlock> actualBlocks){
		ArrayList<FieldBlock> tmp = new ArrayList<>();
		for(ActualBlock block : actualBlocks){
			tmp.add(blocks[block.getX()][block.getY()]);
			Color blockColor = BlockColor.getBlockColor(block.getState());
			int x = block.getX();
			int y = block.getY();
			blocks[x][y].setColor(blockColor);
			blocks[x][y].repaint();
		}
		for(FieldBlock[] block : blocks){
			for(FieldBlock block1 : block){
				if(!tmp.contains(block1)){
					block1.setColor(new Color(0,0,0));
					block1.repaint();
				}
			}
		}

	}
}
