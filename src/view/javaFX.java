package view;
import java.util.ArrayList;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;

public class javaFX extends Application {
     public static  Scene scene1;
    Scene scene2;
    ArrayList <Label> test ;

    public void start(Stage stage) throws Exception{
        test  = new ArrayList<Label>();
        // Image icon = new Image("/assets/worldC.png");
        // ImageView v = new ImageView(icon);
        HBox awlany = new HBox ();
        awlany.setSpacing(50);
        awlany.setAlignment(Pos.CENTER);
        Label label1 = new Label("Name:");
        String [] a = {"wala wa7ed", "wala meya","wla alf we toltomya"};
        ComboBox batee5 = new ComboBox<String>();
        for(String batoot: a){
            batee5.getItems().add(batoot);
        }
        test.add(label1);
        
        label1.setFont(new Font("Arial", 30));
        TextField textField = new TextField ();
        textField.setPromptText("Enter Player Name");
        
        textField.setFont(new Font("Arial", 30));
        textField.setPrefSize(500,50); 
        textField.autosize();
       // textField.setFocusTraversable(false);
        awlany.getChildren().addAll(label1,textField);
        Label city =  new Label("");
        city.setFont(new Font("Arial", 30));
        Button b =new Button("Save Name");
        VBox vb = new VBox();
       
        b.setPrefSize(500,40);
        b.setFont(new Font("Arial", 30));

        
        vb.getChildren().addAll(awlany,b,batee5,city);
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);
        scene1 = new Scene(vb,1920,1080,Color.DARKBLUE);


        Button cairo = new Button("Cairo");
        cairo.setFont(new Font ("Arial", 70));
        cairo.setOnAction(e ->{
            city.setText("Cairo");
            switchViews(scene1,vb);
        });
        Button rome = new Button ("Rome");
        rome.setFont(new Font ("Arial", 70));
        rome.setOnAction(e ->{
            city.setText("Rome");
            switchViews(scene1,vb);
        });
        Button sparta = new Button("Sparta");
        sparta.setFont(new Font ("Arial", 70));
        sparta.setOnAction(e ->{
            city.setText("Sparta");
            switchViews(scene1,vb);
        });

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(cairo,rome,sparta);
        hb2.setSpacing(10);
        hb2.setAlignment(Pos.CENTER);
       
        VBox pauseRoot = new VBox(5);
        pauseRoot.getChildren().add(new Label("Paused"));
        pauseRoot.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8);");
        pauseRoot.setAlignment(Pos.CENTER);
        pauseRoot.setPadding(new Insets(20));

        b.setOnAction(e -> {
            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner(stage);
            popupStage.initModality(Modality.APPLICATION_MODAL);
            Scene s = new Scene(pauseRoot, Color.TRANSPARENT);
            popupStage.setScene(s);
            popupStage.showAndWait();
         
        });
        // vb.setId("pane");
        // hb2.setId("pane");
        // scene1.getStylesheets().add("/assets/test.css");
        // scene2.getStylesheets().add("/assets/test.css");

        stage.setScene(scene1);
        stage.setFullScreen(true);
        stage.show();
        
    }

    
    public void switchViews (Scene s, Parent st){
        s.setRoot(st);
    }

    public static void main(String[] args){
        launch(args); 
    }
}
