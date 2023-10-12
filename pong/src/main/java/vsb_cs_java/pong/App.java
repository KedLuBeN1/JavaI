package vsb_cs_java.pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application
{

	public static void main(String[] args) {
		launch(args);
	}
	
	private Canvas canvas;
	private AnimationTimer timer;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Construct a main window with a canvas.  
			Group root = new Group();
			canvas = new Canvas(800, 600);
			root.getChildren().add(canvas);
			Scene scene = new Scene(root, 800, 600);
			primaryStage.setScene(scene);
	        
			primaryStage.resizableProperty().set(false);
			primaryStage.setTitle("Pong");
			primaryStage.show();
			

			primaryStage.setOnCloseRequest(this::exitProgram);
			timer = new DrawingThread(canvas);
			timer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void stop() throws Exception {
		timer.stop();
		super.stop();
	}
	
	private void exitProgram(WindowEvent evt) {
		System.exit(0);
	}
}
