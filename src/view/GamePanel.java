package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Position;
import model.po.SamuraiPO;
import view.eventhandler.ActionHandler;


public class GamePanel extends Pane implements Observer{
	
    private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;
	
	private int size;
	private int blockWidth;
	private int blockHeight;
	
	public ChessBoardPanel chessBoard;
	//TODO
	private int timeTotal = 30;
	private int roundTotal = 12;

//	private JLabel playerLabel;
//	private JLabel roundLabel;
//	private JLabel timeLabel;
//	private JLabel actionPointLabel;
	
	private SamuraiView currentSamurai; //0：无 1 2 3 4 5 6
	
	private SamuraiView A1;
	private SamuraiView A2;
	private SamuraiView A3;
	private SamuraiView B1;
	private SamuraiView B2;
	private SamuraiView B3;
	
	private PlayerPanel currentPlayer;
	private PlayerPanel playerA;
	private PlayerPanel playerB;
	
	private Arrow arrow;
	public ActionPanel actionPanel;
	private ActionHandler actionHandler;
	
	private String bgImagePath = Images.BG_0;
		
	public GamePanel(int size){
		this.size = size;
		
		//bounds
		this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//background
		this.setStyle("-fx-background-image: url("+bgImagePath+")");
		
		//chessboard
		chessBoard = new ChessBoardPanel(size);
		this.getChildren().add(chessBoard);
		
		//player
		playerA = new PlayerPanel(0, timeTotal);
		playerB = new PlayerPanel(1, timeTotal);
		this.getChildren().add(playerA);
		this.getChildren().add(playerB);
		
		//arrow
		arrow = new Arrow();
		this.getChildren().add(arrow);
		
		//actionHandler
		actionHandler = new ActionHandler(this);
		
		//actionpanel
		actionPanel = new ActionPanel(actionHandler);
		this.getChildren().add(actionPanel);
		
		//samurai
		A1 = new SamuraiView(1, size);
		A2 = new SamuraiView(2, size);
		A3 = new SamuraiView(3, size);
		B1 = new SamuraiView(4, size);
		B2 = new SamuraiView(5, size);
		B3 = new SamuraiView(6, size);
		this.getChildren().add(A1);
		this.getChildren().add(A2);
		this.getChildren().add(A3);
		this.getChildren().add(B1);
		this.getChildren().add(B2);
		this.getChildren().add(B3);
		
		//TODO
		A1.setActualLocation(0, 0);
	}
	
	public void setCurrentSamurai(int i){
		switch (i){
			case 1:
				this.currentSamurai = A1;
				break;
			case 2:
				this.currentSamurai = A2;
				break;
			case 3:
				this.currentSamurai = A3;
				break;
			case 4:
				this.currentSamurai = B1;
				break;
			case 5:
				this.currentSamurai = B2;
				break;
			case 6:
				this.currentSamurai = B3;
				break;
		}
		currentSamurai.setOnMouseClicked(new EventHandler<MouseEvent>() {  
		      public void handle(MouseEvent event) {
		    	  actionPanel.setVisible(true);
		    	  arrow.setVisible(false);
		      }
		});
		arrow.setCurrentSamurai(currentSamurai);
		actionPanel.setCurrentSamurai(currentSamurai);
		playerA.setCurrentSamurai(currentSamurai.getNum());
		playerB.setCurrentSamurai(currentSamurai.getNum());
	}
	
	public void setCurrentPlayer(int player){
		switch(player){
			case 0:
				this.currentPlayer = playerA;
				playerA.pointsPanel.setIsShow(true);
				playerB.pointsPanel.setIsShow(false);
				break;
			case 1:
				this.currentPlayer = playerB;
				playerA.pointsPanel.setIsShow(false);
				playerB.pointsPanel.setIsShow(true);
				break;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();

		if(key.equals("samurai")){
			this.setCurrentSamurai((int)notifingObject.getValue());

		}else if(key.equals("player")){
//			this.playerLabel.setText("玩家 " + Integer.toString((int)notifingObject.getValue()));
			this.setCurrentPlayer((int)notifingObject.getValue());

		}else if(key.equals("round")){
//			this.roundLabel.setText("第 " + Integer.toString((int)notifingObject.getValue()) + " 轮");
//			this.setCurrentRound((int)notifingObject.getValue());

		}else if(key.equals("time")){
//			this.timeLabel.setText("还有 " + Integer.toString((int)notifingObject.getValue()) + " 秒");
//			this.currentPlayer.getCirclePanel().setTimeRest((int)notifingObject.getValue());

		}else if(key.equals("actionPoint")){
//			this.actionPointLabel.setText("点数剩余 " + Integer.toString((int)notifingObject.getValue()));
			this.currentPlayer.pointsPanel.setPointsRest((int)notifingObject.getValue());

		}else if(key.equals("pointsTotal")){
			this.currentPlayer.pointsPanel.setPointsTotal((int)notifingObject.getValue());

		}else if(key.equals("samuraiPosition")){
//			ActualBlock block = (ActualBlock)notifingObject.getValue();
//			if(block.getVisible()) {
//				this.currentSamurai.setActualLocation(block.getX(), block.getY());
//			}
//			this.actionButtonPanel.setActualLocation();
//			this.arrow.setActualLocation();
//
//			System.out.println("new Pos" + block.getX() + "," + block.getY());
		}else if(key.equals("move")){
			Position position = (Position)notifingObject.getValue();
			this.currentSamurai.setActualLocation(position.getX(), position.getY());
			this.actionPanel.setActualLocation();
			this.arrow.setActualLocation();

		}else if(key.equals("samuraiHide")){
			this.currentSamurai.setHide((boolean)notifingObject.getValue());
			
		}else if(key.equals("visible")) {
			if(this.currentPlayer.getPlayer() == 0){
				this.A1.setVisible(true);
				this.A2.setVisible(true);
				this.A3.setVisible(true);
				this.B1.setVisible(false);
				this.B2.setVisible(false);
				this.B3.setVisible(false);
				for(ActualBlock block : (ArrayList<ActualBlock>)notifingObject.getValue()) {
					if (block.getX() == this.B1.x && block.getY() == this.B1.y) {
						if(!this.B1.isHide()) {
							this.B1.setVisible(true);
						}
					}
					if (block.getX() == this.B2.x && block.getY() == this.B2.y) {
						if(!this.B2.isHide()) {
							this.B2.setVisible(true);
						}
					}
					if (block.getX() == this.B3.x && block.getY() == this.B3.y) {
						if(!this.B3.isHide()) {
							this.B3.setVisible(true);
						}
					}
				}

			}else{
				this.B1.setVisible(true);
				this.B2.setVisible(true);
				this.B3.setVisible(true);
				this.A1.setVisible(false);
				this.A2.setVisible(false);
				this.A3.setVisible(false);
				for(ActualBlock block : (ArrayList<ActualBlock>)notifingObject.getValue()) {
					if (block.getX() == this.A1.x && block.getY() == this.A1.y) {
						if(!this.A1.isHide()) {
							this.A1.setVisible(true);
						}
					}
					if (block.getX() == this.A2.x && block.getY() == this.A2.y) {
						if(!this.A2.isHide()) {
							this.A2.setVisible(true);
						}
					}
					if (block.getX() == this.A3.x && block.getY() == this.A3.y) {
						if(!this.A3.isHide()) {
							this.A3.setVisible(true);
						}
					}
				}
			}
		}else if(key.equals("vision")){
			this.chessBoard.see((ArrayList<ActualBlock>)notifingObject.getValue());
			this.chessBoard.setTmpBlocks((ArrayList<ActualBlock>)notifingObject.getValue());
			
		}else if(key.equals("home")){
			SamuraiPO samuraiPO = (SamuraiPO)notifingObject.getValue();
			SamuraiView tmpView = null;
			switch (samuraiPO.getNumber()){
				case 1:
					tmpView = this.A1;
					break;
				case 2:
					tmpView = this.A2;
					break;
				case 3:
					tmpView = this.A3;
					break;
				case 4:
					tmpView = this.B1;
					break;
				case 5:
					tmpView = this.B2;
					break;
				case 6:
					tmpView = this.B3;
					break;
				default:
					break;
			}
			tmpView.setActualLocation(samuraiPO.getHome().getX(), samuraiPO.getHome().getY());
			chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();
		}
	}
	
}
