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
	private int maxTurnCount;
	private int currentTurnCount;

	public Game(String playerName,String playerCity) throws IOException {
	  this.player = new Player(playerName);
	  maxTurnCount = 3;
	  currentTurnCount=0;

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
	}

	private void loadCitiesAndDistances() throws IOException{


	}


}
