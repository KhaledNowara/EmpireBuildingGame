package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ChooseArmyScene {

  private Button Cairo;
  private Button Sparta;
  private Button Rome;
  private HBox mainLayout;


  	public Button getCairo() {
	return Cairo;
}

public Button getSparta() {
	return Sparta;
}


public Button getRome() {
	return Rome;
}

public HBox getMainLayOut() {
	return mainLayout;
}




	public ChooseArmyScene() {

		Cairo = new Button("Cairo");
		Cairo.setFocusTraversable(false);

		Sparta = new Button("Sparta");
		Sparta.setFocusTraversable(false);

		Rome = new Button("Rome");
		Rome.setFocusTraversable(false);

		mainLayout = new HBox();
		mainLayout.getChildren().addAll(Cairo,Sparta,Rome);
		mainLayout.setAlignment(Pos.CENTER);
		mainLayout.setSpacing(20);
	}

}
