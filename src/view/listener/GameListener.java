package view.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GamePanel;

public class GameListener implements MouseListener{
	
	private GamePanel game;
	
	public GameListener(GamePanel game){
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if(e.getSource() == game.getCurrentSamurai()){
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
