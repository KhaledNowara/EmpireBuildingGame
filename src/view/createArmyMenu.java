package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import units.Unit;

public class createArmyMenu extends MessageBox {
    private Label title;
    private Label armyNameLabel;
    private TextField armyName;
    private HBox arn; 
    private ListView<Unit> list;
    private Label warning;
    private Button createArmy;
    private VBox mainLayout;
    private Button close;
    private HBox footer;
    public Label getTitle() {
        return title;
    }

    public Label getArmyNameLabel() {
        return armyNameLabel;
    }
    public TextField getArmyName() {
        return armyName;
    }
    public HBox getArn() {
        return arn;
    }
    public ListView<Unit> getList() {
        return list;
    }
    public Label getWarning() {
        return warning;
    }
    public Button getCreateArmy() {
        return createArmy;
    }
    public VBox getMainLayout() {
        return mainLayout;
    }

    public createArmyMenu(Stage s) {
        super(s);
        title = new Label ("Create a new Army");
        armyNameLabel = new Label("Army Name");
        armyName = new TextField();
        armyName.setPromptText("Enter army Name");
        arn = new HBox();
        arn.getChildren().addAll(armyNameLabel,armyName);
        list = new ListView<Unit>();
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        warning = new Label ("");
        createArmy = new Button("Create army");
        close = new Button("close");
        close.setOnAction(e-> {
            super.getParentStage().show();
            super.getStage().close();
        });
        footer = new HBox();
        footer.getChildren().addAll(createArmy,close);
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(title,arn,list,warning,footer);
        Scene sc = new Scene(mainLayout);
        super.getStage().setScene(sc);
    }
    
}
