package engine;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

public class Game {

	
	private Player player;
	private ArrayList<City> availabeCities;
	private ArrayList<Distance> distances;
	private int maxTurnCount;
	private int currentTurnCount;

	public Game(String playerName,String playerCity) throws IOException {
	  this.player = new Player(playerName);

	}

	public static void readFile(String path) throws IOException{
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
		
		// Parsing the currentLine String
		}
		br.close();
		}

	public void loadArmy(String cityName,String path) throws IOException{

	}

	private void loadCitiesAndDistances() throws IOException{

		
	}


}
