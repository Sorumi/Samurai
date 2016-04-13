package view.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;

import controller.msgqueue.ActionOperation;
import controller.msgqueue.NextOperation;
import controller.msgqueue.Operation;
import controller.msgqueue.OperationQueue;
import view.GamePanel;

public class GameListener implements MouseListener{
	
	private GamePanel game;
	private int action;//0:occupy 1:move 2:show 3:hide
	
	public GameListener(GamePanel game){
		this.game = game;
	}

	public GameListener() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	//actionNum: 0:occupy 1:move 2:show 3:hide
	//direction: 0:up 1:left 2:right 3:down
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == game.getCurrentSamurai()) {
			game.getActionButtons().setVisible(true);
			game.getArrow().setVisible(false);
			game.setLayer(game.getArrow(), JLayeredPane.DEFAULT_LAYER, 0);
			game.setLayer(game.getActionButtons(), JLayeredPane.DRAG_LAYER);
		} else if (e.getSource() == game.getActionButtons().getMoveButton()) {
			game.getActionButtons().setSecondary(true);
			action = 1;
			//发送判断
			//出现（四个方向的）箭头
		} else if (e.getSource() == game.getActionButtons().getOccupyButton()) {
			game.getActionButtons().setSecondary(true);
			action = 0;
			//发送判断
			//出现四个方向的箭头
		} else if (e.getSource() == game.getActionButtons().getHideButton()) {
			System.out.println("hide");
			Operation op = new ActionOperation(2, 0);
			OperationQueue.addOperation(op);
		} else if (e.getSource() == game.getActionButtons().getBackButton()) {
			game.getActionButtons().setSecondary(false);
		} else if (e.getSource() == game.getActionButtons().getExitButton()) {
			game.getActionButtons().setSecondary(false);
			//进入下一轮
			Operation op = new NextOperation();
			OperationQueue.addOperation(op);
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getUpButton()) {
			System.out.println("up");
			Operation op = new ActionOperation(action, 0);
			OperationQueue.addOperation(op);
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getLeftButton()) {
			System.out.println("left");
			Operation op = new ActionOperation(action, 1);
			OperationQueue.addOperation(op);
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getRightButton()) {
			System.out.println("right");
			Operation op = new ActionOperation(action, 2);
			OperationQueue.addOperation(op);
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getDownButton()) {
			System.out.println("down");
			Operation op = new ActionOperation(action, 3);
			OperationQueue.addOperation(op);
		} else {
			game.getActionButtons().setVisible(false);
			game.getActionButtons().setSecondary(false);
			game.getArrow().setVisible(true);
			game.setLayer(game.getActionButtons(), JLayeredPane.DEFAULT_LAYER);
			game.setLayer(game.getArrow(), JLayeredPane.DRAG_LAYER);
		}
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == game.getActionButtons().getDirectionPanel().getUpButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(0, true);
		}else if(e.getSource() == game.getActionButtons().getDirectionPanel().getLeftButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(1, true);
		}else if(e.getSource() == game.getActionButtons().getDirectionPanel().getRightButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(2, true);
		}else if(e.getSource() == game.getActionButtons().getDirectionPanel().getDownButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(3, true);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == game.getActionButtons().getDirectionPanel().getUpButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(0, false);
		}else if(e.getSource() == game.getActionButtons().getDirectionPanel().getLeftButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(1, false);
		}else if(e.getSource() == game.getActionButtons().getDirectionPanel().getRightButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(2, false);
		}else if(e.getSource() == game.getActionButtons().getDirectionPanel().getDownButton()){
			game.getActionButtons().getDirectionPanel().setHighLight(3, false);
		}
	}

}
