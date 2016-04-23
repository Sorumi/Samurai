package view;

import javafx.scene.layout.Pane;

public class PlayerPanel extends OrderPanel {
	

	private int panelWidth;
	private int panelHeight;
	private int player;//0,1
	private int currentSamurai;
	private int pointsTotal;
	public CirclePanel circlePanel;
	public PointsPanel pointsPanel;
	
	public PlayerPanel(int player, int timeTotal){
		this.player = player;
		
		circlePanel = new CirclePanel(player, timeTotal);
		pointsPanel = new PointsPanel(player);
		
		this.getChildren().add(pointsPanel);
		this.getChildren().add(circlePanel);
		
		//bounds
		if(player == 0){
			circlePanel.setLayoutX(0);
			circlePanel.setLayoutY(0);
			pointsPanel.setLayoutX(circlePanel.getBoundsInParent().getWidth()/2);
			pointsPanel.setLayoutY(circlePanel.getBoundsInParent().getHeight()-pointsPanel.getBoundsInParent().getHeight());
			this.setLayoutX(0);
			this.setLayoutY(800-circlePanel.getBoundsInParent().getHeight());
		}else{
			circlePanel.setLayoutX(pointsPanel.getBoundsInParent().getWidth()-circlePanel.getBoundsInParent().getWidth()/2);
			circlePanel.setLayoutY(0);
			pointsPanel.setLayoutX(0);
			pointsPanel.setLayoutY(circlePanel.getBoundsInParent().getHeight()-pointsPanel.getBoundsInParent().getHeight());
			this.setLayoutX(1200-this.getBoundsInParent().getWidth());
			this.setLayoutY(800-circlePanel.getBoundsInParent().getHeight());
		}
	}

	public void setCurrentSamurai(int currentSamurai){
		this.currentSamurai = currentSamurai;
		pointsPanel.setCurrentSamurai(currentSamurai);
	}
	
	public int getPlayer(){
		return this.player;
	}

}
