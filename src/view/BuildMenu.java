package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuildMenu extends MessageBox {
    private Label title;
    private VBox miltaryBuilingsSection;
    private Label miltaryBuildingsLabel;
    private HBox miltaryBuildings;
    private HBox miltaryBuy;                         
    private VBox economicalBuilingsSection;
    private Label economicalBuildingsLabel;
    private HBox economicalBuildings;
    private HBox economicalBuy;
    private Button close;
    private Label warning;
    private VBox mainLayout;
    





    public void setMiltaryBuildings(HBox miltaryBuildings) {
        this.miltaryBuildings = miltaryBuildings;
    }
    public void setEconomicalBuy(HBox economicalBuy) {
        this.economicalBuy = economicalBuy;
    }
    public VBox getMiltaryBuilingsSection() {
        return miltaryBuilingsSection;
    }
    public Label getMiltaryBuildingsLabel() {
        return miltaryBuildingsLabel;
    }
    public HBox getMiltaryBuildings() {
        return miltaryBuildings;
    }
    public VBox getEconomicalBuilingsSection() {
        return economicalBuilingsSection;
    }
    public Label getEconomicalBuildingsLabel() {
        return economicalBuildingsLabel;
    }
    public HBox getEconomicalBuildings() {
        return economicalBuildings;
    }
    public Button getClose() {
        return close;
    }
    public VBox getMainLayout() {
        return mainLayout;
    }
    public Label getWarning(){
        return warning;
    }
    public HBox getMiltaryBuy() {
        return miltaryBuy;
    }
    public HBox getEconomicalBuy() {
        return economicalBuy;
    }
  

    public BuildMenu(Stage s) {
        super(s);
        title = new Label ("Builder");
        miltaryBuildingsLabel = new Label ("Miltary Builidngs");
        miltaryBuildings = new HBox();
        miltaryBuy = new HBox();
        miltaryBuilingsSection =  new VBox();
        miltaryBuilingsSection.getChildren().addAll(miltaryBuildingsLabel,miltaryBuildings,miltaryBuy);
 

        economicalBuildingsLabel = new Label ("economical Builidngs");
        economicalBuildings = new HBox();
        economicalBuy = new HBox();
        economicalBuilingsSection =  new VBox();
        economicalBuilingsSection.getChildren().addAll(economicalBuildingsLabel,economicalBuildings,economicalBuy);

        close = new Button("Close");
        close.setOnAction(e->{
            super.getParentStage().show();
            super.getStage().close();
            });
        warning = new Label();
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(title,miltaryBuilingsSection,economicalBuilingsSection,close);
        
        Scene sc = new Scene(mainLayout);
        super.getStage().setScene(sc);

        

     
    }
   
    
}
