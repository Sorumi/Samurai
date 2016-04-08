package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Arc2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CirclePanel extends JPanel {
	
	private final int CIRCLE_DIAMETER = 200;
	private final int strokeSize = 2;
	
	private int player;
	private int timeTotal;
	private int timeRest;

	private int[] blockNum = {0,0,0,0,0,0,0};
	
	private JLabel playerLogo;
	private ImageIcon logo;
	
	public CirclePanel(int player, int timeTotal){
		this.player = player;
		this.timeTotal = timeTotal;
//		this.timeRest = timeTotal;
		
		logo = Images.PLAYER_LOGO[player];
		playerLogo = new JLabel();
		playerLogo.setIcon(logo);
		playerLogo.setBounds((CIRCLE_DIAMETER-logo.getIconWidth())/2, (CIRCLE_DIAMETER-logo.getIconHeight())/2, logo.getIconWidth(), logo.getIconHeight());
		this.add(playerLogo);
		
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);
		this.setSize(CIRCLE_DIAMETER+2*strokeSize, CIRCLE_DIAMETER+2*strokeSize);

		//TODO
		blockNum[1] = 52;
		blockNum[2] = 38;
		blockNum[3] = 27;
		blockNum[4] = 32;
		blockNum[5] = 49;
		blockNum[6] = 23;
		
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
		
		//画圆
		g2.drawOval(strokeSize, strokeSize, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		g2.setColor(Color.white);
		g2.fillOval(strokeSize, strokeSize, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		
		//画扇形
		//己方
		double startAngle = 90.0;
		double arcAngle = -180.0 / 255;
		for (int i=1; i<=3; i++){
			g2.setColor(BlockColor.getBlockColor(i));
			Arc2D arc = new Arc2D.Double(strokeSize, strokeSize, CIRCLE_DIAMETER, CIRCLE_DIAMETER, startAngle, arcAngle*blockNum[i], Arc2D.PIE);
			g2.fill(arc);
			startAngle += arcAngle*blockNum[i];
		}
		//敌方
		startAngle = -90.0;
		arcAngle = 180.0 / 255;
		for (int i=1; i<=3; i++){
			g2.setColor(BlockColor.getBlockColor(i+3));
			Arc2D arc = new Arc2D.Double(strokeSize, strokeSize, CIRCLE_DIAMETER, CIRCLE_DIAMETER, startAngle, arcAngle*blockNum[i+3], Arc2D.PIE);
			g2.fill(arc);
			startAngle += arcAngle*blockNum[i+3];
		}
		//time
		startAngle = 90.0;
		arcAngle = 180.0 / timeTotal;
		g2.setColor(BlockColor.getOtherColor(player));
		Arc2D arc = new Arc2D.Double(strokeSize, strokeSize, CIRCLE_DIAMETER, CIRCLE_DIAMETER, startAngle, arcAngle*(timeRest-1), Arc2D.PIE);
		g2.fill(arc);
		
	}
	
	public void setTimeRest(int timeRest){
		this.timeRest = timeRest;
	}
	
}
