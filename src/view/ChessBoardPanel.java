package view;

import javax.swing.JPanel;



/**
 * 棋盘界面
 * @author Sorumi
 *
 */

public class ChessBoardPanel extends JPanel {
	static FieldBlock[][] FieldBlock;
	private static int rows;
	private static int columns;
	
	public ChessBoardPanel(int rows,int columns){
		ChessBoardPanel.rows = rows;
		ChessBoardPanel.columns = columns;
		FieldBlock = new FieldBlock[rows][columns];
		this.setLayout(null);
		int m=0;
		int n=0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				int x=m;
				int y=n;
				x=x+1/2;
				y=y-1/2;
				FieldBlock[i][j]=new FieldBlock(x,y);
				FieldBlock[i][j].setBounds(x*width, y*height, width, height);
				
			}
				
			}
	}
	public FieldBlock[][] getFieldBlock(){
		return FieldBlock;
	}
	public void setFieldBlock(FieldBlock[][] FieldBlock){
		ChessBoardPanel.FieldBlock=FieldBlock;
	}
	public int getrows(){
		return rows;
	}
	public void setrows(int rows){
		ChessBoardPanel.rows=rows;
	}
	public int getcolumns(){
		return columns;
	}
	public void setcolumns(int columns){
		ChessBoardPanel.columns=columns;
	}
	
	private final int width=1/15*900;
	private final int height=1/15*225;

}
	
