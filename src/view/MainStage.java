package view;

import java.awt.Toolkit;

import controller.GameController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainStage extends Application {
	public final int ScreenWidth = 3072;
	public final int ScreenHeight = 1728;

	private StartScene startScene;
	private Scene scene ;
	private GameController gameController ; 

	public StartScene getStartScene() {
		return startScene;
	}

	public Scene getScene() {
		return scene;
	}

	@Override
	public void start(Stage stage) throws Exception {
		Image logo = new Image("/resources/Images/LOGO.png");
       // ImageView v = new ImageView(logo);
		startScene= new StartScene();
		scene = new Scene(startScene.getMainLayout());
	
		
		stage.setScene(scene);
		stage.setTitle(" The Conqueror");
		stage.getIcons().add(logo);
		//stage.setResizable(false);
		//stage.setFullScreen(true);
		stage.setMaximized(true);
		stage.show();

		gameController = new GameController(this,stage);
		//gameController.Sparta = w.getSparta();



			
	}

	public void changeViews (Parent view){
		scene.setRoot(view);
	}

	public static void main(String[] args){
        launch(args);
	; 

	}
}
