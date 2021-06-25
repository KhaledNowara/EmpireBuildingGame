package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ChooseArmyScene {

  private ImageView Cairo;
  private ImageView Sparta;
  private ImageView Rome;
  private HBox mainLayout;


  	public ImageView getCairo() {
	return Cairo;
}

public ImageView getSparta() {
	return Sparta;
}


public ImageView getRome() {
	return Rome;
}

public HBox getMainLayOut() {
	return mainLayout;
}




	public ChooseArmyScene() {

		Cairo = new ImageView(images.cairoSelectImage);
		Cairo.setFocusTraversable(false);
		Cairo.setOnMousePressed(e -> Cairo.setImage(images.cairoSelectedImage));
		Cairo.setOnMouseReleased(e -> Cairo.setImage(images.cairoSelectImage));

		Sparta = new ImageView(images.spartaSelectImage);
		Sparta.setFocusTraversable(false);
		Sparta.setOnMousePressed(e -> Sparta.setImage(images.spartaSelectedImage));
		Sparta.setOnMouseReleased(e -> Sparta.setImage(images.spartaSelectImage));

		Rome = new ImageView(images.romeSelectImage);
		Rome.setFocusTraversable(false);
		Rome.setOnMousePressed(e -> Rome.setImage(images.romeSelectedImage) );
		Rome.setOnMouseReleased(e -> Rome.setImage(images.romeSelectImage) );

		mainLayout = new HBox();
		mainLayout.getChildren().addAll(Cairo,Rome,Sparta);
		mainLayout.setAlignment(Pos.CENTER);
		mainLayout.setSpacing(0);
	}

}
