package samuraitest;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//TODO
			SamuraiView samurai = new SamuraiView(1, 2);
			root.getChildren().add(samurai);
			
			Button btnS1 = new Button("A1");
			btnS1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setSamurai(1);
				}
			});
			Button btnS2 = new Button("A2");
			btnS2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setSamurai(2);
				}
			});
			Button btnS3 = new Button("A3");
			btnS3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setSamurai(3);
				}
			});
			Button btnS4 = new Button("B1");
			btnS4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setSamurai(4);
				}
			});
			Button btnS5 = new Button("B2");
			btnS5.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setSamurai(5);
				}
			});
			Button btnS6 = new Button("B3");
			btnS6.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setSamurai(6);
				}
			});
			
			Button btnM0 = new Button("up");
			btnM0.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.move(0);
				}
			});
			Button btnM1 = new Button("left");
			btnM1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.move(1);
				}
			});
			Button btnM2 = new Button("right");
			btnM2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.move(2);
				}
			});
			Button btnM3 = new Button("down");
			btnM3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.move(3);
				}
			});
			Button btnO0 = new Button("up");
			btnO0.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.occupy(0);
				}
			});
			Button btnO1 = new Button("left");
			btnO1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.occupy(1);
				}
			});
			Button btnO2 = new Button("right");
			btnO2.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.occupy(2);
				}
			});
			Button btnO3 = new Button("down");
			btnO3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.occupy(3);
				}
			});
			
			//action
			Button btnInjured = new Button("injured");
			btnInjured.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setInjured(true);
				}
			});
			Button btnMiss = new Button("miss");
			btnMiss.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setMiss(0);
				}
			});
			Button btnAttacked = new Button("attacked");
			btnAttacked.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setAttacked(53);
				}
			});
			Button btnDouble = new Button("double attacked");
			btnDouble.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setDoubleAttacked(33);
				}
			});
			
			//spear
			Button btnW011 = new Button("spear011");
			btnW011.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(11);
				}
			});
			Button btnW012 = new Button("spear012");
			btnW012.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(12);
				}
			});
			Button btnW013 = new Button("spear013");
			btnW013.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(13);
				}
			});
			Button btnW014 = new Button("spear014");
			btnW014.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(14);
				}
			});
			Button btnW015 = new Button("spear015");
			btnW015.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(15);
				}
			});
			Button btnW016 = new Button("spear016");
			btnW016.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(16);
				}
			});
			Button btnW023 = new Button("spear023");
			btnW023.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(23);
				}
			});
			Button btnW025 = new Button("spear025");
			btnW025.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(25);
				}
			});
			Button btnW026 = new Button("spear026");
			btnW026.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(26);
				}
			});
			Button btnW033 = new Button("spear033");
			btnW033.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(33);
				}
			});
			Button btnW034 = new Button("spear034");
			btnW034.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(34);
				}
			});
			Button btnW035 = new Button("spear035");
			btnW035.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(35);
				}
			});
			Button btnW036 = new Button("spear036");
			btnW036.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(36);
				}
			});
			
			//sword
			Button btnW111 = new Button("sword111");
			btnW111.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(111);
				}
			});
			Button btnW112 = new Button("sword112");
			btnW112.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(112);
				}
			});
			Button btnW113 = new Button("sword113");
			btnW113.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(113);
				}
			});
			Button btnW114 = new Button("sword114");
			btnW114.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(114);
				}
			});
			Button btnW115 = new Button("sword115");
			btnW115.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(115);
				}
			});
			Button btnW116 = new Button("sword116");
			btnW116.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(116);
				}
			});
			Button btnW124 = new Button("sword124");
			btnW124.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(124);
				}
			});
			Button btnW125 = new Button("sword125");
			btnW125.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(125);
				}
			});
			Button btnW126 = new Button("sword126");
			btnW126.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(126);
				}
			});
			Button btnW132 = new Button("sword132");
			btnW132.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(132);
				}
			});
			Button btnW133 = new Button("sword133");
			btnW133.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(133);
				}
			});
			Button btnW134 = new Button("sword134");
			btnW134.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(134);
				}
			});
			Button btnW135 = new Button("sword135");
			btnW135.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(135);
				}
			});
			Button btnW136 = new Button("sword136");
			btnW136.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(136);
				}
			});
			
			//battleax
			Button btnW211 = new Button("battleax211");
			btnW211.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(211);
				}
			});
			Button btnW212 = new Button("battleax212");
			btnW212.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(212);
				}
			});
			Button btnW213 = new Button("battleax213");
			btnW213.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(213);
				}
			});
			Button btnW214 = new Button("battleax214");
			btnW214.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(214);
				}
			});
			Button btnW215 = new Button("battleax215");
			btnW215.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(215);
				}
			});
			Button btnW216 = new Button("battleax216");
			btnW216.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(216);
				}
			});
			Button btnW225 = new Button("battleax225");
			btnW225.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(225);
				}
			});
			Button btnW226 = new Button("battleax226");
			btnW226.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(226);
				}
			});
			Button btnW233 = new Button("battleax233");
			btnW233.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(233);
				}
			});
			Button btnW234 = new Button("battleax234");
			btnW234.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(234);
				}
			});
			Button btnW235 = new Button("battleax235");
			btnW235.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(235);
				}
			});
			Button btnW236 = new Button("battleax236");
			btnW236.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(236);
				}
			});

			Button btnW3 = new Button("shuiken");
			btnW3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(300);
				}
			});
			
			Button btnW4 = new Button("bow");
			btnW4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					samurai.setWeapon(400);
				}
			});
			
			HBox hboxSamurai = new HBox();
			hboxSamurai.getChildren().addAll(btnS1, btnS2, btnS3, btnS4, btnS5, btnS6);
			
			HBox hboxMove = new HBox();
			hboxMove.getChildren().addAll(btnM0, btnM1, btnM2, btnM3);

			HBox hboxOccupy = new HBox();
			hboxOccupy.getChildren().addAll(btnO0, btnO1, btnO2, btnO3);

			HBox hboxAction = new HBox();
			hboxAction.getChildren().addAll(btnInjured, btnMiss, btnAttacked, btnDouble);
			
			HBox hboxW01 = new HBox();
			hboxW01.getChildren().addAll(btnW011, btnW012, btnW013, btnW014, btnW015, btnW016);
			
			HBox hboxW02 = new HBox();
			hboxW02.getChildren().addAll(btnW023, btnW025, btnW026);
			
			HBox hboxW03 = new HBox();
			hboxW03.getChildren().addAll(btnW033, btnW034, btnW035, btnW036);			
			
			HBox hboxW11 = new HBox();
			hboxW11.getChildren().addAll(btnW111, btnW112, btnW113, btnW114, btnW115, btnW116);
			
			HBox hboxW12 = new HBox();
			hboxW12.getChildren().addAll(btnW124, btnW125, btnW126);
			
			HBox hboxW13 = new HBox();
			hboxW13.getChildren().addAll(btnW132, btnW133, btnW134, btnW135, btnW136);
			
			HBox hboxW21 = new HBox();
			hboxW21.getChildren().addAll(btnW211, btnW212, btnW213, btnW214, btnW215, btnW216);
			
			HBox hboxW22 = new HBox();
			hboxW22.getChildren().addAll(btnW225, btnW226);
			
			HBox hboxW23 = new HBox();
			hboxW23.getChildren().addAll(btnW233, btnW234, btnW235, btnW236);			
			
			
			HBox hboxWeapon = new HBox();
			hboxWeapon.getChildren().add(btnW3);
			hboxWeapon.getChildren().add(btnW4);
			
			VBox vbox = new VBox();
			vbox.setLayoutX(500);
			vbox.setLayoutY(0);
			
			vbox.getChildren().addAll(hboxSamurai, hboxMove, hboxOccupy, hboxAction, hboxW01, hboxW02, hboxW03, hboxW11, hboxW12, hboxW13, hboxW21, hboxW22, hboxW23, hboxWeapon);

			root.getChildren().add(vbox);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
