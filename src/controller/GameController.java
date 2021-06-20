package controller;


import view.ChooseArmyScene;
import view.MainStage;


public class GameController {

	public MainStage gameStage;


	public GameController(MainStage g) {
		 gameStage = g;	
		 gameStage.getStartScene().getCityButton().setOnAction(e->chooseCityListner() );

		
	}

	public void chooseCityListner (){
		ChooseArmyScene cas = new ChooseArmyScene();
		cas.getCairo().setOnAction(e -> cityListner("Cairo"));;
		cas.getRome().setOnAction(e -> cityListner("Rome"));
		cas.getSparta().setOnAction(e -> cityListner("Sparta"));
		gameStage.getScene().setRoot(cas.getMainLayOut());
	}

	public void cityListner(String cityName){
		
		gameStage.getStartScene().getChosenCity().setText("You chose " + cityName);
		gameStage.getScene().setRoot(gameStage.getStartScene().getMainLayout());
	
	}


	public static void main (String []args){
		MainStage.main(args);
	}


	

}
