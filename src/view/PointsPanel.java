package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class PointsPanel extends JPanel{
	
	private final int PANEL_WIDTH = 200;
	private final int PANEL_HEIGHT = 30;
	private final int strokeSize = 2;
	private int labelX;

	private int player;
	private int pointsTotal;
	private int pointsRest;
	private int currentSamurai;
	private boolean isShow;
	
	public PointsPanel(int player){
		this.player = player;
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
		this.setSize(PANEL_WIDTH+2*strokeSize, PANEL_HEIGHT+2*strokeSize);
		this.setVisible(false);
		

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
		//画框和背景
		RoundRectangle2D roundShape = new RoundRectangle2D.Float(strokeSize, strokeSize, PANEL_WIDTH, PANEL_HEIGHT, PANEL_HEIGHT, PANEL_HEIGHT);
		g2.draw(roundShape);
		g2.fill(roundShape);
		Font f1 = new Font("Tsukushi B Round Gothic",Font.PLAIN,20);
		g2.setFont(f1);
		g2.setColor(BlockColor.getOtherColor(2));
		String text = pointsRest + " / " + pointsTotal;
		int strWidth = g.getFontMetrics().stringWidth(text);
		if(player == 0){
			labelX = PANEL_WIDTH-10-strWidth;
		}else{
			labelX = 10;
		}
		g2.drawString(text, labelX, 25);
		
		//画填充
		double proportion = ((double)pointsRest)/pointsTotal;
		Rectangle2D fillShape = new Rectangle2D.Double(strokeSize+(1-proportion)*PANEL_WIDTH*player, strokeSize, proportion*PANEL_WIDTH, PANEL_HEIGHT);
		
		Area round = new Area(roundShape);
		Area fill = new Area(fillShape);
		fill.intersect(round);
		
		g2.setColor(BlockColor.getBlockColor(currentSamurai));
		g2.fill(fill);
		
		g2.clip(fill);
		g2.setColor(Color.white);//BlockColor.getOtherColor(3)
		g2.drawString(text, labelX, 25);
		
	}
	
	public void setPointsTotal(int pointsTotal){
		this.pointsTotal = pointsTotal;
	}
	
	public void setPointsRest(int pointsRest){
		this.pointsRest = pointsRest;
//		this.pointsRest = 6;
		//动画
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
