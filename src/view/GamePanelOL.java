package view;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import model.GameModel;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Position;
import model.po.SamuraiPO;
import view.eventhandler.ActionHandler;

import javafx.beans.value.ChangeListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Kray on 16/4/18.
 */
public class GamePanelOL extends GamePanel{


    public GamePanelOL(int size){
        super(size, 0);
    }

    public void setCurrentSamurai(int i){
        if(currentSamurai != null){
            currentSamurai.setOnMouseClicked(null);
        }
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
        currentSamurai.setOnMouseClicked(actionHandler.samuraiEvent);
        currentSamurai.setCanActionProperty(true);
        currentSamurai.samuraiV.setRandomAnimation(false);

        playerA.pointsPanel.setCurrentSamurai(currentSamurai.getNum());
        playerB.pointsPanel.setCurrentSamurai(currentSamurai.getNum());
        if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)){
            arrow.setCurrentSamurai(currentSamurai);
            actionPanel.setCurrentSamurai(currentSamurai);
            roundPanel.setCurrentSamurai(currentSamurai.getNum());
            currentSamurai.canActionProperty().addListener(new ChangeListener(){
                public void changed(ObservableValue o, Object oldVal, Object newVal){
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            boolean canAction= (boolean) newVal;
                            if(canAction){
                                arrow.setActualLocation();
                                arrow.setVisible(true);
                            }
                        }
                    });
                }
            });
        }else{
            arrow.setVisible(false);
            actionPanel.setVisible(false);
        }
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
            this.setCurrentPlayer((int)notifingObject.getValue());

        }else if(key.equals("round")){
            this.setCurrentRound((int)notifingObject.getValue());

        }else if(key.equals("time")){
            System.out.println("time" + (int) notifingObject.getValue());
            int i = this.currentSamurai.getNum();
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)){
                this.currentPlayer.circlePanel.setTimeRest((int) notifingObject.getValue());
            }

        }else if(key.equals("actionPoint")){

            int i = this.currentSamurai.getNum();
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)) {
                this.currentPlayer.pointsPanel.setPointsRest((int) notifingObject.getValue());
                this.actionPanel.setPointsRest((int) notifingObject.getValue());
            }

        }else if(key.equals("pointsTotal")){

            int i = this.currentSamurai.getNum();
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)) {
                this.currentPlayer.pointsPanel.setPointsTotal((int) notifingObject.getValue());
            }

        }else if(key.equals("samuraiMove")){
            Position position = (Position)notifingObject.getValue();
            int i = this.currentSamurai.getNum();
//            this.currentSamurai.setActualLocation(position.getX(), position.getY());
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)) {
                this.currentSamurai.move(position.getX(), position.getY());
                this.actionPanel.reset();
                this.setOrder();
            }

        }else if(key.equals("samuraiHide")){

            int i = this.currentSamurai.getNum();
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)) {
                this.currentSamurai.setHide((boolean) notifingObject.getValue());
            }
        }else if(key.equals("samuraiOccupy")){
			this.currentSamurai.occupy((int)notifingObject.getValue());
            int i = this.currentSamurai.getNum();
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)) {
                this.actionPanel.reset();
                this.arrow.setVisible(true);
            }
			
        }else if(key.equals("samuraiKilled")){

        }else if(key.equals("visible")) {
            if(GameModel.isClient() && !GameModel.isServer()) {
                this.B1.setVisible(true);
                this.B2.setVisible(true);
                this.B3.setVisible(true);
                this.A1.setVisible(false);
                this.A2.setVisible(false);
                this.A3.setVisible(false);
                for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()) {
                    if (block.getX() == this.A1.x && block.getY() == this.A1.y) {
                        if (!this.A1.isHide()) {
                            this.A1.setVisible(true);
                        }
                    }
                    if (block.getX() == this.A2.x && block.getY() == this.A2.y) {
                        if (!this.A2.isHide()) {
                            this.A2.setVisible(true);
                        }
                    }
                    if (block.getX() == this.A3.x && block.getY() == this.A3.y) {
                        if (!this.A3.isHide()) {
                            this.A3.setVisible(true);
                        }
                    }
                }
            }else if(!GameModel.isClient() && GameModel.isServer()) {
                this.A1.setVisible(true);
                this.A2.setVisible(true);
                this.A3.setVisible(true);
                this.B1.setVisible(false);
                this.B2.setVisible(false);
                this.B3.setVisible(false);
                for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()) {
                    if (block.getX() == this.B1.x && block.getY() == this.B1.y) {
                        if (!this.B1.isHide()) {
                            this.B1.setVisible(true);
                        }
                    }
                    if (block.getX() == this.B2.x && block.getY() == this.B2.y) {
                        if (!this.B2.isHide()) {
                            this.B2.setVisible(true);
                        }
                    }
                    if (block.getX() == this.B3.x && block.getY() == this.B3.y) {
                        if (!this.B3.isHide()) {
                            this.B3.setVisible(true);
                        }
                    }
                }
            }
        }else if(key.equals("vision")){
            this.chessBoard.see((ArrayList<ActualBlock>)notifingObject.getValue());
            this.chessBoard.setTmpBlocks((ArrayList<ActualBlock>)notifingObject.getValue());
        }else if(key.equals("home")){
            SamuraiPO samuraiPO = (SamuraiPO)notifingObject.getValue();
            SamuraiPanel tmpView = null;
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
            this.chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();
        }else if(key.equals("occupiedBlocks")){
            int[] n = (int [])notifingObject.getValue();
            this.playerA.circlePanel.setBlocks(new int[]{n[1], n[2], n[3]});
            this.playerB.circlePanel.setBlocks(new int[]{n[4], n[5], n[6]});
        }else if(key.equals("revive")){
            System.out.println("Samurai revive!" + (int)notifingObject.getValue());
        }else if(key.equals("pseudoOccupy")){
            this.chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), true);
        }else if(key.equals("a-pseudoOccupy")){
            this.chessBoard.pseudoOccupy((ArrayList<Position>) notifingObject.getValue(), false);
        }
    }

}
