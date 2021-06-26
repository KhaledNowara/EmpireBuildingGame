package controller;


import java.io.IOException;
import java.util.ArrayList;

import buildings.Building;
import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import engine.City;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import units.Army;
import units.Unit;
import view.BuildMenu;
import view.ChooseArmyAttackMenu;
import view.ChooseArmyScene;
import view.CityHallMenu;
import view.CityView;
import view.ControlledCityMenu;
import view.EconomicalBuildingInfoMenu;
import view.MainStage;
import view.MessageBox;
import view.MilitaryBuildingInfoMenu;
import view.NonControlledCityMenu;
import view.SceneSuper;
import view.StartScene;
import view.WorldMapScene;
import view.createArmyMenu;
import view.images;


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
			wmScene.getEndTurn().setOnAction(e -> endTurn(wmScene));
			for(City c: game.getAvailableCities()){
				if (c.getName().equals("Rome")){
					RomeView = generateCityView(c);
					wmScene.getRome().setOnMouseClicked(( e -> viewCityListner("Rome",RomeView)));
				}
				if (c.getName().equals("Sparta")){
					SpartaView = generateCityView(c);
					wmScene.getSparta().setOnMouseClicked((e -> viewCityListner("Sparta",SpartaView)));
				
				}
				if (c.getName().equals("Cairo")){
					CairoView = generateCityView(c);
					wmScene.getCairo().setOnMouseClicked((e -> viewCityListner("Cairo",CairoView)));
				}
				updateInfo(wmScene);
				
				
				switch (startScene.getCityName()){
					case "Rome" : gameStage.changeViews(RomeView.getMainLayout());break;
					case "Cairo" : gameStage.changeViews(CairoView.getMainLayout());break;
					case "Sparta" : gameStage.changeViews(SpartaView.getMainLayout());break;
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
		mmm.getLaySeige().setOnAction(e -> sendArmyListener(mmm.getStage(), cityView));
		for(City city2: game.getAvailableCities()){;
			System.out.println("non controlled city besieging code" + city2.getName() + c);
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

	public void sendArmyListener (Stage s, CityView city){
		ChooseArmyAttackMenu m = new ChooseArmyAttackMenu(s, city.getCity().getName());
		boolean flag = true;
		for(Army a: game.getPlayer().getControlledArmies()){
			flag = false;
			HBox h = new HBox();
			Button b = new Button (a.getName());
			b.setOnAction(e -> sendArmy(a, city, m));
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
	public void sendArmy (Army a, CityView c,ChooseArmyAttackMenu m){
		if (!c.getCity().isUnderThreat()){
				game.targetCity(a,c.getCity());
				m.getStage().close();
		}
		else {
			m.getWarning().setText("An army is on on it' way");
			m.getElements().getChildren().add(m.getWarning());
	}

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
		current.getEndTurn().setOnAction(e -> endTurn(current));
		current.getCityHall().setOnMouseClicked(e -> cityHallListener(c));
		upadateCityView(current, c);
		gameStage.changeViews(current.getMainLayout());
		return current;
	}

	public void cityHallListener(City c){
		int food = 0;
		int gold = 0;
		CityHallMenu m = new CityHallMenu(stage,food,gold,c.getName());
		ComboBox<Unit> box = new ComboBox<Unit>();
		for(Unit u: c.getDefendingArmy().getUnits()){
			box.getItems().add(u);
		}
		m.getDefendingArmy().getChildren().add(box);
		m.getBuild().setOnAction(e-> buildListener(c));
		m.getCreateArmy().setOnAction(e -> createArmyMenuListener(c));
		m.getStage().showAndWait();
	}

	public void buildListener(City c){
		BuildMenu bm= new BuildMenu(stage);
		boolean mFlag = true;
		boolean eFlag = true;
		
		ArrayList<String> ecoTypes = new ArrayList<String>();
		ecoTypes.add("Farm");
		ecoTypes.add("Market");
		for(EconomicBuilding b:c.getEconomicalBuildings()){
			String comp = b.getClass().getSimpleName();
			if(ecoTypes.contains(comp))
				ecoTypes.remove(comp);
		}
		for(String r: ecoTypes){
			eFlag = false;
			ImageView building = null;
			
			switch (r){
				
				case "Farm" : building = new ImageView(images.farmImageS);
				building.setOnMouseClicked(e -> BuildOption(bm,"Farm",c.getName()));
				break;
				case "Market" : building = new ImageView(images.marketImageS);
				building.setOnMouseClicked(e -> BuildOption(bm,"Market",c.getName()));
				break;
			}
			bm.getEconomicalBuildings().getChildren().add(building);
		}
		if (eFlag) bm.getEconomicalBuildings().getChildren().add(new Label("You built all economical buildings "));

		ArrayList<String> milTypes = new ArrayList<String>();
		milTypes.add("ArcheryRange");
		milTypes.add("Barracks");
		milTypes.add("Stable");
		for (MilitaryBuilding m: c.getMilitaryBuildings()){
			
			String comp = m.getClass().getSimpleName();
			if (milTypes.contains(comp))
			milTypes.remove(comp);
		}
		for (String r: milTypes){
			mFlag = false;
			ImageView building = null;
			switch (r){
				case "ArcheryRange": building = new ImageView(images.archeryRangeImageS);
				building.setOnMouseClicked(e -> BuildOption(bm,"ArcheryRange",c.getName()));
				break;
				case "Barracks": building = new ImageView(images.barracksImageS);
				building.setOnMouseClicked(e -> BuildOption(bm,"Barracks",c.getName()));
				break;
				case "Stable" : building = new ImageView(images.stableImageS);
				building.setOnMouseClicked(e -> BuildOption(bm,"Stable", c.getName()));
				break;
			}
			bm.getMiltaryBuildings().getChildren().add(building);

		}
		if (mFlag) bm.getMiltaryBuildings().getChildren().add(new Label("You Built all miltary Buildings"));
		bm.getStage().showAndWait();

	}

	public void BuildOption (BuildMenu m,String type,String location){
		HBox box = new HBox();
		Label l = new Label();
		boolean eco = false;
		ImageView building = null;
		switch (type){
			case "Farm" : l.setText("Cost: 1000 Gold"); 
			eco = true;
			building = new ImageView(images.farmImage);
			break;
			case "Market" : l.setText("Cost: 1500 Gold"); 
			eco = true;
			building = new ImageView(images.marketImage);
			break;
			case "ArcheryRange" :
			l.setText("Cost: 1500 Gold");
			building = new ImageView(images.archeryRangeImage);
			break;
			case "Barracks" : l.setText("Cost: 2000 Gold");
			building = new ImageView(images.barracksImage);
			break;
			case "Stable" : l.setText("Cost: 2500 Gold");
			building = new ImageView(images.stableImage);
			break;
		}
		Button b = new Button("Build");
		final boolean ecoCopy = eco;
		final ImageView bCopy = building;
		b.setOnAction(e -> build(type,location,m,ecoCopy,bCopy));
		box.getChildren().addAll(l,b);
		if(eco) {
			m.getEconomicalBuy().getChildren().clear();
			m.getEconomicalBuy().getChildren().add(box);
		}
		else {
			m.getMiltaryBuy().getChildren().clear();
			m.getMiltaryBuy().getChildren().add(box);
			
		}
	}
	
	public void build(String type,String location,BuildMenu b,Boolean eco,ImageView img){
		try{
			Building building = game.getPlayer().build(type, location);
			switch(location){
				case "Rome" : updateInfo(RomeView);
					if (eco){
						 RomeView.getEconomicalBuildingsLayout().getChildren().add(img);
						 img.setOnMouseClicked(e -> EconomicBuildingInfoListner((EconomicBuilding)building, RomeView));
					}
					else {RomeView.getMiltaryBuildingsLayout().getChildren().add(img);
						img.setOnMouseClicked(e -> MiltaryBuildingInfoListner((MilitaryBuilding)building, RomeView));
					}
				break;
				case "Sparta": updateInfo(SpartaView);
					if (eco){ 
						SpartaView.getEconomicalBuildingsLayout().getChildren().add(img);
						img.setOnMouseClicked(e -> EconomicBuildingInfoListner((EconomicBuilding)building, SpartaView));
					}
					else {
						SpartaView.getMiltaryBuildingsLayout().getChildren().add(img);
						img.setOnMouseClicked(e -> MiltaryBuildingInfoListner((MilitaryBuilding)building, SpartaView));
					}
					
				break;
				case "Cairo": updateInfo(CairoView);
					if (eco){ 
						CairoView.getEconomicalBuildingsLayout().getChildren().add(img);
						img.setOnMouseClicked(e -> EconomicBuildingInfoListner((EconomicBuilding)building, CairoView));
					}
					else {
						CairoView.getMiltaryBuildingsLayout().getChildren().add(img);
						img.setOnMouseClicked(e -> MiltaryBuildingInfoListner((MilitaryBuilding)building, CairoView));

					}
				break;
			}
			b.getStage().close();
		}catch(NotEnoughGoldException e){
			b.getWarning().setText("You dont have enough gold");
		}

	}
	public void EconomicBuildingInfoListner (EconomicBuilding b,SceneSuper s){
		
		EconomicalBuildingInfoMenu m = new EconomicalBuildingInfoMenu(stage, b);
		m.getUpgrade().setOnAction(e -> upgradeBuilding(b,m.getWarning(), s, m));
		m.getStage().showAndWait();
		
	}	
	public void MiltaryBuildingInfoListner (MilitaryBuilding b,CityView s){
		
		MilitaryBuildingInfoMenu m = new MilitaryBuildingInfoMenu(stage,b);
		m.getUpgrade().setOnAction(e -> upgradeBuilding(b,m.getWarning(), s, m));
		m.getRecruit().setOnAction(e-> recruit(b, s, m, m.getWarning()));
		m.getStage().showAndWait();
		

	}	

	public void upgradeBuilding (Building b,Label warning,SceneSuper s,MessageBox m ) {
		try{
			game.getPlayer().upgradeBuilding(b);
			updateInfo(s);
			m.getStage().close();
		}catch(MaxLevelException e){
			warning.setText(warning.getText() +"The building is at max level \n");
		}catch(NotEnoughGoldException e){
			warning.setText(warning.getText() + "You dont have enough gold \n");
		}catch(BuildingInCoolDownException e){
			warning.setText(warning.getText() + "Building is in cool down \n");
		}
	}

	public void recruit (MilitaryBuilding b,CityView s,MessageBox m ,Label warning){
		try {
			game.getPlayer().recruitUnit(b,s.getCity());
			updateInfo(s);
			m.getStage().close();
		} 
		catch(BuildingInCoolDownException e){
			warning.setText(warning.getText() + " Building is in cooldown \n");
		}
		catch(MaxRecruitedException e){
			warning.setText(warning.getText() + " Max recruitment reached \n ") ;
		}
		catch(NotEnoughGoldException e){
			warning.setText(warning.getText() + "You don't have enough gold \n");
		}



	}
	public void createArmyMenuListener (City c ){
		createArmyMenu Am = new createArmyMenu(stage);
		for(Unit u: c.getDefendingArmy().getUnits()){
			Am.getList().getItems().add(u);	
		}
	
		Am.getCreateArmy().setOnAction(e -> createArmyListener(c,Am.getList(),Am.getArmyName().getText(), Am) );
		Am.getStage().showAndWait();

	}
	public void createArmyListener(City c, ListView<Unit> unitList,String Name,createArmyMenu m){
		ArrayList<Unit> units = new ArrayList<Unit>();
		for (Unit u : unitList.getSelectionModel().getSelectedItems()){
			System.out.println(u);
			units.add(u);
		}
		game.getPlayer().initiateArmy(c, units, Name);
		m.getStage().close();
	}

	public void upadateCityView(CityView current, City c){
		updateInfo(current);
		// for (MilitaryBuilding b : c.getMilitaryBuildings() ){
		// 	current.getMiltaryBuildingsLayout().getChildren().add(new Label(b.getClass().toString()));
		// 	}
	
		// for (EconomicBuilding b : c.getEconomicalBuildings()){
		// current.getEconomicalBuildingsLayout().getChildren().add(new Label(b.getClass().toString()));
		// }
		//for(Army a : game.getPlayer().getControlledArmies()){
		//if(a.getCurrentLocation().equals(c.getName()))
		//current.getArmiesLayout().getChildren().add(new Label("Armyy"));

		//}
	}
	private void backToWorldMap() {
	  updateInfo(wmScene); 
	  gameStage.changeViews(wmScene.getMainLayout());
    }

	private void endTurn (SceneSuper s){
		game.endTurn();
		updateInfo(s);
	}

	public void shutUpWarning (){}



	public static void main (String []args){
		MainStage.main(args);
	}


	

}
