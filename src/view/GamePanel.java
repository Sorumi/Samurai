package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.UpdateMessage;
import view.listener.GameListener;

public class GamePanel extends JPanel implements Observer {

    private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;
	
	private int sideBlockQuantity;
	private int blockWidth;
	private int blockHeight;
	
	private int timeInAll = 30;
	private int roundInAll = 12;
	
	public ChessBoardPanel chessBoard;

	private JLabel playerLabel;
	private JLabel roundLabel;
	private JLabel timeLabel;
	private JLabel actionPointLabel;

	private Arrow arrow;
	private SamuraiView currentSamurai; //0：无 1 2 3 4 5 6
	
	private SamuraiView A1;
	private SamuraiView A2;
	private SamuraiView A3;
	private SamuraiView B1;
	private SamuraiView B2;
	private SamuraiView B3;
	
	private PlayerPanel playerA;
	private PlayerPanel playerB;
	
	private ActionButtonPanel actionButtons;
	private GameListener gameListener;
	
	private Image bgImage = Images.BG_0;
	
	public GamePanel(int size){
		this.sideBlockQuantity = size;
		this.setLayout(null);
		this.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
//		this.setBackground(null);
//		this.setOpaque(false);

		
		//playerInfo
		playerA = new PlayerPanel(1, timeInAll);
		this.add(playerA);
		
		//player 标签
		this.playerLabel = new JLabel("Player");
		this.playerLabel.setBounds(800,20,100,40);
		this.add(this.playerLabel);

		//round 标签
		this.roundLabel = new JLabel("Round");
		this.roundLabel.setBounds(1000, 20, 100, 40);
		this.add(this.roundLabel);

		//time 标签
		this.timeLabel = new JLabel("Time");
		this.timeLabel.setBounds(900,20,100,40);
		this.add(this.timeLabel);

		//actionPoint 标签
		this.actionPointLabel = new JLabel("ActionPoint");
		this.actionPointLabel.setBounds(700,20,100,40);
		this.add(this.actionPointLabel);

		//chessboard
		chessBoard = new ChessBoardPanel(sideBlockQuantity);
		this.add(chessBoard);

		//samurais 需要设置初始位置home
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
		
		//listener
		gameListener = new GameListener(this);
		this.addMouseListener(gameListener);
		A1.addMouseListener(gameListener);
		A2.addMouseListener(gameListener);
		A3.addMouseListener(gameListener);
		B1.addMouseListener(gameListener);
		B2.addMouseListener(gameListener);
		B3.addMouseListener(gameListener);
		
		//arrow & actionButtons
		arrow = new Arrow();
		this.add(arrow);
		
		actionButtons = new ActionButtonPanel(gameListener);
		this.add(actionButtons);
		

	
		//order
		this.setComponentZOrder(A1, 0);
		this.setComponentZOrder(A2, 1);
		this.setComponentZOrder(A3, 2);
		this.setComponentZOrder(B1, 3);
		this.setComponentZOrder(B2, 4);
		this.setComponentZOrder(B3, 5);
		this.setComponentZOrder(arrow, 6);
		this.setComponentZOrder(actionButtons, 7);
		this.setComponentZOrder(chessBoard, 8);
		this.setComponentZOrder(playerA, 9);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bgImage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
	}

	public void setCurrentSamurai(int i){
		switch (i){
			case 1:
				this.currentSamurai = A1;
				break;
			case 2:
				this.currentSamurai = B1;
				break;
			case 3:
				this.currentSamurai = B2;
				break;
			case 4:
				this.currentSamurai = A2;
				break;
			case 5:
				this.currentSamurai = A3;
				break;
			case 6:
				this.currentSamurai = B3;
				break;
		}
		arrow.setCurrentSamurai(currentSamurai);
		actionButtons.setCurrentSamurai(currentSamurai);
	}

	public SamuraiView getCurrentSamurai(){
		return this.currentSamurai;
	}
	
	public ActionButtonPanel getActionButtons(){
		return this.actionButtons;
	}
	
	public Arrow getArrow(){
		return this.arrow;
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();

		//如果听到的消息是‘samurai’时
		if(key.equals("samurai")){
			this.setCurrentSamurai((int)notifingObject.getValue());
		}else if(key.equals("player")){
			this.playerLabel.setText("玩家 " + Integer.toString((int)notifingObject.getValue()));
		}else if(key.equals("round")){
			this.roundLabel.setText("第 " + Integer.toString((int)notifingObject.getValue()) + " 轮");
		}else if(key.equals("time")){
			this.timeLabel.setText("还有 " + Integer.toString((int)notifingObject.getValue()) + " 秒");
		}else if(key.equals("actionPoint")){
			this.actionPointLabel.setText("点数剩余 " + Integer.toString((int)notifingObject.getValue()));
		}

	}
}

