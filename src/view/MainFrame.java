package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame implements Observer{
	
	final static int WINDOW_WIDTH = 1200;
	final static int WINDOW_HEIGHT = 800;
	
	public JFrame frame;
	public ChessBoardPanel chessBoard;

	public JButton closebutton;
	
	public MainFrame(){
		frame = new JFrame();
		

		//布局设为null!
		frame.getContentPane().setLayout(null);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//		frame.setUndecorated(true);
		
		chessBoard = new ChessBoardPanel(6);
		closebutton=new JButton("Quit");
		closebutton.addActionListener(new ButtonListener());
		closebutton.setBounds(1135, 600, 40, 20);
//		
		frame.getContentPane().add(chessBoard);
		frame.getContentPane().add(closebutton);
		frame.setVisible(true);
	}
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.exit(0);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
