package view;


import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class MessageBox{
   private Stage parentStage;
   private Stage stage;


public Stage getParentStage() {
    return parentStage;
}

public Stage getStage() {
    return stage;
}


public MessageBox (Stage s)
{
    parentStage= s;
    stage =  new Stage(StageStyle.TRANSPARENT);
    stage.initOwner(s);
    stage.initModality(Modality.APPLICATION_MODAL);
   // stage.setTitle(title);
    stage.setMinWidth(1000);
    stage.setMinHeight(1000);
    stage.setX(1050);
    stage.setY(350);




}
}