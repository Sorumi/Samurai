package view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PointsPanel extends JPanel{
	
	private final int PANEL_WIDTH = 200;
	private final int PANEL_HEIGHT = 30;
	private final int strokeSize = 2;
	
	private int pointsTotal;
	private int pointsRest;
	private int currentSamurai;
	private boolean isShow;
	
	private JLabel pointsLabel;
	
	public PointsPanel(){
		this.setLayout(null);
		this.setBackground(Color.black);
		this.setSize(PANEL_WIDTH+2*strokeSize, PANEL_HEIGHT+2*strokeSize);
		this.setVisible(false);
		pointsLabel = new JLabel();
		pointsLabel.setBounds(150, 5, 50, 20);
		this.add(pointsLabel);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//平滑效果！！！
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//描边
		Stroke stroke = new BasicStroke((float)strokeSize);
		g2.setStroke(stroke);
		g2.setColor(Color.white);
		//画框
		RoundRectangle2D roundShape = new RoundRectangle2D.Float(strokeSize, strokeSize, PANEL_WIDTH, PANEL_HEIGHT, PANEL_HEIGHT, PANEL_HEIGHT);
		g2.draw(roundShape);
		g2.fill(roundShape);
		//填充
		double proportion = ((double)pointsRest)/pointsTotal;
		Rectangle2D fillShape = new Rectangle2D.Double(strokeSize, strokeSize, proportion*PANEL_WIDTH, PANEL_HEIGHT);
		
		Area round = new Area(roundShape);
		Area fill = new Area(fillShape);
		fill.intersect(round);
		
		g2.setColor(BlockColor.getBlockColor(currentSamurai));
		g2.fill(fill);
	
		g2.dispose();
		
	}
	
	public void setPointsTotal(int pointsTotal){
		this.pointsTotal = pointsTotal;
	}
	
	public void setPointsRest(int pointsRest){
		this.pointsRest = pointsRest;
		pointsLabel.setText(pointsRest + " / " + pointsTotal);
	}
	
	public void setCurrentSamurai(int currentSamurai){
		this.currentSamurai = currentSamurai;
	}
	
	public void setIsShow(boolean isShow){
		//判断是否弹出
		//TODO
		this.setVisible(isShow);
	}
}
