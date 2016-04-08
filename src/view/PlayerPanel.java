package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class PlayerPanel extends JPanel{
	
	private int panelWidth;
	private int panelHeight;
	private int player;//0,1
	private int currentSamurai;
	private int pointsTotal;
	private int currentRound;
	
	private int roundX;
	private final int roundD = 45;
	
	private CirclePanel circlePanel;
	private PointsPanel pointsPanel;
	
	public PlayerPanel(int player, int timeTotal){
		
		this.player = player;
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
		
		circlePanel = new CirclePanel(player, timeTotal);
		this.add(circlePanel);
		
		pointsPanel = new PointsPanel(player);
		this.add(pointsPanel);
		
		this.setComponentZOrder(circlePanel, 0);
		this.setComponentZOrder(pointsPanel, 1);
		
		panelWidth = pointsPanel.getWidth()+circlePanel.getWidth()/2;
		panelHeight = circlePanel.getHeight();
		
		this.setSize(panelWidth, panelHeight);
		if(player == 0){
			circlePanel.setLocation(0, 0);
			pointsPanel.setLocation(circlePanel.getWidth()/2, circlePanel.getHeight()-pointsPanel.getHeight());
			roundX = 0;
			this.setLocation(0, 800-panelHeight);
		}else{
			circlePanel.setLocation(pointsPanel.getWidth()-circlePanel.getWidth()/2, 0);
			pointsPanel.setLocation(0, circlePanel.getHeight()-pointsPanel.getHeight());
			roundX = panelWidth-roundD;
			this.setLocation(1200-panelWidth, 800-panelHeight);
		}

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//平滑效果！！！
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.white);
		//roundPanel
		g2.fillOval(roundX, 0, roundD, roundD);

		Font f1 = new Font("Tsukushi B Round Gothic",Font.PLAIN,20);
		g2.setFont(f1);
		g2.setColor(BlockColor.getBlockColor(currentSamurai));//BlockColor.getOtherColor(2)
		g2.drawString(currentRound+"", roundX+16, 26);

	}
	public CirclePanel getCirclePanel(){
		return this.circlePanel;
	}
	public PointsPanel getPointsPanel(){
		return this.pointsPanel;
	}
	public void setCurrentSamurai(int currentSamurai){
		this.currentSamurai = currentSamurai;
		pointsPanel.setCurrentSamurai(currentSamurai);
	}
	public void setCurrentRound(int round){
		this.currentRound = round;
	}
}
