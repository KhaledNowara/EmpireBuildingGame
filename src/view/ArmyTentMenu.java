package view;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import units.Army;
import units.Unit;

public class ArmyTentMenu extends MessageBox {
    Label Armyname;
    Label unitsTitle;
    ListView<String> units;
    Label recurit;
    ListView<Unit>defendingUnits;
    Label warning;
    Button relocate;
    Button close;
    HBox footer;
    VBox mainLayout ;
    public <T> ArmyTentMenu(Stage s,Army a) {
        super(s);
        Armyname = new Label(a.getName());
        unitsTitle = new Label("Army Units");
        recurit = new Label("relocate units from defending Army");
        units = new ListView<String>();

        for (Unit u:a.getUnits()){
            units.getItems().add(u.toString());
        }
        warning = new Label("");
        close = new Button("Close");
        relocate = new Button ("Relocate Unit");
        footer = new HBox(relocate,close);

        close.setOnAction(e -> {
            super.getParentStage().show();
            super.getStage().close();
        });
        defendingUnits = new ListView<Unit>();
        mainLayout = new VBox(Armyname,unitsTitle,units,recurit,defendingUnits,warning,footer);
        Scene sc = new Scene(mainLayout);
        super.getStage().setScene(sc);
        
        
    }
    public Button getRelocate (){
        return relocate;
    }
    public Label getWarning(){
        return warning;
    }
    public Label getArmyname() {
        return Armyname;
    }
    public void setArmyname(Label armyname) {
        Armyname = armyname;
    }
    public Label getUnitsTitle() {
        return unitsTitle;
    }
    public void setUnitsTitle(Label unitsTitle) {
        this.unitsTitle = unitsTitle;
    }
    public ListView<String> getUnits() {
        return units;
    }
    public void setUnits(ListView<String> units) {
        this.units = units;
    }
    public Label getRecurit() {
        return recurit;
    }
    public void setRecurit(Label recurit) {
        this.recurit = recurit;
    }
    public ListView<Unit> getDefendingUnits() {
        return defendingUnits;
    }
    public void setDefendingUnits(ListView<Unit> defendingUnits) {
        this.defendingUnits = defendingUnits;
    }
    public Button getClose() {
        return close;
    }
    public void setClose(Button close) {
        this.close = close;
    }
    public VBox getMainLayout() {
        return mainLayout;
    }

    
}
