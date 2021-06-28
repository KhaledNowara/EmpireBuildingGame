package view;

import engine.City;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class CityView extends SceneSuper {

    private BorderPane mainLayout;
    private Button worldMap;
    private Button endTurn;
    private VBox miltaryBuildingsLayout;
    private VBox economicalBuildingsLayout;
    private VBox centerPart;
    private HBox buildings;
    private HBox armiesLayout;
    private ImageView cityHall;
    private City city;

    public CityView( City city) {
        super();
        this.city = city;
        Region r = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
        worldMap = new Button("World Map");
        worldMap.setAlignment(Pos.TOP_LEFT);
        endTurn = new Button ("endTurn");
        super.getInfoPane().getChildren().addAll(r,worldMap,endTurn);
        mainLayout = new BorderPane();
        mainLayout.setTop(super.getInfoPane());
        miltaryBuildingsLayout = new VBox();
        miltaryBuildingsLayout.setSpacing(20);
        economicalBuildingsLayout = new VBox();
        economicalBuildingsLayout.setSpacing(20);
        buildings = new HBox(economicalBuildingsLayout,miltaryBuildingsLayout);
        centerPart = new VBox();
        centerPart.setSpacing(20);
        switch (city.getName()){
            case "Rome" : cityHall = new ImageView(images.romeCityHallImage);break;
            case "Sparta" : cityHall = new ImageView(images.spartaCityHallImage);break;
            case "Cairo" : cityHall = new ImageView(images.cairoCityHallImage);break;
        }
        centerPart.setAlignment(Pos.CENTER);
        armiesLayout = new HBox();
        //mageView v =new ImageView(images.tentImage);
			
		//armiesLayout.getChildren().add(v);
        centerPart.getChildren().addAll(cityHall,armiesLayout);
        centerPart.setMaxSize(2000, 1000);
        armiesLayout.setSpacing(20);
        mainLayout.setRight(buildings);
        mainLayout.setCenter(centerPart);
        mainLayout.getStylesheets().add("/resources/styleSheets/CityViewStyle.css");
        
    }

    public Button getEndTurn() {
        return endTurn;
    }

    public City getCity() {
        return city;
    }

    public Button getWorldMap() {
        return worldMap;
    }

    public ImageView getCityHall (){
        return cityHall;
    }

    public BorderPane getMainLayout() {
        return mainLayout;
    }

   

    public VBox getMiltaryBuildingsLayout() {
        return miltaryBuildingsLayout;
    }

   

    public VBox getEconomicalBuildingsLayout() {
        return economicalBuildingsLayout;
    }

   

    public VBox getCenterPart() {
        return centerPart;
    }

    

    public HBox getArmiesLayout() {
        return armiesLayout;
    }

   
}
