package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PointsPanel extends JPanel{
	
	private final int PANEL_WIDTH = 200;
	private final int PANEL_HEIGHT = 30;
	
	private int pointsTotal;
//	private int pointsRest;
	
	private JLabel pointsLabel;
	
	public PointsPanel(){
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		
		pointsLabel = new JLabel();
		pointsLabel.setBounds(150, 5, 50, 20);
		this.add(pointsLabel);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//平滑效果！！！
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.white);
		g2.fillRoundRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT, PANEL_HEIGHT, PANEL_HEIGHT);
	}
	
	public void setPointsTotal(int pointsTotal){
		this.pointsTotal = pointsTotal;
	}
	
	public void setPointsRest(int pointsRest){
//		this.pointsRest = pointsRest;
		pointsLabel.setText(pointsRest + " / " + pointsTotal);
		this.repaint();
	}
}
