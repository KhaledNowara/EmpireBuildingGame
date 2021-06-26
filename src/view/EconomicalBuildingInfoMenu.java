package view;


import buildings.EconomicBuilding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EconomicalBuildingInfoMenu extends MessageBox{
    
    private Label TypeLevel;
    private Label revenue;
    private Label cost;
    private Label warning;
    private Button upgrade; 
    private Button close;
    private HBox footer;
    private VBox mainLayout;
    private EconomicBuilding b;


    public Label getTypeLevel() {
        return TypeLevel;
    }

    public Label getRevenue() {
        return revenue;
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
    public EconomicBuilding getB() {
        return b;
    }
    public Label getWarning (){
        return warning;
    }
    
   


    public EconomicalBuildingInfoMenu(Stage s,EconomicBuilding b ) {
        super(s);
        this.b = b;
        TypeLevel = new Label(b.getClass().getSimpleName() + ", Level: " + b.getLevel());
        if (b.getClass().getSimpleName().equals("Farm"))
        revenue = new Label("This farm generates " + b.harvest() + " food");
        else revenue = new Label("This market generates " + b.harvest() + " gold");
        cost = new Label ("Upgrade cost: " + b.getCost());
        warning = new Label("");
        upgrade = new Button("Upgrade Builiding");
        close = new Button("close");
        close.setOnAction(e -> {
            super.getParentStage().show();
            super.getStage().close();
        });
        footer = new HBox();
        footer.getChildren().addAll(cost,upgrade,close);
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(TypeLevel,revenue,warning,footer);

        Scene sc = new Scene(mainLayout);
        super.getStage().setScene(sc);
    }
    
}