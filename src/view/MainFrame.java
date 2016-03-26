package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainFrame implements Observer{
	JFrame mainFrame=new JFrame();
	JPanel ChessBoardPanel;
	int mainwide;
	int mainheight;
	int panelwide;
	int panelheight;
	public void go(){
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1200, 900);
		mainFrame.setLayout(null);
		
		ChessBoardPanel.setBounds(150, 200, 800, 700);
		mainFrame.getContentPane().add(ChessBoardPanel);
		mainFrame.setVisible(true);
	}
	public int getmainwide(){
		return mainwide;
	}
	public int getmainheight(){
		return mainheight;
	}
	public int getpanelwide(){
		return panelwide;
	}
	public int getpanelheight(){
		return panelheight;
	}
	public void setmainwide(int x){
		mainwide=x;
	}
	public void setmainheight(int x){
		mainheight=x;
	}
	public void setpanelwide(int x){
		panelwide=x;
	}
	public void setpanelheight(int x){
		panelheight=x;
	}



	@Override
	public void update(Observable o, Object arg) {
		
		
	}

}
