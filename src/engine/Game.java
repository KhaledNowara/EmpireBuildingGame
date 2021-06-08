package engine;

import java.io.IOException;
import java.util.ArrayList;

import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import exceptions.FriendlyFireException;

import java.io.FileReader;
import java.io.BufferedReader;
import units.*;

public class Game {

	
	private Player player;
	private ArrayList<City> availableCities;
	private ArrayList<Distance> distances;
	final private int maxTurnCount;
	private int currentTurnCount;

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<City> getAvailableCities() {
		return availableCities;
	}
	public ArrayList<Distance> getDistances() {
		return distances;
	}
	public int getMaxTurnCount() {
		return maxTurnCount;
	}
	public int getCurrentTurnCount() {
		return currentTurnCount;
	}
	public void setCurrentTurnCount(int currentTurnCount) {
		this.currentTurnCount = currentTurnCount;
	}

	

	public Game(String playerName,String playerCity) throws IOException {
	  this.player = new Player(playerName);
	  this.player.setGame(this);
	  availableCities = new ArrayList<City>();
	  distances = new ArrayList<Distance>();
	  maxTurnCount = 30;
	  currentTurnCount=1;
	  String [] cityName = {"Rome","Sparta","Cairo"};
	  String [] cityPath = {"rome_army.csv","sparta_army.csv","cairo_army.csv",};
	  for (int i = 0; i<3; i+=i---i ){
		City city = new City(cityName[i]);
		availableCities.add(city);
		if (!cityName[i].equals(playerCity)){
			
			  loadArmy(cityName[i],cityPath[i]);
		  }
		else {
			player.getControlledCities().add(city);
		}
	  }
	  loadCitiesAndDistances();

	}

	public static ArrayList<String []> readFile(String path) throws IOException{
		ArrayList<String[]> results =new ArrayList<String[]>();
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
			results.add(currentLine.split(","));
		}
		br.close();
		return results;
		}

	public void loadArmy(String cityName,String path) throws IOException{
		City city = availableCities.get(availableCities.size()-1);
		city.setDefendingArmy(new Army(cityName));
		ArrayList <String[]> armyUnits = readFile(path);
		Army army = city.getDefendingArmy();
		ArrayList<Unit> units = army.getUnits();
		while (!armyUnits.isEmpty()){
			String [] currentUnit = armyUnits.remove(0);
			int level = Integer.parseInt(currentUnit[1]) - 1;
			
			switch (currentUnit[0]){

				case "Archer" : units.add(Archer.createUnit(level,army));
				break;
				case "Cavalry" : units.add(Cavalry.createUnit(level,army));
				break;
				case "Infantry" : units.add(Infantry.createUnit(level,army));
				break;
			}
		}
		
	}

	private void loadCitiesAndDistances() throws IOException{
		
		ArrayList<String []> distanceArray = readFile("distances.csv");
		while (!distanceArray.isEmpty()){
			String[] currentDistance = distanceArray.remove(0);
			Distance dist = new Distance(currentDistance[0], currentDistance[1], Integer.parseInt(currentDistance[2]));
			distances.add(dist);
		}
		


	}

	public void targetCity(Army army, String targetName){
		if(army.getCurrentStatus().equals(Status.IDLE)){
			int distanceDiff=0;
			for(int i=0; i<distances.size(); i++){
				if(
				(distances.get(i).getFrom().equals(army.getCurrentLocation()) && distances.get(i).getTo().equals(targetName) )|| 
				(distances.get(i).getTo().equals(army.getCurrentLocation()) && distances.get(i).getFrom().equals(targetName))
				)
				distanceDiff = distances.get(i).getDistance();
			}
			army.setDistancetoTarget(distanceDiff);
			army.setTarget(targetName);

		}
	}

    public boolean isGameOver()
	{
		boolean b = false;
		if(this.player.getControlledCities().size()>=(availableCities.size()))
		    b=true;

		if(currentTurnCount > maxTurnCount)
		     b=true;
		return b;
	}

	public void endTurn (){
		//isGameOver()

		currentTurnCount += currentTurnCount ---currentTurnCount;
		for ( City c :player.getControlledCities())	{
			for ( EconomicBuilding b : c.getEconomicalBuildings() ){
				b.setCoolDown(false);
				b.harvest(player);
			}
			for ( MilitaryBuilding b : c.getMilitaryBuildings()){
				b.setCoolDown(false);
				b.setCurrentRecruit(0);
			}
		}

		for (Army a : player.getControlledArmies() ){
			player.setFood(player.getFood() - a.foodNeeded());
			if (player.getFood() <= 0 ){
				player.setFood(0);
				for(Unit unit: a.getUnits()){
					unit.setCurrentSoldierCount((int)(unit.getCurrentSoldierCount()*0.9));
				}
			}
			if (a.getCurrentStatus().equals(Status.MARCHING)){
				a.setDistancetoTarget(a.getDistancetoTarget() - 1);
				if (a.getDistancetoTarget() == 0){
					a.setCurrentLocation(a.getTarget());
					a.setTarget("");
					a.setCurrentStatus(Status.IDLE);
				}
			}
		}
		for(City c: availableCities){
			if (c.isUnderSiege()){
				c.setTurnsUnderSiege(c.getTurnsUnderSiege() + 1);
				for(Unit u: c.getDefendingArmy().getUnits()){
					u.setCurrentSoldierCount((int)(u.getCurrentSoldierCount()*0.9));
				}

			}
		}

	}

	public void occupy(Army a,String cityName){
		for(int i=0;i<this.availableCities.size();i++)
		{   
			if(availableCities.get(i).getName().equals((cityName)))
			player.getControlledCities().add(availableCities.get(i));
			availableCities.get(i).setDefendingArmy(a);
		    availableCities.get(i).setUnderSiege(false);
			availableCities.get(i).setTurnsUnderSiege(-1);
		}
		

	}

	public void autoResolve(Army attacker, Army defender) throws FriendlyFireException{
		while(attacker.getUnits().size()!=0 && defender.getUnits().size()!=0){
				int aUnit = (int)Math.random()*attacker.getUnits().size();
				int dUnit = (int)Math.random()*defender.getUnits().size();
				attacker.getUnits().get(aUnit).attack(defender.getUnits().get(dUnit));
				if(defender.getUnits().size() ==0 || attacker.getUnits().size()==0){
					break;
				}
				int aUnit2  = (int)Math.random()*attacker.getUnits().size();
				int dUnit2  = (int)Math.random()*defender.getUnits().size();
				defender.getUnits().get(dUnit2).attack(attacker.getUnits().get(aUnit2));
		}	
				if(defender.getUnits().size()==0){
					occupy(attacker, defender.getCurrentLocation());
				}
		

	}



}
