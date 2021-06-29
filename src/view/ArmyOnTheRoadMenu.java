package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import units.Army;
import units.Unit;

public class ArmyOnTheRoadMenu extends MessageBox{

    Label DistanceToTarget;
    Label ArmyName;
    Label unitsLabel;
    ComboBox<Unit> units;
    VBox mainLayout;
    Button close;

    public ArmyOnTheRoadMenu(Stage s,Army a) {
        super(s);
        ArmyName = new Label (a.getName());
        DistanceToTarget = new Label ("The army will reach it's target in " + a.getDistancetoTarget() + " Turns");
        unitsLabel = new Label("units");
        units = new ComboBox<Unit>();
        units.setPromptText("Units");
        for (Unit u : a.getUnits()){
            units.getItems().add(u);
        }
        close = new Button ("close");
        close.setOnAction(e->{
            super.getParentStage().show();
            super.getStage().close();
        });
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(ArmyName,unitsLabel,units,DistanceToTarget,close);
        mainLayout.setSpacing(30);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getStylesheets().add("/resources/styleSheets/MenuStyle.css");
        mainLayout.setPadding(new Insets(10));
        Scene sc = new Scene(mainLayout);
        sc.setFill(Color.TRANSPARENT);
        super.getStage().setScene(sc);

    }
    
}
