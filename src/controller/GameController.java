package controller;


import java.io.IOException;

import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import engine.City;
import engine.Game;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import units.Army;
import units.Unit;
import view.ChooseArmyAttackMenu;
import view.ChooseArmyScene;
import view.CityView;
import view.ControlledCityMenu;
import view.MainStage;
import view.NonControlledCityMenu;
import view.SceneSuper;
import view.StartScene;
import view.WorldMapScene;


public class GameController {

	public MainStage gameStage;
	private Stage stage; 
	private StartScene startScene;
	private WorldMapScene wmScene;
	private Game game;
	private CityView RomeView = null;
	private CityView SpartaView = null;
	private CityView CairoView = null;
	


	public GameController(MainStage g,Stage s) {
		 gameStage = g;	
		 stage = s;
		 startScene = gameStage.getStartScene();
		 startScene.getCityButton().setOnAction(e->chooseCityListner() );
		 startScene.getStartGame().setOnAction(e->startGameListner() );
		

		
	}

	public void chooseCityListner (){
		ChooseArmyScene cas = new ChooseArmyScene();
		cas.getCairo().setOnMouseClicked(e -> selectCityListner("Cairo"));;
		cas.getRome().setOnMouseClicked(e -> selectCityListner("Rome"));
		cas.getSparta().setOnMouseClicked(e -> selectCityListner("Sparta"));
		gameStage.getScene().setRoot(cas.getMainLayOut());
	}

	public void selectCityListner(String cityName){
		
		startScene.getChosenCity().setText("You chose " + cityName);
		startScene.setCityName(cityName);
		gameStage.changeViews(startScene.getMainLayout());
		
	
	}

	public void startGameListner(){
		
		if (startScene.getNameText().getText().equals("")||startScene.getChosenCity().getText().equals("")){
			startScene.getChosenCity().setText("Choose name and city batal le3b");
		}
		else{
			try {
			game = new Game(startScene.getNameText().getText(),startScene.getCityName());
			wmScene = new WorldMapScene();
			for(City c: game.getAvailableCities()){
				if (c.getName().equals("Rome"))
				wmScene.getRome().setOnMouseClicked(( e -> viewCityListner("Rome",RomeView)));
				if (c.getName().equals("Sparta"))
				wmScene.getSparta().setOnMouseClicked((e -> viewCityListner("Sparta",SpartaView)));
				if (c.getName().equals("Cairo"))
				wmScene.getCairo().setOnMouseClicked((e -> viewCityListner("Cairo",CairoView)));
			}
			updateInfo(wmScene);
			
			for (City c : game.getPlayer().getControlledCities()){
				if ( c.getName().equals(startScene.getCityName())){ 
					if(c.getName().equals("Rome")){
						RomeView = generateCityView(c);
						gameStage.changeViews(RomeView.getMainLayout());}
					else
						if(c.getName().equals("Cairo")){
							CairoView = generateCityView(c);
							gameStage.changeViews(CairoView.getMainLayout());}
						else{
							SpartaView = generateCityView(c);
							gameStage.changeViews(SpartaView.getMainLayout());
						}	
			}
		}
			
			
			
			

			}catch (IOException e){
				startScene.getChosenCity().setText("You cracked this game and in return we will hack your computer");
			}
		}

	}

	public void viewCityListner(String c, CityView cityView){

		
		for(int i=0; i<game.getPlayer().getControlledCities().size();i++){    
        
			if(c.equals(game.getPlayer().getControlledCities().get(i).getName())){
	
				ControlledCityMenu menu = new  ControlledCityMenu(stage, "ahdjfasfdsankdafshaskdfhdas",cityView);
				menu.getEnter().setOnAction(e -> enterCityListner(menu));
				boolean x = true;
			
				for(Army a : game.getPlayer().getControlledArmies()){
					if (a.getCurrentLocation().equals(c)){
						x = false;
						HBox b = new HBox();
						Label l = new Label(a.getName());

						ComboBox<Unit> box = new ComboBox<Unit>();
						for(Unit u: a.getUnits()){
							box.getItems().add(u);
						}
						b.getChildren().addAll(l,box);
						menu.getArmiesInfo().getChildren().add(b);
					}

				}
				if (x) menu.getArmiesInfo().getChildren().add(new Label("You have no armies"));
				menu.getStage().showAndWait();
				return;
			}
		}
		NonControlledCityMenu mmm = new  NonControlledCityMenu(stage, "ahdjfasfdsankdafshaskdfhdas");
		mmm.getLaySeige().setOnAction(e -> sendArmyListener(mmm.getStage(), c));
		for(City city2: game.getAvailableCities()){;
			if (city2.getName().equals(c)){
				if (city2.isUnderSiege()){
					if (city2.getTurnsUnderSiege() == 3){
						mmm.getTurnsUnderSeige().setText("You must attck the city this turn ");

					}
					else{
					mmm.getTurnsUnderSeige().setText("The City has been UnderSiege for " + city2.getTurnsUnderSiege() + " Turns");
					}
				}
				else mmm.getTurnsUnderSeige().setText("City is not under siege");
  
			}
			
		}
		mmm.getStage().showAndWait();
		

        
	}

	public void sendArmyListener (Stage s, String cityName){
		ChooseArmyAttackMenu m = new ChooseArmyAttackMenu(s, cityName);
		boolean flag = true;
		for(Army a: game.getPlayer().getControlledArmies()){
			flag = false;
			HBox h = new HBox();
			Button b = new Button (a.getName());
			m.getArmies().put(b,a);
			ComboBox<Unit> box = new ComboBox<Unit>();
			for(Unit u: a.getUnits()){
				box.getItems().add(u);
			}
			h.getChildren().addAll(b,box);
			m.getElements().getChildren().add(h);
		}
		if (flag) m.getElements().getChildren().add(new Label("You have no Attacking armies \nGo to your cities and create armies to attck with"));
		m.getStage().showAndWait();

	}

	public void enterCityListner(ControlledCityMenu cm){
		cm.getStage().close();
		upadateCityView(cm.getCityView(),cm.getCityView().getCity());
		gameStage.changeViews(cm.getCityView().getMainLayout());
	}

	public void updateInfo(SceneSuper s) {
        s.getPlayer().setText( game.getPlayer().getName());
        s.getTurn().setText("Turns : " + game.getCurrentTurnCount());
        s.getGold().setText("Gold  : " + (int) game.getPlayer().getTreasury());
        s.getFood().setText("Food :  " + (int) game.getPlayer().getFood());
    }
	public CityView generateCityView(City c ){
		CityView current = new CityView(c);
		current.getWorldMap().setOnAction(e -> backToWorldMap());
		upadateCityView(current, c);
		gameStage.changeViews(current.getMainLayout());
		return current;
	}

	
	public void upadateCityView(CityView current, City c){
		updateInfo(current);
		for (MilitaryBuilding b : c.getMilitaryBuildings() ){
			current.getMiltaryBuildingsLayout().getChildren().add(new Label(b.getClass().toString()));
			}
	
		for (EconomicBuilding b : c.getEconomicalBuildings()){
		current.getEconomicalBuildingsLayout().getChildren().add(new Label(b.getClass().toString()));
		}
		for(Army a : game.getPlayer().getControlledArmies()){
		if(a.getCurrentLocation().equals(c.getName()))
		current.getArmiesLayout().getChildren().add(new Label("Armyy"));

		}
	}
	private void backToWorldMap() {
	  updateInfo(wmScene);
	  gameStage.changeViews(wmScene.getMainLayout());
    }



	public static void main (String []args){
		MainStage.main(args);
	}


	

}
