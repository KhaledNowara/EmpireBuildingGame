package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControlledCityMenu extends MessageBox {
    BorderPane mainLayout;
    Label name;
    VBox armiesInfo;
    HBox Buttons;
    Button enter;
    Button close;
   

    public ControlledCityMenu (Stage s,String nm){
        super(s);
        mainLayout = new BorderPane();
        name = new Label(nm);
        armiesInfo = new VBox();
        Buttons = new HBox();
        enter = new Button("Enter City");
        close = new Button("Close");
        close.setOnAction(e -> {
            super.getParentStage().show();
            super.getStage().close();
        });
        Buttons.getChildren().addAll(enter,close) ;
        mainLayout.setTop(name);
        mainLayout.setLeft(armiesInfo);
        mainLayout.setBottom(Buttons);
        Scene sm = new Scene(mainLayout);
        super.getStage().setScene(sm);
        //super.getStage().showAndWait();
    }


    public BorderPane getMainLayout() {
        return mainLayout;
    }


   

    public Label getName() {
        return name;
    }


  


    public VBox getArmiesInfo() {
        return armiesInfo;
    }


   


    public HBox getButtons() {
        return Buttons;
    }


    

    public Button getEnter() {
        return enter;
    }


    

    public Button getClose() {
        return close;
    }




    

    
    
    
}
