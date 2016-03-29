package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class MainFrame implements Observer{
	
	final static int WINDOW_WIDTH = 1200;
	final static int WINDOW_HEIGHT = 800;
	
	public JFrame frame;
	public ChessBoardPanel chessBoard;
	
	
	public MainFrame(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//布局设为null!
		frame.getContentPane().setLayout(null);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		chessBoard = new ChessBoardPanel(10);
		
		frame.getContentPane().add(chessBoard);
		frame.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new MainFrame();
	}
	

}
