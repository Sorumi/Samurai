package view.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == game.getCurrentSamurai()) {
			game.getActionButtons().setVisible(true);
			game.getArrow().setVisible(false);
		} else if (e.getSource() == game.getActionButtons().getMoveButton()) {
			game.getActionButtons().setSecondary(true);
			action = 0;
			//发送判断
			//出现（四个方向的）箭头
		} else if (e.getSource() == game.getActionButtons().getOccupyButton()) {
			game.getActionButtons().setSecondary(true);
			action = 1;
			//发送判断
			//出现四个方向的箭头
		} else if (e.getSource() == game.getActionButtons().getHideButton()) {
			//
		} else if (e.getSource() == game.getActionButtons().getBackButton()) {
			game.getActionButtons().setSecondary(false);
			//
		} else if (e.getSource() == game.getActionButtons().getExitButton()) {
			game.getActionButtons().setSecondary(false);
			//进入下一轮
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getUpButton()) {
				//0:move 1:occupy 
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getLeftButton()) {
				//0:move 1:occupy 
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getRightButton()) {
				//0:move 1:occupy 
		} else if (e.getSource() == game.getActionButtons().getDirectionPanel().getDownButton()) {
				//0:move 1:occupy 
		} else {
			game.getActionButtons().setVisible(false);
			game.getActionButtons().setSecondary(false);
			game.getArrow().setVisible(true);
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
