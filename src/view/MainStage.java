package view;

import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainStage extends Application {
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
		startScene= new StartScene();
		scene = new Scene(startScene.getMainLayout());
		stage.setScene(scene);
		stage.setTitle("The Conqurer");
		stage.show();

		gameController = new GameController(this);



			
	}

	public static void main(String[] args){
        launch(args); 
    }
}
