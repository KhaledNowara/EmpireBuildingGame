package view;

import buildings.MilitaryBuilding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MilitaryBuildingInfoMenu extends  MessageBox{
    private Label TypeLevel;
    private Label unit;
    private Label cost;
    private Label recCost;
    private Label warning;
    private Button upgrade; 
    private Button close;
    private Button recruit;
    private HBox footer;
    private VBox mainLayout;
    private MilitaryBuilding b;


    public Label getTypeLevel() {
        return TypeLevel;
    }

    public Label getRecCost() {
        return recCost;
    }

    public Button getRecruit() {
        return recruit;
    }

    public Label getUnit() {
        return unit;
    }
    public Label getCost() {
        return cost;
    }
    public Button getUpgrade() {
        return upgrade;
    }
    public Button getClose() {
        return close;
    }
    public HBox getFooter() {
        return footer;
    }
    public VBox getMainLayout() {
        return mainLayout;
    }
    public MilitaryBuilding getB() {
        return b;
    }
    public Label getWarning (){
        return warning;
    }
   


    public MilitaryBuildingInfoMenu(Stage s,MilitaryBuilding b ) {
        super(s);
        this.b = b;
        TypeLevel = new Label(b.getClass().getSimpleName() + ", Level: " + b.getLevel());
        unit = new Label("This " + b.getClass().getSimpleName() + " produces " + b.recruitForView().toString());
        recCost = new Label(" Recruitment cost: " + b.getRecruitmentCost());
        cost = new Label ("Upgrade cost: " + b.getCost());
        warning = new Label("");
        upgrade = new Button("Upgrade Builiding");
        recruit = new Button("Recruit");
        close = new Button("close");
        close.setOnAction(e -> {
            super.getParentStage().show();
            super.getStage().close();
        });
        footer = new HBox();
        footer.getChildren().addAll(recruit,upgrade,close);
        footer.setSpacing(30);
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(TypeLevel,unit,warning,footer);

        mainLayout.setSpacing(30);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getStylesheets().add("/resources/styleSheets/MenuStyle.css");
        mainLayout.setPadding(new Insets(10));
        Scene sc = new Scene(mainLayout);
        sc.setFill(Color.TRANSPARENT);
        super.getStage().setScene(sc);
    }
    
    
}
