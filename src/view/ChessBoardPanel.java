package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import model.UpdateMessage;
import model.po.ActualBlock;

public class ChessBoardPanel extends Pane implements Observer{

	BlockView[][] blocks;
	
	private int size;
	
	private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;
	
	private int blockWidth;
	private int blockHeight;
	
	private ArrayList<BlockView> tmpBlocks;
	
	public ChessBoardPanel(int size){
		this.size = size;
		this.blockWidth = FIELD_WIDTH / size;
		this.blockHeight = FIELD_HEIGHT / size;
		//bounds
		this.setPrefSize(FIELD_WIDTH, FIELD_HEIGHT);
		this.setLayoutX((WINDOW_WIDTH-FIELD_WIDTH)/2);
		this.setLayoutY(WINDOW_HEIGHT-FIELD_HEIGHT-FIELD_FIX);
		
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
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();
		
		//如果听到的消息是‘block’时
		if(key.equals("block")){
			ActualBlock block = (ActualBlock)notifingObject.getValue();
			int x = block.getX();
			int y = block.getY();
			blocks[x][y].setInvision(block.getState());
		}
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

//		System.out.println("size: " + tmpBlocks.size());
//		System.out.println("tmp  " + tmp.size());

		for (BlockView block1 : this.tmpBlocks) {
			if (!tmp.contains(block1)) {
				block1.setOutvision();
			}
		}

//		for(FieldBlock[] block : blocks){
//			for(FieldBlock block1 : block){
//				if(!tmp.contains(block1)){
//					block1.setOutvision();
//				}
//			}
//		}

	}
}
