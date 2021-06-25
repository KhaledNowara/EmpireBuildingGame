package view;

import engine.Game;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class SceneSuper {
    private Label player;
    private Label turn;
    private Label gold;
    private Label food;
    private HBox infoPane;

    public Label getPlayer() {
        return player;
    }

    public Label getTurn() {
        return turn;
    }

    public Label getGold() {
        return gold;
    }

    public Label getFood() {
        return food;
    }

    public HBox getInfoPane() {
        return infoPane;
    }

    public SceneSuper() {
        player = new Label("Player name");
        gold = new Label("Gold");
        food = new Label("Food");
        turn = new Label("Turn");
        player.setMaxWidth(1500);
        infoPane = new HBox();
        infoPane.setSpacing(100);
        infoPane.getChildren().addAll(player, gold, food, turn);
        infoPane.setBackground(new Background(new BackgroundFill( Color.rgb(224, 181, 63,0.3),null,null)));
    }

    

}
