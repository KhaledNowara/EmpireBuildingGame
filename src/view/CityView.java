package view;

import java.security.PrivilegedAction;

import engine.City;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class CityView extends SceneSuper {

    private BorderPane mainLayout;
    private Button worldMap;
    private VBox miltaryBuildingsLayout;
    private HBox economicalBuildingsLayout;
    private VBox centerPart;
    private HBox armiesLayout;
    private String cityName;

    public CityView(String cityName) {
        super();
        this.cityName = cityName;
        Region r = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
        worldMap = new Button("World Map");
        worldMap.setAlignment(Pos.TOP_LEFT);
        super.getInfoPane().getChildren().addAll(r,worldMap);
        mainLayout = new BorderPane();
        mainLayout.setTop(super.getInfoPane());
        miltaryBuildingsLayout = new VBox();
        miltaryBuildingsLayout.setSpacing(20);
        economicalBuildingsLayout = new HBox();
        economicalBuildingsLayout.setSpacing(20);
        centerPart = new VBox();
        centerPart.setSpacing(20);
        centerPart.getChildren().addAll(economicalBuildingsLayout,new Label ("CityHall"));
        armiesLayout = new HBox();
        armiesLayout.setSpacing(20);
        mainLayout.setRight(miltaryBuildingsLayout);
        mainLayout.setCenter(centerPart);
        mainLayout.setBottom(armiesLayout);
        mainLayout.getStylesheets().add("/resources/styleSheets/CityViewStyle.css");
        
    }

    public Button getWorldMap() {
        return worldMap;
    }

   

    public String getCityName(){
        return cityName;
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
