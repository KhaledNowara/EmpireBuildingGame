package view;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class WorldMapScene extends SceneSuper {
	private ImageView Rome; 
	private ImageView Sparta ; 
	private ImageView Cairo ; 
	private Button endTurn;
	private GridPane gridPane ; 
	private BorderPane  mainLayout;

	
	public ImageView getRome() {
		return Rome;
	}

	

	public ImageView getSparta() {
		return Sparta;
	}

	

	public ImageView getCairo() {
		return Cairo;
	}
	public Button getEndTurn(){
		return endTurn;
	}
	public GridPane getGridPane() {
		return gridPane;
	}
	public BorderPane getMainLayout() {
		return mainLayout;
	}

	

	public WorldMapScene() {
		super();
       	Rome = new ImageView(images.romeImage);
		Sparta = new ImageView (images.spartaImage);
		Cairo = new ImageView (images.cairoImage);
		endTurn = new Button("End Turn");
		Region r = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
		super.getInfoPane().getChildren().addAll(endTurn);
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(20);
		gridPane.setHgap(20);
	
    
		

		gridPane.add(Rome ,1,1);
		gridPane.add(new Label(""),2,1);
		gridPane.add(new Label(""),0,1);
		gridPane.add(new Label(""),1,0);
		gridPane.add(new Label(""),2,2);
		gridPane.add(Sparta,3,1);
		gridPane.add(Cairo ,2,3);
		mainLayout = new BorderPane();
		mainLayout.setCenter(gridPane);

		
		
		mainLayout.setTop(super.getInfoPane());
		mainLayout.getStylesheets().add("/resources/styleSheets/WorldMapStyle.css");

	}

}
