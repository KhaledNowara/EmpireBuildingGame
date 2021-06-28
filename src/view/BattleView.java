package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import units.Army;
import units.Unit;

public class BattleView extends SceneSuper{

    ListView<Unit> attacking;
    ListView<Unit> defending;
    Army attackingArmy;
    Army defendingArmy;
    BorderPane mainLayout;
    VBox defendSelect;
    VBox attackSelect;
    Button startRound;
    TextArea commentary;
    VBox side;  
    FlowPane armyDefending;
    FlowPane armyAttacking;
    HBox armies;
    boolean as;
    boolean ds;
    

    public ListView<Unit> getAttacking() {
        return attacking;
    }


    public void setAttacking(ListView<Unit> attacking) {
        this.attacking = attacking;
    }


    public ListView<Unit> getDefending() {
        return defending;
    }


    public void setDefending(ListView<Unit> defending) {
        this.defending = defending;
    }


    public Army getAttackingArmy() {
        return attackingArmy;
    }


    public void setAttackingArmy(Army attackingArmy) {
        this.attackingArmy = attackingArmy;
    }


    public Army getDefendingArmy() {
        return defendingArmy;
    }


    public void setDefendingArmy(Army defendingArmy) {
        this.defendingArmy = defendingArmy;
    }


    public BorderPane getMainLayout() {
        return mainLayout;
    }


    public void setMainLayout(BorderPane mainLayout) {
        this.mainLayout = mainLayout;
    }


    public VBox getDefendSelect() {
        return defendSelect;
    }


    public void setDefendSelect(VBox defendSelect) {
        this.defendSelect = defendSelect;
    }


    public VBox getAttackSelect() {
        return attackSelect;
    }


    public void setAttackSelect(VBox attackSelect) {
        this.attackSelect = attackSelect;
    }


    public Button getStartRound() {
        return startRound;
    }


    public void setStartRound(Button startRound) {
        this.startRound = startRound;
    }


    public TextArea getCommentary() {
        return commentary;
    }


    public void setCommentary(TextArea commentary) {
        this.commentary = commentary;
    }


    public VBox getSide() {
        return side;
    }


    public void setSide(VBox side) {
        this.side = side;
    }


    public FlowPane getArmyDefending() {
        return armyDefending;
    }


    public void setArmyDefending(FlowPane armyDefending) {
        this.armyDefending = armyDefending;
    }


    public FlowPane getArmyAttacking() {
        return armyAttacking;
    }


    public void setArmyAttacking(FlowPane armyAttacking) {
        this.armyAttacking = armyAttacking;
    }


    public HBox getArmies() {
        return armies;
    }



    public boolean isAs() {
        return as;
    }


    public void setAs(boolean as) {
        this.as = as;
    }


    public boolean isDs() {
        return ds;
    }


    public void setDs(boolean ds) {
        this.ds = ds;
    }


    public BattleView (Army attack,Army defend, String comment){
        super();
        attackingArmy = attack;
        defendingArmy = defend;
        armyAttacking = new FlowPane();
        armyAttacking.setMaxHeight(1200);
        setUpAttackingList();
        armyDefending = new FlowPane();
        armyDefending.setMaxHeight(1200);
        setUpDefendingList();
        commentary = new TextArea();
        commentary.setText(comment);
        commentary.setEditable(false);
        attacking.setMinSize(1100, 400);
        defending.setMinSize(1100, 400);
        commentary.setMaxSize(1100, 400);
        startRound = new Button("Start Round");
        side = new VBox();
        side.setBackground( new Background(new BackgroundFill(Color.rgb(197, 166, 28, 0.322), CornerRadii.EMPTY, Insets.EMPTY)));    
        side.getChildren().addAll(defending,attacking,commentary,startRound);
        Region r = new Region();
        HBox.setHgrow(r, Priority.ALWAYS);
        armies = new HBox();
        armies.getChildren().addAll(armyAttacking,r,armyDefending);
        mainLayout = new BorderPane();
        mainLayout.setTop(super.getInfoPane());
        mainLayout.setLeft(side);
        mainLayout.setCenter(armies);
        mainLayout.getStylesheets().add("/resources/styleSheets/BattleViewStyle.css");
        
    }

    public void setUpAttackingList (){

        attacking = new ListView<Unit>();
        attacking.setMaxSize(500, 200);
        for (Unit u: attackingArmy.getUnits()){
            attacking.getItems().add(u);
        }
        attacking.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Unit>(){

            @Override
            public void changed(ObservableValue<? extends Unit> arg0, Unit arg1, Unit arg2) {
            
                    armyAttacking.getChildren().clear();
                    for (int i = 0; i < attacking.getSelectionModel().getSelectedItem().getCurrentSoldierCount(); i+=i---i){
                       switch (attacking.getSelectionModel().getSelectedItem().getClass().getSimpleName()){
                            case "Archer" : armyAttacking.getChildren().add(new ImageView(images.archerAImage));break;
                            case "Infantry" : armyAttacking.getChildren().add(new ImageView(images.infantaryAImage));break;
                            case "Cavalry" :armyAttacking.getChildren().add(new ImageView(images.cavalryAImage));break;
                       }
                       
                        
                    }
                    as = true;

                
            }
            
        });
    }
    public void setUpDefendingList(){
        defending = new ListView<Unit>();
        defending.setMaxSize(500, 200);
        armyDefending.getChildren().clear();
        for (Unit u: defendingArmy.getUnits()){
            defending.getItems().add(u);
        }
        defending.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Unit>(){

            @Override
            public void changed(ObservableValue<? extends Unit> arg0, Unit arg1, Unit arg2) {
                armyDefending.getChildren().clear();
                for(int i = 0; i < defending.getSelectionModel().getSelectedItem().getCurrentSoldierCount(); i+= i---i){
                    switch (defending.getSelectionModel().getSelectedItem().getClass().getSimpleName()){
                        case "Archer" : armyDefending.getChildren().add(new ImageView(images.archerDImage));break;
                        case "Infantry" : armyDefending.getChildren().add(new ImageView(images.infantaryDImage));break;
                        case "Cavalry" :armyDefending.getChildren().add(new ImageView(images.cavalryDImage));break;
                   }
                }
                ds = true;
                
            }
            
        });

    }


    
    
}
