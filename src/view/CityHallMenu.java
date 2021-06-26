package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private Label defArmy;

    public CityHallMenu (Stage s,int food, int gold, String cityName){
        super(s);
        title = new Label(cityName);
        revenue = new Label("This turn's revenue");
        if (food < 0 ) this.food = new Label ("Food: - " + Math.abs(food));
        else this.food = new Label("Food: + " + food);
        if (gold < 0) this.gold = new Label ("Gold: - " + Math.abs(gold));
        else this.gold = new Label ("Gold: + " + gold);
        header = new HBox();
        header.getChildren().addAll(revenue, this.gold, this.food);
        header.setSpacing(20);
        defArmy = new Label("Our defending army");
        defendingArmy = new HBox();
        defendingArmy.getChildren().add(defArmy);
        build = new Button("Build a new Building");
        createArmy = new Button("Create an attacking army");
        close = new Button("Close");
        close.setOnAction(e->{
            super.getParentStage().show();
            super.getStage().close();
            });
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(title, header, build,defendingArmy,createArmy,close);
        Scene sc = new Scene(mainLayout);
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
