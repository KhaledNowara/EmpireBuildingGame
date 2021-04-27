package engine;
import java.util.ArrayList;

import units.Army;

public class Player {

	private String name;
	private ArrayList<City> controlledCities;
	private	ArrayList<Army> contArmies;
	private double treasury;
	private double food;



	public Player(String name) {
		this.name = name;
	}

}
