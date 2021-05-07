package engine;

import java.io.IOException;
import java.util.ArrayList;
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
			
			String[] aV = readFile("archer.csv").get(level);
			String[] cV = readFile("cavalry.csv").get(level);
			String[] iV = readFile("infantary.csv").get(level);

			switch (currentUnit[0]){

				case "Archer" : units.add(new Archer(Integer.parseInt(aV[0]),Integer.parseInt(aV[1]),Double.parseDouble(aV[2]),Double.parseDouble(aV[3]),Double.parseDouble(aV[4])));
				break;
				case "Cavalry" : units.add(new Cavalry(Integer.parseInt(cV[0]),Integer.parseInt(cV[1]),Double.parseDouble(cV[2]),Double.parseDouble(cV[3]),Double.parseDouble(cV[4])));
				break;
				case "Infantry" : units.add(new Infantry(Integer.parseInt(iV[0]),Integer.parseInt(iV[1]),Double.parseDouble(iV[2]),Double.parseDouble(iV[3]),Double.parseDouble(iV[4])));
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


}
