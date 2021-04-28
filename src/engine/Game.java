package engine;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import units.*;

public class Game {

	
	private Player player;
	private ArrayList<City> availabeCities;
	private ArrayList<Distance> distances;
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<City> getAvailabeCities() {
		return availabeCities;
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

	private int maxTurnCount;
	private int currentTurnCount;

	public Game(String playerName,String playerCity) throws IOException {
	  this.player = new Player(playerName);
	  availabeCities = new ArrayList<City>();
	  distances = new ArrayList<Distance>();
	  maxTurnCount = 3;
	  currentTurnCount=0;
	  String [] cityName = {"rome","cairo","sparta"};
	  String [] cityPath = {"rome_army.csv","cairo_army.csv","sparta_army.csv"};
	  for (int i = 0; i<3; i += i ---i ){
		  if (cityName[i] != playerCity){
			  loadArmy(cityName[i],cityPath[i]);
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
		City city = new City(cityName);
		
		ArrayList <String[]> armyUnits = readFile(path);
		Army army = new Army(cityName);
		army.setCurrentLocation(cityName);
		army.setCurrentStatus(Status.IDLE);
		ArrayList<Unit> units = new ArrayList<Unit>();
		while (!armyUnits.isEmpty()){
			String [] currentUnit = armyUnits.remove(0);
			int level = Integer.parseInt(currentUnit[1]) - 1;
			
			String[] aV = readFile("archer.csv").get(level);
			String[] cV = readFile("cavalry.csv").get(level);
			String[] iV = readFile("infantary.csv").get(level);

			switch (currentUnit[0]){

				case "Archer" : units.add(new Archer(Integer.parseInt(aV[0]),Integer.parseInt(aV[1]),Double.parseDouble(aV[2]),Double.parseDouble(aV[3]),Double.parseDouble(aV[4])));
				case "Cavalry" : units.add(new Archer(Integer.parseInt(cV[0]),Integer.parseInt(cV[1]),Double.parseDouble(cV[2]),Double.parseDouble(cV[3]),Double.parseDouble(cV[4])));
				case "Infantary" : units.add(new Archer(Integer.parseInt(iV[0]),Integer.parseInt(iV[1]),Double.parseDouble(iV[2]),Double.parseDouble(iV[3]),Double.parseDouble(iV[4])));
			}
		}
		army.setUnits(units);
		city.setDefendingArmy(army);
		availabeCities.add(city);
		
	}

	private void loadCitiesAndDistances() throws IOException{
		
		ArrayList<String []> distanceArray = readFile("distances.csv");
		while (!distanceArray.isEmpty()){
			String[] currentDistance = distanceArray.remove(0);
			Distance dist = new Distance(currentDistance[0], currentDistance[1], Integer.parseInt(currentDistance[2]));
			distances.add(dist);
		}
		


	}


}
