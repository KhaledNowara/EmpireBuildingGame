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
    private HBox economicalBuildingsLayout;
    private VBox centerPart;
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
        economicalBuildingsLayout = new HBox();
        economicalBuildingsLayout.setSpacing(20);
        centerPart = new VBox();
        centerPart.setSpacing(20);
        switch (city.getName()){
            case "Rome" : cityHall = new ImageView(images.romeCityHallImage);break;
            case "Sparta" : cityHall = new ImageView(images.spartaCityHallImage);break;
            case "Cairo" : cityHall = new ImageView(images.cairoCityHallImage);break;
        }
        centerPart.setAlignment(Pos.CENTER);
        centerPart.getChildren().addAll(economicalBuildingsLayout,cityHall);
        armiesLayout = new HBox();
        armiesLayout.setSpacing(20);
        mainLayout.setRight(miltaryBuildingsLayout);
        mainLayout.setCenter(centerPart);
        mainLayout.setBottom(armiesLayout);
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

   

    public HBox getEconomicalBuildingsLayout() {
        return economicalBuildingsLayout;
    }

   

    public VBox getCenterPart() {
        return centerPart;
    }

    

    public HBox getArmiesLayout() {
        return armiesLayout;
    }

   
}
