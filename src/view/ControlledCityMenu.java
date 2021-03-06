package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControlledCityMenu extends MessageBox {
    BorderPane mainLayout;
    Label name;
    VBox armiesInfo;
    HBox Buttons;
    Button enter;
    Button close;
    CityView cityView;
   

    public ControlledCityMenu (Stage s,String nm, CityView c ){
        super(s);
        cityView = c;
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

        Buttons.setSpacing(20);
        Buttons.setPadding(new Insets(20) );
        mainLayout.setTop(name);
        mainLayout.setLeft(armiesInfo);
        mainLayout.setBottom(Buttons);
        mainLayout.getStylesheets().add("/resources/styleSheets/MenuStyle.css");
        mainLayout.setPadding(new Insets(10));
        Scene sm = new Scene(mainLayout);
        sm.setFill(Color.TRANSPARENT);
        super.getStage().setScene(sm);
        //super.getStage().showAndWait();
    }


    public CityView getCityView() {
        return cityView;
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
