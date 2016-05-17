package view.guide;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.po.ActualBlock;
import model.po.Position;
import view.BlockView;
import view.OrderPanel;

public class ChessBoardGuidePanel extends OrderPanel implements Observer{
	BlockView[][] blocks;

	private int size;

	private final int WINDOW_WIDTH = 1100;
	private final int WINDOW_HEIGHT = 700;
	private final int BLOCK_WIDTH = 70;
	private final int BLOCK_HEIGHT = 40;
	private final int FIELD_FIX = 20;

	private int feildWidth;
	private int feildHeight;

	private ArrayList<BlockView> tmpBlocks;

	public ChessBoardGuidePanel(int size){
		this.size = size;
		this.feildWidth = BLOCK_WIDTH * size;
		this.feildHeight = BLOCK_HEIGHT * size;
		//bounds
		this.setPrefSize(feildWidth, feildHeight);
		this.setLayoutX((WINDOW_WIDTH-feildWidth)/2);
		this.setLayoutY(WINDOW_HEIGHT-feildHeight-FIELD_FIX);
//		this.setStyle("-fx-background-color: rgba(0,0,0,0.2)");

		//blocks
		blocks = new BlockView[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				blocks[i][j] = new BlockView(i,j,size);
				this.getChildren().add(blocks[i][j]);
			}
		}

		this.tmpBlocks = new ArrayList<>();
	}

	@Override
	//这方法到底有啥用……
	public void update(Observable o, Object arg) {

	}

	public void setTmpBlocks(ArrayList<ActualBlock> actualBlocks){
		this.tmpBlocks.clear();
		for(ActualBlock block : actualBlocks){
			this.tmpBlocks.add(blocks[block.getX()][block.getY()]);
		}
	}

	//返回视野
	public void see(ArrayList<ActualBlock> actualBlocks){
		ArrayList<BlockView> tmp = new ArrayList<>();
		for(ActualBlock block : actualBlocks){
			tmp.add(blocks[block.getX()][block.getY()]);
			int x = block.getX();
			int y = block.getY();
			blocks[x][y].setInvision(block.getState());
		}
		for (BlockView block1 : this.tmpBlocks) {
			if (!tmp.contains(block1)) {
				block1.setOutvision();
			}
		}
	}

	public void pseudoOccupy(ArrayList<Position> positions, boolean HL){
		ArrayList<BlockView> poBlocks = new ArrayList<>();
		for(Position position : positions){
			poBlocks.add(blocks[position.getX()][position.getY()]);
		}
		for(BlockView blockView : poBlocks){
			blockView.setHighlight(HL);
		}
	}

	public int getState(int x, int y){
		return this.blocks[x][y].getState();
	}

}
