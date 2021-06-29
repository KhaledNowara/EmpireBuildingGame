package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class maxSeigeBox extends MessageBox {
    
    private Label message;
    private Button close;
    private VBox mainLayout;
    
    public maxSeigeBox(Stage s, String m) {
        super(s);
        message = new Label(m);
        close = new Button("close");
        close.setOnAction(e -> {
            super.getParentStage().show();
            super.getStage().close();

        });
        mainLayout = new VBox();
        mainLayout.getChildren().addAll(message,close);
        mainLayout.setSpacing(30);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getStylesheets().add("/resources/styleSheets/MenuStyle.css");
        mainLayout.setPadding(new Insets(10));
        Scene sc = new Scene(mainLayout);
        sc.setFill(Color.TRANSPARENT);
        super.getStage().setScene(sc);
        super.getStage().showAndWait();
        
        
        
    }

    
    
    
}
