package main;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import fonts.FontManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.GameModel;
import musics.Musics;
import view.BasePanel;
import view.GamePanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import view.MenuPanel;
import view.StartLogoPanel;
import view.StoryPanel;

/*
	*********************
	*     SamuraINF     *
	*    Produced by    *
	*       Sorumi      *
	*       KrayC       *
	*  SilverNarcissus  *
	*     Vivian-SJ     *
	*    Version 1.0    *
	*     2016-5-18     *
	*********************
 */

public class Main extends Application {
	
	private Scene scene;
	public BasePanel basePanel;
	
	@Override
	public void start(Stage primaryStage) {
		FontManager.loadAllFont();
		
		basePanel = new BasePanel();
		scene = new Scene(basePanel);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
