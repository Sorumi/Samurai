package view.game;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import view.OrderPanel;

public class PlayerPanel extends OrderPanel {
	
	private int player;//0,1
	public CirclePanel circlePanel;
	public PointsPanel pointsPanel;
	
	public PlayerPanel(int player, int timeTotal){
		this.player = player;
		
		circlePanel = new CirclePanel(player, timeTotal);
		pointsPanel = new PointsPanel(player);
		
		this.getChildren().addAll(pointsPanel, circlePanel);	

		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(2.0);
		dropShadow.setOffsetX(0.0);
		dropShadow.setOffsetY(1.0);
		dropShadow.setColor(Color.rgb(0,0,0,0.5));
		
		this.setEffect(dropShadow);
		
		//bounds
		if(player == 0){
			circlePanel.setLayoutX(0);
			circlePanel.setLayoutY(0);
			pointsPanel.setLayoutX(circlePanel.getBoundsInParent().getWidth()/2+15);
			pointsPanel.setLayoutY(circlePanel.getBoundsInParent().getHeight()-pointsPanel.getBoundsInParent().getHeight());
			this.setLayoutX(0);
			this.setLayoutY(800-circlePanel.getBoundsInParent().getHeight());
		}else{
			circlePanel.setLayoutX(pointsPanel.getBoundsInParent().getWidth()-circlePanel.getBoundsInParent().getWidth()/2);
			circlePanel.setLayoutY(0);
			pointsPanel.setLayoutX(-15);
			pointsPanel.setLayoutY(circlePanel.getBoundsInParent().getHeight()-pointsPanel.getBoundsInParent().getHeight());
			this.setLayoutX(1200-this.getBoundsInParent().getWidth());
			this.setLayoutY(800-circlePanel.getBoundsInParent().getHeight());
		}
	}

	public int getPlayer(){
		return this.player;
	}

}
