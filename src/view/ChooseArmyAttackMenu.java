package view;

import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import units.Army;

public class ChooseArmyAttackMenu extends MessageBox{
    private Label Title ;
    private BorderPane mainLayout;
    private VBox elements;
    private HashMap<Button,Army> Armies;
    private Button close;

    public Label getTitle() {
        return Title;
    }
    public BorderPane getMainLayout() {
        return mainLayout;
    }
    public VBox getElements() {
        return elements;
    }
    public HashMap<Button, Army> getArmies() {
        return Armies;
    }
    public Button getClose() {
        return close;
    }

    public ChooseArmyAttackMenu(Stage s, String cityName ) {
        super(s);
        Title = new Label("Pick an Army to send to " + cityName);
        Armies = new HashMap<Button,Army>();
        mainLayout = new BorderPane();
        elements = new VBox();
        close = new Button("back");
        close.setOnAction(e -> {
            super.getStage().close();
        }); 
        elements.getChildren().add(Title);
        mainLayout.setBottom(close);
        mainLayout.setCenter(elements);
        Scene sc = new Scene(mainLayout);
        super.getStage().setScene(sc);

    }





}