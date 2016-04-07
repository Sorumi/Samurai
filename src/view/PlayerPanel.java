package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel{
	
	private int player;
	private int currentSamurai;
	private int pointsTotal;
	
	private CirclePanel circlePanel;
	private PointsPanel pointsPanel;
	
	public PlayerPanel(int player, int timeTotal){
		
		this.player = player;
		this.setLayout(null);
		
		circlePanel = new CirclePanel(player, timeTotal);
		circlePanel.setLocation(0, 0);
		this.add(circlePanel);
		
		pointsPanel = new PointsPanel(); 
		pointsPanel.setLocation(102, 174);
		this.add(pointsPanel);
		
		this.setComponentZOrder(circlePanel, 0);
		this.setComponentZOrder(pointsPanel, 1);
		
		this.setSize(304, 204);
		if(player == 0){
			this.setLocation(0, 0);
		}else{
			this.setLocation(850, 0);
		}

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//平滑效果！！！
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.white);
		//roundPanel
		g2.fillOval(0, 0, 45, 45);
	}
	
	public void setCurrentSamurai(int num){
		currentSamurai = num;
		if (num>=player && num<=player*3) {
			//pointpanel 出现
		}
	}
	public void setTimeRest(int timeRest){
		circlePanel.setTimeRest(timeRest);
	}
	public void setPointsTotal(int pointsTotal){
		pointsPanel.setPointsTotal(pointsTotal);
	}
	public void setPointsRest(int pointsRest){
		pointsPanel.setPointsRest(pointsRest);
	}
	//set round
}
