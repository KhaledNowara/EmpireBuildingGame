package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NonControlledCityMenu extends MessageBox{
        BorderPane mainLayout;
        Label name;
        HBox Buttons;
        Button close;
        Button laySeige;
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

        public NonControlledCityMenu (Stage s,String nm){
            super(s);
            mainLayout = new BorderPane();
            name = new Label(nm);
            Buttons = new HBox();
            Attack= new Button("Attack");
            turnsUnderSeige= new Label("Turns Under Seige");
            laySeige = new Button("Lay Seige");

            close = new Button("Close");
            close.setOnAction(e -> {
                super.getParentStage().show();
                super.getStage().close();
            });
            Buttons.getChildren().addAll(Attack,laySeige,close) ;
            mainLayout.setTop(name);
            mainLayout.setLeft(turnsUnderSeige);
            mainLayout.setBottom(Buttons);
            Scene sm = new Scene(mainLayout);
            super.getStage().setScene(sm);
            //super.getStage().showAndWait();
        }
    
    
}
