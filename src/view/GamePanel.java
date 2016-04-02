package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
    private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;
	
	private int sideBlockQuantity;
	private int blockWidth;
	private int blockHeight;
	
	public ChessBoardPanel chessBoard;
	public SamuraiView A1;
	public SamuraiView A2;
	public SamuraiView A3;
	public SamuraiView B1;
	public SamuraiView B2;
	public SamuraiView B3;
	
	private Image bgImage = Images.BG_0;
	
	public GamePanel(int size){
		this.sideBlockQuantity = size;
		this.setLayout(null);
		this.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
//		this.setBackground(null);
//		this.setOpaque(false);
		
		//chesboard
		chessBoard = new ChessBoardPanel(sideBlockQuantity);
		this.add(chessBoard);
		
		//samurais 需要设置初始位置home
		//TODO
		A1 = new SamuraiView(1, size, 0, 0);
		A2 = new SamuraiView(2, size, 0, 7);
		A3 = new SamuraiView(3, size, 0, 14);
		B1 = new SamuraiView(4, size, 14, 0);
		B2 = new SamuraiView(5, size, 14, 7);
		B3 = new SamuraiView(6, size, 14, 14);
		this.add(A1);
		this.add(A2);
		this.add(A3);
		this.add(B1);
		this.add(B2);
		this.add(B3);
		this.setComponentZOrder(A1, 0);
		this.setComponentZOrder(A2, 0);
		this.setComponentZOrder(A3, 0);
		this.setComponentZOrder(B1, 0);
		this.setComponentZOrder(B2, 0);
		this.setComponentZOrder(B3, 0);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bgImage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
	}
}
