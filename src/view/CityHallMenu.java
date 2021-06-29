package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class CityHallMenu extends MessageBox{

    private Label title;
    private HBox header;
    private Label revenue;
    private Label gold;
    private Label food;
    private Button build;
    private Button createArmy;
    private Button close;
    private VBox mainLayout;
    private HBox defendingArmy;
    //fprivate Label attackingArmies;
    private Label defArmy;
    private Label warning;

    public Label getWarning() {
        return warning;
    }

    public void setWarning(Label warning) {
        this.warning = warning;
    }

    public CityHallMenu (Stage s,int food, int gold, String cityName){
        super(s);
        title = new Label(cityName);
        Region r = new Region();
        VBox.setVgrow(r,Priority.ALWAYS);
        revenue = new Label("This turn's revenue");
        if (food < 0 ) this.food = new Label ("Food: - " + Math.abs(food));
        else this.food = new Label("Food: + " + food);
        if (gold < 0) this.gold = new Label ("Gold: - " + Math.abs(gold));
        else this.gold = new Label ("Gold: + " + gold);
        header = new HBox();
        header.getChildren().addAll(revenue, this.gold, this.food);
        header.setSpacing(30);
        header.setAlignment(Pos.CENTER);
        defArmy = new Label("Our defending army");
        //ttackingArmies = new Label("Attacking armies located in this city");
        defendingArmy = new HBox();
        defendingArmy.setSpacing(30);
        defendingArmy.getChildren().add(defArmy);
        build = new Button("Build a new Building");
        defendingArmy.setAlignment(Pos.CENTER);
        warning = new Label ("");
        createArmy = new Button("Create an attacking army");
        close = new Button("Close");
        close.setOnAction(e->{
            super.getParentStage().show();
            super.getStage().close();
            });
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(title, header,defendingArmy,createArmy,warning,build,close);
        mainLayout.setSpacing(30);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getStylesheets().add("/resources/styleSheets/MenuStyle.css");
        mainLayout.setPadding(new Insets(10));
        Scene sc = new Scene(mainLayout);
        sc.setFill(Color.TRANSPARENT);
        super.getStage().setScene(sc);


    }

    public HBox getDefendingArmy() {
        return defendingArmy;
    }

    public Label getTitle() {
        return title;
    }

    

    public HBox getHeader() {
        return header;
    }

    

    public Label getRevenue() {
        return revenue;
    }

   

    public Label getGold() {
        return gold;
    }

   
    public Label getFood() {
        return food;
    }

    

    public Button getBuild() {
        return build;
    }

    

    public Button getCreateArmy() {
        return createArmy;
    }

   

    public Button getClose() {
        return close;
    }

    

    public VBox getMainLayout() {
        return mainLayout;
    }

    

}
