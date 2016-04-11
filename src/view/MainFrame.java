package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class MainFrame implements Observer{
	
	final static int WINDOW_WIDTH = 1200;
	final static int WINDOW_HEIGHT = 800;
//    private final int window_fix = 22;
	
	public JFrame frame;
	public JButton exitButton;
	
	public GamePanel gamePanel;
	
	public MainFrame(){
		frame = new JFrame();
		//布局设为null!
		frame.getContentPane().setLayout(null);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setUndecorated(true);
		
		exitButton = new JButton("Quit");
		exitButton.addActionListener(new ButtonListener());
		exitButton.setBounds(1135, 20, 40, 40);
	
		gamePanel = new GamePanel(15);
		
		frame.getContentPane().add(gamePanel);
		frame.getContentPane().add(exitButton);
		frame.getContentPane().setComponentZOrder(exitButton, 0);
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

	public GamePanel getGamePanel(){
		return this.gamePanel;
	}

}
