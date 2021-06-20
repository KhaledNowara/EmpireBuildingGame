package view;
import java.util.ArrayList;

import javafx.application.*;
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

        
        vb.getChildren().addAll(awlany,b,city);
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
   

        b.setOnAction(e -> {
            switchViews(scene1, hb2);
            // test.add(new Label(textField.getText()));
            // for (Label l : test){
            //     if (!vb.getChildren().contains(l))
            //     vb.getChildren().add(l);
            // }
            // scene1.setRoot(vb);
            // //stage.setScene(scene1);
            // for (Label l : test){
            //     System.out.println(l.getText());            }
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
