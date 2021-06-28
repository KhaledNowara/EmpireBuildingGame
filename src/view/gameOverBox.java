package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gameOverBox extends MessageBox {
    Label message ;
    Button close;
    public gameOverBox(Stage s,String Message) {
        super(s);
        message = new Label (Message);
        close = new Button("Close");
        close.setOnAction(e->{
            super.getStage().close();
            super.getParentStage().close(); 
        });
        VBox mainLayout = new VBox(message,close);
        Scene sc = new Scene(mainLayout);
        super.getStage().setScene(sc);
        super.getStage().showAndWait();    }
    
}
