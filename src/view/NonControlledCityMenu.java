package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NonControlledCityMenu extends MessageBox{
        BorderPane mainLayout;
        Label name;
        HBox Buttons;
        Button close;
        Button laySeige;
        Button autoResolve;
        Label turnsUnderSeige;
        Button Attack;
    
        public BorderPane getMainLayout() {
            return mainLayout;
        }

        public void setMainLayout(BorderPane mainLayout) {
            this.mainLayout = mainLayout;
        }

        public Label getName() {
            return name;
        }

        public void setName(Label name) {
            this.name = name;
        }

        public HBox getButtons() {
            return Buttons;
        }

        public void setButtons(HBox buttons) {
            Buttons = buttons;
        }

        public Button getClose() {
            return close;
        }

        public void setClose(Button close) {
            this.close = close;
        }

        public Button getLaySeige() {
            return laySeige;
        }

        public void setLaySeige(Button laySeige) {
            this.laySeige = laySeige;
        }

        public Label getTurnsUnderSeige() {
            return turnsUnderSeige;
        }

        public void setTurnsUnderSeige(Label turnsUnderSeige) {
            this.turnsUnderSeige = turnsUnderSeige;
        }

        public Button getAttack() {
            return Attack;
        }

        public void setAttack(Button attack) {
            Attack = attack;
        }
        public Button getAutoResolve(){
            return autoResolve;
        }

        public NonControlledCityMenu (Stage s,String nm){
            super(s);
            mainLayout = new BorderPane();
            name = new Label(nm);
            Buttons = new HBox();
            Attack= new Button("Attack");
            autoResolve = new Button("Auto Resolve Battle");
            turnsUnderSeige= new Label("Turns Under Seige");
            laySeige = new Button("Send Army");

            close = new Button("Close");
            close.setOnAction(e -> {
                super.getParentStage().show();
                super.getStage().close();
            });
            Buttons.getChildren().addAll(Attack,autoResolve,laySeige,close) ;
            Buttons.setSpacing(30);
            mainLayout.setTop(name);
            mainLayout.setLeft(turnsUnderSeige);
            mainLayout.setBottom(Buttons);
            mainLayout.getStylesheets().add("/resources/styleSheets/MenuStyle.css");
            mainLayout.setPadding(new Insets(30));
            Scene sm = new Scene(mainLayout);
            sm.setFill(Color.TRANSPARENT);
            super.getStage().setScene(sm);
            //super.getStage().showAndWait();
        }
    
    
}
