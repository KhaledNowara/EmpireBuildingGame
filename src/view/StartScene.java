package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartScene {
	
	private Label name;
	private String cityName;
	private TextField nameText;
	private HBox nameComponent;
	private Button cityButton;
	private Button startGame;
	private Label chosenCity;
	private VBox mainLayout;

	public Label getChosenCity() {
		return chosenCity;
	}
	public Label getName() {
		return name;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public TextField getNameText() {
		return nameText;
	}
	public HBox getNameComponent() {
		return nameComponent;
	}
	public Button getCityButton() {
		return cityButton;
	}
	public Button getStartGame() {
		return startGame;
	}

	public VBox getMainLayout() {
		return mainLayout;
	}
	public StartScene() {
		name = new Label("Player Name");
		nameText = new TextField();
		nameText.setPromptText("Enter your name");
		nameText.setFocusTraversable(false);
		nameText.setId("text-field");
		nameComponent = new HBox();
		nameComponent.setAlignment(Pos.CENTER);
		nameComponent.getChildren().addAll(name,nameText);
		nameComponent.setSpacing(20);

		cityButton = new Button("Pick City");
		cityButton.setFocusTraversable(false);
		cityButton.setPrefSize(800, 100);

		startGame = new Button("Start New Game");
		startGame.setFocusTraversable(false);
		startGame.setPrefSize(800, 100);

		chosenCity = new Label();

		
		mainLayout = new VBox();
		mainLayout.getChildren().addAll(nameComponent,cityButton,startGame,chosenCity);
		mainLayout.setAlignment(Pos.CENTER);
		mainLayout.setSpacing(20);
		mainLayout.setId("test");
		//mainLayout.getStylesheets().add("/resources/styleSheets/TextField.css");

		mainLayout.getStylesheets().add("/resources/styleSheets/StartGameStyle.css");
	
		
	}

}
