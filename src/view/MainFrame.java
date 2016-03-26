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
		mainFrame.setSize(mainwide, mainheight);
		mainFrame.setLayout(null);
		//下面的面积大小比是按照1200*900来大致算的//
		ChessBoardPanel.setBounds(1/8*mainwide, 1/4*mainheight, panelwide, panelheight);
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
